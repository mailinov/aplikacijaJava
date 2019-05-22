package hr.btb.testapi.model;

public class User {
	private int id;
	private String ime;
	private String prezime;
	private String mail;
	private String korisnicko_ime;
	private String lozinka;
	private String kontakt_broj;
	private int id_rola;
	private int id_adresa;
	private int id_uredaja;
	public int getId_rola() {
		return id_rola;
	}

	public void setId_rola(int id_rola) {
		this.id_rola = id_rola;
	}

	public int getId_adresa() {
		return id_adresa;
	}

	public void setId_adresa(int id_adresa) {
		this.id_adresa = id_adresa;
	}

	public int getId_uredaja() {
		return id_uredaja;
	}

	public void setId_uredaja(int id_uredaja) {
		this.id_uredaja = id_uredaja;
	}

	private Rola rola;
	private Adresa adresa;
	


	public Adresa getAdresa() {
		return adresa;
	}

	public void setAdresa(Adresa adresa) {
		this.adresa = adresa;
	}

	public Uredaj getUredaj() {
		return uredaj;
	}

	public void setUredaj(Uredaj uredaj) {
		this.uredaj = uredaj;
	}

	private Uredaj uredaj;

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

	public void setId(int id) {
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
