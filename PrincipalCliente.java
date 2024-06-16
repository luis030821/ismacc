public class PrincipalCliente {

     public static void main(String[] args) {
         ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
         EntityManager entityManager = context.getBean(EntityManager.class);
         EntityTransaction transaction = entityManager.getTransaction();
 
         try {
             transaction.begin();
 
             // Insertar un nuevo cliente
             Cliente cliente = new Cliente();
             cliente.setNombre("John Doe");
             cliente.setDireccion("123 Main St");
             entityManager.persist(cliente);
 
             // Consultar todos los clientes
             List<Cliente> clientes = entityManager.createQuery("from Cliente", Cliente.class).getResultList();
             for (Cliente c : clientes) {
                 System.out.println(c.getIdCliente() + " - " + c.getNombre() + " - " + c.getDireccion());
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
 