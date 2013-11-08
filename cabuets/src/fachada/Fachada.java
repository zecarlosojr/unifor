package fachada;

import dao.PessoaDao;
import model.Pessoa;


public class Fachada {
	
	PessoaDao dao = new PessoaDao();
	
	public void incluirPessoa(Pessoa pessoa){
		dao.incluir(pessoa);
	
	}
	
}
