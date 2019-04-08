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
public class UredajDao implements UredajDaoInterface  {
	
	private static final Logger log = LoggerFactory.getLogger(UredajController.class);
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	public int insertOne(Uredaj obj) throws SQLException {
		String sqlQuery = "INSERT INTO uredaj (imei, model, proizvodac, serial_uredaj, tip) VALUES (?,?,?,?,?)";
		int vrati=0;
		System.out.println("---------------getSerial="+obj.getSerial_uredaj());
		try {
			vrati = jdbcTemplate.update(sqlQuery, obj.getImei() , obj.getModel(), obj.getProizvodac(),obj.getSerial_uredaj(), obj.getTip());
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return vrati;
	}

	public int update(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<Uredaj> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public int remove(Object obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Uredaj getOne(Long id) {
		String sqlQuery = "SELECT id, imei, model, proizvodac, serial_uredaj, tip FROM uredaj WHERE id=?";
		Object[] args = new Object[] {id};
		Uredaj uredaj =  jdbcTemplate.queryForObject(sqlQuery, args, new UredajRowMapper());
		
		return uredaj;
	}

	

}
