package cruzeirao.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import cruzeirao.modelos.Equipe;
import cruzeirao.modelos.Inscricao;
import cruzeirao.modelos.Inscrito;
import cruzeirao.modelos.Tipo;
import cruzeirao.modelos.User;
import cruzeirao.service.InscService;

@ManagedBean(name = "InscMB")
@SessionScoped
public class InscritoMB {
	
	private Inscrito inscrito = new Inscrito();
	private InscService service =  new InscService();
	private Equipe equipe = new Equipe();
	private User usuario = new User();
	private Inscricao inscricao = new Inscricao();
	
	public String salvar()
	{
		inscrito.setEquipe(equipe);
		inscrito.setUsuario(usuario);
		inscrito.getUsuario().setTipo(Tipo.JOGADOR);
		inscrito.addInscricoes(inscricao);
		
		service.salvar(inscrito);
		inscrito = new Inscrito();
		
		return "inicio";
	}

	public Inscrito getInscrito() {
		return inscrito;
	}

	public void setInscrito(Inscrito inscrito) {
		this.inscrito = inscrito;
	}

	public InscService getService() {
		return service;
	}

	public void setService(InscService service) {
		this.service = service;
	}

	public Equipe getEquipe() {
		return equipe;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}
	
	public List<Inscrito> getInscritos()
	{
		return service.getInscritos();
	}

}
