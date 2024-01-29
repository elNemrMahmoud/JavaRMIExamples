package projects.SimpleRMI.Server;

import projects.SimpleRMI.Shared.ServerRemoteInterfaces;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServerRemoteImpl extends UnicastRemoteObject implements ServerRemoteInterfaces {

    ServerRemoteImpl() throws RemoteException {
        //super();

    }
    @Override
    public String sayHello(String name) throws RemoteException {
        return "Hello"+name;
    }
}
