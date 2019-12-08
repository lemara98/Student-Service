package model;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import controller.MyController;

public class MyToolBar extends JToolBar{

	
	private static final long serialVersionUID = 2933819767532950350L;

	private JButton btnAddProfessor;
	private JButton btnAddStudent;
	
	public JButton getBtnAddProfessor() {
		return btnAddProfessor;
	}
	
	public JButton getBtnAddStudent() {
		return btnAddStudent;
	}
	
	public MyToolBar() {
		super(SwingConstants.HORIZONTAL);
		
		setBackground(Color.DARK_GRAY);
		//setPreferredSize(new Dimension(tbWidth,tbHeight));

		// Dodao sam svoje ikonice(20x20) posto tvoje nisu stavljene u repozitorijum i podesio velicinu dugmeta na 30x30
		// Unosi novi podatak bez obzira na karticu
		ImageIcon icon = new ImageIcon("slike\\ikonice\\1800_Icon_Pack_20x20\\PNG1_black_icons\\inbox_plus [#1554].png");
		JButton btnAdd = new JButton(icon);
		btnAdd.setPreferredSize(new Dimension(30,30));
		btnAdd.setToolTipText("Add");
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedPane = MyMainFrame.getInstance().getSelectedTabbedPane();
				if(selectedPane == 0) {
					//professors
				}else if(selectedPane == 1) {
					//subjects
					MyController.getInstance().addSubject();
				}
				else {
					//students
					MyController.getInstance().addStudent();
				}
			}
		});
		
		// Menja datu torku bez obzira na karticu
		icon = new ImageIcon("slike\\ikonice\\1800_Icon_Pack_20x20\\PNG2_black_icons\\pen [#1319].png");
		icon = resizeIcon(icon);
		JButton btnEdit = new JButton(icon);
		btnEdit.setPreferredSize(new Dimension(30,30));
		btnEdit.setToolTipText("Edit");
		btnEdit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int selectedPane = MyMainFrame.getInstance().getSelectedTabbedPane();
				if(selectedPane == 0) {
					//professors
				}else if(selectedPane == 1) {
					//subjects
					MyController.getInstance().addSubject();
				}
				else {
					//students
					int idx = MyMainFrame.getInstance().getStudentJTable().getSelectedRow();
					MyController.getInstance().editStudent(idx);
				}
				
			}
		});
		
		// Brise odabranu torku bez obzira na karticu
		icon = new ImageIcon("slike\\ikonice\\1800_Icon_Pack_20x20\\PNG2_black_icons\\delete [#1487].png");
		icon = resizeIcon(icon);
		JButton btnDelete = new JButton(icon);
		btnDelete.setPreferredSize(new Dimension(30,30));
		btnDelete.setToolTipText("Delete");
		btnDelete.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
					
							if(MyMainFrame.getInstance().getSelectedTabbedPane() == 0) {
								//index of selected row --> this gives us a professor
								{
									int idx = MyMainFrame.getInstance().getProfessorJTable().getSelectedRow();
									if(idx != -1) {
										
										int dialogButton = JOptionPane.showConfirmDialog(btnDelete, "Are you sure ?","Delete",JOptionPane.YES_NO_OPTION);
										if(dialogButton == JOptionPane.YES_OPTION)
											MyController.getInstance().deleteProfessor(idx);
										
									} else {
										JOptionPane.showMessageDialog(MyMainFrame.getInstance(), "You must fitrst select something to delete", "WARNING", JOptionPane.WARNING_MESSAGE);
									}
								}
							}
							else if (MyMainFrame.getInstance().getSelectedTabbedPane() == 1) {
								
									int idx = MyMainFrame.getInstance().getSubjectJTable().getSelectedRow();
									if(idx != -1) {
										int dialogButton = JOptionPane.showConfirmDialog(btnDelete, "Are you sure ?","Delete",JOptionPane.YES_NO_OPTION);
										if(dialogButton == JOptionPane.YES_OPTION) 
											MyController.getInstance().deleteSubject(idx);
									
									} else {
										JOptionPane.showMessageDialog(MyMainFrame.getInstance(), "You must first select something to delete", "WARNING", JOptionPane.WARNING_MESSAGE);
									}
							}
							else {
								
									int idx = MyMainFrame.getInstance().getStudentJTable().getSelectedRow();
									if(idx != -1) {
										int dialogButton = JOptionPane.showConfirmDialog(btnDelete, "Are you sure ?","Delete",JOptionPane.YES_NO_OPTION);
										if(dialogButton == JOptionPane.YES_OPTION) 
										MyController.getInstance().deleteStudent(idx);
										
									} else {
										JOptionPane.showMessageDialog(MyMainFrame.getInstance(), "You must first select something to delete", "WARNING", JOptionPane.WARNING_MESSAGE);
									}
							}
						
					}
				});
		
		// Button Search treba da highlightuje sve pronadjene na stringove u bazi
		icon = new ImageIcon("slike\\ikonice\\1800_Icon_Pack_20x20\\PNG1_black_icons\\search_left [#1504].png");
		JButton btnSearch= new JButton(icon);
		btnSearch.setPreferredSize(new Dimension(30,30));
		btnSearch.setToolTipText("Search");
		
		// Button addStudent treba da doda studente na predmet!
		icon = new ImageIcon("slike\\ikonice\\1800_Icon_Pack_20x20\\PNG1_black_icons\\profile_plus [#1357].png");
		btnAddStudent = new JButton(icon);
		btnAddStudent.setPreferredSize(new Dimension(30,30));
		btnAddStudent.setToolTipText("Add Student to subject");
		
		// Button proffesor treba da doda predmetnog profesora predmetu
		icon = new ImageIcon("slike\\ikonice\\1800_Icon_Pack_20x20\\PNG1_black_icons\\profile_image_favorite_round [#1331].png");
		btnAddProfessor = new JButton(icon);
		btnAddProfessor.setPreferredSize(new Dimension(30,30));
		btnAddProfessor.setToolTipText("Add Professor to subject");
		
		JTextField textField = new JTextField("Type here to search");
		Font f1 = textField.getFont();
		Font f = new Font("Verdana", Font.ITALIC, 12);
		textField.setFont(f);
		textField.setPreferredSize(new Dimension(150,20));
		textField.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				textField.setText("Type here to search");
				Font f = new Font("Verdana", Font.ITALIC, 12);
				textField.setFont(f);
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				textField.setCaretColor(Color.BLACK);
				textField.setText("");
				textField.setFont(f1);
			}
		});
		
	//	setLayout(new FlowLayout(FlowLayout.LEFT)); // Saletova verzija
		setLayout(new BorderLayout());  // Miletova verzija -- Dodao sam samo dugmice na panele da bi moglo lepse da izgleda.
										// Ako ti nije jasno zasto, pozovi me nocas u 3. Insomnia. Broj: 0631623155
										//:'D Kidajj Milee
		JPanel leviDeo = new JPanel(new FlowLayout(FlowLayout.LEFT));
		leviDeo.setBackground(Color.DARK_GRAY);
		
		JPanel desniDeo = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		desniDeo.setBackground(Color.DARK_GRAY);
		
		leviDeo.add(btnAdd);
		leviDeo.add(btnEdit);
		leviDeo.add(btnDelete);
		leviDeo.add(btnAddStudent);
		leviDeo.add(btnAddProfessor);
		desniDeo.add(textField);
		desniDeo.add(btnSearch);
		
		add(leviDeo, BorderLayout.WEST);
		add(desniDeo, BorderLayout.EAST);
		
		this.setFloatable(false);	// Mile promenio!
		
	}
	
	/**
	 * Function which resizes any picture to a 20x20 picture for Menu Bar
	 * @param ul -- Image
	 * @return  Same but resized image
	 */
	private ImageIcon resizeIcon(ImageIcon ul) {
		Image slika = ul.getImage();
		BufferedImage bi = new BufferedImage(20, 20, BufferedImage.TYPE_INT_ARGB);
		Graphics g = bi.getGraphics();
		g.drawImage(slika, 0, 0, 20, 20, null);
		return new ImageIcon(bi);
	}
	
	
}
