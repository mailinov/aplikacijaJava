package hr.btb.testapi.dao;

import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import hr.btb.testapi.model.User;
import hr.btb.testapi.rowMapper.AllRowMaper;
import hr.btb.testapi.rowMapper.UserRowMapper;

@Component
public class UserDao implements UserDaoInterface {

	@Autowired
	JdbcTemplate jdbcTemplate;

	// -------------DOHVAĆANJE USERA SA SVIM PODACIMA-------------

	public User getOneAll(int id) throws SQLException {
		String sqlQuery = "SELECT * FROM user u, rola r, adresa a WHERE u.id="+id+" and u.id_rola = r.id and u.id_adresa = a.id;";
		try {
			User user = jdbcTemplate.queryForObject(sqlQuery, new AllRowMaper());
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
		String sqlQuery = "INSERT INTO user (ime, prezime, mail, korisnicko_ime, lozinka, kontakt_broj, id_rola, id_adresa) VALUES (?,?,?,?,?,?,?,?)";
		
		int id = 0;
		int vrati = jdbcTemplate.update(sqlQuery, obj.getIme(), obj.getPrezime(), obj.getMail(), obj.getKorisnicko_ime(),
				obj.getLozinka(), obj.getKontakt_broj(), obj.getRola().getId(), obj.getAdresa().getId());
		if(vrati!=0) {
			String sqlQuery1 = "SELECT LAST_INSERT_ID()";
			id = jdbcTemplate.queryForObject(sqlQuery1, Integer.class);
		}
		
		return id;
	}

	// ---------BRISANJE JEDNOG USERA PO ID---------------------

	public int remove(long id) throws SQLException {
		int obrisano = 0;
		
		{

			String sqlDelete = "DELETE from user WHERE id=?";
			Object[] args = new Object[] { id };
			obrisano = jdbcTemplate.update(sqlDelete, args);
			
			return obrisano;

		}

	}

	// ---------DOBIVANJE LISTE USERA----------------------------

	public List<User> getAll() throws SQLException {
		String sqlQuery = "SELECT * FROM user u, rola r, adresa a WHERE u.id_rola = r.id and u.id_adresa = a.id;";
		List<User> myList = (List<User>) jdbcTemplate.query(sqlQuery, new AllRowMaper());
		return myList;
	}

	// -------UPDATE JEDNOG USERA PO ID--------------------------

	public int update(User obj) throws SQLException {
		int vrati = 0;
		
		String sqlQuery = "UPDATE user u, adresa a SET u.ime=?, u.prezime=?, u.mail=?, u.korisnicko_ime=?, u.lozinka=?, u.kontakt_broj=?, "
				+ "a.ulica=?, a.kucni_broj=?, a.grad=?, a.postanski_broj=? WHERE a.id=u.id_adresa and u.id="
				+ obj.getId();
		Object[] arg = new Object[] { obj.getIme(), obj.getPrezime(), obj.getMail(), obj.getKorisnicko_ime(),
				obj.getLozinka(), obj.getKontakt_broj(), obj.getAdresa().getUlica(), obj.getAdresa().getKucni_broj(), obj.getAdresa().getGrad(), obj.getAdresa().getPostanski_broj() };
		vrati = jdbcTemplate.update(sqlQuery, arg);
		
		
		return vrati;

	}

}
