package hr.btb.testapi.model;

public class Uredaj {

	private Long id;
	private String imei;
	private String model;
	private String proizvodac;
	private String serial_uredaj;
	private String tip;
	private Kvar id_kvara;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getProizvodac() {
		return proizvodac;
	}

	public void setProizvodac(String proizvodac) {
		this.proizvodac = proizvodac;
	}

	public String getSerial_uredaj() {
		return serial_uredaj;
	}

	public void setSerial_uredaj(String serial_uredaj) {
		this.serial_uredaj = serial_uredaj;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public Kvar getId_kvara() {
		return id_kvara;
	}

	public void setId_kvara(Kvar id_kvara) {
		this.id_kvara = id_kvara;
	}

}
