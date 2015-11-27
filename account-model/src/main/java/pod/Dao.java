package pod;

import javax.persistence.EntityManager;

/**
 *
 * @author joaomarcos
 */
public class Dao<T> {

    private EntityManager em;
    
    public Dao(EntityManager em) {
        this.em = em;
    }

    public void persist(T object) {
        em.persist(object);
    }

    public void update(T object) {
        em.merge(object);
    }

    public T find(Object key, Class clazz) {
        Object find = em.find(clazz, key);
        return (T) find;
    }
}
