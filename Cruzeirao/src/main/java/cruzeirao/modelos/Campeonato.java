package cruzeirao.modelos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
 
@Entity
@Table(name="campeonatos")
@NamedQuery(name = "Campeonato.pesquisarPorNome", query = "select u from Campeonato u where u.nome = :nome")
public class Campeonato implements Serializable{
	
	private static final long serialVersionUID = 8784890467331743479L;

	public static final String PESQUISAR_POR_NOME = "Campeonato.pesquisarPorNome";
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private int idCampeonato;

	@Column(name="Nome")
	private String nome;
	
/*	private List<Local> locais;*/
	
	@OneToMany(mappedBy="campeonato", cascade=CascadeType.ALL)
	private List<Categoria> categorias = new ArrayList<Categoria>();
	
	@Column
	private Calendar dataInicioInscricao;
	@Column
	private Calendar dataFimInscricao;
	@Column
	private Calendar dataInicioCampeonato;
	@Column
	private Calendar dataFimCampeonato;
	
	private double valorTaxa;
	
	private int minJogadores;
	private int maxJogadores;
	
	
	public int getIdCampeonato() {
		return idCampeonato;
	}
	public void setIdCampeonato(int idCampeonato) {
		this.idCampeonato = idCampeonato;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
/*	public List<Local> getLocais() {
		return locais;
	}
	public void setLocais(List<Local> locais) {
		this.locais = locais;
	}*/
	public List<Categoria> getCategorias() {
		return categorias;
	}
	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}
	public void addCategorias(Categoria categoria) {
		categorias.add(categoria);
	}

	public double getValorTaxa() {
		return valorTaxa;
	}
	public void setValorTaxa(double valorTaxa) {
		this.valorTaxa = valorTaxa;
	}
	public int getMinJogadores() {
		return minJogadores;
	}
	public void setMinJogadores(int minJogadores) {
		this.minJogadores = minJogadores;
	}
	public int getMaxJogadores() {
		return maxJogadores;
	}
	public void setMaxJogadores(int maxJogadores) {
		this.maxJogadores = maxJogadores;
	}
	
	public Calendar getDataInicioInscricao() {
		return dataInicioInscricao;
	}
	public void setDataInicioInscricao(Calendar dataInicioInscricao) {
		this.dataInicioInscricao = dataInicioInscricao;
	}
	public Calendar getDataFimInscricao() {
		return dataFimInscricao;
	}
	public void setDataFimInscricao(Calendar dataFimInscricao) {
		this.dataFimInscricao = dataFimInscricao;
	}
	public Calendar getDataInicioCampeonato() {
		return dataInicioCampeonato;
	}
	public void setDataInicioCampeonato(Calendar dataInicioCampeonato) {
		this.dataInicioCampeonato = dataInicioCampeonato;
	}
	public Calendar getDataFimCampeonato() {
		return dataFimCampeonato;
	}
	public void setDataFimCampeonato(Calendar dataFimCampeonato) {
		this.dataFimCampeonato = dataFimCampeonato;
	}
	@Override
	public String toString() {
		return "Campeonato [nome=" + nome + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		Campeonato other = (Campeonato) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
}
