package cruzeirao.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import cruzeirao.modelos.User;
import cruzeirao.service.UserService;

@ManagedBean
@SessionScoped
public class UserMB {
	private User usuario = new User();
	private UserService service = new UserService();
	
	public void salvar()
	{
		service.salvar(usuario);
		usuario = new User();
	}

	public User getUsuario() {
		return usuario;
	}

	public void setUsuario(User usuario) {
		this.usuario = usuario;
	}
	
	public List<User> getUsuarios()
	{
		return service.getUsuarios();
	}
}