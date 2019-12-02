package model;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
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
		setIconImage(new ImageIcon("slike\\ikonice\\1800_Icon_Pack_20x20\\PNG2_black_icons\\naruto [#119].png").getImage());
		
		
		setLayout(new BorderLayout());
		setResizable(false);  // Sale podesi ovo kako ti odgovara!
		
		setSize(new Dimension(ss.width*3/4, ss.height*3/4));
		setLocationRelativeTo(null);
		
		
		// Sigurnosni Prozor za izlaz iz programa
	//	izlazniProzor();		// izuzetno dosadna opcija pri testiranju aplikacije! Otkomentarisati pri kraju i dugme exit obavezno!
		
		JPanel panelSever = new JPanel();
		JPanel panelCentar = new JPanel();
		panelSever.setLayout(new FlowLayout());
		
		
		add(MyMenuBar.getInstance(), BorderLayout.NORTH);
		add(MyStatusBar.getInstance(), BorderLayout.SOUTH);
		add(panelCentar, BorderLayout.CENTER);
		
		panelCentar.setLayout(new BorderLayout());
		MyToolBar myToolBar = new MyToolBar();
		panelCentar.add(myToolBar,BorderLayout.NORTH);
		
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
	
	public void izlazniProzor() {
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				int potvrda = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit the program?\nMake sure that you saved changes.", "Exit program confirmation", JOptionPane.YES_NO_OPTION);
				
				if (potvrda == JOptionPane.YES_OPTION) {
					setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					System.exit(0);
				}
				else {
					setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				}
			}
		});
	}
	

}