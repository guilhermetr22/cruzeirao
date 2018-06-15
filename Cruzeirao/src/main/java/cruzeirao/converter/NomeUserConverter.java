package cruzeirao.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import cruzeirao.modelos.User;
import cruzeirao.service.UserService;

@FacesConverter(forClass=User.class, value="userConverter")
public class NomeUserConverter implements Converter{
	
	private UserService service = new UserService();
	
	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String nomeUser) {
		
		if(nomeUser != null && !nomeUser.isEmpty()){
			
			for(User u : service.getUsuarios())
				if(u.getNome().equals(nomeUser))
					return u;
		}
		
		return null;
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent uic, Object objetoUser) {
		if(objetoUser == null || objetoUser.equals("")){
			return null;
		} else {
			return ((User)objetoUser).getNome();
		}
	}
}
