public class Libro {
     private int idLibro;
     private String titulo;
     private Autor autor;
     private Categoria categoria;
     private double precio;
 
     public Libro(int idLibro, String titulo, Autor autor, Categoria categoria, double precio) {
         this.idLibro = idLibro;
         this.titulo = titulo;
         this.autor = autor;
         this.categoria = categoria;
         this.precio = precio;
     }
 
     public int getIdLibro() {
         return idLibro;
     }
 
     public void setIdLibro(int idLibro) {
         this.idLibro = idLibro;
     }
 
     public String getTitulo() {
         return titulo;
     }
 
     public void setTitulo(String titulo) {
         this.titulo = titulo;
     }
 
     public Autor getAutor() {
         return autor;
     }
 
     public void setAutor(Autor autor) {
         this.autor = autor;
     }
 
     public Categoria getCategoria() {
         return categoria;
     }
 
     public void setCategoria(Categoria categoria) {
         this.categoria = categoria;
     }
 
     public double getPrecio() {
         return precio;
     }
 
     public void setPrecio(double precio) {
         this.precio = precio;
     }
 }
 