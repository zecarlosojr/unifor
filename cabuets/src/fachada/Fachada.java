package fachada;

import java.util.ArrayList;

import dao.PessoaDao;
import model.Pessoa;

/**
 * 
 * @author 1210841 - Dennis Fernandes <br>
 * 		   1213854 - José Carlos de Oliveira Júnior <br>
 * 		   1213978 - Raul Martins <br>
 * 		   1013808 - Suliany Colares <br>
 * 
 * @version
 * 			<p><b>v1.0 (16/11/2013) - Dennis Fernandes</b><br>
 * 				- Criação do método {@link #incluirPessoa(Pessoa)}<br>
 * 				- Criação do método {@link #logar(Pessoa)}<br>
 * 				- Criação do método {@link #consultar(Pessoa)}<br>
 * 			</p>
 *
 */
public class Fachada {
	
	PessoaDao dao = new PessoaDao();
	
	/**
	 * Método para incluir uma pessoa
	 * 
	 * @param pessoa
	 */
	public void incluirPessoa(Pessoa pessoa){
		dao.incluir(pessoa);
	}
	
	
	
	/**
	 * Método de login que irá verificar
	 * se os emais e senhas são validos.
	 * 
	 * @param pessoa
	 * @return booleano (true or false) 
	 */
	public boolean logar(Pessoa pessoa) {
		Pessoa p = new Pessoa();
		p = dao.consultar(pessoa);
		return ( pessoa.getSenha().equals(p.getSenha()) );
	}
	
	
	
	/**
	 * Método para pegar todos os dados de uma
	 * pessoa.
	 * 
	 * @param pessoa
	 * @return Pessoa populada
	 */
	public Pessoa consultar(Pessoa pessoa) {
		Pessoa p = dao.consultar(pessoa);
		return p;
	}
	
	public ArrayList<Pessoa> listarPostagem(Pessoa pessoa) {
		ArrayList<Pessoa> retorno = dao.listarPostagens(pessoa);
		return retorno;
	}
	
}
