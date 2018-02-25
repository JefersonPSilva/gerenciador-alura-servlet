package br.com.alura.gerenciador.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/fazTudo")
public class FazTudo extends HttpServlet{
	private static final long serialVersionUID = 6626322586019870362L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tarefa = request.getParameter("tarefa");
		
		if(tarefa == null) { 
			throw new IllegalArgumentException("Você esqueceu de passar a tarefa");
		}
		//Pega a string tarefa
		tarefa = "br.com.alura.gerenciador.web." + tarefa;
		try {
			//Pega a class da string tarefa
			Class<?> tipo = Class.forName(tarefa);
			//Interace que representa a instancia da class tarefa
			Tarefa instancia = (Tarefa) tipo.newInstance();
			//Chama o metodo executa
			String pagina = instancia.executa(request, response);
			//Redireciona para a view
			RequestDispatcher dispatcher = request.getRequestDispatcher(pagina);
			dispatcher.forward(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			throw new ServletException(e);
		}
	}
}
