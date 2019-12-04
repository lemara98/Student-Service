package model;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AddFrameSubject extends JFrame {

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
		setSize(new Dimension(width/4, height/4));
		this.setTitle("Add new element");
		setVisible(true);
		
		this.setLocationRelativeTo(null);
		setBackground(java.awt.Color.LIGHT_GRAY);
		
		GridBagLayout gbl = new GridBagLayout();
		setLayout(gbl);
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		
		gbc.anchor = GridBagConstraints.CENTER;
		
		JLabel nameLabel = new JLabel("Name");
		add(nameLabel,gbc);
		
		GridBagConstraints gbc2 = new GridBagConstraints();
		
		gbc2.gridx = 1;
		gbc2.gridy = 0;
		
		gbc2.gridwidth = 1;
		gbc2.gridheight = 1;
		
		gbc2.anchor = GridBagConstraints.CENTER;
		
		JTextField nameTextField = new JTextField();
		nameTextField.setPreferredSize(new Dimension(100,20));
		add(nameTextField,gbc2);
		
		GridBagConstraints gbc3 = new GridBagConstraints();
		
		gbc3.gridx = 0;
		gbc3.gridy = 1;
		
		gbc3.gridwidth = 1;
		gbc3.gridheight = 1;
		
		gbc3.anchor = GridBagConstraints.CENTER;
		
		JLabel semesterLabel = new JLabel("Semester");
		add(semesterLabel,gbc3);
		
		GridBagConstraints gbc4 = new GridBagConstraints();
		
		gbc4.gridx = 1;
		gbc4.gridy = 1;
		
		gbc4.gridwidth = 1;
		gbc4.gridheight = 1;
		
		gbc4.anchor = GridBagConstraints.CENTER;
		
		JTextField semesterTextField = new JTextField();
		semesterTextField.setPreferredSize(new Dimension(100,20));
		add(semesterTextField,gbc4);
		
		GridBagConstraints gbc5 = new GridBagConstraints();
		
		gbc5.gridx = 0;
		gbc5.gridy = 2;
		
		gbc5.gridwidth = 1;
		gbc5.gridheight = 1;
		
		gbc5.anchor = GridBagConstraints.CENTER;
		
		JLabel yearLabel = new JLabel("Year of study");
		add(yearLabel,gbc5);
		
		GridBagConstraints gbc6 = new GridBagConstraints();
		
		gbc6.gridx = 1;
		gbc6.gridy = 2;
		
		gbc6.gridwidth = 1;
		gbc6.gridheight = 1;
		
		gbc6.anchor = GridBagConstraints.CENTER;
		
		JTextField yearTextField = new JTextField();
		yearTextField.setPreferredSize(new Dimension(100,20));
		add(yearTextField,gbc6);
		
		GridBagConstraints gbc7 = new GridBagConstraints();
		
		gbc7.gridx = 0;
		gbc7.gridy = 3;
		
		gbc7.gridwidth = 2;
		gbc7.gridheight = 2;
		
		gbc7.anchor = GridBagConstraints.CENTER;

		JButton createBtn = new JButton("Create Subject");
		createBtn.setPreferredSize(new Dimension(120,20));
		createBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = nameTextField.getText();
				//baca error ako nista ne unesemo zbog parseInt
				int semester = Integer.parseInt(semesterTextField.getText());
				int year = Integer.parseInt(yearTextField.getText());
				Subject s = new Subject(name, semester, year, null, null);
				//Potrebno dodati opadajuci meni za listu studenata na predmetu, takodje za profesora dugme!
				MyBase.getInstance().addSubject(s);
				
			}
		});
		
		add(createBtn,gbc7);
	}
	
}
