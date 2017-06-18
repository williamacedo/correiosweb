package br.com.correiosproject;

import java.util.List;

import br.com.correiosproject.persistencia.entidade.Pessoa;
import br.com.correiosproject.persistencia.jdbc.PessoaDao;

public class TestPessoaDAO {

		public static void main(String[] args) {
			TesteListar();
			//TesteCadastrar();
			//TesteAlterar();
			//TesteExcluir();
			//TesteSalvar();
		}
		
		public static void TesteListar(){
			PessoaDao dao = new PessoaDao();
			List<Pessoa> pessoas = dao.getLista();
			
			for (Pessoa pessoa : pessoas) {
				System.out.println("Cpf: " + pessoa.getCpf());
				System.out.println("Nome: " + pessoa.getNome());
				System.out.println("Celular: " + pessoa.getCelular());
				System.out.println("Logradouro: " + pessoa.getLogradouro().getNome());
				System.out.println("Numero: " + pessoa.getNumero());
				System.out.println("Complemento: " + pessoa.getComplemento());
				}
		}

	}


