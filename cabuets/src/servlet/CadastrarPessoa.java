package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Pessoa;
import fachada.Fachada;


public class CadastrarPessoa extends HttpServlet {

	private static final long serialVersionUID = -2093909544747706671L;

		
	protected void doPost(HttpServletRequest request, 
						  HttpServletResponse response)
						  throws ServletException, IOException {
		
		try {
			
			Fachada f = new Fachada();
			Pessoa p = new Pessoa();
			
			p.setEmail(request.getParameter("email"));
			p.setSenha(request.getParameter("senha"));
			p.setNome(request.getParameter("nome"));
			p.setSobrenome(request.getParameter("sobreNome"));
			p.setDt_nascimento(request.getParameter("dataNascimento"));
			
			f.incluirPessoa(p);
			
			RequestDispatcher rd =  request.getRequestDispatcher("login.html");
			rd.forward(request, response);
			
			
		} catch (Exception e) {
			
		}
		
		
}
}