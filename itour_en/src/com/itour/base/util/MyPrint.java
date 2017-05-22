package com.itour.base.util;

import java.io.File;
import java.io.FileInputStream;

import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.ServiceUI;
import javax.print.SimpleDoc;
import javax.print.attribute.DocAttributeSet;
import javax.print.attribute.HashDocAttributeSet;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.swing.JFileChooser;
import java.awt.Graphics;  
import java.awt.Graphics2D;  
import java.awt.Rectangle;  
import java.awt.print.Book;  
import java.awt.print.PageFormat;  
import java.awt.print.Paper;  
import java.awt.print.Printable;  
import java.awt.print.PrinterException;  
import java.awt.print.PrinterJob;  
import java.io.FileOutputStream;  
import java.io.IOException;  
import java.io.OutputStream;  
import java.net.URL;  
import java.nio.ByteBuffer;  
  
  
import org.jsoup.Jsoup;  
import org.jsoup.nodes.Document;  
import org.xhtmlrenderer.pdf.ITextFontResolver;  
import org.xhtmlrenderer.pdf.ITextRenderer;  
  
import com.lowagie.text.DocumentException;  
import com.lowagie.text.pdf.BaseFont; 
import com.lowagie.text.pdf.fonts.FontsResourceAnchor;
//import com.nudms.server.nurse.servlet.CompressDataServlet;  
import com.sun.pdfview.PDFFile;  
import com.sun.pdfview.PDFPage;  
import com.sun.pdfview.PDFRenderer; 
public class MyPrint {

	private static void print(){
		//      JFileChooser fileChooser = new JFileChooser(); //创建打印作业  
		//      int state = fileChooser.showOpenDialog(null);  
		//      if(state == fileChooser.APPROVE_OPTION){  
		//          File file = fileChooser.getSelectedFile();
          File file = new File("F:\\基督福音\\撒旦的饵.epub"); //获取选择的文件  
          //构建打印请求属性集  
          HashPrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();  
          //设置打印格式，因为未确定类型，所以选择autosense  
          DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;  
          //查找所有的可用的打印服务  
          PrintService printService[] = PrintServiceLookup.lookupPrintServices(flavor, pras);  
          //定位默认的打印服务  
          PrintService defaultService = PrintServiceLookup.lookupDefaultPrintService();  
          //显示打印对话框  
          PrintService service = ServiceUI.printDialog(null, 200, 200, printService,   
                  defaultService, flavor, pras);  
          if(service != null){  
              try {  
                  DocPrintJob job = service.createPrintJob(); //创建打印作业  
                  FileInputStream fis = new FileInputStream(file); //构造待打印的文件流  
                  DocAttributeSet das = new HashDocAttributeSet();  
                  Doc doc = new SimpleDoc(fis, flavor, das);  
                  job.print(doc, pras);  
                  fis.close();
              } catch (Exception e) {  
                  e.printStackTrace();  
              }  
          }  
//      }  
	}
	
	private static void print2(){
	     JFileChooser fileChooser = new JFileChooser(); //创建打印作业  
	        int state = fileChooser.showOpenDialog(null);  
	        if(state == fileChooser.APPROVE_OPTION){  
	            File file = new File("F:\\基督福音\\撒旦的饵.epub"); //获取选择的文件  
	            //构建打印请求属性集  
	            HashPrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();  
	            //设置打印格式，因为未确定类型，所以选择autosense  
	            DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;  
	            //查找所有的可用的打印服务  
	            PrintService printService[] = PrintServiceLookup.lookupPrintServices(flavor, pras);  
	            //定位默认的打印服务  
	            PrintService defaultService = PrintServiceLookup.lookupDefaultPrintService();  
	            //显示打印对话框  
	            PrintService service = ServiceUI.printDialog(null, 200, 200, printService,   
	                    defaultService, flavor, pras);  
	            if(service != null){  
	                try {  
	                    DocPrintJob job = service.createPrintJob(); //创建打印作业  
	                    FileInputStream fis = new FileInputStream(file); //构造待打印的文件流  
	                    DocAttributeSet das = new HashDocAttributeSet();  
	                    Doc doc = new SimpleDoc(fis, flavor, das);  
	                    job.print(doc, pras);  
	                } catch (Exception e) {  
	                    e.printStackTrace();  
	                }  
	            }  
	        }  
	}
	   
    public void printmenu(String urlpath,String filepath, String printName) throws  IOException,DocumentException, PrinterException{  
        URL url = new URL(urlpath);  
        Document document =Jsoup.parse(url, 100000);  
        String html = document.html();  
          
        ITextRenderer renderer = new ITextRenderer();  
        ITextFontResolver fontResolver = renderer.getFontResolver();      
     //   fontResolver.addFont(CompressDataServlet.FONTSPATH, BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);  
        renderer.setDocumentFromString(html);  
        renderer.layout();   
        OutputStream os = new FileOutputStream(filepath);     
        renderer.createPDF(os);   
        os.close();  
        int j=0;  
        PrintService[] services = PrintServiceLookup.lookupPrintServices(null, null);  
        if(services.length == 0){  
            System.out.println("not found printer");  
        }  
        PrinterJob job = PrinterJob.getPrinterJob();  
        for(PrintService ps: services){  
            if(ps.getName().equals(printName)){  
                job.setPrintService(services[j]);  
            }else {  
                j++;  
            }  
        }  
          
        FileInputStream fis = new FileInputStream(filepath);  
        byte[] pdfContent = new byte[fis.available()];  
        fis.read(pdfContent, 0, fis.available());  
        ByteBuffer buf = ByteBuffer.wrap(pdfContent);  
        PDFFile pdfFile = new PDFFile(buf);  
          
        Book bk = new Book();  
          
        int num = pdfFile.getNumPages();  
        for(int i=0; i<num; i++){  
            PDFPage page = pdfFile.getPage(i+1);  
            PageFormat pf = job.defaultPage();  
          //  bk.append(new MyPDFPrintPage(page), pf);  
              
            Paper paper = pf.getPaper();  
            double x = 0;  
            double y = 0;   
              
            if(page.getAspectRatio()<1){  
                double width = page.getBBox().getWidth();  
                double height = page.getBBox().getHeight();  
                  
                paper.setImageableArea(x, y, width, height);  
                  
                pf.setOrientation(PageFormat.PORTRAIT);  
            }else{  
                  
                double width = page.getBBox().getHeight();  
                double height = page.getBBox().getWidth();  
                  
                paper.setImageableArea(x, y, width, height);  
                  
                pf.setOrientation(PageFormat.LANDSCAPE);  
            }  
            pf.setPaper(paper);  
            System.out.println();  
        }  
        job.setPageable(bk);  
        job.setJobName("My book");  
        try {  
            job.print();  
          } catch (Exception e) {  
              e.printStackTrace();  
          }  
        }  
	public static void main(String[] args) {
		print();
		//print2();
		
	}

}
