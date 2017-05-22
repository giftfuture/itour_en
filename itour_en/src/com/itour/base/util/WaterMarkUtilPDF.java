package com.itour.base.util;

import java.awt.Color;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfGState;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

/*import com.fr.third.com.lowagie.text.DocumentException;
import com.fr.third.com.lowagie.text.Element;
import com.fr.third.com.lowagie.text.Rectangle;
import com.fr.third.com.lowagie.text.pdf.BaseFont;
import com.fr.third.com.lowagie.text.pdf.PdfContentByte;
import com.fr.third.com.lowagie.text.pdf.PdfGState;
import com.fr.third.com.lowagie.text.pdf.PdfReader;
import com.fr.third.com.lowagie.text.pdf.PdfStamper;*/



public class WaterMarkUtilPDF {

	public static void main(String[] args) throws Exception {
		PdfReader pdfReader = new PdfReader("D:\\itours\\orderpdfs\\0D597A0A267C401B82AB73935BB2665E_稻城亚丁--黄山景区端午轻旅行_726E5C0658D94815BE35FE36C957B06B_2016年07月24日45646.pdf");
		// Get the PdfStamper object
		PdfStamper pdfStamper = new PdfStamper(pdfReader, new FileOutputStream("I:\\0D597A0A267C401B82AB73935BB2665E_稻城亚丁--黄山景区端午轻旅行_726E5C0658D94815BE35FE36C957B06B_2016年07月24日45646.pdf"));
		addWatermark(pdfStamper, "www.itours.com.cn");
		pdfStamper.close(); 
	}   

	public static void addWatermark(PdfStamper pdfStamper, String waterMarkName) {
		PdfContentByte content = null;
		BaseFont base = null;
		Rectangle pageRect = null;
		PdfGState gs = new PdfGState();
		try {// 设置字体
			//base = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H",BaseFont.EMBEDDED);
			base = BaseFont.createFont("C:/WINDOWS/Fonts/SIMSUN.TTC,1", "Identity-H",BaseFont.EMBEDDED);
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			if (base == null || pdfStamper == null) {
				return;
			}
			// 设置透明度为0.4
			gs.setFillOpacity(0.4f);
			gs.setStrokeOpacity(0.4f);
			int toPage = pdfStamper.getReader().getNumberOfPages();
			for (int i = 1; i <= toPage; i++) {
				pageRect = pdfStamper.getReader().getPageSizeWithRotation(i);
				// 计算水印X,Y坐标
				float x = pageRect.getWidth() / 2;
				float y = pageRect.getHeight() / 2;
				//获得PDF最顶层
				content = pdfStamper.getOverContent(i);
				content.saveState();
				// set Transparency
				content.setGState(gs);
				content.beginText();
				content.setColorFill(BaseColor.GRAY);
				//content.setColorFill(arg0);
				content.setFontAndSize(base, 80);
				// 水印文字成45度角倾斜
				content.showTextAligned(Element.ALIGN_CENTER, waterMarkName, x,y, 315);
				content.endText();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			content = null;
			base = null;
			pageRect = null;
		}
	}
	  public static void waterMark(String inputFile, String imageFile,String outputFile, String waterMarkName, int permission) {  
	        try {  
	            PdfReader reader = new PdfReader(inputFile);  
	            PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(  
	                    outputFile));  
	  
	            BaseFont base = BaseFont.createFont(  
	                    "C:/WINDOWS/Fonts/SIMSUN.TTC,1", "Identity-H", true);// 使用系统字体  
	  
	            int total = reader.getNumberOfPages() + 1;  
	            Image image = Image.getInstance(imageFile);  
	  
	            // 图片位置  
	            image.setAbsolutePosition(400, 480);  
	            PdfContentByte under;  
	            int j = waterMarkName.length();  
	            char c = 0;  
	            int rise = 0;  
	            for (int i = 1; i < total; i++) {  
	                rise = 400;  
	                under = stamper.getUnderContent(i);  
	                under.beginText();  
	                under.setFontAndSize(base, 30);  
	  
	                if (j >= 15) {  
	                    under.setTextMatrix(200, 120);  
	                    for (int k = 0; k < j; k++) {  
	                        under.setTextRise(rise);  
	                        c = waterMarkName.charAt(k);  
	                        under.showText(c + "");  
	                    }  
	                } else {  
	                    under.setTextMatrix(240, 100);  
	                    for (int k = 0; k < j; k++) {  
	                        under.setTextRise(rise);  
	                        c = waterMarkName.charAt(k);  
	                        under.showText(c + "");  
	                        rise -= 18;  
	  
	                    }  
	                }  
	  
	                // 添加水印文字  
	                under.endText();  
	  
	                // 添加水印图片  
	                under.addImage(image);  
	  
	                // 画个圈  
	                under.ellipse(250, 450, 350, 550);  
	                under.setLineWidth(1f);  
	                under.stroke();  
	            }  
	            stamper.close();  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	    }  
}