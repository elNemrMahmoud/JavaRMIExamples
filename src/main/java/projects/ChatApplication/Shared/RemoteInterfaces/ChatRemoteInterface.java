package projects.ChatApplication.Shared.RemoteInterfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ChatRemoteInterface extends Remote {
    void sendMessage(String message) throws RemoteException;
    void registerClient(ChatCallbackInterface client) throws RemoteException;
}
