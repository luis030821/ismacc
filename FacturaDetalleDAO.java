import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class FacturaDetalleDAO implements GenericDAO<FacturaDetalle> {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("miUnidadDePersistencia");
    private EntityManager em = emf.createEntityManager();

    @Override
    public void save(FacturaDetalle entity) {
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
    }

    @Override
    public void update(FacturaDetalle entity) {
        em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();
    }

    @Override
    public void delete(FacturaDetalle entity) {
        em.getTransaction().begin();
        em.remove(em.merge(entity));
        em.getTransaction().commit();
    }

    @Override
    public FacturaDetalle findById(int id) {
        return em.find(FacturaDetalle.class, id);
    }

    @Override
    public List<FacturaDetalle> findAll() {
        return em.createQuery("from FacturaDetalle", FacturaDetalle.class).getResultList();
    }
}
