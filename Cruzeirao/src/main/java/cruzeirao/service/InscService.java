package cruzeirao.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import cruzeirao.modelos.Inscrito;

public class InscService {
	private EntityManagerFactory emf;
	
	public InscService(){
		emf = Persistence.createEntityManagerFactory("Cruzeirao");
	}
	
	public void salvar(Inscrito local){
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
			em.persist(local);
		em.getTransaction().commit();
		em.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Inscrito> getInscritos(){
		List<Inscrito> locais;
		
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("Select u From Inscrito u");
		locais = q.getResultList();
		em.close();
		return locais; 
	}
}
