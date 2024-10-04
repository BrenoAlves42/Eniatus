package model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class PdfLogAlts {
	private File file;
	private FileWriter writer;
	private PrintWriter pWriter;
	private Path filePath;
	
	public PdfLogAlts() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	private void CriarArquivoTXT() throws IOException {
		file = new File("LogAlts.txt");
		file.setWritable(true);
		writer = new FileWriter(file, true);
		pWriter = new PrintWriter(writer);
		
	}
	

	private void escreverDados(String user, String data, String table, String Atributos) {
		
		file.setWritable(true);
		pWriter.println("Em: "+data +" O Usuario: "+user+" Alterou em: "+table+" o(s) atributos "+Atributos);
		pWriter.close();
		file.setWritable(false);
	
	}
	
	public void gerarPDF(String user, String data, String table, String Atributos) {
		try {
				Document documento = new Document(PageSize.A4);
				CriarArquivoTXT();
				escreverDados(user, data, table, Atributos);
				filePath = Paths.get("LogAlts.txt");
				String dados = Files.readString(filePath);
				
				
				PdfWriter.getInstance(documento, new FileOutputStream(new File(System.getProperty("user.home"), "Desktop\\LogAltsEniatus.pdf")));
				documento.addHeader("Titulo", "LOG DE ALTERAÇÕES NO SISTEMA ENIATUS");
					
				documento.open();
				
				Paragraph para = new Paragraph(dados);	
				documento.add(para);
					
				documento.close();
					
			
		} catch (DocumentException | IOException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
