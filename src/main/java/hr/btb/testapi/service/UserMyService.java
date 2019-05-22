package hr.btb.testapi.service;

import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hr.btb.testapi.model.User;
import hr.btb.testapi.dao.UserDaoInterface;

@Service("myServiceUser")
public class UserMyService implements UserMyServiceInterface {

	@Autowired
	UserDaoInterface dao;

	public User get(long id) throws SQLException {
		return dao.getOne(id);
	}

	public int delete(long id) throws SQLException {
		return dao.remove(id);
	}

	public int save(User user) throws SQLException {

		return dao.insertOne(user);
	}

	public List<User> list() throws SQLException {

		return dao.getAll();
	}

}
