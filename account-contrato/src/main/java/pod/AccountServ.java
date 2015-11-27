package pod;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author joaomarcos
 */
public interface AccountServ extends Remote {

    /**
     * Realiza um débito de determinado valor de uma conta
     *
     * @param value
     * @throws RemoteException
     */
    public void debit(float value) throws RemoteException;

    /**
     * Credita determinado valor em uma conta.
     *
     * @param value
     * @throws RemoteException
     */
    public void credit(float value) throws RemoteException;
}
