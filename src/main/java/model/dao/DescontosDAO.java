package model.dao;

import java.math.BigDecimal;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import model.Descontos;
import model.Proventos;

public class DescontosDAO {
	
	private EntityManager em;

	
	public DescontosDAO() {
		
	}
	
	public Descontos find(EntityManagerFactory emf, int id) {
		
		   try {
	            this.em = emf.createEntityManager(); 
	            
	            Descontos d = em.find(Descontos.class, id);
	            return d;
	             
	             
	            
	        } catch (Exception e) {
	            System.out.println("Não encontrou: " + e.getMessage());
	            em.getTransaction().rollback();
	            return null;
	            
	        } finally {
	            em.close(); 
	            
	        }
		   
		   
	    }
	
	  public void persist(Descontos d, EntityManagerFactory emf) {
	        try {
	            this.em = emf.createEntityManager(); 
	            em.getTransaction().begin(); 
	            
	            em.persist(d); 
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
	            
	            Descontos d = em.find(Descontos.class, id);
	            em.remove(d); 
	            
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
				case "inss":
					em.find(Descontos.class, id).setInss(valor);;
					break;
				case "contSindical":
					em.find(Descontos.class, id).setContSindical(valor);;
					break;
				case "faltas":
					em.find(Descontos.class, id).setFaltas(valor);;
					break;
				case "irff":
					em.find(Descontos.class, id).setIrff(valor);;
					break;
				case "outros":
					em.find(Descontos.class, id).setOutros(valor);;
					break;
				case "outrosDesc":
					em.find(Descontos.class, id).setOutrosDesc(outrosDesc);
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
	  
	  public void updateMerge(EntityManagerFactory emf, Descontos d) {
		   try {
	            this.em = emf.createEntityManager(); 
	        
	            em.getTransaction().begin(); 
	            em.merge(d);
	            em.getTransaction().commit(); 
	            System.out.println("atualizar: deu certo");
	        } catch (Exception e) {
	            System.out.println("atualizar: deu errado: " + e.getMessage());
	            em.getTransaction().rollback();
	        } finally {
	            em.close(); 
	        }
	    }

	   public ArrayList<Descontos> findAll(EntityManagerFactory emf) {
		   try {
	            this.em = emf.createEntityManager(); 
	            
	            ArrayList<Descontos> lista = (ArrayList<Descontos>) em.createQuery("select p from Descontos p").getResultList();
	             
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
