package mainFrame2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import mainFrame2.MainFrame;

public class MainFrame extends JFrame{

	private static MainFrame instance = null;
	
	public static MainFrame getInstance() {
		if(instance == null) {
			instance = new MainFrame();
		}
		return instance;
	}
	
	private MainFrame() {
		super();
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int height = screenSize.height;
		int width = screenSize.width;
		setTitle("Studentska sluzba");
		setSize(width*3/4,height*3/4);
		//postavljamo akciju pri zatvaranju prozora
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setBackground(Color.LIGHT_GRAY);
		setLayout(new BorderLayout());
		setResizable(false);
		setVisible(true);
	}
	
	
}
