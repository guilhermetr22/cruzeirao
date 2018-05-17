package cruzeirao.beans;

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

	public String salvar()
	{
		userAtual = user.pesquisarPorUsername(userAtual.getUserAtual());
		equipe.setDiretor(userAtual);
		userAtual.setTipo(Tipo.DIRETOR);
		
		equipeService.salvar(equipe);
		userService.salvarEditado(userAtual);
		equipe = new Equipe();
	
		return "inicio";
	}
	
	public String salvarJogador()
	{
		
		equipeService.salvar(equipe);
		equipe = new Equipe();
	
		return "cadUser";
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
	
}


