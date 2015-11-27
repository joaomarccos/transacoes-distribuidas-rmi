package pod;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import javax.persistence.EntityManager;

/**
 *
 * @author joaomarcos
 */
public class AccountServImpl extends UnicastRemoteObject implements AccountServ {

    private final Account accountD;
    private final Dao<Account> dao;

    public AccountServImpl(EntityManager em) throws RemoteException {
        super();
        this.dao = new Dao(em);
        this.accountD = dao.find("D", Account.class);
    }

    @Override
    public void debit(float value) throws RemoteException {
        if (accountD.getBalance() >= value) {
            accountD.setBalance(accountD.getBalance() - value);
            dao.update(accountD);
        }
    }

    @Override
    public void credit(float value) throws RemoteException {
        accountD.setBalance(accountD.getBalance() + value);
        dao.update(accountD);
    }

}
