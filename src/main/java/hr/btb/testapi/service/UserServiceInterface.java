package hr.btb.testapi.service;

import java.sql.SQLException;
import java.util.List;

import hr.btb.testapi.model.Uredaj;
import hr.btb.testapi.model.User;

public interface UserServiceInterface {
	
	User get(long id) throws SQLException;
	
	public int delete(long id) throws SQLException;
	
	int save(User user) throws SQLException;
	
	List<User> list() throws SQLException;
	
	public int userUpdate(User user) throws SQLException;

}
