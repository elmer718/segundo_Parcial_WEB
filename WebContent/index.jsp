<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <title>Banco BBVA</title>
</head>
<body>
   
    <header class="bg-dark text-white text-center py-4">
        <h1>BBVA</h1>
      </header>
   
      <div class="container mt-4">
        <div class="row justify-content-center">
          <div class="col-md-6">
            <form action="login" method="post">
              <c:if test="${datoError!=''}">
	          	<label><c:out value="-${datoError}"/></label>
	          </c:if>
	              <div class="mb-3">
	                <label for="usuario" class="form-label">Usuario</label>
	                <input type="text" class="form-control" id="user" name="user">
	              </div>
	              <div class="mb-3">
	                <label for="contrasena" class="form-label">Contraseña</label>
	                <input type="password" class="form-control" id="pass" name="pass">
	              </div>
	              <button type="submit" class="btn btn-primary">Ingresar</button>
	              <br>
	              <br>
	              <a href="#" class="link-secondary">Registrar usuario</a>
            </form>
          </div>
        </div>
      </div>


    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</body>
</html>
