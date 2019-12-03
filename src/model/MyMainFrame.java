package model;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import view.ProfessorJTable;

public class MyMainFrame extends JFrame {

	private static final long serialVersionUID = -9032128792693493257L;
	
	private static MyMainFrame instance = null;
	
	private MyMainFrame() {
		super();
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension ss = kit.getScreenSize();
		
		setTitle("Studentska služba");
		setIconImage(new ImageIcon("slike\\ikonice\\1800_Icon_Pack_20x20\\PNG2_black_icons\\naruto [#119].png").getImage());
		
		
		setLayout(new BorderLayout());
		setResizable(true);  // Sale podesi ovo kako ti odgovara! ##### Mile promenio na true! Da bi bio fenseraj
							// ## Primetices da sam ogranicio minimumSize da ne bi
		
		setSize(new Dimension(ss.width*3/4, ss.height*3/4));
		setMinimumSize(new Dimension(ss.width*3/4 - 50, ss.height*3/4 - 50));
		setLocationRelativeTo(null);
		
		
		// Sigurnosni Prozor za izlaz iz programa
	//	izlazniProzor();		// izuzetno dosadna opcija pri testiranju aplikacije! Otkomentarisati pri kraju i dugme exit obavezno!
		
		
	// 	Odavde sam menjao tako da tu prilagodi. Od ove linije pa do 77
		
		JPanel panelCentar = new JPanel();
	
		
		// Centralni panel
		
		panelCentar.setLayout(new BorderLayout());
		
		JPanel panelToolBar = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panelToolBar.setPreferredSize(new Dimension(300,30));
		panelToolBar.setBackground(Color.gray);
		
		JTabbedPane panelSaKarticama = new JTabbedPane();
		
		JLabel l1  = new JLabel("Panel sa profesorima");
		panelSaKarticama.addTab("Profesori", l1);
		
		JLabel l2  = new JLabel("Panel sa studentima");
		panelSaKarticama.addTab("Studentima", l2);
		
		
		// Dodavanje na centralni panel
		panelCentar.add(panelToolBar, BorderLayout.NORTH);
		panelCentar.add(panelSaKarticama, BorderLayout.CENTER);
		
		// Dodavanje na Mainframe
		add(MyMenuBar.getInstance(), BorderLayout.NORTH);
		add(MyStatusBar.getInstance(), BorderLayout.SOUTH);
		add(panelCentar, BorderLayout.CENTER);
		
		// Dodajemo toolbar 
		panelCentar.setLayout(new BorderLayout());
		MyToolBar myToolBar = new MyToolBar();
		panelCentar.add(myToolBar,BorderLayout.NORTH);
		
		JTabbedPane kartice = new JTabbedPane();
		
		ProfessorJTable professorJTable = new ProfessorJTable();
		JScrollPane professorPane = new JScrollPane(professorJTable);
		professorJTable.setVisible(true);
		
		kartice.addTab("Professors", professorPane);
		panelCentar.add(kartice,BorderLayout.CENTER);
		

		// UIManager promenjen celokupan izgled aplikacije -- u ovom slucaju ne znacajno
		try {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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
	
	/**
	 * Sigurnosni prozor: Izbacuje YES_NO JOptionPane
	 *
	 */
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