package hr.btb.testapi.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import hr.btb.testapi.model.Kvar;

public class KvarRowMapper implements RowMapper<Kvar> {

	public Kvar mapRow(ResultSet rs, int rowNum) throws SQLException {
			Kvar kvar = new Kvar();
			kvar.setId(rs.getLong("id"));
			kvar.setOpis_kvara(rs.getString("opis_kvara"));
			kvar.setOstecenja(rs.getString("ostecenja"));
			kvar.setDodatne_informacije(rs.getString("dodatne_informacije"));
			
			return kvar;
		
	}

}
