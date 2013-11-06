package fachada;

import dao.PessoaDao;
import model.Pessoa;

/**
 * 
 * @author JoséCarlos
 * Teste de inserção de asterisco! =]
 *
 */

public class Fachada {
	
	PessoaDao dao = new PessoaDao();
	
	public void incluirPessoa(Pessoa pessoa){
		dao.incluir(pessoa);
	
	}
	
}
