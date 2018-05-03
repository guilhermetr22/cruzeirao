package cruzeirao.modelos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import cruzeirao.service.CampService;

@Entity
@Table(name="inscricoes")
@NamedQuery(name = "Inscricao.pesquisarPorNome", query = "select u from Inscricao u where u.equipe.nome = :nome")
public class Inscricao implements Serializable{
	
	private static final long serialVersionUID = -4086207985010677485L;
	public static final String PESQUISAR_POR_NOME = "Inscricao.pesquisarPorNome";
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long IDInsc;
	
	private boolean pagamento;
	private boolean validada;
	
	private List<User> jogadores = new ArrayList<User>();
	
	@ManyToOne
	private Equipe equipe;
	
	@ManyToOne
	private Categoria categoria;
	
	@OneToMany(mappedBy="timeA")
	private List<Partida> partidas = new ArrayList<Partida>();
	
	@Transient
	CampService campService = new CampService();
	
	public Campeonato getCampeonato() {
		for(Campeonato c : campService.getCampeonatos())
		{
			for(Categoria cat : c.getCategorias())
			{
				if(cat.equals(categoria))
				{
					return c;
				}
			}
		}
		return null;
	}
	
	public Inscricao()
	{
		pagamento = false;
		validada = false;
	}

	public Equipe getEquipe() {
		return equipe;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}
	public boolean getPagamento() {
		return pagamento;
	}
	public void setPagamento(boolean pagamento) {
		this.pagamento = pagamento;
	}
	public boolean isValidadas() {
		return validada;
	}
	public void setValidadas(boolean validadas) {
		this.validada = validadas;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public List<Partida> getPartidas() {
		return partidas;
	}
	public void setPartidas(List<Partida> partidas) {
		this.partidas = partidas;
	}
	public void setJogadores(ArrayList<User> jogadores) {
		this.jogadores = jogadores;
	}
	public void addJogador(User u){
		jogadores.add(u);
	}
	public void removeJogador(User u){
		jogadores.remove(u);
	}
	
}
