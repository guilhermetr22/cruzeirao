package cruzeirao.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import cruzeirao.DAO.UserDAO;
import cruzeirao.modelos.User;


public class UserSistemaService implements UserDetailsService{
	
	@Override
	public UserDetails loadUserByUsername(final String login) throws UsernameNotFoundException{
		UserDAO usuarioService = new UserDAO();
		
		User usuario = usuarioService.pesquisarPorUsername(login);
		
		if(usuario != null){
			return new UserSistema(usuario, obtemGruposdoUsuario(usuario));
		}
		throw new UsernameNotFoundException("Usuário Não Encontrado:" + login);
	}
	
	
	private Collection<? extends GrantedAuthority> obtemGruposdoUsuario(User usuario) {
		List<GrantedAuthority> tipos = new ArrayList<>();
		
		tipos.add(new SimpleGrantedAuthority("ROLE_" + usuario.getTipo()));

		return tipos;
	}
}
