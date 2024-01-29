package projects.EmployeeRMI.server;

import projects.EmployeeRMI.server.service.EmployeeService;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    public static void main(String[] args) {
        new Server();
    }

    public Server(){
        try{
            EmployeeService obj = new EmployeeService();
            Registry reg = LocateRegistry.createRegistry(1999);
            reg.rebind("EmployeeService",obj);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }
}
