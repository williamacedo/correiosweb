package br.com.correiosproject.persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.correiosproject.persistencia.entidade.Estado;

public class EstadoDao {
	private Connection con = ConexaoFactory.getConnection();
	public void cadastrar(Estado estado) {
		String sql = "insert into estados (uf, nome) values (?,?)";
		try (PreparedStatement preparador = con.prepareStatement(sql)){
			preparador.setString(1, estado.getUf());
			preparador.setString(2, estado.getNome());
			
			preparador.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public void alterar(Estado estado) {
		String sql = "update estados set uf=?, nome=? where id=?";
		try (PreparedStatement preparador = con.prepareStatement(sql)){
			preparador.setString(1, estado.getUf());
			preparador.setString(2, estado.getNome());
			preparador.setInt(3, estado.getId());
			
			preparador.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void excluir(Estado estado) {
		String sql = "delete from estados where id=?";
		try (PreparedStatement preparador = con.prepareStatement(sql)){
			preparador.setInt(1, estado.getId());
			
			preparador.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void salvar(Estado estado) {
		if(estado.getId()!=null){
			alterar(estado);
		}else {
			cadastrar(estado);
		}
		
	}
	
	public List<Estado> getLista() {
		try{
			List<Estado> estados = new ArrayList<Estado>();
			PreparedStatement stmt = this.con.
					 prepareStatement("select * from estados");
					 ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				
				Estado estado = new Estado();
				estado.setUf(rs.getString("uf"));
				estado.setNome(rs.getString("nome"));
				estados.add(estado);
			}
		rs.close();
		stmt.close();
		return estados;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
