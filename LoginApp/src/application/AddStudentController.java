package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AddStudentController implements Initializable
{
	@FXML
	private TextField firstName;
	
	@FXML
	private TextField lastName;
	
	@FXML
	private TextField age;
	
	@FXML
	private TextField deleteBox;
	
	@FXML
	private Text studentDeleted;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	public void addColorBelt(ActionEvent event1)
	{
		try
		{
			((Node)event1.getSource()).getScene().getWindow().hide();
			Stage primaryStage = new Stage();
			FXMLLoader loader = new FXMLLoader();
			Pane root;
			
				root = loader.load(getClass().getResource("/application/AddColorBelt.fxml").openStream());
				AddColorBeltController addColorBeltController = (AddColorBeltController)loader.getController();
				Scene scene = new Scene(root);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				primaryStage.setScene(scene);
				primaryStage.show();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	public void addBlackBelt(ActionEvent event2)
	{
		try
		{
			((Node)event2.getSource()).getScene().getWindow().hide();
			Stage primaryStage = new Stage();
			FXMLLoader loader = new FXMLLoader();
			Pane root;
			
				root = loader.load(getClass().getResource("/application/AddBlackBelt.fxml").openStream());
				AddBlackBeltController addBlackBeltController = (AddBlackBeltController)loader.getController();
				Scene scene = new Scene(root);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				primaryStage.setScene(scene);
				primaryStage.show();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	public void addLittleTiger(ActionEvent event3)
	{
		try
		{
			((Node)event3.getSource()).getScene().getWindow().hide();
			Stage primaryStage = new Stage();
			FXMLLoader loader = new FXMLLoader();
			Pane root;
			
				root = loader.load(getClass().getResource("/application/AddLittleTiger.fxml").openStream());
				AddLittleTigerController addLittleTigerController = (AddLittleTigerController)loader.getController();
				Scene scene = new Scene(root);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				primaryStage.setScene(scene);
				primaryStage.show();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	public void goBack(ActionEvent event4)
	{
		try
		{
			((Node)event4.getSource()).getScene().getWindow().hide();
			Stage primaryStage = new Stage();
			FXMLLoader loader = new FXMLLoader();
			Pane root;
			
				root = loader.load(getClass().getResource("/application/EditCreateDelete.fxml").openStream());
				EditCreateDeleteController editCreateDeleteController = (EditCreateDeleteController)loader.getController();
				Scene scene = new Scene(root);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				primaryStage.setScene(scene);
				primaryStage.show();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	@FXML
	private void deleteStudent(ActionEvent event5)
	{
		try 
		{
			String matchCheck = "SELECT * FROM Students WHERE fname = ? and lname = ?";
			Connection conn1 = SqliteConnection.Connector();
			PreparedStatement statementCheck = conn1.prepareStatement(matchCheck);
			statementCheck.setString(1, this.firstName.getText());
			statementCheck.setString(2, this.lastName.getText());
			ResultSet testResult = statementCheck.executeQuery();
			conn1.close();
			if(deleteBox.getText().contentEquals("Delete"))
			{
				String personDeleted = firstName.getText() + " Deleted";
				String sqlDelete = "DELETE FROM Students WHERE fname = ? and lname = ? and age = ?";
				Connection conn = SqliteConnection.Connector();
				PreparedStatement statement = conn.prepareStatement(sqlDelete);
				statement.setString(1, this.firstName.getText());
				statement.setString(2, this.lastName.getText());
				statement.setInt(3, Integer.parseInt(this.age.getText()));
				statement.execute();
				this.firstName.setText("");
				this.lastName.setText("");
				this.age.setText("");
				this.deleteBox.setText("");
				this.studentDeleted.setText(personDeleted);
			}
		}catch (SQLException e)
		{
			e.printStackTrace();
		}	
	}
}
