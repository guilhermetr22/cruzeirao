package cruzeirao.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import cruzeirao.modelos.Campeonato;
import cruzeirao.service.CampService;

@FacesConverter(forClass=Campeonato.class, value="campConverter")
public class NomeCampeonatoConverter implements Converter{
	
	private CampService service = new CampService();
	
	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String nomeCamp) {
		
		if(nomeCamp != null && !nomeCamp.isEmpty()){
			
			for(Campeonato u : service.getCampeonatos())
				if(u.getNome().equals(nomeCamp))
					return u;
		}
		
		return null;
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent uic, Object objetoCamp) {
		if(objetoCamp == null || objetoCamp.equals("")){
			return null;
		} else {
			return ((Campeonato)objetoCamp).getNome();
		}
	}
}

