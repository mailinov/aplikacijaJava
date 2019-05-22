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
import hr.btb.testapi.rowMapper.UredajRowMapper;
import hr.btb.testapi.rowMapper.UserRowMapper;

@Component
public class UserDao implements UserDaoInterface {

	private static final Logger log = LoggerFactory.getLogger(UredajController.class);

	@Autowired
	JdbcTemplate jdbcTemplate;
	
//------------------------------------------------------SPREMANJE JEDNOG USERA ----------------------------------------------------------------------------------

	public int insertOne(User obj) throws SQLException {
		String sqlQuery = "INSERT INTO user (ime, prezime, mail, korisnicko_ime, lozinka, kontakt_broj, id_rola, id_adresa, id_uredaja ) VALUES (?,?,?,?,?,?,?,?,?)";
		int vrati = 0;
		
		vrati = jdbcTemplate.update(sqlQuery, obj.getIme(), obj.getPrezime(), obj.getMail(), obj.getKorisnicko_ime(),
				obj.getLozinka(), obj.getKontakt_broj(), obj.getId_rola(), obj.getId_adresa(), obj.getId_uredaja());
		return vrati;
	}


//------------------------------------------------------DOBIVANJE JEDNOG USERA PO ID----------------------------------------------------------------------------------

	public User getOne(Long id) throws SQLException {
		String sqlQuery = "SELECT * FROM user u, rola r, adresa a, uredaj ur, kvar k WHERE u.id=? and u.id_rola = r.id and u.id_adresa = a.id and u.id_uredaja = ur.id and k.id = ur.id_kvara";
		Object[] args = new Object[] { id };
		User user = jdbcTemplate.queryForObject(sqlQuery, args, new UserRowMapper());

		return user;
	}

//------------------------------------------------------UPDATE JEDNOG USERA PO ID----------------------------------------------------------------------------------
	public int update(User obj) throws SQLException  {
		int vrati = 0;
		String sqlQuery = "UPDATE user u SET ime=?, prezime=?, mail=?, korisnicko_ime=?, lozinka=?, kontakt_broj=? WHERE id=?;";
		Object[] arg = new Object[] { obj.getIme(), obj.getPrezime() , obj.getMail(), obj.getKorisnicko_ime(),
				obj.getLozinka(), obj.getKontakt_broj(), obj.getId() };
		vrati = jdbcTemplate.update(sqlQuery, arg);
		return vrati;

	}
	
//------------------------------------------------------DOBIVANJE LISTE USERA----------------------------------------------------------------------------------

	public List<User> getAll() throws SQLException {
		String sqlQuery = "SELECT * FROM user u";
		List<User> myList = (List<User>) jdbcTemplate.query(sqlQuery, new UserRowMapper());
		return myList;
	}

//------------------------------------------------------BRISANJE JEDNOG USERA PO ID----------------------------------------------------------------------------------	

	public int remove(long id) throws SQLException {
		{
			String tableName = null;
			String recordId = null;

			tableName = "user";
			recordId = "id";

			String sqlDelete = "DELETE from " + tableName + " WHERE " + recordId + "=?";
			Object[] args = new Object[] { id };
			jdbcTemplate.update(sqlDelete, args);
			return 1;

		}

	}
}
