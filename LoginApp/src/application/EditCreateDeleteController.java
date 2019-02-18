package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class EditCreateDeleteController implements Initializable {

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		
	}
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
	public void addStudent(ActionEvent event2)
	{
		try
		{
			Stage primaryStage = new Stage();
			FXMLLoader loader = new FXMLLoader();
			Pane root;
			
				root = loader.load(getClass().getResource("/application/AddStudent.fxml").openStream());
				AddStudentController addStudentController = (AddStudentController)loader.getController();
				Scene scene = new Scene(root);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				primaryStage.setScene(scene);
				primaryStage.show();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	public void editStudent(ActionEvent event3)
	{
		try
		{
			Stage primaryStage = new Stage();
			FXMLLoader loader = new FXMLLoader();
			Pane root;
			
				root = loader.load(getClass().getResource("/application/EditStudent.fxml").openStream());
				EditStudentController editStudentController = (EditStudentController)loader.getController();
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
