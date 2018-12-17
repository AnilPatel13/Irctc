package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Main extends Application {
	public static Scene scene1, scene2;
    public static Stage thestage;
	@Override
	public void start(Stage primaryStage) {
		try {

		    thestage=primaryStage;
			primaryStage.setTitle("ZeroCrack Login | Home");
			Parent root=FXMLLoader.load(getClass().getResource("/application/Login.fxml"));
			scene1 = new Scene(root,691,434);
			scene1.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene1);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
