package projects.ChatApplication.Server;

import projects.ChatApplication.Shared.RemoteInterfaces.ChatRemoteInterface;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    public static void main(String[] args) {
        try {
            ChatRemoteInterface server = new ChatServer();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("Chat",server);
            System.out.println("Server Started");
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }
}
