package cruzeirao.modelos;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="partidas")
@NamedQuery(name = "Partida.pesquisarPorJogoID", query = "select u from Partida u where u.partidaID = :partidaID")
public class Partida implements Serializable {
	
	private static final long serialVersionUID = -3544960264984921955L;

	public static final String PESQUISAR_POR_PARTIDAID = "Partida.pesquisarPorPartidaID";
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int partidaID;
	
	private Calendar data = new GregorianCalendar();
	
	@ManyToOne
	private Inscricao timeA;
	
	@ManyToOne
	private Inscricao timeB;
	
	private Local local;
	private User juiz;
	
	private List<Gol> golsMandantes;
	private List<Gol> golsVisitantes;
	private List<Cartao> cartoesMandante;
	private List<Cartao> cartoesVisitante;
	
	public List<Gol> getGolsMandantes() {
		return golsMandantes;
	}
	public void setGolsMandantes(List<Gol> golsMandantes) {
		this.golsMandantes = golsMandantes;
	}
	public List<Gol> getGolsVisitantes() {
		return golsVisitantes;
	}
	public void setGolsVisitantes(List<Gol> golsVisitantes) {
		this.golsVisitantes = golsVisitantes;
	}
	public List<Cartao> getCartoesMandante() {
		return cartoesMandante;
	}
	public void setCartoesMandante(List<Cartao> cartoesMandante) {
		this.cartoesMandante = cartoesMandante;
	}
	public List<Cartao> getCartoesVisitante() {
		return cartoesVisitante;
	}
	public void setCartoesVisitante(List<Cartao> cartoesVisitante) {
		this.cartoesVisitante = cartoesVisitante;
	}
	public int getPartidaID() {
		return partidaID;
	}
	public void setPartidaID(int partidaID) {
		this.partidaID = partidaID;
	}
	public Calendar getData() {
		return data;
	}
	public void setData(Calendar data) {
		this.data = data;
	}
	public Local getLocal() {
		return local;
	}
	public void setLocal(Local local) {
		this.local = local;
	}
	public User getJuiz() {
		return juiz;
	}
	public void setJuiz(User juiz) {
		this.juiz = juiz;
	}
	
	
	
}
