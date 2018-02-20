package br.com.alura.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/logout")
public class Logout extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//m�todos para finalizar uma sess�o
		request.getSession().removeAttribute("usuario.logado");
		//request.getSession().invalidate();
		
		PrintWriter escrever = response.getWriter();
		escrever.println("<html><body>Deslogado com sucesso!</body></html>");
	}
}
