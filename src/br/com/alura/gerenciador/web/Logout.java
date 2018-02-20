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
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie cookie = new Cookies(req.getCookies()).buscoUsuarioLogado();
		PrintWriter escrever = resp.getWriter();
		if(cookie == null) { 
			escrever.println("<html><body>Usuario não estava logado!</body></html>");
			return;
		}
		//Encerra tempo usuário e desloga
		cookie.setMaxAge(0);
		//Envia como response o tempo do cookie zerado
		resp.addCookie(cookie);
		escrever.println("<html><body>Deslogado com sucesso!</body></html>");
	}
}
