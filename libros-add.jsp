<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Agregar Libro</title>
  </head>
  <body>
    <h2>Agregar Nuevo Libro</h2>
    <form action="libros-add" method="post">
      <label for="titulo">Título:</label>
      <input type="text" id="titulo" name="titulo" /><br /><br />
      <label for="autor">Autor:</label>
      <select id="autor" name="autor">
        <c:forEach var="autor" items="${autores}">
          <option value="${autor.idAutor}">${autor.nombre}</option>
        </c:forEach></select
      ><br /><br />
      <label for="categoria">Categoría:</label>
      <select id="categoria" name="categoria">
        <c:forEach var="categoria" items="${categorias}">
          <option value="${categoria.idCategoria}">${categoria.nombre}</option>
        </c:forEach></select
      ><br /><br />
      <label for="precio">Precio:</label>
      <input type="text" id="precio" name="precio" /><br /><br />
      <input type="submit" value="Agregar Libro" />
    </form>
  </body>
</html>
