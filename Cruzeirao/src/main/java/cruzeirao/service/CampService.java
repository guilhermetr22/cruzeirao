 	package cruzeirao.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import cruzeirao.modelos.Campeonato;

public class CampService {
	
	private EntityManagerFactory emf;
	
	public CampService()
	{
		emf = Persistence.createEntityManagerFactory("Cruzeirao");
	}
	
	public void salvar(Campeonato campeonato)
	{
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();	
			em.persist(campeonato);
		em.getTransaction().commit();	
	    em.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Campeonato> getCampeonatos()
	{
		List <Campeonato> campeonatos;
		
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("Select a From Campeonato a");
		campeonatos = q.getResultList();
		em.close();
		
		return campeonatos;
	}
}
