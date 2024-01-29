package projects.EmployeeRMI.client;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class client extends Application {



    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/EmployeeRMI/Dashboard.fxml"));
            Parent root = loader.load();
            primaryStage.setTitle("Client Interface");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        }catch(Exception e)
        {
            //System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    public static void main(String [] args)
    {
        launch(args);
    }
}
