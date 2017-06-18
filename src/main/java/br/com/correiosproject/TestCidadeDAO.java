package br.com.correiosproject;

import java.util.List;

import br.com.correiosproject.persistencia.entidade.Cidade;
import br.com.correiosproject.persistencia.jdbc.CidadeDao;


public class TestCidadeDAO {

	public static void main(String[] args) {
		TesteBuscarTodos();

	}
	
	private static void TesteBuscarTodos() {
		CidadeDao cidadeDao = new CidadeDao();
		List<Cidade> cidades = cidadeDao.getLista();
		for (Cidade cidade : cidades) {
		System.out.println("Nome: " + cidade.getNome());
		System.out.println("Estado: " + cidade.getEstado().getNome());
		}
	}
	

}
