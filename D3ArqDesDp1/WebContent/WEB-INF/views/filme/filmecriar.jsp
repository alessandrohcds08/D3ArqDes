<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Novo Filme</title>

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
</head>

<body>
	<!-- Barra superior com os menus de navegação -->
	<c:import url="../menu.jsp" />
	<!-- Container Principal -->
	<div id="main" class="container">
		<h3 class="page-header">Incluir filme</h3>
		<!-- Formulario para inclusao de filme -->
		<form action="incluir_filme" method="post">
			<!-- area de campos do form -->
			<div class="row">
				<div class="form-group col-md-8">
					<label for="nome">Nome</label> 
					<input type="text" class="form-control" name="nome" 
					id="nome" required maxlength="128" 
					placeholder="nome do filme">
					<form:errors path="filme.nome" cssStyle="color:red" />
				</div>
				<div class="form-group col-md-4">
					<label for="idioma">Idioma</label> 
					<select name="idioma.id" class="form-control">
						<c:forEach var="idioma" items="${idiomas}">
							<option value="${idioma.id}">${idioma.nome}</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-4">
					<label for="genero">Genero</label> 
					<input type="number" class="form-control" name="genero" 
					id="genero"  placeholder="genero do filme">
					<form:errors path="idioma.genero" cssStyle="color:red" />
				</div>
				</div>
			</div>
			<hr />
			<div id="actions" class="row">
				<div class="col-md-12">
					<button type="submit" class="btn btn-primary">Salvar</button>
					<a href="index" class="btn btn-default">Cancelar</a>
				</div>
			</div>
		</form>
	</div>
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>

</html>