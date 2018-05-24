package cruzeirao.beans;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import cruzeirao.DAO.UserDAO;
import cruzeirao.modelos.Campeonato;
import cruzeirao.modelos.Tipo;
import cruzeirao.modelos.User;
import cruzeirao.service.CampService;
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
	private Calendar inicio_cal = new GregorianCalendar();
	private Calendar fim_cal = new GregorianCalendar();
	private Calendar inicio_insc_cal = new GregorianCalendar();
	private Calendar fim_insc_cal = new GregorianCalendar();
	private Date data_inicio;
	private Date data_fim;
	private Date data_insc_inicio;
	private Date data_insc_fim;
	private Alertas msg = new Alertas();
	
	public String salvar()
	{			
		
		inicio_cal.setTime(data_inicio);
		fim_cal.setTime(data_fim);
		inicio_insc_cal.setTime(data_insc_inicio);
		fim_insc_cal.setTime(data_insc_fim);

		if(inicio_insc_cal.after(fim_insc_cal) == false)
		{
			if(inicio_cal.after(fim_cal) == false)
			{
				
				if(fim_insc_cal.after(inicio_cal) == false)
				{
					userAtual = userDAO.pesquisarPorUsername(userAtual.getUserAtual());
					userAtual.setTipo(Tipo.ORGANIZADOR);
					
					userService.salvarEditado(userAtual);
					
					campeonato.setDataInicioCampeonato(inicio_cal);
					campeonato.setDataFimCampeonato(fim_cal);
					campeonato.setDataInicioInscricao(fim_insc_cal);
					campeonato.setDataFimInscricao(fim_insc_cal);
					
					campService.salvar(campeonato);
					campeonato = new Campeonato();		
					
					return "inicio";
				}
				else {
					msg.exibirErroGrowl("Período de inscrição após início do campeonato!");
					return "cadCampeonato";
				}
				
			}
			
			else {
				msg.exibirErroGrowl("Período do campeonato inválido!");
				
				return "cadCampeonato";
			}
		}
		
		else {
			msg.exibirErroGrowl("Período de inscrições inválido!");
			
			return "cadCampeonato";
		}
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


	public Calendar getInicio_cal() {
		return inicio_cal;
	}


	public void setInicio_cal(Calendar inicio_cal) {
		this.inicio_cal = inicio_cal;
	}


	public Calendar getFim_cal() {
		return fim_cal;
	}


	public void setFim_cal(Calendar fim_cal) {
		this.fim_cal = fim_cal;
	}


	public Calendar getInicio_insc_cal() {
		return inicio_insc_cal;
	}


	public void setInicio_insc_cal(Calendar inicio_insc_cal) {
		this.inicio_insc_cal = inicio_insc_cal;
	}


	public Calendar getFim_insc_cal() {
		return fim_insc_cal;
	}


	public void setFim_insc_cal(Calendar fim_insc_cal) {
		this.fim_insc_cal = fim_insc_cal;
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
