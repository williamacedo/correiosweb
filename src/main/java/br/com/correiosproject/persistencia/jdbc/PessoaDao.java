package br.com.correiosproject.persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.correiosproject.persistencia.entidade.Pessoa;

public class PessoaDao {
private static Connection con = ConexaoFactory.getConnection();
final private static String searchId = "select p.id, p.cpf, p.nome,p.email, p.celular, l.nome, p.numero, p.complemento  from pessoas p inner join logradouros l on p.id_logradouro=l.id limit 100";
	
	public void cadastrar(Pessoa pessoa) {
		String sql = "insert into pessoas (cpf,nome, email, celular, id_logradouro, numero, complemento) values (?,?,?,?,?,?,?)";
		try (PreparedStatement preparador = con.prepareStatement(sql)){
			preparador.setString(1, pessoa.getCpf());
			preparador.setString(2, pessoa.getNome());
			preparador.setString(3, pessoa.getEmail());
			preparador.setString(4, pessoa.getCelular());
			preparador.setLong(5, pessoa.getLogradouro().getId());
			preparador.setString(6, pessoa.getNumero());
			preparador.setString(7, pessoa.getComplemento());
			
			
			preparador.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public String alterar(Pessoa pessoa) {
		String retorno = "falha";  
		String sql = "update pessoas set cpf=?, nome=?, email=?, celular=?, id_logradouro=?, numero=?, complemento=? where id= '"+ pessoa.getId() +"'";
		try (PreparedStatement preparador = con.prepareStatement(sql)){
			preparador.setString(1, pessoa.getCpf());
			preparador.setString(2, pessoa.getNome());
			preparador.setString(3, pessoa.getEmail());
			preparador.setString(4, pessoa.getCelular());
			preparador.setLong(5, pessoa.getLogradouro().getId());
			preparador.setString(6, pessoa.getNumero());
			preparador.setString(7, pessoa.getComplemento());
			preparador.setInt(8, pessoa.getId());
			
			preparador.executeUpdate(); 
			retorno = "sucesso";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retorno;
		
	}
	public void excluir(Pessoa pessoa) {
		String sql = "delete from pessoas where id=?";
		try (PreparedStatement preparador = con.prepareStatement(sql)){
			preparador.setInt(1, pessoa.getId());
			
			preparador.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void salvar(Pessoa pessoa) {
		if(pessoa.getId()!=null){
			alterar(pessoa);
		}else {
			cadastrar(pessoa);
		}
		
	}
	
	public List<Pessoa> getLista() {
		try{
			List<Pessoa> pessoas = new ArrayList<Pessoa>();
			PreparedStatement preparador = this.con.
					 prepareStatement("select p.id, p.cpf, p.nome,p.email, p.celular, l.nome, p.numero, p.complemento  from pessoas p inner join logradouros l on p.id_logradouro=l.id limit 100");
					 ResultSet rs = preparador.executeQuery();
			while (rs.next()) {
				
				Pessoa pessoa = new Pessoa();
				pessoa.setId(rs.getInt("p.id"));
				pessoa.setCpf(rs.getString("p.cpf"));
				pessoa.setNome(rs.getString("p.nome"));
				pessoa.setEmail(rs.getString("p.email"));
				pessoa.setCelular(rs.getString("p.celular"));
				pessoa.getLogradouro().setNome(rs.getString("l.nome"));
				pessoa.setNumero(rs.getString("p.numero"));
				pessoa.setComplemento(rs.getString("p.complemento"));
				
				pessoas.add(pessoa);
			}

		return pessoas;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Pessoa selecionar(int id){
		Pessoa pessoa = new Pessoa();
		String sql = "select p.id, p.cpf, p.nome,p.email, p.celular, l.nome , p.numero, p.complemento  from pessoas p inner join logradouros l on p.id_logradouro=l.id where p.id'"+ id +"'";
		
		try (PreparedStatement preparador = con.prepareStatement(sql)){
			preparador.setInt(1, id);
			
			ResultSet resultado = preparador.executeQuery();
			//Posicionando o cursor no primeiro registro
			if(resultado.next()){
				
				pessoa.setId(resultado.getInt("p.id"));
				pessoa.setCpf(resultado.getString("p.cpf"));
				pessoa.setNome(resultado.getString("p.nome"));
				pessoa.setEmail(resultado.getString("p.email"));
				pessoa.setCelular(resultado.getString("p.celular"));
				pessoa.getLogradouro().setNome(resultado.getString("l.nome"));
				pessoa.setNumero(resultado.getString("p.numero"));
				pessoa.setComplemento(resultado.getString("p.complemento"));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pessoa;
	}
	
	 
}



