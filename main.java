import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DependencyInjector {
    public static Cliente createCliente(int id, String nombre, String direccion) {
        return new Cliente(id, nombre, direccion);
    }

    public static Factura createFactura(int id, Date fecha, Cliente cliente, List<FacturaDetalle> detalles) {
        return new Factura(id, fecha, cliente, detalles);
    }

    public static FacturaDetalle createFacturaDetalle(int id, Factura factura, Libro libro, int cantidad, double precio) {
        return new FacturaDetalle(id, factura, libro, cantidad, precio);
    }

    public static Libro createLibro(int id, String titulo, Autor autor, Categoria categoria, double precio) {
        return new Libro(id, titulo, autor, categoria, precio);
    }

    public static Autor createAutor(int id, String nombre, String nacionalidad) {
        return new Autor(id, nombre, nacionalidad);
    }

    public static Categoria createCategoria(int id, String nombre) {
        return new Categoria(id, nombre);
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        Cliente cliente = createCliente(1, "Juan Pérez", "Calle Falsa 123");
        Autor autor = createAutor(1, "Gabriel García Márquez", "Colombiana");
        Categoria categoria = createCategoria(1, "Novela");
        Libro libro = createLibro(1, "Cien Años de Soledad", autor, categoria, 29.99);

        List<FacturaDetalle> detalles = new ArrayList<>();
        Factura factura = createFactura(1, new Date(), cliente, detalles);

        FacturaDetalle detalle = createFacturaDetalle(1, factura, libro, 2, 59.98);
        detalles.add(detalle);

        System.out.println("Factura creada para: " + cliente.getNombre());
    }
}
