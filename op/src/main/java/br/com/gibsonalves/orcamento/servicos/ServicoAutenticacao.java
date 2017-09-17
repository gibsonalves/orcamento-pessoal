package br.com.gibsonalves.orcamento.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.gibsonalves.orcamento.entidades.Usuario;
import br.com.gibsonalves.orcamento.repositorios.UsuarioRepositorio;

@Service
public class ServicoAutenticacao implements UserDetailsService {

	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	
	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		return usuarioRepositorio.findOneByLogin(login);
	}

	public Usuario getUsuarioLogado() {
		Authentication autenticado = SecurityContextHolder.getContext().getAuthentication();
		if (autenticado == null)
			throw new AuthenticationCredentialsNotFoundException("Usuário não logado");

		UserDetails usuarioLogado = (UserDetails) autenticado.getPrincipal();
		return usuarioRepositorio.findOneByLogin(usuarioLogado.getUsername());
	}
	
}
