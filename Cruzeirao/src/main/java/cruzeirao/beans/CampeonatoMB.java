package cruzeirao.beans;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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
	private Categoria categoria = new Categoria();
	private CategoriaService catService = new CategoriaService();
	private Campeonato campSelecionado = new Campeonato();
	private User userAtual = new User();
	private UserService userService = new UserService();
	private UserDAO userDAO = new UserDAO();
	private Date data_inicio;
	private Date data_fim;
	private Date data_insc_inicio;
	private Date data_insc_fim;
	
	public String salvar()
	{
		campeonato.setDataInicioCampeonato(data_inicio);
		campeonato.setDataFimCampeonato(data_fim);
		campeonato.setDataInicioInscricao(data_insc_inicio);
		campeonato.setDataFimInscricao(data_insc_fim);
			
		campService.salvar(campeonato);
		
		return "cadCategoria";
	}
	
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public Campeonato getCampeonato() {
		return campeonato;
	}
	
	public void setCampeonato(Campeonato campeonato) {
		this.campeonato = campeonato;
	}
	
	public List<Campeonato> getCampeonatos()
	{
		return campService.getCampeonatos();
	}

	public Campeonato getCampSelecionado() {
		return campSelecionado;
	}

	public void setCampSelecionado(Campeonato campSelecionado) {
		this.campSelecionado = campSelecionado;
	}

	public Date getData_inicio() {
		return data_inicio;
	}

	public void setData_inicio(Date data_inicio) {
		this.data_inicio = data_inicio;
	}

	public Date getData_fim() {
		return data_fim;
	}

	public void setData_fim(Date data_fim) {
		this.data_fim = data_fim;
	}

	public Date getData_insc_inicio() {
		return data_insc_inicio;
	}

	public void setData_insc_inicio(Date data_insc_inicio) {
		this.data_insc_inicio = data_insc_inicio;
	}

	public Date getData_insc_fim() {
		return data_insc_fim;
	}

	public void setData_insc_fim(Date data_insc_fim) {
		this.data_insc_fim = data_insc_fim;
	}
	
}
