package br.com.alura.gerenciador.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/logout")
public class Logout extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//métodos para finalizar uma sessão
		request.getSession().removeAttribute("usuario.logado");
		//request.getSession().invalidate();
		//Redireciona o cliente para a página de logout no lado do servidor
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/paginas/logout.html");
		dispatcher.forward(request, response);
	}
}
