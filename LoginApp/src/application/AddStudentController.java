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

public class AddStudentController implements Initializable{

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	public void addColorBelt(ActionEvent event1)
	{
		try
		{
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
		
	}
}
