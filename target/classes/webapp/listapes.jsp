<%@page import="java.util.List"%>
<%@page import="br.com.correiosproject.persistencia.entidade.Pessoa"%>
<%@ page import="br.com.correiosproject.persistencia.jdbc.PessoaDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Pessoas</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/fontawesome/4.7.0/css/font-awesome.min.css">
<script src="//code.jquery.com/jquery-1.10.2.min.js"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top">
	    	<div class="container">
	        	<div class="navbar-header">
	          		<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
			            <span class="sr-only">Toggle navigation</span>
			            <span class="icon-bar"></span>
			            <span class="icon-bar"></span>
			            <span class="icon-bar"></span>
	          		</button>
	          		<a class="navbar-brand hacked-font" href="#">CorreiosWeb</a>
	        	</div>
	        	<div id="navbar" class="navbar-collapse collapse">
	          		<ul class="nav navbar-nav">
	            		<li><a href="index.html">Inicio</a></li>
	            		<li><a href="consulta.jsp">Consulta</a></li> 
				         <li><a href="listapes.jsp">Pessoas</a></li> 
		              		</ul>
	            		</li>
	          		</ul>      
		              		</ul>
	            		</li>
	          		</ul>
	        	</div><!--/.nav-collapse -->
	      	</div>
    	</nav>	
    		<div class="container" style="padding: 93px; ">	
			<h2>CorreiosWeb - Pessoas</h2>
			<a class="btn btn-primary" href="add-pessoa.html" style="margin-bottom: 12px;"><i class="fa fa-plus" aria-hidden="true"></i> Adicionar Pessoa</a>
			<table class="table">
			<thead style="background-color: #ddd">
		<tr>
			<th>Cpf</th>
			<th>Nome</th>
			<th>Email</th>
			<th>Celular</th>
			<th>Logradouro</th>
			<th>Numero</th>
			<th>Complemento</th>
			<th style="width: 200px;">Ações</th>

		</tr>
		</thead>
		<%
			PessoaDao dao = new PessoaDao();
			List<Pessoa> pessoas = dao.getLista();

			for (Pessoa pessoa : pessoas) {
		%>
		<tr>
			<td><%=pessoa.getCpf()%></td>
			<td><%=pessoa.getNome()%></td>
			<td><%=pessoa.getEmail()%></td>
			<td><%=pessoa.getCelular()%></td>
			<td><%=pessoa.getLogradouro().getNome()%></td>
			<td><%=pessoa.getNumero()%></td>
			<td><%=pessoa.getComplemento()%></td>
			
			<td>
				<a class="btn btn-info" style="float: left;margin-right: 11px" href="pessoacontroller.do?acao=alt&id=<%=pessoa.getId()%>"><i class="fa fa-pencil" aria-hidden="true"></i> Editar</a>
				<a class="btn btn-danger" onclick="return confirm('Tem certeza que deseja remover esta pessoa?');" style="float: left" href="pessoacontroller.do?acao=exc&id=<%=pessoa.getId()%>"><i class="fa fa-trash" aria-hidden="true"></i> Excluir</a>
			</td>
		</tr>
		<%
			}
		%>
	</table>
</div>
</body>
</html>