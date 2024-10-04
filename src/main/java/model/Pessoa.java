package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Staff")
public class Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String nome;
	private String dataNasci;
	private String naturalidade;
	private String dataAdmissao;
	private int numFilhos;
	private String cargo;
	private String senha;
	private String userName;
	private int id_descontos;
	private int id_proventos;
	private int id_folha;
	
	public Pessoa() {
		super();
	
	}

	public Pessoa(String nome, String dataNasci, String naturalidade, String dataAdmissao, int numFilhos, String cargo,
			String senha, String userName, int id_descontos, int id_proventos, int id_folha) {
		super();
		this.nome = nome;
		this.dataNasci = dataNasci;
		this.naturalidade = naturalidade;
		this.dataAdmissao = dataAdmissao;
		this.numFilhos = numFilhos;
		this.cargo = cargo;
		this.senha = senha;
		this.userName = userName;
		this.id_descontos = id_descontos;
		this.id_proventos = id_proventos;
		this.id_folha = id_folha;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDataNasci() {
		return dataNasci;
	}

	public void setDataNasci(String dataNasci) {
		this.dataNasci = dataNasci;
	}

	public String getNaturalidade() {
		return naturalidade;
	}

	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}

	public String getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(String dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public int getNumFilhos() {
		return numFilhos;
	}

	public void setNumFilhos(int numFilhos) {
		this.numFilhos = numFilhos;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getId_descontos() {
		return id_descontos;
	}

	public void setId_descontos(int id_descontos) {
		this.id_descontos = id_descontos;
	}

	public int getId_proventos() {
		return id_proventos;
	}

	public void setId_proventos(int id_proventos) {
		this.id_proventos = id_proventos;
	}

	public int getId_folha() {
		return id_folha;
	}

	public void setId_folha(int id_folha) {
		this.id_folha = id_folha;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cargo == null) ? 0 : cargo.hashCode());
		result = prime * result + ((dataAdmissao == null) ? 0 : dataAdmissao.hashCode());
		result = prime * result + ((dataNasci == null) ? 0 : dataNasci.hashCode());
		result = prime * result + id;
		result = prime * result + id_descontos;
		result = prime * result + id_folha;
		result = prime * result + id_proventos;
		result = prime * result + ((naturalidade == null) ? 0 : naturalidade.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + numFilhos;
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
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
		Pessoa other = (Pessoa) obj;
		if (cargo == null) {
			if (other.cargo != null)
				return false;
		} else if (!cargo.equals(other.cargo))
			return false;
		if (dataAdmissao == null) {
			if (other.dataAdmissao != null)
				return false;
		} else if (!dataAdmissao.equals(other.dataAdmissao))
			return false;
		if (dataNasci == null) {
			if (other.dataNasci != null)
				return false;
		} else if (!dataNasci.equals(other.dataNasci))
			return false;
		if (id != other.id)
			return false;
		if (id_descontos != other.id_descontos)
			return false;
		if (id_folha != other.id_folha)
			return false;
		if (id_proventos != other.id_proventos)
			return false;
		if (naturalidade == null) {
			if (other.naturalidade != null)
				return false;
		} else if (!naturalidade.equals(other.naturalidade))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (numFilhos != other.numFilhos)
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", nome=" + nome + ", dataNasci=" + dataNasci + ", naturalidade=" + naturalidade
				+ ", dataAdmissao=" + dataAdmissao + ", numFilhos=" + numFilhos + ", cargo=" + cargo + ", senha="
				+ senha + ", userName=" + userName + ", id_descontos=" + id_descontos + ", id_proventos=" + id_proventos
				+ ", id_folha=" + id_folha + "]";
	}
	
	
	
	
}
	
	
	