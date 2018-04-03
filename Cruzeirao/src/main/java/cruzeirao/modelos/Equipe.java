package cruzeirao.modelos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="equipes")
@NamedQuery(name = "Equipe.pesquisarPorNome", query = "select u from Equipe u where u.nome = :nome")
public class Equipe implements Serializable{
	
	private static final long serialVersionUID = 5460457849249703396L;
	
	public static final String PESQUISAR_POR_NOME = "Equipe.pesquisarPorNome";

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id_time;
	
	private String nome;
	
	@Temporal(TemporalType.DATE)
	private Date dataFundacao;
	
	private String cidade;
	
	@OneToOne
	private User diretor;
	
	private ArrayList<Inscrito> inscritos;
	
	public int getId_time() {
		return id_time;
	}
	public void setId_time(int id_time) {
		this.id_time = id_time;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getDataFundacao() {
		return dataFundacao;
	}
	public void setDataFundacao(Date dataFundacao) {
		this.dataFundacao = dataFundacao;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public User getDiretor() {
		return diretor;
	}
	public void setDiretor(User diretor) {
		this.diretor = diretor;
	}

	public List<Inscrito> getInscritos() {
		return inscritos;
	}
	public void addInscritos(Inscrito inscrito) {
		this.inscritos.add(inscrito);
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id_time;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Equipe other = (Equipe) obj;
		if (id_time != other.id_time)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
}
