package controller;

import model.AddFrameSubject;
import model.MyBase;
import model.MyMainFrame;
import model.Professor;

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
}
