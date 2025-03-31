package vnua.fita.th03134.training;

import java.util.Arrays;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class RegisterController {
	@FXML
	private TextField emailTf;
	@FXML
	private TextField fullnameTf;
	@FXML
	private ToggleGroup genderGroup;
	@FXML
	private ChoiceBox<String> courseChoiceBox;
	@FXML
	private PasswordField passwordPf;
	@FXML
	private TextField passwordTf;
	@FXML
	private CheckBox displayCheckBox;
	@FXML
	private Label messageLabel;
	@FXML
	private Hyperlink toHomeLink;
	@FXML
	private Button registerButton;
	
	private UserDAO userDAO = new UserDAO();
	private User loginedUser;
	
	//Khoi tao choicebox
	
	public void initialize() {
		List<String> courses = Arrays.asList("Java", "Python", "C++", "Web Development");
		
		//Thiet lap du lieu
		courseChoiceBox.getItems().addAll(courses);
		courseChoiceBox.getSelectionModel().selectFirst();
	}
	
	@FXML
	private void onClickToHomeLink() {
		
	}

	//xu ly sk "hien thi"
	@FXML
	private void onClickDisplayCheckbox(ActionEvent event) {
		//ktra trang thai
		boolean isChecked = displayCheckBox.isSelected();
		//xu ly thay doi hien thi mk
		handlePasswordVisibility(isChecked);
	}

	//thay doi hien thi mk khi checkbox thay doi
	private void handlePasswordVisibility(boolean isChecked) {
		if (isChecked) {
			//hien thi mk duoi dang van ban
			passwordTf.setText(passwordPf.getText());
			passwordTf.setVisible(true);
			passwordTf.setVisible(false);
		}else {
			// an mk, hien thi dang ma hoa
			passwordPf.setText(passwordPf.getText());
			passwordPf.setVisible(true);
			passwordPf.setVisible(false);
		}
	}
	
	@FXML
	public void onClickRegisterBtn(ActionEvent event) {
		// lay dl tu form
		String email = emailTf.getText();
		String fullname = fullnameTf.getText();
		String password = passwordPf.getText();
		
		//lay ve male, vi ko dat fx:id cho radio nen ta pb qua nhan di kem radio(nam/nu)
		String gender = ((RadioButton) genderGroup.getSelectedToggle()).getText();
		String course = courseChoiceBox.getValue();
		
		//Kiem tra tinh hop le
		String validationMessage = validateForm(email, fullname, password, course);
		if (validationMessage != null) {
			// neu co loi hien thi thong bao va dung lai
			showMessage(false, validationMessage);
			return;
		}
	
		//ktra email ton tai chua
		if(userDAO.getUserByEmail(email) != null) {
			showMessage(false, "Email da ton tai!");
			return;
		}
	//Tao doi tuong user tu du lieu nhap vao
		User newUser = new User(email, fullname, gender.equals("Nam"), course, password);
		loginedUser = newUser;// luu tru ghi vao session khi toi mh Home
		
		//Them ng dung vao CSDL
		boolean isAdded = userDAO.addUser(newUser);
		
		//Hien thi tbao ket qua
		if (isAdded) {
			showMessage(true, "Đăng ký thành công");
		}else {
			showMessage(false, "Đăng ký không thành công");
		}
	
	}
	
	//kiem tra tinh hop le cua du lieu
	private String validateForm(String emiail, String fullname, String password, String course) {
		if (email == null || email.isEmpty() || !isEmailValid(email)) {
			return "Email không hợp lệ";
		}
		if (fullname = null || fullname.isEmpty()) {
			return "Vui lòng nhập họ tên";
		}
		if (password = null || password.isEmpty()) {
			return "Vui lòng nhập mật khẩu";
		}
		if (course == null || course.isEmpty()) {
			return "Vui lòng chọn khóa học";
		}
		return null;
	}
	
	//Kiem tra tinh hop le cua email
}

