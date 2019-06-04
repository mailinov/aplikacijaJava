package hr.btb.testapi.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import hr.btb.testapi.model.Kvar;

public class KvarRowMapper implements RowMapper<Kvar> {

	public Kvar mapRow(ResultSet rs, int rowNum) throws SQLException {
			Kvar kvar = new Kvar();
			kvar.setId(rs.getInt("id"));
			kvar.setOpis_kvara(rs.getString("opis_kvara"));
			kvar.setOstecenja(rs.getString("ostecenja"));
			kvar.setDodatne_informacije(rs.getString("dodatne_informacije"));
			kvar.setStatus_uredaja(rs.getString("status_uredaja"));
			kvar.setDatum_zaprimanja(rs.getDate("datum_zaprimanja"));
			kvar.setDatum_zavrsetka(rs.getDate("datum_zavrsetka"));
			
			return kvar;
		
	}

}
