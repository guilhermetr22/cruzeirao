package cruzeirao.service;

import java.util.ArrayList;
import java.util.List;

import cruzeirao.modelos.User;

public class UserService {
	private ArrayList <User> usuarios = new ArrayList<>();
	
	public UserService()
	{
		
	}
	
	public void salvar(User usuario)
	{
		usuarios.add(usuario);
	}
	
	public List<User> getUsuarios()
	{
		return usuarios;
	}
}
