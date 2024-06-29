import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class LibroDAO implements GenericDAO<Libro> {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("miUnidadDePersistencia");
    private EntityManager em = emf.createEntityManager();

    @Override
    public void save(Libro entity) {
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
    }

    @Override
    public void update(Libro entity) {
        em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();
    }

    @Override
    public void delete(Libro entity) {
        em.getTransaction().begin();
        em.remove(em.merge(entity));
        em.getTransaction().commit();
    }

    @Override
    public Libro findById(int id) {
        return em.find(Libro.class, id);
    }

    @Override
    public List<Libro> findAll() {
        return em.createQuery("from Libro", Libro.class).getResultList();
    }
}
