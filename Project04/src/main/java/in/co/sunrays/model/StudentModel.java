package in.co.sunrays.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import in.co.sunrays.bean.RoleBean;
import in.co.sunrays.bean.StudentBean;

public class StudentModel {
	public int nextPK() throws Exception {

		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/project04", "root", "root");

		int pk = 0;

		PreparedStatement ps = conn.prepareStatement(" select max(id) from st_student");

		ResultSet ro = ps.executeQuery();
		while (ro.next()) {
			pk = ro.getInt(1);
		}
		return pk + 1;
	}

	public long add(StudentBean cb) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");

		Connection conc = DriverManager.getConnection("jdbc:mysql://localhost/project04", "root", "root");

		conc.setAutoCommit(false);

		PreparedStatement ps = conc.prepareStatement(" insert into st_role values(?,?,?,?,?,?,?,?,?,?,?,?)");

		ps.setInt(1, nextPK());
		ps.setLong(2, cb.getCollegeId());
		ps.setString(3, cb.getCollegeName());
		ps.setString(4, cb.getFirstName());
		ps.setString(5, cb.getLastName());
		ps.setDate(6, cb.getDob());
		ps.setString(7, cb.getMobileNo());
		ps.setString(8, cb.getEmail());
		ps.setString(9, cb.getCreatedBy());
		ps.setString(10, cb.getModifiedBy());
		ps.setTimestamp(11,cb.getCreatedDateTime());
		ps.setTimestamp(12, cb.getModifiedDateTime());

		ps.executeUpdate();

		conc.commit();

		System.out.println("Added Successfully");

		ps.close();
		conc.close();

		return 0;

	}

	public void delete(StudentBean cb) {

	}

	public StudentBean findByEmail(String em) {

		return null;
	}

	public StudentBean findByPK(long cb) throws Exception {
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/project04", "root", "root");

		StudentBean bean = null;
		PreparedStatement ps = conn.prepareStatement(" Select * from st_role where id = ?");

		ps.setLong(1, cb);

		Date d = null;

		Date d1 = null;

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			bean = new StudentBean();
			rs.getString(1);
			bean.setCollegeId(rs.getLong(2));
			bean.setCollegeName(rs.getString(3));
			bean.setFirstName(rs.getString(4));
			bean.setLastName(rs.getString(5));
			
			bean.setCreatedBy(rs.getString(4));
			bean.setModifiedBy(rs.getString(5));

			 d = new Date();

			d1 = new Date();

			d = rs.getDate(6);
			Timestamp ts = new Timestamp(d.getTime());

			d1 = rs.getDate(7);
			Timestamp ts1 = new Timestamp(d1.getTime());
			
			bean.setCreatedDateTime(ts);
			bean.setModifiedDateTime(ts1);
		}
		ps.close();
		conn.close();

		return bean;
	}

	public void update(StudentBean cb) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/project04", "root", "root");

		conn.setAutoCommit(false);
		PreparedStatement ps = conn.prepareStatement(
				" Update st_student set college_Id = ?, college_name = ?,first_name=?, last_name = ?,date_of_birth =?,mobile_no = ? , email=? ,createdBy=?, modifiedBy=?, created_datetime=?, modified_datetime=?  where id = ?");

		ps.setLong(1, cb.getCollegeId());
		ps.setString(2, cb.getCollegeName());
		ps.setString(3, cb.getFirstName());
		ps.setString(4, cb.getLastName());
		ps.setDate(5, cb.getDob());
		ps.setString(6, cb.getMobileNo());
		ps.setString(7,cb.getEmail());		
		ps.setString(8, cb.getCreatedBy());
		ps.setString(9, cb.getModifiedBy());
		ps.setTimestamp(10, cb.getCreatedDateTime());
		ps.setTimestamp(11, cb.getModifiedDateTime());
		ps.setLong(12, cb.getId());

		ps.executeUpdate();

		conn.commit();
		System.out.println("Updated Successfully");

		ps.close();
		conn.close();

	}

	public List search(StudentBean cb, int pageNo, int pageSize) {
	
		return null;
	}

	public List search(StudentBean cb) {
	
		return null;
	}

	public List list() {
	
		return null;
	}
	public List list(int pageNo, int pageSize) {
		
		return null;
	}
	
	


}
