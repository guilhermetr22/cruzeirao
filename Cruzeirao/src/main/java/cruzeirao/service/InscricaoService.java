package cruzeirao.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import cruzeirao.modelos.Inscricao;

public class InscricaoService {
	private EntityManagerFactory emf;
	
	public InscricaoService(){
		emf = Persistence.createEntityManagerFactory("Cruzeirao");
	}
	
	public void salvar(Inscricao inscricao){
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
			em.persist(inscricao);
		em.getTransaction().commit();
		em.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Inscricao> getInscricoes(){
		List<Inscricao> inscricoes;
		
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("Select u From Inscricao u");
		inscricoes = q.getResultList();
		em.close();
		return inscricoes; 
	}
	
}
