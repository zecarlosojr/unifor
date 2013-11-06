package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import persistencia.BD;
import model.Pessoa;
import model.Postagem;

/**
 * Classe teste XPTO - TESTE DO TESTE
 * 
 * @author 1210841 - Dennis Fernandes<br>
 * 		   1213978 - Raul Martins<br>
 * 		   1213854 - José Carlos Oliveira<br>
 * 
 * @version
 * 			<p><b>v1.0 (14/10/2013)</b><br>
 * 				-{@link #consultar(String)}
 * 			</p>
 */
public class PessoaDao {
	
	public Pessoa consultar(String email) {
		
		String sql_pessoas = "SELECT email, senha, nome, sobrenome"
						+ " FROM pessoas"
						+ " WHERE email ='" + email + "'";
		
		String sql_postagens = "SELECT mensagem, data"
						+ " FROM Postagens"
						+ " WHERE email = '" + email + "'"
						+ " ORDER BY data DESC";
		
		String sql_relacionamentos = "SELECT p.email, p.senha, p.nome, p.sobrenome"
						+ " FROM pessoas AS p"
						+ " INNER JOIN relacionamentos AS r ON p.email = r.email_amigo"
						+ " WHERE r.email = '" + email + "'";
						
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		conn = BD.getConn();
		Pessoa pessoa = new Pessoa();
		

		try {
			/* Recupera as informações básicas de uma Pessoa */
			stmt = conn.prepareStatement(sql_pessoas);
			rs = stmt.executeQuery();
			
			while(rs.next()){
				
				pessoa.setEmail( rs.getString("email") );
				pessoa.setSenha( rs.getString("senha") );
				pessoa.setNome( rs.getString("nome") );
				pessoa.setSobrenome( rs.getString("sobrenome") );
			}
			stmt.close();
			rs.close();
			
			/* Recupera as postagens de uma Pessoa */
			stmt = conn.prepareStatement(sql_postagens);
			rs = stmt.executeQuery();
			
			while(rs.next()){
				pessoa.getPostagem().add(new Postagem(rs.getString("mensagem"), rs.getString("data")));
			}
			stmt.close();
			rs.close();
			
			/* Recupera os amigos de uma Pessoa */
			stmt = conn.prepareStatement(sql_relacionamentos);
			rs = stmt.executeQuery();
			
			while(rs.next()){
				Pessoa amigo = new Pessoa();
				amigo.setEmail( rs.getString("email") );
				amigo.setSenha( rs.getString("senha") );
				amigo.setNome( rs.getString("nome") );
				amigo.setSobrenome( rs.getString("sobrenome") );
				pessoa.getRelacionamentos().add(amigo);
			}
			
			for ( Pessoa amigo : pessoa.getRelacionamentos() ) {
				String sql_post_amigo = "SELECT mensagem, data"
						+ " FROM Postagens"
						+ " WHERE email = '" + amigo.getEmail().toString() + "'"
						+ " ORDER BY data DESC";
				
				/* Recupera as postagens de um Amigo de uma Pessoa */
				stmt = conn.prepareStatement(sql_post_amigo);
				rs = stmt.executeQuery();
				
				while(rs.next()){
					amigo.getPostagem().add(new Postagem(rs.getString("mensagem"), rs.getString("data")));
				}
				stmt.close();
				rs.close();
				conn.close();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return pessoa;
		
	}
	
	
	public void incluir(Pessoa pessoa) {
		String sql = "INSERT INTO pessoas(email, senha, nome, sobrenome)"
				+ " VALUES(?,?,?,?)";
		
		Connection conn = BD.getConn();
		PreparedStatement stmt = null;
		
		try {
			stmt = conn.prepareStatement(sql.toString());
			stmt.setString(1, pessoa.getEmail());
			stmt.setString(2, pessoa.getSenha());
			stmt.setString(3, pessoa.getNome());
			stmt.setString(4, pessoa.getSobrenome());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public void deletar(Pessoa pessoa) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		conn = BD.getConn();
		
		String sql_deletar_relacionamentos = "DELETE FROM relacionamentos"
									+ " WHERE email ='" + pessoa.getEmail().toString() + "'";
		
		String sql_deletar_relacionamentos_inverso = "DELETE FROM relacionamentos"
				+ " WHERE email_amigo ='" + pessoa.getEmail().toString() + "'";
		
		String sql_deletar_postagem =  "DELETE FROM postagens"
							+ " WHERE email ='" + pessoa.getEmail().toString() + "'";
		
		String sql_deletar_pessoa = "DELETE FROM pessoas"
							+ " WHERE email ='" + pessoa.getEmail().toString() + "'";
		
		
		
		try {
			stmt = conn.prepareStatement(sql_deletar_relacionamentos);
			stmt.executeUpdate();
			stmt.close();
			
			stmt = conn.prepareStatement(sql_deletar_relacionamentos_inverso);
			stmt.executeUpdate();
			stmt.close();
			
			stmt = conn.prepareStatement(sql_deletar_postagem);
			stmt.executeUpdate();
			stmt.close();
			
			stmt = conn.prepareStatement(sql_deletar_pessoa);
			stmt.executeUpdate();
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void editar(Pessoa pessoa) {
		
		
		
	}
	
	
	public void inserirPostagem(Pessoa pessoa, String mensagem) {

		
		String sql = "INSERT INTO postagens(email, mensagem, data)"
				+ " VALUES(?,?,GETDATE())";
		
		Connection conn = BD.getConn();
		PreparedStatement stmt = null;
		
		try {
			stmt = conn.prepareStatement(sql.toString());
			stmt.setString(1, pessoa.getEmail());
			stmt.setString(2, mensagem);
			
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	public void deletarPostagem(Pessoa pessoa, String data){

		String sql = "DELETE FROM postagens"
				+ " WHERE email ='" + pessoa.getEmail().toString() + "'"
				+ " AND DATA='" + data + "'"; 
		
		Connection conn = BD.getConn();
		PreparedStatement stmt = null;
		
		try {
			stmt = conn.prepareStatement(sql);
			stmt.executeUpdate();
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
				
	}
	
	/**
	 * 
	 */
	public void inserirAmigo(Pessoa pessoa, Pessoa amigo){
		String sql = "INSERT INTO relacionamentos(email, email_amigo)"
				+ " VALUES(?,?)";
		
		Connection conn = BD.getConn();
		PreparedStatement stmt = null;
		
		try {
			stmt = conn.prepareStatement(sql.toString());
			stmt.setString(1, pessoa.getEmail());
			stmt.setString(2, amigo.getEmail());
			
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 
	 * @param pessoa
	 * @param amigo
	 */
	public void deletarAmigo(Pessoa pessoa, Pessoa amigo){
		
		String sql = "DELETE FROM relacionamentos"
				+ " WHERE email='" + pessoa.getEmail().toString() + "'"
				+ " AND email_amigo='" + amigo.getEmail().toString() + "'";
		
		Connection conn = BD.getConn();
		PreparedStatement stmt = null;
		
		try {
			stmt = conn.prepareStatement(sql);
			stmt.executeUpdate();
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
