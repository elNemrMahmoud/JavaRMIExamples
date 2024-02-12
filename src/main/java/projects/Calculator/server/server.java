package projects.Calculator.server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class server {
    public static void main(String[] args) {
        new server();
    }

    public server(){
        try{
            CalculatorRemoteImpl obj = new CalculatorRemoteImpl();
            Registry reg = LocateRegistry.createRegistry(1199);
            reg.rebind("CalculatorService",obj);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

}
