package model;

public class Student {
	private static int idCount = 0;
	private long idStudenta;
	private String ime;
	private String prezime;
	
	public Student(String ime, String prezime) {
		super();
		++idCount;
		this.idStudenta = idCount;
		this.ime = ime;
		this.prezime = prezime;
	}
	
	public long getIdStudenta() {
		return idStudenta;
	}
	public void setIdStudenta(long idStudenta) {
		this.idStudenta = idStudenta;
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

	

}


