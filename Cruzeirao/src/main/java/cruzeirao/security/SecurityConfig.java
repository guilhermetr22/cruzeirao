package cruzeirao.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter { 
	
	private static UserDetailsService userService = new UserSistemaService();
	
	public SecurityConfig() {
		 
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.inMemoryAuthentication().withUser("adm").password("{noop}123").roles("ADMIN");
		auth.userDetailsService(userService); 
	}
	   
    protected void configure(HttpSecurity http) throws Exception {
    	
    	//Controle feito pelo JSF
    	http.csrf().disable();
    	    	
    	//Página de acesso negado
        http.exceptionHandling().accessDeniedPage("/acessonegado.xhtml");
        
        //Libera todos os recursos do JSF nas páginas abaixo
        http.authorizeRequests().antMatchers("/javax.faces.resource/**").permitAll();
        http.authorizeRequests().antMatchers("/bemVindo.xhtml").permitAll();
        http.authorizeRequests().antMatchers("/paginas/cadastros/cadUser.xhtml").permitAll();
        
    	//Login
    	http.formLogin().loginPage("/login.xhtml").permitAll()
		.defaultSuccessUrl("/paginas/cadastros/inicio.xhtml", true)
		.failureUrl("/login.xhtml?error=true")
		.usernameParameter("username")
		.passwordParameter("password");
    	
    	//Logout
        http.logout().logoutUrl("/logout")
                     .logoutSuccessUrl("/paginas/cadastros/inicio.xhtml");

        // Todas as requisições para partes internas da aplicação devem ser autenticadas
		http.authorizeRequests().anyRequest().authenticated();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/**");
        web.ignoring().antMatchers("/javax.faces.resource/**");
    }
}
