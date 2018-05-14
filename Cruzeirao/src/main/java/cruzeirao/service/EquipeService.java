package cruzeirao.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import cruzeirao.modelos.Equipe;

public class EquipeService {
	private static EntityManagerFactory emf;
	
	public EquipeService(){
		emf = Persistence.createEntityManagerFactory("Cruzeirao");
	}
	
	public void salvar(Equipe equipe){
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
			em.persist(equipe);
		em.getTransaction().commit();
		em.close();
	}
	
	public void remove(Equipe time) {
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
			Equipe time2 = em.merge(time);
			em.remove(time2);
		em.getTransaction().commit();
		em.close();
	}
	
	public Equipe salvarEditado(Equipe t) {

		Equipe time = null;
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
			time = em.merge(t);
		em.getTransaction().commit();
		em.close();
		
		return time;
	}
	
	@SuppressWarnings("unchecked")
	public static List<Equipe> getEquipes(){
		List<Equipe> equipes;
		
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("Select u From Equipe u");
		equipes = q.getResultList();
		em.close();
		return equipes; 
	}
}
