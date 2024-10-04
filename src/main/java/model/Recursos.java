package model;

import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;

public class Recursos {
	
	ImageIcon eniatus, entrar, sair, confirmar, cancelar, resetar, fechar, altSenha, resetSenha, icon, cadUser, proventos, descontos, folha, usrInfo, forms;

	public Recursos() {
		super();
		this.eniatus = new ImageIcon(getClass().getResource("/logo.png"));
		this.entrar  = new ImageIcon(getClass().getResource("/entrar.png"));
		this.sair = new ImageIcon(getClass().getResource("/sair.png"));
		this.confirmar = new ImageIcon(getClass().getResource("/confirmarr.png"));
		this.cancelar = new ImageIcon(getClass().getResource("/cancelarr.png"));
		this.resetar = new ImageIcon(getClass().getResource("/resetar.png"));
		this.fechar =  new ImageIcon(getClass().getResource("/fechar.png"));
		this.altSenha = new ImageIcon(getClass().getResource("/altSenha.png"));
		this.resetSenha = new ImageIcon(getClass().getResource("/resetarSenha.png"));
		this.icon = new ImageIcon(getClass().getResource("/icone.png"));
		this.cadUser = new ImageIcon(getClass().getResource("/cadUser.png"));
		this.proventos = new ImageIcon(getClass().getResource("/proventos.png"));
		this.descontos = new ImageIcon(getClass().getResource("/Descontos.png"));
		this.folha = new ImageIcon(getClass().getResource("/folhaMensal.png"));
		this.usrInfo = new ImageIcon(getClass().getResource("/userInfo.png"));
		this.forms = new ImageIcon(getClass().getResource("/forms.png"));
	}

	public ImageIcon getEniatus() {
		return eniatus;
	}

	public void setEniatus(ImageIcon eniatus) {
		this.eniatus = eniatus;
	}

	public ImageIcon getEntrar() {
		return entrar;
	}

	public void setEntrar(ImageIcon entrar) {
		this.entrar = entrar;
	}

	public ImageIcon getSair() {
		return sair;
	}

	public void setSair(ImageIcon sair) {
		this.sair = sair;
	}

	public ImageIcon getConfirmar() {
		return confirmar;
	}

	public ImageIcon getCancelarr() {
		return cancelar;
	}

	public ImageIcon getResetar() {
		return resetar;
	}

	public ImageIcon getFechar() {
		return fechar;
	}

	public ImageIcon getCancelar() {
		return cancelar;
	}

	public ImageIcon getAltSenha() {
		return altSenha;
	}

	public ImageIcon getResetSenha() {
		return resetSenha;
	}

	public ImageIcon getIcon() {
		return icon;
	}

	public ImageIcon getCadUser() {
		return cadUser;
	}

	public ImageIcon getProventos() {
		return proventos;
	}

	public ImageIcon getDescontos() {
		return descontos;
	}

	public ImageIcon getFolha() {
		return folha;
	}

	public ImageIcon getUsrInfo() {
		return usrInfo;
	}

	public ImageIcon getForms() {
		return forms;
	}



}
