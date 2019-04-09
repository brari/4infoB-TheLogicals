
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class dd extends Application {

	@Override
	public void start(Stage primaryStage) throws IOException {
		Parent root=FXMLLoader.load(getClass().getResource("Signup.fxml"));
        Scene scene = new Scene(root);
        
        primaryStage.setTitle("Ajouter un Article");
        primaryStage.setScene(scene);
        primaryStage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
