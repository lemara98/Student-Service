package model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.security.auth.Subject;

public class Professor {
	private String firstName;
	private String lastName;
	private String date;
	private String livingAdress;
	private long number;
	private String email;
	private String workAdress;
	private long idNumber;
	private String title;
	private String rank;
	//private List<Subject> subjects;
	//SimpleDateFormat df;
	public Professor(String firstName, String lastName, String date, String livingAdress, long number, String email,
			String workAdress, long idNumber, String title, String rank) {
		super();
		
		this.firstName = firstName;
		this.lastName = lastName;
		//SimpleDateFormat = newDateFormat
		this.date = date;
		this.livingAdress = livingAdress;
		this.number = number;
		this.email = email;
		this.idNumber = idNumber;
		this.title = title;
		this.rank = rank;
		//this.subjects = subjects2;
	}
	
	
	
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
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getLivingAdress() {
		return livingAdress;
	}
	public void setLivingAdress(String livingAdress) {
		this.livingAdress = livingAdress;
	}
	public long getNumber() {
		return number;
	}
	public void setNumber(long number) {
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
	public long getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(long idNumber) {
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
//	public List<Subject> getSubjects() {
//		return subjects;
//	}
//	public void setSubjects(List<Subject> subjects) {
//		this.subjects = subjects;
//	}

}
