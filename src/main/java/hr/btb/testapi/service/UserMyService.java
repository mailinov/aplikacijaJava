package hr.btb.testapi.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hr.btb.testapi.model.User;
import hr.btb.testapi.dao.UredajDaoInterface;
import hr.btb.testapi.dao.UserDao;
import hr.btb.testapi.dao.UserDaoInterface;



@Service("myServiceUser")
public class UserMyService implements UserMyServiceInterface {
	
	@Autowired
	UserDaoInterface dao;

	public User get(long id) throws SQLException {
		return dao.getOne(id);
	}

}
