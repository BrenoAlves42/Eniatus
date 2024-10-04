package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Recursos;

import java.awt.CardLayout;
import java.awt.FlowLayout;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class LoginView extends JFrame {

	private JPanel contentPane;
	private JTextField userNameField;
	private JPasswordField passwordField;
	private JLabel ustNameLabel, lblSenha;
	private JButton entrarBttn, sairBttn;
	private JCheckBox mostrarPsswrd;
	private JPanel panel;
	private JLabel eniLabel;
	private JLabel logoLabel;
	

	
	public LoginView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 370, 506);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		userNameField = new JTextField();
		userNameField.setBounds(31, 251, 283, 20);
		contentPane.add(userNameField);
		userNameField.setColumns(10);
		
		ustNameLabel = new JLabel("Nome de usuário:");
		ustNameLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 16));
		ustNameLabel.setForeground(new Color(0, 0, 0));
		ustNameLabel.setBounds(21, 214, 140, 14);
		contentPane.add(ustNameLabel);
		
		lblSenha = new JLabel("Senha:");
		lblSenha.setForeground(new Color(0, 0, 0));
		lblSenha.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 16));
		lblSenha.setBounds(21, 288, 60, 14);
		contentPane.add(lblSenha);
		
		entrarBttn = new JButton("Entrar");
		entrarBttn.setIcon(null);
		entrarBttn.setForeground(new Color(255, 255, 255));
		entrarBttn.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		entrarBttn.setBackground(new Color(30, 144, 255));
		entrarBttn.setBounds(48, 393, 97, 48);
		contentPane.add(entrarBttn);
		
		sairBttn = new JButton("Sair");
		sairBttn.setIcon(null);
		sairBttn.setBackground(new Color(30, 144, 255));
		sairBttn.setBounds(177, 393, 92, 49);
		contentPane.add(sairBttn);
		
		mostrarPsswrd = new JCheckBox("Mostrar");
		mostrarPsswrd.setBackground(new Color(255, 255, 255));
		mostrarPsswrd.setBounds(228, 318, 97, 23);
		contentPane.add(mostrarPsswrd);
		
		panel = new JPanel();
		panel.setBackground(new Color(30, 144, 255));
		panel.setBounds(0, 0, 358, 161);
		contentPane.add(panel);
		panel.setLayout(null);
		
		eniLabel = new JLabel("Eniatus");
		eniLabel.setBounds(223, 63, 74, 31);
		panel.add(eniLabel);
		eniLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 23));
		eniLabel.setForeground(new Color(255, 255, 255));
		
		logoLabel = new JLabel("New label");
		logoLabel.setIcon(null);
		logoLabel.setBounds(-9, 16, 227, 133);
		panel.add(logoLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(31, 321, 195, 20);
		contentPane.add(passwordField);
		
		setVisible(false);
	}



	public JPanel getContentPane() {
		return contentPane;
	}



	public JTextField getUserNameField() {
		return userNameField;
	}



	public JPasswordField getPasswordField() {
		return passwordField;
	}



	public JButton getEntrarBttn() {
		return entrarBttn;
	}



	public JButton getSairBttn() {
		return sairBttn;
	}



	public JCheckBox getMostrarPsswrd() {
		return mostrarPsswrd;
	}



	public JPanel getPanel() {
		return panel;
	}



	public JLabel getLogoLabel() {
		return logoLabel;
	}
}
