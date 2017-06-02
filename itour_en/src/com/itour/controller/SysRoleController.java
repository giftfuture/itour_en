package com.itour.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.collect.Maps;
import com.itour.base.annotation.Auth;
import com.itour.base.collect.Mapxs;
import com.itour.base.easyui.DataGridAdapter;
import com.itour.base.easyui.EasyUIGrid;
import com.itour.base.json.JsonUtils;
import com.itour.base.page.BasePage;
import com.itour.base.util.HtmlUtil;
import com.itour.base.util.SessionUtils;
import com.itour.base.web.BaseController;
import com.itour.entity.LogOperation;
import com.itour.entity.LogSetting;
import com.itour.entity.SysMenu;
import com.itour.entity.SysRole;
import com.itour.entity.SysRoleRel;
import com.itour.entity.SysRoleRel.RelType;
import com.itour.entity.SysUser;
import com.itour.service.LogOperationService;
import com.itour.service.LogSettingDetailService;
import com.itour.service.LogSettingService;
import com.itour.service.SysMenuService;
import com.itour.service.SysRoleRelService;
import com.itour.service.SysRoleService;
import com.itour.vo.SysRoleVO;
 
@Controller
@RequestMapping("/sysRole") 
public class SysRoleController extends BaseController{
	
	protected final Logger logger =  LoggerFactory.getLogger(getClass());
	@Autowired 
	private SysRoleService<SysRole> sysRoleService; 
	@Autowired
	private SysMenuService<SysMenu> sysMenuService; 
	@Autowired
	private SysRoleRelService<SysRoleRel> sysRoleRelService;
	@Autowired
	private DataGridAdapter dataGridAdapter;
	@Autowired
	private LogSettingService logSettingService;
	
	@Autowired
	private LogSettingDetailService logSettingDetailService;
	
	@Autowired
	private LogOperationService logOperationService;
	
	/**
	 * 
	 * @param url
	 * @param classifyId
	 * @return
	 * @throws Exception 
	 */
	@Auth(verifyLogin=true,verifyURL=true)
	@RequestMapping(value="/role")
	public ModelAndView role(SysRoleVO model,HttpServletRequest request) throws Exception{
		SysUser sessionuser = SessionUtils.getUser(request);
		logger.info("#####"+(sessionuser != null?("id:"+sessionuser .getId()+"email:"+sessionuser.getEmail()+",nickName:"+sessionuser.getNickName()):"")+"调用执行SysRoleController的role方法");
		return forward("server/sys/sysRole"); 
	}
	
	
	/**
	 * @param url
	 * @param classifyId
	 * @return 
	 * @return
	 * @throws Exception 
	 */
	@Auth(verifyLogin=true,verifyURL=true)
	@ResponseBody
	@RequestMapping(value="/dataList.json", method = RequestMethod.POST) 
	public EasyUIGrid datalist(SysRoleVO vo,HttpServletRequest request,HttpServletResponse response) throws Exception{
		//response.setContentType("application/json; charset=UTF-8");
		BasePage<SysRoleVO> pagination = sysRoleService.pagedQuery(vo);
		SysUser sessionuser = SessionUtils.getUser(request);
		logger.info("#####"+(sessionuser != null?("id:"+sessionuser .getId()+"email:"+sessionuser.getEmail()+",nickName:"+sessionuser.getNickName()):"")+"调用执行SysRoleController的dataList方法");
		return dataGridAdapter.wrap(pagination); 
	}
	
	/**
	 * 添加或修改数据
	 * @param url
	 * @param classifyId
	 * @return
	 * @throws Exception 
	 */
	@SuppressWarnings("unchecked")
	@Auth(verifyLogin=true,verifyURL=true)
	@ResponseBody
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public Object save(SysRole bean,String[] menuIds,String[] btnIds,HttpServletRequest request,HttpServletResponse response) throws Exception{
		SysRole sr = null;
		String srId = "";
		SysUser sessionuser = SessionUtils.getUser(request);
		if(StringUtils.isNotEmpty(bean.getId())){
			sr = sysRoleService.queryById(bean.getId());
			if(sr == null){
				bean.setCreateBy(sessionuser.getId());
				bean.setUpdateBy(sessionuser.getId());
				srId = sysRoleService.add(bean,menuIds,btnIds,sessionuser.getId());
			}else{
				bean.setUpdateBy(sessionuser.getId());
				sysRoleService.update(bean,menuIds,btnIds,sessionuser.getId());
			}
		}else{
			bean.setCreateBy(sessionuser.getId());
			bean.setUpdateBy(sessionuser.getId());
			sysRoleService.add(bean,menuIds,btnIds,sessionuser.getId());
		}
		Map<String,Object> result = getRootMap();
		//sendSuccessMessage(response, "保存成功~");
		result.put(SUCCESS, true);
		result.put(MSG, "角色保存成功！");
		logger.info("#####"+(sessionuser != null?("id:"+sessionuser .getId()+"email:"+sessionuser.getEmail()+",nickName:"+sessionuser.getNickName()):"")+"调用执行SysRoleController的save方法");
		Map<String,Object> map = Maps.newHashMap();
		map.put("sysRole",bean);
		map.put("menuIds", menuIds);
		map.put("btnIds", btnIds);
		if(StringUtils.isNotEmpty(srId)){			
			String logid = logSettingService.add(new LogSetting("sys_role","角色管理","sysRole/save",sessionuser.getId(),"",""));
			logOperationService.add(new LogOperation(logid,"新增",srId,JsonUtils.encode(map),"","sysRole/save",sessionuser.getId()));
		}else{
			String logid = logSettingService.add(new LogSetting("sys_role","角色管理","sysRole/save(update)",sessionuser.getId(),"",""));
			logOperationService.add(new LogOperation(logid,"更新",bean!= null?bean.getId():"",JsonUtils.encode(sr),JsonUtils.encode(map),"sysRole/save(update)",sessionuser.getId()));
		}
		return result;
	}
	/**
	 * @param id
	 * @param response
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@Auth(verifyLogin=true,verifyURL=true)
	@ResponseBody
	@RequestMapping(value="/getId", method = RequestMethod.POST)
	public String getId(String id,HttpServletRequest request,HttpServletResponse response) throws Exception{
		Map<String,Object> context = getRootMap();
		SysRole bean  = sysRoleService.queryById(id);
		if(bean  == null){
			return sendFailureResult(response, "没有找到对应的记录!");
		}
		//获取权限关联的菜单
		String[] menuIds = null;
		List<SysMenu> menuList =  sysMenuService.getMenuByRoleId(id);
		if(menuList != null){
			menuIds = new String[menuList.size()];
			int i = 0;
			for(SysMenu item : menuList){
				menuIds[i] = item.getId();
				i++;
			}
		}
		//获取权限下关联的按钮
		String[] btnIds = null;
		List<SysRoleRel>  btnList =sysRoleRelService.queryByRoleId(id, RelType.BTN.key);
		if(btnList != null){
			btnIds = new String[btnList.size()];
			int i = 0;
			for(SysRoleRel item : btnList){
				btnIds[i] = item.getObjId();
				i++;
			}
		}
		//将对象转成Map
		Map<String,Object> data = BeanUtils.describe(bean);
		data.put("menuIds", menuIds);
		data.put("btnIds", btnIds);
		context.put("data",data);
		context.put(SUCCESS, true);
		SysUser sessionuser = SessionUtils.getUser(request);
		logger.info("#####"+(sessionuser != null?("id:"+sessionuser .getId()+"email:"+sessionuser.getEmail()+",nickName:"+sessionuser.getNickName()):"")+"调用执行SysRoleController的getId方法");
		String logId = logSettingService.add(new LogSetting("sys_role","角色管理","sysRole/getId",sessionuser.getId(),"",""));//String tableName,String function,String urlTeimplate,String creater,String deletescriptTemplate,String updatescriptTemplate
		logOperationService.add(new LogOperation(logId,"查看",bean.getId(),JsonUtils.encode(data),"","sysRole/getId",sessionuser.getId()));//String logCode,String operationType,String primaryKeyvalue,String content,String url,String creater
		return JsonUtils.encode(context);
	}
	
	/**
	 * 
	 * @param id
	 * @param response
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@Auth(verifyLogin=true,verifyURL=true)
	@ResponseBody
	@RequestMapping(value="/delete", method = RequestMethod.POST)
	public String delete(String[] id,HttpServletRequest request,HttpServletResponse response) throws Exception{
		sysRoleService.delete(id);
		SysUser sessionuser = SessionUtils.getUser(request);
		logger.info("#####"+(sessionuser != null?("id:"+sessionuser .getId()+"email:"+sessionuser.getEmail()+",nickName:"+sessionuser.getNickName()):"")+"调用执行SysRoleController的delete方法");
		String logId = logSettingService.add(new LogSetting("sys_role","角色管理","sysRole/delete",sessionuser.getId(),"delete from sys_role where id in("+JsonUtils.encode(id)+")",""));//String tableName,String function,String urlTeimplate,String creater,String deletescriptTemplate,String updatescriptTemplate
		logOperationService.add(new LogOperation(logId,"物理删除",JsonUtils.encode(id),JsonUtils.encode(id),JsonUtils.encode(id),"sysRole/delete",sessionuser.getId()));//String logCode,String operationType,String primaryKeyvalue,String content,String url,String creater
		return removeSuccessMessage(response);
	}
	/**
	 * 
	 * @param id
	 * @param response
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@Auth(verifyLogin=true,verifyURL=true)
	@ResponseBody
	@RequestMapping(value="/logicdelete", method = RequestMethod.POST)
	public String logicdelete(String[] id,HttpServletRequest request,HttpServletResponse response) throws Exception{
		sysRoleService.logicdelete(id);
		SysUser sessionuser = SessionUtils.getUser(request);
		logger.info("#####"+(sessionuser != null?("id:"+sessionuser .getId()+"email:"+sessionuser.getEmail()+",nickName:"+sessionuser.getNickName()):"")+"调用执行SysRoleController的logicdelete方法");
		String logId = logSettingService.add(new LogSetting("sys_role","角色管理","sysRole/logicdelete",sessionuser.getId(),"update sys_role set deleted=1 where id in("+JsonUtils.encode(id)+")",""));//String tableName,String function,String urlTeimplate,String creater,String deletescriptTemplate,String updatescriptTemplate
		logOperationService.add(new LogOperation(logId,"逻辑删除",JsonUtils.encode(id),JsonUtils.encode(id),JsonUtils.encode(id),"sysRole/logicdelete",sessionuser.getId()));//String logCode,String operationType,String primaryKeyvalue,String content,String url,String creater
		return removeSuccessMessage(response);
	}
	/**
	 * 
	 * @param response
	 * @throws Exception
	 */
	@Auth(verifyLogin=true,verifyURL=true)
	@ResponseBody
	@RequestMapping(value="/loadRoleList", method = RequestMethod.POST)
	public void loadRoleList(HttpServletRequest request,HttpServletResponse response) throws Exception{
		List<SysRole>  roloList = sysRoleService.queryAllList();
		SysUser sessionuser = SessionUtils.getUser(request);
		logger.info("#####"+(sessionuser != null?("id:"+sessionuser .getId()+"email:"+sessionuser.getEmail()+",nickName:"+sessionuser.getNickName()):"")+"调用执行SysRoleController的loadRoleList方法");
		HtmlUtil.writerJson(response, roloList);
	}


	
	
}
