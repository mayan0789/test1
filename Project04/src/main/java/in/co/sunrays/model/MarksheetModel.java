package in.co.sunrays.model;
import java.lang.System;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import in.co.sunrays.bean.MarksheetBean;

public class MarksheetModel {
	public int nextPK() throws Exception {

		Class.forName("driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/project04", "root", "root");

		int pk = 0;

		PreparedStatement ps = conn.prepareStatement(" select max(id) from st_marksheet");

		ResultSet ro = ps.executeQuery();
		while (ro.next()) {
			pk = ro.getInt(1);
		}
		return pk + 1;
	}

	public long add(MarksheetBean cb) throws Exception {

		Class.forName("com.mysql.jdbc.Driver");

		Connection conc = DriverManager.getConnection("jdbc:mysql://localhost/project04", "root", "root");

		conc.setAutoCommit(false);

		PreparedStatement ps = conc.prepareStatement(" insert into st_marksheet values(?,?,?,?,?,?,?,?,?,?,?)");

		ps.setInt(1, nextPK());
		ps.setString(2, cb.getRollNo());
		ps.setLong(3, cb.getStudentId());
		ps.setString(4, cb.getName());
		ps.setInt(5, cb.getPhysics());
		ps.setInt(6, cb.getChemistry());
		ps.setInt(7, cb.getMaths());
		ps.setString(8, cb.getCreatedBy());
		ps.setString(9, cb.getModifiedBy());
		ps.setTimestamp(10, cb.getCreatedDateTime());
		ps.setTimestamp(11, cb.getModifiedDateTime());

		ps.executeUpdate();

		conc.commit();

		System.out.println("Added Successfully");

		ps.close();
		conc.close();

		return 0;

	}

	public void delete(MarksheetBean cb) throws Exception {

		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/project04", "root", "root");

		PreparedStatement ps = conn.prepareStatement(" Delete From st_marksheet where id = ?");

		ps.setLong(1, cb.getId());

		ps.executeUpdate();
		System.out.println("Deleted Successfully");

		ps.close();
		conn.close();
	}

	public MarksheetBean findByRollNo(String rb) throws Exception {

		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/project04", "root", "root");

		MarksheetBean bean = null;
		PreparedStatement ps = conn.prepareStatement(" Select * from st_marksheet where name = ?");

		ps.setString(1, rb);

		Date d = new Date();

		Date d1 = new Date();

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			bean = new MarksheetBean();
			rs.getString(1);

			bean.setRollNo(rs.getString(2));
			bean.setStudentId(rs.getLong(3));
			bean.setName(rs.getString(4));
			bean.setPhysics(rs.getInt(5));
			bean.setChemistry(rs.getInt(6));
			bean.setMaths(rs.getInt(7));
			bean.setCreatedBy(rs.getString(8));
			bean.setModifiedBy(rs.getString(9));

			d = rs.getDate(10);
			Timestamp ts = new Timestamp(d.getTime());

			d1 = rs.getDate(11);
			Timestamp ts1 = new Timestamp(d1.getTime());

			bean.setCreatedDateTime(ts);
			bean.setModifiedDateTime(ts1);
		}
		ps.close();
		conn.close();

		return bean;
	}

	public MarksheetBean findByPK(long cb) throws Exception {

		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/project04", "root", "root");

		MarksheetBean bean = null;
		PreparedStatement ps = conn.prepareStatement(" Select * from st_marksheet where id = ?");

		ps.setLong(1, cb);

		Date d = null;

		Date d1 = null;

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			bean = new MarksheetBean();
			rs.getString(1);

			bean.setRollNo(rs.getString(2));
			bean.setStudentId(rs.getLong(3));
			bean.setName(rs.getString(4));
			bean.setPhysics(rs.getInt(5));
			bean.setChemistry(rs.getInt(6));
			bean.setMaths(rs.getInt(7));
			bean.setCreatedBy(rs.getString(8));
			bean.setModifiedBy(rs.getString(9));

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

	public void update(MarksheetBean cb) throws Exception {

		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/project04", "root", "root");

		conn.setAutoCommit(false);
		PreparedStatement ps = conn.prepareStatement(
				" Update st_marksheet set roll_no = ?, Student_id = ?, name = ?, physics = ?, chemistry = ?, maths = ?, createdBy=?, modifiedBy=?, created_datetime=?, modified_datetime=?  where id = ?");

		ps.setString(1, cb.getRollNo());
		ps.setLong(2, cb.getStudentId());
		ps.setString(3, cb.getName());
		ps.setInt(4, cb.getPhysics());
		ps.setInt(5, cb.getChemistry());
		ps.setInt(6, cb.getMaths());
		ps.setString(7, cb.getCreatedBy());
		ps.setString(8, cb.getModifiedBy());
		ps.setTimestamp(9, cb.getCreatedDateTime());
		ps.setTimestamp(10, cb.getModifiedDateTime());
		ps.setLong(11, cb.getId());

		ps.executeUpdate();

		conn.commit();
		System.out.println("Updated Successfully");

		ps.close();
		conn.close();
	}

	public List search(MarksheetBean cb, int pageNo, int pageSize) {

		return null;
	}

	public List search(MarksheetBean cb) {

		return null;
	}

	public List list() {

		return null;
	}

	public List list(int pageNo, int pageSize) {

		return null;
	}

	public List getMeritList(int pageNo, int pageSize) {

		return null;
	}
}
