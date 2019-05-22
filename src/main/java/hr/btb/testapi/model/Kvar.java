package hr.btb.testapi.model;

import java.sql.Date;

public class Kvar {

	private long id;
	private String opis_kvara;
	private String ostecenja;
	private String dodatne_informacije;
	private String status_uredaja;
	private Date datum_zaprimanja;
	private Date datum_zavrsetka;

	public String getStatus_uredaja() {
		return status_uredaja;
	}

	public void setStatus_uredaja(String status_uredaja) {
		this.status_uredaja = status_uredaja;
	}

	public Date getDatum_zaprimanja() {
		return datum_zaprimanja;
	}

	public void setDatum_zaprimanja(Date datum_zaprimanja) {
		this.datum_zaprimanja = datum_zaprimanja;
	}

	public Date getDatum_zavrsetka() {
		return datum_zavrsetka;
	}

	public void setDatum_zavrsetka(Date datum_zavrsetka) {
		this.datum_zavrsetka = datum_zavrsetka;
	}

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