package br.com.correiosproject.controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.correiosproject.persistencia.entidade.Pessoa;
import br.com.correiosproject.persistencia.jdbc.PessoaDao;


@WebServlet("/pessoacontroller.do")
public class PessoaController extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
    	PessoaDao pessoaDao = new PessoaDao();
		String acao = req.getParameter("acao");
		if (acao.equals("exc")) {
			String id = req.getParameter("id");
			Pessoa pessoa = new Pessoa();
			if (id != null) {
				pessoa.setId(Integer.parseInt(id));

				pessoaDao.excluir(pessoa);
				
				resp.sendRedirect("listapes.jsp");
				
		}
                
	}
}

	/**
	 * 
	 */


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PessoaDao pessoaDao = new PessoaDao();
		
		String cpf = req.getParameter("cpf");
		String nome = req.getParameter("nome");
		String email = req.getParameter("email");
		String celular = req.getParameter("celular");
		String logradouro = req.getParameter("logradouro");
		String numero = req.getParameter("numero");
		String complemento = req.getParameter("complemento");

		Pessoa pessoa = new Pessoa();
		pessoa.setCpf(cpf);
		pessoa.setNome(nome);
		pessoa.setEmail(email);
		pessoa.setCelular(celular);
		pessoa.setEmail(email);
		pessoa.getLogradouro().setId(Long.parseLong(logradouro));
		pessoa.setNumero(numero);
		pessoa.setComplemento(complemento);
		pessoaDao.salvar(pessoa);

		resp.sendRedirect("listapes.jsp");
		
	}

}
