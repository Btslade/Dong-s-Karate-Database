package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class UserController implements Initializable{
    @FXML
    private Label userLbl;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	public void getUser(String user)
	{
		userLbl.setText("Welcome " + user);
		
	}
	
	public void takeAttendance (ActionEvent event1)
	{
		try 
		{
		Stage primaryStage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		Pane root;
		
			root = loader.load(getClass().getResource("/application/TakeAttendance.fxml").openStream());
			TakeAttendanceController takeAttendanceController = (TakeAttendanceController)loader.getController();
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void studentInformation(ActionEvent event2)
	{
		try
		{
		Stage primaryStage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		Pane root;
		
			root = loader.load(getClass().getResource("/application/StudentInformation.fxml").openStream());
			StudentInformationController studentInformationController = (StudentInformationController)loader.getController();
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void editDeleteCreateStudent(ActionEvent event3)
	{
		try
		{
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
	
	public void close()
	{
		
	}
}


