package model;

import java.util.ArrayList;
import java.util.Date;
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
	}
	
	private void initProfessors() {
		professors = new ArrayList<Professor>();
		students = new ArrayList<Student>();
		subjects = new ArrayList<Subject>();
		Subject s1 = new Subject("111", "Bases of Data", 5, 3, "Ivana", students);
		subjects.add(s1);
		
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

	
}
