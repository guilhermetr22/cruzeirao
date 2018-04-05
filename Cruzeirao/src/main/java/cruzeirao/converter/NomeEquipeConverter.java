package cruzeirao.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import cruzeirao.modelos.Equipe;
import cruzeirao.service.EquipeService;

@FacesConverter(forClass=Equipe.class, value="timeConverter")
public class NomeEquipeConverter implements Converter {
	private EquipeService service = new EquipeService();
	
	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String nomeEquipe) {
		
		if(nomeEquipe != null && !nomeEquipe.isEmpty()){
			
			for(Equipe u : service.getEquipes())
				if(u.getNome().equals(nomeEquipe))
					return u;
		}
		
		return null;
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent uic, Object objetoEquipe) {
		if(objetoEquipe == null || objetoEquipe.equals("")){
			return null;
		} else {
			return ((Equipe)objetoEquipe).getNome();
		}
	}
}

