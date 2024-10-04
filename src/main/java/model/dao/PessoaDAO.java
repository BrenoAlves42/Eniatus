package model.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import model.Pessoa;

public class PessoaDAO {

	private EntityManager em; 
	
	
	public PessoaDAO() {
		super();
	}

	public Pessoa find(EntityManagerFactory emf, int id) {
		   try {
	            this.em = emf.createEntityManager(); 
	            
	             Pessoa p = em.find(Pessoa.class, id);
	             return p;
	             
	            
	        } catch (Exception e) {
	            System.out.println("Não encontrou: " + e.getMessage());
	            em.getTransaction().rollback();
	            
	        } finally {
	            em.close(); 
	            
	        }
		   
		   return null;
		   
	    }
	
	
	  public void persist(Pessoa p, EntityManagerFactory emf) {
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
	            
	            Pessoa p = em.find(Pessoa.class, id);
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

	   public void update(EntityManagerFactory emf, int id, String variavel, String valor) {
		   try {
			  
	            this.em = emf.createEntityManager(); 
	            em.getTransaction().begin(); 
	            
	            switch (variavel) {
				case "nome":
					em.find(Pessoa.class, id).setNome(valor);
					break;
				case "datanascimento":
					em.find(Pessoa.class, id).setDataNasci(valor);;
					break;
				case "naturalidade":
					em.find(Pessoa.class, id).setNaturalidade(valor);
					break;
				case "dataadmissao":
					em.find(Pessoa.class, id).setDataAdmissao(valor);
					break;
				case "numfilhos":
					em.find(Pessoa.class, id).setNumFilhos(Integer.parseInt(valor));
					break;
				case "cargo":
					em.find(Pessoa.class, id).setCargo(valor);
					break;
				case "senha":
					em.find(Pessoa.class, id).setSenha(valor);
					break;
				case "username":
					em.find(Pessoa.class, id).setUserName(valor);
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

	   public void updateMerge(EntityManagerFactory emf, Pessoa usuario) {
		   try {
	            this.em = emf.createEntityManager();
	            
	            em.getTransaction().begin(); 		
	            em.merge(usuario);
	            em.getTransaction().commit(); 
	            System.out.println("atualizar: deu certo");
	        } catch (Exception e) {
	            System.out.println("atualizar: deu errado: " + e.getMessage());
	            em.getTransaction().rollback();
	        } finally {
	            em.close(); 
	        }
	    }
	   
	   public ArrayList<Pessoa> findAll(EntityManagerFactory emf) {
		   try {
	            this.em = emf.createEntityManager(); 
	            
	            ArrayList<Pessoa> lista = (ArrayList<Pessoa>) em.createQuery("select p from Pessoa p").getResultList();
	             
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
