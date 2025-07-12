package com.springboot.security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
public class WebConfigSecurity  extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private ImplementacaoUserDetailsService implementacaoUserDetailsService;
	
	@Override // Configura as solicitações de acesso por Http
	protected void configure(HttpSecurity http) throws Exception {    
	    http.csrf().disable() // Desativa as configurações padrão de memória.
	        .authorizeRequests() // Permite restringir acessos
	        .antMatchers(HttpMethod.GET, "/").permitAll() // Qualquer usuário acessa a página inicial
	        .antMatchers("**/materialize/**").permitAll() // Acesso liberado para recursos do Materialize
	        .antMatchers(HttpMethod.GET, "/cadastropessoa").hasAnyRole("ADMIN") // Protege a página para ADMIN
	        .anyRequest().authenticated() // Qualquer outra requisição precisa estar autenticada
	        .and().formLogin().permitAll() // Permite qualquer usuário acessar a página de login
	        .loginPage("/login") // Define a página de login
	        .defaultSuccessUrl("/cadastropessoa", true) // Após login, redireciona para /cadastropessoa
	        .failureUrl("/login?error=true") // Se falhar, redireciona para /login com erro
	        .and().logout()
	        .logoutSuccessUrl("/login") // Redireciona para a página de login após o logout
	        .invalidateHttpSession(true) // Invalida a sessão
	        .deleteCookies("JSESSIONID"); // Deleta o cookie de sessão
	}

	
	@Override // Cria autenticação do usuário com banco de dados ou em memória
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(implementacaoUserDetailsService)
		.passwordEncoder(new BCryptPasswordEncoder());
		
		
	}
	
	


	
	
	
	@Override
	public void configure(WebSecurity web) throws Exception {
	    web.ignoring()
	        .antMatchers("/materialize/**", "/resources/**", "/static/**");
	}







}
