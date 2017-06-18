package br.com.correiosproject.persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.correiosproject.persistencia.entidade.Cidade;

public class CidadeDao {
	private Connection con = ConexaoFactory.getConnection();
	
	public void cadastrar(Cidade cidade) {
		String sql = "insert into cidades (nome, id_estado) values (?,?)";
		try (PreparedStatement preparador = con.prepareStatement(sql)){
			preparador.setString(1, cidade.getNome());
			preparador.setLong(2, cidade.getEstado().getId());
			
			preparador.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public void alterar(Cidade cidade) {
		String sql = "update cidades set nome=?, id_estado=? where id=?";
		try (PreparedStatement preparador = con.prepareStatement(sql)){
			preparador.setString(1, cidade.getNome());
			preparador.setLong(2, cidade.getEstado().getId());
			preparador.setLong(3, cidade.getId());
			
			preparador.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void excluir(Cidade cidade) {
		String sql = "delete from cidades where id=?";
		try (PreparedStatement preparador = con.prepareStatement(sql)){
			preparador.setLong(1, cidade.getId());
			
			preparador.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void salvar(Cidade cidade) {
		if(cidade.getId()!=null){
			alterar(cidade);
		}else {
			cadastrar(cidade);
		}
		
	}
	
	public List<Cidade> getLista() {
		try{
			List<Cidade> cidades = new ArrayList<Cidade>();
			PreparedStatement stmt = this.con.
					 prepareStatement("select c.nome, e.nome from cidades c inner join estados e on c.id_estado=e.id limit 100");
					 ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				
				Cidade cidade = new Cidade();
				cidade.setNome(rs.getString("c.nome"));
				cidade.getEstado().setNome(rs.getString("e.nome"));
				cidades.add(cidade);
			}
		rs.close();
		stmt.close();
		return cidades;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
