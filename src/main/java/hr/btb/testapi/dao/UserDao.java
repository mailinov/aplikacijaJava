package hr.btb.testapi.dao;

import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import hr.btb.testapi.model.User;
import hr.btb.testapi.rowMapper.UserRowMapper;

@Component
public class UserDao implements UserDaoInterface {

	@Autowired
	JdbcTemplate jdbcTemplate;

	// -------------DOHVAĆANJE USERA SA SVIM PODACIMA-------------

	public User getOneAll(Long id) throws SQLException {
		String sqlQuery = "SELECT * FROM user u, rola r, adresa a, uredaj ur, kvar k WHERE u.id=? and u.id_rola = r.id and u.id_adresa = a.id and u.id_uredaja = ur.id and k.id = ur.id_kvara";
		Object[] args = new Object[] { id };
		try {
			User user = jdbcTemplate.queryForObject(sqlQuery, args, new UserRowMapper(true));
			return user;
		} catch (Exception e) {
			System.out.println("--------------------------- Problem kod SQL");
			e.printStackTrace();
			return null;
		}

	}

	// ------------DOBIVANJE JEDNOG USERA PO ID---------------

	public User getOne(Long id) throws SQLException {
		String sqlQuery = "SELECT * FROM user u WHERE u.id=? ";
		Object[] args = new Object[] { id };
		User user = jdbcTemplate.queryForObject(sqlQuery, args, new UserRowMapper());

		return user;
	}

	// ----------SPREMANJE JEDNOG USERA------------------------

	public int insertOne(User obj) throws SQLException {
		String sqlQuery = "INSERT INTO user (ime, prezime, mail, korisnicko_ime, lozinka, kontakt_broj, id_rola, id_adresa, id_uredaja) VALUES (?,?,?,?,?,?,?,?,?)";
		int vrati = 0;
		vrati = jdbcTemplate.update(sqlQuery, obj.getIme(), obj.getPrezime(), obj.getMail(), obj.getKorisnicko_ime(),
				obj.getLozinka(), obj.getKontakt_broj(), obj.getRola().getId(), obj.getAdresa().getId(), obj.getUredaj().getId());
		return vrati;
	}

	// ---------BRISANJE JEDNOG USERA PO ID---------------------

	public int remove(long id) throws SQLException {
		{

			String sqlDelete = "DELETE from user WHERE id=?";
			Object[] args = new Object[] { id };
			jdbcTemplate.update(sqlDelete, args);
			return 1;

		}

	}

	// ---------DOBIVANJE LISTE USERA----------------------------

	public List<User> getAll() throws SQLException {
		String sqlQuery = "SELECT * FROM user u";
		List<User> myList = (List<User>) jdbcTemplate.query(sqlQuery, new UserRowMapper());
		return myList;
	}

	// -------UPDATE JEDNOG USERA PO ID--------------------------

	public int update(User obj) throws SQLException {
		int vrati = 0;
		String sqlQuery = "UPDATE user u SET ime=?, prezime=?, mail=?, korisnicko_ime=?, lozinka=?, kontakt_broj=? WHERE id="
				+ obj.getId();
		Object[] arg = new Object[] { obj.getIme(), obj.getPrezime(), obj.getMail(), obj.getKorisnicko_ime(),
				obj.getLozinka(), obj.getKontakt_broj() };
		vrati = jdbcTemplate.update(sqlQuery, arg);
		return vrati;

	}

}
