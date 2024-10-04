package model;

import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;

import view.Forms;

public class SingleForm {
	Forms formulario;

	public SingleForm() {
		
		
	}
	 
	public void emitir(Forms form, String nome) {
		formulario = form;
		
	    com.itextpdf.text.Document doc=new com.itextpdf.text.Document();
		BufferedImage img = new BufferedImage(form.getWidth(), form.getHeight(), BufferedImage.TYPE_INT_RGB);
		Graphics2D g2d = img.createGraphics();
		form.printAll(g2d);
		Document document = new Document(PageSize.A4.rotate());
		try {
			ImageIO.write(img, "png", new FileOutputStream(new File(System.getProperty("user.home"), "Desktop\\temp.png")));
			 FileOutputStream fos = new FileOutputStream(new File(System.getProperty("user.home"), "Desktop\\Holerite_"+nome+".pdf"));
		     PdfWriter writer = PdfWriter.getInstance(document, fos);
		     writer.open();
		     document.open();
		     document.add(Image.getInstance(new File(System.getProperty("user.home"), "Desktop\\temp.png").getAbsolutePath()));
		     document.close();
		     writer.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
	
}