package ansi;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

//najem
//import java.sql.*;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.scene.control.Alert;
//import javafx.scene.control.cell.PropertyValueFactory;

//hany
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.scene.control.Alert;
//import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Ansi Abdulmalek
 */
public class ShowStudentController implements Initializable
{

    @FXML
    private TableView<Student> tv_student;
    @FXML
    private TableColumn<Student, Integer> tc_id;
    @FXML
    private TableColumn<Student, String> tc_name;
    @FXML
    private TableColumn<Student, Integer> tc_age;
    @FXML
    private TableColumn<Student, Integer> tc_phone_number;
    @FXML
    private TableColumn<Student, String> tc_address;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        ObservableList<Student> list = FXCollections.observableArrayList();
        try
        {
            Class.forName("org.sqlite.JDBC");
            Connection con = DriverManager.getConnection("jdbc:sqlite:D:\\All_DBeaver_db\\NewStudent.db");
            PreparedStatement ps = con.prepareStatement("select * from Student_Data");
            ResultSet rs = ps.executeQuery();
           
            while(rs.next())
            {
                Student s = new Student(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getInt("phone_number"),
                        rs.getString("address"));
                list.add(s);
            }
            
            tc_id.setCellValueFactory(new PropertyValueFactory<>("id"));
            tc_name.setCellValueFactory(new PropertyValueFactory<>("name"));
            tc_age.setCellValueFactory(new PropertyValueFactory<>("age"));
            tc_phone_number.setCellValueFactory(new PropertyValueFactory<>("phone_number"));
            tc_address.setCellValueFactory(new PropertyValueFactory<>("address"));
            
            
            tv_student.setItems(list);
            
            con.close();
        } catch (Exception e)
        {
            System.out.println(e);
        }
    }    
    
}
