package br.com.alura.gerenciador.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Logout implements Tarefa{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) {
		//m�todos para finalizar uma sess�o
		request.getSession().removeAttribute("usuarioLogado");
		//request.getSession().invalidate();
		//Redireciona o cliente para a p�gina de logout no lado do servidor
		return "/WEB-INF/paginas/logout.html";
	}
}
