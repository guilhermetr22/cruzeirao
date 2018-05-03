package cruzeirao.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import cruzeirao.modelos.Campeonato;
import cruzeirao.modelos.Equipe;
import cruzeirao.modelos.Inscricao;
import cruzeirao.service.InscricaoService;

@ManagedBean(name = "InscricaoMB")
@SessionScoped
public class InscricaoMB {
	private Campeonato campeonato = new Campeonato();
	private Equipe equipe = new Equipe();
	private Inscricao inscricao = new Inscricao();
	private InscricaoService service = new InscricaoService();
	
	public String salvar()
	{
		inscricao.setEquipe(equipe);
		
		service.salvar(inscricao);
		inscricao = new Inscricao();
		
		return "inicio";
	}

	public Campeonato getCampeonato() {
		return campeonato;
	}
 
	public void setCampeonato(Campeonato campeonato) {
		this.campeonato = campeonato;
	}

	public Equipe getEquipe() {
		return equipe;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}

	public Inscricao getInscricao() {
		return inscricao;
	}

	public void setInscricao(Inscricao inscricao) {
		this.inscricao = inscricao;
	}

	public InscricaoService getService() {
		return service;
	}

	public void setService(InscricaoService service) {
		this.service = service;
	}
	
	public List<Inscricao> getInscricoes()
	{
		return service.getInscricoes();
	}

	@Override
	public String toString() {
		return "Detalhes [campeonato=" + campeonato + ", equipe=" + equipe + ", inscricao=" + inscricao + "]";
	}
	
	
}
