package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

public class ListarPostagem extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 129509529672956551L;
	
	@Override
	protected void doPost(HttpServletRequest request,
						  HttpServletResponse response)
						  throws ServletException, IOException {
		
		Fachada f = new Fachada();
		HttpSession session = request.getSession();
		Pessoa p = (Pessoa) session.getAttribute("pessoa");
		ArrayList<Pessoa> postagens = new ArrayList<Pessoa>();
		postagens = f.listarPostagem(p);
		
		session.setAttribute("postagens", postagens);
	    RequestDispatcher rd = request.getRequestDispatcher("pagina_inicial.jsp");
		rd.forward(request, response);
		
	}
	
}
