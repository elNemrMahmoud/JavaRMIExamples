package projects.ChatApplication.Client;

import javafx.application.Platform;
import projects.ChatApplication.Shared.RemoteInterfaces.ChatCallbackInterface;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class callbackImpl extends UnicastRemoteObject implements ChatCallbackInterface, Serializable {
    private static final long serialVersionUID = -6164099372552737297L;

    protected callbackImpl() throws RemoteException {
    }

    @Override
    public void recieveMessage(String message) throws RemoteException {
       Platform.runLater(()->processMessage(message));
    }

    private void processMessage(String message) {
        // Process the message as needed
    ChatController.chatMessages.add(message);
    }
}
