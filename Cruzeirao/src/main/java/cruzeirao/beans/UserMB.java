package cruzeirao.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import cruzeirao.modelos.Equipe;
import cruzeirao.modelos.Tipo;
import cruzeirao.modelos.User;
import cruzeirao.service.EquipeService;
import cruzeirao.service.UserService;

@ManagedBean (name = "UserMB")
@SessionScoped
public class UserMB {
	private User usuario = new User();
	private UserService service = new UserService();
	private Equipe equipe = new Equipe();
	private EquipeService equipeService = new EquipeService();
	
	public String salvar()
	{
		this.usuario.setTipo(Tipo.COMUM);
		
		service.salvar(usuario);
		usuario = new User();
		
		return "inicio";
	}
	
	public String newJogador()
	{
		service.salvar(usuario);
		this.equipe.addJogadores(usuario);
		
		usuario = new User();
		
		return "cadJogador";
	}
	
	public String salvarJogador()
	{
		service.salvar(usuario);
		equipe.addJogadores(usuario);
		
		usuario = new User();
		equipe = new Equipe();
		
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
		return service.getUsuarios();
	}
}
