package cruzeirao.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import cruzeirao.modelos.Equipe;
import cruzeirao.service.EquipeService;



@ManagedBean(name="EquipeMB")
@SessionScoped
public class EquipeMB {
	private Equipe equipe = new Equipe();
	private EquipeService equipeService = new EquipeService();

	public String salvar()
	{
		equipeService.salvar(equipe);
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
	
}


