package vnua.fita.th03134.training;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class HomeSCMain extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("HomeScreen.fxml"));
				 
			
			//Them layout vao Scene
			//BorderPane root = new BorderPane();
			Scene scene = new Scene(root);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			//Them scene vao stage
			primaryStage.setScene(scene);
			//Hien thi khung chua len
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}	
	
	public static void main(String[] args) {
		launch(args);
	}
}
