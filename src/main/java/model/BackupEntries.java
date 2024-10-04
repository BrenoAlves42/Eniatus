package model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "backupentries")
public class BackupEntries {

	private int numero;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	
	
	public BackupEntries() {
		super();
		// TODO Auto-generated constructor stub
	}


	public BackupEntries(int numero) {
		super();
		this.numero = numero;
	}

	
	
	
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	
	
}
