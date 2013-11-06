package model;

import java.util.ArrayList;
/**
 * 
 * @author 1210841 - Dennis Fernandes<br>
 * 		   1213978 - Raul Martins<br>
 * 		   1213854 - José Carlos Oliveira<br>
 * 
 * @version
 * 			<p><b>v1.0 (14/10/2013)</b><br>
 * 				- Criação da classe, atributos e seus metodos get's e set's
 * 			</p>
 */
public class Postagem {
	
	private String mensagem;
	private String data;
	
	
	/**
	 * Construtor de Postagem
	 * @param mensagem
	 * @param data
	 */
	public Postagem(String mensagem, String data) {
		this.mensagem = mensagem;
		this.data = data;
	}
	
	/**
	 * @return the mensagem
	 */
	public String getMensagem() {
		return mensagem;
	}
	
	/**
	 * @param mensagem the mensagem to set
	 */
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	/**
	 * @return the data
	 */
	public String getData() {
		return data;
	}
	
	/**
	 * @param data the data to set
	 */
	public void setData(String data) {
		this.data = data;
	}
	
}
