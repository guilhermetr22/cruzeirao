package cruzeirao.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import cruzeirao.modelos.Categoria;
import cruzeirao.modelos.Equipe;
import cruzeirao.modelos.Inscricao;
import cruzeirao.service.CategoriaService;
import cruzeirao.service.EquipeService;

@ManagedBean (name="CategoriaMB")
@SessionScoped
public class CategoriaMB {
	private Categoria categoria = new Categoria();
	private CategoriaService service = new CategoriaService();
	private Equipe equipe = new Equipe();
	private Inscricao inscricao = new Inscricao();
	
	public String salvar()
	{
		service.salvar(categoria);
		categoria = new Categoria();
		return "inicio";
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public List<Categoria> getCategorias()
	{
		return service.getCategorias();
	}

	public Equipe getEquipe() {
		return equipe;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}
	
	public ArrayList<Inscricao> getInscricoes(){
		return equipe.getInscricoes();
	}
	
	public ArrayList<Equipe> getAllTeams(){
		
		EquipeService ts = new EquipeService();
		List<Equipe> times = ts.getEquipes();
		ArrayList<Equipe> times2 = new ArrayList<Equipe>();
		times2.addAll(times);
		
		return times2;
	}
	
	public void setPagamento(Equipe t)
	{
		inscricao.setPagamento(true);
		
		t.addInscricao(inscricao);
		
	}
}
