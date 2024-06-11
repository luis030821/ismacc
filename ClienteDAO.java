import java.util.List;

public interface ClienteDAO {
    void addCliente(Cliente cliente);
    Cliente getCliente(int id);
    List<Cliente> getAllClientes();
    void updateCliente(Cliente cliente);
    void deleteCliente(int id);
}
