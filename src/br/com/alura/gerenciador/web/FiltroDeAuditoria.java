package br.com.alura.gerenciador.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import br.com.alura.gerenciador.Usuario;

@WebFilter(urlPatterns = "/*")
public class FiltroDeAuditoria implements Filter{

	@Override
	public void destroy() {	
		//Executado quando o filtro e destruido
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//Cast de ServletRequest para HttpServletRequest 
		HttpServletRequest req = (HttpServletRequest) request;
		String uri = req.getRequestURI();
		System.out.println("Usuario acesso a URI "+uri);
		
		String usuario = getUsuario(req);
		
		//Continuar com a request e response
		System.out.println("Usuário "+usuario+ " acessando a URI "+uri);
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {	
		//Executado quando o filtro e inicializado
	}
	
	//pega o usuário na sessão iniciada
	private String getUsuario(HttpServletRequest req) {
		Usuario usuario = (Usuario) req.getSession().getAttribute("usuario.logado");
		if(usuario == null) return "<deslogado>";
		return usuario.getEmail();
	}
}
