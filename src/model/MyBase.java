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
		
//		Professor p3 = new Professor("Milan","Vikakovic","03-02","Branimira Cosica",(long)19223828,"vidakovic@gmail.com","FTN",(long)122332134,"Professor","1.",subjects);
//		Professor p1 = new Professor("Pera","Peric",new Date(1999,02,03),"Branimira Cosica",061533466,"pera@gmail.com","FTN",12358701,"Profesor","Dr.",subjects);
//		Professor p2 = new Professor("Djoka","Djokic","04/02/99","Kralja Petra",0613442334,"djoka@gmail.com","FTN",12358702,"Profesor","Dr.",subjects);
	//	professors.add(p3);
	}
	
	
}
