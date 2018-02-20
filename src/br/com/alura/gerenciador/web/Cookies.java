package br.com.alura.gerenciador.web;

import javax.servlet.http.Cookie;

public class Cookies {
	private final Cookie[] cookies;
	
	//Cria um cookie no metodo construtor da class
	public Cookies(Cookie[] cookies) { 
		this.cookies = cookies;
	}
	
	public Cookie buscoUsuarioLogado() { 
		//Se cookie for igual a null usu�rio deslogado e devolve vazio
		if(cookies == null) return null; 
		//Realia uma busca nos cookies para encontrar o usu�rio
		for(Cookie cookie : cookies) { 
			if(cookie.getName().equals("usuario.logado")) {
				
				//sempre adiar 10min para usu�rio logado
				//cookie.setMaxAge(10*60);//10 min
				//resp.addCookie(cookie);
				
				return cookie;
			}
		}
		//Caso n�o tenha nenhum cookie
		return null;
	}
}
