package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class AddLittleTigerController implements Initializable {

	@FXML
	private TextField firstname;
	@FXML
	private TextField lastname;
	@FXML
	private TextField guardianname;
	@FXML
	private TextField age;
	@FXML
	private DatePicker predictedTestingDate;
	@FXML
	private TextField address;
	@FXML
	private TextField phoneNumber;
	@FXML
	private TextField email;
	@FXML
	private TextField stripeColor;
	@FXML
	private SqliteConnection db;
	@FXML
	private ObservableList<Student> data;
	
	@Override
	
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	@FXML
	private void addColorBeltStudent(ActionEvent event1)
	{
		try
		{
			//////SEARCH TO SEE IF THEY MATCH
			String matchCheck = "SELECT * FROM Students WHERE fname = ? and lname = ?";
			Connection conn1 = SqliteConnection.Connector();
			PreparedStatement statementCheck = conn1.prepareStatement(matchCheck);
			statementCheck.setString(1, this.firstname.getText());
			statementCheck.setString(2, this.lastname.getText());
			ResultSet testResult = statementCheck.executeQuery();
			conn1.close();
			if(!testResult.next())
			{
			    try
			    {
				String sqlInsert = "INSERT INTO Students(fname, lname, guardian, age, testingDate, address, phoneNumber, email, attendance, beltStripeColor, BeltColor, degree, numOfStars) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
				Connection conn = SqliteConnection.Connector();
				PreparedStatement statement = conn.prepareStatement(sqlInsert);
				
				statement.setString(1, this.firstname.getText());
				statement.setString(2, this.lastname.getText());
				statement.setString(3, this.guardianname.getText());
				statement.setInt(4, Integer.parseInt(this.age.getText()));
				statement.setString(5, this.predictedTestingDate.getEditor().getText());
				statement.setString(6, this.address.getText());
				statement.setString(7, this.phoneNumber.getText());
				statement.setString(8, this.email.getText());
				statement.setInt(9, 0);
				statement.setString(10, this.stripeColor.getText());
				statement.setString(11, "N/A");
				statement.setInt(12, 0);
				statement.setInt(13, 0);
				statement.execute();
				//conn.close();
				
				
				/*String getId = "SELECT * FROM Students WHERE fname = ? and lname = ?";
				//Connection conn1 = db.Connector();
				//PreparedStatement statement1 = conn1.prepareStatement(getId);
				PreparedStatement statement1 = conn.prepareStatement(getId);
				statement1.setString(1, this.firstname.getText());
				statement1.setString(2, this.lastname.getText());
				statement1.execute();
				//ResultSet rs = conn1.createStatement().executeQuery(getId);
				//ResultSet rs = conn.createStatement().executeQuery(getId);
				ResultSet rs = statement1.executeQuery();
				while(rs.next())
				{
					Student joe = new Student(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getInt(7), rs.getString(8), rs.getString(9), rs.getString(10), "", 0, 0, "");
					idSaver = joe.getId();
				}
				//conn1.close();
				
				
				String sqlInsertIntoColorBelt = "INSERT INTO LittleTiger(id,beltStripeColor ) VALUES(?,?) " ;
				System.out.println(idSaver);
				//Connection conn2 = db.Connector();
				//PreparedStatement statement2 = conn2.prepareStatement(sqlInsertIntoColorBelt);
				PreparedStatement statement2 = conn.prepareStatement(sqlInsertIntoColorBelt);
				statement2.setInt(1, idSaver);
				statement2.setString(2, this.stripeColor.getText());
				statement2.execute();
				conn.close();
				//conn1.close();
				//conn2.close();*/
				
			}catch (SQLException e)
			{
				e.printStackTrace();
			}	
		}
		else
		{
			System.out.println(this.firstname.getText() + " " + this.lastname.getText() + " is already a student in the database" );
		}
	}catch (SQLException e)
	{
		e.printStackTrace();
	}
					
			
			
			
			
			
			
			
		
	
	}
	@FXML
	public void clearForm(ActionEvent event4)
	{
		this.firstname.setText("");
		this.lastname.setText("");
		this.guardianname.setText("");
		this.age.setText("");
		this.predictedTestingDate.getEditor().setText(null);
		this.address.setText("");
		this.phoneNumber.setText("");
		this.email.setText("");
		this.stripeColor.setText("");
	}



}
