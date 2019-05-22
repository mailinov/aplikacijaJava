package hr.btb.testapi.dao;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import hr.btb.testapi.controller.UredajController;
import hr.btb.testapi.model.Uredaj;
import hr.btb.testapi.rowMapper.UredajRowMapper;

@Component
public class UredajDao implements UredajDaoInterface {

	private static final Logger log = LoggerFactory.getLogger(UredajController.class);

	@Autowired
	JdbcTemplate jdbcTemplate;

//------------------------------------------------------SPREMANJE JEDNOG UREĐAJA----------------------------------------------------------------------------------
	public int insertOne(Uredaj obj) throws SQLException {
		String sqlQuery = "INSERT INTO uredaj (imei, model, proizvodac, serial_uredaj, tip) VALUES (?,?,?,?,?)";
		int vrati = 0;
		System.out.println("---------------getSerial=" + obj.getSerial_uredaj());
		vrati = jdbcTemplate.update(sqlQuery, obj.getImei(), obj.getModel(), obj.getProizvodac(),
				obj.getSerial_uredaj(), obj.getTip());
		return vrati;
	}

//------------------------------------------------------UPDATE JEDNOG UREĐAJA PO ID----------------------------------------------------------------------------------
	public int update(Uredaj obj) throws SQLException {
		int vrati = 0;
		String sqlQuery = "UPDATE uredaj SET imei=?, model=?, proizvodac=?, serial_uredaj=?, tip=? WHERE id=?;";
		Object[] arg = new Object[] { obj.getImei(), obj.getModel(), obj.getProizvodac(), obj.getSerial_uredaj(),
				obj.getTip(), obj.getId() };
		vrati = jdbcTemplate.update(sqlQuery, arg);
		return vrati;

	}

//------------------------------------------------------DOBIVANJE LISTE UREĐAJA----------------------------------------------------------------------------------
	public List<Uredaj> getAll() throws SQLException {
		String sqlQuery = "SELECT * FROM uredaj";
		List<Uredaj> myList = (List<Uredaj>) jdbcTemplate.query(sqlQuery, new UredajRowMapper());
		return myList;
	}

//------------------------------------------------------BRISANJE JEDNOG UREĐAJA PO ID----------------------------------------------------------------------------------	
	public int remove(long id) throws SQLException {
		String tableName = null;
		String recordId = null;

		tableName = "uredaj";
		recordId = "id";

		String sqlDelete = "DELETE from " + tableName + " WHERE " + recordId + "=?";
		Object[] args = new Object[] { id };
		jdbcTemplate.update(sqlDelete, args);
		return 1;

	}

//------------------------------------------------------DOBIVANJE JEDNOG UREĐAJA PO ID----------------------------------------------------------------------------------
	public Uredaj getOne(Long id) throws SQLException {
		String sqlQuery = "SELECT id, imei, model, proizvodac, serial_uredaj, tip FROM uredaj WHERE id=?";
		Object[] args = new Object[] { id };
		Uredaj uredaj = jdbcTemplate.queryForObject(sqlQuery, args, new UredajRowMapper());

		return uredaj;
	}

}
