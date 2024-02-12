package projects.ChatApplication.Client;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import projects.ChatApplication.Shared.RemoteInterfaces.ChatCallbackInterface;
import projects.ChatApplication.Shared.RemoteInterfaces.ChatRemoteInterface;

import java.net.URL;
import java.rmi.RemoteException;
import java.util.ResourceBundle;

public class ChatController implements Initializable {

    @FXML
    private ListView<String> chatListView;

    public static ObservableList<String> chatMessages;


    @FXML
    private TextField messageInput;

    public void initialize(){

    }
    @FXML
    void sendMessage(ActionEvent event) {
        String message = messageInput.getText();
        if(!message.isEmpty()){
            try{
                ChatClient.server.sendMessage(message);
                messageInput.clear();
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public void recieveMessage(String message) throws RemoteException {
        chatMessages.add(message);

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        chatMessages = FXCollections.observableArrayList();
        chatListView.setItems(chatMessages);
    }
}
