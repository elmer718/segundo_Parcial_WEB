<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
        <h1>Registro de Movimientos</h1>
      </header>
   
      <div class="container mt-4">
        <div class="row justify-content-center">
          <div class="col-md-6">
            <form>
              <div class="mb-3">
                <label for="descripcion" class="form-label">Descripción</label>
                <input type="text" class="form-control" id="descripcion" name="descripcion">
              </div>
              <div class="mb-3">
                <label for="tipoMovimiento" class="form-label">Tipo de Movimiento</label>
                <div class="form-check">
                  <input class="form-check-input" type="checkbox" value="ingreso" id="ingreso" name="tipoMovimiento">
                  <label class="form-check-label" for="ingreso">
                    Ingreso
                  </label>
                </div>
                <div class="form-check">
                  <input class="form-check-input" type="checkbox" value="gasto" id="gasto" name="tipoMovimiento">
                  <label class="form-check-label" for="gasto">
                    Gasto
                  </label>
                </div>
              </div>
              <div class="mb-3">
                <label for="valor" class="form-label">Valor</label>
                <input type="text" class="form-control" id="valor" name="valor">
              </div>
              <button type="submit" class="btn btn-primary">Registrar</button>
              <button type="button" class="btn btn-secondary">Cancelar</button>
            </form>
          </div>
        </div>
      </div>    


    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</body>
</html>
