package br.com.correiosproject;

import java.util.List;

import br.com.correiosproject.persistencia.entidade.Estado;
import br.com.correiosproject.persistencia.jdbc.EstadoDao;

public class TestEstadoDAO {

	public static void main(String[] args) {
		TesteListar();
		//TesteCadastrar();
		//TesteAlterar();
		//TesteExcluir();
		//TesteSalvar();
	}
	
	public static void TesteCadastrar() {
		Estado estado = new Estado();
		estado.setUf("Tc");
		estado.setNome("techs");
		
		EstadoDao estDAO = new EstadoDao();
		estDAO.cadastrar(estado);
		
		System.out.println("Cadastrado com sucesso!");
	}
	
	public static void TesteAlterar() {
		Estado estado = new Estado();
		estado.setId(30);
		estado.setUf("TH");
		estado.setNome("tech");
		
		EstadoDao usuDAO = new EstadoDao();
		usuDAO.alterar(estado);
		
		System.out.println("Alterado com sucesso!");
	}
	
	public static void TesteExcluir() {
		Estado estado = new Estado();
		estado.setId(30);
		
		EstadoDao usuDAO = new EstadoDao();
		usuDAO.excluir(estado);
		
		System.out.println("Excluido com sucesso!");
	}
	
	public static void TesteSalvar(){
		Estado estado = new Estado();
		//usuario.setId(2);
		estado.setUf("Th");
		estado.setNome("tech");
		
		EstadoDao usuDao = new EstadoDao();
		usuDao.salvar(estado);
		
		System.out.println("Salvo com sucesso");
	}
	
	public static void TesteListar(){
		EstadoDao dao = new EstadoDao();
		List<Estado> estados = dao.getLista();
		
		for (Estado estado : estados) {
			System.out.println("Uf: " + estado.getUf());
			System.out.println("Nome: " + estado.getNome());
			}
	}

}
