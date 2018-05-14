package cruzeirao.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

import cruzeirao.modelos.User;

public class UserSistema extends org.springframework.security.core.userdetails.User{
	private static final long serialVersionUID = 2289014715682414218L;
	
	private User usuario;
	
	public UserSistema(User usuario, Collection<? extends GrantedAuthority> tipo) {
		super(usuario.getLogin(), usuario.getSenha(), true, true, true, true, tipo);
		this.usuario = usuario;
	}
	
	public User getUsuario() {
		return usuario;
	}
}
