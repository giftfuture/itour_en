package com.itour.controller;

import java.sql.Timestamp;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itour.base.annotation.Auth;
import com.itour.base.easyui.DataGridAdapter;
import com.itour.base.util.IDGenerator;
import com.itour.base.util.SHA;
import com.itour.base.util.SystemVariable;
import com.itour.base.util.email.EmailService;
import com.itour.base.web.BaseController;
import com.itour.entity.SysUser;
import com.itour.service.SysUserService;
import com.itour.util.Constants;
import com.itour.vo.SysUserVO;

@Controller
@RequestMapping("/passEmail")
public class PassEmailController extends BaseController {
	protected final Logger logger =  LoggerFactory.getLogger(getClass());
	@SuppressWarnings("rawtypes")
	@Autowired
	private SysUserService userService;
	@Autowired
	private DataGridAdapter dataGridAdapter;
    private String sid;
    private String userName;
    
	@ResponseBody
    @SuppressWarnings("unchecked")
	@Auth(verifyLogin=true,verifyURL=true)
	@RequestMapping(value="/sendmail", method = RequestMethod.POST)
    public String sendmail(SysUserVO user, HttpServletRequest req,HttpServletResponse response) throws Exception{
        try {
        	int count = userService.getUserCountByEmail(user.getEmail());
        	if (count >= 1) {
                String secretKey = IDGenerator.getUUID(); // 密钥
                Timestamp expireDate = new Timestamp(System.currentTimeMillis() + 30 * 60 * 1000);// 30分钟后过期
                long date = expireDate.getTime() / (1000 * 1000);// 忽略毫秒数  mySql 取出时间是忽略毫秒数的
                //this.getUserHander().getUsersDAO().getHibernateTemplate().update(users); // 保存到数据库
                System.out.println("   UserName>>>> "+user.getEmail());
                String key =user.getEmail() + "$" + date + "$" + secretKey;
                System.out.println(" key>>>"+key);
                String digitalSignature = SHA.encodeByMAC(key);//Md5.md5(key);// 数字签名
                HashMap map = new HashMap();
                map.put("id", user.getId());
                map.put("expireDate", expireDate);
                map.put("validateCode", secretKey);
                userService.updateCode(map);
                String path = req.getContextPath();
                String basePath = req.getScheme() + "://"+ req.getServerName() + ":" + req.getServerPort() + path + "/";
                String resetPassHref = basePath + "checkLink?sid=" + digitalSignature +"&userName="+user.getEmail();
                String emailContent = "请勿回复本邮件.点击下面的链接,重设密码<br/><a href="
                    + resetPassHref + " target='_BLANK'>" + resetPassHref
                    + "</a>  或者    <a href=" + resetPassHref
                    + " target='_BLANK'>点击我重新设置密码</a>"
                    + "<br/>tips:本邮件超过30分钟,链接将会失效，需要重新申请'找回密码'" + key
                    + "\t" + digitalSignature;
                String subject="找回您的itour账户密码";
                String receivers = Constants.cache.get("receive_email");
                String sender = Constants.cache.get("sender_email");
                String pwd = Constants.cache.get("sender_pwd");
                String host = Constants.cache.get("sender_host");
                String port = Constants.cache.get("sender_port");
                String auth = Constants.cache.get("sender_auth");
                String ssl = Constants.cache.get("sender_ssl");
                String protocol = Constants.cache.get("sender_protocol");
                boolean iSend = EmailService.sendEmail(receivers, subject, emailContent, sender, pwd, host, port, auth, ssl, protocol,"");
                if(iSend){
                	req.setAttribute(MSG, "重置密码邮件已经发送，请登陆邮箱进行重置！");
                }
            } else {
            	req.setAttribute(MSG, "用户名不存在,你不会忘记邮箱了吧?");
                return "noUser";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

	/**
	 * 
	 * @param req
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@Auth(verifyLogin=true,verifyURL=true)
	@ResponseBody
  	@RequestMapping(value="/checkLink", method = RequestMethod.POST)
    public String checkResetLink(HttpServletRequest req,HttpServletResponse response) throws Exception {
        System.out.println("sid>>>" +sid);
        if (sid.equals("")  || userName.equals("")) {
            req.setAttribute(MSG, "链接不完整,请重新生成");
            System.out.println(">>>>> null");
            return "error";
        }
    	SysUser u = userService.getUserByEmail(userName);
    	if (u != null) {
            Timestamp expireDate =  (Timestamp) u.getExpireDate();
            System.out.println("outDate>>>"+expireDate);
             if(expireDate.getTime() <= System.currentTimeMillis()){ //表示已经过期
            	 req.setAttribute(MSG, "链接已经过期,请重新申请找回密码.");
                 System.out.println("时间 超时");
                 return "error";
             }
             
             String key = u.getEmail()+"$"+expireDate.getTime()/(1000*1000)+"$"+u.getValidateCode();//数字签名
            
             System.out.println("key link》》"+key);
             String digitalSignature =  SHA.encodeByMAC(key);// Md5.md5(key);// 数字签名
             
             System.out.println("digitalSignature>>>>"+digitalSignature);
              if(!digitalSignature.equals(sid)) {
                  req.setAttribute(MSG, "链接不正确,是否已经过期了?重新申请吧.");
                      System.out.println("标示不正确");
                    return "error";
              }else {
                //链接验证通过 转到修改密码页面
               req.setAttribute("user", u);
                return "success";
            }
        }else {
           req.setAttribute(MSG, "链接错误,无法找到匹配用户,请重新申请找回密码.");
            System.out.println("用户不存在");
            return "error";
        }
    	//  sun.misc.BASE64Encoder enc = new sun.misc.BASE64Encoder();
    	//  mailMessage.setSubject(MimeUtility.encodeText(mailInfo.getSubject(), "UTF-8", "B")); 
    }
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

  
 
}
