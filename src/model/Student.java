package model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

enum StatusStudenta {B, S}

public class Student {
	


	private String ime;
	private String prezime;
	private Date datumRodjenja;
	private String adresaStanovanje;
	private String kontaktTelefon;
	private String emailAdresa;
	private String brojIndeksa;
	private Date datumUpisa;
	private Integer trenutnaGodinaStudija;
	private StatusStudenta status;
	private Double prosecnaOcena;
	private ArrayList<Subject> spisakPredmetaKojeStudentSlusa;
	
	

	
	public Student(String ime, String prezime, String datumRodjenja, String adresaStanovanje, String kontaktTelefon,
			String emailAdresa, String brojIndeksa, String datumUpisa, Integer trenutnaGodinaStudija,
			StatusStudenta status, Double prosecnaOcena) throws Exception {
		super();
		
		this.ime = ime;
		this.prezime = prezime;
		this.datumRodjenja = new SimpleDateFormat("dd.MM.yyyy.").parse(datumRodjenja);
		this.adresaStanovanje = adresaStanovanje;
		this.kontaktTelefon = kontaktTelefon;
		this.emailAdresa = emailAdresa;
		this.brojIndeksa = brojIndeksa;
		this.datumUpisa = new SimpleDateFormat("dd.MM.yyyy.").parse(datumUpisa);
		this.trenutnaGodinaStudija = trenutnaGodinaStudija;
		this.status = status;
		this.prosecnaOcena = prosecnaOcena;
		this.spisakPredmetaKojeStudentSlusa = new ArrayList<Subject>();
		
		if (this.datumRodjenja.compareTo(this.datumUpisa) > 0) throw new Exception();
	}

	public Student() {}	//Dodao sam prazan konstruktor Sale.
	
	public Student(Student s) {
		this.ime = s.ime;
		this.prezime = s.prezime;
		this.datumRodjenja = s.datumRodjenja;
		this.adresaStanovanje = s.adresaStanovanje;
		this.kontaktTelefon = s.kontaktTelefon;
		this.emailAdresa = s.emailAdresa;
		this.brojIndeksa = s.brojIndeksa;
		this.datumUpisa = s.datumUpisa;
		this.trenutnaGodinaStudija = s.trenutnaGodinaStudija;
		this.status = s.status;
		this.prosecnaOcena = s.prosecnaOcena;
		this.spisakPredmetaKojeStudentSlusa = new ArrayList<Subject>();
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


	public Date getDatumRodjenja() {
		return datumRodjenja;
	}


	public void setDatumRodjenja(String datumRodjenja) throws ParseException {
		this.datumRodjenja = new SimpleDateFormat("dd.MM.yyyy.").parse(datumRodjenja);
	}


	public String getAdresaStanovanje() {
		return adresaStanovanje;
	}


	public void setAdresaStanovanje(String adresaStanovanje) {
		this.adresaStanovanje = adresaStanovanje;
	}


	public String getKontaktTelefon() {
		return kontaktTelefon;
	}


	public void setKontaktTelefon(String kontaktTelefon) {
		this.kontaktTelefon = kontaktTelefon;
	}


	public String getEmailAdresa() {
		return emailAdresa;
	}


	public void setEmailAdresa(String emailAdresa) {
		this.emailAdresa = emailAdresa;
	}


	public String getBrojIndeksa() {
		return brojIndeksa;
	}


	public void setBrojIndeksa(String brojIndeksa) {
		this.brojIndeksa = brojIndeksa;
	}


	public Date getDatumUpisa() {
		return datumUpisa;
	}


	public void setDatumUpisa(String datumUpisa) throws ParseException {
		this.datumUpisa = new SimpleDateFormat("dd.MM.yyyy.").parse(datumUpisa);
	}


	public int getTrenutnaGodinaStudija() {
		return trenutnaGodinaStudija;
	}


	public void setTrenutnaGodinaStudija(int trenutnaGodinaStudija) {
		this.trenutnaGodinaStudija = trenutnaGodinaStudija;
	}

	public StatusStudenta getStatus() {
		return status;
	}


	public void setStatus(StatusStudenta status) {
		this.status = status;
	}


	public Double getProsecnaOcena() {
		return prosecnaOcena;
	}


	public void setProsecnaOcena(Double prosecnaOcena) {
		this.prosecnaOcena = prosecnaOcena;
	}


	@Override
	public String toString() {
		DateFormat df = new SimpleDateFormat("dd.MM.yyyy.");
		if (spisakPredmetaKojeStudentSlusa.isEmpty())
			return ime + "; " + prezime + "; " + df.format(datumRodjenja)
				+ "; " + adresaStanovanje + "; " + kontaktTelefon + "; "
				+ emailAdresa + "; " + brojIndeksa + "; " + df.format(datumUpisa)
				+ "; " + trenutnaGodinaStudija + "; " + status + "; "
				+ prosecnaOcena;
		
		StringBuilder predmeti = new StringBuilder();
		for (Subject i: spisakPredmetaKojeStudentSlusa) {
			predmeti.append("; " + i.getCode().toString());
		}
		
		return ime + "; " + prezime + "; " + df.format(datumRodjenja)
			+ "; " + adresaStanovanje + "; " + kontaktTelefon + "; "
			+ emailAdresa + "; " + brojIndeksa + "; " + df.format(datumUpisa)
			+ "; " + trenutnaGodinaStudija + "; " + status + "; "
			+ prosecnaOcena + predmeti;
			
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		
		if (!(o instanceof Student))
			return false;
		
		Student s = (Student) o;
		
		if (this.brojIndeksa.equals(s.brojIndeksa))
				return true;
			
		return false;
	}

	public ArrayList<Subject> getSpisakPredmetaKojeStudentSlusa() {
		return spisakPredmetaKojeStudentSlusa;
	}

	public void setSpisakPredmetaKojeStudentSlusa(ArrayList<Subject> spisakPredmetaKojeStudentSlusa) {
		this.spisakPredmetaKojeStudentSlusa = spisakPredmetaKojeStudentSlusa;
	}
	
	public void dodajPredmetUSpisak(Subject predmet) {
		spisakPredmetaKojeStudentSlusa.add(predmet);
	}
	
	public void skiniPredmetSaSpiska(int ind) {
		spisakPredmetaKojeStudentSlusa.remove(ind);
	}
	
	public void removeSubjectFromStudents(Subject s) {
		for(Subject sub: this.spisakPredmetaKojeStudentSlusa)
			if(s.equals(sub))
				this.spisakPredmetaKojeStudentSlusa.remove(sub);
	}

	public void ukloniStudentaSaPredmeta(Subject menjaniPredmet) {
		this.spisakPredmetaKojeStudentSlusa.remove(menjaniPredmet);
		
	}

}


