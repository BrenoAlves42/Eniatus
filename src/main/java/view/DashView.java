package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Recursos;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Frame;
import java.awt.SystemColor;
import java.awt.Window;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;
import javax.swing.border.EtchedBorder;
import java.awt.FlowLayout;

public class DashView extends JFrame {

	private JPanel contentPane, menuPanel, rstSenhaPanel, altSenhaPanel, panelCadUser, panelProventos, panelDescontos, panelFolha;
	private JPasswordField alterarSenhaField;
	private JTextField rstSenhaIdField, novaSenhaField, cadNome, cadNaturalidade, cadUserName, descOutros, descInssField, 
	desctContratoSindField, descAddOutros, descFaltasField, descIrffField, proventOutros, proventTempoServico, proventHoraExtra, proventAddOutros,
	panelInfoUserNome, panelInfoUserDatNasci, panelInfoUserNat, panelInfoUserDatAdmiss,  panelInfoUserNumFilhos, panelInfoUserCargo, panelInfoUserUsrN;
	private JLabel logoIcon, logoLabel, usrIDLabel, rstSenhaLabel, novaSenhaLabel, labelDadosPessoa, lblNewLabel, cadLabelUserName,  lblNewLabel_1_3, lblNewLabel_1_4
	, lblNewLabel_7, lblNewLabel_3, lblNewLabel_4, lblNewLabel_5, lblNewLabel_1, lblNewLabel_6, lblNewLabel_8, lblNewLabel_9, lblNewLabel_10,
	lblNewLabel_11, folhaVencBaseLabel, folhaVencBrutoLabel, folhaSalFamLabel, folhaSalLiqdLabel, folhaTotalProventLabel, folhaTotalDescLabel, lblNewLabel_18,
	folhaNomeLabel, lblNewLabel_20, folhaIDLabel;
	private JButton altSenhaBttn, rstSenhaBttn, fecharBttn, sairBttn, confirmarResetBttn, cancelarResetBttn, aceitarAltBttn, cancelAltBttn, cadAceitar, cadCancelar, 
	descaddoutrosBttn, descFechar, descBuscarIDAtual, descBuscarID, copiarBttn, cadBttn, proventosBttn, descontosBttn, folhaBttn, folhaIDAtualBttn, folhaSairBttn, 
	folhaSelectIDBttn, proventBuscarID, proventBuscarIDAtual, proventFechar, proventaddoutrosBttn, proventosEdit, usrInfoIDAtualBttn, infoBttn, panelInfoUserSairBttn, panelInfoUserSelectIDBttn;
	private JRadioButton cadFuncionario, cadContador, cadMensalistaRadio, cadHoristaRadio;
	private JComboBox cadAdmissDia, cadNasciDia, cadAdmissMes, cadNasciMes, cadAdmissAno, cadNasciAno, cadNumFilhos, proventID, descontosID, folhaIDBox;
	private ButtonGroup group, group2;
	private JTextArea proventOutrosDesc, descOutrosDesc;
	private JButton proventSalvarEditDesc;
	private JButton descSalvarEditOutros;
	private JButton descEditar;
	private JPanel panelInfoUser;
	private JComboBox panelInfoUserIDBox;
	private JButton panelInfoUserEditbttn;
	private JPanel panelForms;
	private JButton formsRelIndividual;
	private JButton formsAnaliticoBttn;
	private JButton formsSinteticoBttn;
	private JButton formsBttn;
	private JComboBox formsUserID;
	private JLabel labelWC1;
	private JLabel labelWC2;
	private JButton altButton;
	private JButton acessoBttn;
	
	


	public DashView() {
		setName("Sistema Eniatus");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1041, 730);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		menuPanel = new JPanel();
		menuPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		menuPanel.setBackground(new Color(0, 0, 0));
		menuPanel.setBounds(0, 0, 176, 690);
		contentPane.add(menuPanel);
		menuPanel.setLayout(null);
		
		logoIcon = new JLabel("New label");
		logoIcon.setIcon(null);
		logoIcon.setBounds(-33, 12, 228, 137);
		menuPanel.add(logoIcon);
		
		logoLabel = new JLabel("Menu");
		logoLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 18));
		logoLabel.setForeground(new Color(255, 255, 255));
		logoLabel.setBounds(44, 162, 121, 36);
		menuPanel.add(logoLabel);
		
		altSenhaBttn = new JButton("Alterar senha");
		altSenhaBttn.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		altSenhaBttn.setForeground(Color.BLACK);
		altSenhaBttn.setBounds(10, 209, 117, 37);
		menuPanel.add(altSenhaBttn);
		
		rstSenhaBttn = new JButton("Resetar senha");
		rstSenhaBttn.setForeground(Color.BLACK);
		rstSenhaBttn.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		rstSenhaBttn.setBounds(10, 254, 117, 37);
		menuPanel.add(rstSenhaBttn);
		
		fecharBttn = new JButton("Fechar");
		fecharBttn.setIcon(null);
		fecharBttn.setBounds(5, 653, 78, 23);
		menuPanel.add(fecharBttn);
		
		sairBttn = new JButton("Sair");
		sairBttn.setIcon(null);
		sairBttn.setBounds(97, 653, 68, 23);
//		menuPanel.add(sairBttn);
		
		cadBttn = new JButton("");
		cadBttn.setForeground(Color.BLACK);
		cadBttn.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		cadBttn.setBounds(11, 299, 117, 37);
		menuPanel.add(cadBttn);
		
		proventosBttn = new JButton("");
		proventosBttn.setForeground(Color.BLACK);
		proventosBttn.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		proventosBttn.setBounds(11, 345, 117, 37);
		menuPanel.add(proventosBttn);
		
		descontosBttn = new JButton("");
		descontosBttn.setForeground(Color.BLACK);
		descontosBttn.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		descontosBttn.setBounds(12, 391, 117, 37);
		menuPanel.add(descontosBttn);
		
		folhaBttn = new JButton("");
		folhaBttn.setForeground(Color.BLACK);
		folhaBttn.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		folhaBttn.setBounds(12, 438, 117, 37);
		menuPanel.add(folhaBttn);
		
		infoBttn = new JButton("");
		infoBttn.setForeground(Color.BLACK);
		infoBttn.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		infoBttn.setBounds(12, 500, 117, 37);
		menuPanel.add(infoBttn);
		
		formsBttn = new JButton("");
		formsBttn.setForeground(Color.BLACK);
		formsBttn.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		formsBttn.setBounds(11, 548, 130, 37);
		menuPanel.add(formsBttn);
		
		labelWC1 = new JLabel("Sistema Eniatus");
		labelWC1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 80));
		labelWC1.setBounds(317, 101, 629, 203);
		contentPane.add(labelWC1);
		
		labelWC2 = new JLabel("Seja bem vindo");
		labelWC2.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 75));
		labelWC2.setBounds(338, 369, 544, 100);
		contentPane.add(labelWC2);
		
		acessoBttn = new JButton("Relatório de acessos");
		acessoBttn.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		acessoBttn.setBackground(Color.WHITE);
		acessoBttn.setBounds(322, 31, 215, 44);
		contentPane.add(acessoBttn);
		
		altButton = new JButton("Relatório de alterações");
		altButton.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		altButton.setBackground(Color.WHITE);
		altButton.setBounds(667, 31, 215, 44);
		contentPane.add(altButton);
		
		
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		
		panelForms = new JPanel();
		panelForms.setBounds(243, 214, 184, 283);
//		contentPane.add(panelForms);
		panelForms.setLayout(null);
		
		formsRelIndividual = new JButton("Holerite");
		formsRelIndividual.setBackground(Color.WHITE);
		formsRelIndividual.setBounds(0, 11, 129, 83);
		panelForms.add(formsRelIndividual);
		
		formsAnaliticoBttn = new JButton("Relatório Analitico");
		formsAnaliticoBttn.setBackground(Color.WHITE);
		formsAnaliticoBttn.setBounds(0, 93, 184, 91);
		panelForms.add(formsAnaliticoBttn);
		
		formsSinteticoBttn = new JButton("Relatório sintético");
		formsSinteticoBttn.setBackground(Color.WHITE);
		formsSinteticoBttn.setBounds(0, 181, 184, 91);
		panelForms.add(formsSinteticoBttn);
		
		formsUserID = new JComboBox();
		formsUserID.setBounds(129, 21, 45, 32);
		panelForms.add(formsUserID);
		
		
		
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		panelInfoUser = new JPanel();
		panelInfoUser.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panelInfoUser.setBackground(Color.WHITE);
		panelInfoUser.setBounds(208, 80, 770, 417);
		panelInfoUser.setLayout(null);
//		contentPane.add(panelInfoUser);
		
		JPanel panel2 = new JPanel();
		panel2.setBackground(new Color(30, 144, 255));
		panel2.setBounds(10, 324, 750, 71);
		panelInfoUser.add(panel2);
		panel2.setLayout(null);
		
		usrInfoIDAtualBttn = new JButton("ID Atual");
		usrInfoIDAtualBttn.setBounds(49, 26, 89, 23);
		panel2.add(usrInfoIDAtualBttn);
		
		panelInfoUserSairBttn = new JButton("Sair");
		panelInfoUserSairBttn.setBackground(new Color(255, 255, 255));
		panelInfoUserSairBttn.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		panelInfoUserSairBttn.setBounds(634, 15, 106, 45);
		panel2.add(panelInfoUserSairBttn);
		
		panelInfoUserSelectIDBttn = new JButton("Select ID");
		panelInfoUserSelectIDBttn.setBounds(163, 26, 89, 23);
		panel2.add(panelInfoUserSelectIDBttn);
		
		panelInfoUserIDBox = new JComboBox();
		panelInfoUserIDBox.setBounds(262, 26, 46, 22);
		panel2.add(panelInfoUserIDBox);
		
		panelInfoUserEditbttn = new JButton("Editar");
		panelInfoUserEditbttn.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		panelInfoUserEditbttn.setBackground(Color.WHITE);
		panelInfoUserEditbttn.setBounds(518, 15, 106, 45);
		panel2.add(panelInfoUserEditbttn);
		
		panelInfoUserNome = new JTextField();
		panelInfoUserNome.setEditable(false);
		panelInfoUserNome.setBounds(163, 64, 227, 20);
		panelInfoUser.add(panelInfoUserNome);
		panelInfoUserNome.setColumns(10);
		
		panelInfoUserDatNasci = new JTextField();
		panelInfoUserDatNasci.setEditable(false);
		panelInfoUserDatNasci.setColumns(10);
		panelInfoUserDatNasci.setBounds(163, 119, 101, 20);
		panelInfoUser.add(panelInfoUserDatNasci);
		
		panelInfoUserNat = new JTextField();
		panelInfoUserNat.setEditable(false);
		panelInfoUserNat.setColumns(10);
		panelInfoUserNat.setBounds(163, 168, 227, 20);
		panelInfoUser.add(panelInfoUserNat);
		
		panelInfoUserDatAdmiss = new JTextField();
		panelInfoUserDatAdmiss.setEditable(false);
		panelInfoUserDatAdmiss.setColumns(10);
		panelInfoUserDatAdmiss.setBounds(163, 222, 101, 20);
		panelInfoUser.add(panelInfoUserDatAdmiss);
		
		panelInfoUserNumFilhos = new JTextField();
		panelInfoUserNumFilhos.setEditable(false);
		panelInfoUserNumFilhos.setColumns(10);
		panelInfoUserNumFilhos.setBounds(512, 64, 101, 20);
		panelInfoUser.add(panelInfoUserNumFilhos);
		
		panelInfoUserCargo = new JTextField();
		panelInfoUserCargo.setEditable(false);
		panelInfoUserCargo.setColumns(10);
		panelInfoUserCargo.setBounds(512, 119, 101, 20);
		panelInfoUser.add(panelInfoUserCargo);
		
		panelInfoUserUsrN = new JTextField();
		panelInfoUserUsrN.setEditable(false);
		panelInfoUserUsrN.setColumns(10);
		panelInfoUserUsrN.setBounds(512, 168, 101, 20);
		panelInfoUser.add(panelInfoUserUsrN);
		
		JLabel infolblname = new JLabel("Nome");
		infolblname.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		infolblname.setBounds(47, 67, 106, 17);
		panelInfoUser.add(infolblname);
		
		JLabel infolblDataNasci = new JLabel("Data de nascimento");
		infolblDataNasci.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		infolblDataNasci.setBounds(47, 122, 106, 17);
		panelInfoUser.add(infolblDataNasci);
		
		JLabel infolblNaturalidade = new JLabel("Naturalidade");
		infolblNaturalidade.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		infolblNaturalidade.setBounds(47, 171, 106, 17);
		panelInfoUser.add(infolblNaturalidade);
		
		JLabel infolblDataAdmiss = new JLabel("Data de admissão");
		infolblDataAdmiss.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		infolblDataAdmiss.setBounds(47, 225, 106, 17);
		panelInfoUser.add(infolblDataAdmiss);
		
		JLabel infolblNumFilhos = new JLabel("Numero de filhos:");
		infolblNumFilhos.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		infolblNumFilhos.setBounds(400, 67, 101, 17);
		panelInfoUser.add(infolblNumFilhos);
		
		JLabel infolblCargo = new JLabel("Cargo");
		infolblCargo.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		infolblCargo.setBounds(400, 122, 101, 17);
		panelInfoUser.add(infolblCargo);
		
		JLabel infolblUserName = new JLabel("Nome de usuario");
		infolblUserName.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		infolblUserName.setBounds(400, 171, 101, 17);
		panelInfoUser.add(infolblUserName);
		
		
		
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		panelCadUser = new JPanel();
		panelCadUser.setBackground(new Color(30, 144, 255));
		panelCadUser.setBounds(208, 80, 770, 417);
		panelCadUser.setLayout(null);
		
		labelDadosPessoa = new JLabel("Dados Pessoa");
		labelDadosPessoa.setForeground(new Color(255, 255, 255));
		labelDadosPessoa.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 18));
		labelDadosPessoa.setBounds(97, 59, 152, 56);
		panelCadUser.add(labelDadosPessoa);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setForeground(new Color(255, 255, 255));
		lblNome.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		lblNome.setBounds(97, 140, 48, 14);
		panelCadUser.add(lblNome);
		
		JLabel lblDATAnascimento = new JLabel("Data de nascimento:");
		lblDATAnascimento.setForeground(new Color(255, 255, 255));
		lblDATAnascimento.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		lblDATAnascimento.setBounds(97, 179, 132, 14);
		panelCadUser.add(lblDATAnascimento);
		
		JLabel lblNewLabel_2_2 = new JLabel("Naturalidade:");
		lblNewLabel_2_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_2.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		lblNewLabel_2_2.setBounds(97, 220, 95, 14);
		panelCadUser.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("Numero de filhos:");
		lblNewLabel_2_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_3.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		lblNewLabel_2_3.setBounds(97, 262, 119, 14);
		panelCadUser.add(lblNewLabel_2_3);
		
		lblNewLabel_3 = new JLabel("Dados Funcionário");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(477, 59, 178, 56);
		panelCadUser.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Cargo:");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(477, 142, 48, 23);
		panelCadUser.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Data de admissão:");
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(477, 181, 119, 14);
		panelCadUser.add(lblNewLabel_5);
		
		cadLabelUserName = new JLabel("Nome de usário:");
		cadLabelUserName.setForeground(new Color(255, 255, 255));
		cadLabelUserName.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		cadLabelUserName.setBounds(477, 222, 111, 14);
		panelCadUser.add(cadLabelUserName);
		
		cadFuncionario = new JRadioButton("Funcionário");
		cadFuncionario.setForeground(new Color(255, 255, 255));
		cadFuncionario.setBackground(new Color(30, 144, 255));
		cadFuncionario.setBounds(530, 122, 109, 23);
		panelCadUser.add(cadFuncionario);
		
		cadContador = new JRadioButton("Contador");
		cadContador.setBackground(new Color(30, 144, 255));
		cadContador.setForeground(new Color(255, 255, 255));
		cadContador.setBounds(530, 151, 109, 23);
		panelCadUser.add(cadContador);
		
		group = new ButtonGroup();
		group.add(cadContador);
		group.add(cadFuncionario);	
		
		cadNome = new JTextField();
		cadNome.setBounds(143, 139, 164, 20);
		panelCadUser.add(cadNome);
		cadNome.setColumns(10);
		
		cadNaturalidade = new JTextField();
		cadNaturalidade.setColumns(10);
		cadNaturalidade.setBounds(186, 219, 164, 20);
		panelCadUser.add(cadNaturalidade);
		
		cadNasciDia = new JComboBox();
		cadNasciDia.setBackground(new Color(255, 255, 255));
		cadNasciDia.setMaximumRowCount(31);
		cadNasciDia.setToolTipText("Dia");
		cadNasciDia.setBounds(230, 177, 43, 22);
		panelCadUser.add(cadNasciDia);
		
		cadNasciMes = new JComboBox();
		cadNasciMes.setMaximumRowCount(12);
		cadNasciMes.setToolTipText("Mes");
		cadNasciMes.setBounds(283, 177, 43, 22);
		panelCadUser.add(cadNasciMes);
		
		cadNasciAno = new JComboBox();
		cadNasciAno.setToolTipText("Ano");
		cadNasciAno.setBounds(336, 177, 60, 22);
		panelCadUser.add(cadNasciAno);
		
		cadUserName = new JTextField();
		cadUserName.setColumns(10);
		cadUserName.setBounds(584, 219, 164, 20);
		panelCadUser.add(cadUserName);
		
		cadAdmissDia = new JComboBox();
		cadAdmissDia.setToolTipText("Dia");
		cadAdmissDia.setMaximumRowCount(31);
		cadAdmissDia.setBounds(596, 177, 43, 22);
		panelCadUser.add(cadAdmissDia);
		
		cadAdmissMes = new JComboBox();
		cadAdmissMes.setToolTipText("Mes");
		cadAdmissMes.setMaximumRowCount(12);
		cadAdmissMes.setBounds(649, 177, 43, 22);
		panelCadUser.add(cadAdmissMes);
		
		cadAdmissAno = new JComboBox();
		cadAdmissAno.setToolTipText("Ano");
		cadAdmissAno.setBounds(702, 177, 60, 22);
		panelCadUser.add(cadAdmissAno);
		
		cadNumFilhos = new JComboBox();
		cadNumFilhos.setToolTipText("Dia");
		cadNumFilhos.setMaximumRowCount(31);
		cadNumFilhos.setBounds(212, 260, 43, 22);
		panelCadUser.add(cadNumFilhos);
		
		cadAceitar = new JButton("Aceitar");
		cadAceitar.setBackground(new Color(255, 255, 255));
		cadAceitar.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		cadAceitar.setBounds(241, 350, 113, 37);
		panelCadUser.add(cadAceitar);
		
		cadCancelar = new JButton("Cancelar");
		cadCancelar.setBackground(new Color(255, 255, 255));
		cadCancelar.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		cadCancelar.setBounds(386, 350, 113, 37);
		panelCadUser.add(cadCancelar);
		
//		contentPane.add(panelCadUser);
		


		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		rstSenhaPanel = new JPanel();
		rstSenhaPanel.setBackground(new Color(30, 144, 255));
		rstSenhaPanel.setBounds(390, 210, 376, 243);
//		contentPane.add(rstSenhaPanel);
		rstSenhaPanel.setLayout(null);
		
		usrIDLabel = new JLabel("Username:");
		usrIDLabel.setForeground(Color.WHITE);
		usrIDLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		usrIDLabel.setBackground(Color.WHITE);
		usrIDLabel.setBounds(60, 101, 80, 14);
		rstSenhaPanel.add(usrIDLabel);
		
		rstSenhaIdField = new JTextField();
		rstSenhaIdField.setBounds(141, 101, 86, 20);
		rstSenhaPanel.add(rstSenhaIdField);
		rstSenhaIdField.setColumns(10);
		
		confirmarResetBttn = new JButton("Resetar ");
		confirmarResetBttn.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		confirmarResetBttn.setBounds(80, 178, 86, 39);
		rstSenhaPanel.add(confirmarResetBttn);
		
		cancelarResetBttn = new JButton("Cancelar");
		cancelarResetBttn.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		cancelarResetBttn.setBounds(216, 178, 89, 39);
		rstSenhaPanel.add(cancelarResetBttn);
		
		rstSenhaLabel = new JLabel("Resetar senha de acesso ao sistema");
		rstSenhaLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		rstSenhaLabel.setForeground(Color.WHITE);
		rstSenhaLabel.setBounds(52, 35, 272, 28);
		rstSenhaPanel.add(rstSenhaLabel);
		
		lblNewLabel = new JLabel("Nova senha:");
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(41, 139, 102, 14);
		rstSenhaPanel.add(lblNewLabel);
		
		novaSenhaField = new JTextField();
		novaSenhaField.setBounds(141, 139, 86, 20);
		rstSenhaPanel.add(novaSenhaField);
		novaSenhaField.setColumns(10);
		novaSenhaField.setEditable(false);
		
		copiarBttn = new JButton("Copiar");
		copiarBttn.setToolTipText("Copiar a senha para a area de transferencia");
		copiarBttn.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		copiarBttn.setBounds(233, 137, 89, 23);
		rstSenhaPanel.add(copiarBttn);
		
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		altSenhaPanel = new JPanel();
		altSenhaPanel.setBackground(new Color(30, 144, 255));
		altSenhaPanel.setBounds(390, 210, 376, 243);
//		contentPane.add(altSenhaPanel);
		altSenhaPanel.setLayout(null);
		
		aceitarAltBttn = new JButton("Aceitar");
		aceitarAltBttn.setBounds(80, 178, 86, 39);
		altSenhaPanel.add(aceitarAltBttn);
		
		cancelAltBttn = new JButton("Cancelar");
		cancelAltBttn.setBounds(216, 178, 89, 39);
		altSenhaPanel.add(cancelAltBttn);
		
		novaSenhaLabel = new JLabel("Nova Senha:");
		novaSenhaLabel.setForeground(new Color(255, 255, 255));
		novaSenhaLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		novaSenhaLabel.setBounds(25, 129, 104, 14);
		altSenhaPanel.add(novaSenhaLabel);
		
		alterarSenhaField = new JPasswordField(11);
		alterarSenhaField.setBounds(121, 128, 219, 23);
		altSenhaPanel.add(alterarSenhaField);
		
		JLabel altSenhaLabel = new JLabel("Alterar senha de acesso");
		altSenhaLabel.setForeground(new Color(255, 255, 255));
		altSenhaLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		altSenhaLabel.setBounds(52, 35, 272, 28);
		altSenhaPanel.add(altSenhaLabel);
		
		setVisible(false);
		
		
		
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		panelProventos = new JPanel();
		panelProventos.setBackground(new Color(30, 144, 255));
		panelProventos.setBounds(208, 80, 770, 417);
		panelProventos.setLayout(null);
//		contentPane.add(panelProventos);
		
		JLabel lblNewLabel_1 = new JLabel("Adicional por tempo de serviço");
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 18));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(379, 135, 274, 38);
		panelProventos.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Hora Extra");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(465, 222, 94, 38);
		panelProventos.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Outros");
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 18));
		lblNewLabel_1_2.setBounds(99, 135, 68, 38);
		panelProventos.add(lblNewLabel_1_2);
		
		proventOutrosDesc = new JTextArea();
		proventOutrosDesc.setLineWrap(true);
		proventOutrosDesc.setWrapStyleWord(true);
		proventOutrosDesc.setBounds(44, 206, 188, 176);
		panelProventos.add(proventOutrosDesc);
		
		proventOutros = new JTextField();
		proventOutros.setEditable(false);
		proventOutros.setBounds(78, 172, 113, 20);
		panelProventos.add(proventOutros);
		proventOutros.setColumns(10);
		
		proventTempoServico = new JTextField();
		proventTempoServico.setEditable(false);
		proventTempoServico.setColumns(10);
		proventTempoServico.setBounds(451, 184, 113, 20);
		panelProventos.add(proventTempoServico);
		
		proventHoraExtra = new JTextField();
		proventHoraExtra.setEditable(false);
		proventHoraExtra.setColumns(10);
		proventHoraExtra.setBounds(451, 261, 113, 20);
		panelProventos.add(proventHoraExtra);
		
		proventID = new JComboBox();
		proventID.setBounds(345, 50, 57, 22);
		panelProventos.add(proventID);
		
		lblNewLabel_1_3 = new JLabel("User ID");
		lblNewLabel_1_3.setForeground(Color.WHITE);
		lblNewLabel_1_3.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 18));
		lblNewLabel_1_3.setBounds(267, 38, 68, 38);
		panelProventos.add(lblNewLabel_1_3);
		
		proventBuscarID = new JButton("Buscar por ID");
		proventBuscarID.setBackground(Color.WHITE);
		proventBuscarID.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		proventBuscarID.setBounds(44, 34, 123, 38);
		panelProventos.add(proventBuscarID);
		
		proventBuscarIDAtual = new JButton("ID Atual");
		proventBuscarIDAtual.setBackground(Color.WHITE);
		proventBuscarIDAtual.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		proventBuscarIDAtual.setBounds(44, 83, 123, 38);
		panelProventos.add(proventBuscarIDAtual);
		
		proventFechar = new JButton("Sair");
		proventFechar.setBackground(Color.WHITE);
		proventFechar.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		proventFechar.setBounds(635, 354, 101, 38);
		panelProventos.add(proventFechar);
		
		proventAddOutros = new JTextField();
		proventAddOutros.setColumns(10);
		proventAddOutros.setBounds(245, 261, 113, 20);
		panelProventos.add(proventAddOutros);
		
		proventaddoutrosBttn = new JButton("Add outros");
		proventaddoutrosBttn.setBackground(Color.WHITE);
		proventaddoutrosBttn.setBounds(249, 234, 98, 23);
		panelProventos.add(proventaddoutrosBttn);
		
		JLabel lblNewLabel_6 = new JLabel("Descrição");
		lblNewLabel_6.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setBounds(44, 393, 61, 14);
		panelProventos.add(lblNewLabel_6);
		
		proventosEdit = new JButton("EDITAR");
		proventosEdit.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		proventosEdit.setBackground(Color.WHITE);
		proventosEdit.setBounds(502, 354, 123, 38);
		panelProventos.add(proventosEdit);
		
		proventSalvarEditDesc = new JButton("Salvar edição");
		proventSalvarEditDesc.setBackground(Color.WHITE);
		proventSalvarEditDesc.setBounds(115, 391, 116, 23);
		panelProventos.add(proventSalvarEditDesc);
		
		///////////////////////////////////////////////////////////////////////////////////
		
		panelDescontos = new JPanel();
		panelDescontos.setBackground(new Color(30, 144, 255));
		panelDescontos.setBounds(208, 80, 770, 417);
		panelDescontos.setLayout(null);
//		contentPane.add(panelDescontos);
		
		JLabel labelINSS = new JLabel("INSS");
		labelINSS.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 18));
		labelINSS.setForeground(Color.WHITE);
		labelINSS.setBounds(483, 80, 47, 38);
		panelDescontos.add(labelINSS);
		
		JLabel labelContSindical = new JLabel("Contrato Sindical");
		labelContSindical.setForeground(Color.WHITE);
		labelContSindical.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 18));
		labelContSindical.setBounds(434, 159, 152, 38);
		panelDescontos.add(labelContSindical);
		
		JLabel labelOutros = new JLabel("Outros");
		labelOutros.setForeground(Color.WHITE);
		labelOutros.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 18));
		labelOutros.setBounds(99, 135, 68, 38);
		panelDescontos.add(labelOutros);
		
		descOutrosDesc = new JTextArea();
		descOutrosDesc.setLineWrap(true);
		descOutrosDesc.setWrapStyleWord(true);
		descOutrosDesc.setBounds(44, 206, 188, 176);
		panelDescontos.add(descOutrosDesc);
		
		descOutros = new JTextField();
		descOutros.setBounds(78, 172, 113, 20);
		panelDescontos.add(descOutros);
		descOutros.setColumns(10);
		
		descInssField = new JTextField();
		descInssField.setColumns(10);
		descInssField.setBounds(451, 129, 113, 20);
		panelDescontos.add(descInssField);
		
		desctContratoSindField = new JTextField();
		desctContratoSindField.setColumns(10);
		desctContratoSindField.setBounds(451, 208, 113, 20);
		panelDescontos.add(desctContratoSindField);
		
		descontosID = new JComboBox();
		descontosID.setBounds(345, 50, 57, 22);
		panelDescontos.add(descontosID);
		
		lblNewLabel_1_3 = new JLabel("User ID");
		lblNewLabel_1_3.setForeground(Color.WHITE);
		lblNewLabel_1_3.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 18));
		lblNewLabel_1_3.setBounds(267, 38, 68, 38);
		panelDescontos.add(lblNewLabel_1_3);
		
		descBuscarID = new JButton("Buscar por ID");
		descBuscarID.setBackground(Color.WHITE);
		descBuscarID.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		descBuscarID.setBounds(44, 34, 123, 38);
		panelDescontos.add(descBuscarID);
		
		descBuscarIDAtual = new JButton("ID Atual");
		descBuscarIDAtual.setBackground(Color.WHITE);
		descBuscarIDAtual.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		descBuscarIDAtual.setBounds(44, 83, 123, 38);
		panelDescontos.add(descBuscarIDAtual);
		
		descFechar = new JButton("Sair");
		descFechar.setBackground(Color.WHITE);
		descFechar.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		descFechar.setBounds(635, 354, 101, 38);
		panelDescontos.add(descFechar);
		
		descAddOutros = new JTextField();
		descAddOutros.setColumns(10);
		descAddOutros.setBounds(245, 261, 120, 20);
		panelDescontos.add(descAddOutros);
		
		descaddoutrosBttn = new JButton("Add outros");
		descaddoutrosBttn.setBackground(Color.WHITE);
		descaddoutrosBttn.setBounds(245, 234, 89, 23);
		panelDescontos.add(descaddoutrosBttn);
		
		JLabel labelDesc = new JLabel("Descrição");
		labelDesc.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		labelDesc.setForeground(Color.WHITE);
		labelDesc.setBounds(54, 393, 61, 14);
		panelDescontos.add(labelDesc);
		
		lblNewLabel_1_4 = new JLabel("Faltas");
		lblNewLabel_1_4.setForeground(Color.WHITE);
		lblNewLabel_1_4.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 18));
		lblNewLabel_1_4.setBounds(483, 239, 57, 38);
		panelDescontos.add(lblNewLabel_1_4);
		
		descFaltasField = new JTextField();
		descFaltasField.setColumns(10);
		descFaltasField.setBounds(451, 285, 113, 20);
		panelDescontos.add(descFaltasField);
		
		lblNewLabel_7 = new JLabel("IRFF");
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 18));
		lblNewLabel_7.setBounds(668, 80, 47, 38);
		panelDescontos.add(lblNewLabel_7);
		
		descIrffField = new JTextField();
		descIrffField.setColumns(10);
		descIrffField.setBounds(635, 129, 113, 20);
		panelDescontos.add(descIrffField);
		
		descSalvarEditOutros = new JButton("Salvar edição");
		descSalvarEditOutros.setBackground(Color.WHITE);
		descSalvarEditOutros.setBounds(125, 391, 115, 23);
		panelDescontos.add(descSalvarEditOutros);
		
		descEditar = new JButton("EDITAR");
		descEditar.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		descEditar.setBackground(Color.WHITE);
		descEditar.setBounds(524, 354, 101, 38);
		panelDescontos.add(descEditar);
		
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		panelFolha = new JPanel();
		panelFolha.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panelFolha.setBackground(Color.WHITE);
		panelFolha.setBounds(208, 80, 770, 417);
		panelFolha.setLayout(null);
//		contentPane.add(panelFolha);
		
		lblNewLabel_1 = new JLabel("Vencimento base");
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(251, 69, 112, 25);
		panelFolha.add(lblNewLabel_1);
		
		lblNewLabel_6 = new JLabel("Total proventos");
		lblNewLabel_6.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(251, 210, 112, 25);
		panelFolha.add(lblNewLabel_6);
		
		lblNewLabel_8 = new JLabel("Vencimento bruto");
		lblNewLabel_8.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		lblNewLabel_8.setBounds(251, 95, 126, 25);
		panelFolha.add(lblNewLabel_8);
		
		lblNewLabel_9 = new JLabel("Total Descontos");
		lblNewLabel_9.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		lblNewLabel_9.setBounds(251, 246, 112, 25);
		panelFolha.add(lblNewLabel_9);
		
		lblNewLabel_10 = new JLabel("Salario familia");
		lblNewLabel_10.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		lblNewLabel_10.setBounds(251, 138, 112, 25);
		panelFolha.add(lblNewLabel_10);
		
		lblNewLabel_11 = new JLabel("Salario liquido");
		lblNewLabel_11.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		lblNewLabel_11.setBounds(251, 174, 112, 25);
		panelFolha.add(lblNewLabel_11);
		
		folhaVencBaseLabel = new JLabel("New label");
		folhaVencBaseLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		folhaVencBaseLabel.setBounds(406, 73, 90, 18);
		panelFolha.add(folhaVencBaseLabel);
		
		folhaVencBrutoLabel = new JLabel("New label");
		folhaVencBrutoLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		folhaVencBrutoLabel.setBounds(406, 99, 90, 18);
		panelFolha.add(folhaVencBrutoLabel);
		
		folhaSalFamLabel = new JLabel("New label");
		folhaSalFamLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		folhaSalFamLabel.setBounds(406, 142, 90, 18);
		panelFolha.add(folhaSalFamLabel);
		
		folhaSalLiqdLabel = new JLabel("New label");
		folhaSalLiqdLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		folhaSalLiqdLabel.setBounds(406, 178, 90, 18);
		panelFolha.add(folhaSalLiqdLabel);
		
		folhaTotalProventLabel = new JLabel("New label");
		folhaTotalProventLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		folhaTotalProventLabel.setBounds(406, 214, 90, 18);
		panelFolha.add(folhaTotalProventLabel);
		
		folhaTotalDescLabel = new JLabel("New label");
		folhaTotalDescLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		folhaTotalDescLabel.setBounds(406, 250, 90, 18);
		panelFolha.add(folhaTotalDescLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(30, 144, 255));
		panel.setBounds(10, 324, 750, 71);
		panelFolha.add(panel);
		panel.setLayout(null);
		
		folhaIDAtualBttn = new JButton("ID Atual");
		folhaIDAtualBttn.setBounds(49, 26, 89, 23);
		panel.add(folhaIDAtualBttn);
		
		folhaSairBttn = new JButton("Sair");
		folhaSairBttn.setBackground(new Color(255, 255, 255));
		folhaSairBttn.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		folhaSairBttn.setBounds(634, 15, 106, 45);
		panel.add(folhaSairBttn);
		
		folhaSelectIDBttn = new JButton("Select ID");
		folhaSelectIDBttn.setBounds(163, 26, 89, 23);
		panel.add(folhaSelectIDBttn);
		
		folhaIDBox = new JComboBox();
		folhaIDBox.setBounds(262, 26, 46, 22);
		panel.add(folhaIDBox);
		
		lblNewLabel_18 = new JLabel("Nome:");
		lblNewLabel_18.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		lblNewLabel_18.setBounds(95, 11, 55, 25);
		panelFolha.add(lblNewLabel_18);
		
		folhaNomeLabel = new JLabel("New label");
		folhaNomeLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		folhaNomeLabel.setBounds(148, 15, 400, 18);
		panelFolha.add(folhaNomeLabel);
		
		lblNewLabel_20 = new JLabel("ID:");
		lblNewLabel_20.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		lblNewLabel_20.setBounds(558, 11, 23, 25);
		panelFolha.add(lblNewLabel_20);
		
		folhaIDLabel = new JLabel("New label");
		folhaIDLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		folhaIDLabel.setBounds(591, 13, 90, 22);
		panelFolha.add(folhaIDLabel);
		
		/////////////////////////////////////////////////////////////////////////////////////
		
	}




	public JPanel getContentPane() {
		return contentPane;
	}




	public JPanel getRstSenhaPanel() {
		return rstSenhaPanel;
	}




	public JPanel getAltSenhaPanel() {
		return altSenhaPanel;
	}




	public JPasswordField getAlterarSenhaField() {
		return alterarSenhaField;
	}




	public JTextField getRstSenhaIdField() {
		return rstSenhaIdField;
	}




	public JLabel getLogoIcon() {
		return logoIcon;
	}




	public JButton getAltSenhaBttn() {
		return altSenhaBttn;
	}




	public JButton getRstSenhaBttn() {
		return rstSenhaBttn;
	}




	public JButton getFecharBttn() {
		return fecharBttn;
	}




	public JButton getSairBttn() {
		return sairBttn;
	}




	public JButton getConfirmarResetBttn() {
		return confirmarResetBttn;
	}




	public JButton getCancelarResetBttn() {
		return cancelarResetBttn;
	}




	public JButton getAceitarAltBttn() {
		return aceitarAltBttn;
	}




	public JButton getCancelAltBttn() {
		return cancelAltBttn;
	}




	public JLabel getLogoLabel() {
		return logoLabel;
	}




	public JTextField getNovaSenhaField() {
		return novaSenhaField;
	}




	public JButton getCopiarBttn() {
		return copiarBttn;
	}




	public JPanel getMenuPanel() {
		return menuPanel;
	}




	public JLabel getUsrIDLabel() {
		return usrIDLabel;
	}




	public JLabel getRstSenhaLabel() {
		return rstSenhaLabel;
	}




	public JLabel getNovaSenhaLabel() {
		return novaSenhaLabel;
	}




	public JLabel getLblNewLabel() {
		return lblNewLabel;
	}




	public JPanel getPanelCadUser() {
		return panelCadUser;
	}




	public JRadioButton getCadFuncionario() {
		return cadFuncionario;
	}




	public JTextField getCadNome() {
		return cadNome;
	}




	public JTextField getCadNaturalidade() {
		return cadNaturalidade;
	}




	public JTextField getCadUserName() {
		return cadUserName;
	}




	public JComboBox getCadAdmissDia() {
		return cadAdmissDia;
	}




	public JComboBox getCadNasciDia() {
		return cadNasciDia;
	}




	public JComboBox getCadAdmissMes() {
		return cadAdmissMes;
	}




	public JComboBox getCadNasciMes() {
		return cadNasciMes;
	}




	public JComboBox getCadAdmissAno() {
		return cadAdmissAno;
	}




	public JComboBox getCadNasciAno() {
		return cadNasciAno;
	}




	public JComboBox getCadNumFilhos() {
		return cadNumFilhos;
	}




	public JButton getCadAceitar() {
		return cadAceitar;
	}




	public JButton getCadCancelar() {
		return cadCancelar;
	}




	public JRadioButton getCadContador() {
		return cadContador;
	}




	public JLabel getCadLabelUserName() {
		return cadLabelUserName;
	}




	public JLabel getLabelDadosPessoa() {
		return labelDadosPessoa;
	}




	public JLabel getLblNewLabel_3() {
		return lblNewLabel_3;
	}




	public JLabel getLblNewLabel_4() {
		return lblNewLabel_4;
	}




	public JLabel getLblNewLabel_5() {
		return lblNewLabel_5;
	}




	public ButtonGroup getGroup() {
		return group;
	}




	public JButton getCadBttn() {
		return cadBttn;
	}




	public JButton getProventosBttn() {
		return proventosBttn;
	}




	public JButton getDescontosBttn() {
		return descontosBttn;
	}




	public JButton getFolhaBttn() {
		return folhaBttn;
	}




	public JPanel getPanelProventos() {
		return panelProventos;
	}




	public JTextField getDescOutros() {
		return descOutros;
	}




	public JTextField getDescInssField() {
		return descInssField;
	}




	public JTextField getDesctContratoSindField() {
		return desctContratoSindField;
	}




	public JLabel getLblNewLabel_1_3() {
		return lblNewLabel_1_3;
	}




	public JTextField getDescAddOutros() {
		return descAddOutros;
	}




	public JPanel getPanelDescontos() {
		return panelDescontos;
	}




	public JLabel getLblNewLabel_1_4() {
		return lblNewLabel_1_4;
	}




	public JTextField getDescFaltasField() {
		return descFaltasField;
	}




	public JLabel getLblNewLabel_7() {
		return lblNewLabel_7;
	}




	public JTextField getDescIrffField() {
		return descIrffField;
	}




	public JPanel getPanelFolha() {
		return panelFolha;
	}




	public JLabel getLblNewLabel_1() {
		return lblNewLabel_1;
	}




	public JLabel getLblNewLabel_6() {
		return lblNewLabel_6;
	}




	public JLabel getLblNewLabel_8() {
		return lblNewLabel_8;
	}




	public JLabel getLblNewLabel_9() {
		return lblNewLabel_9;
	}




	public JLabel getLblNewLabel_10() {
		return lblNewLabel_10;
	}




	public JLabel getLblNewLabel_11() {
		return lblNewLabel_11;
	}




	public JLabel getFolhaVencBaseLabel() {
		return folhaVencBaseLabel;
	}




	public JLabel getFolhaVencBrutoLabel() {
		return folhaVencBrutoLabel;
	}




	public JLabel getFolhaSalFamLabel() {
		return folhaSalFamLabel;
	}




	public JLabel getFolhaSalLiqdLabel() {
		return folhaSalLiqdLabel;
	}




	public JLabel getFolhaTotalProventLabel() {
		return folhaTotalProventLabel;
	}




	public JLabel getFolhaTotalDescLabel() {
		return folhaTotalDescLabel;
	}




	public JLabel getLblNewLabel_18() {
		return lblNewLabel_18;
	}




	public JLabel getFolhaNomeLabel() {
		return folhaNomeLabel;
	}




	public JLabel getLblNewLabel_20() {
		return lblNewLabel_20;
	}




	public JLabel getFolhaIDLabel() {
		return folhaIDLabel;
	}




	public JButton getFolhaIDAtualBttn() {
		return folhaIDAtualBttn;
	}




	public JButton getFolhaSairBttn() {
		return folhaSairBttn;
	}




	public JButton getFolhaSelectIDBttn() {
		return folhaSelectIDBttn;
	}




	public JTextField getProventOutros() {
		return proventOutros;
	}




	public JTextField getProventTempoServico() {
		return proventTempoServico;
	}




	public JTextField getProventHoraExtra() {
		return proventHoraExtra;
	}




	public JTextField getProventAddOutros() {
		return proventAddOutros;
	}




	public JTextArea getProventOutrosDesc() {
		return proventOutrosDesc;
	}




	public JComboBox getProventID() {
		return proventID;
	}




	public JButton getProventBuscarID() {
		return proventBuscarID;
	}




	public JButton getProventBuscarIDAtual() {
		return proventBuscarIDAtual;
	}




	public JButton getProventFechar() {
		return proventFechar;
	}




	public JButton getProventaddoutrosBttn() {
		return proventaddoutrosBttn;
	}



	public JButton getDescaddoutrosBttn() {
		return descaddoutrosBttn;
	}




	public JButton getDescFechar() {
		return descFechar;
	}




	public JButton getDescBuscarIDAtual() {
		return descBuscarIDAtual;
	}




	public JButton getDescBuscarID() {
		return descBuscarID;
	}




	public JRadioButton getCadMensalistaRadio() {
		return cadMensalistaRadio;
	}




	public JRadioButton getCadHoristaRadio() {
		return cadHoristaRadio;
	}




	public JComboBox getDescontosID() {
		return descontosID;
	}




	public JComboBox getFolhaIDBox() {
		return folhaIDBox;
	}




	public ButtonGroup getGroup2() {
		return group2;
	}




	public JTextArea getDescOutrosDesc() {
		return descOutrosDesc;
	}




	public JButton getProventosEdit() {
		return proventosEdit;
	}




	public JButton getProventSalvarEditDesc() {
		return proventSalvarEditDesc;
	}




	public JButton getDescSalvarEditOutros() {
		return descSalvarEditOutros;
	}




	public JButton getDescEditar() {
		return descEditar;
	}




	public JPanel getPanelInfoUser() {
		return panelInfoUser;
	}




	public JComboBox getPanelInfoUserIDBox() {
		return panelInfoUserIDBox;
	}




	public JButton getUsrInfoIDAtualBttn() {
		return usrInfoIDAtualBttn;
	}




	public JButton getPanelInfoUserSairBttn() {
		return panelInfoUserSairBttn;
	}




	public JButton getPanelInfoUserSelectIDBttn() {
		return panelInfoUserSelectIDBttn;
	}




	public JTextField getPanelInfoUserNome() {
		return panelInfoUserNome;
	}




	public JTextField getPanelInfoUserDatNasci() {
		return panelInfoUserDatNasci;
	}




	public JTextField getPanelInfoUserNat() {
		return panelInfoUserNat;
	}




	public JTextField getPanelInfoUserDatAdmiss() {
		return panelInfoUserDatAdmiss;
	}




	public JTextField getPanelInfoUserNumFilhos() {
		return panelInfoUserNumFilhos;
	}




	public JTextField getPanelInfoUserCargo() {
		return panelInfoUserCargo;
	}




	public JTextField getPanelInfoUserUsrN() {
		return panelInfoUserUsrN;
	}




	public JButton getInfoBttn() {
		return infoBttn;
	}




	public void setInfoBttn(JButton infoBttn) {
		this.infoBttn = infoBttn;
	}




	public JButton getPanelInfoUserEditbttn() {
		return panelInfoUserEditbttn;
	}




	public void setPanelInfoUserEditbttn(JButton panelInfoUserEditbttn) {
		this.panelInfoUserEditbttn = panelInfoUserEditbttn;
	}




	public JPanel getPanelForms() {
		return panelForms;
	}




	public JButton getFormsRelIndividual() {
		return formsRelIndividual;
	}




	public JButton getFormsAnaliticoBttn() {
		return formsAnaliticoBttn;
	}




	public JButton getFormsSinteticoBttn() {
		return formsSinteticoBttn;
	}




	public JButton getFormsBttn() {
		return formsBttn;
	}




	public JComboBox getFormsUserID() {
		return formsUserID;
	}




	public JLabel getLabelWC1() {
		return labelWC1;
	}




	public JLabel getLabelWC2() {
		return labelWC2;
	}




	public JButton getAltButton() {
		return altButton;
	}




	public JButton getAcessoBttn() {
		return acessoBttn;
	}
}
