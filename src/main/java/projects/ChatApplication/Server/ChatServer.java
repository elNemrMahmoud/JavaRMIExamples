package projects.ChatApplication.Server;

import projects.ChatApplication.Shared.RemoteInterfaces.ChatCallbackInterface;
import projects.ChatApplication.Shared.RemoteInterfaces.ChatRemoteInterface;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class ChatServer extends UnicastRemoteObject implements ChatRemoteInterface {
    private List<ChatCallbackInterface> clients;
    protected ChatServer() throws RemoteException {
        clients = new ArrayList<>();
    }

    @Override
    public void sendMessage(String message) throws RemoteException {
        for(ChatCallbackInterface client : clients){
            client.recieveMessage(message);
        }

    }

    @Override
    public void registerClient(ChatCallbackInterface client) throws RemoteException {
        clients.add(client);
    }
}
