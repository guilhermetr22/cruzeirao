package cruzeirao.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import cruzeirao.modelos.Campeonato;
import cruzeirao.modelos.Categoria;
import cruzeirao.service.CategoriaService;

@ManagedBean (name="CategoriaMB")
@SessionScoped
public class CategoriaMB {
	private Categoria categoria = new Categoria();
	private CategoriaService service = new CategoriaService();
	private Campeonato campeonato = new Campeonato();
	
	public void salvar()
	{
		service.salvar(categoria);
		campeonato.addCategorias(categoria);
		categoria = new Categoria();
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
}
