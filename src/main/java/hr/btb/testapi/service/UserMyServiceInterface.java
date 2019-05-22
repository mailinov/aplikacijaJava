package hr.btb.testapi.service;

import java.sql.SQLException;


import hr.btb.testapi.model.User;

public interface UserMyServiceInterface {
	
	User get(long id) throws SQLException;
	
	public int delete(long id) throws SQLException;
	
	int save(User user) throws SQLException;

}
