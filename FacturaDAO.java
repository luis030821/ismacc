import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class FacturaDAO implements GenericDAO<Factura> {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("miUnidadDePersistencia");
    private EntityManager em = emf.createEntityManager();

    @Override
    public void save(Factura entity) {
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
    }

    @Override
    public void update(Factura entity) {
        em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();
    }

    @Override
    public void delete(Factura entity) {
        em.getTransaction().begin();
        em.remove(em.merge(entity));
        em.getTransaction().commit();
    }

    @Override
    public Factura findById(int id) {
        return em.find(Factura.class, id);
    }

    @Override
    public List<Factura> findAll() {
        return em.createQuery("from Factura", Factura.class).getResultList();
    }
}
