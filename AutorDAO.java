import java.util.List;

public interface AutorDAO {
    void addAutor(Autor autor);
    Autor getAutor(int id);
    List<Autor> getAllAutores();
    void updateAutor(Autor autor);
    void deleteAutor(int id);
}
