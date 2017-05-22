package com.itour.servlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.IOUtils; 
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import com.itour.base.util.FilePros;


/**
 * Servlet implementation class Counter
 */
@WebServlet("/Counter")
public final class Counter extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Autowired
    private ResourceLoader resourceLoader;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Counter() {
        super();
    }

    /**
     * 
     * @param filename
     * @param count
     */
    public void writeCount(String count){  
    	/*Resource resource = resourceLoader.getResource("/WEB-INF/classes/conf.properties");
    	//String path = getServletContext().getRealPath("/WEB-INF/")+"classes/conf.properties";
    	try {
			IOUtils.toString(resource.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}*/
    	FilePros.updateProperties("counter", count);
    }  
    /**
     *   
     * @param filename
     * @return
     */
    public int readCount() {
    	try {
    		//String path = this.getServletContext().getRealPath("/WEB-INF/")+"classes/conf.properties";
    		String count = FilePros.read("counter");
    		//System.out.println("###count="+count);
    		return Integer.parseInt(count);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return 0;
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
