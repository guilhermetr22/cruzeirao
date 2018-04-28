package cruzeirao.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import cruzeirao.modelos.Campeonato;
import cruzeirao.modelos.Categoria;
import cruzeirao.modelos.Equipe;
import cruzeirao.modelos.Inscricao;
import cruzeirao.service.CategoriaService;

@ManagedBean (name="CategoriaMB")
@SessionScoped
public class CategoriaMB {
	private Categoria categoria = new Categoria();
	private CategoriaService service = new CategoriaService();
	private Campeonato campeonato = new Campeonato();
	private Equipe equipe = new Equipe();
	private Inscricao inscricao = new Inscricao();
	
	public String salvar()
	{
		service.salvar(categoria);
		categoria.setCampeonato(campeonato);
		campeonato.addCategorias(categoria);
		
		categoria = new Categoria();
		campeonato = new Campeonato();
		
		return "inicio";
	}
	
	public String salvaNewCat()
	{		
		service.salvar(categoria);
		categoria.setCampeonato(campeonato);
		campeonato.addCategorias(categoria);
		categoria = new Categoria();
		
		return "cadCategoria";
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
	
	
}
