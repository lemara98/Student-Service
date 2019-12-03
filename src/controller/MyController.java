package controller;

import model.MyBase;
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
	
	
	
	
	//////////////////////////////////////////////PROFESOR/////////////////////////////////////////////////////
	
	public void deleteProfessor(int rowSelected) {
		try {
			Professor pr = MyBase.getInstance().getProfessorRow(rowSelected);
			MyBase.getInstance().deleteProfessor(pr.getIdNumber());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
