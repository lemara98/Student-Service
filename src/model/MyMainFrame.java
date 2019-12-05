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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import view.AbstractTableModelProfessor;
import view.AbstractTableModelStudent;
import view.AbstractTableModelSubject;
import view.ProfessorJTable;
import view.StudentJTable;
import view.SubjectJTable;


public class MyMainFrame extends JFrame {

	private static final long serialVersionUID = -9032128792693493257L;
	
	private static MyMainFrame instance = null;
	private JTabbedPane kartice;
	private ProfessorJTable professorJTable;
	private SubjectJTable subjectJTable;
	private StudentJTable studentJTable;
	
	private MyMainFrame() {
		super();
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension ss = kit.getScreenSize();
		
		setTitle("Studentska služba");
		setIconImage(new ImageIcon("slike\\ikonice\\1800_Icon_Pack_20x20\\PNG2_black_icons\\naruto [#119].png").getImage());
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
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
		
		// Dodavanje na centralni panel
		panelCentar.add(panelToolBar, BorderLayout.NORTH);
		
		// Dodavanje na Mainframe
		add(MyMenuBar.getInstance(), BorderLayout.NORTH);
		add(MyStatusBar.getInstance(), BorderLayout.SOUTH);
		add(panelCentar, BorderLayout.CENTER);
		
		// Dodajemo toolbar 
		panelCentar.setLayout(new BorderLayout());
		MyToolBar myToolBar = new MyToolBar();
		panelCentar.add(myToolBar,BorderLayout.NORTH);
		
		kartice = new JTabbedPane();
		
		professorJTable = new ProfessorJTable();
		JScrollPane professorPane = new JScrollPane(professorJTable);
		professorJTable.setVisible(true);
		
		subjectJTable = new SubjectJTable();
		JScrollPane subjectPane = new JScrollPane(subjectJTable);
		subjectJTable.setVisible(true);
		
		kartice.addTab("Professors", professorPane);
		kartice.addTab("Subjects", subjectPane);
		//Listener that sets addProfessor button depending of selected tab in tabbed pane
		kartice.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				if(kartice.getSelectedIndex() == 0 ) { 			// Proffesors
					myToolBar.getBtnAddProfessor().setEnabled(true);
					myToolBar.getBtnAddStudent().setEnabled(false);
				} else if (kartice.getSelectedIndex() == 1) {	// Subjects
					myToolBar.getBtnAddProfessor().setEnabled(false);
					myToolBar.getBtnAddStudent().setEnabled(true);
				} else {										// Students
					myToolBar.getBtnAddProfessor().setEnabled(false);
					myToolBar.getBtnAddStudent().setEnabled(false);
				}
				
			}
		});
		
		// Dodajemo karticu studenata
		studentJTable = new StudentJTable();
		JScrollPane studentPane = new JScrollPane(studentJTable);
		studentJTable.setVisible(true);
		
		kartice.addTab("Students", studentPane);

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
		if (instance == null) 
			instance = new MyMainFrame();
			
		return instance;
	}
	
	public int getSelectedTabbedPane() {
		return kartice.getSelectedIndex();
	}
	
	public ProfessorJTable getProfessorJTable() {
		return professorJTable;
	}
	
	public StudentJTable getStudentJTable() {
		return studentJTable;
	}
	
	public SubjectJTable getSubjectJTable() {
		return subjectJTable;
	}
	
	public void azurirajPrikaz() {
		AbstractTableModelProfessor modelProfessor = (AbstractTableModelProfessor)professorJTable.getModel();
		AbstractTableModelSubject modelSubject = (AbstractTableModelSubject)subjectJTable.getModel();
		AbstractTableModelStudent modelStudent = (AbstractTableModelStudent)studentJTable.getModel();
		modelProfessor.fireTableDataChanged();
		modelSubject.fireTableDataChanged();
		modelStudent.fireTableDataChanged();
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