package model;

import java.util.ArrayList;
import java.util.List;

public class Professor {
	private String firstName;
	private String lastName;
	private String date;
	private String livingAdress;
	private String number;
	private String email;
	private String workAdress;
	private String idNumber;
	private String title;
	private String rank;
	private List<Subject> subjects;
	//SimpleDateFormat df;
	
	public Professor(String idNumber, String firstName, String lastName, String date, String livingAdress, String number, String email,
			String workAdress, String title, String rank, List<Subject> subjects) {
		super();
		this.idNumber = idNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.date = date;
		this.livingAdress = livingAdress;
		this.number = number;
		this.email = email;
		this.workAdress = workAdress;
		this.title = title;
		this.rank = rank;
		this.subjects = subjects;
	//	this.subjects = new ArrayList<Subject>();
	}	
	
	public Professor(String idNumber, String firstName, String lastName, String date, String livingAdress, String number, String email,
			String workAdress, String title, String rank) {
		super();
		this.idNumber = idNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.date = date;
		this.livingAdress = livingAdress;
		this.number = number;
		this.email = email;
		this.workAdress = workAdress;
		this.title = title;
		this.rank = rank;
	//	this.subjects = subjects;
		this.subjects = new ArrayList<Subject>();
	}	
	
	
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		
		for (Subject s : subjects)  {
			str.append("; " + s.getCode());
		}
		return  idNumber + "; " + firstName + "; " + lastName + "; " + date + "; "
				+ livingAdress + "; " + number + "; " + email + "; " + workAdress
				+ "; " + title + "; " + rank + str;
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
	
	public void addSubjectToSubjects(Subject s) {
		this.subjects.add(s);
	}
	
	public void addSubjectToSubjects(String s) {
		Subject newSubject = MyBase.getInstance().getSubject(s);
		this.subjects.add(newSubject);
	}
	
	public void deleteSubjectFromSubjects(Subject sub) {
		this.subjects.remove(sub);
	}


}
