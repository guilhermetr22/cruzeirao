package cruzeirao.DAO;

import java.util.HashMap;
import java.util.Map;

import cruzeirao.modelos.User;

public class UserDAO extends GenericDAO<User> {

	protected Class<User> getClassEentidade(){
		return User.class;
	}
	
	public User pesquisarPorUsername(String userName){
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("username",userName);
		
		return super.pesquisarUm(User.PESQUISAR_POR_LOGIN, parametros);
	}
}
