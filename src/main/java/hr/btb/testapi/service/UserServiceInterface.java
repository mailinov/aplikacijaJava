package hr.btb.testapi.service;

import java.sql.SQLException;
import java.util.List;
import hr.btb.testapi.model.User;

public interface UserServiceInterface {

	User getOneAll(int id) throws SQLException;

	// Get a single record
	User get(long id) throws SQLException;

	// Save a single record
	int save(User user) throws SQLException;

	// Delete a records
	public int delete(long id) throws SQLException;

	// get all records
	List<User> list() throws SQLException;

	// Update the records
	public int userUpdate(User user) throws SQLException;
	
	public void send(User user) throws SQLException;

}
