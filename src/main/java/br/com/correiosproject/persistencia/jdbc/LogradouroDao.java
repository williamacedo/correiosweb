package br.com.correiosproject.persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.correiosproject.persistencia.entidade.Logradouro;

public class LogradouroDao {
	private Connection con = ConexaoFactory.getConnection();

	public void cadastrar(Logradouro logradouro) {
		String sql = "insert into logradouros (cep,nome,id_tipo_logradouro, id_cidade) values (?,?,?,?)";
		try (PreparedStatement preparador = con.prepareStatement(sql)) {
			preparador.setString(1, logradouro.getCep());
			preparador.setString(2, logradouro.getNome());
			preparador.setLong(3, logradouro.getTipologradouro().getId());
			preparador.setLong(4, logradouro.getBairros().getId());

			preparador.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void alterar(Logradouro logradouro) {
		String sql = "update logradouros set cep=?, nome=?, id_tipo_logradouro=?, id_bairro=? where id=?";
		try (PreparedStatement preparador = con.prepareStatement(sql)) {
			preparador.setString(1, logradouro.getCep());
			preparador.setString(2, logradouro.getNome());
			preparador.setLong(3, logradouro.getTipologradouro().getId());
			preparador.setLong(4, logradouro.getBairros().getId());

			preparador.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void excluir(Logradouro logradouro) {
		String sql = "delete from logradouros where id=?";
		try (PreparedStatement preparador = con.prepareStatement(sql)) {
			preparador.setLong(1, logradouro.getId());

			preparador.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void salvar(Logradouro logradouro) {
		if (logradouro.getId() != null) {
			alterar(logradouro);
		} else {
			cadastrar(logradouro);
		}

	}

	public List<Logradouro> getLista() {
		try {
			List<Logradouro> logradouros = new ArrayList<Logradouro>();
			PreparedStatement stmt = this.con
					.prepareStatement("select l.cep, l.nome,t.nome, b.nome from logradouros l inner join tipos_logradouros t inner join bairros b on l.id_tipo_logradouro=t.id AND l.id_bairro=b.id limit 100");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {

				Logradouro logradouro = new Logradouro();
				logradouro.setCep(rs.getString("l.cep"));
				logradouro.setNome(rs.getString("l.nome"));
				logradouro.getTipologradouro().setNome(rs.getString("t.nome"));
				logradouro.getBairros().setNome(rs.getString("b.nome"));

				logradouros.add(logradouro);
			}
			return logradouros;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Logradouro> buscaPorCep(String cep) {

		String sql = "select l.cep, l.nome,t.nome, b.nome from logradouros l inner join tipos_logradouros t inner join bairros b on l.id_tipo_logradouro=t.id AND l.id_bairro=b.id where cep like ?";
		

		try (PreparedStatement preparador = con.prepareStatement(sql)) {
			preparador.setString(1, "%" + cep + "%");

			ResultSet resultado = preparador.executeQuery();
			List<Logradouro> logradouros = new ArrayList<Logradouro>();
			// Posicionando o cursor no primeiro registro
			while (resultado.next()) {
				Logradouro logradouro = new Logradouro();
				logradouro.setCep(resultado.getString("l.cep"));
				logradouro.setNome(resultado.getString("l.nome"));
				logradouro.getTipologradouro().setNome(
						resultado.getString("t.nome"));
				logradouro.getBairros().setNome(resultado.getString("b.nome"));

				logradouros.add(logradouro);
			}
			return logradouros;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;


	}
}
