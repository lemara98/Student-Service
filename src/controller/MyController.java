package controller;

import javax.swing.JOptionPane;

import model.AddFrameProfessor;
import model.AddFrameStudent;
import model.AddFrameSubject;
import model.MyBase;
import model.MyMainFrame;
import model.Professor;
import model.Student;
import model.Subject;

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
	
	public void deleteSubject(int rowSelected) {
		try {
			Subject s = MyBase.getInstance().getSubjectRow(rowSelected);
			MyBase.getInstance().deleteSubject(s.getCode());
			MyMainFrame.getInstance().azurirajPrikaz();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	//////////////////////////////////////////////PROFESOR/////////////////////////////////////////////////////

	public void addProfessor() {
		AddFrameProfessor.getInstance().setVisible(true);
		MyMainFrame.getInstance().azurirajPrikaz();
	}
	
	
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
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void editStudent(int rowSelected) {
	//		Student st = MyBase.getInstance().getStudentRow(rowSelected);
	//		new EditFrameStudent(st).setVisible(true);
		try {
			MyBase.getInstance().editStudent(rowSelected);
			MyMainFrame.getInstance().azurirajPrikaz();
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(MyMainFrame.getInstance(), "YOU HAVE TO CHOOOSE A STUDENT FIRST", "WARNING", JOptionPane.WARNING_MESSAGE);
		}
	}
	
	
}
