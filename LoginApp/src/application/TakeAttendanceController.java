package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class TakeAttendanceController implements  Initializable {
	
	@FXML
	private TextField firstname;
	@FXML
	private TextField lastname;
	@FXML
	private TableView<Student> studentTable;
	@FXML
	private TableColumn<Student, String> firstName;
	@FXML
	private TableColumn<Student, String> lastName;
	@FXML
	private TableColumn<Student, Integer> attendance;
	
	private SqliteConnection db;
	private ObservableList<Student> data;
	
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.db = new SqliteConnection();
		
		
	}
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	@FXML
	private void SearchStudentData(ActionEvent event1) throws SQLException
	{
		String sqlSearch = "SELECT* FROM Students WHERE fname = ? and lname = ?";
		String sqlSearch1 = "SELECT* FROM Students WHERE fname = ?";
		String sqlSearch2 = "SELECT* FROM Students WHERE lname =?";
		
		if(this.lastname.getText().equals(""))
		{
			try
			{
			
				Connection conn = SqliteConnection.Connector();
				PreparedStatement preparedStatement = conn.prepareStatement(sqlSearch1);
				this.data = FXCollections.observableArrayList();
				preparedStatement.setString(1, this.firstname.getText());
				ResultSet rs = preparedStatement.executeQuery();
				while(rs.next())
				{
					this.data.add(new Student(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getString(8), rs.getString(9), rs.getString(10)));
					/*Student student = new Student();
					student.setID(rs.getInt(1));
					student.setFirstName(rs.getString(2));
					student.setLastName(rs.getString(3));
					student.setGuardianName(rs.getString(4));
					student.setAge(rs.getInt(5));
					student.setTestingDate(rs.getString(6));
					student.setAttendance(rs.getInt(7));
					student.setAdress(rs.getString(8));
					student.setPhoneNumber(rs.getString(9));
					student.setEmail(rs.getString(10));*/
				}
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
			this.firstName.setCellValueFactory(new PropertyValueFactory<Student, String> ("firstName"));
			this.lastName.setCellValueFactory(new PropertyValueFactory <Student, String> ("lastName"));
			this.attendance.setCellValueFactory(new PropertyValueFactory <Student, Integer> ("attendance"));
			this.studentTable.setItems(this.data);
		}
		
		
		
		
		else if(this.firstname.getText().equals(""))
		{
			try
			{
			
				Connection conn = SqliteConnection.Connector();
				PreparedStatement preparedStatement = conn.prepareStatement(sqlSearch2);
				this.data = FXCollections.observableArrayList();
				preparedStatement.setString(1,this.lastname.getText());
				ResultSet rs = preparedStatement.executeQuery();
				while(rs.next())
				{
					this.data.add(new Student(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getString(8), rs.getString(9), rs.getString(10)));
					/*Student student = new Student();
					student.setID(rs.getInt(1));
					student.setFirstName(rs.getString(2));
					student.setLastName(rs.getString(3));
					student.setGuardianName(rs.getString(4));
					student.setAge(rs.getInt(5));
					student.setTestingDate(rs.getString(6));
					student.setAttendance(rs.getInt(7));
					student.setAdress(rs.getString(8));
					student.setPhoneNumber(rs.getString(9));
					student.setEmail(rs.getString(10));*/
				}
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
			this.firstName.setCellValueFactory(new PropertyValueFactory<Student, String> ("firstName"));
			this.lastName.setCellValueFactory(new PropertyValueFactory <Student, String> ("lastName"));
			this.attendance.setCellValueFactory(new PropertyValueFactory <Student, Integer> ("attendance"));
			this.studentTable.setItems(this.data);
		}
		
		
		
		
		
		else
		{
			try
			{
			
				Connection conn = SqliteConnection.Connector();
				PreparedStatement preparedStatement = conn.prepareStatement(sqlSearch);
				this.data = FXCollections.observableArrayList();
				preparedStatement.setString(1, this.firstname.getText());
				preparedStatement.setString(2,this.lastname.getText());
				ResultSet rs = preparedStatement.executeQuery();
				while(rs.next())
				{
					this.data.add(new Student(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getString(8), rs.getString(9), rs.getString(10)));
					/*Student student = new Student();
					student.setID(rs.getInt(1));
					student.setFirstName(rs.getString(2));
					student.setLastName(rs.getString(3));
					student.setGuardianName(rs.getString(4));
					student.setAge(rs.getInt(5));
					student.setTestingDate(rs.getString(6));
					student.setAttendance(rs.getInt(7));
					student.setAdress(rs.getString(8));
					student.setPhoneNumber(rs.getString(9));
					student.setEmail(rs.getString(10));*/
				}
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
			this.firstName.setCellValueFactory(new PropertyValueFactory<Student, String> ("firstName"));
			this.lastName.setCellValueFactory(new PropertyValueFactory <Student, String> ("lastName"));
			this.attendance.setCellValueFactory(new PropertyValueFactory <Student, Integer> ("attendance"));
			this.studentTable.setItems(this.data);
		}
		
		
	}
	
	
	
	
	
	
	
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	

	@FXML
	private void takeAttendance(ActionEvent event2) throws SQLException
	{
		String sqlTakeAttendance = "UPDATE Students SET attendance = attendance + 1 WHERE fname = ? and lname = ?";
		String sqlTakeAttendance1= "UPDATE Students SET attendance = attendance + 1 WHERE fname = ?";
		String sqlTakeAttendance2= "UPDATE Students SET attendance = attendance + 1 WHERE lname = ?";
		if(this.firstname.getText().equals(""))
		{
			try
			{
			
				Connection conn = SqliteConnection.Connector();
				PreparedStatement preparedStatement = conn.prepareStatement(sqlTakeAttendance2);
				this.data = FXCollections.observableArrayList();
				preparedStatement.setString(1,this.lastname.getText());
				preparedStatement.execute();
				SearchStudentData(event2);
			
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		
		
		if(this.lastname.getText().equals(""))
		{
			try
			{
			
				Connection conn = SqliteConnection.Connector();
				PreparedStatement preparedStatement = conn.prepareStatement(sqlTakeAttendance1);
				this.data = FXCollections.observableArrayList();
				preparedStatement.setString(1, this.firstname.getText());
				preparedStatement.execute();
				SearchStudentData(event2);
			
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
	
		
		else
		{
			try
			{
			
				Connection conn = SqliteConnection.Connector();
				PreparedStatement preparedStatement = conn.prepareStatement(sqlTakeAttendance);
				this.data = FXCollections.observableArrayList();
				preparedStatement.setString(1,this.firstname.getText());
				preparedStatement.setString(2, this.lastname.getText());
				preparedStatement.execute();
				SearchStudentData(event2);
			
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	@FXML
	private void removeAttendance(ActionEvent event3) throws SQLException
	{
		String sqlRemoveAttendance = "UPDATE Students SET attendance = attendance + -1 WHERE fname = ? and lname = ?";
		String sqlRemoveAttendance1 = "UPDATE Students SET attendance = attendance + -1 WHERE fname = ?";
		String sqlRemoveAttendance2 = "UPDATE Students SET attendance = attendance + -1 WHERE lname = ?";
		if(this.firstname.getText().equals(""))
		{
			try
			{
				
				Connection conn = SqliteConnection.Connector();
				PreparedStatement preparedStatement = conn.prepareStatement(sqlRemoveAttendance2);
				this.data = FXCollections.observableArrayList();
				preparedStatement.setString(1,this.lastname.getText());
				preparedStatement.execute();
				SearchStudentData(event3);
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		else if(this.lastname.getText().equals(""))
		{
			try
			{
				
				Connection conn = SqliteConnection.Connector();
				PreparedStatement preparedStatement = conn.prepareStatement(sqlRemoveAttendance1);
				this.data = FXCollections.observableArrayList();
				preparedStatement.setString(1,this.firstname.getText());
				preparedStatement.execute();
				SearchStudentData(event3);
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		else
		{
			try
			{
				
				Connection conn = SqliteConnection.Connector();
				PreparedStatement preparedStatement = conn.prepareStatement(sqlRemoveAttendance);
				this.data = FXCollections.observableArrayList();
				preparedStatement.setString(1, this.firstname.getText());
				preparedStatement.setString(2,this.lastname.getText());
				preparedStatement.execute();
				SearchStudentData(event3);
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		
	
	}
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	@FXML
	public void clearForm(ActionEvent event4)
	{
		this.firstname.setText("");
		this.lastname.setText("");
	}
	
	
	
	
	
	
	
	
	
	
	@FXML
	public void goBack (ActionEvent event5)
	{
		try 
		{
		Stage primaryStage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		Pane root;
		
			root = loader.load(getClass().getResource("/application/User.fxml").openStream());
			UserController userController = (UserController)loader.getController();
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

}
