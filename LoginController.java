package vnua.fita.th03134.training;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {
	@FXML
	private TextField emailTf;
	@FXML
	private PasswordField passwordPf;
	@FXML
	private Label errorLabel;
	
	private UserDAO userDAO;
	
	//Phuong thuc chay khoi tao khi controller dc tao
	public void initialize() {
		userDAO = new UserDAO();
		errorLabel.setVisible(false);
	}
	
	//xu ly su kien
	@FXML
	private void onClickLoginBtn() {
		
		String email = emailTf.getText().trim();
		String password = passwordPf.getText().trim();
		
		//kiem tra tinh hop le
		if(email.isEmpty() || password.isEmpty()) {
			errorLabel.setText("Email va pass ko dc de trong");
			errorLabel.setVisible(true);
			return;
		}
		
		//kiem tra email , pass user trong csdl
		User user = userDAO.getUserByEmail(email);
		if (user == null || !user.getPassword().equals(password)) {
			errorLabel.setText("Tai khoan chua chinh xac");
			errorLabel.setVisible(true);
		}else {
			//login succes
			
			errorLabel.setVisible(false);
			
			//Chuyen den man hinh home
			goHomeScreen();
		}
	}
	@FXML
	private void onClickRegisterLink() {
		try {
			Stage loginStage = (Stage) emailTf.getScene().getWindow();
			loginStage.close();
		
			FXMLLoader loader = new FXMLLoader(getClass().getResource("RegisterForm.fxml"));
			Parent root = loader.load();
		
			//Tao stage
			Stage homeStage = new Stage();
			homeStage.setTitle("Đăng ký khóa học");
			homeStage.setScene(new Scene(root));
			homeStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	} 

	//chuyen toi man hinh home
	private void goHomeScreen() {
		System.out.println("Đăng nhập thành công!");
	}
	
}
