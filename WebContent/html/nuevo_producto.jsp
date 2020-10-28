<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
						<li><a href="<%=request.getContextPath()%>/list">Productos</a></li>
					</ul>
				</div>
			</div>
		</nav>
	</header>

	<div class="container">
		<div class="row">
			<div class="col-sm-12 col-xs-12" id="registro">
				<c:if test="${prod != null}">
                	<form action="update" method="post">
                </c:if>
                <c:if test="${prod == null}">
                    <form action="insert" method="post">
                </c:if>
                <caption>
                	<h2>
                    	<c:if test="${prod != null}">Editar Producto</c:if>
                        <c:if test="${prod == null}">Agregar Nuevo Producto</c:if>
                    </h2>
                </caption>
                <div class="col-sm-5 col-xs-5">
                	<fieldset class="form-group">
						<label>ID</label><input type="text" value="<c:out value='${prod.id}' />" class="form-control" name="id">
					</fieldset>
					<fieldset class="form-group">
						<label>Refenrencia</label><input type="text" name="referencia" value="<c:out value='${prod.referencia}' />" class="form-control">
					</fieldset>
					<fieldset class="form-group">
						<label>Nombre</label><input type="text" name="nombre" value="<c:out value='${prod.nombre}' />" class="form-control">
					</fieldset>	
					<fieldset class="form-group">
						<label>Marca</label><input type="text" name="marca" value="<c:out value='${prod.marca}' />" class="form-control">
					</fieldset>
					<fieldset class="form-group">
						<label>Categoria</label><input type="text" name="categoria" value="<c:out value='${prod.categoria}' />" class="form-control">
					</fieldset>	
					<fieldset class="form-group">
						<label>Valor</label><input type="text" name="valor" value="<c:out value='${prod.valor}' />" class="form-control">
					</fieldset>
					<fieldset class="form-group">
						<label>Detalle</label><input type="text" name="detalle" value="<c:out value='${prod.detalle}' />" class="form-control">
					</fieldset>
                </div>
                	
				</form>
                <div class="col-sm-3 col-xs-3">
                	<div id="categoria">
                		<h3>Categorias</h3>
						<c:forEach var="categoria" items="${listCateg}">
							<ul><label>Id</label><c:out value="${categoria.id}" /></ul>
							<ul><label>Descripcion</label><c:out value="${categoria.descripcion}" /></ul>
						</c:forEach>
						<a href="<%=request.getContextPath()%>/newCateg" class="btn btn-success">Nueva Categoria</a>
					</div>
					<div>
						<h3>Marcas</h3>
						<c:forEach var="marca" items="${listMarca}">
							<ul><c:out value="${marca.id}" /></ul>
							<ul><c:out value="${marca.nombre}" /></ul>
						</c:forEach>
						<a href="<%=request.getContextPath()%>/newMarca" class="btn btn-success">Nueva Categoria</a>
					</div>
                </div>
				
			</div>
			<br>
			<div id="guardar" class="col-sm-12 col-xs-12">
				<button type="submit" class="btn btn-success">Guardar</button>
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