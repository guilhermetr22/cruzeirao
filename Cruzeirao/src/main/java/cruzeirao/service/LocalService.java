package cruzeirao.service;

import java.util.ArrayList;
import java.util.List;

import cruzeirao.modelos.Local;

public class LocalService {
	private ArrayList <Local> locais = new ArrayList<>();
	
	public LocalService()
	{
		
	}
	
	public void salvar(Local local)
	{
		locais.add(local);
	}
	
	public List<Local> getLocais()
	{
		return locais;
	}
}
