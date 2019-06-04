package hr.btb.testapi.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import hr.btb.testapi.model.Uredaj;

public class UredajRowMapper implements RowMapper<Uredaj> {

	public Uredaj mapRow(ResultSet rs, int rowNum) throws SQLException {

		Uredaj uredaj = new Uredaj();

		uredaj.setId(rs.getLong("id"));
		uredaj.setImei(rs.getString("imei"));
		uredaj.setModel(rs.getString("model"));
		uredaj.setProizvodac(rs.getString("proizvodac"));
		uredaj.setSerial_uredaj(rs.getString("serial_uredaj"));
		uredaj.setTip(rs.getString("tip"));

		return uredaj;

	}

}
