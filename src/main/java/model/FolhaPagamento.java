package model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "folhapagamento")
public class FolhaPagamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private double VencBase;
	private double totalProvent;
	private double vencBruto;
	private double totalDescont;
	private double salarioFam;
	private double salarioLiquid;
	
	public FolhaPagamento() {
		super();
	
	}
	
	

	public FolhaPagamento(double vencBase, double totalProvent, double vencBruto, double totalDescont,
			double salarioFam, double salarioLiquid) {
		super();
		this.id = id;
		VencBase = vencBase;
		this.totalProvent = totalProvent;
		this.vencBruto = vencBruto;
		this.totalDescont = totalDescont;
		this.salarioFam = salarioFam;
		this.salarioLiquid = salarioLiquid;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getVencBase() {
		return VencBase;
	}

	public void setVencBase(double vencBase) {
		VencBase = vencBase;
	}

	public double getTotalProvent() {
		return totalProvent;
	}

	public void setTotalProvent(double totalProvent) {
		this.totalProvent = totalProvent;
	}

	public double getVencBruto() {
		return vencBruto;
	}

	public void setVencBruto(double vencBruto) {
		this.vencBruto = vencBruto;
	}

	public double getTotalDescont() {
		return totalDescont;
	}

	public void setTotalDescont(double totalDescont) {
		this.totalDescont = totalDescont;
	}

	public double getSalarioFam() {
		return salarioFam;
	}

	public void setSalarioFam(double salarioFam) {
		this.salarioFam = salarioFam;
	}

	public double getSalarioLiquid() {
		return salarioLiquid;
	}

	public void setSalarioLiquid(double salarioLiquid) {
		this.salarioLiquid = salarioLiquid;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(VencBase);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + id;
		temp = Double.doubleToLongBits(salarioFam);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(salarioLiquid);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(totalDescont);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(totalProvent);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(vencBruto);
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
		FolhaPagamento other = (FolhaPagamento) obj;
		if (Double.doubleToLongBits(VencBase) != Double.doubleToLongBits(other.VencBase))
			return false;
		if (id != other.id)
			return false;
		if (Double.doubleToLongBits(salarioFam) != Double.doubleToLongBits(other.salarioFam))
			return false;
		if (Double.doubleToLongBits(salarioLiquid) != Double.doubleToLongBits(other.salarioLiquid))
			return false;
		if (Double.doubleToLongBits(totalDescont) != Double.doubleToLongBits(other.totalDescont))
			return false;
		if (Double.doubleToLongBits(totalProvent) != Double.doubleToLongBits(other.totalProvent))
			return false;
		if (Double.doubleToLongBits(vencBruto) != Double.doubleToLongBits(other.vencBruto))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "FolhaPagamento [id=" + id + ", VencBase=" + VencBase + ", totalProvent=" + totalProvent + ", vencBruto="
				+ vencBruto + ", totalDescont=" + totalDescont + ", salarioFam=" + salarioFam + ", salarioLiquid="
				+ salarioLiquid + "]";
	}

	
}