package com.itour.base.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.w3c.tidy.Tidy;
import org.xhtmlrenderer.pdf.ITextFontResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

public class HtmlToPdf {
	
	
	 //wkhtmltopdf在系统中的路径  
    private static final String toPdfTool = "D:\\Program Files\\wkhtmltopdf\\bin\\wkhtmltopdf.exe";  
      
    /** 
     * html转pdf 
     * @param srcPath html路径，可以是硬盘上的路径，也可以是网络路径 
     * @param destPath pdf保存路径 
     * @return 转换成功返回true 
     */  
    public static boolean convert(String srcPath, String destPath){  
        File file = new File(destPath);  
        File parent = file.getParentFile();  
        //如果pdf保存路径不存在，则创建路径  
        if(!parent.exists()){  
            parent.mkdirs();  
        }  
          
        StringBuilder cmd = new StringBuilder();  
        cmd.append(toPdfTool);  
        cmd.append(" ");  
        cmd.append(srcPath);  
        cmd.append(" ");  
        cmd.append(destPath);  
          
        boolean result = true;  
        try{  
            Process proc = Runtime.getRuntime().exec(cmd.toString());  
            HtmlToPdfInterceptor error = new HtmlToPdfInterceptor(proc.getErrorStream());  
            HtmlToPdfInterceptor output = new HtmlToPdfInterceptor(proc.getInputStream());  
            error.start();  
            output.start();  
            proc.waitFor();  
        }catch(Exception e){  
            result = false;  
            e.printStackTrace();  
        }  
          
        return result;  
    }  
    public static String parseXhtml(String f_in){
        ByteArrayInputStream stream = new ByteArrayInputStream(f_in.getBytes());
        ByteArrayOutputStream  tidyOutStream = new ByteArrayOutputStream();
        //实例化Tidy对象
        Tidy tidy = new Tidy();
        //设置输入
        tidy.setInputEncoding("utf8");
        //如果是true  不输出注释，警告和错误信息
        tidy.setQuiet(true);
        //设置输出
        tidy.setOutputEncoding("utf8");
      //不显示警告信息
        tidy.setShowWarnings(false);
        //缩进适当的标签内容。
        tidy.setIndentContent(true);
        //内容缩进
        tidy.setSmartIndent(true);
        tidy.setIndentAttributes(false);
        //只输出body内部的内容
        tidy.setPrintBodyOnly(true);
        //多长换行
        tidy.setWraplen(1024);
        //输出为xhtml
        tidy.setXHTML(true);
        //去掉没用的标签
        tidy.setMakeClean(true);
        //清洗word2000的内容
        tidy.setWord2000(true);
        //设置错误输出信息
        tidy.setErrout(new PrintWriter(System.out));
        tidy.parse(stream, tidyOutStream);
        return tidyOutStream.toString();
    }
    
    public static void main(String[] args) {
    	try {
			String orderpdfs = FilePros.orderpdfs();
			String orderhtmls = FilePros.orderhtmls();
			HtmlToPdf.convert(orderhtmls+"aaa.html", orderpdfs+"aaa.pdf");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 
	 * @param inputFile
	 * @param outputFile
	 * @return
	 * @throws Exception
	 */
	private boolean convertHtmlToPdf(String content,String tordername, String outputFile) throws Exception {  
        OutputStream os = new FileOutputStream(outputFile);       
        ITextRenderer renderer = new ITextRenderer();       
        //String url = new File(inputFile).toURI().toURL().toString();   
       // renderer.setDocument(content);  
        String group0 = "<\\s*img\\s+([^>]+)\\s*>" ;// 整个img标签,group0  
        String group1 = "<\\s*input\\s+([^>]+)\\s*>" ;// 整个input标签,group1  
        Pattern pattern0 = Pattern.compile(group0);  
        Matcher matcher0 = pattern0.matcher(content);  
        while (matcher0.find()) {  
            String img = matcher0.group(0);  
            content = content.replace(img, img+"</img>");
        }
        content = content.replaceAll("</img></img></img>", "</img>");
        content = content.replaceAll("</img></img>", "</img>");
        Pattern pattern1 = Pattern.compile(group1);  
        Matcher matcher1 = pattern1.matcher(content); 
        while(matcher1.find()){
        	 String input = matcher1.group(0);
        	content = content.replace(input, input+"</input>");
        }
        content = content.replaceAll("</input></input>", "</input>");
        content="<!DOCTYPE html PUBLIC '-//W3C//DTD XHTML 1.0 Transitional//EN' 'http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd'> <html xmlns='http://www.w3.org/1999/xhtml'><head><title>"+tordername+"</title></head><body>"+content+"</body></html>";
        //content = HtmlToPdf.parseXhtml(content);
        renderer.setDocumentFromString(content);
        // 解决中文支持问题       
        ITextFontResolver fontResolver = renderer.getFontResolver();      
        fontResolver.addFont("C:/Windows/Fonts/SIMSUN.TTC", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);       
        //解决图片的相对路径问题  
       renderer.getSharedContext();//.setBaseURL("file:/D:/itours/orders");  
       renderer.getRootBox();
        renderer.layout();
       // renderer.
        renderer.createPDF(os);    
        os.flush();  
        os.close();  
        return true;  
    }  
	/**
	 * 
	 * @param content
	 * @param tordername
	 * @param outputFile
	 * @throws DocumentException
	 * @throws IOException
	 */
	public static void writehtmlToPdf(String content,String tordername, String outputFile)throws DocumentException, IOException {
	    Document document = new Document();
	    PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(outputFile));
	    document.open();
	    String group0 = "<\\s*img\\s+([^>]+)\\s*>" ;// 整个img标签,group0  
        String group1 = "<\\s*input\\s+([^>]+)\\s*>" ;// 整个input标签,group1  
        Pattern pattern0 = Pattern.compile(group0);  
        Matcher matcher0 = pattern0.matcher(content);  
        while (matcher0.find()) {  
            String img = matcher0.group(0);  
            content = content.replace(img, img+"</img>");
        }
        content = content.replaceAll("</img></img></img>", "</img>");
        content = content.replaceAll("</img></img>", "</img>");
        Pattern pattern1 = Pattern.compile(group1);  
        Matcher matcher1 = pattern1.matcher(content); 
        while(matcher1.find()){
        	 String input = matcher1.group(0);
        	content = content.replace(input, input+"</input>");
        }
        content = content.replaceAll("</input></input>", "</input>");
        content="<!DOCTYPE html PUBLIC '-//W3C//DTD XHTML 1.0 Transitional//EN' 'http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd'> <html xmlns='http://www.w3.org/1999/xhtml'><head><title>"+tordername+"</title><meta charset='UTF-8'>"+
        "<meta name='applicable-device' content='pc'><meta http-equiv='Content-Type' content='text/html; charset=utf-8' /></head><body>"+content+"</body></html>";
        ByteArrayInputStream stream = new ByteArrayInputStream(content.getBytes());
        InputStreamReader isr = new InputStreamReader(stream, "UTF-8");  
       // InputStream is = new FileInputStream(content);
	    XMLWorkerHelper.getInstance().parseXHtml(writer,document,isr);
	    document.close();
	  //  System.out.println( "PDF Created!" );
	}
}
