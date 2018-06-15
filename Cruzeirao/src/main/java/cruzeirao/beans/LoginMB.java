package cruzeirao.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

@ManagedBean
@SessionScoped
public class LoginMB {

	private Alertas msg = new Alertas();
	
	public void preRender(){
		HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		
		if("true".equals(request.getParameter("error"))) {
			msg.exibirErroGrowl("Usuário ou senha inválidps");
		}
	}
}
