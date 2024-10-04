package control;

import model.*;
import model.dao.*;

import java.math.BigDecimal;
import java.util.ArrayList;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GenericDAO {

    private EntityManagerFactory emf;
    private PessoaDAO pessoaDAO;
    private ProventosDAO proventosDAO;
    private DescontosDAO descontosDAO;
    private FolhaPagamentoDAO folhaDAO;
    private BackupEntriesDAO bckup;
	private static GenericDAO instance;


    public GenericDAO() { 
    	emf = Persistence.createEntityManagerFactory("Eniatus");; 
    	pessoaDAO = new PessoaDAO();
    	proventosDAO = new ProventosDAO();
    	descontosDAO = new DescontosDAO();
    	folhaDAO = new FolhaPagamentoDAO();
    	bckup = new BackupEntriesDAO();
    }
    
	public static GenericDAO getInstance() {
		if(instance == null) {
			instance = new GenericDAO();
		}
		return instance;
		
	}
		
    public Pessoa pessoaManager(String opcao, Pessoa p, int id, String variavel, String valor) {
            switch (opcao) {
			case "find":
				return pessoaDAO.find(emf, id);
				
			case "persist":
				pessoaDAO.persist(p, emf);
				break;
			case "remove":
				pessoaDAO.remove(emf, id);
				break;
			case "update":
				pessoaDAO.update(emf, id, variavel, valor);
				break;
			case "merge":
				pessoaDAO.updateMerge(emf, p);
				break;
				
			default:
				break;
			}
            return null;
    }
    public ArrayList<Pessoa> pessoaAll(){
    	return pessoaDAO.findAll(emf);
    }
    
    public Proventos proventosManager(String opcao, Proventos p, int id, String coluna, double valor, String outrosDesc) {
        switch (opcao) {
		case "find":
			return proventosDAO.find(emf, id);
		case "persist":
			proventosDAO.persist(p, emf);
			break;
		case "remove":
			proventosDAO.remove(emf, id);
			break;
		case "update":
			proventosDAO.update(emf, id, coluna, valor, outrosDesc);
			break;
		case "merge":
			proventosDAO.updateMerge(emf, p);
			break;

		default:
			return null;
		}
        return null;
    }
    public ArrayList<Proventos> proventosAll(){
    	return proventosDAO.findAll(emf);
    }
    
    public Descontos descontosManager(String opcao, Descontos d, int id, String coluna, double valor, String outrosDesc) {
    	 switch (opcao) {
 		case "find":
 			return descontosDAO.find(emf, id);
 		case "persist":
 			descontosDAO.persist(d, emf);
 			break;
 		case "remove":
 			descontosDAO.remove(emf, id);
 			break;
 		case "update":
 			descontosDAO.update(emf, id, coluna, valor, outrosDesc);
 			break;
 		case "merge":
 			descontosDAO.updateMerge(emf, d);
 			break;

 		default:
 			return null;
 		}
         return null;
    }
    public ArrayList<Descontos> descontosAll(){
    	return descontosDAO.findAll(emf);
    }
    
    public FolhaPagamento folhaManager(String opcao,FolhaPagamento f, int id, String coluna, double valor) {
    	 switch (opcao) {
  		case "find":
  			return folhaDAO.find(emf, id);
  		case "persist":
  			folhaDAO.persist(f, emf);
  			break;
  		case "remove":
  			folhaDAO.remove(emf, id);
  			break;
  		case "update":
  			folhaDAO.update(emf, id, coluna, valor);
  			break;
  		case "merge":
  			folhaDAO.updateMerge(emf, f);
  			break;

  		default:
  			return null;
  		}
          return null;
    }
    public ArrayList<FolhaPagamento> folhaAll(){
    	return folhaDAO.findAll(emf);
    }
    
    public  BackupEntries entryManager(String opcao, int id, int numero, BackupEntries bk) {
    	 switch (opcao) {
   		case "find":
   			return bckup.find(emf, id);
   		case "persist":
   			bckup.persist(bk, emf);
   			break;
   		case "remove":
   			bckup.remove(emf, id);
   			break;
   		case "update":
   			bckup.update(emf, id, numero);
   			break;
   		case "merge":
   			bckup.updateMerge(emf, bk);
   			break;

   		default:
   			return null;
   		}
           return null;
    }
    
    public ArrayList<BackupEntries> bckupAll(){
    	return bckup.findAll(emf);
    }
}
    

    