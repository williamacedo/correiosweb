package br.com.correiosproject.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.correiosproject.persistencia.jdbc.LogradouroDao;
import br.com.correiosproject.persistencia.entidade.Logradouro;

@WebServlet("/consultacontroller.do")
public class ConsultaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		LogradouroDao dao = new LogradouroDao();
		List<Logradouro> logradouros = new ArrayList<>();
		logradouros = dao.getLista();
		String parametro = req.getParameter("searchString");
		String rua = req.getParameter("searchString");
		

		try {
			logradouros = dao.buscaPorCep(parametro, rua);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.println("<html>");
		out.println("<body>");
		out.println("<head>");
		out.println("<title>Consulta</title>");
		out.println("<link rel='stylesheet' href='css/bootstrap.min.css'>");
		out.println("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css'>");
		out.println("</head>");
		out.println("<a href='consulta.jsp' class='btn btn-primary' style='margin-left: 10px;margin-top: 10px'><i class='fa fa-chevron-circle-left' aria-hidden='true'></i> Voltar</a>");
		out.println("<div class='container' style='padding: 57px'>");
		out.println("<table class='table'>"
				+ "<thead style='background-color: #ddd'><tr><th scope='col'>Cep</th><th scope='col'>Nome</th>"
				+ "<th scope='col'>Logradouro</th><th scope='col'>Bairro</th><th scope='col'>Cidade</th></tr></thead>");

		for (Logradouro logradouro : logradouros) {
			out.println("<tbody><tr> " + "<td>" + logradouro.getCep() + " "
					+ "</td>" + "<td>" + logradouro.getNome() + " " + "</td>"
					+ "<td>" + logradouro.getTipologradouro().getNome() + " "
					+ "</td>" + "<td>" + logradouro.getBairros().getNome()
					+ " " + "</td>" +
					"<td>" + logradouro.getBairros().getCidade().getNome()
					+ " " + "</td>"+ "</tr>");
				}
			out.println("</table>");
			out.println("</div>");
			out.println("</body>");
			out.println("</html>");



	}
}
