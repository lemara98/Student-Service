package controller;

import javax.swing.JOptionPane;

import model.AddFrameProfessor;
import model.AddFrameStudent;
import model.AddFrameSubject;
import model.EditFrameProfessor;
import model.MyBase;
import model.MyMainFrame;
import model.Professor;
import model.Student;
import model.Subject;

/**
 * Klasa kontroler
 * @authors Aleksandar, Mile
 *
 */
public class MyController {
	private static MyController instance = null;
	
	/**
	 * Singleton poziv za kreiranje konstruktra
	 * @return
	 */
	public static MyController getInstance() {
		if(instance == null)
			instance = new MyController();
		
		return instance;
	}
	
	/**
	 * privatni konstruktor bez parametara
	 */
	private MyController() {}
	
	//////////////////////////////////////////////PREDMET/////////////////////////////////////////////////////
	public void addSubject() {
		new AddFrameSubject().setVisible(true);
		MyMainFrame.getInstance().azurirajPrikaz();
	}
	
	public void deleteSubject(int rowSelected) {
		try {
			Subject s = MyBase.getInstance().getSubjectRow(rowSelected);
			for(Professor pr : MyBase.getInstance().getProfessors()) {
				for(Subject sub : pr.getSubjects()) {
					if (sub.equals(s)) {
						pr.deleteSubjectFromSubjects(sub);
						break;
					}
				}
			}
			
			for(Student stud : MyBase.getInstance().getStudents()) {
				for(Subject sub : stud.getSpisakPredmetaKojeStudentSlusa()) {
					if(sub.equals(s)) {
						stud.ukloniStudentaSaPredmeta(sub);
						break;
					}
				}
			}
			MyBase.getInstance().deleteSubject(s.getCode());
			MyMainFrame.getInstance().azurirajPrikaz();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void editSubject(int idx) {
		try {
		MyBase.getInstance().editSubject(idx);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//////////////////////////////////////////////PROFESOR/////////////////////////////////////////////////////

	public void addProfessor() {
		new AddFrameProfessor().setVisible(true);
		MyMainFrame.getInstance().azurirajPrikaz();
	}
	
	
	public void deleteProfessor(int rowSelected) {
		try {
			Professor pr = MyBase.getInstance().getProfessorRow(rowSelected);

			for(Subject s : MyBase.getInstance().getSubjects()) {
				if(s.getProfessor() != null)
					if (s.getProfessor().equals(pr)){
					s.setProfessor(null);
				}
			}
			MyBase.getInstance().deleteProfessor(pr.getIdNumber());
			MyMainFrame.getInstance().azurirajPrikaz();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void editProfessor(int menjaniProfesoridx) {
		String idProf = (String)MyMainFrame.getInstance().getProfessorJTable().getValueAt(menjaniProfesoridx, 0);
		Professor prof = null;
		for(Professor p : MyBase.getInstance().getProfessors()) {
			if(p.getIdNumber().equals(idProf)) {
				prof = p;
			}
		}
		new EditFrameProfessor(prof);
		MyMainFrame.getInstance().azurirajPrikaz();
	}
	
	////////////////////////////////////////////STUDENT/////////////////////////////////////////////////////
	
	public void addStudent() {
		new AddFrameStudent().setVisible(true);
		MyMainFrame.getInstance().azurirajPrikaz();
		
	}
	
	public void deleteStudent(int rowSelected) {
		try {
			Student st = MyBase.getInstance().getStudentRow(rowSelected);
			for(Subject sub : MyBase.getInstance().getSubjects()) {
				for(Student stud : sub.getStudents()) {
					if(stud.equals(st)) {
						sub.deleteStudentFromSubject(stud);
						break;
					}
				}
			}
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
