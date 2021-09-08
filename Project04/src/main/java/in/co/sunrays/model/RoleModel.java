package in.co.sunrays.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import in.co.sunrays.bean.RoleBean;

public class RoleModel {

	public int nextPK() throws Exception {

		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/project04", "root", "root");

		int pk = 0;

		PreparedStatement ps = conn.prepareStatement(" select max(id) from st_role");

		ResultSet ro = ps.executeQuery();
		while (ro.next()) {
			pk = ro.getInt(1);
		}
		return pk + 1;
	}

	public long add(RoleBean cb) throws Exception {
		
		
		Class.forName("com.mysql.jdbc.Driver");

		Connection conc = DriverManager.getConnection("jdbc:mysql://localhost/project04", "root", "root");

		conc.setAutoCommit(false);

		PreparedStatement ps = conc.prepareStatement(" insert into st_role values(?,?,?,?,?,?,?)");

		ps.setInt(1, nextPK());
		ps.setString(2, cb.getName());
		ps.setString(3, cb.getDescription());
		ps.setString(4, cb.getCreatedBy());
		ps.setString(5, cb.getModifiedBy());
		ps.setTimestamp(6,cb.getCreatedDateTime());
		ps.setTimestamp(7, cb.getModifiedDateTime());

		ps.executeUpdate();

		conc.commit();

		System.out.println("Added Successfully");

		ps.close();
		conc.close();

		return 0;
	}

	public void delete(RoleBean cb) throws Exception {

		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/project04", "root", "root");

		PreparedStatement ps = conn.prepareStatement(" Delete From st_role where id = ?");

		ps.setLong(1, cb.getId());

		ps.executeUpdate();
		System.out.println("Deleted Successfully");

		ps.close();
		conn.close();
	}

	public RoleBean findByName(String cb) throws Exception {

		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/project04", "root", "root");

		RoleBean bean = null;
		PreparedStatement ps = conn.prepareStatement(" Select * from st_role where name = ?");

		ps.setString(1, cb);

		Date d = new Date();

		Date d1 = new Date();
		
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			bean = new RoleBean();
			rs.getString(1);
			bean.setName(rs.getString(2));
			bean.setDescription(rs.getString(3));
			bean.setCreatedBy(rs.getString(4));
			bean.setModifiedBy(rs.getString(5));
		
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

	public RoleBean findByPK(long cb) throws Exception {
 
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/project04", "root", "root");

		RoleBean bean = null;
		PreparedStatement ps = conn.prepareStatement(" Select * from st_role where id = ?");

		ps.setLong(1, cb);

		Date d = null;

		Date d1 = null;

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			bean = new RoleBean();
			rs.getString(1);
			bean.setName(rs.getString(2));
			bean.setDescription(rs.getString(3));
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

	public void update(RoleBean cb) throws Exception {

		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/project04", "root", "root");

		conn.setAutoCommit(false);
		PreparedStatement ps = conn.prepareStatement(
				" Update st_role set name = ?, description = ?, createdBy=?, modifiedBy=?, created_datetime=?, modified_datetime=?  where id = ?");

		ps.setString(1, cb.getName());
		ps.setString(2, cb.getDescription());
		ps.setString(3, cb.getCreatedBy());
		ps.setString(4, cb.getModifiedBy());
		ps.setTimestamp(5, cb.getCreatedDateTime());
		ps.setTimestamp(6, cb.getModifiedDateTime());
		ps.setLong(7, cb.getId());

		ps.executeUpdate();

		conn.commit();
		System.out.println("Updated Successfully");

		ps.close();
		conn.close();
	}

	public List search(RoleBean cb, int pageNo, int pageSize) {
	
		return null;
	}

	public List search(RoleBean cb) {
	
		return null;
	}

	public List list() {
	
		return null;
	}
	public List list(int pageNo, int pageSize) {
		
		return null;
	}
	
	

}
