<%@page import="br.com.correiosproject.persistencia.entidade.Pessoa"%>
<%@ page import="br.com.correiosproject.persistencia.jdbc.PessoaDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Alterar Pessoa</title>
</head>
<body>
	<%
		int id = Integer.parseInt(request.getParameter("id"));
		PessoaDao dao = new PessoaDao();
		Pessoa pessoa = dao.selecionar(id);
	%>
	<form action="AtualizarController" method='POST'>
		<input type="hidden" name="id" value="<%=pessoa.getId() %>">
		<input type="hidden" name="id" value="<%=pessoa.getNome() %>">
	</form>
</body>
</html>