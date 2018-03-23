package cruzeirao.modelos;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="equipes")
public class Equipe implements Serializable{
	
	private static final long serialVersionUID = 5460457849249703396L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id_time;
	
	private String nome;
	
	private Date dataFundacao;
	private String cidade;
	private User diretor;
	
	
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

	
	
	
}
