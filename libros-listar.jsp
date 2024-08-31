<%@ page contentType="text/html;charset=UTF-8" language="java" %> <%@ taglib
uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
    <title>Listar Libros</title>
  </head>
  <body>
    <h2>Lista de Libros</h2>
    <table border="1">
      <tr>
        <th>ID</th>
        <th>Título</th>
        <th>Autor</th>
        <th>Categoría</th>
        <th>Precio</th>
      </tr>
      <c:forEach var="libro" items="${libros}">
        <tr>
          <td>${libro.idLibro}</td>
          <td>${libro.titulo}</td>
          <td>${libro.autor.nombre}</td>
          <td>${libro.categoria.nombre}</td>
          <td>${libro.precio}</td>
        </tr>
      </c:forEach>
    </table>
  </body>
</html>
