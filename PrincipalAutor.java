public class PrincipalAutor {

     public static void main(String[] args) {
         ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
         EntityManager entityManager = context.getBean(EntityManager.class);
         EntityTransaction transaction = entityManager.getTransaction();
 
         try {
             transaction.begin();
 
             // Insertar un nuevo autor
             Autor autor = new Autor();
             autor.setNombre("Isaac Asimov");
             autor.setNacionalidad("Ruso-Americano");
             entityManager.persist(autor);
 
             // Consultar todos los autores
             List<Autor> autores = entityManager.createQuery("from Autor", Autor.class).getResultList();
             for (Autor a : autores) {
                 System.out.println(a.getIdAutor() + " - " + a.getNombre() + " - " + a.getNacionalidad());
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
 