package br.com.correiosproject;

import java.util.List;

import br.com.correiosproject.persistencia.entidade.Logradouro;
import br.com.correiosproject.persistencia.jdbc.LogradouroDao;

public class TestLogradouroDAO {
	public static void main(String[] args) {
		LogradouroDao dao = new LogradouroDao();
		List<Logradouro> logradouros = dao.getLista();
		
		for (Logradouro logradouro : logradouros) {
			System.out.println("Nome: " + logradouro.getNome());
			System.out.println("Cep: " + logradouro.getCep());
			System.out.println("Logradouro: " + logradouro.getTipologradouro().getNome());
			System.out.println("Bairro: " + logradouro.getBairros().getNome());
			}

	}

}
