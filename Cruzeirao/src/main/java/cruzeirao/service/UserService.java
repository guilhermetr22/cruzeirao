package cruzeirao.service;

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
	
	public User getUsuarioAtual(String name) {

		List<User> users = this.getUsuarios();

		for (User u : users) {
			if (u.getLogin() == name)
				return u;
		}

		return null;
	}
	
	public User salvarEditado(User usuario) {

		User user = null;
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		user = em.merge(usuario);
		em.getTransaction().commit();
		em.close();

		return user;
	}
	
	@SuppressWarnings("unchecked")
	public List<User> getUsuarios()
	{
		List <User> usuarios;
		
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("Select a From User a");
		usuarios = q.getResultList();
		em.close();
		
		return usuarios;
	}
	
	
	public void remover(User usuario) {

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();	
			usuario = em.find(User.class,usuario.getIDUser());
			em.remove(usuario);
		em.getTransaction().commit();	
	    em.close();
		
	}
}
