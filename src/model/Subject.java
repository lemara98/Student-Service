package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Klasa predmet
 * @authors Aleksandar, Mile
 *
 */
public class Subject {

	private String code;
	private String name;
	private int semester;
	private int yearOfStuding;
	private Professor professor;
	private ArrayList<Student> students;
	
	/**
	 * Prazan Konstruktor
	 */
	public Subject() {}
	
	/**
	 * Konstruktor kopije
	 * @param sub
	 */
	public Subject(Subject sub) {
		super();
		this.code = new String(sub.code);
		this.name = new String(sub.name);
		this.semester = sub.semester;
		this.yearOfStuding = sub.yearOfStuding;
		this.professor = sub.professor;
		this.students = new ArrayList<Student>(sub.students);
	}
	
	
	/**
	 * Konstruktor koji prima sve parametre
	 * @param code
	 * @param name
	 * @param semester
	 * @param yearOfStuding
	 * @param professor
	 * @param students
	 */
	public Subject(String code, String name, int semester, int yearOfStuding, Professor professor,
			ArrayList<Student> students) {
		super();
		this.code = code;
		this.name = name;
		this.semester = semester;
		this.yearOfStuding = yearOfStuding;
		this.professor = professor;
		this.students = students;
	}
	
	/**
	 * Konstruktor koji prima sve parametre sem spiska Studenata
	 * @param code
	 * @param name
	 * @param semester
	 * @param yearOfStuding
	 * @param professor
	 */
	public Subject(String code, String name, int semester, int yearOfStuding, Professor professor) {
		super();
		this.code = code;
		this.name = name;
		this.semester = semester;
		this.yearOfStuding = yearOfStuding;
		this.professor = professor;
		this.students = new ArrayList<Student>() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 2595655369364615933L;

			
		};
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSemester() {
		return semester;
	}
	public void setSemester(int semester) {
		this.semester = semester;
	}
	public int getYearOfStuding() {
		return yearOfStuding;
	}
	public void setYearOfStuding(int yearOfStuding) {
		this.yearOfStuding = yearOfStuding;
	}
	public Professor getProfessor() {
		return professor;
	}
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(ArrayList<Student> students) {
		this.students = students;
	}
	
	/**
	 * toString metoda za Predmet prilagodjena formatu cuvanja u fajl
	 */
	@Override
	public String toString() {
		StringBuilder stud = new StringBuilder();
		for (Student s : students) {
			stud.append("; " + s.getBrojIndeksa());
		}
		
		if (professor != null)
			return  code + "; " + name + "; " + semester + "; "
					+ yearOfStuding + "; " + professor.getIdNumber() + stud;
		else
			return  code + "; " + name + "; " + semester + "; "
			+ yearOfStuding + "; " + stud;
	}
	
	/**
	 * equals metoda koja proverava da li su dva predmea jednaka po njihovom primarnom kljucu (sifri predmeta)
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (obj.getClass() != this.getClass())
			return false;
		Subject sb = (Subject)obj;
		if(sb.getCode() == this.getCode())
			return true;
		return false;
	}
	
	
	public void deleteStudentFromSubject(Student stud) {
			for(Student st : this.students) {
				if(st.equals(stud)) {
					this.students.remove(stud);
					break;
				}
			}
		}
	
	public void addStudentToSubject(Student stud) {
		boolean t = true;
		for(Student s : this.students) {
			if (stud.equals(s)) {
				t = false;
				break;
			}
		}
		
		if(t)
			this.students.add(stud);
	}
	
	
	
}
