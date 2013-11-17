package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import persistencia.BD;
import model.Pessoa;
import model.Postagem;

/**
 * Classe PessoaDao
 * 
 * @author 1210841 - Dennis Fernandes<br>
 *         1213978 - Raul Martins<br>
 *         1213854 - José Carlos Oliveira<br>
 * 
 * @version <p>
 *          <b>v1.0 (14/10/2013)</b><br>
 *          -{@link #consultar(String)}
 *          </p>
 */
public class PessoaDao {
	/**
	 * @param email
	 * @return Pessoa populada
	 */

	public Pessoa consultar(Pessoa p) {

		String sql_pessoas = "SELECT email, senha, nome, sobrenome, dt_nascimento"
				+ " FROM pessoas" + " WHERE email ='" + p.getEmail() + "'";

		String sql_postagens = "SELECT mensagem, data" + " FROM Postagens"
				+ " WHERE email = '" + p.getEmail() + "'"
				+ " ORDER BY data DESC";

		String sql_relacionamentos = "SELECT p.email, p.senha, p.nome, p.sobrenome, p.dt_nascimento"
				+ " FROM pessoas AS p"
				+ " INNER JOIN relacionamentos AS r ON p.email = r.email_amigo"
				+ " WHERE r.email = '" + p.getEmail() + "'";

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		conn = BD.getConn();
		Pessoa pessoa = new Pessoa();

		try {
			/* Recupera as informações básicas de uma Pessoa */
			stmt = conn.prepareStatement(sql_pessoas);
			rs = stmt.executeQuery();

			while (rs.next()) {

				pessoa.setEmail(rs.getString("email"));
				pessoa.setSenha(rs.getString("senha"));
				pessoa.setNome(rs.getString("nome"));
				pessoa.setDt_nascimento(rs.getString("dt_nascimento"));
				pessoa.setSobrenome(rs.getString("sobrenome"));

			}
			stmt.close();
			rs.close();

			/* Recupera as postagens de uma Pessoa */
			stmt = conn.prepareStatement(sql_postagens);
			rs = stmt.executeQuery();

			while (rs.next()) {
				pessoa.getPostagem().add(
						new Postagem(rs.getString("mensagem"), rs
								.getString("data")));
			}
			stmt.close();
			rs.close();

			/* Recupera os amigos de uma Pessoa */
			stmt = conn.prepareStatement(sql_relacionamentos);
			rs = stmt.executeQuery();

			while (rs.next()) {

				Pessoa amigo = new Pessoa();

				amigo.setEmail(rs.getString("email"));
				amigo.setSenha(rs.getString("senha"));
				amigo.setNome(rs.getString("nome"));
				amigo.setSobrenome(rs.getString("sobrenome"));
				amigo.setDt_nascimento(rs.getString("dt_nascimento"));
				pessoa.getRelacionamentos().add(amigo);
			}

			for (Pessoa amigo : pessoa.getRelacionamentos()) {
				String sql_post_amigo = "SELECT mensagem, data"
						+ " FROM Postagens" + " WHERE email = '"
						+ amigo.getEmail().toString() + "'"
						+ " ORDER BY data DESC";

				/* Recupera as postagens de um Amigo de uma Pessoa */
				stmt = conn.prepareStatement(sql_post_amigo);
				rs = stmt.executeQuery();

				while (rs.next()) {
					amigo.getPostagem().add(
							new Postagem(rs.getString("mensagem"), rs
									.getString("data")));
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

	/**
	 * 
	 * @param pessoa
	 */
	public void incluir(Pessoa pessoa) {
		String sql = "INSERT INTO pessoas(email, senha, nome, sobrenome, dt_nascimento)"
				+ " VALUES(?,?,?,?,?)";

		Connection conn = BD.getConn();
		PreparedStatement stmt = null;

		try {

			stmt = conn.prepareStatement(sql.toString());

			stmt.setString(1, pessoa.getEmail());
			stmt.setString(2, pessoa.getSenha());
			stmt.setString(3, pessoa.getNome());
			stmt.setString(4, pessoa.getSobrenome());
			stmt.setString(5, pessoa.getDt_nascimento());
			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 
	 * @param pessoa
	 */
	public void deletar(Pessoa pessoa) {

		Connection conn = null;
		PreparedStatement stmt = null;
		conn = BD.getConn();

		String sql_deletar_relacionamentos = "DELETE FROM relacionamentos"
				+ " WHERE email ='" + pessoa.getEmail().toString() + "'";

		String sql_deletar_relacionamentos_inverso = "DELETE FROM relacionamentos"
				+ " WHERE email_amigo ='" + pessoa.getEmail().toString() + "'";

		String sql_deletar_postagem = "DELETE FROM postagens"
				+ " WHERE email ='" + pessoa.getEmail().toString() + "'";

		String sql_deletar_pessoa = "DELETE FROM pessoas" + " WHERE email ='"
				+ pessoa.getEmail().toString() + "'";

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

	/**
	 * 
	 * @param pessoa
	 */
	public void editar(Pessoa pessoa) {

	}

	/**
	 * 
	 * @param pessoa
	 * @param mensagem
	 * @param data
	 */
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

	/**
	 * 
	 * @param pessoa
	 * @param data
	 */
	public void deletarPostagem(Pessoa pessoa, String data) {

		String sql = "DELETE FROM postagens" + " WHERE email ='"
				+ pessoa.getEmail().toString() + "'" + " AND DATA='" + data
				+ "'";

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
	public void inserirAmigo(Pessoa pessoa, Pessoa amigo) {
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
	public void deletarAmigo(Pessoa pessoa, Pessoa amigo) {

		String sql = "DELETE FROM relacionamentos" + " WHERE email='"
				+ pessoa.getEmail().toString() + "'" + " AND email_amigo='"
				+ amigo.getEmail().toString() + "'";

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

	public ArrayList<Pessoa> listarPostagens(Pessoa pessoa) {

		ArrayList<Pessoa> postagens = new ArrayList<Pessoa>();

		String sql_postagens = " select top 20 email, nome, sobrenome, data, mensagem"
				+ " from (select po1.email, pe1.nome, pe1.sobrenome, po1.data, po1.mensagem"
				+ " from postagens po1 inner join pessoas pe1 on po1.email = pe1.email"
				+ "	where po1.email ='"
				+ pessoa.getEmail()
				+ "'"
				+ " union"
				+ " select po2.email, pe2.nome, pe2.sobrenome, po2.data, po2.mensagem"
				+ " from postagens po2 inner join pessoas pe2 on po2.email = pe2.email"
				+ " where po2.email = (select email_amigo from relacionamentos where email ='"
				+ pessoa.getEmail()
				+ "'))"
				+ " as SubSelect"
				+ " order by data desc";

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		conn = BD.getConn();

		try {
			/* Recupera as top 20 postagens */
			stmt = conn.prepareStatement(sql_postagens);
			rs = stmt.executeQuery();

			while (rs.next()) {
				Pessoa nova = new Pessoa();
				nova.setEmail(rs.getString("email"));
				nova.setNome(rs.getString("nome"));
				nova.setSobrenome(rs.getString("sobrenome"));
				Postagem novopost = new Postagem(rs.getString("mensagem"),
						rs.getString("data"));
				nova.getPostagem().add(novopost);

				postagens.add(nova);
			}
			stmt.close();
			rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return postagens;

	}
}
