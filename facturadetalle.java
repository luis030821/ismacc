public class FacturaDetalle {
     private int idDetalle;
     private Factura factura;
     private Libro libro;
     private int cantidad;
     private double precio;
 
     public FacturaDetalle(int idDetalle, Factura factura, Libro libro, int cantidad, double precio) {
         this.idDetalle = idDetalle;
         this.factura = factura;
         this.libro = libro;
         this.cantidad = cantidad;
         this.precio = precio;
     }
 
     public int getIdDetalle() {
         return idDetalle;
     }
 
     public void setIdDetalle(int idDetalle) {
         this.idDetalle = idDetalle;
     }
 
     public Factura getFactura() {
         return factura;
     }
 
     public void setFactura(Factura factura) {
         this.factura = factura;
     }
 
     public Libro getLibro() {
         return libro;
     }
 
     public void setLibro(Libro libro) {
         this.libro = libro;
     }
 
     public int getCantidad() {
         return cantidad;
     }
 
     public void setCantidad(int cantidad) {
         this.cantidad = cantidad;
     }
 
     public double getPrecio() {
         return precio;
     }
 
     public void setPrecio(double precio) {
         this.precio = precio;
     }
 }
 