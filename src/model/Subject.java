package model;

import java.util.ArrayList;
import java.util.List;


public class Subject {

	private static int codeCnt = 0;
	private String code;
	private String name;
	private int semester;
	private int yearOfStuding;
	private Professor professor;
	private List<Student> students;
	
	public Subject() {}
	
	public Subject(String name, int semester, int yearOfStuding, Professor professor,
			List<Student> students) {
		super();
		++codeCnt;
		this.code = Integer.toString(codeCnt);
		this.name = name;
		this.semester = semester;
		this.yearOfStuding = yearOfStuding;
		this.professor = professor;
		this.students = students;
	}
	
	public Subject(String name, int semester, int yearOfStuding, Professor professor) {
		super();
		++codeCnt;
		this.code = Integer.toString(codeCnt);
		this.name = name;
		this.semester = semester;
		this.yearOfStuding = yearOfStuding;
		this.professor = professor;
		this.students = null;
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
	public void setStudents(List<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		String stud = new String();
		for (Student s : students) {
			stud += ", " + s.getBrojIndeksa();
		}
		return  code + ", " + name + ", " + semester + ", "
				+ yearOfStuding + ", " + professor.getIdNumber() + stud;
	}
	
//	@Override
//	public String toString() {
//		return name + ", " + semester + ", "
//				+ yearOfStuding + ", " + professor + ", " + students;
//	}
	
	
}
