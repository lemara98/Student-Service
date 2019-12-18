package model;

import java.awt.BorderLayout;
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

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class AddFrameSubject extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5176543725768611200L;
	
	private static AddFrameSubject instance = null;
	
	public static AddFrameSubject getInstance() {
		if(instance == null)
			instance = new AddFrameSubject();
		
		return instance;
	}
	
	private AddFrameSubject() {
		super();
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int width = screenSize.width;
		int height = screenSize.height;
		setSize(new Dimension(width/3+50, height/3));
		this.setTitle("Add new element");
		setVisible(true);
		setModal(true);
		
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
		JPanel topPanel = new JPanel();
		topPanel.setSize(new Dimension(100,50));	//top panel mi sluzi da zauzme mesto zvog borderLayouta
		
		this.add(leftPanel,BorderLayout.WEST);	//sa leve strane ce biti polja za unos teksta
		this.add(rightPanel,BorderLayout.EAST); //desno ce biti lista studenata koji slusaju predmet
		this.add(downPanel, BorderLayout.SOUTH);	//dole ce biti submit i cancel button
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		
		gbc.anchor = GridBagConstraints.CENTER;
		
		JLabel nameLabel = new JLabel("Name");
		leftPanel.add(nameLabel,gbc);
		
		GridBagConstraints gbc2 = new GridBagConstraints();
		
		gbc2.gridx = 1;
		gbc2.gridy = 0;
		
		gbc2.gridwidth = 1;
		gbc2.gridheight = 1;
		
		gbc2.anchor = GridBagConstraints.CENTER;
		
		JTextField nameTextField = new JTextField();
		nameTextField.setPreferredSize(new Dimension(100,20));
		leftPanel.add(nameTextField,gbc2);
		
		GridBagConstraints gbc3 = new GridBagConstraints();
		
		gbc3.gridx = 0;
		gbc3.gridy = 1;
		
		gbc3.gridwidth = 1;
		gbc3.gridheight = 1;
		
		gbc3.anchor = GridBagConstraints.CENTER;
		
		JLabel semesterLabel = new JLabel("Semester");
		leftPanel.add(semesterLabel,gbc3);
		
		GridBagConstraints gbc4 = new GridBagConstraints();
		
		gbc4.gridx = 1;
		gbc4.gridy = 1;
		
		gbc4.gridwidth = 1;
		gbc4.gridheight = 1;
		
		gbc4.anchor = GridBagConstraints.CENTER;
		
		JTextField semesterTextField = new JTextField();
		semesterTextField.setPreferredSize(new Dimension(100,20));
		leftPanel.add(semesterTextField,gbc4);
		
		GridBagConstraints gbc5 = new GridBagConstraints();
		
		gbc5.gridx = 0;
		gbc5.gridy = 2;
		
		gbc5.gridwidth = 1;
		gbc5.gridheight = 1;
		
		gbc5.anchor = GridBagConstraints.CENTER;
		
		JLabel yearLabel = new JLabel("Year of study");
		leftPanel.add(yearLabel,gbc5);
		
		GridBagConstraints gbc6 = new GridBagConstraints();
		
		gbc6.gridx = 1;
		gbc6.gridy = 2;
		
		gbc6.gridwidth = 1;
		gbc6.gridheight = 1;
		
		gbc6.anchor = GridBagConstraints.CENTER;
		
		JTextField yearTextField = new JTextField();
		yearTextField.setPreferredSize(new Dimension(100,20));
		leftPanel.add(yearTextField,gbc6);
		
		GridBagConstraints gbc7 = new GridBagConstraints();
		
		gbc7.gridx = 0;
		gbc7.gridy = 3;
		
		gbc7.gridwidth = 1;
		gbc7.gridheight = 1;
		
		gbc7.anchor = GridBagConstraints.CENTER;
		
		JLabel professorLabel = new JLabel("Professor");
		leftPanel.add(professorLabel,gbc7);
		
		GridBagConstraints gbc8 = new GridBagConstraints();
		
		gbc8.gridx = 1;
		gbc8.gridy = 3;
		
		gbc8.gridwidth = 1;
		gbc8.gridheight = 1;
		
		gbc8.anchor = GridBagConstraints.CENTER;
		
		String[] choises = new String[MyBase.getInstance().getProfessors().size()];
		int i = 0;
		//Hocu da smestim profesore u combo box
		for(Professor pr : MyBase.getInstance().getProfessors()) {
			choises[i] = pr.getLastName() + " " + pr.getFirstName().substring(0,1) + ". " + pr.getIdNumber();
			i++;
		}
		
		JComboBox<String> professorComboBox = new JComboBox<String>(choises);
		professorComboBox.setSize(new Dimension(100,20));
		leftPanel.add(professorComboBox,gbc8);
		
		JButton submitBtn = new JButton("Submit");
		submitBtn.setPreferredSize(new Dimension(100,20));
		submitBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					//baca error ako nista ne unesemo zbog parseInt
					ArrayList<Student> studentsOnSubject = new ArrayList<Student>();
					
					studentsOnSubject = manageCheckedCheckboxes(rightPanel);
					
					String[] prof = professorComboBox.getSelectedItem().toString().split(" ");
					Professor pr = MyBase.getInstance().getProfessorById(Integer.parseInt(prof[2]));
					
					Subject s = new Subject(nameTextField.getText(),
											Integer.parseInt(semesterTextField.getText()),
											Integer.parseInt(yearTextField.getText()),
											pr, studentsOnSubject);
					
					//Provera da li je predmet vec u listi
					boolean greska = false;
					List<Subject> ls = MyBase.getInstance().getSubjects();
					for(Subject i : ls) {
						if (i.equals(s)) {	
							greska = true;
							JOptionPane.showMessageDialog(leftPanel, "YOU CAN'T ADD SAME STUDENT TWICE\nYOU ADDED SAME INDEX NUMBER AGAIN!", "ERROR", JOptionPane.ERROR_MESSAGE);
							setVisible(true);
							break;
						}
					}
					if (!greska) {
						MyBase.getInstance().addSubject(s);
						setVisible(false);
					}
					//Potrebno dodati opadajuci meni za listu studenata na predmetu, takodje za profesora dugme!
					
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(leftPanel, "Ubacili ste neodgovarajuce podatke!", "ERROR IN ADDDING NEW STUDENT", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		
		//Na donji panel dodajem dugmad submit i cancel
		downPanel.add(submitBtn,gbc7);
		
		JButton cancelBtn = new JButton("Cancel");
		cancelBtn.setPreferredSize(new Dimension(100,20));
		cancelBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				nameTextField.setText("");
				yearTextField.setText("");
				semesterTextField.setText("");
				setVisible(false);
				
			}
		});
		
		downPanel.add(cancelBtn);
		
		
		
		//Na desni panel dodajemo listu studenata koji slusaju predmet
		int br = 0;
		for(Student st : MyBase.getInstance().getStudents()) {
			addStudentToList(rightPanel,st,br);
			br++;
		}
		
		JScrollPane rightPane = new JScrollPane(rightPanel);
		rightPane.setPreferredSize(new Dimension(250,250));
		add(rightPane,BorderLayout.EAST);
		
	}
	
	private void addStudentToList(JPanel panel, Student student, int rbr) {
		JCheckBox cekBox = new JCheckBox(student.getIme()+" "+student.getPrezime()+" "+student.getBrojIndeksa());
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx = 0;
		gbc.gridy = rbr;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.anchor = GridBagConstraints.WEST;
		
		panel.add(cekBox, gbc);
	}
	
	//This method returns a list of selected checkboxes(Students that should listen the subject)
	public static ArrayList<Student> manageCheckedCheckboxes(final Container c) {
	    Component[] comps = c.getComponents();
	    ArrayList<Student> checkedStudents = new ArrayList<Student>();

	    for (Component comp : comps) {

	        if (comp instanceof JCheckBox) {
	            JCheckBox box = (JCheckBox) comp;
	            if (box.isSelected()) {
	                String text = box.getText();
	                String[] temp = text.split(" ");
	                Student st = MyBase.getInstance().getStudentIndex(temp[2]);//uzimam studenta i ubacujem u listu
	                checkedStudents.add(st);
	            }
	        }
	    }

	    return checkedStudents;

	}
}
