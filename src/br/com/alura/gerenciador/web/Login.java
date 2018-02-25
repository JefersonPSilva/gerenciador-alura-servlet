package br.com.alura.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.Usuario;
import br.com.alura.gerenciador.dao.UsuarioDAO;

@WebServlet(urlPatterns="/login")
public class Login extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		
		Usuario usuario = new UsuarioDAO().buscaPorEmailESenha(email, senha);
		
		PrintWriter escrever = response.getWriter();
		//valida��o usu�rio simulado
		if(usuario ==null) {
			escrever.println("<html><body>Usu�rio Inv�lido.</body></html>");
		} else { 
			//Implementa��o de session
			HttpSession session = request.getSession();
			session.setAttribute("usuarioLogado", usuario);
			
			escrever.println("<html><body>Usu�rio logado: "+usuario.getEmail()+"</body></html>");
		}
	}
}
