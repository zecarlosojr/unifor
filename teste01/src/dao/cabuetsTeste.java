package dao;

import model.Pessoa;
import model.Postagem;

public class cabuetsTeste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PessoaDao dao = new PessoaDao();
		
		Pessoa a = dao.consultar("raul.martins@msn.com");
		System.out.println(a.getEmail());
		System.out.println(a.getNome());
		System.out.println(a.getSenha());
		for (Postagem postagem : a.getPostagem() ) {
			System.out.println(postagem.getMensagem());
			System.out.println(postagem.getData());
		}
		
		for (Pessoa amigos : a.getRelacionamentos() ) {
			System.out.println(amigos.getNome());
			System.out.println(amigos.getEmail());
			for (Postagem postagem : amigos.getPostagem() ) {
				System.out.println(postagem.getMensagem());
				System.out.println(postagem.getData());
			}
		}
		
		dao.incluir("su@hotmail.com", "123", "su", "liane");
		Pessoa b = dao.consultar("su@hotmail.com");
		dao.inserirPostagem(b, "Gua");
		dao.inserirAmigo(b, a);
		dao.inserirAmigo(a, b);
		dao.deletar(b);
		
		
	}

}
