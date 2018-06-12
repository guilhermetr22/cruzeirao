package cruzeirao.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import cruzeirao.modelos.Categoria;
import cruzeirao.modelos.Equipe;

public class CategoriaService {
	private EntityManagerFactory emf;
	
	public CategoriaService()
	{
		emf = Persistence.createEntityManagerFactory("Cruzeirao");
	}
	
	public void salvar(Categoria categoria)
	{
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
			em.persist(categoria);
		em.getTransaction().commit();
		em.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Categoria> getCategorias(){
		List<Categoria> categorias;
		
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("Select u From Categoria u");
		categorias = q.getResultList();
		em.close();
		return categorias; 
	}
	
	@SuppressWarnings("unchecked")
	public List<Equipe> getEquipes(){
		List<Equipe> equipes;
		
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("Select equipes From Categoria u");
		equipes = q.getResultList();
		em.close();
		
		return equipes;
	}
}

