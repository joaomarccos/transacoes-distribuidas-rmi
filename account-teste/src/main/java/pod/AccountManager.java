package pod;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author joaomarcos
 */
public interface AccountManager extends Remote {

    public void transfer(String sourceAccount, float value) throws RemoteException;
    
}
