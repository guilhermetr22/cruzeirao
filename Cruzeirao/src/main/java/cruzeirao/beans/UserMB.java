package cruzeirao.beans;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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
	private User userSelecionado;
	private Alertas msg = new Alertas();
	private Calendar nasc_cal = new GregorianCalendar();
	private Date nasc = new Date();
	private Date hoje_date = new Date();
	private Calendar hoje_cal = new GregorianCalendar();

	public String salvar()
	{
		hoje_cal.setTime(hoje_date);
		
		nasc_cal.setTime(nasc);
		
		if(hoje_cal.after(nasc_cal))
		{
			usuario.setTipo(Tipo.COMUM);
			
			usuario.setDataNascimento(nasc_cal);
			
			service.salvar(usuario);
			usuario = new User();
			
			msg.exibirInfoGrowl("Cadastrado", "Usuário cadastrado!");
			
			return "bemVindo";
		}
		else {
			msg.exibirErroGrowl("Data de nascimento inválida");
			return "cadUser";
		}

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

	public void setUserSelecionado(User userSelecionado) {
		this.userSelecionado = userSelecionado;
	}

	public void remover(User usuario)
	{
		service.remover(usuario);
		usuarios.remove(usuario);
	}

	public Calendar getNasc_cal() {
		return nasc_cal;
	}

	public void setNasc_cal(Calendar nasc_cal) {
		this.nasc_cal = nasc_cal;
	}

	public Date getNasc() {
		return nasc;
	}

	public void setNasc(Date nasc) {
		this.nasc = nasc;
	}
}
