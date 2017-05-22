package com.itour.base.Filter;
import java.io.File;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.filter.CompositeFilter;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.filter.DelegatingFilterProxy;
import com.itour.base.util.FilePros;

import net.sf.morph.context.contexts.HttpServletContext;

public class FileCaptureFilter extends OncePerRequestFilter {
	
///	private FilterConfig filterConfig;
/*	@Override
	public void destroy() {
		
	}

	public void init(FilterConfig arg0) throws ServletException {
		this.filterConfig=arg0;
		menuUrl = arg0.getServletContext().get;
	}*/
	@Override
	protected void doFilterInternal(HttpServletRequest request,HttpServletResponse response,FilterChain chain) throws IOException, ServletException {
		try {
			String menuUrl = request.getRequestURI();
			String phycialPath = FilePros.basePath();
			String requesturi= request.getRequestURI();
			String contextPath = request.getContextPath();
			String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"/"; 
			String subpath = menuUrl.substring(0, menuUrl.lastIndexOf("/"));
			//String fileName = menuUrl.substring(menuUrl.lastIndexOf("/"))+".html";
			if(menuUrl.endsWith("main")||menuUrl.contains("detail")||menuUrl.contains("hiking/hiking")||menuUrl.contains("climb/climb")
				||menuUrl.contains("selfdrive/selfdrive")||menuUrl.contains("light/light")||menuUrl.contains("moredests")||menuUrl.contains("whyus")
				||menuUrl.contains("destination/related")||menuUrl.contains("showhappy/sharehappy")||menuUrl.contains("RandomCodeServlet")||menuUrl.contains("ImageServlet")){
				String dirc = phycialPath+subpath.replaceAll("/", "\\\\");
				File tempfile = new File(dirc);
				if(!tempfile.exists()){
					tempfile.mkdirs();
				}
				//String reffer = request.getHeader("referer");
				String newfile= phycialPath+menuUrl.replaceAll("/", "\\\\")+".html";
				File file = new File(newfile);
				 // 判断缓存文件是否存在或者是否重新设置了缓存内容
				if (!file.exists()) {// 如果缓存文件不存在
					//fileName=protDirPath+fileName;
					FileCaptureResponseWrapper responseWrapper = new FileCaptureResponseWrapper((HttpServletResponse)response);
		  			chain.doFilter(request, responseWrapper);
					//得到的html 页面结果字符串
					//String html = responseWrapper.toString();
		  			//String contextpath = request.getContextPath();
					// 写成html 文件
					responseWrapper.writeFile(newfile);
					// back to browser
					responseWrapper.writeResponse();
					}else{
					// 转发至缓存文件
				    String accesspath =  basePath+"itour/home"+request.getServletPath()+".html";
					//String accesspath =request.getServletPath()+"home"+StringUtils.replace(menuUrl, contextPath+"/", "")+".html";
					//request.getRequestDispatcher(accesspath).forward(request,response);
					response.sendRedirect(accesspath);
				}
			}else if(menuUrl.equals("/itour/")){
				String dirc = phycialPath+menuUrl.replaceAll("/", "\\\\");
				File tempfile = new File(dirc);
				if(!tempfile.exists()){
					tempfile.mkdirs();
				}
				//String reffer = request.getHeader("referer");
				String newfile= phycialPath+"\\itour\\home.html";
				File file = new File(newfile);
				 // 判断缓存文件是否存在或者是否重新设置了缓存内容
				if (!file.exists()) {// 如果缓存文件不存在
						//fileName=protDirPath+fileName;
						FileCaptureResponseWrapper responseWrapper = new FileCaptureResponseWrapper((HttpServletResponse)response);
			  			chain.doFilter(request, responseWrapper);
						//得到的html 页面结果字符串
						//String html = responseWrapper.toString();
						// 写成html 文件
						responseWrapper.writeFile(newfile);
						// back to browser
						responseWrapper.writeResponse();
					}else{
						// 转发至缓存文件
						String accesspath = "home/home.html";
						/*ServletContext context2 =  request.getServletContext().getContext("/itourhome");
						RequestDispatcher requestDispatcher;
						requestDispatcher = context2.getRequestDispatcher("home.html");
						requestDispatcher.forward(request,response);*/
						//RequestDispatcher requestDispatcher = request.getRequestDispatcher(accesspath);
						//requestDispatcher.forward(request,response);
						response.sendRedirect(accesspath);
				}
			}else{
				//response.sendRedirect(arg0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
