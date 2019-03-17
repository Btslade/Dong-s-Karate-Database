package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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
	private TableColumn<Student, String> colorBelt;
	@FXML
	private TableColumn<Student, String> degreeNum;
	@FXML
	private TableColumn<Student, String> numOfStars;
	@FXML
	private TableColumn<Student, String> beltStripe;
	@FXML
	private TableColumn<Student, String> attendance;
	@FXML
	private TableColumn<Student, String> age;
	@FXML
	private TableColumn<Student, String> guardian;
	@FXML
	private TableColumn<Student, String> address;
	@FXML
	private TableColumn<Student, String> phonenumber;
	@FXML
	private TableColumn<Student, String> email;
	private SqliteConnection db;
	private ObservableList<Student> data;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		
	}
		
	
	
	@FXML
	public void SearchDatabase(ActionEvent event0)
	{
		String sqlSearchBuild= "SELECT * FROM Students, ColorBelt WHERE";
		boolean firstTime = true;
		
		///FIRST NAME
		if(!this.firstname.getText().equals("") && firstTime )
		{
			sqlSearchBuild = sqlSearchBuild +" Students.fname = ?";
			firstTime = false;
		}
		
		
		
		////LAST NAME
		if(!this.lastname.getText().equals("") && firstTime)
		{
			sqlSearchBuild = sqlSearchBuild + " Students.lname = ?";
			firstTime = false;
		}
		else if(!this.lastname.getText().equals("") && !firstTime)
		{
			sqlSearchBuild = sqlSearchBuild + " AND Students.lname = ?";
		}
		
		
		
		
		
		////TESTING DATE
		if(!this.testingdate.getEditor().getText().equals("")&& firstTime)
		{
			sqlSearchBuild = sqlSearchBuild + " Students.testingDate = ?";
			firstTime = false;
		}
		else if(!this.lastname.getText().equals("") && !firstTime)
		{
			sqlSearchBuild = sqlSearchBuild + " AND Students.testingDate = ?";
		}
		
		
		
		///BELT COLOR
		if(!this.colorbelt.getText().equals("") && firstTime)
		{
			sqlSearchBuild = sqlSearchBuild + "ColorBelt.BeltColor = ?";
			firstTime = false;
		}
		else if(!this.colorbelt.getText().equals("") && !firstTime )
		{
			sqlSearchBuild = sqlSearchBuild + " AND ColorBelt.BeltColor = ?";
		}
		
		
		
		
		//BLACK BELT DEGREE
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		if(!this.testingdate.getEditor().getText().equals(""))
		{
			sqlSearchBuild = sqlSearchBuild + "testingDate = ?";
		}
		//String sqlSearch1 = "SELECT * FROM Students, BlackBelt WHERE Students.fname = ? AND Students.lname = ? AND Students.testingDate = ? AND BlackBelt.degree = ? AND BlackBelt.numOfStars = ?";
		
		
	}
	public void SearchByEligibility(ActionEvent event2)
	{
		String sqlSearch = "SELECT * FROM Students WHERE attendance > 20";
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
