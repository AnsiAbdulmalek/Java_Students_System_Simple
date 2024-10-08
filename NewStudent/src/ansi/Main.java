package ansi;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application
{
    @Override
    public void start(Stage primaryStage)
    {
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
            
            Scene scene = new Scene(root);
            
            primaryStage.setTitle("Hello World!");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException iOException)
        {
            System.out.println(iOException);
        }
    }

    public static void main(String[] args)
    {
        launch(args);
    }
    
}
