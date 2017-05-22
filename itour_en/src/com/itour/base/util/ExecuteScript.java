package com.itour.base.util;


import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.servlet.http.HttpServletRequest;

public class ExecuteScript {
	public static String exeScript(String divId,String html,HttpServletRequest request){
		   String jspath = "D:\\projects\\itour\\WebContent\\js\\ux\\front\\trek\\hiking.js";
		   ScriptEngineManager manager = new ScriptEngineManager();
		    ScriptEngine engine = manager.getEngineByName("js");
		   // Invocable invocableEngine = (Invocable)engine;
		    String callbackvalue = "";
		    try {
		    	File file = new File(jspath);
		    	FileInputStream fileInputStream = new FileInputStream(file.getAbsolutePath().replaceAll("\\\\", "/"));  
		    	Reader reader = new InputStreamReader(fileInputStream,"utf-8");
		    		engine.eval(reader);
			    	if(engine instanceof Invocable){
				    	Invocable invoke = (Invocable) engine;
				    	callbackvalue=(String)invoke.invokeFunction("itour.hiking.replaceInput", html);
				    	System.out.println(callbackvalue);
			    	}
		    		reader.close();
		     } catch (ScriptException e) {
		    	 e.printStackTrace();
		     } catch (NoSuchMethodException e) {
		    	 e.printStackTrace();
		     }catch (Exception e) {
		    	 e.printStackTrace();
		    }
		    return callbackvalue;
	}
	public static String exeScript(String divId,String html){
		    ScriptEngineManager manager = new ScriptEngineManager();
		    ScriptEngine engine = manager.getEngineByName("js");
		    Invocable invocableEngine = (Invocable)engine;
		    String callbackvalue = "";
		    try {
		     //调用有参数JAVASCRIPT函数
		      engine.eval("function replaceInput(html){"+
		    	" var div = document.createElement('div');"+	  
    		    "div.innerHTML=html;"+
				"var olist = div.getElementsByTagName('input');"+
			   " for(var i=0;i<olist.length;i++){"+
			    "    var obj = document.createElement('span');"+
			    "    obj.innerText = olist[i].value;"+
			     "   olist[i].parentNode.replaceChild(obj,olist[i]);"+
			    "}"+
			   " console.log(html);"+
			"return html;}");
		     callbackvalue=(String)invocableEngine.invokeFunction("replaceInput", html);
		    System.out.println(callbackvalue);
		      // FileReader的参数为所要执行的js文件的路径
		   /*   engine.eval(new FileReader(path + "JavaScriptMethods.js"));
		      if (engine instanceof Invocable) {
		        Invocable invocable = (Invocable) engine;
		      //  Methods executeMethod = (Methods) invocable.getInterface(Methods.class);
		      //  System.out.println(executeMethod.execute("li", "yuncong"));
		      }*/
		     } catch (ScriptException e) {
		    	 e.printStackTrace();
		     } catch (NoSuchMethodException e) {
		    	 e.printStackTrace();
		     }catch (Exception e) {
		    	 e.printStackTrace();
		    }
		    return callbackvalue;
	}
	public static void main(String[] args) {
	//	System.out.println(ExecuteScript.class.getResource("/"));
		System.out.println( System.getProperty("user.dir")+"\\WebContent\\js\\ux\\front\\trek\\hiking.js");
		 String path = ExecuteScript.class.getResource("").getPath();
	      System.out.println(path);
	}
}
