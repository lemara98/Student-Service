package testovi;

import controller.MyController;
import model.MyBase;
import model.MyMainFrame;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyMainFrame.getInstance();
		MyBase.getInstance();
		MyController.getInstance();
	}

}
