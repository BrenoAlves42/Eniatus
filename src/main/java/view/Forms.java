package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import net.miginfocom.swing.MigLayout;
import java.awt.Component;
import java.awt.Container;

import javax.swing.Box;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Window;

import javax.swing.JTextField;

public class Forms extends JFrame {

	private JPanel contentPane, panel;
	private JLabel lblXNome;
	private JLabel lblX_1nat;
	private JLabel lblX_2id;
	private JLabel lblX_3Cargo;
	private JLabel lblX_4IdFolha;
	private JLabel lblX_5IdProv;
	private JLabel lblX_6IdDesc;
	private JLabel lblX_totalProventos;
	private JLabel lblX_11TotalDescontos;
	private JLabel lblX_13INSS;
	private JLabel lblX_14IRRF;
	private JLabel lblX_15Fam;
	private JLabel lblX_16Liquid;


	public Forms() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(10000, 10000, 802, 612);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(new Color(240, 248, 255));
		panel.setBounds(10, 11, 766, 80);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 18));
		lblNome.setBounds(10, 28, 61, 25);
		panel.add(lblNome);
		
		JLabel lblNaturalidade = new JLabel("Naturalidade:");
		lblNaturalidade.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 18));
		lblNaturalidade.setBounds(10, 55, 118, 25);
		panel.add(lblNaturalidade);
		
		JLabel lblReciboDePagamento = new JLabel("Recibo de pagamento de salário");
		lblReciboDePagamento.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 18));
		lblReciboDePagamento.setBounds(442, 11, 282, 25);
		panel.add(lblReciboDePagamento);
		
		lblXNome = new JLabel("x");
		lblXNome.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 18));
		lblXNome.setBounds(81, 28, 320, 25);
		panel.add(lblXNome);
		
		lblX_1nat = new JLabel("x");
		lblX_1nat.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 18));
		lblX_1nat.setBounds(129, 55, 272, 25);
		panel.add(lblX_1nat);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(240, 248, 255));
		panel_1.setBounds(10, 110, 766, 40);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblIdDoFuncionrio = new JLabel("ID do funcionário:");
		lblIdDoFuncionrio.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 18));
		lblIdDoFuncionrio.setBounds(10, 11, 155, 25);
		panel_1.add(lblIdDoFuncionrio);
		
		JLabel lblCargo = new JLabel("Cargo:");
		lblCargo.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 18));
		lblCargo.setBounds(370, 11, 71, 25);
		panel_1.add(lblCargo);
		
		lblX_2id = new JLabel("x");
		lblX_2id.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 18));
		lblX_2id.setBounds(161, 11, 199, 25);
		panel_1.add(lblX_2id);
		
		lblX_3Cargo = new JLabel("x");
		lblX_3Cargo.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 18));
		lblX_3Cargo.setBounds(429, 11, 306, 25);
		panel_1.add(lblX_3Cargo);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(240, 248, 255));
		panel_2.setBounds(10, 170, 766, 372);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 18));
		lblNewLabel.setBounds(10, 11, 46, 25);
		panel_2.add(lblNewLabel);
		
		JLabel lblDescrio = new JLabel("Descrição");
		lblDescrio.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 18));
		lblDescrio.setBounds(147, 11, 121, 25);
		panel_2.add(lblDescrio);
		
		JLabel lblValor = new JLabel("Valor");
		lblValor.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 18));
		lblValor.setBounds(402, 11, 80, 25);
		panel_2.add(lblValor);
		
		JLabel lblSalrioBase = new JLabel("Salário base");
		lblSalrioBase.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 18));
		lblSalrioBase.setBounds(10, 302, 105, 25);
		panel_2.add(lblSalrioBase);
		
		JLabel lblInss = new JLabel("INSS");
		lblInss.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 18));
		lblInss.setBounds(147, 302, 46, 25);
		panel_2.add(lblInss);
		
		JLabel lblIrrf = new JLabel("IRRF");
		lblIrrf.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 18));
		lblIrrf.setBounds(249, 302, 46, 25);
		panel_2.add(lblIrrf);
		
		JLabel lblSalrioFamilia = new JLabel("Salário familia");
		lblSalrioFamilia.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 18));
		lblSalrioFamilia.setBounds(337, 302, 121, 25);
		panel_2.add(lblSalrioFamilia);
		
		JLabel lblLiquidoAReceber = new JLabel("Liquido a receber:");
		lblLiquidoAReceber.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 18));
		lblLiquidoAReceber.setBounds(509, 334, 162, 25);
		panel_2.add(lblLiquidoAReceber);
		
		lblX_4IdFolha = new JLabel("x");
		lblX_4IdFolha.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 18));
		lblX_4IdFolha.setBounds(10, 47, 46, 25);
		panel_2.add(lblX_4IdFolha);
		
		lblX_5IdProv = new JLabel("x");
		lblX_5IdProv.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 18));
		lblX_5IdProv.setBounds(10, 79, 46, 25);
		panel_2.add(lblX_5IdProv);
		
		lblX_6IdDesc = new JLabel("x");
		lblX_6IdDesc.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 18));
		lblX_6IdDesc.setBounds(10, 111, 46, 25);
		panel_2.add(lblX_6IdDesc);
		
		JLabel lblFolhaDePagamento = new JLabel("Folha de pagamento");
		lblFolhaDePagamento.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 18));
		lblFolhaDePagamento.setBounds(147, 47, 173, 25);
		panel_2.add(lblFolhaDePagamento);
		
		JLabel lblProventos = new JLabel("Proventos");
		lblProventos.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 18));
		lblProventos.setBounds(147, 79, 173, 25);
		panel_2.add(lblProventos);
		
		JLabel lblDescontos = new JLabel("Descontos");
		lblDescontos.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 18));
		lblDescontos.setBounds(147, 111, 173, 25);
		panel_2.add(lblDescontos);
		
		lblX_totalProventos = new JLabel("x");
		lblX_totalProventos.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 18));
		lblX_totalProventos.setBounds(402, 79, 205, 25);
		panel_2.add(lblX_totalProventos);
		
		lblX_11TotalDescontos = new JLabel("x");
		lblX_11TotalDescontos.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 18));
		lblX_11TotalDescontos.setBounds(402, 111, 205, 25);
		panel_2.add(lblX_11TotalDescontos);
		
		JLabel lblX_12Base = new JLabel("1050.00");
		lblX_12Base.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 18));
		lblX_12Base.setBounds(20, 334, 105, 25);
		panel_2.add(lblX_12Base);
		
		lblX_13INSS = new JLabel("x");
		lblX_13INSS.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 18));
		lblX_13INSS.setBounds(147, 334, 69, 25);
		panel_2.add(lblX_13INSS);
		
		lblX_14IRRF = new JLabel("x");
		lblX_14IRRF.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 18));
		lblX_14IRRF.setBounds(249, 334, 71, 25);
		panel_2.add(lblX_14IRRF);
		
		lblX_15Fam = new JLabel("x");
		lblX_15Fam.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 18));
		lblX_15Fam.setBounds(347, 334, 111, 25);
		panel_2.add(lblX_15Fam);
		
		lblX_16Liquid = new JLabel("x");
		lblX_16Liquid.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 18));
		lblX_16Liquid.setBounds(662, 334, 94, 25);
		panel_2.add(lblX_16Liquid);
	}


	public JPanel getContentPane() {
		return contentPane;
	}


	public JLabel getLblXNome() {
		return lblXNome;
	}


	public JLabel getLblX_1nat() {
		return lblX_1nat;
	}


	public JLabel getLblX_2id() {
		return lblX_2id;
	}


	public JLabel getLblX_3Cargo() {
		return lblX_3Cargo;
	}


	public JLabel getLblX_4IdFolha() {
		return lblX_4IdFolha;
	}


	public JLabel getLblX_5IdProv() {
		return lblX_5IdProv;
	}


	public JLabel getLblX_6IdDesc() {
		return lblX_6IdDesc;
	}


	public JLabel getLblX_totalProventos() {
		return lblX_totalProventos;
	}


	public JLabel getLblX_11TotalDescontos() {
		return lblX_11TotalDescontos;
	}


	public JLabel getLblX_13INSS() {
		return lblX_13INSS;
	}


	public JLabel getLblX_14IRRF() {
		return lblX_14IRRF;
	}


	public JLabel getLblX_15Fam() {
		return lblX_15Fam;
	}


	public JLabel getLblX_16Liquid() {
		return lblX_16Liquid;
	}


	public JPanel getPanel() {
		return panel;
	}
}
