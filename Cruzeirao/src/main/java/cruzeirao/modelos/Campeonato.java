package cruzeirao.modelos;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import cruzeirao.modelos.Categoria;

@Entity
@Table(name="campeonatos")
public class Campeonato implements Serializable{
	
	private static final long serialVersionUID = 8784890467331743479L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idCampeonato;
	
	private String nome;
	
/*	private List<Local> locais;
	private List<Juiz> juizes;*/
	
	private List<Categoria> categorias;
	
	private Date dataInicioInscricao;
	private Date dataFimInscricao;
	
	private Date dataInicioCampeonato;
	private Date dataFimCampeonato;
	
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
	}
	public List<Juiz> getJuizes() {
		return juizes;
	}
	public void setJuizes(List<Juiz> juizes) {
		this.juizes = juizes;
	}*/
	public List<Categoria> getCategorias() {
		return categorias;
	}
	public void addCategorias(Categoria categoria) {
		this.categorias.add(categoria);
	}
	public Date getDataInicioInscricao() {
		return dataInicioInscricao;
	}
	public void setDataInicioInscricao(Date dataInicioInscricao) {
		this.dataInicioInscricao = dataInicioInscricao;
	}
	public Date getDataFimInscricao() {
		return dataFimInscricao;
	}
	public void setDataFimInscricao(Date dataFimInscricao) {
		this.dataFimInscricao = dataFimInscricao;
	}
	public Date getDataInicioCampeonato() {
		return dataInicioCampeonato;
	}
	public void setDataInicioCampeonato(Date dataInicioCampeonato) {
		this.dataInicioCampeonato = dataInicioCampeonato;
	}
	public Date getDataFimCampeonato() {
		return dataFimCampeonato;
	}
	public void setDataFimCampeonato(Date dataFimCampeonato) {
		this.dataFimCampeonato = dataFimCampeonato;
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
	
	@Override
	public String toString() {
		return "Campeonato [nome=" + nome + "]";
	}
	
	
}
