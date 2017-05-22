package  com.itour.exception;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import com.itour.base.collect.Mapx;
import com.itour.base.collect.Mapxs;
import com.itour.base.web.BaseController;
/**
 * spring_mvc 异常处理
 */
public class SpringMvcExceptionResolver extends SimpleMappingExceptionResolver implements HandlerExceptionResolver {

	// ==============================Fields===========================================
	protected final Logger logger = LoggerFactory.getLogger(getClass());

	// ==============================Methods==========================================
	/**
	 * 处理异常
	 */
	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
		logException(ex);
		if (isAjax(request)) {
			try {
				String message = ex.getMessage();
				if (message == null) {
					message = "Service Error !";
				}
				Mapx error = Mapxs.newMapx();
				error.put("successed", false);
				error.put("message", message);
				error.put("@failure", Boolean.TRUE);// failure|success
				response.setCharacterEncoding("utf-8");
				BaseController.write(error, response);
			} catch (Exception e) {
				//logger.error("!", ex);
			}
		} else {
			//Map<String, Object> map = Maps.newHashMap();
			//map.put("errorMsg", Throwables.getStackTraceAsString(ex));//将错误信息传递给view  
			//return new ModelAndView("error", map);
		}
		return new ModelAndView();
	}

	/**
	 * 判断是否AJAX请求
	 * @param request HTTP请求
	 * @return 如果是AJAX请求返回true,如果不是则返回false.
	 */
	private boolean isAjax(HttpServletRequest request) {
		String header = request.getHeader("X-Requested-With");
		return "XMLHttpRequest".equals(header) ? true : false;
	}

	/**
	 * 异常日志
	 * @param ex 异常
	 */
	protected void logException(Exception ex) {
		if (ex instanceof PromptException) {
			logger.error(ex.toString());
		} else {
			logger.error("!", ex);
		}
	}
}
