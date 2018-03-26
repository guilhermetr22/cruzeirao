package cruzeirao.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import cruzeirao.modelos.Campeonato;
import cruzeirao.service.CampService;
import cruzeirao.modelos.Categoria;
import cruzeirao.service.CategoriaService;

@ManagedBean (name="CampeonatoMB")
@SessionScoped
public class CampeonatoMB {
	private Campeonato campeonato = new	Campeonato();
	private CampService campService = new CampService();
	private CategoriaService catService = new CategoriaService();
	private Categoria categoria = new Categoria();
	
	public String salvar()
	{
		catService.salvar(categoria);
		campeonato.addCategorias(categoria);
		
		campService.salvar(campeonato);
		
		campeonato = new Campeonato();
		categoria = new Categoria();
		
		return "inicio";
	}
	
	public String salvarCat()
	{		
		catService.salvar(categoria);
		campeonato.addCategorias(categoria);
		categoria = new Categoria();
		
		return "CadCategoria";
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
}
