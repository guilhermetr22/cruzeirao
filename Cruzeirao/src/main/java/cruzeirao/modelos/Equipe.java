package cruzeirao.modelos;

import java.util.Date;
import java.util.List;

public class Equipe {
	private String nome;
	private Date dataFundacao;
	private String cidade;
	private List<User> diretores;
	
	
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
	public List<User> getDiretores() {
		return diretores;
	}
	public void setDiretores(List<User> diretores) {
		this.diretores = diretores;
	}
	
	
}
