package hr.btb.testapi.dao;

import java.sql.SQLException;
import java.util.List;

import hr.btb.testapi.model.User;

public interface UserDaoInterface {
	
	public int insertOne(User obj) throws SQLException;

	public User getOne(Long id) throws SQLException;

	public int update(User obj) throws SQLException;

	public List<User> getAll() throws SQLException;

	public int remove(long id) throws SQLException;

}
