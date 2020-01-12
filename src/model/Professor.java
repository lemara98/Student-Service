package model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Klasa profesor
 * @author Aleksandar, Mile
 *
 */
public class Professor {
	private String firstName;
	private String lastName;
	private Date date;
	private String livingAdress;
	private String number;
	private String email;
	private String workAdress;
	private String idNumber;
	private String title;
	private String rank;
	private List<Subject> subjects;
	//SimpleDateFormat df;
	
	/**
	 * Konstruktor sa svim parametrima
	 * @param idNumber
	 * @param firstName
	 * @param lastName
	 * @param date
	 * @param livingAdress
	 * @param number
	 * @param email
	 * @param workAdress
	 * @param title
	 * @param rank
	 * @param subjects
	 * @throws ParseException
	 */
	public Professor(String idNumber, String firstName, String lastName, String date, String livingAdress, String number, String email,
			String workAdress, String title, String rank, List<Subject> subjects) throws ParseException {
		super();
		this.idNumber = idNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.date = new SimpleDateFormat("dd.MM.yyyy.").parse(date);
		this.livingAdress = livingAdress;
		this.number = number;
		this.email = email;
		this.workAdress = workAdress;
		this.title = title;
		this.rank = rank;
		this.subjects = subjects;
	//	this.subjects = new ArrayList<Subject>();
	}	
	
	/**
	 * Konstruktor sa svim parametrima izuzev predmeta koje drzi profesor
	 * @param idNumber
	 * @param firstName
	 * @param lastName
	 * @param date
	 * @param livingAdress
	 * @param number
	 * @param email
	 * @param workAdress
	 * @param title
	 * @param rank
	 * @throws ParseException
	 */
	public Professor(String idNumber, String firstName, String lastName, String date, String livingAdress, String number, String email,
			String workAdress, String title, String rank) throws ParseException {
		super();
		this.idNumber = idNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.date = new SimpleDateFormat("dd.MM.yyyy.").parse(date);
		this.livingAdress = livingAdress;
		this.number = number;
		this.email = email;
		this.workAdress = workAdress;
		this.title = title;
		this.rank = rank;
	//	this.subjects = subjects;
		this.subjects = new ArrayList<Subject>();
	}	
	
	
	/**
	 * Prilagodjena toString metoda za upis u fajl
	 */
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		DateFormat df = new SimpleDateFormat("dd.MM.yyyy."); 
		for (Subject s : subjects)  {
			str.append("; " + s.getCode());
		}
		return  idNumber + "; " + firstName + "; " + lastName + "; " + df.format(date) + "; "
				+ livingAdress + "; " + number + "; " + email + "; " + workAdress
				+ "; " + title + "; " + rank + str;
	}

	
	/**
	 * Konstruktor bez parametara
	 */
	public Professor() {
		super();
	}



	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(String date) throws ParseException {
		this.date = new SimpleDateFormat("dd.MM.yyyy.").parse(date);;
	}
	public String getLivingAdress() {
		return livingAdress;
	}
	public void setLivingAdress(String livingAdress) {
		this.livingAdress = livingAdress;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getWorkAdress() {
		return workAdress;
	}
	public void setWorkAdress(String workAdress) {
		this.workAdress = workAdress;
	}
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	
	/**
	 * Metoda koja proverava da li su 2 profesora jednaka po primarnom kljucu (broju licne karte)
	 */
	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		
		if (!(o instanceof Professor))
			return false;
		
		Professor p = (Professor)o;
		
		if (this.idNumber == p.idNumber)
				return true;
			
		return false;
	}


	public List<Subject> getSubjects() {
		return subjects;
	}


	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}
	
	/**
	 * Dodaje predmet u listu
	 * @param s - predmet
	 */
	public void addSubjectToSubjects(Subject s) {
		this.subjects.add(s);
	}
	
	/**
	 * pretrazuje bazu podataka za unetom sifrom predmeta i kad pronadje stalja ga u listu 
	 * @param s - sifra predmeta
	 */
	public void addSubjectToSubjects(String s) {
		Subject newSubject = MyBase.getInstance().getSubject(s);
		this.subjects.add(newSubject);
	}
	
	/**
	 * brise predmet iz liste
	 * @param sub - predmet
	 */
	public void deleteSubjectFromSubjects(Subject sub) {
		this.subjects.remove(sub);
	}


}
