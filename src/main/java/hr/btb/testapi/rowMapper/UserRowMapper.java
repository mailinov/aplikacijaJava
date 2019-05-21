package hr.btb.testapi.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import hr.btb.testapi.model.User;

public class UserRowMapper  implements RowMapper<User> {

	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user = new User();
			user.setId(rs.getLong("id"));
			user.setIme(rs.getString("ime"));
			user.setPrezime(rs.getString("prezime"));
			user.setMail(rs.getString("mail"));
			user.setKorisnicko_ime(rs.getString("korisnicko_ime"));
			user.setLozinka(rs.getString("lozinka"));
			user.setKontakt_broj(rs.getString("kontakt_broj"));
			
			return user;
		
	}

}
