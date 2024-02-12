package projects.ChatApplication.Client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import projects.ChatApplication.Shared.RemoteInterfaces.ChatCallbackInterface;
import projects.ChatApplication.Shared.RemoteInterfaces.ChatRemoteInterface;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ChatClient extends Application {

    public static ChatRemoteInterface server;
    @Override
    public void start(Stage stage) throws Exception {
        try{
            Registry registry = LocateRegistry.getRegistry("localhost",1099);
            ChatRemoteInterface server1 = (ChatRemoteInterface) registry.lookup("Chat");
            server = server1;


            FXMLLoader loader = new FXMLLoader(getClass().getResource("/dashboard.fxml"));
            Parent root = loader.load();

            ChatCallbackInterface client = new callbackImpl();
            server.registerClient(client);



            stage.setTitle("Chat App");
            stage.setScene(new Scene(root));
            stage.show();

        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
