package cruzeirao.modelos;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="inscricoes")
@NamedQuery(name = "Inscricao.pesquisarPorNome", query = "select u from Inscricao u where u.equipe.nome = :nome")
public class Inscrito implements Serializable{
	
	private static final long serialVersionUID = -6491770205391247735L;
	public static final String PESQUISAR_POR_NOME = "Inscricao.pesquisarPorNome";
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id_inscricao;
	
	private Tipo tipo;
	
	@OneToOne
	private User usuario;
	
	@OneToOne
	private Equipe equipe;
	
	//private Inscricao inscricao;
	
	//private boolean suspensoJogos;
	private boolean valido;
	
	public Tipo getTipo() {
		return tipo;
	}
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	public User getUsuario() {
		return usuario;
	}
	public void setUsuario(User usuario) {
		this.usuario = usuario;
	}
/*	public Inscricao getInscricao() {
		return inscricao;
	}
	public void setInscricao(Inscricao inscricao) {
		this.inscricao = inscricao;
	}
	public boolean isAceiteUsuario() {
		return aceiteUsuario;
	}
	public void setAceiteUsuario(boolean aceiteUsuario) {
		this.aceiteUsuario = aceiteUsuario;
	}
	public boolean isSuspensoJogos() {
		return suspensoJogos;
	}
	public void setSuspensoJogos(boolean suspensoJogos) {
		this.suspensoJogos = suspensoJogos;
	}*/
	public boolean isValido() {
		return valido;
	}
	public void setValido(boolean valido) {
		this.valido = valido;
	}
	
	public Equipe getEquipe() {
		return equipe;
	}
	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}
	
}
