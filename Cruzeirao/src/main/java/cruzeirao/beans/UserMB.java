package cruzeirao.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import cruzeirao.modelos.Tipo;
import cruzeirao.modelos.User;
import cruzeirao.service.UserService;

@ManagedBean (name = "UserMB")
@SessionScoped
public class UserMB {
	private User usuario = new User();
	private List<User> usuarios;
	private UserService service = new UserService();
	private User userSelecionado = new User();
	
	public String salvar()
	{
	
		usuario.setTipo(Tipo.COMUM);
		
		service.salvar(usuario);
		usuario = new User();
		
		return "inicio";
	}

	public User getUsuario() {
		return usuario;
	}

	public void setUsuario(User usuario) {
		this.usuario = usuario;
	}
	
	public List<User> getUsuarios()
	{
		if(usuarios == null)
			usuarios = service.getUsuarios();
		
		return usuarios;
	}

	public User getUserSelecionado() {
		return userSelecionado;
	}

	public void remover(User usuario)
	{
		service.remover(usuario);
		usuarios.remove(usuario);
	}	
}
