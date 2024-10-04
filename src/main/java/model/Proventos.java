package model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "proventos")
public class Proventos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "servico5")
	private double servico5;
	
	@Column(name = "horasExtras")
	private double horasExtras;
	
	@Column(name = "auxilioAlimentar")
	private double auxilioAlimentar;
	
	@Column(name = "outros")
	private double outros;
	
	@Column(name = "outrosDesc")
	private String outrosDesc;
	
	public Proventos() {
		super();
	}
	

	public Proventos(double servico5, double horasExtras, double auxilioAlimentar,
			double outros, String outrosDesc) {
		super();
		
		this.servico5 = servico5;
		this.horasExtras = horasExtras;
		this.auxilioAlimentar = auxilioAlimentar;
		this.outros = outros;
		this.outrosDesc = outrosDesc;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getServico5() {
		return servico5;
	}

	public void setServico5(double servico5) {
		this.servico5 = servico5;
	}

	public double getHorasExtras() {
		return horasExtras;
	}

	public void setHorasExtras(double horasExtras) {
		this.horasExtras = horasExtras;
	}

	public double getAuxilioAlimentar() {
		return auxilioAlimentar;
	}

	public void setAuxilioAlimentar(double auxilioAlimentar) {
		this.auxilioAlimentar = auxilioAlimentar;
	}

	public double getOutros() {
		return outros;
	}

	public void setOutros(double outros) {
		this.outros = outros;
	}

	public String getOutrosDesc() {
		return outrosDesc;
	}

	public void setOutrosDesc(String outrosDesc) {
		this.outrosDesc = outrosDesc;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(auxilioAlimentar);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(horasExtras);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + id;
		temp = Double.doubleToLongBits(outros);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((outrosDesc == null) ? 0 : outrosDesc.hashCode());
		temp = Double.doubleToLongBits(servico5);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Proventos other = (Proventos) obj;
		if (Double.doubleToLongBits(auxilioAlimentar) != Double.doubleToLongBits(other.auxilioAlimentar))
			return false;
		if (Double.doubleToLongBits(horasExtras) != Double.doubleToLongBits(other.horasExtras))
			return false;
		if (id != other.id)
			return false;
		if (Double.doubleToLongBits(outros) != Double.doubleToLongBits(other.outros))
			return false;
		if (outrosDesc == null) {
			if (other.outrosDesc != null)
				return false;
		} else if (!outrosDesc.equals(other.outrosDesc))
			return false;
		if (Double.doubleToLongBits(servico5) != Double.doubleToLongBits(other.servico5))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Proventos [id=" + id + ", servico5=" + servico5 + ", horasExtras=" + horasExtras + ", auxilioAlimentar="
				+ auxilioAlimentar + ", outros=" + outros + ", outrosDesc=" + outrosDesc + "]";
	}

	
	

}
