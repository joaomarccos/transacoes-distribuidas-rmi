package pod;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 * Classe responsável por disponibilizar os serviços via RMI
 * @author joaomarcos
 */
public class Main {

    public static void main(String[] args) {
        try {            
            System.setProperty("java.rmi.server.hostname", "192.168.1.104");

            EntityManager em = Persistence.createEntityManagerFactory("io.github.joaomarccos_account-model_jar_1.0-SNAPSHOTPU").createEntityManager();

            AccountServImpl accountServImpl = new AccountServImpl(em);

            System.out.println("Disponiblizando AccountServ..");
            Registry registroAccountServ = LocateRegistry.createRegistry(10002);
            registroAccountServ.rebind("Account", accountServImpl);

            System.out.println("Disponiblizando TxServ..");
            Registry registroTx = LocateRegistry.createRegistry(10001);
            registroTx.rebind("TxServ", new TxServImpl(em));

        } catch (RemoteException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
