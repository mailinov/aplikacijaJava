package hr.btb.testapi.dao;

import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import hr.btb.testapi.model.Kvar;
import hr.btb.testapi.rowMapper.KvarRowMapper;

@Component
public class KvarDao implements KvarDaoInterface {

	@Autowired
	JdbcTemplate jdbcTemplate;

	// ------------DOBIVANJE JEDNOG KVRA PO ID---------------

	public Kvar getOne(int id) throws SQLException {
		String sqlQuery = "SELECT * FROM kvar WHERE id=" + id;
		Kvar kvar = jdbcTemplate.queryForObject(sqlQuery, new KvarRowMapper());

		return kvar;
	}

	// ------------SPREMANJE KVARA---------------------------

	public int insertOne(Kvar obj) throws SQLException {
		String sqlQuery = "INSERT INTO kvar (opis_kvara, ostecenja, dodatne_informacije, datum_zaprimanja, status_uredaja, datum_zavrsetka) VALUES (?,?,?,?,?,?)";
		int vrati = jdbcTemplate.update(sqlQuery, obj.getOpis_kvara(), obj.getOstecenja(), obj.getDodatne_informacije(),
				obj.getDatum_zaprimanja(), obj.getStatus_uredaja(), obj.getDatum_zavrsetka());
		return vrati;
	}

	// ------------BRISANJE KVARA---------------------------

	public int remove(int id) throws SQLException {
		String sqlDelete = "DELETE from kvar WHERE id=?";
		Object[] args = new Object[] { id };
		jdbcTemplate.update(sqlDelete, args);
		return 1;

	}

	// ------------DOBIVANJE LISTE KVRA --------------------

	public List<Kvar> getAll() throws SQLException {
		String sqlQuery = "SELECT * FROM kvar";
		List<Kvar> myList = (List<Kvar>) jdbcTemplate.query(sqlQuery, new KvarRowMapper());
		return myList;
	}

	// ------------UPDATE KVARA----------------------------

	public int update(Kvar obj) throws SQLException {
		String sqlQuery = "UPDATE kvar SET opis_kvara=?, ostecenja=?, dodatne_informacija=?, datum_zaprimanja=?, status_uredaja=?, datum_zavrsetka=? WHERE id=?;";
		Object[] arg = new Object[] { obj.getOpis_kvara(), obj.getOstecenja(), obj.getDodatne_informacije(),
				obj.getDatum_zaprimanja(), obj.getStatus_uredaja(), obj.getDatum_zavrsetka(), obj.getId() };
		int vrati = jdbcTemplate.update(sqlQuery, arg);
		return vrati;
	}

}
