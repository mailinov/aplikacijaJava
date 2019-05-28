package hr.btb.testapi.service;

import java.sql.SQLException;
import java.util.List;
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
		try {
			return dao.getOneAll(id);
		} catch (Exception e) {
			System.out.println("--------------------------- Problem kod servisa ");
			e.printStackTrace();
			return null;
		}
	}

	public User get(long id) throws SQLException {

		return dao.getOne(id);

	}

	public int save(User user) throws SQLException {

		try {
			System.out.println("---------------------------");
			mail.sendMail(user);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return dao.insertOne(user);

	}

	public int delete(long id) throws SQLException {
		return dao.remove(id);
	}

	public List<User> list() throws SQLException {

		return dao.getAll();
	}

	public int userUpdate(User user) throws SQLException {

		int x = dao.update(user);

		if (x == 1) {
			try {
				System.out.println("---------------------------");
				mail.sendMail(user);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return x;
	}

}
