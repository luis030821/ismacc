<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Eliminar Libro</title>
  </head>
  <body>
    <h2>Eliminar Libro</h2>
    <form action="libros-del" method="post">
      <label for="libro">Seleccione el libro a eliminar:</label>
      <select id="libro" name="libro">
        <c:forEach var="libro" items="${libros}">
          <option value="${libro.idLibro}">${libro.titulo}</option>
        </c:forEach></select
      ><br /><br />
      <input type="submit" value="Eliminar Libro" />
    </form>
  </body>
</html>
