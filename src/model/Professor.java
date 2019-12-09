package model;

public class Professor {
	private String firstName;
	private String lastName;
	private String date;
	private String livingAdress;
	private String number;
	private String email;
	private String workAdress;
	private long idNumber;
	private String title;
	private String rank;
	//private List<Subject> subjects;
	//SimpleDateFormat df;
	
	public Professor(String firstName, String lastName, String date, String livingAdress, String number, String email,
			String workAdress, long idNumber, String title, String rank) {
		super();
		
		this.firstName = firstName;
		this.lastName = lastName;
		//SimpleDateFormat = newDateFormat
		this.date = date;
		this.livingAdress = livingAdress;
		this.number = number;
		this.email = email;
		this.workAdress = workAdress;
		this.idNumber = idNumber;
		this.title = title;
		this.rank = rank;
		//this.subjects = subjects2;
	}
	
	
	
	@Override
	public String toString() {
		return  firstName + ", " + lastName + ", " + date + ", "
				+ livingAdress + ", " + number + ", " + email + ", " + workAdress
				+ ", " + idNumber + ", " + title + ", " + rank;
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
