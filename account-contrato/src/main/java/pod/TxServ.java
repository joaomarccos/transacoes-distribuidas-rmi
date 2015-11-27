package pod;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author joaomarcos
 */
public interface TxServ extends Remote {

    /**
     * Prepara a conta para realizar uma operação
     *
     * @throws RemoteException
     */
    public void prepare() throws RemoteException;

    /**
     * Confirma a operação realizada, salvando as alterações na base de dados
     *
     * @throws RemoteException
     */
    public void commit() throws RemoteException;

    /**
     * Cancela as operações não confirmadas fazendo com que as alterações sejam
     * revertidas.
     *
     * @throws RemoteException
     */
    public void rollback() throws RemoteException;
}
