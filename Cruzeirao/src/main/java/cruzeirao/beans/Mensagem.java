package cruzeirao.beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean (name = "MSG")
public class Mensagem {

    public void SucessoUser() {
        FacesContext context = FacesContext.getCurrentInstance();
         
        context.addMessage(null, new FacesMessage("Sucesso",  "Usuário cadastrado!") );
    }
}
