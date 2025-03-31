package vnua.fita.th03134.training;

import java.time.LocalDate;

public class User {
	private int userId;
	private String email;
	private String fullname;
	private boolean gender; //quy ước true = Nam , false = nữ
	private LocalDate birthday;
	private String course;
	private String password;
	
	//khi thêm ng mới ta ch biêt userid
	//userid dc sinh trong csdl
	//ta dung constructor nay de tao doi tuong user khi them moi
	
	public User(String email, String fullname, boolean gender, LocalDate birthday, String course, String password) {
		this.email = email;
		this.fullname = fullname;
		this.gender = gender;
		this.course = course;
		this.birthday = birthday;
		this.password = password;
	}
	
	//constructor nay dung khi tao doi tuong user lay tu csdl len tang model (trong userDAO)
	
	public User(int userId, String email, String fullname, boolean gender,LocalDate birthday, String course, String password) {
		this.userId = userId;
		this.email = email;
		this.fullname = fullname;
		this.gender = gender;
		this.birthday = birthday;
		this.course = course;
		this.password = password;
	}

	
	// get and set
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	//voi boolean getX thay = isX
	
	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public LocalDate getBirthday() {
		return birthday;
	}
	
	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}
	
	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
