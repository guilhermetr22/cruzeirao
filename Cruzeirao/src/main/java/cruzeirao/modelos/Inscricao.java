package cruzeirao.modelos;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="inscricoes")
public class Inscricao implements Serializable{
	
	private static final long serialVersionUID = -4086207985010677485L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long numero;
	
	private boolean pagamento;
	private boolean validadas;
	private List<Inscrito> inscritos;
	private Categoria categoria;
	private List<Partida> partidas;
	private Equipe equipe;
	public long getNumero() {
		return numero;
	}
	public void setNumero(long numero) {
		this.numero = numero;
	}
	public boolean isPagamento() {
		return pagamento;
	}
	public void setPagamento(boolean pagamento) {
		this.pagamento = pagamento;
	}
	public boolean isValidadas() {
		return validadas;
	}
	public void setValidadas(boolean validadas) {
		this.validadas = validadas;
	}
	public List<Inscrito> getInscritos() {
		return inscritos;
	}
	public void setInscritos(List<Inscrito> inscritos) {
		this.inscritos = inscritos;
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
	public Equipe getEquipe() {
		return equipe;
	}
	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}
	
	
}
