package model;

import java.util.ArrayList;


public class Pessoa {

	String email;
	String senha;
	String nome;
	String sobrenome;
	ArrayList<Postagem> postagem;
	ArrayList<Pessoa> relacionamentos;
	
	public Pessoa() {
		this.email = null;
		this.senha = null;
		this.nome = null;
		this.sobrenome = null;
		this.postagem = new ArrayList<Postagem>();
		this.relacionamentos = new ArrayList<Pessoa>();
	}

	
	

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the senha
	 */
	public String getSenha() {
		return senha;
	}
	/**
	 * @param senha the senha to set
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}
	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**
	 * @return the sobrenome
	 */
	public String getSobrenome() {
		return sobrenome;
	}
	/**
	 * @param sobrenome the sobrenome to set
	 */
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	/**
	 * @return the post
	 */

	/**
	 * @return the postagem
	 */
	public ArrayList<Postagem> getPostagem() {
		return postagem;
	}
	
	/**
	 * @param postagem the postagem to set
	 */
	public void setPostagem(ArrayList<Postagem> postagem) {
		this.postagem = postagem;
	}
	
	/**
	 * @return the relacionamentos
	 */
	public ArrayList<Pessoa> getRelacionamentos() {
		return relacionamentos;
	}

	/**
	 * @param relacionamentos the relacionamentos to set
	 */
	public void setRelacionamentos(ArrayList<Pessoa> relacionamentos) {
		this.relacionamentos = relacionamentos;
	}
	
}
