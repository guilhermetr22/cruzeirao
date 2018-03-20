package cruzeirao.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import cruzeirao.modelos.User;

public class UserService {
	
	private EntityManagerFactory emf;
	
	public UserService()
	{
		emf = Persistence.createEntityManagerFactory("Cruzeirao");
	}
	
	public void salvar(User usuario)
	{
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();	
			em.persist(usuario);
		em.getTransaction().commit();	
	    em.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<User> getUsuarios()
	{
		List <User> usuarios;
		
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("Select a From Aluno a");
		usuarios = q.getResultList();
		em.close();
		
		return usuarios;
	}
}
