package fachada;

import dao.PessoaDao;
import model.Pessoa;

/**
 * 
 * @author Jos�Carlos
 * Teste de inser��o de asterisco! =]
 *
 */

public class Fachada {
	
	PessoaDao dao = new PessoaDao();
	
	public void incluirPessoa(Pessoa pessoa){
		dao.incluir(pessoa);
	
	}
	
}
