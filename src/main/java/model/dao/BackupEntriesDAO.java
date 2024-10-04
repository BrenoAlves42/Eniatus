package model.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import model.BackupEntries;
import model.Pessoa;

public class BackupEntriesDAO {
	
	private EntityManager em;

	public BackupEntriesDAO() {
		super();
		// TODO Auto-generated constructor stub
	} 
	
	public BackupEntries find(EntityManagerFactory emf, int id) {
		   try {
	            this.em = emf.createEntityManager(); 
	            
	            BackupEntries b = em.find(BackupEntries.class, id);
	             return b;
	             
	            
	        } catch (Exception e) {
	            System.out.println("Não encontrou: " + e.getMessage());
	            em.getTransaction().rollback();
	            
	        } finally {
	            em.close(); 
	            
	        }
		   
		   return null;
		   
	    }
	
	  public void persist(BackupEntries b, EntityManagerFactory emf) {
	        try {
	            this.em = emf.createEntityManager(); 
	            em.getTransaction().begin(); 
	            
	            em.persist(b); 
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
	            
	            BackupEntries b = em.find(BackupEntries.class, id);
	            em.remove(b); 
	            
	            em.getTransaction().commit(); 
	            System.out.println("remover: deu certo");
	        } catch (Exception e) {
	            System.out.println("remover: deu errado: " + e.getMessage());
	            em.getTransaction().rollback();
	        } finally {
	            em.close(); 
	        }
	    }
	  
	  public void update(EntityManagerFactory emf, int id, int numero) {
		   try {
			  
	            this.em = emf.createEntityManager(); 
	            em.getTransaction().begin(); 
	            
	           em.find(BackupEntries.class, id).setNumero(numero);
	            
	            em.getTransaction().commit(); 
	            System.out.println("atualizar: deu certo");
	        } catch (Exception e) {
	            System.out.println("atualizar: deu errado: " + e.getMessage());
	            em.getTransaction().rollback();
	        } finally {
	            em.close(); 
	        }
	    }
	  

	   public void updateMerge(EntityManagerFactory emf, BackupEntries entry) {
		   try {
	            this.em = emf.createEntityManager();
	            
	            em.getTransaction().begin(); 		
	            em.merge(entry);
	            em.getTransaction().commit(); 
	            System.out.println("atualizar: deu certo");
	        } catch (Exception e) {
	            System.out.println("atualizar: deu errado: " + e.getMessage());
	            em.getTransaction().rollback();
	        } finally {
	            em.close(); 
	        }
	    }
	   
	   public ArrayList<BackupEntries> findAll(EntityManagerFactory emf) {
		   try {
	            this.em = emf.createEntityManager(); 
	            
	            ArrayList<BackupEntries> lista = (ArrayList<BackupEntries>) em.createQuery("select b from BackupEntries b").getResultList();
	             
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
