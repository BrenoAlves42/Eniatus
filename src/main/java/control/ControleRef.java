package control;

import java.math.BigDecimal;

import model.Referencia;

public class ControleRef {

	private Referencia ref;

	public ControleRef(int tempoServico, String contrat, int salarioBruto, int numFilhos) {
		super();
		
		ref  = new Referencia(tempoServico, contrat, 0, salarioBruto, numFilhos);

	}
	
	public double tempoServico() {
		if(ref.getTempoServico() >= 5) {
			double porcento = (5.0 * ref.getSalarioBruto()) / 100.0;
			return porcento;
		}
		return 0;
	}
	
	public double horaExtra() {
		double valor = 0;
		if(ref.getHorasExtras() > 0) {
			int cont = ref.getHorasExtras();
			for(int i = 0; i <= cont; i++) {
				
				double porcento = ( 5.0 * 50.0 ) / 100.0;
				valor = valor + porcento;
			}
		}
		return valor;
		
	}
	
	public double inss() {
		double porcento = 0;
		if(ref.getSalarioBruto() <= 1045) {
			porcento = (7.5 * ref.getSalarioBruto()) / 100.0;
		}
		else if(ref.getSalarioBruto() <= 2089) {
			porcento = (9.0 * ref.getSalarioBruto()) / 100.0;
		}
		else if(ref.getSalarioBruto() <= 3134) {
			porcento = (12.0 * ref.getSalarioBruto()) / 100.0;
		}
		else if(ref.getSalarioBruto() <= 6101) {
			porcento = (14.0 * ref.getSalarioBruto()) / 100.0;
		}
		
		return porcento;
	}
	
	public double irrf() {
		double porcento = 0;
		if(ref.getSalarioBruto() <= 1903) {
			porcento = 0;
		}
		else if(ref.getSalarioBruto() <= 2826) {
			porcento = ((7.5 * ref.getSalarioBruto()) / 100.0) - 142.8;
		}
		else if(ref.getSalarioBruto() <= 3751) {
			porcento = ((15.0 * ref.getSalarioBruto()) / 100.0) - 354.8;
		}
		else if(ref.getSalarioBruto() <= 4664) {
			porcento = ((22.5 * ref.getSalarioBruto()) / 100.0) - 636.13;
		}
		
		else if(ref.getSalarioBruto() > 4664) {
			porcento = ((27.5 * ref.getSalarioBruto()) / 100.0) - 869.36;
		}
		
		return porcento;
	}
	
	public double valorFilhos() {
		double valor = 0;
		if(ref.getSalarioBruto() <= 1425) {
			int quant = ref.getNumFilhos();
			if(quant > 0) {
				for(int i = 0; i <= quant; i++) {
					valor = valor + 48.62;
				}
			}
		}
		return valor;
	}
	
}
