<%@page import="br.com.correiosproject.persistencia.entidade.Pessoa"%>
<%@ page import="br.com.correiosproject.persistencia.jdbc.PessoaDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/fontawesome/4.7.0/css/font-awesome.min.css">
<script src="//code.jquery.com/jquery-1.10.2.min.js"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
</head>
<body>
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
	        	</div><!--/.nav-collapse -->
	      	</div>
    	</nav>	
    		<div class="container" style="padding: 93px; ">
					<h2>Atualizar Pessoa:</h2>
        
	<%
		int id = Integer.parseInt(request.getParameter("id"));
		PessoaDao dao = new PessoaDao();
		Pessoa pessoa = dao.selecionar(id);
	%>
				<form method="post" action="AtualizarController" method="post">
					<div class="row">
						<div class="col-md-2">
							<div class="form-group">
								<label for="id">ID:</label>
								<input type="text" name="id" class="form-control" value="<%=pessoa.getId()%>">
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label for="cpf">CPF:</label>
								<input type="text" name="cpf" class="form-control" value="<%=pessoa.getCpf()%>">
							</div>
						</div>			
		
						<div class="col-md-6">
							<div class="form-group">
								<label for="nome">Nome:</label>
								<input type="text" name="nome" class="form-control" value="<%=pessoa.getNome()%>">
							</div>
						</div>			
					</div>
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label for="email">Email:</label>
								<input type="text" name="email" class="form-control" value="<%=pessoa.getEmail()%>">
							</div>
						</div>			
		
						<div class="col-md-6">
							<div class="form-group">
								<label for="celular">Celular:</label>
								<input type="text" name="celular" class="form-control" value="<%=pessoa.getCelular()%>">
							</div>
						</div>			
					</div>
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label for=logradouro>Logradouro:</label>
								<input type="text" name="logradouro" class="form-control" value="<%=pessoa.getLogradouro().getNome()%>">
							</div>
						</div>			
		
						<div class="col-md-6">
							<div class="form-group">
								<label for="numero">Numero:</label>
								<input type="text" name="numero" class="form-control" value="<%=pessoa.getNumero()%>">
							</div>
						</div>			
					</div>
					<div class="row">
						<div class="col-md-12">
							<div class="form-group">
								<label for="complemento">Complemento</label>
								<input type="text" name="complemento" class="form-control" value="<%=pessoa.getComplemento()%>">
							</div>
						</div>
					</div>
					<input type="submit" value="Salvar" class="btn btn-primary">
					
</form>
				</div>				
</body>
</html>