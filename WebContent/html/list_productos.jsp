<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Proyecto WEB</title>

	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
	
</head>
<body>

	<header>
		<div class="row" id="logo">
			<div class="col-xs-2 col-sm-2">
				<picture>
					<img title="" src="">
				</picture>
			</div>

			<div class="col-xs-4 col-sm-5">
				<h1>The Mister</h1>
				<p>Lo mejor en Tecnologia</p>
			</div>
		</div>
		<nav class="navbar navbar-default">
			<div class="container">
				<div class="collapsed">
					<ul class="nav navbar-nav">
						<li><a href="index.html">Inicio</a></li>
					</ul>
				</div>
			</div>
		</nav>
	</header>

	<div class="slider">
		<ul>
			<li><img src="../multimedia/pc_escritorio 3.jpg" alt=""></li>
			<li><img src="../multimedia/pc_portatil 3.jpg" alt=""></li>
			<li><img src="../multimedia/tablet 3.jpg" alt=""></li>
		</ul>
	</div>

	<div class="container">
		<div id="btn_nuevop">
			<a href="<%=request.getContextPath()%>/new" class="btn btn-success">Nuevo producto</a>
		</div>
		<div class="row">
			<h2>Lista de Productos</h2>
			<div id="producto">
				
				<div class="col-xs-9 col-sm-9" id="tabla-producto">
					<table class="table table-bordered">
						<tr>
							<td>Id</td>
							<td>Referencia</td>
							<td>Nombre</td>
							<td>Detalle</td>
							<td>Valor</td>
							<td>Marca</td>
							<td>Categoria</td>
							<td>Mas Opciones</td>
						</tr>
						<tbody>
							<c:forEach var="prod" items="${listProd}">
								<tr>
									<td>
										<c:out value="${prod.id}" />
									</td>
									<td>
										<c:out value="${prod.referencia}" />
									</td>
									<td>
										<c:out value="${prod.nombre}" />
									</td>
									<td>
										<c:out value="${prod.detalle}" />
									</td>
									<td>
										<c:out value="${prod.valor}" />
									</td>
									<td>
										<c:out value="${prod.marca}" />
									</td>
									<td>
										<c:out value="${prod.categoria}" />
									<td><a href="edit?id=<c:out value='${prod.id}' />">Editar</a> &nbsp;&nbsp;&nbsp;&nbsp; <a href="delete?id=<c:out value='${prod.id}' />">Eliminar</a></td>
								</tr>
							</c:forEach>
						</tbody>
						
					</table>
				</div>
			</div>
		</div>
	</div>
	<br>
	<footer class="footer">
		<div class="container">
			<div class="col-xs-7 col-sm-7" id="informacion">
				<ul>Email: elmerfabianrc@ufps.edu.co</ul>
				<ul>Cel +57 311 5147988</ul>
			</div>
			<div id="contacto" class="col-xs-3 col-sm-3">
				<h5>Contactanos</h5>
			</div>
			<div id="desarrollado" class="col-xs-12 col-sm-12">
				<p>2020 © All Rights Reserved. Desarrollado por Elmer Fabian Rodriguez Cardenas</p>
			</div>
		</div>
	</footer>

	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

</body>
</html>