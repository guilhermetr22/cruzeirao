package cruzeirao.DAO;

import java.util.HashMap;
import java.util.Map;

import cruzeirao.modelos.Categoria;
import cruzeirao.DAO.GenericDAO;

public class CategoriaDAO extends GenericDAO<Categoria>{
		
		protected Class<Categoria> getClassEentidade(){
			return Categoria.class;
		}
		
		public Categoria pesquisarPorNome(String catName){
			Map<String, Object> parametros = new HashMap<String, Object>();
			parametros.put("nome",catName);
			
			return super.pesquisarUm(Categoria.PESQUISAR_POR_NOME, parametros);
		}
}
