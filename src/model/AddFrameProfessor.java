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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class AddFrameProfessor extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8383577535696823396L;
	
	
	public AddFrameProfessor() {
		super();
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int width = screenSize.width;
		int height = screenSize.height;
		setSize(new Dimension(width/3+100, height/2));
		this.setTitle("Dodaj novog profesora");
		this.setIconImage(new ImageIcon("slike\\ikonice\\1800_Icon_Pack_20x20\\PNG1_black_icons\\inbox_plus [#1554].png").getImage());
		
		setModal(true);
		
		this.setLocationRelativeTo(null);
		setBackground(java.awt.Color.LIGHT_GRAY);
		
		GridBagLayout gbl = new GridBagLayout();
		setLayout(new BorderLayout());	//glavni prozor mi je borderlayout
		
		JPanel leftPanel = new JPanel();
		leftPanel.setLayout(gbl);
		JPanel rightPanel = new JPanel();
		rightPanel.setLayout(gbl);
	
		JPanel downPanel = new JPanel();
		downPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		this.add(leftPanel,BorderLayout.WEST);	//sa leve strane ce biti polja za unos teksta
		this.add(downPanel, BorderLayout.SOUTH);	//dole ce biti submit i cancel button
		this.add(rightPanel,BorderLayout.CENTER); //desno ce biti lista studenata koji slusaju predmet
		
		GridBagConstraints gbc0 = new GridBagConstraints();
				
		gbc0.gridx = 0;
		gbc0.gridy = 0;
		
		gbc0.gridwidth = 1;
		gbc0.gridheight = 1;
		
		gbc0.anchor = GridBagConstraints.CENTER;
		
		JLabel IDNumberLabel = new JLabel("ID broj*");
		leftPanel.add(IDNumberLabel,gbc0);
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		
		gbc.anchor = GridBagConstraints.CENTER;
		
		JTextField IDNumberTextField = new JTextField();
		IDNumberTextField.setPreferredSize(new Dimension(150,20));
		leftPanel.add(IDNumberTextField,gbc);
		
		GridBagConstraints gbc1 = new GridBagConstraints();
		
		gbc1.gridx = 0;
		gbc1.gridy = 1;
		
		gbc1.gridwidth = 1;
		gbc1.gridheight = 1;
		
		gbc1.anchor = GridBagConstraints.CENTER;
		
		JLabel firstNameLabel = new JLabel("Ime*");
		leftPanel.add(firstNameLabel,gbc1);
		
		GridBagConstraints gbc2 = new GridBagConstraints();
		
		gbc2.gridx = 1;
		gbc2.gridy = 1;
		
		gbc2.gridwidth = 1;
		gbc2.gridheight = 1;
		
		gbc2.anchor = GridBagConstraints.CENTER;
		
		JTextField firstnameTextField = new JTextField();
		firstnameTextField.setPreferredSize(new Dimension(150,20));
		leftPanel.add(firstnameTextField,gbc2);
		
		GridBagConstraints gbc3 = new GridBagConstraints();
		
		gbc3.gridx = 0;
		gbc3.gridy = 2;
		
		gbc3.gridwidth = 1;
		gbc3.gridheight = 1;
		
		gbc3.anchor = GridBagConstraints.CENTER;
		
		JLabel lastNameLabel = new JLabel("Prezime*");
		leftPanel.add(lastNameLabel,gbc3);
		
		GridBagConstraints gbc4 = new GridBagConstraints();
		
		gbc4.gridx = 1;
		gbc4.gridy = 2;
		
		gbc4.gridwidth = 1;
		gbc4.gridheight = 1;
		
		gbc4.anchor = GridBagConstraints.CENTER;
		
		JTextField lastNameTextField = new JTextField();
		lastNameTextField.setPreferredSize(new Dimension(150,20));
		leftPanel.add(lastNameTextField,gbc4);
		
		GridBagConstraints gbc5 = new GridBagConstraints();
		
		gbc5.gridx = 0;
		gbc5.gridy = 3;
		
		gbc5.gridwidth = 1;
		gbc5.gridheight = 1;
		
		gbc5.anchor = GridBagConstraints.CENTER;
		
		JLabel yearLabel = new JLabel("Datum rodjenja* [dd.MM.yyyy.]");
		leftPanel.add(yearLabel,gbc5);
		
		GridBagConstraints gbc6 = new GridBagConstraints();
		
		gbc6.gridx = 1;
		gbc6.gridy = 3;
		
		gbc6.gridwidth = 1;
		gbc6.gridheight = 1;
		
		gbc6.anchor = GridBagConstraints.CENTER;
		
		JTextField yearTextField = new JTextField();
		yearTextField.setPreferredSize(new Dimension(150,20));
		leftPanel.add(yearTextField,gbc6);
		
		GridBagConstraints gbc7 = new GridBagConstraints();
		
		gbc7.gridx = 0;
		gbc7.gridy = 4;
		
		gbc7.gridwidth = 1;
		gbc7.gridheight = 1;
		
		gbc7.anchor = GridBagConstraints.CENTER;
		
		JLabel livingAdressLabel = new JLabel("Adresa stanovanja*");
		leftPanel.add(livingAdressLabel,gbc7);
		
		GridBagConstraints gbc8 = new GridBagConstraints();
		
		gbc8.gridx = 1;
		gbc8.gridy = 4;
		
		gbc8.gridwidth = 1;
		gbc8.gridheight = 1;
		
		gbc8.anchor = GridBagConstraints.CENTER;
		
		JTextField livingAdressTextField = new JTextField();
		livingAdressTextField.setPreferredSize(new Dimension(150,20));
		leftPanel.add(livingAdressTextField,gbc8);
		
		GridBagConstraints gbc9 = new GridBagConstraints();
		
		gbc9.gridx = 0;
		gbc9.gridy = 5;
		
		gbc9.gridwidth = 1;
		gbc9.gridheight = 1;
		
		gbc9.anchor = GridBagConstraints.CENTER;
		
		JLabel contactNumberLabel = new JLabel("Kontakt telefon*");
		leftPanel.add(contactNumberLabel,gbc9);
		
		GridBagConstraints gbc10 = new GridBagConstraints();
		
		gbc10.gridx = 1;
		gbc10.gridy = 5;
		
		gbc10.gridwidth = 1;
		gbc10.gridheight = 1;
		
		gbc10.anchor = GridBagConstraints.CENTER;
		
		JTextField contactNumberTextField = new JTextField();
		contactNumberTextField.setPreferredSize(new Dimension(150,20));
		leftPanel.add(contactNumberTextField,gbc10);
		
		GridBagConstraints gbc11 = new GridBagConstraints();
		
		gbc11.gridx = 0;
		gbc11.gridy = 6;
		
		gbc11.gridwidth = 1;
		gbc11.gridheight = 1;
		
		gbc11.anchor = GridBagConstraints.CENTER;
		
		JLabel emailLabel = new JLabel("Email adresa*");
		leftPanel.add(emailLabel,gbc11);
		
		GridBagConstraints gbc12 = new GridBagConstraints();
		
		gbc12.gridx = 1;
		gbc12.gridy = 6;
		
		gbc12.gridwidth = 1;
		gbc12.gridheight = 1;
		
		gbc12.anchor = GridBagConstraints.CENTER;
		
		JTextField emailTextField = new JTextField();
		emailTextField.setPreferredSize(new Dimension(150,20));
		leftPanel.add(emailTextField,gbc12);
		
		GridBagConstraints gbc13 = new GridBagConstraints();
		
		gbc13.gridx = 0;
		gbc13.gridy = 7;
		
		gbc13.gridwidth = 1;
		gbc13.gridheight = 1;
		
		gbc13.anchor = GridBagConstraints.CENTER;
		
		JLabel workAdressLabel = new JLabel("Adresa radnog mesta*");
		leftPanel.add(workAdressLabel,gbc13);
		
		GridBagConstraints gbc14 = new GridBagConstraints();
		
		gbc14.gridx = 1;
		gbc14.gridy = 7;
		
		gbc14.gridwidth = 1;
		gbc14.gridheight = 1;
		
		gbc14.anchor = GridBagConstraints.CENTER;
		
		JTextField workAdressTextField = new JTextField();
		workAdressTextField.setPreferredSize(new Dimension(150,20));
		leftPanel.add(workAdressTextField,gbc14);
		
		GridBagConstraints gbc15 = new GridBagConstraints();
		
		gbc15.gridx = 0;
		gbc15.gridy = 8;
		
		gbc15.gridwidth = 1;
		gbc15.gridheight = 1;
		
		gbc15.anchor = GridBagConstraints.CENTER;
		
		JLabel titleLabel = new JLabel("Zvanje*");
		leftPanel.add(titleLabel,gbc15);
		
		GridBagConstraints gbc16 = new GridBagConstraints();
		
		gbc16.gridx = 1;
		gbc16.gridy = 8;
		
		gbc16.gridwidth = 1;
		gbc16.gridheight = 1;
		
		gbc16.anchor = GridBagConstraints.CENTER;
		
		JTextField titleTextField = new JTextField();
		titleTextField.setPreferredSize(new Dimension(150,20));
		leftPanel.add(titleTextField,gbc16);
		
		GridBagConstraints gbc17 = new GridBagConstraints();
		
		gbc17.gridx = 0;
		gbc17.gridy = 9;
		
		gbc17.gridwidth = 1;
		gbc17.gridheight = 1;
		
		gbc17.anchor = GridBagConstraints.CENTER;
		
		JLabel rankLabel = new JLabel("Rang*");
		leftPanel.add(rankLabel,gbc17);
		
		GridBagConstraints gbc18 = new GridBagConstraints();
		
		gbc18.gridx = 1;
		gbc18.gridy = 9;
		
		gbc18.gridwidth = 1;
		gbc18.gridheight = 1;
		
		gbc18.anchor = GridBagConstraints.CENTER;
		
		JTextField rankTextField = new JTextField();
		rankTextField.setPreferredSize(new Dimension(150,20));
		leftPanel.add(rankTextField,gbc18);
		
		//Na desni panel dodajemo listu studenata koji slusaju predmet
		int br = 0;
		for(Subject sub : MyBase.getInstance().getSubjects()) {
			addSubjectToList(rightPanel,sub,br);
			br++;
		}
		
		JScrollPane rightPane = new JScrollPane(rightPanel);
		rightPane.setPreferredSize(new Dimension(250,250));
		add(rightPane,BorderLayout.CENTER);

	
		JButton submitBtn = new JButton("Submit");
		submitBtn.setPreferredSize(new Dimension(100,20));
		submitBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					//baca error ako nista ne unesemo zbog parseInt
					if (IDNumberTextField.getText().equals("") ||
							firstnameTextField.getText().equals("")||
							lastNameTextField.getText().equals("") ||
							yearTextField.getText().equals("") ||
							livingAdressTextField.getText().equals("") ||
							contactNumberTextField.getText().equals("") ||
							emailTextField.getText().equals("") ||
							workAdressTextField.getText().equals("") ||
							rankTextField.getText().equals(""))
							throw new Exception();
					
					String[] datum = yearTextField.getText().split("\\.");
					if (datum.length != 3) throw new Exception();
					
					List<Subject> checkedSubjects = new ArrayList<Subject>();
					
					Professor p = new Professor(IDNumberTextField.getText(),
												firstnameTextField.getText(),
											    lastNameTextField.getText(),
											    yearTextField.getText(),
											    livingAdressTextField.getText(),
											    contactNumberTextField.getText(),
											    emailTextField.getText(),
											    workAdressTextField.getText(),
											    titleTextField.getText(),
											    rankTextField.getText(),
											    checkedSubjects);
					
					checkedSubjects = manageCheckedCheckboxes(rightPanel, p);
					
					p.setSubjects(checkedSubjects);
					
	
					//Provera da li je predmet vec u listi
					boolean greska = false;
					List<Professor> lp = MyBase.getInstance().getProfessors();
					for(Professor i : lp) {
						if (i.equals(p)) {	
							greska = true;
							JOptionPane.showMessageDialog(leftPanel, "YOU CAN'T ADD SAME PROFFESOR TWICE\nYOU ADDED SAME ID NUMBER AGAIN!", "ERROR", JOptionPane.ERROR_MESSAGE);
							setVisible(true);
							break;
						}
					}
					if (!greska) {
						MyBase.getInstance().addProfessor(p);
						setVisible(false);
					}
					//Potrebno dodati opadajuci meni za listu studenata na predmetu, takodje za profesora dugme!
					
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(leftPanel, "Ubacili ste ne odgovarajuce podatke!", "ERROR IN ADDDING NEW PROFESSOR", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		
		downPanel.add(submitBtn);	// dodajemo submit button
		
		JButton cancelBtn = new JButton("Cancel");
		cancelBtn.setPreferredSize(new Dimension(100,20));
		cancelBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		
		downPanel.add(cancelBtn);
		
		
	}
	
	private void addSubjectToList(JPanel panel, Subject subject, int rbr) {
		JCheckBox cekBox = new JCheckBox(subject.getCode() + " | " + subject.getName());
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx = 0;
		gbc.gridy = rbr;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.anchor = GridBagConstraints.WEST;
		
		panel.add(cekBox, gbc);
	}
	
	public static List<Subject> manageCheckedCheckboxes(final Container c, Professor dodavaniProfa) {
	    Component[] comps = c.getComponents();
	    List<Subject> checkedSubjects = new ArrayList<Subject>();

	    for (Component comp : comps) {
	        if (comp instanceof JCheckBox) {
	            JCheckBox box = (JCheckBox) comp;
	            if (box.isSelected()) {
	                String text = box.getText();
	                String[] temp = text.split(" | ");
	                Subject sub = MyBase.getInstance().getSubject(temp[0]);//uzimam studenta i ubacujem u listu
	                checkedSubjects.add(sub);
	                Professor p = sub.getProfessor();
	                
	                if (p != null) {
	                	p.deleteSubjectFromSubjects(sub);
	                }
	                sub.setProfessor(dodavaniProfa);
	                
	            }
	        }
	    }

	    return checkedSubjects;

	}

}
