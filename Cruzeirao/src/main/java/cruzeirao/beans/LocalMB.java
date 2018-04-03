package cruzeirao.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import cruzeirao.modelos.Local;
import cruzeirao.service.LocalService;

@ManagedBean (name = "LocalMB")
@SessionScoped
public class LocalMB {
	private Local local = new Local();
	private LocalService service =  new LocalService();
	
	public String salvar()
	{
		service.salvar(local);
		local = new Local();
		
		return "inicio";
	}

	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}
	
	public List<Local> getLocais()
	{
		return service.getLocais();
	}
	
}
