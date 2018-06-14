package cruzeirao.modelos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;


@Entity
@Table(name="usuarios")
@NamedQuery(name = "User.pesquisarPorLogin", query = "SELECT u FROM User u WHERE u.username = :username")
public class User implements Serializable {

	private static final long serialVersionUID = -4115440631798495868L;
	
	public static final String PESQUISAR_POR_LOGIN = "User.pesquisarPorLogin";

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="IDUser")
	private int IDUser;
	
	@Enumerated(EnumType.STRING)
	@Column(name="Tipo")
	private Tipo tipo;
	
	@Column(name="Nome")
	private String nome;

	@Column(name="RG")
	private String rg;
	
	@Column(name="CPF")
	private String cpf;

	@Column(name="DataNascimento")
	private Calendar dataNascimento = new GregorianCalendar();
	
	@Column(unique=true)
	private String username;
	
	private String senha;
	
	@Column(name="Email")
	private String email;
	
	@Column(name="sexo")
	private String sexo;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Equipe", referencedColumnName="IDEquipe")
	private Equipe equipe;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Campeonato", referencedColumnName="IDCamp")
	private Campeonato campeonato;

	private ArrayList<Convite> convites = new ArrayList<Convite>();
	
	@Column(name="telefoneFixo")
	private String telefoneFixo;
	
	@Column(name="telefoneMovel")
	private String telefoneMovel;
	
	@Column(name="Endereco")
	private String endereco;
	
	
	
	
	

	public int getIDUser() {
		return IDUser;
	}
	public void setIDUser(int iDUser) {
		IDUser = iDUser;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Calendar getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
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
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Tipo getTipo() {
		return tipo;
	}
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
		
	public Equipe getEquipe() {
		return equipe;
	}
	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + IDUser;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		User other = (User) obj;
		if (IDUser != other.IDUser)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return nome;
	}
	
	public String getUserAtual(){
		return (((SecurityContext) SecurityContextHolder.getContext()).getAuthentication().getName());
	}
	
	public ArrayList<Convite> getConvites() {
		return convites;
	}

	public void setConvites(ArrayList<Convite> convites) {
		this.convites = convites;
	}
	
	public void addConvite(Convite c){
		this.convites.add(c);
	}
	public Campeonato getCampeonato() {
		return campeonato;
	}
	public void setCampeonato(Campeonato campeonato) {
		this.campeonato = campeonato;
	}
	public void removeConvite(Convite c){
		this.convites.remove(c);
	}
}
