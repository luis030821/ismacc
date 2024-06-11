import java.util.List;

public interface CategoriaDAO {
    void addCategoria(Categoria categoria);
    Categoria getCategoria(int id);
    List<Categoria> getAllCategorias();
    void updateCategoria(Categoria categoria);
    void deleteCategoria(int id);
}
