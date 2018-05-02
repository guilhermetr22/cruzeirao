package cruzeirao.beans;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import cruzeirao.modelos.Equipe;
import cruzeirao.modelos.Tipo;
import cruzeirao.modelos.User;
import cruzeirao.service.UserService;

@ManagedBean (name = "UserMB")
@SessionScoped
public class UserMB {
	private User usuario = new User();
	private UserService service = new UserService();
	private Equipe equipe = new Equipe();
	private Date data;
	private Calendar data_cal = new GregorianCalendar();
	
	public String salvar()
	{
		data_cal.setTime(data);
		usuario.setDataNascimento(data_cal);
		
		this.usuario.setTipo(Tipo.COMUM);
		
		service.salvar(usuario);
		usuario = new User();
		
		return "inicio";
	}
	
	public String newJogador()
	{
		
		data_cal.setTime(data);
		usuario.setDataNascimento(data_cal);
		
		service.salvar(usuario);
		equipe.addJogadores(usuario);
		
		usuario = new User();
		
		return "cadJogador";
	}
	
	public String salvarJogador()
	{
		
		data_cal.setTime(data);
		usuario.setDataNascimento(data_cal);
		
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

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
}
