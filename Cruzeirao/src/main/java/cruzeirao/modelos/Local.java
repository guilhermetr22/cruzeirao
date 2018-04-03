package cruzeirao.modelos;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="locais")
@NamedQuery(name = "Local.pesquisarPorNome", query = "select u from Local u where u.nome = :nome")
public class Local implements Serializable{
	
	private static final long serialVersionUID = 3470046527052274113L;
	
	public static final String PESQUISAR_POR_NOME = "Local.pesquisarPorNome";

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id_local;
	
	private String nome;
	private String endereco;
	
	public int getId_local() {
		return id_local;
	}
	public void setId_local(int id_local) {
		this.id_local = id_local;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	
}
