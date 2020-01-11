import entity.Boat;
import entity.Dock;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private static final Logger LOGGER = Logger.getLogger("session");

    public static void main(String[] args) {
        Main main = new Main();
        main.run();




        //EntityManagerFactory factory = Persistence.createEntityManagerFactory("test");
        //EntityManager em = factory.createEntityManager();


        //em.getTransaction().begin();
        //em.getTransaction().commit();
    }

    public void run(){
        EntityManagerFactory factory = null;
        EntityManager entityManager = null;
        try {
            factory = Persistence.createEntityManagerFactory("test");
            entityManager = factory.createEntityManager();
            persistDock(entityManager);

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

    private void persistDock(EntityManager entityManager){
        EntityTransaction transaction = entityManager.getTransaction();
        try{
            transaction.begin();
            Dock dock1 = new Dock();
            dock1.setNbLocation(10);
            entityManager.persist(dock1);
            transaction.commit();
        }catch (Exception e){
            if(transaction.isActive()){
                transaction.rollback();
            }
        }
    }

    private void persistBoat(EntityManager entityManager){
        EntityTransaction transaction = entityManager.getTransaction();
        try{
            transaction.begin();
            Boat boat1 = new Boat();
            boat1.setName("Boat1");
            boat1.setWight(200);
            entityManager.persist(boat1);
            transaction.commit();
        }catch (Exception e){
            if(transaction.isActive()){
                transaction.rollback();
            }
        }
    }

}
