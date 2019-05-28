package hr.btb.testapi.dao;

import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import hr.btb.testapi.model.Uredaj;
import hr.btb.testapi.rowMapper.UredajRowMapper;

@Component
public class UredajDao implements UredajDaoInterface {

	@Autowired
	JdbcTemplate jdbcTemplate;

	// -----------DOBIVANJE JEDNOG UREĐAJA PO ID----------------

	public Uredaj getOne(Long id) throws SQLException {
		String sqlQuery = "SELECT id, imei, model, proizvodac, serial_uredaj, tip FROM uredaj WHERE id=?";
		Object[] args = new Object[] { id };
		Uredaj uredaj = jdbcTemplate.queryForObject(sqlQuery, args, new UredajRowMapper());

		return uredaj;
	}

	//------------SPREMANJE JEDNOG UREĐAJA------------------------

	public int insertOne(Uredaj obj) throws SQLException {
		String sqlQuery = "INSERT INTO uredaj (imei, model, proizvodac, serial_uredaj, tip) VALUES (?,?,?,?,?)";
		int vrati = jdbcTemplate.update(sqlQuery, obj.getImei(), obj.getModel(), obj.getProizvodac(),
				obj.getSerial_uredaj(), obj.getTip());

		return vrati;
	}

	// ---------BRISANJE JEDNOG UREĐAJA PO ID--------------------

	public int remove(long id) throws SQLException {
		String sqlDelete = "DELETE from uredaj WHERE id=?";
		Object[] args = new Object[] { id };
		jdbcTemplate.update(sqlDelete, args);
		return 1;

	}

	//----------DOBIVANJE LISTE UREĐAJA-----------------------------

	public List<Uredaj> getAll() throws SQLException {
		String sqlQuery = "SELECT * FROM uredaj";
		List<Uredaj> myList = (List<Uredaj>) jdbcTemplate.query(sqlQuery, new UredajRowMapper());
		return myList;
	}

	// ---------UPDATE JEDNOG UREĐAJA PO ID------------------------

	public int update(Uredaj obj) throws SQLException {
		String sqlQuery = "UPDATE uredaj SET imei=?, model=?, proizvodac=?, serial_uredaj=?, tip=? WHERE id=?;";
		Object[] arg = new Object[] { obj.getImei(), obj.getModel(), obj.getProizvodac(), obj.getSerial_uredaj(),
				obj.getTip(), obj.getId() };
		int vrati = jdbcTemplate.update(sqlQuery, arg);
		return vrati;
	}

}
