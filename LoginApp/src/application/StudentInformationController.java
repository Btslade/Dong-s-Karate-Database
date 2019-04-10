package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class StudentInformationController implements Initializable {

	@FXML
	private TextField firstname;
	@FXML
	private TextField lastname;
	@FXML
	private DatePicker testingdate;
	@FXML
	private TextField colorbelt;
	@FXML
	private TextField degree;
	@FXML
	private TextField numofstars;
	@FXML
	private TextField beltstripe;
	@FXML
	private TableView<Student> studentTable;
	@FXML
	private TableColumn<Student, String> firstName;
	@FXML
	private TableColumn<Student, String> lastName;
	@FXML
	private TableColumn<Student, String> testingDate;
	@FXML
	private TableColumn<Student, Integer> attendance;
	@FXML
	private TableColumn<Student, Integer> age;
	@FXML
	private TableColumn<Student, String> guardianName;
	@FXML
	private TableColumn<Student, String> address;
	@FXML
	private TableColumn<Student, String> phoneNumber;
	@FXML
	private TableColumn<Student, String> email;
	@FXML
	private TableColumn<Student, String> colorOfBelt;
	@FXML
	private TableColumn<Student, Integer> degreeNum;
	@FXML
	private TableColumn<Student, Integer> starNum;
	@FXML
	private TableColumn<Student, String> colorOfStripe;
	@FXML
	private SqliteConnection db;
	@FXML
	private ObservableList<Student> data;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		studentTable.setEditable(true);
		firstName.setCellFactory(TextFieldTableCell.forTableColumn());
		
	}
		
	@FXML
	public void onfNameChanged(TableColumn.CellEditEvent<Student, String> studentStringCellEditEvent)
	{
		try
		{
			Connection conn = SqliteConnection.Connector();
			Student student = studentTable.getSelectionModel().getSelectedItem();
			String oldFName = student.getFirstName();
			student.setFirstName(studentStringCellEditEvent.getNewValue());
			String sqlFNameUpdate = "UPDATE Students SET fname = ? WHERE fname = ? AND lname = ? AND age = ? AND id = ?";
	        PreparedStatement preparedStatement = conn.prepareStatement(sqlFNameUpdate);
	        preparedStatement.setString(1, studentStringCellEditEvent.getNewValue());
	        //System.out.println(studentStringCellEditEvent.getNewValue());
	        preparedStatement.setString(2, oldFName);
	        //System.out.println(oldFName);
	        preparedStatement.setString(3, this.studentTable.getSelectionModel().getSelectedItem().getLastName());
	        //System.out.println(this.studentTable.getSelectionModel().getSelectedItem().getLastName());
	        preparedStatement.setInt(4, this.studentTable.getSelectionModel().getSelectedItem().getAge());
	        //System.out.println(this.studentTable.getSelectionModel().getSelectedItem().getAge());
	        preparedStatement.setInt(5, this.studentTable.getSelectionModel().getSelectedItem().getId());
	        preparedStatement.execute();
	        preparedStatement.close();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}

	}
	
	@FXML
	public void SearchDatabase(ActionEvent event0)
	{
		try
		{
			Connection conn = SqliteConnection.Connector();
			this.data = FXCollections.observableArrayList();

			String sqlSearchFinal = "Select * FROM Students WHERE fname LIKE ? AND lname LIKE ? AND testingDate LIKE ? AND BeltColor LIKE ? AND degree LIKE ? AND numOfStars LIKE ? AND beltStripeColor LIKE ?";
		
	            PreparedStatement preparedStatement = conn.prepareStatement(sqlSearchFinal);
	            preparedStatement.setString(1, "%" + this.firstname.getText() +"%");
	            preparedStatement.setString(2, "%" +this.lastname.getText() + "%");
				preparedStatement.setString(3, "%" +this.testingdate.getEditor().getText()+ "%");
				preparedStatement.setString(4, "%" +this.colorbelt.getText() + "%");
				preparedStatement.setString(5, "%" + this.degree.getText() + "%");
				preparedStatement.setString(6, "%" + this.numofstars.getText() +"%");
				preparedStatement.setString(7, "%" +this.beltstripe.getText() + "%");
				ResultSet rs = preparedStatement.executeQuery();
				while(rs.next())
				{
					this.data.add(new Student(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getInt(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getInt(12), rs.getInt(13), rs.getString(14)));
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
				rs.close();
				conn.close();
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
			this.firstName.setCellValueFactory(new PropertyValueFactory<Student, String> ("firstName"));
			this.lastName.setCellValueFactory(new PropertyValueFactory <Student, String> ("lastName"));
			this.attendance.setCellValueFactory(new PropertyValueFactory <Student, Integer> ("attendance"));
			this.testingDate.setCellValueFactory(new PropertyValueFactory <Student, String> ("testingDate"));
			this.attendance.setCellValueFactory(new PropertyValueFactory <Student, Integer> ("attendance"));
			this.age.setCellValueFactory(new PropertyValueFactory <Student, Integer> ("age"));
			this.guardianName.setCellValueFactory(new PropertyValueFactory <Student, String> ("guardianName"));
			this.address.setCellValueFactory(new PropertyValueFactory <Student, String> ("adress"));
			this.phoneNumber.setCellValueFactory(new PropertyValueFactory <Student, String> ("phoneNumber"));
			this.email.setCellValueFactory(new PropertyValueFactory <Student, String> ("email"));
			this.colorOfBelt.setCellValueFactory(new PropertyValueFactory <Student, String> ("colorOfBelt"));
			this.degreeNum.setCellValueFactory(new PropertyValueFactory <Student, Integer> ("degreeNum"));
			this.starNum.setCellValueFactory(new PropertyValueFactory <Student, Integer> ("starNum"));
			this.colorOfStripe.setCellValueFactory(new PropertyValueFactory <Student, String> ("colorOfStripe"));
			this.studentTable.setItems(this.data);
					
	}
	
	
	
	
	
	@FXML
	public void SearchByEligibility(ActionEvent event2)
	{
		try
		{
			Connection conn = SqliteConnection.Connector();
			this.data = FXCollections.observableArrayList();

			String sqlSearch = "SELECT * FROM Students WHERE attendance > 18";

	            PreparedStatement preparedStatement = conn.prepareStatement(sqlSearch);
				ResultSet rs = preparedStatement.executeQuery();
				while(rs.next())
				{
					this.data.add(new Student(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getInt(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getInt(12), rs.getInt(13), rs.getString(14)));

				}
				//rs.close();
				//conn.close();
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
			this.firstName.setCellValueFactory(new PropertyValueFactory<Student, String> ("firstName"));
			this.lastName.setCellValueFactory(new PropertyValueFactory <Student, String> ("lastName"));
			this.attendance.setCellValueFactory(new PropertyValueFactory <Student, Integer> ("attendance"));
			this.testingDate.setCellValueFactory(new PropertyValueFactory <Student, String> ("testingDate"));
			this.attendance.setCellValueFactory(new PropertyValueFactory <Student, Integer>("attendance"));
			this.age.setCellValueFactory(new PropertyValueFactory<Student, Integer>("age"));
			this.guardianName.setCellValueFactory(new PropertyValueFactory <Student, String> ("guardianName"));
			this.address.setCellValueFactory(new PropertyValueFactory<Student, String> ("adress"));
			this.phoneNumber.setCellValueFactory(new PropertyValueFactory<Student, String>("phoneNumber"));
			this.email.setCellValueFactory(new PropertyValueFactory<Student, String>("email"));
			this.colorOfBelt.setCellValueFactory(new PropertyValueFactory <Student, String>("colorOfBelt"));
			this.degreeNum.setCellValueFactory(new PropertyValueFactory<Student, Integer> ("degreeNum"));
			this.starNum.setCellValueFactory(new PropertyValueFactory<Student, Integer> ("starNum"));
			this.colorOfStripe.setCellValueFactory(new PropertyValueFactory<Student, String>("colorOfStripe"));
			this.studentTable.setItems(this.data);
		
	}
	
	
	
	
	
	
	
	
	@FXML
		public void goBack (ActionEvent event1)
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
