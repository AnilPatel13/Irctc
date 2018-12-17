package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LoginController {

	@FXML
	public Label lblStatus=null;
	
	@FXML
	private TextField txtUsername;

	@FXML
	private TextField txtPassword;

	public void login(ActionEvent event) throws IOException {
		if (txtUsername.getText().equals("admin") && txtPassword.getText().equals("admin")) {
			lblStatus.setText("Login Success");
			Parent root = FXMLLoader.load(getClass().getResource("/application/Irctc.fxml"));
			Main.scene2 = new Scene(root, 691, 434);
			Main.scene2.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Main.thestage.setTitle("CRACKER HOME");
			Main.thestage.setScene(Main.scene2);
		} else {
			lblStatus.setText("Login Failed");
		}
	}

}
