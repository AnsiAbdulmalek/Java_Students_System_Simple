package ansi;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

//najem
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import java.sql.*;
//import javafx.scene.control.Alert;

//hany
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import javafx.scene.control.Alert;
//import javafx.scene.control.RadioButton;
//import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author Ansi Abdulmalek
 */
public class AddStudentController implements Initializable
{

    @FXML
    private TextField tf_name;
    @FXML
    private TextField tf_age;
    @FXML
    private TextField tf_phone_nymber;
    @FXML
    private TextField tf_address;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
    }    

    @FXML
    private void save(ActionEvent event) throws SQLException
    {
        try
        {
            String name = tf_name.getText();
            int age = Integer.parseInt(tf_age.getText());
            int phone_number = Integer.parseInt(tf_phone_nymber.getText());
            String address = tf_address.getText();
            
            Class.forName("org.sqlite.JDBC");
            Connection con = DriverManager.getConnection("jdbc:sqlite:D:\\All_DBeaver_db\\NewStudent.db");
            PreparedStatement ps = con.prepareStatement("INSERT INTO Student_Data (name,age,phone_number,address)VALUES (?,?,?,? )");
            
            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setInt(3, phone_number);
            ps.setString(4, address);
            int affectedrows = ps.executeUpdate();
            if(affectedrows> 0)
            {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Data Insertions!");
                alert.setContentText(name+"'s contact was added succ! ");
                clear(event);
                alert.show();
            }
            else
            {
                System.out.println("Error");
            }
            con.close();
            
        } catch (NumberFormatException | ClassNotFoundException numberFormatException)
        {
            System.out.println(numberFormatException);
        }
    }

    @FXML
    private void clear(ActionEvent event)
    {
        tf_name.clear();
        tf_age.clear();
        tf_phone_nymber.clear();
        tf_address.clear();
    }
    
}
