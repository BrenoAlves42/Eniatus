package model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "descontos")
public class Descontos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private double inss;
	private double contSindical;
	private double faltas;
	private double irff;
	private double outros;
	private String outrosDesc;
	
	public Descontos() {
		super();
		
	}

	
	public Descontos(double inss, double contSindical, double faltas, double irff,
			double outros, String outrosDesc) {
		super();
		this.id = id;
		this.inss = inss;
		this.contSindical = contSindical;
		this.faltas = faltas;
		this.irff = irff;
		this.outros = outros;
		this.outrosDesc = outrosDesc;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getInss() {
		return inss;
	}

	public void setInss(double inss) {
		this.inss = inss;
	}

	public double getContSindical() {
		return contSindical;
	}

	public void setContSindical(double contSindical) {
		this.contSindical = contSindical;
	}

	public double getFaltas() {
		return faltas;
	}

	public void setFaltas(double faltas) {
		this.faltas = faltas;
	}

	public double getIrff() {
		return irff;
	}

	public void setIrff(double irff) {
		this.irff = irff;
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
		temp = Double.doubleToLongBits(contSindical);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(faltas);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + id;
		temp = Double.doubleToLongBits(inss);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(irff);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(outros);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((outrosDesc == null) ? 0 : outrosDesc.hashCode());
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
		Descontos other = (Descontos) obj;
		if (Double.doubleToLongBits(contSindical) != Double.doubleToLongBits(other.contSindical))
			return false;
		if (Double.doubleToLongBits(faltas) != Double.doubleToLongBits(other.faltas))
			return false;
		if (id != other.id)
			return false;
		if (Double.doubleToLongBits(inss) != Double.doubleToLongBits(other.inss))
			return false;
		if (Double.doubleToLongBits(irff) != Double.doubleToLongBits(other.irff))
			return false;
		if (Double.doubleToLongBits(outros) != Double.doubleToLongBits(other.outros))
			return false;
		if (outrosDesc == null) {
			if (other.outrosDesc != null)
				return false;
		} else if (!outrosDesc.equals(other.outrosDesc))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Descontos [id=" + id + ", inss=" + inss + ", contSindical=" + contSindical + ", faltas=" + faltas
				+ ", irff=" + irff + ", outros=" + outros + ", outrosDesc=" + outrosDesc + "]";
	}

	
	
	
}
