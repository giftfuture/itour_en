package com.itour.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.JsonEncoding;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.itour.base.annotation.Auth;
import com.itour.base.easyui.DataGridAdapter;
import com.itour.base.util.State;
import com.itour.exception.NoSupportExtensionException;
  

public class ExceptionHandler implements HandlerExceptionResolver, Ordered {

	protected final Logger logger =  LoggerFactory.getLogger(getClass());
	
	@Autowired
	private DataGridAdapter dataGridAdapter;
	@Override  
    public int getOrder() {  
        return Integer.MIN_VALUE;  
    }  
	
	@Auth(verifyLogin=true,verifyURL=true)
	@ResponseBody
	@Override
	@RequestMapping("/reslove")
    public ModelAndView resolveException(HttpServletRequest request,HttpServletResponse response, Object handler, Exception ex) {  
        logger.info("ExceptionHandler#resolveException() start");  
        Map<String, Object> errorMap = null;  
        if(ex instanceof NoSupportExtensionException) {  
            errorMap = State.NO_SUPPORT_EXTENSION.toMap();  
        } else if(ex instanceof MaxUploadSizeExceededException){ //spring 中对apache common组件中抛出的FileSizeLimitExceededException做了转换  
            errorMap = State.OVER_FILE_LIMIT.toMap();  
        } else {  
            errorMap = State.ERROR.toMap();  
        }  
        //这里牵扯到spring mvc的异常处理,这里暂时做一个简单处理,不做深究  
        try {  
            ObjectMapper objectMapper = new ObjectMapper();  
            response.setContentType("text/html;charset=UTF-8");  
            JsonGenerator jsonGenerator = objectMapper.getJsonFactory().createJsonGenerator(response.getOutputStream(), JsonEncoding.UTF8);  
            objectMapper.writeValue(jsonGenerator, errorMap);  
        } catch(Exception e) {  
            logger.error(e.getMessage(), e);  
        }  
        logger.info("ExceptionHandler#resolveException() end");  
        return null;  
    }  
}
