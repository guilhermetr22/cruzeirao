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
		Query q = em.createQuery("Select u From Campeonato u");
		campeonatos = q.getResultList();
		em.close();
		
		return campeonatos;
	}
	
	public Campeonato getCampeonatooAtual(String name) {

		List<Campeonato> campeonatos = this.getCampeonatos();

		for (Campeonato u : campeonatos) {
			if (u.getNome() == name)
				return u;
		}

		return null;
	}

	public void remover(Campeonato campeonato) {

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();	
			campeonato = em.find(Campeonato.class, campeonato.getIdCampeonato());
			em.remove(campeonato);
		em.getTransaction().commit();	
	    em.close();
		
	}
}