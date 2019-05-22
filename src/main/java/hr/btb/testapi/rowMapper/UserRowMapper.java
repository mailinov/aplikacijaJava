package hr.btb.testapi.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


import org.springframework.jdbc.core.RowMapper;

import hr.btb.testapi.model.Adresa;
import hr.btb.testapi.model.Kvar;
import hr.btb.testapi.model.Rola;
import hr.btb.testapi.model.Uredaj;
import hr.btb.testapi.model.User;

public class UserRowMapper  implements RowMapper<User> {

	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			/*Rola r = new Rola();
			r.setId(rs.getInt("r.id"));	
			r.setTitle(rs.getString("r.title"));
			
			Adresa a = new Adresa();
			a.setId(rs.getInt("a.id"));	
			a.setUlica(rs.getString("a.ulica"));
			a.setKucni_broj(rs.getString("a.kucni_broj"));
			a.setGrad(rs.getString("a.grad"));
			a.setPostanski_broj(rs.getString("a.postanski_broj"));
			
			Kvar k = new Kvar();
			k.setId(rs.getLong("k.id"));
			k.setOpis_kvara(rs.getString("k.opis_kvara"));
			k.setOstecenja(rs.getString("k.ostecenja"));
			k.setDodatne_informacije(rs.getString("k.dodatne_informacija"));
			k.setDatum_zaprimanja(rs.getDate("k.datum_zaprimanja"));
			k.setDatum_zavrsetka(rs.getDate("k.datum_zavrsetka"));
			k.setStatus_uredaja(rs.getString("k.status_uredaja"));
			
			Uredaj ur = new Uredaj();
			ur.setId(rs.getLong("ur.id"));	
			ur.setImei(rs.getString("ur.imei"));
			ur.setModel(rs.getString("ur.model"));
			ur.setProizvodac(rs.getString("ur.proizvodac"));
			ur.setSerial_uredaj(rs.getString("ur.serial_uredaj"));
			ur.setTip(rs.getString("ur.tip"));
			ur.setId_kvara(k);*/
			
		
			User user = new User();
			user.setId(rs.getInt("u.id"));
			user.setIme(rs.getString("u.ime"));
			user.setPrezime(rs.getString("u.prezime"));
			user.setMail(rs.getString("u.mail"));
			user.setKorisnicko_ime(rs.getString("u.korisnicko_ime"));
			user.setLozinka(rs.getString("u.lozinka"));
			user.setKontakt_broj(rs.getString("u.kontakt_broj"));
			/*user.setRola(r);
			user.setAdresa(a);
			user.setUredaj(ur);*/
			
			
			return user;
		
	}

}
