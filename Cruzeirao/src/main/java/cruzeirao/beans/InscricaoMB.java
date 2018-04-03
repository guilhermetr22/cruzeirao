package cruzeirao.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import cruzeirao.modelos.Campeonato;
import cruzeirao.modelos.Equipe;
import cruzeirao.modelos.Inscricao;
import cruzeirao.service.InscricaoService;

@ManagedBean(name = "InscritoMB")
@SessionScoped
public class InscricaoMB {
	private Campeonato campeonato = new Campeonato();
	private Equipe equipe = new Equipe();
	private Inscricao inscricao = new Inscricao();
	private InscricaoService service = new InscricaoService();
	
	public String salvar()
	{
		inscricao.setCampeonato(campeonato);
		inscricao.setEquipe(equipe);
		
		service.salvar(inscricao);
		inscricao = new Inscricao();
		
		return "inicio";
	}
}
