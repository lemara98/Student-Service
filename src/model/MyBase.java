package model;

import java.util.ArrayList;
import java.util.List;

public class MyBase {
	private static MyBase instance = null;
	
	public static MyBase getInstance() {
		if(instance == null)
			instance = new MyBase();
		
		return instance;
	}
	
	private List<Professor> professors;		//Ove liste nam sluze kao baza podataka za tabelu
	private List<String> columnsProfessor;
	private List<Student> students;
	private List<String> columnsStudent;
	private List<Subject> subjects;
	private List<String> columnsSubject;
	
	private MyBase() {
		initProfessors();		//na Pocetku inicijalizujemo listu profesora

		initSubjects();
		initStudents();

	}
	
	private void initProfessors() {
		professors = new ArrayList<Professor>();
		
		Subject s1 = new Subject( "Bases of Data", 5, 3, "Ivana", students);
		
		List<Subject> subjects1 = new ArrayList<Subject>();
		subjects1.add(s1);
		
		Professor p3 = new Professor("Milan","Vikakovic","03/02/56","Branimira Cosica",19223828,"vidakovic@gmail.com","FTN",122332134,"Professor","1.");
		Professor p1 = new Professor("Pera","Peric","16/08/67","Branimira Cosica",061533466,"pera@gmail.com","FTN",12358701,"Profesor","Dr.");
		Professor p2 = new Professor("Djoka","Djokic","04/02/99","Kralja Petra",0613442334,"djoka@gmail.com","FTN",12358702,"Profesor","Dr.");
		professors.add(p3);
		professors.add(p1);
		professors.add(p2);
		
		columnsProfessor = new ArrayList<String>();
		columnsProfessor.add("FirstName");
		columnsProfessor.add("LastName");
		columnsProfessor.add("Date");
		columnsProfessor.add("Adress");
		columnsProfessor.add("PhoneNumber");
		columnsProfessor.add("Email");
		columnsProfessor.add("WorkPlace");
		columnsProfessor.add("Title");
		columnsProfessor.add("Rank");
	}
	
	public List<Professor> getProfessors(){
		return professors;		//returns my list of professors that we are using to create Professor table
	}

	public void setProfessors(List<Professor> professors) {
		this.professors = professors;	// sets my list of professors 
	}
	
	public int getProfessorColumnCount() {
		return columnsProfessor.size(); 	//returns number of columns in the table	
	}
	public String getProfessorColumnName(int index) {
		return columnsProfessor.get(index);		//returns the name of a column
	}
	public Professor getProfessorRow(int rowIndex) {
		return professors.get(rowIndex);		//returns one of my professors from the list
	}
	public String getProfessorValueAt(int row, int column) {		//returns the string of one table field
			Professor prof = this.professors.get(row);
			switch(column) {
			case 0:
				return prof.getFirstName();
			case 1:
				return prof.getLastName();
			case 2:
				return prof.getDate();
			case 3:
				return prof.getLivingAdress();
			case 4:
				return Long.toString(prof.getNumber());
			case 5:
				return prof.getEmail();
			case 6:
				return prof.getWorkAdress();
			case 7:
				return prof.getTitle();
			case 8:
				return prof.getRank();
			default:
				return null;
		}
	}
	
	public void addProfessor() {	//this method adds a new professor to my list(table)
		//this.professors.add(pr);
	}
	
	public void deleteProfessor(long idNumber) {  //this method deletes a professor from my table by idNumber
		List<Professor> temp = new ArrayList<Professor>(); 
		
		for(Professor pr : professors) {
			if(pr.getIdNumber() == idNumber) {
				temp.add(pr);
			}
		}
		
		professors.removeAll(temp);
	}
	
	public void editProfessor() {
		
	}
	
	//////////////////////////////////////////////////SUBJECT/////////////////////////////////////////////////
	public void initSubjects() {
		subjects = new ArrayList<Subject>();
		
		Subject s1 = new Subject("OISISI",5,3,null,null);
		Subject s2 = new Subject("NANS",5,3,null,null);
		Subject s3 = new Subject("PJISP",1,1,null,null);
		subjects.add(s1);
		subjects.add(s2);
		subjects.add(s3);
		
		columnsSubject = new ArrayList<String>();
		columnsSubject.add("Name");
		columnsSubject.add("Semester");
		columnsSubject.add("Year of study");
		columnsSubject.add("Professor");
		
		
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}

	public List<String> getColumnsSubject() {
		return columnsSubject;
	}

	public void setColumnsSubject(List<String> columnsSubject) {
		this.columnsSubject = columnsSubject;
	}
	
	public int getSubjectColumnCount() {
		return columnsSubject.size();
	}
	
	public String getSubjectColumnName(int index) {
		return columnsSubject.get(index);
	}
	
	public Subject getSubjectRow(int row) {
		return subjects.get(row);
	}
	
	public String getSubjectValueAt(int row, int column) {
		Subject s = subjects.get(row);
		switch(column) {
		case 0:
			return s.getName();
		case 1:
			return Integer.toString(s.getSemester());
		case 2:
			return Integer.toString(s.getYearOfStuding());
		case 3:
			return s.getProfessor();
		default:
			return null;
		}
	}
	
	public void addSubject(Subject s) {
		subjects.add(s);
		MyMainFrame.getInstance().azurirajPrikaz();	//moram ovde da stavim iz nekog razloga?
	}
	
	public void deleteSubject(String code) {
		List<Subject> temp = new ArrayList<Subject>();
		
		for(Subject s : subjects) {
			if(s.getCode() == code) {	//ako se code podudara treba ga izbrisati
				temp.add(s);
			}
		}
		
		subjects.removeAll(temp);
	}
	
	public void editSubject() {
		
	}

	/////////////////	Studenti	/////////////////

	
	private void initStudents() {
		students = new ArrayList<Student>();
		columnsStudent = new ArrayList<String>();
		
		Subject s1 = new Subject("Algebra", 1, 1, "Rade Doros", students);
		
		ArrayList<Subject> sp = new ArrayList<Subject>();
		sp.add(s1);
		Student st1 = new Student("Ljuba", "Alicic", "01-04-1959", "Ilidza", "062431234", "ljuba.alicic@uns.ac.rs", "RA1/3019", "01-10-3019", 1, StatusStudenta.B, 6.00, sp);
		students.add(st1);
		
		columnsStudent.add("Ime");
		columnsStudent.add("Prezime");
		columnsStudent.add("Datum rodjenja");
		columnsStudent.add("Kontakt telefon");
		columnsStudent.add("Email Adresa");
		columnsStudent.add("Broj indeksa");
		columnsStudent.add("Datum upisa");
		columnsStudent.add("Trenutna godina studija");
		columnsStudent.add("Prosecna ocena");
		columnsStudent.add("Spisak predmeta koje student slusa");
		
		
	}
	

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public int getStudentsColumnCount() {
		return columnsStudent.size(); 	//returns number of columns in the table	
	}
	public String getStudentsColumnName(int index) {
		return columnsStudent.get(index);		//returns the name of a column
	}
	public Professor getStudentsRow(int rowIndex) {
		return professors.get(rowIndex);		//returns one of my professors from the list
	}
	public String getStudentsValueAt(int row, int column) {		//returns the string of one table field
			Student stud = this.students.get(row);
			switch(column) {
			case 0:
				return stud.getIme();
			case 1:
				return stud.getPrezime();
			case 2:
				return stud.getDatumRodjenja().toString();
			case 3:
				return stud.getAdresaStanovanje();
			case 4:
				return stud.getEmailAdresa();
			case 5:
				return stud.getEmailAdresa();
			case 6:
				return stud.getBrojIndeksa();
			case 7:
				return stud.getDatumUpisa().toString();
			case 8:
				return Integer.toString(stud.getTrenutnaGodinaStudija());
			case 9:
				return Double.toString(stud.getProsecnaOcena());
			case 10:	
				return stud.getSpisakPredmetaKojeStudentSlusa().toString();
			default:
				return null;
		}
	}
}
	

	
	
	
	
	
	

