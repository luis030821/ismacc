<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listado de Clientes</title>
</head>
<body>
    <h1>Listado de Clientes</h1>
    
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Dirección</th>
        </tr>
        <c:forEach var="cliente" items="${clientes}">
            <tr>
                <td>${cliente.idCliente}</td>
                <td>${cliente.nombre}</td>
                <td>${cliente.direccion}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
