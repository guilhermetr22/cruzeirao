package cruzeirao.modelos;

import java.util.Calendar;
import java.util.List;

public class Fase {
	private Calendar dataInicio;
	private Calendar dataFim;
	private TipoFase formato;
	private Categoria categoria;
	private List<Grupo> grupos;
	private int numero;
	
	public Calendar getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(Calendar dataInicio) {
		this.dataInicio = dataInicio;
	}
	public Calendar getDataFim() {
		return dataFim;
	}
	public void setDataFim(Calendar dataFim) {
		this.dataFim = dataFim;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public List<Grupo> getGrupos() {
		return grupos;
	}
	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public TipoFase getFormato() {
		return formato;
	}
	public void setFormato(TipoFase formato) {
		this.formato = formato;
	}
	
}
