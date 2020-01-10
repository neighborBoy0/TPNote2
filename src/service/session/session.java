package service.session;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

public class session<T> {
    private T t;

    @PersistenceContext(unitName = "session")
    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("test");
    protected EntityManager em = factory.createEntityManager();

    public session(){ }

    public <T> T queryByIndex(Class<? extends T> classT,int id){
        return em.find(classT,id);
    }

    public <T> void addT(T t){
        em.getTransaction().begin();
        em.persist(t);
        em.getTransaction().commit();
    }

    public <T> boolean removeT(Class<? extends T> classT, int index){
        T t = this.queryByIndex(classT, index);
        if(t == null){
            return false;
        }
        em.getTransaction().begin();
        em.remove(t);
        em.getTransaction().commit();
        return true;
    }
}
