package model;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 * Klasa za dodavanje predmeta u bazu
 * @author Aleksandar, Mile
 *
 */
public class AddFrameSubject extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5176543725768611200L;
	
	
	public ArrayList<JCheckBox> listaCekBoxova;
	
	/**
	 * Konstruktor Prozora bez parametara
	 */
	public AddFrameSubject() {
		super();
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int width = screenSize.width;
		int height = screenSize.height;
		setSize(new Dimension(width/3+100, height/3));
		this.setTitle("Dodaj novi predmet");
		this.setIconImage(new ImageIcon("slike\\ikonice\\1800_Icon_Pack_20x20\\PNG1_black_icons\\inbox_plus [#1554].png").getImage());
		setModal(true);
		
		//List of students on course
		listaCekBoxova = new ArrayList<JCheckBox>();
		JCheckBox box;
		for (Student student : MyBase.getInstance().getStudents()) {
			box = new JCheckBox(student.getBrojIndeksa() + " | " + student.getIme() + " " + student.getPrezime());
			listaCekBoxova.add(box);
		}
		
		this.setLocationRelativeTo(null);
		setBackground(java.awt.Color.LIGHT_GRAY);
		
		GridBagLayout gbl = new GridBagLayout();
		setLayout(new BorderLayout());
		
		JPanel leftPanel = new JPanel();
		leftPanel.setLayout(gbl);
		JPanel rightPanel = new JPanel();
		rightPanel.setLayout(gbl);
	
		JPanel downPanel = new JPanel();
		downPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		this.add(leftPanel,BorderLayout.WEST);	//sa leve strane ce biti polja za unos teksta
		this.add(downPanel, BorderLayout.SOUTH);	//dole ce biti submit i cancel button
		this.add(rightPanel,BorderLayout.CENTER); //desno ce biti lista studenata koji slusaju predmet
		
		//////////////////////////
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		
		gbc.anchor = GridBagConstraints.CENTER;
		
		JLabel codeLabel = new JLabel("Code*");
		leftPanel.add(codeLabel,gbc);
		
		//////////////////////////
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		
		gbc.anchor = GridBagConstraints.CENTER;
		
		JTextField codeTextField = new JTextField();
		codeTextField.setPreferredSize(new Dimension(150,20));
		leftPanel.add(codeTextField,gbc);
		
		//////////////////////////
		
		gbc = new GridBagConstraints();
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		
		gbc.anchor = GridBagConstraints.CENTER;
		
		JLabel nameLabel = new JLabel("Name*");
		leftPanel.add(nameLabel,gbc);
		
		//////////////////////////
		
		GridBagConstraints gbc2 = new GridBagConstraints();
		
		gbc2.gridx = 1;
		gbc2.gridy = 1;
		
		gbc2.gridwidth = 1;
		gbc2.gridheight = 1;
		
		gbc2.anchor = GridBagConstraints.CENTER;
		
		JTextField nameTextField = new JTextField();
		nameTextField.setPreferredSize(new Dimension(150,20));
		leftPanel.add(nameTextField,gbc2);
		
		//////////////////////////
		
		GridBagConstraints gbc3 = new GridBagConstraints();
		
		gbc3.gridx = 0;
		gbc3.gridy = 2;
		
		gbc3.gridwidth = 1;
		gbc3.gridheight = 1;
		
		gbc3.anchor = GridBagConstraints.CENTER;
		
		JLabel semesterLabel = new JLabel("Semester* [1-8]");
		leftPanel.add(semesterLabel,gbc3);
		
		//////////////////////////
		
		GridBagConstraints gbc4 = new GridBagConstraints();
		
		gbc4.gridx = 1;
		gbc4.gridy = 2;
		
		gbc4.gridwidth = 1;
		gbc4.gridheight = 1;
		
		gbc4.anchor = GridBagConstraints.CENTER;
		
		JTextField semesterTextField = new JTextField();
		semesterTextField.setPreferredSize(new Dimension(150,20));
		leftPanel.add(semesterTextField,gbc4);
		
		//////////////////////////
		
		GridBagConstraints gbc5 = new GridBagConstraints();
		
		gbc5.gridx = 0;
		gbc5.gridy = 3;
		
		gbc5.gridwidth = 1;
		gbc5.gridheight = 1;
		
		gbc5.anchor = GridBagConstraints.CENTER;
		
		JLabel yearLabel = new JLabel("Year of study* [1-4]");
		leftPanel.add(yearLabel,gbc5);
		
		//////////////////////////
		
		GridBagConstraints gbc6 = new GridBagConstraints();
		
		gbc6.gridx = 1;
		gbc6.gridy = 3;
		
		gbc6.gridwidth = 1;
		gbc6.gridheight = 1;
		
		gbc6.anchor = GridBagConstraints.CENTER;
		
		JTextField yearTextField = new JTextField();
		yearTextField.setPreferredSize(new Dimension(150,20));
		leftPanel.add(yearTextField,gbc6);
		
		//////////////////////////
		
		GridBagConstraints gbc7 = new GridBagConstraints();
		
		gbc7.gridx = 0;
		gbc7.gridy = 4;
		
		gbc7.gridwidth = 1;
		gbc7.gridheight = 1;
		
		gbc7.anchor = GridBagConstraints.CENTER;
		
		JLabel professorLabel = new JLabel("Professor");
		leftPanel.add(professorLabel,gbc7);
		
		//////////////////////////
		
		GridBagConstraints gbc8 = new GridBagConstraints();
		
		gbc8.gridx = 1;
		gbc8.gridy = 4;
		
		gbc8.gridwidth = 1;
		gbc8.gridheight = 1;
		
		gbc8.anchor = GridBagConstraints.CENTER;
		
		String[] choises = new String[MyBase.getInstance().getProfessors().size() + 1];
		int i = 1;
		//Hocu da smestim profesore u combo box
		choises[0] = "Nema Profesora";
		for(Professor pr : MyBase.getInstance().getProfessors()) {
			choises[i] = pr.getIdNumber() + " | " + pr.getLastName() + " " + pr.getFirstName();
			i++;
		}
		
		JComboBox<String> professorComboBox = new JComboBox<String>(choises);
		professorComboBox.setSize(new Dimension(100,20));
		professorComboBox.setSelectedIndex(-1);
		leftPanel.add(professorComboBox,gbc8);
		
		//////////////////////////
		
		JButton submitBtn = new JButton("Submit");
		submitBtn.setPreferredSize(new Dimension(100,20));
		submitBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean c = true, n = true, sb = true, yos = true, p = true;
				codeLabel.setForeground(Color.BLACK);
				nameLabel.setForeground(Color.BLACK);
				yearLabel.setForeground(Color.BLACK);
				semesterLabel.setForeground(Color.BLACK);
				professorLabel.setForeground(Color.BLACK);
				
				try {
					
					if (codeTextField.getText().equals("")) c = false;
					if (nameTextField.getText().equals("")) n = false;
					if (yearTextField.getText().equals("")) sb = false;
					if (semesterTextField.getText().equals("")) yos = false;
					if (professorComboBox.getSelectedItem() == null) p = false;
					
					//baca error ako nista ne unesemo zbog parseInt
					int q =	Integer.parseInt(yearTextField.getText());
					if (q < 1 || q > 4) yos = false;
					int w = Integer.parseInt(semesterTextField.getText());
					if ( q == 1 ) {
						if (!(w == 1 || w == 2))
							sb = false;
					}	
					else if ( q == 2 ) {
						if (!(w == 3 || w == 4))
							sb = false;
					}
					else if ( q == 3 ) {
						if (!(w == 5 || w == 6))
							sb = false;
					}
					else if ( q == 4 )  {
						if (!(w == 7 || w == 8))
							sb = false;
					}
					
					if (w < 1 || w > 8)
						sb = false;
					
					
					
					ArrayList<Student> studentsOnSubject = new ArrayList<Student>();
					
					
					
					Professor pr;
					if(professorComboBox.getSelectedItem().toString().equals("Nema profesora!")) {
						pr = null;
					} else {
						String[] prof = professorComboBox.getSelectedItem().toString().split(" | ");
						pr = MyBase.getInstance().getProfessorById(prof[0]);
					}
					
					Subject s = new Subject(codeTextField.getText(),
											nameTextField.getText(),
											Integer.parseInt(semesterTextField.getText()),
											Integer.parseInt(yearTextField.getText()),
											pr, 
											studentsOnSubject);
					
					studentsOnSubject = manageCheckedCheckboxes(rightPanel, s);
					
					
					s.setStudents(studentsOnSubject);
					if(pr != null)
						pr.addSubjectToSubjects(s);
					
					//Provera da li je predmet vec u listi
					boolean greska = false;
					List<Subject> ls = MyBase.getInstance().getSubjects();
					for(Subject i : ls) {
						if (i.equals(s)) {	
							greska = true;
							JOptionPane.showMessageDialog(leftPanel, "YOU CAN'T ADD SAME SUBJECT TWICE\nYOU ADDED SAME CODE NUMBER AGAIN!", "ERROR", JOptionPane.ERROR_MESSAGE);
							break;
						}
					}
				//	boolean c = true, n = true, sb = true, yos = true, p = true;
					if (!(c && n && sb && yos && p)) {
						greska = true;
						throw new Exception();
					}
					
					if (!greska) {
						MyBase.getInstance().addSubject(s);
						setVisible(false);
					}
					//Potrebno dodati opadajuci meni za listu studenata na predmetu, takodje za profesora dugme!
					
				}catch(Exception ex) {
					if (!c) codeLabel.setForeground(Color.RED);
					if (!n) nameLabel.setForeground(Color.RED);
					if (!yos) yearLabel.setForeground(Color.RED);
					if (!sb) semesterLabel.setForeground(Color.RED);
					if (!p) professorLabel.setForeground(Color.RED);
					
					JOptionPane.showMessageDialog(leftPanel, "Ubacili ste neodgovarajuce podatke!", "ERROR IN ADDDING NEW SUBJECT", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		
		//Na donji panel dodajem dugmad submit i cancel
		downPanel.add(submitBtn,gbc7);
		
		//////////////////////////
		
		JButton cancelBtn = new JButton("Cancel");
		cancelBtn.setPreferredSize(new Dimension(100,20));
		cancelBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		
		downPanel.add(cancelBtn);
		
		//////////////////////////
		
		//Na desni panel dodajemo listu studenata koji slusaju predmet
		int br = 0;
		for(JCheckBox k : listaCekBoxova) {
			addStudentToList(rightPanel,k,br);
			br++;
		}
		
		JScrollPane rightPane = new JScrollPane(rightPanel);
		rightPane.setPreferredSize(new Dimension(250,250));
		add(rightPane,BorderLayout.CENTER);
		
		
	}
	
	/**
	 * Dodavanje studenata na desni panel
	 * @param panel
	 * @param box
	 * @param rbr
	 */
	private void addStudentToList(JPanel panel, JCheckBox box, int rbr) {
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx = 0;
		gbc.gridy = rbr;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.anchor = GridBagConstraints.WEST;
		
		panel.add(box, gbc);
		
	}
	
	//This method returns a list of selected checkboxes(Students that should listen the subject)
	/**
	 * Citanje selektovanih cek boksova studenata
	 * @param c
	 * @param dodavaniPredmet
	 * @return
	 */
	public static ArrayList<Student> manageCheckedCheckboxes(final Container c, Subject dodavaniPredmet) {
	    Component[] comps = c.getComponents();
	    ArrayList<Student> checkedStudents = new ArrayList<Student>();

	    for (Component comp : comps) {

	        if (comp instanceof JCheckBox) {
	            JCheckBox box = (JCheckBox) comp;
	            if (box.isSelected()) {
	                String text = box.getText();
	                String[] temp = text.split(" \\| ");
	                Student st = MyBase.getInstance().getStudentByIndex(temp[0]);//uzimam studenta i ubacujem u listu
	                System.out.println(st.toString());
	                checkedStudents.add(st);
	                st.dodajPredmetUSpisak(dodavaniPredmet);
	            }
	        }
	    }

	    return checkedStudents;

	}
	
	public void uncheckCheckBoxes() {
		for (JCheckBox box : listaCekBoxova) {
			box.setSelected(false);
		}
	}
}
