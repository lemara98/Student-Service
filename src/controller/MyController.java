package controller;

import model.AddFrameStudent;
import model.AddFrameSubject;
import model.MyBase;
import model.MyMainFrame;
import model.Professor;
import model.Student;

public class MyController {
	private static MyController instance = null;
	
	public static MyController getInstance() {
		if(instance == null)
			instance = new MyController();
		
		return instance;
	}
	
	private MyController() {}
	
	//////////////////////////////////////////////PREDMET/////////////////////////////////////////////////////
	public void addSubject() {
		AddFrameSubject.getInstance().setVisible(true);
		MyMainFrame.getInstance().azurirajPrikaz();
	}
	
	
	
	//////////////////////////////////////////////PROFESOR/////////////////////////////////////////////////////
	
	public void deleteProfessor(int rowSelected) {
		try {
			Professor pr = MyBase.getInstance().getProfessorRow(rowSelected);
			MyBase.getInstance().deleteProfessor(pr.getIdNumber());
			MyMainFrame.getInstance().azurirajPrikaz();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	////////////////////////////////////////////STUDENT/////////////////////////////////////////////////////
	
	public void addStudent() {
		new AddFrameStudent().setVisible(true);
		MyMainFrame.getInstance().azurirajPrikaz();
		
	}
	
	public void deleteStudent(int rowSelected) {
		try {
			Student st = MyBase.getInstance().getStudentRow(rowSelected);
			MyBase.getInstance().deleteStudent(st.getBrojIndeksa());
			MyMainFrame.getInstance().azurirajPrikaz();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
