package control;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import model.Backup;
import model.BackupEntries;
import model.Descontos;
import model.FolhaPagamento;
import model.PdfLog;
import model.PdfLogAlts;
import model.Pessoa;
import model.Proventos;
import model.Recursos;
import model.SingleForm;
import view.DashView;
import view.Forms;
import view.LoginView;

public class Controller implements ActionListener, Runnable, ItemListener{



	private LoginView loginView;
	private DashView dashView;
	private Recursos rec;
	private GenericDAO genericDAO;
	private int userAtualID;
	private String userAtualName;
	private Boolean telaOn, proventEditOn, descEditOn, userEditOn, wcOn, formsOn;
	private PdfLog acessoLog;
	private PdfLogAlts alteracoesLog;
	private SingleForm relIndividual;
	private int montou = 0;
	private ControleRef ctrlREF;
	private double totProvent;
	private double salarioFam;
	private double totDesc;
	private double vencBruto;
	private double vencLiquid;
	private double vencBase;
	private int tempServ;
	private int selectedProv, selectedDisc, selectedFolha, selectedUser;
	private double editHora, editFaltas, editContS;
	private String cargoAtual;
	File file = new File(System.getProperty("user.home"), "Desktop\\temp.png");
	
	
	
	
	
	public Controller() {
		selectedProv = 0;
		selectedDisc = 0;
		selectedFolha = 0;
		selectedUser = 0;
		userAtualID = 0;
		telaOn = false;
		proventEditOn = false;
		descEditOn = false;
		userEditOn = false;
		wcOn = true;
		formsOn = false;
		genericDAO = new GenericDAO();
		loginView = new LoginView();
		dashView = new DashView();
		initSistema();
		rec = new Recursos();
		acessoLog = new PdfLog();
		alteracoesLog = new PdfLogAlts();
		relIndividual = new SingleForm();
		montarTelaLogin();
		montarDash();
		control();
		backupManager();
	}
	
	private void initSistema() {
		ArrayList<Integer> lista = new ArrayList<Integer>();
		int id_adm = 0;
		for(Pessoa p : genericDAO.pessoaAll()) {
			if(p.getCargo().equalsIgnoreCase("administrador")) {
				id_adm = p.getId();
			}else {
				lista.add(p.getId());
				
			}
		}
		Collections.sort(lista);
		dashView.getFormsUserID().addItem(id_adm);
		for(int i : lista) {
			
			dashView.getProventID().addItem(i);
			dashView.getDescontosID().addItem(i);
			dashView.getFolhaIDBox().addItem(i);
			dashView.getPanelInfoUserIDBox().addItem(i);
			
			dashView.getFormsUserID().addItem(i);
		}
		
		
		
	}
	
	private void backupManager() {
		Calendar cal = Calendar.getInstance();
		int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
		int dayOfMonthProx = (cal.get(Calendar.DAY_OF_MONTH))+1;
		if(dayOfMonthProx == 31) {
			dayOfMonthProx = 1;
		}
		
		BackupEntries entry = genericDAO.entryManager("find", 1, 0, null);
		BackupEntries entry2 = genericDAO.entryManager("find", 3, 0, null);
		if(entry.getNumero() == dayOfMonth && entry2.getNumero() == 1) {
			
			Backup.fazBackup();
			genericDAO.entryManager("update", 3, 0, null);
			
		}else {
			genericDAO.entryManager("update", 1, dayOfMonthProx, null);
			genericDAO.entryManager("update", 3, 1, null);
		}
	}
	
	private void wcTxt() {
		if(wcOn == true) {
			
		dashView.getLabelWC1().setVisible(false);
		dashView.getLabelWC2().setVisible(false);
		wcOn = false;	
		
		}else {
			
			dashView.getLabelWC1().setVisible(true);
			dashView.getLabelWC2().setVisible(true);
			wcOn = true;
		}
	}
	
	
	
	private void montarTelaLogin() {
		loginView.setIconImage(rec.getIcon().getImage());
		loginView.getLogoLabel().setIcon(rec.getEniatus());
		loginView.getEntrarBttn().setIcon(rec.getEntrar());
		loginView.getSairBttn().setIcon(rec.getSair());
		loginView.setVisible(true);
	}

	private void montarDash() {
		
			dashView.setIconImage(rec.getIcon().getImage());
			dashView.getLogoIcon().setIcon(rec.getEniatus());
			dashView.getFecharBttn().setIcon(rec.getFechar());
			dashView.getSairBttn().setIcon(rec.getSair());
			dashView.getAltSenhaBttn().setIcon(rec.getAltSenha());
			dashView.getRstSenhaBttn().setIcon(rec.getResetSenha());
			dashView.getCadBttn().setIcon(rec.getCadUser());
			dashView.getProventosBttn().setIcon(rec.getProventos());
			dashView.getDescontosBttn().setIcon(rec.getDescontos());
			dashView.getFolhaBttn().setIcon(rec.getFolha());
			dashView.getInfoBttn().setIcon(rec.getUsrInfo());
			dashView.getFormsBttn().setIcon(rec.getForms());
			
			
		
		
	}
	
	private void montarCadUser() {
		
		dashView.getContentPane().add(dashView.getPanelCadUser());
		dashView.getContentPane().setBackground(new Color(211, 211, 211));
		if(montou == 0) {
			
			for(int year = java.time.LocalDate.now().getYear(); year>=1910; --year){
				dashView.getCadAdmissAno().addItem(year);
				dashView.getCadNasciAno().addItem(year);
			}
			for(int mes = 1; mes <= 12; ++mes){
				dashView.getCadAdmissMes().addItem(mes);
				dashView.getCadNasciMes().addItem(mes);
			}
			for(int dia = 1; dia <= 31; ++dia){
				dashView.getCadAdmissDia().addItem(dia);
				dashView.getCadNasciDia().addItem(dia);
			}	
			for(int f = 0; f <= 31; ++f){
				dashView.getCadNumFilhos().addItem(f);
				
			}
			montou = 1;
		}
		
		
		
	
		
	}
	private void montarTelaForms() {
		if(formsOn == false) {
			dashView.getContentPane().add(dashView.getPanelForms());
			dashView.getContentPane().setBackground(new Color(211, 211, 211));
			formsOn = true;
		}else {
			
			dashView.getContentPane().remove(dashView.getPanelForms());
			dashView.getContentPane().setBackground(Color.WHITE);
			formsOn = false;
		}
	}

	private void montarProventos() {
		
		dashView.getPanelProventos().remove(dashView.getProventosEdit());
		dashView.getContentPane().add(dashView.getPanelProventos());
		dashView.getContentPane().setBackground(new Color(211, 211, 211));
		
	}
	
	private void montarDescontos() {
		dashView.getPanelDescontos().remove(dashView.getDescEditar());
		dashView.getContentPane().add(dashView.getPanelDescontos());
		dashView.getContentPane().setBackground(new Color(211, 211, 211));
		
	}
	
	private void montarFolha() {
		dashView.getContentPane().add(dashView.getPanelFolha());
		dashView.getContentPane().setBackground(new Color(211, 211, 211));
	}
	
	private void montarInfoUser() {
		dashView.getContentPane().add(dashView.getPanelInfoUser());
		dashView.getContentPane().setBackground(new Color(211, 211, 211));
	}
	private void defSalarios() {
		vencBase = 1050.00;
		vencBruto = vencBase + totProvent;
		vencLiquid = vencBruto - totDesc + salarioFam;
	}
	
	private void gerarNewProventos(int tempoServico, int salarioBruto) {
		ctrlREF = new ControleRef(tempoServico, "", salarioBruto, 0);
		Proventos prov = new Proventos(ctrlREF.tempoServico(), ctrlREF.horaExtra(), 0, 0, "");
		genericDAO.proventosManager("persist", prov, 0, "", 0, "");
		totProvent = prov.getAuxilioAlimentar() + prov.getHorasExtras() + prov.getOutros() + prov.getServico5();
		ctrlREF = null;
	}
	
	
	private void gerarNewDescontos(int salarioBruto) {
		ctrlREF = new ControleRef(0, "", salarioBruto, 0);
		Descontos desc = new Descontos(ctrlREF.inss(), 0, 0, ctrlREF.irrf(), 0, "");
		genericDAO.descontosManager("persist", desc, 0, "", 0, "");
		totDesc = desc.getInss() + desc.getFaltas() + desc.getContSindical() + desc.getIrff() + desc.getOutros();
		ctrlREF = null;
	}
	
	private void gerarFolha(int salarioBruto, int numFilhos) {
		ctrlREF = new ControleRef(0, "", salarioBruto, numFilhos);
		salarioFam = ctrlREF.valorFilhos();
		defSalarios();
		FolhaPagamento folha = new FolhaPagamento(vencBase, totProvent, vencBruto, totDesc, ctrlREF.valorFilhos(), vencLiquid);
		genericDAO.folhaManager("persist", folha, 0, "", 0);
		ctrlREF = null;
	}
	
	private void atualizarFolhaProvent() {
		totProvent = Double.parseDouble(dashView.getProventHoraExtra().getText()) + Double.parseDouble(dashView.getProventOutros().getText())
		+ Double.parseDouble(dashView.getProventHoraExtra().getText());
		
		
		int usrID = (int) dashView.getProventID().getSelectedItem();
		Pessoa p = genericDAO.pessoaManager("find", null, usrID, "", "");
		FolhaPagamento folha = genericDAO.folhaManager("find", null, p.getId_folha(), "", 0);
		
		vencBase = folha.getVencBase();
		vencBruto = vencBase + totProvent;
		vencLiquid = folha.getVencBruto() - folha.getTotalDescont() + folha.getSalarioFam();
		
		genericDAO.folhaManager("update", null, folha.getId(), "totalProventos", totProvent);
		genericDAO.folhaManager("update", null, folha.getId(), "vencBruto", vencBruto);
		genericDAO.folhaManager("update", null, folha.getId(), "salarioLiquid", vencLiquid);
		
	}
	private void atualizarFolhaDesc() {
		totDesc = Double.parseDouble(dashView.getDescOutros().getText()) + Double.parseDouble(dashView.getDescFaltasField().getText()) 
		+ Double.parseDouble(dashView.getDesctContratoSindField().getText());
		
		int usrID = (int) dashView.getDescontosID().getSelectedItem();
		Pessoa p = genericDAO.pessoaManager("find", null, usrID, "", "");
		FolhaPagamento folha = genericDAO.folhaManager("find", null, p.getId_folha(), "", 0);
		
		vencBase = folha.getVencBase();
		vencBruto = vencBase + folha.getTotalProvent();
		vencLiquid = folha.getVencBruto() - totDesc + folha.getSalarioFam();
		
		genericDAO.folhaManager("update", null, folha.getId(), "totalDescontos", totDesc);
		genericDAO.folhaManager("update", null, folha.getId(), "vencBruto", vencBruto);
		genericDAO.folhaManager("update", null, folha.getId(), "salarioLiquid", vencLiquid);
	}
	
	private void montarResetSenha() {
		dashView.getContentPane().setBackground(new Color(211, 211, 211));
		dashView.getContentPane().add(dashView.getRstSenhaPanel());

	}
	private void montarMudarSenha() {
		dashView.getContentPane().setBackground(new Color(211, 211, 211));
		dashView.getContentPane().add(dashView.getAltSenhaPanel());

	}
	public static String crypto(String password) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest algoritmo = MessageDigest.getInstance("SHA-256");
		byte digestMessage[] = algoritmo.digest(password.getBytes("UTF-8"));
		StringBuilder hexPassword = new StringBuilder();
		for (byte aByte : digestMessage) {
		hexPassword.append(String.format("%02X", 0xFF & aByte));
			}
		return hexPassword.toString();
	}
	public String resetSenha() {
		 
	    int leftLimit = 97; // letter 'a'
	    int rightLimit = 122; // letter 'z'
	    int targetStringLength =  new Random().nextInt((11 - 6) + 1) + 6;;
	    Random random = new Random();
	    StringBuilder buffer = new StringBuilder(targetStringLength);
	    for (int i = 0; i < targetStringLength; i++) {
	        int randomLimitedInt = leftLimit + (int) 
	          (random.nextFloat() * (rightLimit - leftLimit + 1));
	        buffer.append((char) randomLimitedInt);
	    }
	    String generatedString = buffer.toString();
	 return generatedString;
	}
	
	public void resetDashCamps() {
		dashView.getAlterarSenhaField().setText("");
		dashView.getRstSenhaIdField().setText("");
		dashView.getNovaSenhaField().setText("");
	}
	public void resetCadCamps() {
		dashView.getCadNome().setText("");
		dashView.getCadNasciDia().setSelectedIndex(0);
		dashView.getCadNasciMes().setSelectedIndex(0);
		dashView.getCadNasciAno().setSelectedIndex(0);
		dashView.getCadAdmissDia().setSelectedIndex(0);
		dashView.getCadAdmissMes().setSelectedIndex(0);
		dashView.getCadAdmissAno().setSelectedIndex(0);
		dashView.getCadNaturalidade().setText("");
		dashView.getCadNumFilhos().setSelectedIndex(0);
		dashView.getGroup().clearSelection();
		dashView.getCadUserName().setText("");
	}
	
	public boolean cadCampsVazios() {
		String c1 = dashView.getCadNome().getText();
		String c2 = dashView.getCadNaturalidade().getText();
		String c3 = dashView.getCadUserName().getText();
		boolean b1 = dashView.getCadFuncionario().isSelected();
		boolean b2 = dashView.getCadContador().isSelected();
		if(c1 == "" || c2 == "" || c3 == "") {
			return true;
		}
		else if(b1 == false && b2 == false) {
			return true;
		}
		else {
			return false;
		}
	
	}
	
	public void limparDash() {
		dashView.getContentPane().remove(dashView.getRstSenhaPanel());
		dashView.getContentPane().remove(dashView.getAltSenhaPanel());
		dashView.getContentPane().remove(dashView.getPanelCadUser());
		dashView.getContentPane().remove(dashView.getPanelProventos());
		dashView.getContentPane().remove(dashView.getPanelDescontos());
		dashView.getContentPane().remove(dashView.getPanelFolha());
		dashView.getContentPane().remove(dashView.getPanelInfoUser());
		dashView.getContentPane().remove(dashView.getPanelForms());
	}
	public void control() {
		loginView.getSairBttn().addActionListener(this);
		loginView.getEntrarBttn().addActionListener(this);
		loginView.getMostrarPsswrd().addActionListener(this);
		dashView.getSairBttn().addActionListener(this);
		dashView.getFecharBttn().addActionListener(this);
		dashView.getAltSenhaBttn().addActionListener(this);
		dashView.getRstSenhaBttn().addActionListener(this);
		dashView.getAceitarAltBttn().addActionListener(this);
		dashView.getCancelAltBttn().addActionListener(this);
		dashView.getConfirmarResetBttn().addActionListener(this);
		dashView.getCancelarResetBttn().addActionListener(this);
		dashView.getCopiarBttn().addActionListener(this);
		dashView.getCadBttn().addActionListener(this);
		dashView.getCadAceitar().addActionListener(this);
		dashView.getCadCancelar().addActionListener(this);
		dashView.getCadFuncionario().addItemListener(this);
		dashView.getCadContador().addItemListener(this);
		dashView.getProventosBttn().addActionListener(this);
		dashView.getProventFechar().addActionListener(this);
		dashView.getProventBuscarID().addActionListener(this);
		dashView.getProventBuscarIDAtual().addActionListener(this);
		dashView.getProventaddoutrosBttn().addActionListener(this);
		dashView.getProventosEdit().addActionListener(this);
		dashView.getProventSalvarEditDesc().addActionListener(this);
		dashView.getDescontosBttn().addActionListener(this);
		dashView.getDescFechar().addActionListener(this);
		dashView.getDescBuscarID().addActionListener(this);
		dashView.getDescBuscarIDAtual().addActionListener(this);
		dashView.getDescaddoutrosBttn().addActionListener(this);
		dashView.getDescEditar().addActionListener(this);
		dashView.getDescSalvarEditOutros().addActionListener(this);
		dashView.getFolhaBttn().addActionListener(this);
		dashView.getFolhaSairBttn().addActionListener(this);
		dashView.getFolhaIDAtualBttn().addActionListener(this);
		dashView.getFolhaSelectIDBttn().addActionListener(this);
		dashView.getInfoBttn().addActionListener(this);
		dashView.getPanelInfoUserSairBttn().addActionListener(this);
		dashView.getPanelInfoUserSelectIDBttn().addActionListener(this);
		dashView.getPanelInfoUserEditbttn().addActionListener(this);
		dashView.getUsrInfoIDAtualBttn().addActionListener(this);
		dashView.getFormsBttn().addActionListener(this);
		dashView.getFormsAnaliticoBttn().addActionListener(this);
		dashView.getFormsRelIndividual().addActionListener(this);
		dashView.getFormsSinteticoBttn().addActionListener(this);
		dashView.getAltButton().addActionListener(this);
		dashView.getAcessoBttn().addActionListener(this);
	}
	
	
	public void run() {
		while(true) {
			try {
		
					file.delete();
					loginView.revalidate();
					loginView.repaint();
					dashView.revalidate();
					dashView.repaint();
					Thread.sleep(1);
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
		}
		
	}
	
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(loginView.getSairBttn())) {
			System.exit(0);
		}
		else if (e.getSource().equals(loginView.getMostrarPsswrd())) {
			if(loginView.getMostrarPsswrd().isSelected()){
				loginView.getPasswordField().setEchoChar((char) 0);
			}
			if(loginView.getMostrarPsswrd().isSelected() == false){
				loginView.getPasswordField().setEchoChar('•');
			}
			
		}
		////////////////////////////////////////////////////////////////////////////////////////////////
		else if (e.getSource().equals(loginView.getEntrarBttn())) {
			try {
			String tempPssw = loginView.getPasswordField().getText();
			String tempPsswEncrypt = crypto(tempPssw);
			String tempUsr = loginView.getUserNameField().getText();
			boolean encontrou = false;
			
			if(loginView.getUserNameField().getText().isBlank() || loginView.getPasswordField().getText().isBlank()) {
				JOptionPane.showMessageDialog(loginView, "Ambos os campos precisam ser preenchidos");
			}
			for (Pessoa p : genericDAO.pessoaAll()) {
				if(p.getSenha().equals(tempPsswEncrypt) && p.getUserName().equals(tempUsr)) {
					loginView.setVisible(false);
					dashView.setVisible(true);
					userAtualID = p.getId();
					userAtualName = p.getUserName();
					cargoAtual = p.getCargo();
					acessoLog.gerarPDF(userAtualName, java.time.LocalDate.now().toString(), java.time.LocalTime.now().toString());
					encontrou = true;
				}
				
				}			
			if(encontrou == false){	
				JOptionPane.showMessageDialog(loginView, "Usuario ou senha incorretos");
			}
		
			
			} catch (NoSuchAlgorithmException | UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			if(cargoAtual.equalsIgnoreCase("contador")) {
				dashView.remove(dashView.getAltButton());
				dashView.remove(dashView.getAcessoBttn());
			}
		}
		////////////////////////////////////////////////////////////////////////////////////////////////
	
		
		if (e.getSource().equals(dashView.getFecharBttn())) {
			System.exit(0);
		}
		
		////////////////////////////////////////////////////////////////////////////////////////////////
		else if(e.getSource().equals(dashView.getAltSenhaBttn())) {
			if(telaOn) {
					
	
				
			}else if(telaOn == false) {
				wcTxt();
				montarMudarSenha();
				telaOn = true;
			}
		}
		////////////////////////////////////////////////////////////////////////////////////////////////
		else if(e.getSource().equals(dashView.getRstSenhaBttn())) {
			if(cargoAtual.equalsIgnoreCase("Contador")) {
				JOptionPane.showMessageDialog(dashView, "REQUISITE AO ADMINISTRADOR O RESET DA SUA SENHA");
			}
			else {
				if(telaOn) {

					
				}else if(telaOn == false){
					wcTxt();
					montarResetSenha();
					telaOn = true;
				}
			}
		}
		
		////////////////////////////////////////////////////////////////////////////////////////////////
		else if(e.getSource().equals(dashView.getCancelAltBttn())) {
			wcTxt();
			limparDash();
			dashView.getContentPane().setBackground(Color.white);
			telaOn = false;

		}
		////////////////////////////////////////////////////////////////////////////////////////////////
		else if(e.getSource().equals(dashView.getAceitarAltBttn())) {
			if(dashView.getAlterarSenhaField().getText().equals("")) {	
				JOptionPane.showMessageDialog(dashView, "Erro, o campo está vazio");	
			}
			else {			
				try {
					String senha = dashView.getAlterarSenhaField().getText();
					if(senha.getBytes().length >= 6 && senha.getBytes().length <= 11) {
						
						String senhaCrypto = crypto(senha);
						if(JOptionPane.showConfirmDialog(dashView, "Tem certeza?") == 0) {
							
							genericDAO.pessoaManager("update", genericDAO.pessoaManager("find", null, userAtualID, null, null), userAtualID, "senha", senhaCrypto);
							dashView.getAlterarSenhaField().setText("");
							alteracoesLog.gerarPDF(userAtualName,java.time.LocalDate.now().toString(), "Staff", "Senha");
							JOptionPane.showMessageDialog(dashView, "Senha alterada com sucesso!");	
						}
						
					}
					else {
						JOptionPane.showMessageDialog(dashView, "A senha deve conter entre 6 e 11 caracteres!!");	
					}
				} catch (NoSuchAlgorithmException | UnsupportedEncodingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		////////////////////////////////////////////////////////////////////////////////////////////////
		else if(e.getSource().equals(dashView.getCancelarResetBttn())) {
			wcTxt();
			limparDash();
			dashView.getContentPane().setBackground(Color.white);
			telaOn = false;
		
		}
		////////////////////////////////////////////////////////////////////////////////////////////////
		else if(e.getSource().equals(dashView.getConfirmarResetBttn())) {
			try {
				boolean userFound = false;
				String user = dashView.getRstSenhaIdField().getText();
				for (Pessoa p : genericDAO.pessoaAll()) {
					if(p.getUserName().equals(user)) {
						userFound = true;
						String senha = resetSenha();
						String cryptoSenha = crypto(senha);
						genericDAO.pessoaManager("update", p, p.getId(), "senha", cryptoSenha);
						JOptionPane.showMessageDialog(dashView, "Senha resetada com sucesso");
						alteracoesLog.gerarPDF(userAtualName,java.time.LocalDate.now().toString(), "Staff", "Senha do usuario: "+p.getUserName());
						dashView.getNovaSenhaField().setText(senha);
					}
					
				}
				if(userFound == false) {
					JOptionPane.showMessageDialog(dashView, "Usuario não encontrado");
					
				}
			}
			catch (NoSuchAlgorithmException | UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
		}
			
	}
		////////////////////////////////////////////////////////////////////////////////////////////////
		else if(e.getSource().equals(dashView.getCopiarBttn())) {
			String myString = dashView.getNovaSenhaField().getText();
			StringSelection stringSelection = new StringSelection(myString);
			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			clipboard.setContents(stringSelection, null);
		}
		/////////////////////////////////
		else if(e.getSource().equals(dashView.getCadBttn())) {
			if(telaOn) {

			}else if(telaOn == false) {
				wcTxt();
				montarCadUser();
				if(cargoAtual.equalsIgnoreCase("Contador")) {
					dashView.getPanelCadUser().remove(dashView.getCadContador());
					dashView.getPanelCadUser().remove(dashView.getCadLabelUserName());
					dashView.getPanelCadUser().remove(dashView.getCadUserName());
					dashView.getCadFuncionario().setSelected(true);
				}
				if(cargoAtual.equalsIgnoreCase("Administrador")) {
					dashView.getPanelCadUser().add(dashView.getCadContador());
					dashView.getPanelCadUser().add(dashView.getCadLabelUserName());
					dashView.getPanelCadUser().add(dashView.getCadUserName());
					dashView.getCadFuncionario().setSelected(false);
				}
				telaOn = true;
			}
		}
		
		else if(e.getSource().equals(dashView.getCadAceitar())) {
			String nome = dashView.getCadNome().getText();
			String dataNasci =  ""+ dashView.getCadNasciAno().getSelectedItem() + "-" +  dashView.getCadNasciMes().getSelectedItem() + "-" +  dashView.getCadNasciDia().getSelectedItem();
			String naturalidade = dashView.getCadNaturalidade().getText();
			String dataAdmissao = ""+ dashView.getCadAdmissAno().getSelectedItem() + "-" +  dashView.getCadAdmissMes().getSelectedItem() + "-" +  dashView.getCadAdmissDia().getSelectedItem();
			int numFilhos = dashView.getCadNumFilhos().getSelectedIndex();
			String cargo = "";
			if(dashView.getCadContador().isSelected()) cargo = "Contador";
			else cargo = "Funcionário";
			String senha = resetSenha();
			String cryptoSenha = "";
			String userName = dashView.getCadUserName().getText();
			int id_descontos = 0;
			int id_proventos = 0;
			int id_folha = 0;
			tempServ = Calendar.getInstance().get(Calendar.YEAR) - (int)dashView.getCadAdmissAno().getSelectedItem();
			gerarNewProventos(tempServ, 1050);
			gerarNewDescontos(1050);
			gerarFolha(1050, numFilhos);
			
			if(cadCampsVazios()) {
				JOptionPane.showMessageDialog(dashView, "Há campos em branco, por favor preencher.");
			}
			else {
				
				
				
				for(Proventos prov : genericDAO.proventosAll()) {
					id_proventos = prov.getId();
				}
				for(Descontos desc : genericDAO.descontosAll()) {
					id_descontos = desc.getId();
				}
				for(FolhaPagamento folha : genericDAO.folhaAll()) {
					id_folha = folha.getId();
				}
				
				
				}
				try {
					cryptoSenha = crypto(senha);
				} catch (NoSuchAlgorithmException | UnsupportedEncodingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Pessoa p = new Pessoa(nome, dataNasci, naturalidade, dataAdmissao, numFilhos, cargo, senha, userName, id_descontos, id_proventos, id_folha);
				genericDAO.pessoaManager("persist", p, 0, null, null);
				
				int id = 0;
				for (Pessoa p2 : genericDAO.pessoaAll()) {
					if(p2.getUserName().equals(userName)) {
						id = p2.getId();
				}
				}
					if(cargo == "Contador") {
						JOptionPane.showMessageDialog(dashView, "Novo contador(ID: "+id+" ) cadastrado com sucesso, a senha de acesso é: "+senha+"\n"
					+"A senha foi copiada para a area de transferencia, por favor salvar.");
						
						String myString = senha;
						StringSelection stringSelection = new StringSelection(myString);
						Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
						clipboard.setContents(stringSelection, null);
					}
					else if(cargo == "Funcionário") {
						JOptionPane.showMessageDialog(dashView, "Novo funcionário(ID: "+id+" ) cadastrado com sucesso.");
						
					}
					
					
					
					
					dashView.getProventID().addItem(id);
					dashView.getDescontosID().addItem(id);
					dashView.getFolhaIDBox().addItem(id);
					dashView.getPanelInfoUserIDBox().addItem(id);
				resetCadCamps();
				
				
			
		}
		
		else if(e.getSource().equals(dashView.getCadCancelar())) {
			wcTxt();
			limparDash();
			dashView.getContentPane().setBackground(Color.WHITE);
			resetCadCamps();
			telaOn = false;
		}
		////////////////////////////////////////////////////////////////////////////////////////////////////////
		else if(e.getSource().equals(dashView.getProventosBttn())) {
			if(telaOn) {
				
			}else if(telaOn == false) {
				wcTxt();
				montarProventos();
				telaOn = true;
			}
		}
		
		else if(e.getSource().equals(dashView.getProventFechar())) {
			wcTxt();
			
			boolean c1 = dashView.getProventHoraExtra().getText().isBlank();
			boolean c2 = dashView.getProventOutros().getText().isBlank();
			boolean c3 = dashView.getProventTempoServico().getText().isBlank();
			
			if(c1 == true || c2 == true  || c3 == true) {
				limparDash();
				dashView.getContentPane().setBackground(Color.WHITE);
				telaOn = false;	
			}
			else{
				atualizarFolhaProvent();	
				limparDash();
				dashView.getContentPane().setBackground(Color.WHITE);
				telaOn = false;	
			}
		}

		else if(e.getSource().equals(dashView.getProventBuscarID())) {
			int usrID = (int) dashView.getProventID().getSelectedItem();
			Pessoa p = genericDAO.pessoaManager("find", null, usrID, "", "");
			Proventos prov = genericDAO.proventosManager("find", null, p.getId_proventos(), "", 0, "");
			dashView.getProventHoraExtra().setText(""+prov.getHorasExtras());
			dashView.getProventOutros().setText(""+prov.getOutros());
			dashView.getProventOutrosDesc().setText(""+prov.getOutrosDesc());
			dashView.getProventTempoServico().setText(""+prov.getServico5());
			dashView.getPanelProventos().add(dashView.getProventosEdit());
			selectedProv = p.getId_proventos();
			
		}
		else if(e.getSource().equals(dashView.getProventBuscarIDAtual())) {
			Pessoa p = genericDAO.pessoaManager("find", null, userAtualID, "", "");
			Proventos prov = genericDAO.proventosManager("find", null, p.getId_proventos(), "", 0, "");
			dashView.getProventID().setSelectedItem(p.getId());
			dashView.getProventHoraExtra().setText(""+prov.getHorasExtras());
			dashView.getProventOutros().setText(""+prov.getOutros());
			dashView.getProventOutrosDesc().setText(""+prov.getOutrosDesc());
			dashView.getProventTempoServico().setText(""+prov.getServico5());
			dashView.getPanelProventos().add(dashView.getProventosEdit());
			selectedProv = p.getId_proventos();
			
			
		}
		else if(e.getSource().equals(dashView.getProventosEdit())) {
			
			if(proventEditOn == false) {
				editHora = 0.00;
				dashView.getProventHoraExtra().setEditable(true);
				editHora = editHora + Double.parseDouble(dashView.getProventHoraExtra().getText());
				dashView.getProventHoraExtra().setText("");
				proventEditOn = true;
				
			}
			else if(proventEditOn == true) {
				int horasExtras = Integer.parseInt(dashView.getProventHoraExtra().getText());
				
				double valor = 0;
				if(horasExtras > 0) {
					int cont = horasExtras;
					for(int i = 0; i <= cont; i++) {			
						double porcento = ( 5.0 * 50.0 ) / 100.0;
						valor = valor + porcento;
					}
				}
				
				editHora = editHora + valor;	
				String horaStr = Double.toString(editHora);
				genericDAO.proventosManager("update", null, selectedProv, "horasExtras", editHora, "");
				alteracoesLog.gerarPDF(userAtualName,java.time.LocalDate.now().toString(), "Proventos", "Horas extras");
				dashView.getProventHoraExtra().setText(horaStr);
				dashView.getProventHoraExtra().setEditable(false);
				dashView.getPanelProventos().remove(dashView.getProventosEdit());
				proventEditOn = false;
				
				
				
			}
			
			
		}
		else if(e.getSource().equals(dashView.getProventSalvarEditDesc())) {
			String desc = dashView.getProventOutrosDesc().getText();
			genericDAO.proventosManager("update", null, selectedProv, "outrosDesc", 0, desc);		
			alteracoesLog.gerarPDF(userAtualName,java.time.LocalDate.now().toString(), "Proventos", "Outros-Descrição");
		}
		else if(e.getSource().equals(dashView.getProventaddoutrosBttn())) {
			double valor = Double.parseDouble(dashView.getProventOutros().getText()) + Double.parseDouble(dashView.getProventAddOutros().getText());
			genericDAO.proventosManager("update", null, selectedProv, "outros", valor, "");
			dashView.getProventOutros().setText(Double.toString(valor));
			dashView.getProventAddOutros().setText("");
			alteracoesLog.gerarPDF(userAtualName,java.time.LocalDate.now().toString(), "Proventos", "Outros");
			
		}
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		else if(e.getSource().equals(dashView.getDescontosBttn())) {
			if(telaOn) {
				
			}else if(telaOn == false) {
				wcTxt();
				montarDescontos();
				telaOn = true;
				
			}
			
		}
		else if(e.getSource().equals(dashView.getDescFechar())) {
			wcTxt();
			
			boolean c1 = dashView.getDescFaltasField().getText().isBlank();
			boolean c2 = dashView.getDescInssField().getText().isBlank();
			boolean c3 = dashView.getDescIrffField().getText().isBlank();
			
			if(c1 == true || c2 == true  || c3 == true) {
				limparDash();
				dashView.getContentPane().setBackground(Color.WHITE);
				telaOn = false;	
			}
			else{
				atualizarFolhaDesc();
				limparDash();
				dashView.getContentPane().setBackground(Color.WHITE);
				telaOn = false;
			}
		
			
		}
		
		else if(e.getSource().equals(dashView.getDescBuscarID())) {
			int usrID = (int) dashView.getDescontosID().getSelectedItem();
			Pessoa p = genericDAO.pessoaManager("find", null, usrID, "", "");
			Descontos desc = genericDAO.descontosManager("find", null, p.getId_descontos(), "", 0, "");
			dashView.getDescFaltasField().setText(""+desc.getFaltas());
			dashView.getDescInssField().setText(""+desc.getInss());
			dashView.getDescIrffField().setText(""+desc.getIrff());
			dashView.getDescOutros().setText(""+desc.getOutros());
			dashView.getDesctContratoSindField().setText(""+desc.getContSindical());
			dashView.getDescOutrosDesc().setText(""+desc.getOutrosDesc());
			dashView.getPanelDescontos().add(dashView.getDescEditar());
			selectedDisc = p.getId_descontos();
			
		}
		else if(e.getSource().equals(dashView.getDescBuscarIDAtual())) {
			Pessoa p = genericDAO.pessoaManager("find", null, userAtualID, "", "");
			Descontos desc = genericDAO.descontosManager("find", null, p.getId_descontos(), "", 0, "");
			dashView.getDescontosID().setSelectedItem(p.getId());
			dashView.getDescFaltasField().setText(""+desc.getFaltas());
			dashView.getDescInssField().setText(""+desc.getInss());
			dashView.getDescIrffField().setText(""+desc.getIrff());
			dashView.getDescOutros().setText(""+desc.getOutros());
			dashView.getDesctContratoSindField().setText(""+desc.getContSindical());
			dashView.getDescOutrosDesc().setText(""+desc.getOutrosDesc());
			dashView.getPanelDescontos().add(dashView.getDescEditar());
			selectedDisc = p.getId_descontos();
			
		}
		else if(e.getSource().equals(dashView.getDescEditar())) {
			
			if(descEditOn == false) {
				dashView.getDescFaltasField().setEditable(true);
				dashView.getDesctContratoSindField().setEditable(true);
				editFaltas = Double.parseDouble(dashView.getDescFaltasField().getText());
				editContS = Double.parseDouble(dashView.getDesctContratoSindField().getText());
				dashView.getDescFaltasField().setText("");
				dashView.getDesctContratoSindField().setText("");
				descEditOn = true;
				
			}
			else if(descEditOn == true) {
				
				
				if(dashView.getDescFaltasField().getText().isBlank() && dashView.getDesctContratoSindField().getText().isBlank() == false) {
					genericDAO.descontosManager("update", null, selectedDisc, "contSindical", editContS, "");	
					alteracoesLog.gerarPDF(userAtualName,java.time.LocalDate.now().toString(), "Descontos", "Contrato Sindical");
				}
				else if(dashView.getDesctContratoSindField().getText().isBlank() && dashView.getDescFaltasField().getText().isBlank() == false) {
					genericDAO.descontosManager("update", null, selectedDisc, "faltas", editFaltas, "");
					alteracoesLog.gerarPDF(userAtualName,java.time.LocalDate.now().toString(), "Descontos", "Faltas");
				}
				else if(dashView.getDesctContratoSindField().getText().isBlank() == false && dashView.getDescFaltasField().getText().isBlank() == false){
					genericDAO.descontosManager("update", null, selectedDisc, "contSindical", editContS, "");	
					genericDAO.descontosManager("update", null, selectedDisc, "faltas", editFaltas, "");
					alteracoesLog.gerarPDF(userAtualName,java.time.LocalDate.now().toString(), "Descontos", "Contrato Sindical");
					alteracoesLog.gerarPDF(userAtualName,java.time.LocalDate.now().toString(), "Descontos", "Faltas");
				}
				else if(dashView.getDesctContratoSindField().getText().isBlank() == false && dashView.getDescFaltasField().getText().isBlank() == false) {
					dashView.getDescFaltasField().setText(""+editFaltas);
					dashView.getDesctContratoSindField().setText(""+editContS);
				}
				dashView.getDescFaltasField().setText(""+editFaltas);
				dashView.getDesctContratoSindField().setText(""+editContS);
				descEditOn = false;
			}
			
			
			
		}
		else if(e.getSource().equals(dashView.getDescSalvarEditOutros())) {
			String desc = dashView.getDescOutrosDesc().getText();
			genericDAO.descontosManager("update", null, selectedDisc, "outrosDesc", 0, desc);
			alteracoesLog.gerarPDF(userAtualName,java.time.LocalDate.now().toString(), "Descontos", "Outros-Descrição");
			
		}
		else if(e.getSource().equals(dashView.getDescaddoutrosBttn())) {
			double valor = Double.parseDouble(dashView.getDescOutros().getText()) + Double.parseDouble(dashView.getDescAddOutros().getText());
			genericDAO.descontosManager("update", null, selectedDisc, "outros", valor, "");
			dashView.getDescOutros().setText(Double.toString(valor));
			dashView.getDescAddOutros().setText("");
			alteracoesLog.gerarPDF(userAtualName,java.time.LocalDate.now().toString(), "Descontos", "Outros");
		}
		//////////////////////
		else if(e.getSource().equals(dashView.getFolhaBttn())) {
			if(telaOn) {
				
			}else if(telaOn == false) {
				wcTxt();
				montarFolha();
				telaOn = true;
			}
			
		}
		else if(e.getSource().equals(dashView.getFolhaSairBttn())) {
			wcTxt();
			limparDash();
			dashView.getContentPane().setBackground(Color.WHITE);
			telaOn = false;
		}
		else if(e.getSource().equals(dashView.getFolhaIDAtualBttn())) {
			Pessoa p = genericDAO.pessoaManager("find", null, userAtualID, "", "");
			FolhaPagamento f = genericDAO.folhaManager("find", null, p.getId_folha(), "", 0);
			dashView.getFolhaIDLabel().setText(""+userAtualID);;
			dashView.getFolhaNomeLabel().setText(""+p.getNome());
			dashView.getFolhaSalFamLabel().setText(""+f.getSalarioFam());
			dashView.getFolhaSalLiqdLabel().setText(""+f.getSalarioLiquid());
			dashView.getFolhaTotalDescLabel().setText(""+f.getTotalDescont());
			dashView.getFolhaTotalProventLabel().setText(""+f.getTotalProvent());
			dashView.getFolhaVencBaseLabel().setText(""+f.getVencBase());
			dashView.getFolhaVencBrutoLabel().setText(""+f.getVencBruto());
		
			
			
		}	
		else if(e.getSource().equals(dashView.getFolhaSelectIDBttn())) {
			int id = (int) dashView.getFolhaIDBox().getSelectedItem();
			Pessoa p = genericDAO.pessoaManager("find", null, id, "", "");
			FolhaPagamento f = genericDAO.folhaManager("find", null, p.getId_folha(), "", 0);
			dashView.getFolhaIDLabel().setText(""+p.getId());;
			dashView.getFolhaNomeLabel().setText(""+p.getNome());
			dashView.getFolhaSalFamLabel().setText(""+f.getSalarioFam());
			dashView.getFolhaSalLiqdLabel().setText(""+f.getSalarioLiquid());
			dashView.getFolhaTotalDescLabel().setText(""+f.getTotalDescont());
			dashView.getFolhaTotalProventLabel().setText(""+f.getTotalProvent());
			dashView.getFolhaVencBaseLabel().setText(""+f.getVencBase());
			dashView.getFolhaVencBrutoLabel().setText(""+f.getVencBruto());
			
		}	
		
		
		////////////////////////////////////////////////////////////////////////////////////////////////////////
		else if(e.getSource().equals(dashView.getInfoBttn())) {
		if(telaOn) {
	
	
				
			}else if(telaOn == false) {
				wcTxt();
				montarInfoUser();
				telaOn = true;
			}
		}
		
		else if(e.getSource().equals(dashView.getPanelInfoUserSairBttn())) {
			if(userEditOn == false) {
				
				wcTxt();
				limparDash();
				dashView.getContentPane().setBackground(Color.WHITE);
				telaOn = false;
			}else {
				JOptionPane.showMessageDialog(dashView, "Termine de editar para sair desta tela");
			}
		}
		
		else if(e.getSource().equals(dashView.getPanelInfoUserEditbttn())) {
			if(userEditOn == false && selectedUser > 0) {
				dashView.getPanelInfoUserNome().setEditable(true);
				dashView.getPanelInfoUserDatNasci().setEditable(true);
				dashView.getPanelInfoUserCargo().setEditable(true);
				dashView.getPanelInfoUserDatAdmiss().setEditable(true);
				dashView.getPanelInfoUserNumFilhos().setEditable(true);
				dashView.getPanelInfoUserNat().setEditable(true);
				dashView.getPanelInfoUserUsrN().setEditable(true);
				userEditOn = true;
				
			}
			else if(userEditOn == true){
				Pessoa p = genericDAO.pessoaManager("find", null, selectedUser, "", "");
				p.setNome(dashView.getPanelInfoUserNome().getText());
				p.setDataNasci(dashView.getPanelInfoUserDatNasci().getText());
				p.setCargo(dashView.getPanelInfoUserCargo().getText());
				p.setDataAdmissao(dashView.getPanelInfoUserDatAdmiss().getText());
				p.setNumFilhos(Integer.parseInt(dashView.getPanelInfoUserNumFilhos().getText()));
				p.setNaturalidade(dashView.getPanelInfoUserNat().getText());
				p.setUserName(dashView.getPanelInfoUserUsrN().getText());
				genericDAO.pessoaManager("merge", p, 0, "", "");
				userEditOn = false;
				alteracoesLog.gerarPDF(userAtualName,java.time.LocalDate.now().toString(), "Staff", "da tabela do usuário "+p.getUserName());
				dashView.getPanelInfoUserNome().setEditable(false);
				dashView.getPanelInfoUserDatNasci().setEditable(false);
				dashView.getPanelInfoUserCargo().setEditable(false);
				dashView.getPanelInfoUserDatAdmiss().setEditable(false);
				dashView.getPanelInfoUserNumFilhos().setEditable(false);
				dashView.getPanelInfoUserNat().setEditable(false);
				dashView.getPanelInfoUserUsrN().setEditable(false);
			}
			else if(dashView.getPanelInfoUserNome().getText().isBlank()) {
				JOptionPane.showMessageDialog(dashView, "Por favor selecione um ID");
			}
		}
		
		else if(e.getSource().equals(dashView.getUsrInfoIDAtualBttn())) {
			if(dashView.getPanelInfoUserNome().isEditable() == false) {
				Pessoa p = genericDAO.pessoaManager("find", null, userAtualID, "", "");
				selectedUser = p.getId();
				dashView.getPanelInfoUserNome().setText(p.getNome());
				dashView.getPanelInfoUserDatNasci().setText(p.getDataNasci());
				dashView.getPanelInfoUserCargo().setText(p.getCargo());
				dashView.getPanelInfoUserDatAdmiss().setText(p.getDataAdmissao());
				dashView.getPanelInfoUserNumFilhos().setText(Integer.toString(p.getNumFilhos()));
				dashView.getPanelInfoUserNat().setText(p.getNaturalidade());
				dashView.getPanelInfoUserUsrN().setText(p.getUserName());
			}
			else {
				JOptionPane.showMessageDialog(dashView, "Termine a edição para selecionar outro usuário");
			}
		}
		
		else if(e.getSource().equals(dashView.getPanelInfoUserSelectIDBttn())) {
			if(dashView.getPanelInfoUserNome().isEditable() == false) {
				int id = (int) dashView.getPanelInfoUserIDBox().getSelectedItem();
				selectedUser = id;
				Pessoa p = genericDAO.pessoaManager("find", null, id, "", "");
				dashView.getPanelInfoUserNome().setText(p.getNome());
				dashView.getPanelInfoUserDatNasci().setText(p.getDataNasci());
				dashView.getPanelInfoUserCargo().setText(p.getCargo());
				dashView.getPanelInfoUserDatAdmiss().setText(p.getDataAdmissao());
				dashView.getPanelInfoUserNumFilhos().setText(Integer.toString(p.getNumFilhos()));
				dashView.getPanelInfoUserNat().setText(p.getNaturalidade());
				dashView.getPanelInfoUserUsrN().setText(p.getUserName());
			}
			else {
				JOptionPane.showMessageDialog(dashView, "Termine a edição para selecionar outro usuário");
			}
			
		}
		
		else if(e.getSource().equals(dashView.getFormsBttn())) {
			if(telaOn && formsOn) {
				wcTxt();
				montarTelaForms();
				telaOn = false;
	
				
			}else if(telaOn == false) {
				wcTxt();
				montarTelaForms();
				telaOn = true;
				
			}
			
			
		}
		else if(e.getSource().equals(dashView.getFormsRelIndividual())) {
			
			int id = (int) dashView.getFormsUserID().getSelectedItem();
			Pessoa p = genericDAO.pessoaManager("find", null, id, "", "");
			FolhaPagamento f = genericDAO.folhaManager("find", null, p.getId_folha(), "", 0);
			Descontos d = genericDAO.descontosManager("find", null, p.getId_descontos(), "", 0, "");
			Forms formulario = new Forms();
			formulario.getLblXNome().setText(p.getNome());
			formulario.getLblX_1nat().setText(p.getNaturalidade());
			formulario.getLblX_2id().setText(Integer.toString(p.getId()));
			formulario.getLblX_3Cargo().setText(p.getCargo());
			formulario.getLblX_4IdFolha().setText(Integer.toString(p.getId_folha()));
			formulario.getLblX_5IdProv().setText(Integer.toString(p.getId_proventos()));
			formulario.getLblX_6IdDesc().setText(Integer.toString(p.getId_descontos()));
			formulario.getLblX_totalProventos().setText(Double.toString(f.getTotalProvent()));
			formulario.getLblX_11TotalDescontos().setText(Double.toString(f.getTotalDescont()));
			formulario.getLblX_13INSS().setText(Double.toString(d.getInss()));
			formulario.getLblX_14IRRF().setText(Double.toString(d.getIrff()));
			formulario.getLblX_15Fam().setText(Double.toString(f.getSalarioFam()));
			formulario.getLblX_16Liquid().setText(Double.toString(f.getSalarioLiquid()));
			formulario.revalidate();
			formulario.repaint();
			formulario.setVisible(true);
			relIndividual.emitir(formulario, p.getNome());
			formulario.setVisible(false);
			formulario.revalidate();
			formulario.repaint();
			formulario = null;
			JOptionPane.showMessageDialog(dashView, "O formulário foi gerado na área de trabalho do sistela");
		
		}
		else if(e.getSource().equals(dashView.getFormsAnaliticoBttn())) {
			JOptionPane.showMessageDialog(dashView, "Não implementado :(");
		}
		else if(e.getSource().equals(dashView.getFormsSinteticoBttn())) {
			JOptionPane.showMessageDialog(dashView, "Não implementado :(");
		}
		
		else if(e.getSource().equals(dashView.getAltButton())) {
			try {
			File file = new File(System.getProperty("user.home"), "Desktop\\LogAltsEniatus.pdf");
		    if (file.toString().endsWith(".pdf"))
					Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + file);
			else {
		        Desktop desktop = Desktop.getDesktop();
		        desktop.open(file);
			}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if(e.getSource().equals(dashView.getAcessoBttn())) {
			try {
				File file = new File(System.getProperty("user.home"), "Desktop\\LogAcessoEniatus.pdf");
			    if (file.toString().endsWith(".pdf"))
						Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + file);
				else {
			        Desktop desktop = Desktop.getDesktop();
			        desktop.open(file);
				}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		}
		
		
		
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if(dashView.getCadFuncionario().isSelected()) {
			dashView.getPanelCadUser().remove(dashView.getCadUserName());
			dashView.getPanelCadUser().remove(dashView.getCadLabelUserName());
			
		}
		else if(dashView.getCadContador().isSelected()) {
			dashView.getPanelCadUser().add(dashView.getCadUserName());
			dashView.getPanelCadUser().add(dashView.getCadLabelUserName());
			
		}
		
	}


	

	
	
}
