package projects.SimpleRMI.Client;

import projects.SimpleRMI.Shared.ServerRemoteInterfaces;

import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Arrays;

public class Client {
    public static void main(String[] args) {
        new Client();
    }
    public Client() {
        try {
            Registry reg = LocateRegistry.getRegistry("localhost");
            ServerRemoteInterfaces cli = (ServerRemoteInterfaces) reg.lookup("HelloService");
            String str = cli.sayHello("ITI!");
            System.out.println(str);
            String[] services = reg.list();
            Arrays.stream(services).forEach(System.out::println);

        } catch (NotBoundException e) {
            System.out.println(e.getMessage());
        } catch (AccessException e) {
            System.out.println(e.getMessage());
        } catch (RemoteException e) {
            System.out.println(e.getMessage());
        }
    }
}
