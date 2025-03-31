package vnua.fita.th03134.training;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;




public class UserDAO {
	public static List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        String dbURL = "jdbc:ucanaccess://lib/QLKH.accdb";
        String query = "SELECT * FROM tbluser";

            try {
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				Connection con = DriverManager.getConnection(dbURL);
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(query);

				while (rs.next()) {
					int userId = rs.getInt("UserID");
				    String email = rs.getString("email");
				    String fullname = rs.getString("fullname");
				    boolean gender = rs.getBoolean("Gender");
				    LocalDate birthday = rs.getDate("Birthday").toLocalDate();
				    
				    String course = rs.getString("Course");
				    String password = rs.getString("Password");
				    
				    //Dong goi vao doi tuong user
				    User user = new User(userId, email, fullname, gender, birthday, course, password);
				    userList.add(user);// them vao ds ke tra ve
				}
				
				rs.close();
				stmt.close();
				con.close();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
            return userList;
	}
	
	//Lay mot ng dung theo userid
	public  User getUserById(int userId) {
		User user = null;
        String dbURL = "jdbc:ucanaccess://lib/QLKH.accdb";
        String query = "SELECT * FROM tbluser WHERE UserID = ?";

            try {
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				Connection con = DriverManager.getConnection(dbURL);
				PreparedStatement stmt = con.prepareStatement(query);
				stmt.setInt(1, userId);// limit nen chi tra ve 1 ban ghi , ko can while
				ResultSet rs = stmt.executeQuery();
				
				if(rs.next()) {
					 String email = rs.getString("Email");
					 String fullname = rs.getString("Fullname");
					 boolean gender = rs.getBoolean("Gender");
					 LocalDate birthday = rs.getDate("Birthday").toLocalDate();
					 String course = rs.getString("Course");
					 String password = rs.getString("Password");
					 
					 user = new User(userId, email, fullname, gender, birthday, course, password);
				}
				rs.close();
				stmt.close();
				con.close();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
	return user;
	
}
	//lay mot ng dung theo email
	public  User getUserByEmail(String email) {
		User user = null;
        String dbURL = "jdbc:ucanaccess://lib/QLKH.accdb";
        String query = "SELECT * FROM tbluser WHERE Email = ?";

            try {
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				Connection con = DriverManager.getConnection(dbURL);
				PreparedStatement stmt = con.prepareStatement(query);
				stmt.setString(1, email);// limit nen chi tra ve 1 ban ghi , ko can while
				ResultSet rs = stmt.executeQuery();
				
				if(rs.next()) {
					 int userId = rs.getInt("UserID");
					 String fullname = rs.getString("Fullname");
					 boolean gender = rs.getBoolean("Gender");
					 LocalDate birthday = rs.getDate("Birthday").toLocalDate();
					 String course = rs.getString("Course");
					 String password = rs.getString("Password");
					 
					 user = new User(userId, email, fullname, gender, birthday,course, password);
				}
				rs.close();
				stmt.close();
				con.close();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
	return user;
	
}
	// them 1 ng dung moi vao csdl
	public  boolean addUser(User user) {
        String dbURL = "jdbc:ucanaccess://lib/QLKH.accdb";
        String query = "INSERT INTO tbluser (Email, Fullname, Gender, Birthday, Course, Password) VALUES (?, ?, ?, ?, ?, ?)";

            try {
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				Connection con = DriverManager.getConnection(dbURL);
				PreparedStatement stmt = con.prepareStatement(query);
				stmt.setString(1, user.getEmail());
				stmt.setString(2, user.getFullname());
				stmt.setBoolean(3, user.isGender());
				stmt.setDate(4, java.sql.Date.valueOf(user.getBirthday()));
				stmt.setString(5, user.getCourse());
				stmt.setString(6, user.getPassword());
				
				int rowInserted = stmt.executeUpdate();
				return rowInserted > 0;
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
	return false;
	
}
	
	//cap nhat thong tin user
	public  boolean updateUser(User user) {
        String dbURL = "jdbc:ucanaccess://lib/QLKH.accdb";
        String query = "UPDATE tblUser SET Email = ?, Fullname = ?, Gender = ?, Birthday = ?, Course = ?, Password = ?, WHERE UserID = ?";

            try {
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				Connection con = DriverManager.getConnection(dbURL);
				PreparedStatement stmt = con.prepareStatement(query);
				stmt.setString(1, user.getEmail());
				stmt.setString(2, user.getFullname());
				stmt.setBoolean(3, user.isGender());
				stmt.setDate(4, java.sql.Date.valueOf(user.getBirthday()));
				stmt.setString(5, user.getCourse());
				stmt.setString(6, user.getPassword());
				stmt.setInt(7, user.getUserId());

				
				int rowUpdate = stmt.executeUpdate();
				return rowUpdate > 0;
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
	return false;
	
}
	
	//Xoa ng dung theo UserID
	public  boolean deleteUser(int userId) {
        String dbURL = "jdbc:ucanaccess://lib/QLKH.accdb";
        String query = "DELETE FROM tblUser WHERE UserID = ?";

            try {
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				Connection con = DriverManager.getConnection(dbURL);
				PreparedStatement stmt = con.prepareStatement(query);
				stmt.setInt(1, userId);

				
				int rowDeleted = stmt.executeUpdate();
				return rowDeleted > 0;
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
	return false;
	
}
	

}
