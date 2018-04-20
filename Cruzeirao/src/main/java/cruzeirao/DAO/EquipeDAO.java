package cruzeirao.DAO;

import java.util.HashMap;
import java.util.Map;

import cruzeirao.modelos.Equipe;

public class EquipeDAO extends GenericDAO<Equipe>{
	
	protected Class<Equipe> getClassEentidade(){
		return Equipe.class;
	}
	
	public Equipe pesquisarPorNome(String equipeName){
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("nome",equipeName);
		
		return super.pesquisarUm(Equipe.PESQUISAR_POR_NOME, parametros);
	}
}