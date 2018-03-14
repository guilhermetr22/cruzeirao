package cruzeirao.service;

import java.util.ArrayList;
import java.util.List;

import cruzeirao.modelos.Categoria;

public class CategoriaService {
private ArrayList <Categoria> categorias = new ArrayList<>();
	
	
	public CategoriaService()
	{
		
	}
	
	public void salvar(Categoria categoria)
	{
		categorias.add(categoria);
	}
	
	public List<Categoria> getCategorias()
	{
		return categorias;
	}
}
