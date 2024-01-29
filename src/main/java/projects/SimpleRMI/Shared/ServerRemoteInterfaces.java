package projects.SimpleRMI.Shared;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServerRemoteInterfaces extends Remote {
    String sayHello (String name) throws RemoteException;
}
