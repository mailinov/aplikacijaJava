package hr.btb.testapi.model;

public class Kvar {
	
	private long id;
	private String opis_kvara;
	private String ostecenja;
	private String dodatne_informacije;
	public long getId() {
		return id;
	}
	public void setId(long l) {
		this.id = l;
	}
	public String getOpis_kvara() {
		return opis_kvara;
	}
	public void setOpis_kvara(String opis_kvara) {
		this.opis_kvara = opis_kvara;
	}
	public String getOstecenja() {
		return ostecenja;
	}
	public void setOstecenja(String ostecenja) {
		this.ostecenja = ostecenja;
	}
	public String getDodatne_informacije() {
		return dodatne_informacije;
	}
	public void setDodatne_informacije(String dodatne_informacije) {
		this.dodatne_informacije = dodatne_informacije;
	}

}