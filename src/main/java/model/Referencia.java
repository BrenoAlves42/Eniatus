package model;

import java.math.BigDecimal;

public class Referencia {

	
	
	private int tempoServico;
	private String contrat;
	private int horasExtras;
	private int salarioBruto;
	private int numFilhos;
	
	public Referencia(int tempoServico, String contrat, int horasExtras, int salarioBruto, int numFilhos) {
		super();
		this.tempoServico = tempoServico;
		this.contrat = contrat;
		this.horasExtras = horasExtras;
		this.salarioBruto = salarioBruto;
		this.numFilhos = numFilhos;
	}
	
	public Referencia() {
		super();
		
	}

	public int getTempoServico() {
		return tempoServico;
	}
	public String getContrat() {
		return contrat;
	}
	public int getHorasExtras() {
		return horasExtras;
	}
	public int getSalarioBruto() {
		return salarioBruto;
	}
	public int getNumFilhos() {
		return numFilhos;
	}
	
	
}
