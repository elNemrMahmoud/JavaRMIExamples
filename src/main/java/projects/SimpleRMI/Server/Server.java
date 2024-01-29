package projects.SimpleRMI.Server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    public static void main(String[] args){
        new Server();
    }
    public Server(){
        try{
            Registry reg;
            Remote impl = new ServerRemoteImpl();
            try {
               reg = LocateRegistry.createRegistry(1099);
            }catch(RemoteException e)
            {
                reg = LocateRegistry.getRegistry();

            }
            reg.rebind("HelloService",impl);

        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }
}
