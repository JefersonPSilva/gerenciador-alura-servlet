package br.com.alura.gerenciador.web;

import javax.servlet.http.Cookie;

public class Cookies {
	private final Cookie[] cookies;
	
	//Cria um cookie no metodo construtor da class
	public Cookies(Cookie[] cookies) { 
		this.cookies = cookies;
	}
	
	public Cookie buscoUsuarioLogado() { 
		//Se cookie for igual a null usuário deslogado e devolve vazio
		if(cookies == null) return null; 
		//Realia uma busca nos cookies para encontrar o usuário
		for(Cookie cookie : cookies) { 
			if(cookie.getName().equals("usuario.logado")) {
				
				//sempre adiar 10min para usuário logado
				//cookie.setMaxAge(10*60);//10 min
				//resp.addCookie(cookie);
				
				return cookie;
			}
		}
		//Caso não tenha nenhum cookie
		return null;
	}
}
