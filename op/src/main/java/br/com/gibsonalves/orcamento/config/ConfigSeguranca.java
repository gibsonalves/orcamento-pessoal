package br.com.gibsonalves.orcamento.config;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.gibsonalves.orcamento.servicos.ServicoAutenticacao;

//import br.com.gibsonalves.orcamento.servicos.ServicoAutenticacao;

@Configuration
@EnableWebSecurity
public class ConfigSeguranca extends WebSecurityConfigurerAdapter {

	@Autowired
	private ServicoAutenticacao servicoAutenticacao;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
		.userDetailsService(servicoAutenticacao)
		.passwordEncoder(encoder());
		//auth.inMemoryAuthentication().withUser("admin").password("admin").roles("PIZZARIA");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	http
		.authorizeRequests()
			.antMatchers().permitAll()
			.antMatchers("/pizzas/**","/ingredientes/**","/categorias/**","/movimentos/**").hasRole("USUARIO")
		.and()
			.formLogin()
				.loginPage("/login")
				.loginProcessingUrl("/autenticar")
				.defaultSuccessUrl("/pizzas")
				.failureUrl("/login?semacesso=true")
				.usernameParameter("usuario")
				.passwordParameter("senha")
			.and()
				.logout()
					.logoutUrl("/sair")
					.logoutSuccessUrl("/login?saiu=true");
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
	
	}
	
	@Bean
	public BCryptPasswordEncoder encoder(){
		return new BCryptPasswordEncoder();
	}
	
	
	public static void main(String[] args) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		System.out.println(encoder.encode("gibson"));
	}
	
}
