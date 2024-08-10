<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Agregar Cliente</title>
</head>
<body>
    <h1>Agregar Cliente</h1>
    
    <form action="guardarCliente.jsp" method="post">
        Nombre: <input type="text" name="nombre"><br>
        Dirección: <input type="text" name="direccion"><br>
        <input type="submit" value="Guardar">
    </form>
</body>
</html>
