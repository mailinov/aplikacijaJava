package hr.btb.testapi.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import hr.btb.testapi.model.Adresa;


public class AdresaRowMapper implements RowMapper<Adresa> {

	public Adresa mapRow(ResultSet rs, int rowNum) throws SQLException {
			Adresa adresa = new Adresa();
			adresa.setId(rs.getInt("id"));
			adresa.setUlica(rs.getString("ulica"));
			adresa.setKucni_broj(rs.getString("kucni_broj"));
			adresa.setGrad(rs.getString("grad"));
			adresa.setPostanski_broj(rs.getString("postanski_broj"));
			
			
			return adresa;
		
	}

}

