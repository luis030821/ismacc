import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class PrincipalCategoria {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        EntityManager entityManager = context.getBean(EntityManager.class);
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();

            // Insertar una nueva categoría
            Categoria categoria = new Categoria();
            categoria.setNombre("Ciencia Ficción");
            entityManager.persist(categoria);

            // Consultar todas las categorías
            List<Categoria> categorias = entityManager.createQuery("from Categoria", Categoria.class).getResultList();
            for (Categoria c : categorias) {
                System.out.println(c.getIdCategoria() + " - " + c.getNombre());
            }

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }
}
