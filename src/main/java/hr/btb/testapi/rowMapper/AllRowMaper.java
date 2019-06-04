package hr.btb.testapi.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


import org.springframework.jdbc.core.RowMapper;

import hr.btb.testapi.model.Adresa;
import hr.btb.testapi.model.Rola;
import hr.btb.testapi.model.User;
public class AllRowMaper implements RowMapper<User> {

	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		Rola r = new Rola();
		r.setId(rs.getInt("r.id"));	
		r.setTitle(rs.getString("r.title"));

		Adresa a = new Adresa();
		a.setId(rs.getInt("a.id"));	
		a.setUlica(rs.getString("a.ulica"));
		a.setKucni_broj(rs.getString("a.kucni_broj"));
		a.setGrad(rs.getString("a.grad"));
		a.setPostanski_broj(rs.getString("a.postanski_broj"));

		User user = new User();
		user.setId(rs.getInt("u.id"));
		user.setIme(rs.getString("u.ime"));
		user.setPrezime(rs.getString("u.prezime"));
		user.setMail(rs.getString("u.mail"));
		user.setKorisnicko_ime(rs.getString("u.korisnicko_ime"));
		user.setLozinka(rs.getString("u.lozinka"));
		user.setKontakt_broj(rs.getString("u.kontakt_broj"));
		user.setRola(r);
		user.setAdresa(a);


		return user;

	}
	



}
