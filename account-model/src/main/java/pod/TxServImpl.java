package pod;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import javax.persistence.EntityManager;

/**
 *
 * @author joaomarcos
 */
public class TxServImpl extends UnicastRemoteObject implements TxServ {

    private final EntityManager em;

    public TxServImpl(EntityManager em) throws RemoteException {
        super();
        this.em = em;
    }

    @Override
    public void prepare() throws RemoteException {
        em.getTransaction().begin();
    }

    @Override
    public void commit() throws RemoteException {
        em.getTransaction().commit();
    }

    @Override
    public void rollback() throws RemoteException {
        em.getTransaction().rollback();
    }

}
