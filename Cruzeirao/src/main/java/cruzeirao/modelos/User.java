package cruzeirao.modelos;

import java.io.Serializable;
import java.util.Date;
//import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuarios")
public class User implements Serializable {

	private static final long serialVersionUID = -4115440631798495868L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int IDUser;
	
	private String email;
	private String nome;
	private Date dataNascimento;
	//private List<Equipe> equipes;
	//private List<Inscrito> inscricoes;
	//private List<Campeonato> campeonatos;
	//private Enum tipo;
	private String telefoneFixo;
	private String telefoneMovel;
	private String endereco;
	private String rg;
	private String cpf;
	//private String cref;
	//private Enum sexo;
	private String login;
	private String senha;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
/*	public List<Equipe> getEquipes() {
		return equipes;
	}
	public void setEquipes(List<Equipe> equipes) {
		this.equipes = equipes;
	}
	public List<Inscrito> getInscricoes() {
		return inscricoes;
	}
	public void setInscricoes(List<Inscrito> inscricoes) {
		this.inscricoes = inscricoes;
	}
	public List<Campeonato> getCampeonatos() {
		return campeonatos;
	}
	public void setCampeonatos(List<Campeonato> campeonatos) {
		this.campeonatos = campeonatos;
	}
	public Enum getTipo() {
		return tipo;
	}
	public void setTipo(Enum tipo) {
		this.tipo = tipo;
	}*/
	public String getTelefoneFixo() {
		return telefoneFixo;
	}
	public void setTelefoneFixo(String telefoneFixo) {
		this.telefoneFixo = telefoneFixo;
	}
	public String getTelefoneMovel() {
		return telefoneMovel;
	}
	public void setTelefoneMovel(String telefoneMovel) {
		this.telefoneMovel = telefoneMovel;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
/*	public String getCref() {
		return cref;
	}
	public void setCref(String cref) {
		this.cref = cref;
	}
	public Enum getSexo() {
		return sexo;
	}
	public void setSexo(Enum sexo) {
		this.sexo = sexo;
	}*/
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public int getIDUser() {
		return IDUser;
	}
	public void setIDUser(int iDUser) {
		IDUser = iDUser;
	}
	
	
	
}
