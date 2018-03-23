package cruzeirao.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import cruzeirao.modelos.Equipe;


public class EquipeService {
	private EntityManagerFactory emf;
	
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
	
	@SuppressWarnings("unchecked")
	public List<Equipe> getEquipes(){
		List<Equipe> equipes;
		
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("Select u From Equipe u");
		equipes = q.getResultList();
		em.close();
		return equipes; 
	}
}
