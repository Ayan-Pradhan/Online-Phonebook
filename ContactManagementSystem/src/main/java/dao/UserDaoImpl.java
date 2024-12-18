package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.User;

public class UserDaoImpl implements UserDao<User> {
	DbConnectionProvider db = new DbConnectionProvider();

	@Override
	public int add(User u) throws SQLException {

		Connection dbconnect = db.dbcon();

		String sql = "INSERT INTO USERS VALUES(?,?,?,?)";
		PreparedStatement ps = dbconnect.prepareStatement(sql);
		ps.setString(1, u.getEmail());
		ps.setString(2, u.getName());
		ps.setString(3, u.getContact());
		ps.setString(4, u.getPassword());

		int status = ps.executeUpdate();

		dbconnect.close();

		return status;
	}

	@Override
	public User getById(User u) throws SQLException {

		Connection dbconnect = db.dbcon();

		String sql = "SELECT * FROM USERS WHERE EMAIL=? AND PASSWORD=?";
		PreparedStatement ps = dbconnect.prepareStatement(sql);
		ps.setString(1, u.getEmail());
		ps.setString(2, u.getPassword());

		User user = new User();
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			user.setEmail(rs.getString(1));
			user.setName(rs.getString(2));
			user.setContact(rs.getString(3));
		}

		dbconnect.close();

		return user;
	}

	@Override
	public boolean login(String username, String password) throws SQLException {

		Connection dbconnect = db.dbcon();

		String sql = "SELECT * FROM USERS WHERE EMAIL=? AND PASSWORD=?";
		PreparedStatement ps = dbconnect.prepareStatement(sql);
		ps.setString(1, username);
		ps.setString(2, password);

		ResultSet rs = ps.executeQuery();

		boolean status = rs.next();

		dbconnect.close();

		return status;
	}

	@Override
	public boolean ifExists(String username) throws SQLException {
		Connection dbconnect = db.dbcon();

		String sql = "SELECT * FROM USERS WHERE EMAIL=?";
		PreparedStatement ps = dbconnect.prepareStatement(sql);
		ps.setString(1, username);

		ResultSet rs = ps.executeQuery();

		boolean status = rs.next();

		dbconnect.close();

		return status;
	}

	@Override
	public void reset(String username, String password) throws SQLException {
		Connection dbconnect = db.dbcon();

		String sql = "UPDATE USERS SET PASSWORD=? WHERE EMAIL=?";
		PreparedStatement ps = dbconnect.prepareStatement(sql);
		ps.setString(1, password);
		ps.setString(2, username);

		ps.executeUpdate();

		dbconnect.close();

	}

}
