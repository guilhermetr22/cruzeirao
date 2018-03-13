package cruzeirao.service;

import java.util.ArrayList;
import java.util.List;

import cruzeirao.modelos.Campeonato;

public class CampService {
	private ArrayList <Campeonato> campeonatos = new ArrayList<>();
	
	
	public CampService()
	{
		
	}
	
	public void salvar(Campeonato campeonato)
	{
		campeonatos.add(campeonato);
	}
	
	public List<Campeonato> getCampeonatos()
	{
		return campeonatos;
	}
}
