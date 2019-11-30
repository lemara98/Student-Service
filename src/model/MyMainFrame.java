package model;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyMainFrame extends JFrame {

	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9032128792693493257L;
	
	private static MyMainFrame instance = null;
	
	private MyMainFrame() {
		super();
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension ss = kit.getScreenSize();
		
		setTitle("Studentska služba");
		setIconImage(new ImageIcon("C:\\Users\\Mile\\Desktop\\workspace\\studentskasluzba\\slike\\ikonice\\1800_Icon_Pack_20x20\\PNG2_black_icons\\naruto [#119].png").getImage());
		setLayout(new BorderLayout());
		//setResizable(true);
		
		setSize(new Dimension(ss.width/2, ss.height/2));
		setLocationRelativeTo(null);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel panelSever = new JPanel();
		JPanel panelCentar = new JPanel();
		panelSever.setLayout(new FlowLayout());
		
		
		add(MyMenuBar.getInstance(), BorderLayout.NORTH);
		add(MyStatusBar.getInstance(), BorderLayout.SOUTH);
		add(panelCentar, BorderLayout.CENTER);
		
		setVisible(true);
	}
	
	public static  MyMainFrame getInstance() {
		if (instance == null) {
			instance = new MyMainFrame();
			return instance;
		} else {
			return null;
		}
	}

}