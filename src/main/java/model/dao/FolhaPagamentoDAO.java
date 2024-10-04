package model.dao;

import java.math.BigDecimal;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import model.FolhaPagamento;

public class FolhaPagamentoDAO {

	private EntityManager em;

	public FolhaPagamentoDAO() {
		super();
	
	}
	
	public FolhaPagamento find(EntityManagerFactory emf, int id) {
		
		   try {
	            this.em = emf.createEntityManager(); 
	            
	            FolhaPagamento f = em.find(FolhaPagamento.class, id);
	            return f;
	             
	             
	            
	        } catch (Exception e) {
	            System.out.println("Não encontrou: " + e.getMessage());
	            em.getTransaction().rollback();
	            return null;
	            
	        } finally {
	            em.close(); 
	            
	        }
		   
		   
	    }
	
	  public void persist(FolhaPagamento f, EntityManagerFactory emf) {
	        try {
	            this.em = emf.createEntityManager(); 
	            em.getTransaction().begin(); 
	            
	            em.persist(f); 
	            em.getTransaction().commit(); 
	            
	            System.out.println("persistir: deu certo");
	        } catch (Exception e) {
	            System.out.println("persistir: deu errado: " + e.getMessage());
	            em.getTransaction().rollback();
	        } finally {
	            em.close(); 
	        }
	  }
	  
	  public void remove(EntityManagerFactory emf, int id) {
		   try {
			   	
	            this.em = emf.createEntityManager(); 
	            em.getTransaction().begin(); 
	            
	            FolhaPagamento f = em.find(FolhaPagamento.class, id);
	            em.remove(f); 
	            
	            em.getTransaction().commit(); 
	            System.out.println("remover: deu certo");
	        } catch (Exception e) {
	            System.out.println("remover: deu errado: " + e.getMessage());
	            em.getTransaction().rollback();
	        } finally {
	            em.close(); 
	        }
	    }
	  
	  public void update(EntityManagerFactory emf, int id, String coluna, double valor) {
		   try {
			   	
	            this.em = emf.createEntityManager();
	            em.getTransaction().begin(); 
	            
	            switch (coluna) {
				case "vencBase":
					em.find(FolhaPagamento.class, id).setVencBase(valor);
					break;
				case "totalProventos":
					em.find(FolhaPagamento.class, id).setTotalProvent(valor);
					break;
				case "vencBruto":
					em.find(FolhaPagamento.class, id).setVencBruto(valor);
					break;
				case "totalDescontos":
					em.find(FolhaPagamento.class, id).setTotalDescont(valor);
					break;
				case "salarioFam":
					em.find(FolhaPagamento.class, id).setSalarioFam(valor);
					break;
				case "salarioLiquid":
					em.find(FolhaPagamento.class, id).setSalarioLiquid(valor);
					break;

				default:
					break;
				}
	            
	            em.getTransaction().commit(); 
	            System.out.println("atualizar: deu certo");
	        } catch (Exception e) {
	            System.out.println("atualizar: deu errado: " + e.getMessage());
	            em.getTransaction().rollback();
	        } finally {
	            em.close(); 
	        }
	    }
	  
	  public void updateMerge(EntityManagerFactory emf, FolhaPagamento f) {
		   try {
	            this.em = emf.createEntityManager(); 
	            em.getTransaction().begin(); 
	          
	            em.merge(f);
	            
	            em.getTransaction().commit(); 
	            System.out.println("atualizar: deu certo");
	        } catch (Exception e) {
	            System.out.println("atualizar: deu errado: " + e.getMessage());
	            em.getTransaction().rollback();
	        } finally {
	            em.close(); 
	        }
	    }
	  
	   public ArrayList<FolhaPagamento> findAll(EntityManagerFactory emf) {
		   try {
	            this.em = emf.createEntityManager(); 
	            
	            ArrayList<FolhaPagamento> lista = (ArrayList<FolhaPagamento>) em.createQuery("select p from FolhaPagamento p").getResultList();
	             
	            return lista;
	            
	        } catch (Exception e) {
	            System.out.println("Não encontrou: " + e.getMessage());
	            em.getTransaction().rollback();
	            return null;
	            
	        } finally {
	            em.close(); 
	            
	        }
		  
		   
	    }
}
