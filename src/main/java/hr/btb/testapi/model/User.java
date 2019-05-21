package hr.btb.testapi.model;

public class User {
	private long id;
	private String ime;
	private String prezime;
	private String mail;
	private String korisnicko_ime;
	private String lozinka;
	private String kontakt_broj;
	private Rola rola;

	public String getKontakt_broj() {
		return kontakt_broj;
	}

	public void setKontakt_broj(String kontakt_broj) {
		this.kontakt_broj = kontakt_broj;
	}

	public String getKorisnicko_ime() {
		return korisnicko_ime;
	}

	public void setKorisnicko_ime(String korisnicko_ime) {
		this.korisnicko_ime = korisnicko_ime;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String email) {
		this.mail = email;
	}

	public String getLozinka() {
		return lozinka;
	}

	public void setLozinka(String adresa) {
		this.lozinka = adresa;
	}

	public Rola getRola() {
		return rola;
	}

	public void setRola(Rola rola) {
		this.rola = rola;
	}

}
