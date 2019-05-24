package hr.btb.testapi.service;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hr.btb.testapi.model.User;
import hr.btb.testapi.dao.UserDaoInterface;
import hr.btb.testapi.email.MailBuilder;

@Service
public class UserService implements UserServiceInterface {


	@Autowired
	UserDaoInterface dao;
	
	@Autowired
	MailBuilder mail;
	
	public User getOneAll(long id) throws SQLException {
		return dao.getOneAll(id);
	}
	
	
	public User get(long id) throws SQLException {
		
		return dao.getOne(id);
		
	}

	public int delete(long id) throws SQLException {
		return dao.remove(id);
	}

	public int save(User user) throws SQLException {
		
		try {
		System.out.println("----------------------------------------------");
		mail.sendMail(user);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		int x = user.getRola().getId();
		if (x==1) {
			return dao.insertOne(user);
		}
		return dao.insertOneAll(user);
	}

	public List<User> list() throws SQLException {

		return dao.getAll();
	}

	public int userUpdate(User user) throws SQLException {
		return dao.update(user);
	}

	

}
