package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.atomic.AtomicBoolean;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class PdfLog {
	
	private File file;
	private FileWriter writer;
	private PrintWriter pWriter;
	private Path filePath;
	
	public PdfLog() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	private void CriarArquivoTXT() throws IOException {
		file = new File("Log.txt");
		file.setWritable(true);
		writer = new FileWriter(file, true);
		pWriter = new PrintWriter(writer);
		
	}
	

	private void escreverDados(String user, String data, String hora) {
		file.setWritable(true);
		pWriter.println(user +" ---- "+data+" ---- "+hora);
		pWriter.close();
		file.setWritable(false);
	}
	
	public void gerarPDF(String user, String data, String hora) {
		try {
				Document documento = new Document(PageSize.A4);
				CriarArquivoTXT();
				escreverDados(user, data, hora);
				filePath = Paths.get("Log.txt");
				String dados = Files.readString(filePath);
				
				
				PdfWriter.getInstance(documento, new FileOutputStream(new File(System.getProperty("user.home"), "Desktop\\LogAcessoEniatus.pdf")));
				documento.addHeader("Titulo", "LOG DE ACESSO AO SISTEMA ENIATUS");
					
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
