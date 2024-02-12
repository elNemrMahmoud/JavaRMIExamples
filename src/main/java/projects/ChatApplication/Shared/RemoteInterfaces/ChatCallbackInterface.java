package projects.ChatApplication.Shared.RemoteInterfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ChatCallbackInterface  extends Remote {
    static final long serialVersionUID = 1L;
    void recieveMessage(String message) throws RemoteException;
}
