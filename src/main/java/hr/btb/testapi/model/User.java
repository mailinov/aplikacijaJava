package hr.btb.testapi.model;

public class User {
	private int id;
	private String ime;
	private String prezime;
	private String email;
	private String adresa;
	private Rola rola;

	public int getId() {
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public Rola getRola() {
		return rola;
	}

	public void setRola(Rola rola) {
		this.rola = rola;
	}

}
