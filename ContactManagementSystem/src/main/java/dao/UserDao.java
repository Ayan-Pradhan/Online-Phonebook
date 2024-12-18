package dao;

import java.sql.SQLException;

public interface UserDao<T> {
	int add(T t) throws SQLException;
	T getById(T t) throws SQLException;
	boolean ifExists(String username) throws SQLException;
	void reset(String username,String password) throws SQLException;
	boolean login(String username, String password) throws SQLException;
	
}
