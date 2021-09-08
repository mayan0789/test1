package in.co.sunrays.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import in.co.sunrays.bean.UserBean;

public class UserModel {
	public int nextPK() throws Exception {

		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/project04", "root", "root");

		int pk = 0;

		PreparedStatement ps = conn.prepareStatement(" select max(id) from marksheet");

		ResultSet ro = ps.executeQuery();
		while (ro.next()) {
			pk = ro.getInt(1);
		}
		return pk + 1;
	}

	public long add(UserBean cb) throws Exception {

		Class.forName("com.mysql.jdbc.Driver");

		Connection conc = DriverManager.getConnection("jdbc:mysql://localhost/project04", "root", "root");

		conc.setAutoCommit(false);

		PreparedStatement ps = conc.prepareStatement(" insert into st_user values(?,?,?,?,?,?,?,?,?,?)");

		ps.setInt(1, nextPK());
		
		  ps.setString(2, cb.getFirstName());
		  ps.setString(3, cb.getLastName());
		/*
		 * ps.setString(4, cb.getState()); ps.setString(5, cb.getCity());
		 * ps.setString(6, cb.getPhoneNo()); ps.setString(7, cb.getCreatedBy());
		 * ps.setString(8, cb.getModifiedBy()); ps.setTimestamp(9,
		 * cb.getCreatedDateTime()); ps.setTimestamp(10, cb.getModifiedDateTime());
		 */
		ps.executeUpdate();

		conc.commit();

		System.out.println("Added Successfully");

		ps.close();
		conc.close();

		return 0;
	}

	public void delete(UserBean cb) {

	}

	public UserBean findByName(String cb) {

		return null;
	}

	public UserBean findByPK(long cb) {

		return null;
	}

	public void update(UserBean cb) {

	}

	public List search(UserBean cb, int pageNo, int pageSize) {
	
		return null;
	}

	public List search(UserBean cb) {
	
		return null;
	}

	public List list() {
	
		return null;
	}
	public List list(int pageNo, int pageSize) {
		
		return null;
	}
	
	public UserBean authenticate(String login, String password) {
		return null;
		
	}
	public boolean lock(String login) {
		return false;
		
	}
	public List getRoles(UserBean ub) {
		return null;
		
	}
	public boolean changePassword(int id, String oldpass, String newpass) {
		return true;
		
	}
	public UserBean updateAccess(UserBean ub) {
		return null;
		
	}
	public long registerUser(UserBean ub) {
		return 0;
		
	}
	public boolean resetPassword(UserBean ub) {
		return false;
		
	}public boolean forgotPassword(String login) {
		return false;
		
	}
	

}
