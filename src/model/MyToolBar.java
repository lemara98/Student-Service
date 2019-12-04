package model;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.Icon;
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
	
	public JButton getBtnAddProfessor() {
		return btnAddProfessor;
	}
	
	public MyToolBar() {
		super(SwingConstants.HORIZONTAL);
		
		setBackground(Color.DARK_GRAY);
		//setPreferredSize(new Dimension(tbWidth,tbHeight));

		// Dodao sam svoje ikonice(20x20) posto tvoje nisu stavljene u repozitorijum i podesio velicinu dugmeta na 30x30
		
		Icon icon = new ImageIcon("slike\\ikonice\\1800_Icon_Pack_20x20\\PNG1_black_icons\\profile_plus [#1357].png");
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
					MyController.getInstance().addStudent();
				}
			}
		});
		
		icon = new ImageIcon("slike\\ikonice\\1800_Icon_Pack_20x20\\PNG1_black_icons\\edit_cover [#1481].png");
		JButton btnEdit = new JButton(icon);
		btnEdit.setPreferredSize(new Dimension(30,30));
		btnEdit.setToolTipText("Edit");
		
		icon = new ImageIcon("slike\\ikonice\\1800_Icon_Pack_20x20\\PNG1_black_icons\\profile_close [#1358].png");
		JButton btnDelete = new JButton(icon);
		btnDelete.setPreferredSize(new Dimension(30,30));
		btnDelete.setToolTipText("Delete");
		btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int dialogButton = JOptionPane.showConfirmDialog(btnDelete, "Are you sure ?","Delete",JOptionPane.YES_NO_OPTION);
				if(dialogButton == JOptionPane.YES_OPTION) {
	//				System.out.println("Professor deleted");
	//				System.out.println(MyMainFrame.getInstance().getSelectedTabbedPane());
					if(MyMainFrame.getInstance().getSelectedTabbedPane() == 0) {
						//index of selected row --> this gives us a professor
						int idx = MyMainFrame.getInstance().getProfessorJTable().getSelectedRow();
						if(idx != -1) {
							MyController.getInstance().deleteProfessor(idx);
						}		
					}
					else if (MyMainFrame.getInstance().getSelectedTabbedPane() == 1) {
						int idx = MyMainFrame.getInstance().getSubjectJTable().getSelectedRow();
						if(idx != -1) {
							MyController.getInstance().deleteSubject(idx);
						}
					}
					else {
						int idx = MyMainFrame.getInstance().getStudentJTable().getSelectedRow();
						if(idx != -1) {
							MyController.getInstance().deleteStudent(idx);
						}	
					}
				}else {
					System.out.println("Professor saved");
				}
			}
		});
		
		icon = new ImageIcon("slike\\ikonice\\1800_Icon_Pack_20x20\\PNG1_black_icons\\search_left [#1504].png");
		JButton btnSearch= new JButton(icon);
		btnSearch.setPreferredSize(new Dimension(30,30));
		btnSearch.setToolTipText("Search");
		
		icon = new ImageIcon("slike\\ikonice\\1800_Icon_Pack_20x20\\PNG1_black_icons\\profile_image_favorite_round [#1331].png");
		btnAddProfessor = new JButton(icon);
		btnAddProfessor.setPreferredSize(new Dimension(30,30));
		btnAddProfessor.setToolTipText("Add Professor");
		
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
		leviDeo.add(btnAddProfessor);
		desniDeo.add(textField);
		desniDeo.add(btnSearch);
		
		add(leviDeo, BorderLayout.WEST);
		add(desniDeo, BorderLayout.EAST);
		
		this.setFloatable(false);	// Mile promenio!
		
	}
	
}
