package cruzeirao.beans;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import cruzeirao.DAO.UserDAO;
import cruzeirao.modelos.Equipe;
import cruzeirao.modelos.Tipo;
import cruzeirao.modelos.User;
import cruzeirao.service.EquipeService;
import cruzeirao.service.UserService;



@ManagedBean(name="EquipeMB")
@SessionScoped
public class EquipeMB {
	private Equipe equipe = new Equipe();
	private EquipeService equipeService = new EquipeService();
	private User userAtual = new User();
	private UserDAO user = new UserDAO();
	private Equipe equipeSelecionada = new Equipe();
	private UserService userService = new UserService();
	private Calendar fund_cal = new GregorianCalendar();
	private Date fund = new Date();

	public String salvar()
	{
		fund_cal.setTime(fund);
		
		equipe.setDataFundacao(fund_cal);
		
		userAtual = user.pesquisarPorUsername(userAtual.getUserAtual());
		equipe.setDiretor(userAtual);
		
		userAtual.setTipo(Tipo.DIRETOR);
		
		equipeService.salvar(equipe);
		userService.salvarEditado(userAtual);
		equipe = new Equipe();
	
		return "inicio";
	}
	
	public List<Equipe> getEquipes(){
		return equipeService.getEquipes();
	}
	
	public Equipe getEquipe() {
		return equipe;
	}
	
	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}

	public Equipe getEquipeSelecionada() {
		return equipeSelecionada;
	}

	public void setEquipeSelecionada(Equipe equipeSelecionada) {
		this.equipeSelecionada = equipeSelecionada;
	}

	public Calendar getFund_cal() {
		return fund_cal;
	}

	public void setFund_cal(Calendar fund_cal) {
		this.fund_cal = fund_cal;
	}

	public Date getFund() {
		return fund;
	}

	public void setFund(Date fund) {
		this.fund = fund;
	}
	
}


