package service.session;

import javax.persistence.*;
import java.util.List;

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

    public <T> List<T> findAll(Class<T> entityClass){
        String hql = "from " + entityClass.getSimpleName();
        Query query = em.createQuery(hql);
        List<T> tList = (List<T>) query.getResultList();
        return tList;
    }

    public <T> List<T> findByJpaQl(String jpaQl, float n){
        Query query = em.createQuery(jpaQl);
        query.setParameter("n", n);
        List<T> t = (List<T>) query.getResultList();
        return t;
    }

    public <T> List<T> findByJpaQl(String jpaQl, String str){
        Query query = em.createQuery(jpaQl);
        query.setParameter("str", str);
        List<T> t = (List<T>) query.getResultList();
        return t;
    }
}
