package hr.btb.testapi.dao;

import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import hr.btb.testapi.model.Adresa;
import hr.btb.testapi.rowMapper.AdresaRowMapper;

@Component
public class AdresaDao implements AdresaDaoInterface {

	@Autowired
	JdbcTemplate jdbcTemplate;

	// ------------DOBIVANJE JEDNE ADRESE PO ID---------------

	public Adresa getOne(int id) throws SQLException {
		String sqlQuery = "SELECT * FROM adresa WHERE id=" + id;
		Adresa adresa = jdbcTemplate.queryForObject(sqlQuery, new AdresaRowMapper());

		return adresa;
	}

	// ------------SPREMANJE ADRESE---------------------------

	public int insertOne(Adresa obj) throws SQLException {
		String sqlQuery = "INSERT INTO adresa (ulica, kucni_broj, grad, postanski_broj) VALUES (?,?,?,?)";
		int id=0;
		int vrati = jdbcTemplate.update(sqlQuery, obj.getUlica(), obj.getKucni_broj(), obj.getGrad(),
				obj.getPostanski_broj());
		if(vrati!=0) {
			String sqlQuery1 = "SELECT LAST_INSERT_ID()";
			id = jdbcTemplate.queryForObject(sqlQuery1, Integer.class);
		}
		return id;
	}

	// ------------BRISANJE ADRESE---------------------------

	public int remove(int id) throws SQLException {
		String sqlDelete = "DELETE from adresa WHERE id=?";
		Object[] args = new Object[] { id };
		jdbcTemplate.update(sqlDelete, args);
		return 1;

	}

	// ------------DOBIVANJE LISTE SVIH ADRESA --------------

	public List<Adresa> getAll() throws SQLException {
		String sqlQuery = "SELECT * FROM adresa";
		List<Adresa> myList = (List<Adresa>) jdbcTemplate.query(sqlQuery, new AdresaRowMapper());
		return myList;
	}

	// ------------UPDATE ADRESE----------------------------

	public int update(Adresa obj) throws SQLException {
		String sqlQuery = "UPDATE adresa SET ulica=?, kucni_broj=?, grad=?, postanski_broj=? WHERE id=?;";
		Object[] arg = new Object[] { obj.getUlica(), obj.getKucni_broj(), obj.getGrad(), obj.getPostanski_broj(),
				obj.getId() };
		int vrati = jdbcTemplate.update(sqlQuery, arg);
		return vrati;
	}

}
