package cruzeirao.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import cruzeirao.DAO.UserDAO;
import cruzeirao.modelos.Campeonato;
import cruzeirao.modelos.Categoria;
import cruzeirao.modelos.User;
import cruzeirao.service.CampService;
import cruzeirao.service.CategoriaService;
import cruzeirao.service.UserService;

@ManagedBean (name="CampeonatoMB")
@SessionScoped
public class CampeonatoMB {
	private Campeonato campeonato = new	Campeonato();
	private CampService campService = new CampService();
	private List<Campeonato> campeonatos;
	private Campeonato campSelecionado;
	private User userAtual = new User();
	private UserService userService = new UserService();
	private UserDAO userDAO = new UserDAO();
	
	public String salvar()
	{			
		campService.salvar(campeonato);
		campeonato = new Campeonato();
		
		return "inicio";
	}
	
	
	public Campeonato getCampeonato() {
		return campeonato;
	}
	
	public void setCampeonato(Campeonato campeonato) {
		this.campeonato = campeonato;
	}
	
	public List<Campeonato> getCampeonatos()
	{
		if(campeonatos == null)
			campeonatos = campService.getCampeonatos();
		
		return campeonatos;
	}

	public Campeonato getCampSelecionado() {
		return campSelecionado;
	}

	public void setCampSelecionado(Campeonato campSelecionado) {
		this.campSelecionado = campSelecionado;
	}
	
	public void remover(Campeonato campeonato)
	{
		campService.remover(campeonato);
		campeonatos.remove(campeonato);
	}	
}
