package hr.btb.testapi.dao;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import hr.btb.testapi.controller.UredajController;
import hr.btb.testapi.model.Uredaj;
import hr.btb.testapi.model.User;
import hr.btb.testapi.rowMapper.UserRowMapper;

@Component
public class UserDao implements UserDaoInterface {
	
	private static final Logger log = LoggerFactory.getLogger(UredajController.class);

	@Autowired
	JdbcTemplate jdbcTemplate;

	public int insertOne(User obj) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	public User getOne(Long id) throws SQLException {
		String sqlQuery = "SELECT id, ime, prezime, mail, korisnicko_ime, lozinka, kontakt_broj FROM user WHERE id=?";
		Object[] args = new Object[] { id };
		User user = jdbcTemplate.queryForObject(sqlQuery, args, new UserRowMapper());

		return user;
	}

	

	public int update(User obj) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<User> getAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public int remove(long id) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
