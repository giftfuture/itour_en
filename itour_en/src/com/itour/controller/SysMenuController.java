package com.itour.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.collect.Lists;
import com.itour.base.annotation.Auth;
import com.itour.base.easyui.DataGridAdapter;
import com.itour.base.easyui.EasyUIGrid;
import com.itour.base.entity.BaseEntity.DELETED;
import com.itour.base.json.JsonUtils;
import com.itour.base.entity.TreeNode;
import com.itour.base.page.BasePage;
import com.itour.base.util.HtmlUtil;
import com.itour.base.util.SessionUtils;
import com.itour.base.util.TreeUtil;
import com.itour.base.web.BaseController;
import com.itour.entity.LogOperation;
import com.itour.entity.LogSetting;
import com.itour.entity.SysMenu;
import com.itour.entity.SysMenuBtn;
import com.itour.entity.SysUser;
import com.itour.service.LogOperationService;
import com.itour.service.LogSettingDetailService;
import com.itour.service.LogSettingService;
import com.itour.service.SysMenuBtnService;
import com.itour.service.SysMenuService;
import com.itour.vo.SysMenuVo;
 
@Controller
@RequestMapping("/sysMenu") 
public class SysMenuController extends BaseController{
	
	protected final Logger logger =  LoggerFactory.getLogger(getClass());
	
	// Servrice start
	@Autowired //自动注入，不需要生成set方法了，required=false表示没有实现类，也不会报错。
	private SysMenuService<SysMenu> sysMenuService; 
	
	@Autowired
	private SysMenuBtnService<SysMenuBtn> sysMenuBtnService;
	
	@Autowired
	private DataGridAdapter dataGridAdapter;
	@Autowired
	private LogSettingService logSettingService;
	
	@Autowired
	private LogSettingDetailService logSettingDetailService;
	
	@Autowired
	private LogOperationService logOperationService;
	/**
	 * @param url
	 * @param classifyId
	 * @return
	 */
	@Auth(verifyLogin=true,verifyURL=true)
	@ResponseBody
	@RequestMapping(value="/menu")
	public ModelAndView menu(SysMenuVo model,HttpServletRequest request) throws Exception{
	//	Map<String,Object>  context = getRootMap();
	//	model.setDeleted(DELETED.NO.key);
	//	List<SysMenu> dataList = sysMenuService.queryByList(model);
		//设置页面数据
	//	context.put("dataList", dataList);
		SysUser sessionuser = SessionUtils.getUser(request);
		logger.info("#####"+(sessionuser != null?("id:"+sessionuser .getId()+"email:"+sessionuser.getEmail()+",nickName:"+sessionuser.getNickName()):"")+"调用执行SysMenuController的menu方法");
		return forward("server/sys/sysMenu"); 
	}
	
	/**
	 * json 列表页面
	 * @param url
	 * @param classifyId
	 * @return
	 * @throws Exception 
	 */
	@Auth(verifyLogin=true,verifyURL=true)
	@ResponseBody
	@RequestMapping(value="/dataList.json", method = RequestMethod.POST) 
	public EasyUIGrid dataList(SysMenuVo vo,HttpServletRequest request,HttpServletResponse response) throws Exception{
		//List<SysMenu> dataList = sysMenuService.queryByList(vo);
		//dataGridAdapter.getPagination();
		BasePage<Map<String, Object>> pagination = sysMenuService.pagedQuery(vo);
		SysUser sessionuser = SessionUtils.getUser(request);
		logger.info("#####"+(sessionuser != null?("id:"+sessionuser .getId()+"email:"+sessionuser.getEmail()+",nickName:"+sessionuser.getNickName()):"")+"调用执行SysMenuController的dataList方法");
		return dataGridAdapter.wrap(pagination); 
		//设置页面数据
		//Map<String,Object> jsonMap = new HashMap<String,Object>();
		//jsonMap.put("total",model.getPager().getRowCount());
		//jsonMap.put("rows", dataList);
	//	System.out.println(JSON.toJSONString(dataList));
		//HtmlUtil.writerJson(response, jsonMap);
	}
	
	/**
	 * 顶级菜单 json 
	 * @param menuId 此菜单id不查询，可以为空
	 * @param response
	 * @throws Exception
	 */
	@Auth(verifyLogin=true,verifyURL=true)
	@ResponseBody
	@RequestMapping(value="/rootMenuJson", method = RequestMethod.POST) 
	public void  rootMenu(String menuId,HttpServletRequest request,HttpServletResponse response) throws Exception{
		List<SysMenu> dataList = sysMenuService.getRootMenu(menuId);
		if(dataList==null){
			dataList = Lists.newArrayList();
		}
		SysUser sessionuser = SessionUtils.getUser(request);
		logger.info("#####"+(sessionuser != null?("id:"+sessionuser .getId()+"email:"+sessionuser.getEmail()+",nickName:"+sessionuser.getNickName()):"")+"调用执行SysMenuController的rootMenuJson方法");
		HtmlUtil.writerJson(response, dataList);
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
	public String save(SysMenu bean,HttpServletRequest request,HttpServletResponse response) throws Exception{
		SysUser user = SessionUtils.getUser(request);
		String id = "";
		//设置菜单按钮数据
		List<SysMenuBtn> btns = getReqBtns(request);
		bean.setBtns(btns);
		int rank = sysMenuService.maxRank();
		bean.setRank(rank);
		SysMenu sm  = sysMenuService.queryById(bean.getId());
		if(StringUtils.isEmpty(sm.getId())){
			if(user != null){
				bean.setCreateBy(user.getId());
				bean.setUpdateBy(user.getId());
			}
			bean.setDeleted(DELETED.NO.key);
			id = sysMenuService.add(bean);
		}else{
			//SysMenu sm = sysMenuService.queryById(bean.getId());
		/*	if(sm == null){
				if(user != null){
					bean.setCreateBy(user.getId());
					bean.setUpdateBy(user.getId());
				}
				bean.setDeleted(DELETED.NO.key);
				sysMenuService.add(bean);
			}else{*/
				if(user != null){
					bean.setUpdateBy(user.getId());
				}
				sysMenuService.update(bean);
			//}
		}
		logger.info("#####"+(user != null?("id:"+user .getId()+"email:"+user.getEmail()+",nickName:"+user.getNickName()):"")+"调用执行SysMenuController的save方法");
		if(StringUtils.isNotEmpty(id)){			
			String logid = logSettingService.add(new LogSetting("sys_menu","菜单管理","sysMenu/save",user.getId(),"",""));
			logOperationService.add(new LogOperation(logid,"新增",id,JsonUtils.encode(bean),"","sysMenu/save",user.getId()));
		}else{
			String logid = logSettingService.add(new LogSetting("sys_menu","菜单管理","sysMenu/save(update)",user.getId(),"",""));
			logOperationService.add(new LogOperation(logid,"更新",bean!= null?bean.getId():"",JsonUtils.encode(sm),JsonUtils.encode(bean),"sysMenu/save(update)",user.getId()));
		}
		return sendSuccessResult(response, "保存成功~");
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
	@RequestMapping(value="/getId", method = RequestMethod.POST)
	public String getId(@RequestParam(value="", defaultValue = StringUtils.EMPTY) String id,HttpServletRequest request,HttpServletResponse response) throws Exception{
		Map<String,Object>  context = getRootMap();
		SysMenu bean = sysMenuService.queryById(id);
		if(bean  == null){
			return sendFailureResult(response, "没有找到对应的记录!");
		}
		List<SysMenuBtn> btns = sysMenuBtnService.queryByMenuid(id);
		bean.setBtns(btns);
		context.put(SUCCESS, true);
		context.put("data", bean);
		SysUser sessionuser = SessionUtils.getUser(request);
		logger.info("#####"+(sessionuser != null?("id:"+sessionuser .getId()+"email:"+sessionuser.getEmail()+",nickName:"+sessionuser.getNickName()):"")+"调用执行SysMenuController的getId方法");
		String logId = logSettingService.add(new LogSetting("sys_menu","菜单管理","sysMenu/getId",sessionuser.getId(),"",""));//String tableName,String function,String urlTeimplate,String creater,String deletescriptTemplate,String updatescriptTemplate
		logOperationService.add(new LogOperation(logId,"查看",bean.getId(),JsonUtils.encode(bean),"","sysMenu/getId",sessionuser.getId()));//String logCode,String operationType,String primaryKeyvalue,String content,String url,String creater
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
		if(id != null && id.length > 0){
			sysMenuService.delete(id);
			sendSuccessMessage(response, "删除成功");
		}else{
			sendFailureMessage(response, "未选中记录");
		}
		SysUser sessionuser = SessionUtils.getUser(request);
		logger.info("#####"+(sessionuser != null?("id:"+sessionuser .getId()+"email:"+sessionuser.getEmail()+",nickName:"+sessionuser.getNickName()):"")+"调用执行SysMenuController的delete方法");
		String logId = logSettingService.add(new LogSetting("sys_menu","菜单管理","sysMenu/delete",sessionuser.getId(),"delete from sys_menu where id in("+JsonUtils.encode(id)+")",""));//String tableName,String function,String urlTeimplate,String creater,String deletescriptTemplate,String updatescriptTemplate
		logOperationService.add(new LogOperation(logId,"物理删除",JsonUtils.encode(id),JsonUtils.encode(id),JsonUtils.encode(id),"sysMenu/delete",sessionuser.getId()));//String logCode,String operationType,String primaryKeyvalue,String content,String url,String creater
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
		if(id != null && id.length > 0){
			sysMenuService.logicdelete(id);
			sendSuccessMessage(response, "删除成功");
		}else{
			sendFailureMessage(response, "未选中记录");
		}
		SysUser sessionuser = SessionUtils.getUser(request);
		String logId = logSettingService.add(new LogSetting("sys_menu","菜单管理","sysMenu/logicdelete",sessionuser.getId(),"update sys_menu set deleted=1 where id in("+JsonUtils.encode(id)+")",""));//String tableName,String function,String urlTeimplate,String creater,String deletescriptTemplate,String updatescriptTemplate
		logOperationService.add(new LogOperation(logId,"逻辑删除",JsonUtils.encode(id),JsonUtils.encode(id),JsonUtils.encode(id),"sysMenu/logicdelete",sessionuser.getId()));//String logCode,String operationType,String primaryKeyvalue,String content,String url,String creater
		logger.info("#####"+(sessionuser != null?("id:"+sessionuser .getId()+"email:"+sessionuser.getEmail()+",nickName:"+sessionuser.getNickName()):"")+"调用执行SysMenuController的logicdelete方法");
		return removeSuccessMessage(response);
	}
	/**
	 * 
	 * @param id
	 * @param response
	 * @throws Exception
	 */
	@Auth(verifyLogin=true,verifyURL=true)
	@ResponseBody
	@RequestMapping(value="/getMenuTree", method = RequestMethod.POST)
	public void getMenuTree(Integer id,HttpServletRequest request,HttpServletResponse response) throws Exception{
		List<TreeNode> menuTree = treeMenu();
		SysUser sessionuser = SessionUtils.getUser(request);
		logger.info("#####"+(sessionuser != null?("id:"+sessionuser .getId()+"email:"+sessionuser.getEmail()+",nickName:"+sessionuser.getNickName()):"")+"调用执行SysMenuController的getMenuTree方法");
		HtmlUtil.writerJson(response, menuTree);
	}
	
	/**
	 * 构建树形菜单
	 * @return
	 */
	public List<TreeNode> treeMenu(){
		List<SysMenu> rootMenus = sysMenuService.getRootMenu(null);//根节点
		List<SysMenu> childMenus = sysMenuService.getChildMenu(null);//子节点
		List<SysMenuBtn> childBtns = sysMenuBtnService.queryByAll();
		TreeUtil util = new TreeUtil(rootMenus,childMenus,childBtns);
		return util.getTreeNode();
	}
	
	/**
	 * 获取请求的菜单按钮数据
	 * @param request
	 * @return
	 */
	public List<SysMenuBtn> getReqBtns(HttpServletRequest request){
		SysUser user = SessionUtils.getUser(request);
		List<SysMenuBtn> btnList= new ArrayList<SysMenuBtn>();
		String[] btnId  = request.getParameterValues("btnId");
		String[] btnName  = request.getParameterValues("btnName");
		String[] btnType  = request.getParameterValues("btnType");
		String[] actionUrls  = request.getParameterValues("actionUrls");
		String[] deleteFlag  = request.getParameterValues("deleteFlag");
		if(btnId  == null || btnId.length < 1){
			return null;
		}
		
		for (int i = 0; i < btnId.length; i++) {
			if(StringUtils.isNotBlank(btnName[i]) && StringUtils.isNotBlank(btnType[i])){
				SysMenuBtn btn = new SysMenuBtn();
				if(StringUtils.isNotBlank(btnId[i]) && NumberUtils.isNumber(btnId[i])){
					//btn.setId(NumberUtils.toInt(btnId[i]));
					btn.setId(btnId[i]);
				}
				//sysMenuBtnService.queryById(id)
				btn.setBtnName(btnName[i]);
				btn.setBtnType(btnType[i]);
				btn.setActionUrls(actionUrls[i]);
				btn.setDeleteFlag(deleteFlag[i]);
				if(user != null){					
					//btn.setCreateBy(user.getId());
					btn.setUpdateBy(user.getId());
				}
				btnList.add(btn);
			}
		}
		return btnList;
	}
}
