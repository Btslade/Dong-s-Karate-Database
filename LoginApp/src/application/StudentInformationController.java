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
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;

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
		lastName.setCellFactory(TextFieldTableCell.forTableColumn());
		guardianName.setCellFactory(TextFieldTableCell.forTableColumn());
		testingDate.setCellFactory(TextFieldTableCell.forTableColumn());
		address.setCellFactory(TextFieldTableCell.forTableColumn());
		phoneNumber.setCellFactory(TextFieldTableCell.forTableColumn());
		email.setCellFactory(TextFieldTableCell.forTableColumn());
		colorOfBelt.setCellFactory(TextFieldTableCell.forTableColumn());
		colorOfStripe.setCellFactory(TextFieldTableCell.forTableColumn());
		
		
		age.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
		attendance.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
		degreeNum.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
		starNum.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
		
		
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
	public void onlNameChanged(TableColumn.CellEditEvent<Student, String> studentStringCellEditEvent)
	{
		try
		{
			Connection conn = SqliteConnection.Connector();
			Student student = studentTable.getSelectionModel().getSelectedItem();
			String oldLName = student.getLastName();
			student.setLastName(studentStringCellEditEvent.getNewValue());
			String sqlLNameUpdate = "UPDATE Students SET lname = ? WHERE fname = ? AND lname = ? AND age = ? AND id = ?";
	        PreparedStatement preparedStatement = conn.prepareStatement(sqlLNameUpdate);
	        preparedStatement.setString(1, studentStringCellEditEvent.getNewValue());
	        preparedStatement.setString(2, this.studentTable.getSelectionModel().getSelectedItem().getFirstName());
	        preparedStatement.setString(3, oldLName);
	        preparedStatement.setInt(4, this.studentTable.getSelectionModel().getSelectedItem().getAge());
	        preparedStatement.setInt(5, this.studentTable.getSelectionModel().getSelectedItem().getId());
	        preparedStatement.execute();
	        preparedStatement.close();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}

	}
	
	@FXML
	public void onguardianChanged(TableColumn.CellEditEvent<Student, String> studentStringCellEditEvent)
	{
		try
		{
			Connection conn = SqliteConnection.Connector();
			Student student = studentTable.getSelectionModel().getSelectedItem();
			student.setGuardianName(studentStringCellEditEvent.getNewValue());
			String sqlGuardianUpdate = "UPDATE Students SET guardian = ? WHERE fname = ? AND lname = ? AND age = ? AND id = ?";
	        PreparedStatement preparedStatement = conn.prepareStatement(sqlGuardianUpdate);
	        preparedStatement.setString(1, studentStringCellEditEvent.getNewValue());
	        preparedStatement.setString(2, this.studentTable.getSelectionModel().getSelectedItem().getFirstName());
	        preparedStatement.setString(3, this.studentTable.getSelectionModel().getSelectedItem().getLastName());
	        preparedStatement.setInt(4, this.studentTable.getSelectionModel().getSelectedItem().getAge());
	        preparedStatement.setInt(5, this.studentTable.getSelectionModel().getSelectedItem().getId());
	        preparedStatement.execute();
	        preparedStatement.close();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	@FXML
	public void onageChanged(TableColumn.CellEditEvent<Student, Integer> studentIntCellEditEvent)
	{
		try
		{
			Connection conn = SqliteConnection.Connector();
			Student student = studentTable.getSelectionModel().getSelectedItem();
			int oldAge = student.getAge();
			student.setAge(studentIntCellEditEvent.getNewValue());
			String sqlAgeUpdate = "UPDATE Students SET age = ? WHERE fname = ? AND lname = ? AND age = ? AND id = ?";
	        PreparedStatement preparedStatement = conn.prepareStatement(sqlAgeUpdate);
	        preparedStatement.setInt(1, studentIntCellEditEvent.getNewValue());
	        preparedStatement.setString(2, this.studentTable.getSelectionModel().getSelectedItem().getFirstName());
	        preparedStatement.setString(3, this.studentTable.getSelectionModel().getSelectedItem().getLastName());
	        preparedStatement.setInt(4, oldAge);
	        preparedStatement.setInt(5, this.studentTable.getSelectionModel().getSelectedItem().getId());
	        preparedStatement.execute();
	        preparedStatement.close();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	@FXML
	public void ontestingDateChanged(TableColumn.CellEditEvent<Student, String> studentStringCellEditEvent)
	{
		try
		{
			Connection conn = SqliteConnection.Connector();
			Student student = studentTable.getSelectionModel().getSelectedItem();
			student.setTestingDate(studentStringCellEditEvent.getNewValue());
			String sqlTestingDateUpdate = "UPDATE Students SET testingDate = ? WHERE fname = ? AND lname = ? AND age = ? AND id = ?";
	        PreparedStatement preparedStatement = conn.prepareStatement(sqlTestingDateUpdate);
	        preparedStatement.setString(1, studentStringCellEditEvent.getNewValue());
	        preparedStatement.setString(2, this.studentTable.getSelectionModel().getSelectedItem().getFirstName());
	        preparedStatement.setString(3, this.studentTable.getSelectionModel().getSelectedItem().getLastName());
	        preparedStatement.setInt(4, this.studentTable.getSelectionModel().getSelectedItem().getAge());
	        preparedStatement.setInt(5, this.studentTable.getSelectionModel().getSelectedItem().getId());
	        preparedStatement.execute();
	        preparedStatement.close();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	@FXML
	public void onattendanceChanged(TableColumn.CellEditEvent<Student, Integer> studentIntCellEditEvent)
	{
		try
		{
			Connection conn = SqliteConnection.Connector();
			Student student = studentTable.getSelectionModel().getSelectedItem();
			student.setAttendance(studentIntCellEditEvent.getNewValue());
			String sqlAttendanceUpdate = "UPDATE Students SET attendance = ? WHERE fname = ? AND lname = ? AND age = ? AND id = ?";
	        PreparedStatement preparedStatement = conn.prepareStatement(sqlAttendanceUpdate);
	        preparedStatement.setInt(1, studentIntCellEditEvent.getNewValue());
	        preparedStatement.setString(2, this.studentTable.getSelectionModel().getSelectedItem().getFirstName());
	        preparedStatement.setString(3, this.studentTable.getSelectionModel().getSelectedItem().getLastName());
	        preparedStatement.setInt(4, this.studentTable.getSelectionModel().getSelectedItem().getAge());
	        preparedStatement.setInt(5, this.studentTable.getSelectionModel().getSelectedItem().getId());
	        preparedStatement.execute();
	        preparedStatement.close();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		
	}
	
	@FXML
	public void onaddressChanged(TableColumn.CellEditEvent<Student, String> studentStringCellEditEvent)
	{
		try
		{
			Connection conn = SqliteConnection.Connector();
			Student student = studentTable.getSelectionModel().getSelectedItem();
			student.setAdress(studentStringCellEditEvent.getNewValue());
			String sqlAddressUpdate = "UPDATE Students SET address = ? WHERE fname = ? AND lname = ? AND age = ? AND id = ?";
	        PreparedStatement preparedStatement = conn.prepareStatement(sqlAddressUpdate);
	        preparedStatement.setString(1, studentStringCellEditEvent.getNewValue());
	        preparedStatement.setString(2, this.studentTable.getSelectionModel().getSelectedItem().getFirstName());
	        preparedStatement.setString(3, this.studentTable.getSelectionModel().getSelectedItem().getLastName());
	        preparedStatement.setInt(4, this.studentTable.getSelectionModel().getSelectedItem().getAge());
	        preparedStatement.setInt(5, this.studentTable.getSelectionModel().getSelectedItem().getId());
	        preparedStatement.execute();
	        preparedStatement.close();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	@FXML
	public void onphoneNumberChanged(TableColumn.CellEditEvent<Student, String> studentStringCellEditEvent)
	{
		try
		{
			Connection conn = SqliteConnection.Connector();
			Student student = studentTable.getSelectionModel().getSelectedItem();
			student.setPhoneNumber(studentStringCellEditEvent.getNewValue());
			String sqlPhoneNumberUpdate = "UPDATE Students SET phoneNumber = ? WHERE fname = ? AND lname = ? AND age = ? AND id = ?";
	        PreparedStatement preparedStatement = conn.prepareStatement(sqlPhoneNumberUpdate);
	        preparedStatement.setString(1, studentStringCellEditEvent.getNewValue());
	        preparedStatement.setString(2, this.studentTable.getSelectionModel().getSelectedItem().getFirstName());
	        preparedStatement.setString(3, this.studentTable.getSelectionModel().getSelectedItem().getLastName());
	        preparedStatement.setInt(4, this.studentTable.getSelectionModel().getSelectedItem().getAge());
	        preparedStatement.setInt(5, this.studentTable.getSelectionModel().getSelectedItem().getId());
	        preparedStatement.execute();
	        preparedStatement.close();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	@FXML
	public void onemailChanged(TableColumn.CellEditEvent<Student, String> studentStringCellEditEvent)
	{
		try
		{
			Connection conn = SqliteConnection.Connector();
			Student student = studentTable.getSelectionModel().getSelectedItem();
			student.setEmail(studentStringCellEditEvent.getNewValue());
			String sqlEmailUpdate = "UPDATE Students SET email = ? WHERE fname = ? AND lname = ? AND age = ? AND id = ?";
	        PreparedStatement preparedStatement = conn.prepareStatement(sqlEmailUpdate);
	        preparedStatement.setString(1, studentStringCellEditEvent.getNewValue());
	        preparedStatement.setString(2, this.studentTable.getSelectionModel().getSelectedItem().getFirstName());
	        preparedStatement.setString(3, this.studentTable.getSelectionModel().getSelectedItem().getLastName());
	        preparedStatement.setInt(4, this.studentTable.getSelectionModel().getSelectedItem().getAge());
	        preparedStatement.setInt(5, this.studentTable.getSelectionModel().getSelectedItem().getId());
	        preparedStatement.execute();
	        preparedStatement.close();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	@FXML
	public void onbeltColorChanged(TableColumn.CellEditEvent<Student, String> studentStringCellEditEvent)
	{
		try
		{
			Connection conn = SqliteConnection.Connector();
			Student student = studentTable.getSelectionModel().getSelectedItem();
			student.setBeltColor(studentStringCellEditEvent.getNewValue());
			String sqlBeltColorUpdate = "UPDATE Students SET BeltColor = ? WHERE fname = ? AND lname = ? AND age = ? AND id = ?";
	        PreparedStatement preparedStatement = conn.prepareStatement(sqlBeltColorUpdate);
	        preparedStatement.setString(1, studentStringCellEditEvent.getNewValue());
	        preparedStatement.setString(2, this.studentTable.getSelectionModel().getSelectedItem().getFirstName());
	        preparedStatement.setString(3, this.studentTable.getSelectionModel().getSelectedItem().getLastName());
	        preparedStatement.setInt(4, this.studentTable.getSelectionModel().getSelectedItem().getAge());
	        preparedStatement.setInt(5, this.studentTable.getSelectionModel().getSelectedItem().getId());
	        preparedStatement.execute();
	        preparedStatement.close();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	@FXML
	public void ondegreeChanged(TableColumn.CellEditEvent<Student, Integer> studentIntCellEditEvent)
	{
		try
		{
			Connection conn = SqliteConnection.Connector();
			Student student = studentTable.getSelectionModel().getSelectedItem();
			student.setDegreeNum(studentIntCellEditEvent.getNewValue());
			String sqlDegreeUpdate = "UPDATE Students SET degree = ? WHERE fname = ? AND lname = ? AND age = ? AND id = ?";
	        PreparedStatement preparedStatement = conn.prepareStatement(sqlDegreeUpdate);
	        preparedStatement.setInt(1, studentIntCellEditEvent.getNewValue());
	        preparedStatement.setString(2, this.studentTable.getSelectionModel().getSelectedItem().getFirstName());
	        preparedStatement.setString(3, this.studentTable.getSelectionModel().getSelectedItem().getLastName());
	        preparedStatement.setInt(4, this.studentTable.getSelectionModel().getSelectedItem().getAge());
	        preparedStatement.setInt(5, this.studentTable.getSelectionModel().getSelectedItem().getId());
	        preparedStatement.execute();
	        preparedStatement.close();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	@FXML
	public void onnumOfStarsChanged(TableColumn.CellEditEvent<Student, Integer> studentIntCellEditEvent)
	{
		try
		{
			Connection conn = SqliteConnection.Connector();
			Student student = studentTable.getSelectionModel().getSelectedItem();
			student.setStarNum(studentIntCellEditEvent.getNewValue());
			String sqlNumOfStarsUpdate = "UPDATE Students SET numOfStars = ? WHERE fname = ? AND lname = ? AND age = ? AND id = ?";
	        PreparedStatement preparedStatement = conn.prepareStatement(sqlNumOfStarsUpdate);
	        preparedStatement.setInt(1, studentIntCellEditEvent.getNewValue());
	        preparedStatement.setString(2, this.studentTable.getSelectionModel().getSelectedItem().getFirstName());
	        preparedStatement.setString(3, this.studentTable.getSelectionModel().getSelectedItem().getLastName());
	        preparedStatement.setInt(4, this.studentTable.getSelectionModel().getSelectedItem().getAge());
	        preparedStatement.setInt(5, this.studentTable.getSelectionModel().getSelectedItem().getId());
	        preparedStatement.execute();
	        preparedStatement.close();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	@FXML
	public void onbeltStripeColorChanged(TableColumn.CellEditEvent<Student, String> studentStringCellEditEvent)
	{
		try
		{
			Connection conn = SqliteConnection.Connector();
			Student student = studentTable.getSelectionModel().getSelectedItem();
			student.setStripeColor(studentStringCellEditEvent.getNewValue());
			String sqlStripeColorUpdate = "UPDATE Students SET beltStripeColor = ? WHERE fname = ? AND lname = ? AND age = ? AND id = ?";
	        PreparedStatement preparedStatement = conn.prepareStatement(sqlStripeColorUpdate);
	        preparedStatement.setString(1, studentStringCellEditEvent.getNewValue());
	        preparedStatement.setString(2, this.studentTable.getSelectionModel().getSelectedItem().getFirstName());
	        preparedStatement.setString(3, this.studentTable.getSelectionModel().getSelectedItem().getLastName());
	        preparedStatement.setInt(4, this.studentTable.getSelectionModel().getSelectedItem().getAge());
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
			((Node)event1.getSource()).getScene().getWindow().hide();
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
