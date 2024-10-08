/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ansi;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Ansi Abdulmalek
 */
public class HomeController implements Initializable
{

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
    }    

    @FXML
    private void addStudent_btn(ActionEvent event)
    {
        Stage primaryStage = new Stage();
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("AddStudent.fxml"));
            
            Scene scene = new Scene(root);
            
            primaryStage.setTitle("Hello World!");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException iOException)
        {
            System.out.println(iOException);
        }
    }

    @FXML
    private void showStudent_btn(ActionEvent event)
    {
        Stage primaryStage = new Stage();
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("ShowStudent.fxml"));
            
            Scene scene = new Scene(root);
            
            primaryStage.setTitle("Hello World!");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException iOException)
        {
            System.out.println(iOException);
        }
    }
    
}
