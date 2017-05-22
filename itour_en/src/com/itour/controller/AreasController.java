
package com.itour.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.collect.Lists;
import com.itour.base.annotation.Auth;
import com.itour.base.cache.CacheService;
import com.itour.base.json.JsonUtils;
import com.itour.base.util.SessionUtils;
import com.itour.base.web.BaseController;
import com.itour.entity.Areas;
import com.itour.entity.SysUser;
import com.itour.service.AreasService;
import com.itour.util.Constants;
@Controller
@RequestMapping("/areas") 
public class AreasController extends BaseController {
	
	protected final Logger logger =  LoggerFactory.getLogger(getClass());
    @Autowired(required=false)
    private CacheService cacheService;
	@Autowired
	private AreasService areasService ;
	
	@ResponseBody
	@RequestMapping(value="/allAreas", method = RequestMethod.GET)
	public List<Areas> allAreas(HttpServletRequest request,HttpServletResponse response) throws Exception{
		//Map<String,Object> root = getRootMap();
		List<Areas> allAreas = Lists.newArrayList();
		allAreas.add(new Areas("","--请选择--"));
		allAreas.addAll(Constants.allAreas);
		if(allAreas.size() <=1){
			Constants.allAreas.addAll(areasService.allAreas());
			allAreas.addAll(Constants.allAreas);
		}
		//root.put("allAreas", allAreas);
		//String result = JsonUtils.encode(root);
		SysUser user = SessionUtils.getUser(request);
		logger.info("#####"+(user!= null?("id:"+user.getId()+"email:"+user.getEmail()+",nickName:"+user.getNickName()):"")+"调用执行AreasController的allAreas方法");
		return allAreas;
	}
	
}
