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

@WebServlet("/atualizarcontroller.do")
public class AtualizarController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		PrintWriter out = resp.getWriter();
		String id = req.getParameter("id");
		String cpf = req.getParameter("cpf");
		String nome = req.getParameter("nome");
		String email = req.getParameter("email");
		String celular = req.getParameter("celular");
		String logradouro = req.getParameter("logradouro");
		String numero = req.getParameter("numero");
		String complemento = req.getParameter("complemento");

		Pessoa pessoa = new Pessoa();

		pessoa.setId(Integer.parseInt(id));
		pessoa.setCpf(cpf);
		pessoa.setNome(nome);
		pessoa.setEmail(email);
		pessoa.setCelular(celular);
		pessoa.getLogradouro().setId(Long.parseLong(logradouro));
		pessoa.setNumero(numero);
		pessoa.setComplemento(complemento);

		PessoaDao dao = new PessoaDao();
		dao.alterar(pessoa);

		out.println("<html>");
		out.println("<body>");
		out.println("<h1>Alterado com Sucesso</h1>");
		out.println("<a href='listapes.jsp'>Voltar</a>");
		out.println("</body>");
		out.println("</html>");
	}

}
