package model.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;


import model.Proventos;

public class ProventosDAO {

	private EntityManager em; 
	
	
	public ProventosDAO() {
		super();
	}

	public Proventos find(EntityManagerFactory emf, int id) {
		
		   try {
	            this.em = emf.createEntityManager(); 
	            
	             Proventos p = em.find(Proventos.class, id);
	             return p;
	             
	             
	            
	        } catch (Exception e) {
	            System.out.println("Não encontrou: " + e.getMessage());
	            em.getTransaction().rollback();
	            return null;
	            
	        } finally {
	            em.close(); 
	            
	        }
		   
		   
	    }
	
	  public void persist(Proventos p, EntityManagerFactory emf) {
	        try {
	            this.em = emf.createEntityManager(); 
	            em.getTransaction().begin(); 
	            
	            em.persist(p); 
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
	            
	            Proventos p = em.find(Proventos.class, id);
	            em.remove(p); 
	            
	            em.getTransaction().commit(); 
	            System.out.println("remover: deu certo");
	        } catch (Exception e) {
	            System.out.println("remover: deu errado: " + e.getMessage());
	            em.getTransaction().rollback();
	        } finally {
	            em.close(); 
	        }
	    }

	   public void update(EntityManagerFactory emf, int id, String coluna, double valor, String outrosDesc) {
		   try {
			   	
	            this.em = emf.createEntityManager();
	            em.getTransaction().begin(); 
	            
	            switch (coluna) {
				case "servico5":
					em.find(Proventos.class, id).setServico5(valor);
					break;
				case "horasExtras":
					em.find(Proventos.class, id).setHorasExtras(valor);
					break;
				case "auxilioAlimentar":
					em.find(Proventos.class, id).setAuxilioAlimentar(valor);
					break;
				case "outros":
					em.find(Proventos.class, id).setOutros(valor);
					break;
				case "outrosDesc":
					em.find(Proventos.class, id).setOutrosDesc(outrosDesc);
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

	   public void updateMerge(EntityManagerFactory emf, Proventos p) {
		   try {
	            this.em = emf.createEntityManager(); 
	            em.getTransaction().begin(); 
	            
	            em.merge(p);
	            
	            em.getTransaction().commit(); 
	            System.out.println("atualizar: deu certo");
	        } catch (Exception e) {
	            System.out.println("atualizar: deu errado: " + e.getMessage());
	            em.getTransaction().rollback();
	        } finally {
	            em.close(); 
	        }
	    }
	   
	   public ArrayList<Proventos> findAll(EntityManagerFactory emf) {
		   try {
	            this.em = emf.createEntityManager(); 
	            
	            ArrayList<Proventos> lista = (ArrayList<Proventos>) em.createQuery("select p from Proventos p").getResultList();
	             
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
