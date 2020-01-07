import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private static final Logger LOGGER = Logger.getLogger("JPA");

    public static void main(String[] args) {
        //Main main = new Main();
        //main.run();




        EntityManagerFactory factory = Persistence.createEntityManagerFactory("test");
        EntityManager em = factory.createEntityManager();


        em.getTransaction().begin();
        em.getTransaction().commit();
    }

    public void run(){
        EntityManagerFactory factory = null;
        EntityManager entityManager = null;
        try {
            factory = Persistence.createEntityManagerFactory("test");
            entityManager = factory.createEntityManager();
            //persistPerson(entityManager);

        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
            e.printStackTrace();
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
            if (factory != null) {
                factory.close();
            }
        }
    }


}
