package br.com.correiosproject;

import java.util.List;

import br.com.correiosproject.persistencia.entidade.Usuario;
import br.com.correiosproject.persistencia.jdbc.UsuarioDao;

public class TestUsuarioDAO {

	public static void main(String[] args) {
		//TesteSalvar();
		TesteBuscarTodos();
		//TesteBuscarPorId();
	}
	
	private static void TesteBuscarTodos() {
		UsuarioDao usuarioDao = new UsuarioDao();
		List<Usuario> lista = usuarioDao.buscaTodos();
		for (Usuario u : lista) {
		System.out.println(u);
		}
	}
	
	private static void TesteBuscarPorId() {
		UsuarioDao usuarioDao = new UsuarioDao();
		Usuario usuario = usuarioDao.buscaPorId(1);
		System.out.println(usuario);
	}

	public static void TesteCadastrar() {
		Usuario usu = new Usuario();
		usu.setNome("Joaozao");
		usu.setLogin("jzao");
		usu.setSenha("123");
		
		UsuarioDao usuDAO = new UsuarioDao();
		usuDAO.cadastrar(usu);
		
		System.out.println("Cadastrado com sucesso!");
	}
	
	public static void TesteAlterar() {
		Usuario usu = new Usuario();
		usu.setId(2);
		usu.setNome("Joaozao da silva");
		usu.setLogin("jzaoss");
		usu.setSenha("12345678");
		
		UsuarioDao usuDAO = new UsuarioDao();
		usuDAO.alterar(usu);
		
		System.out.println("Alterado com sucesso!");
	}
	
	public static void TesteExcluir() {
		Usuario usu = new Usuario();
		usu.setId(4);
		
		UsuarioDao usuDAO = new UsuarioDao();
		usuDAO.excluir(usu);
		
		System.out.println("Excluido com sucesso!");
	}
	
	public static void TesteSalvar(){
		Usuario usuario = new Usuario();
		//usuario.setId(2);
		usuario.setNome("Virmeson");
		usuario.setLogin("vir");
		usuario.setSenha("123");
		
		UsuarioDao usuDao = new UsuarioDao();
		usuDao.salvar(usuario);
		
		System.out.println("Salvo com sucesso");
	}

}
