package dao;

import java.sql.SQLException;
import java.util.List;

import beans.Contact;

public interface ContactDao<T> {
	int addContact(T t) throws SQLException;
	int deleteContact(String contactNo, String owner) throws SQLException;
	int updateContact(T t) throws SQLException;
	String getContactCount(String owner) throws SQLException;
	Contact getContact(String contactNo, String owner) throws SQLException;
	List<T> getAllContact(String id) throws SQLException;
	boolean ifExists(String contactNo, String owner) throws SQLException;
}
