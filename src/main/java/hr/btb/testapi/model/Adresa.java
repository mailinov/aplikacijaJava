package hr.btb.testapi.model;

public class Adresa {
	
	private int id;
	private String ulica;
	private String kucni_broj;
	private String grad;
	private String postanski_broj;
	public int getId() {
		return id;
	}
	public void setId(int l) {
		this.id = l;
	}
	public String getUlica() {
		return ulica;
	}
	public void setUlica(String ulica) {
		this.ulica = ulica;
	}
	public String getKucni_broj() {
		return kucni_broj;
	}
	public void setKucni_broj(String kucni_broj) {
		this.kucni_broj = kucni_broj;
	}
	public String getGrad() {
		return grad;
	}
	public void setGrad(String grad) {
		this.grad = grad;
	}
	public String getPostanski_broj() {
		return postanski_broj;
	}
	public void setPostanski_broj(String postanski_broj) {
		this.postanski_broj = postanski_broj;
	}
	

}
