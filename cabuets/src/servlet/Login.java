package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fachada.Fachada;
import model.Pessoa;
/**
 * Classe PessoaDao
 * 
 * @author 1210841 - Dennis Fernandes<br>
 * 		   1213978 - Raul Martins<br>
 * 		   1213854 - José Carlos Oliveira<br>
 * 
 * @version
 * 			<p><b>v1.0 (14/10/2013)</b><br> - 
 * 				- Criação do Sevlet de Login
 * 			</p>
 */

public class Login extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 129509529672956551L;
	
	@Override
	protected void doPost(HttpServletRequest request,
						  HttpServletResponse response)
						  throws ServletException, IOException {
		
		Pessoa p = new Pessoa();
		Fachada f = new Fachada();
		
		p.setEmail(request.getParameter("email_login"));
		p.setSenha(request.getParameter("senha_login"));
		
		if(f.logar(p) == true) {
			Pessoa pessoa = f.consultar(p);
			request.setAttribute("pessoa", pessoa);
			RequestDispatcher rd = request.getRequestDispatcher("pagina_inicial.jsp");
			rd.forward(request, response);
		}else{
			response.sendRedirect("pages_erros/erro_login.html");
		}
		
	}
	
}
