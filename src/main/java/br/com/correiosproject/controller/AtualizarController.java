package br.com.correiosproject.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.correiosproject.persistencia.entidade.Pessoa;
import br.com.correiosproject.persistencia.jdbc.PessoaDao;

public class AtualizarController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(req.getParameter("id"));
		String cpf = req.getParameter("cpf");
		String nome = req.getParameter("nome");
		String email = req.getParameter("email");
		String celular = req.getParameter("celular");
		String logradouro = req.getParameter("id_logradouro");
		String numero = req.getParameter("numero");
		String complemento = req.getParameter("complemento");
		
		Pessoa pessoa = new Pessoa();
		pessoa.setId(id);
		pessoa.setCpf(cpf);
		pessoa.setNome(nome);
		pessoa.setEmail(email);
		pessoa.setCelular(celular);
		pessoa.getLogradouro().setId(Long.parseLong(logradouro));
		pessoa.setNumero(numero);
		pessoa.setComplemento(complemento);
		
		PessoaDao pessoaDao = new PessoaDao();
		String retorno = pessoaDao.alterar(pessoa);
		if(retorno.equals("sucesso")){
			resp.sendRedirect("listapes.jsp");
		}else{
			PrintWriter out = resp.getWriter();
			out.print("<html>");
			out.print("<Não foi possivel alterar a pessoa");
			out.print("<br/>");
			out.print("<a href='listapes.jsp'>Voltar</a>");
			out.print("</html>");
		}
	}

}
