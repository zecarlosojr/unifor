package servlet;
//mos
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Request;

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
			
			p.setEmail(request.getParameter("txt_email"));
			p.setSenha(request.getParameter("txt_senha"));
			p.setNome(request.getParameter("txt_nome"));
			p.setSobrenome(request.getParameter("txt_sobrenome"));
			f.incluirPessoa(p);
			
			//PrintWriter msg = response.getWriter();
			//msg.println("<html><head><body><h1>Cadastrado com sucesso!</h1></body></head><html>");
			//msg.close();
			RequestDispatcher rd =  request.getRequestDispatcher("login.html");
			rd.forward(request, response);
			
			
		} catch (Exception e) {
			
		}
		
		
}
}