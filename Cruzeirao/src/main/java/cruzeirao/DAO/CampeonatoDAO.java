package cruzeirao.DAO;

import java.util.HashMap;
import java.util.Map;

import cruzeirao.modelos.Campeonato;
import cruzeirao.DAO.GenericDAO;

public class CampeonatoDAO extends GenericDAO<Campeonato> {

	protected Class<Campeonato> getClassEentidade(){
		return Campeonato.class;
	}
	
	public Campeonato pesquisarPorNome(String campName){
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("nome",campName);
		
		return super.pesquisarUm(Campeonato.PESQUISAR_POR_NOME, parametros);
	}
}
