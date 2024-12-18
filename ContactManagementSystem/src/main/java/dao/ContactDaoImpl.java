package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Contact;

public class ContactDaoImpl implements ContactDao<Contact> {
	
	DbConnectionProvider db = new DbConnectionProvider();
	
	@Override
	public int addContact(Contact c) throws SQLException {
		
		Connection dbconnect = db.dbcon();
		
		String sql = "INSERT INTO CONTACTS VALUES(?,?,?,?)";
		PreparedStatement ps = dbconnect.prepareStatement(sql);
		ps.setString(1, c.getEmail());
		ps.setString(2, c.getName());
		ps.setString(3, c.getContact());
		ps.setString(4, c.getOwner());

		int status = ps.executeUpdate();

		dbconnect.close();

		return status;
	}

	@Override
	public int deleteContact(String contactNo, String owner) throws SQLException {
		
		Connection dbconnect = db.dbcon();
		
		String sql = "DELETE FROM CONTACTS WHERE CONTACT_NO=? AND OWNER=?";
		PreparedStatement ps = dbconnect.prepareStatement(sql);
		ps.setString(1, contactNo);
		ps.setString(2, owner);

		int status = ps.executeUpdate();

		dbconnect.close();

		return status;
	}

	@Override
	public int updateContact(Contact contact) throws SQLException {
		
		Connection dbconnect = db.dbcon();
		
		String sql = "UPDATE CONTACTS SET EMAIL=?,NAME=? WHERE CONTACT_NO=? AND OWNER=?";
		PreparedStatement ps = dbconnect.prepareStatement(sql);
		ps.setString(1, contact.getEmail());
		ps.setString(2, contact.getName());
		ps.setString(3, contact.getContact());
		ps.setString(4, contact.getOwner());
		
		int status = ps.executeUpdate();

		dbconnect.close();

		return status;
	}

	@Override
	public String getContactCount(String owner) throws SQLException {
		
		Connection dbconnect = db.dbcon();
		
		String sql = "SELECT COUNT(*) FROM CONTACTS WHERE OWNER=?";
		PreparedStatement ps = dbconnect.prepareStatement(sql);
		ps.setString(1, owner);
		
		String contact="";
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			contact=rs.getString(1);
		}
		dbconnect.close();
		return contact;
	}
	
	@Override
	public List<Contact> getAllContact(String id) throws SQLException {
		
		Connection dbconnect = db.dbcon();
		
		String sql = "SELECT * FROM CONTACTS WHERE OWNER=?";
		PreparedStatement ps = dbconnect.prepareStatement(sql);
		ps.setString(1, id);

		List<Contact> list = new ArrayList<Contact>();
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Contact con = new Contact();
			con.setEmail(rs.getString(1));
			con.setName(rs.getString(2));
			con.setContact(rs.getString(3));
			con.setOwner(rs.getString(4));
			list.add(con);
		}

		dbconnect.close();

		return list;
	}
	
	@Override
	public Contact getContact(String contactNo, String owner) throws SQLException {
		
		Connection dbconnect = db.dbcon();
		
		String sql = "SELECT * FROM CONTACTS WHERE CONTACT_NO=? AND OWNER=?";
		PreparedStatement ps = dbconnect.prepareStatement(sql);
		ps.setString(1, contactNo);
		ps.setString(2, owner);
		
		Contact con = new Contact();
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			con.setEmail(rs.getString(1));
			con.setName(rs.getString(2));
			con.setContact(rs.getString(3));
		}
		dbconnect.close();
		return con;
	}
	
	@Override
	public boolean ifExists(String contactNo, String owner) throws SQLException {
		boolean flag=false;
		
		Connection dbconnect = db.dbcon();
		
		String sql = "SELECT * FROM CONTACTS WHERE CONTACT_NO=? AND OWNER=?";
		PreparedStatement ps = dbconnect.prepareStatement(sql);
		ps.setString(1, contactNo);
		ps.setString(2, owner);
		
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			flag=true;
		}
		dbconnect.close();
		return flag;
	}

}
