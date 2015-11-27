package pod;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author joaomarcos
 */
public class Main {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("192.168.1.103", 10004);
            AccountManager lookup =(AccountManager) registry.lookup("AccountManager");
            
            lookup.transfer("D", 100);
        } catch (RemoteException | NotBoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
