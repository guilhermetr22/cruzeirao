package cruzeirao.DAO;

import java.util.HashMap;
import java.util.Map;

import cruzeirao.modelos.Categoria;
import cruzeirao.modelos.Convite;

public class ConviteDAO extends GenericDAO<Convite>{
	protected Class<Categoria> getClassEentidade(){
		return Categoria.class;
	}
	
	public Convite pesquisarPorID(int conviteID){
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("nome",conviteID);
		
		return super.pesquisarUm(Convite.PESQUISAR_POR_ID, parametros);
	}
}
