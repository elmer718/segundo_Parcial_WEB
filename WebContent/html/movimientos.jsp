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
        <h1>Movimientos</h1>
      </header>
   
      <div class="container mt-4">
        <div class="row">
          <div class="col-md-8">
            <table class="table">
              <thead>
                <tr>
                  <th scope="col">Fecha</th>
                  <th scope="col">Descripción</th>
                  <th scope="col">Valor</th>
                  <th scope="col">Acciones</th>
                </tr>
              </thead>
              <tbody>
              	<c:forEach var="bill" items="${listbill}">
	                <tr>
	                  <td>
	                  	<label><c:out value="${bill.date_bill}"/></label>
	                  	<br>
	                  	<label><c:out value="${bill.observation}"/></label>
	                  </td>
	                  <td>
	                  	<c:if test="${bill.type==1}">
	                  		<label><c:out value="-${bill.value}"/></label>
	                  	</c:if>
	                  	<c:if test="${bill.type==2}">
	                  		<label><c:out value="${bill.value}"/></label>
	                  	</c:if>
	                  </td>
	                  <td>
	                        <a class="link-info" href="">Ver</a>
	                        <a class="link-danger" href="">Eliminar</a>
	                    </td>
	                </tr>
				</c:forEach>
              </tbody>
            </table>
            <button class="btn btn-primary">Ver más</button>
          </div>
        </div>
        <div class="row mt-3">
          <div class="col-md-8">
            <button class="btn btn-success">+</button>
          </div>
        </div>
      </div>


    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</body>
</html>