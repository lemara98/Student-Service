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
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.table.TableRowSorter;

import controller.MyController;
import view.AbstractTableModelProfessor;
import view.AbstractTableModelStudent;
import view.AbstractTableModelSubject;



public class MyToolBar extends JToolBar{

	
	private static final long serialVersionUID = 2933819767532950350L;

//	private JButton btnAddProfessor;
//	private JButton btnAddStudent;
	
//	public JButton getBtnAddProfessor() {
//		return btnAddProfessor;
//	}
//	
//	public JButton getBtnAddStudent() {
//		return btnAddStudent;
//	}
	
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
					MyController.getInstance().addProfessor();
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
					//professors // Ovde se mora dodati!
					int idx = MyMainFrame.getInstance().getProfessorJTable().getSelectedRow();
					
					if (idx != -1) {
						MyController.getInstance().editProfessor(idx);
					}
					else
						JOptionPane.showMessageDialog(MyMainFrame.getInstance(), "You must first select something to edit", "WARNING", JOptionPane.WARNING_MESSAGE);
				}else if(selectedPane == 1) {
					//subjects // Ovde se mora ispraviti!
					int idx = MyMainFrame.getInstance().getSubjectJTable().getSelectedRow();
					if (idx != -1) {
						MyController.getInstance().editSubject(idx);
					}
					else
						JOptionPane.showMessageDialog(MyMainFrame.getInstance(), "You must first select something to edit", "WARNING", JOptionPane.WARNING_MESSAGE);
				}
				else {
					//students
					int idx = MyMainFrame.getInstance().getStudentJTable().getSelectedRow();
					if (idx != -1)
						MyController.getInstance().editStudent(idx);
					else
						JOptionPane.showMessageDialog(MyMainFrame.getInstance(), "You must first select something to edit", "WARNING", JOptionPane.WARNING_MESSAGE);
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
										JOptionPane.showMessageDialog(MyMainFrame.getInstance(), "You must first select something to delete", "WARNING", JOptionPane.WARNING_MESSAGE);
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
		JTextField textField = new JTextField("Type here to search");
		
		icon = new ImageIcon("slike\\ikonice\\1800_Icon_Pack_20x20\\PNG1_black_icons\\search_left [#1504].png");
		JButton btnSearch= new JButton(icon);
		btnSearch.setPreferredSize(new Dimension(30,30));
		btnSearch.setToolTipText("Search");
		btnSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String searchString = textField.getText();
				if(MyMainFrame.getInstance().getSelectedTabbedPane() == 0) {
					List<RowFilter<AbstractTableModelProfessor, Integer>> list = new ArrayList<RowFilter<AbstractTableModelProfessor, Integer>>();
					@SuppressWarnings("unchecked")
					TableRowSorter<AbstractTableModelProfessor> sorter = (TableRowSorter<AbstractTableModelProfessor>)MyMainFrame.getInstance().getProfessorJTable().getRowSorter();
					if(!searchString.equals("Type here to search") && !searchString.isEmpty()) {
						searchString.trim();
						System.out.println(searchString);
						String[] str = searchString.split(";");
						List<String> values = new ArrayList<String>();
						for(String s : str) {
							String[] string = s.split(":");
							values.add(string[1]);
						}
						List<Integer> numberColumns = getProfessorColumnForSearch(searchString);
						System.out.println(str[0]);
						
						int brojac = 0;
						for(Integer i : numberColumns) {
							list.add(RowFilter.regexFilter(values.get(brojac++),i));
						}
						sorter.setRowFilter(RowFilter.andFilter(list));
						
					}else {
						sorter.setRowFilter(null);
					}
				}else if(MyMainFrame.getInstance().getSelectedTabbedPane() == 1) {
					List<RowFilter<AbstractTableModelSubject, Integer>> list = new ArrayList<RowFilter<AbstractTableModelSubject, Integer>>();
					@SuppressWarnings("unchecked")
					TableRowSorter<AbstractTableModelSubject> sorter = (TableRowSorter<AbstractTableModelSubject>)MyMainFrame.getInstance().getSubjectJTable().getRowSorter();
					if(!searchString.equals("Type here to search") && !searchString.isEmpty()) {
						searchString.trim();
						System.out.println(searchString);
						String[] str = searchString.split(";");
						List<String> values = new ArrayList<String>();
						for(String s : str) {
							String[] string = s.split(":");
							values.add(string[1]);
						}
						List<Integer> numberColumns = getSubjectColumnForSearch(searchString);
						System.out.println(str[0]);
						
						int brojac = 0;
						for(Integer i : numberColumns) {
							list.add(RowFilter.regexFilter(values.get(brojac++),i));
						}
						sorter.setRowFilter(RowFilter.andFilter(list));
						
					}else {
						sorter.setRowFilter(null);
					}
				}else {
					List<RowFilter<AbstractTableModelStudent, Integer>> list = new ArrayList<RowFilter<AbstractTableModelStudent, Integer>>();
					@SuppressWarnings("unchecked")
					TableRowSorter<AbstractTableModelStudent> sorter = (TableRowSorter<AbstractTableModelStudent>)MyMainFrame.getInstance().getStudentJTable().getRowSorter();
					if(!searchString.equals("Type here to search") && !searchString.isEmpty()) {
						searchString.trim();
						String[] str = searchString.split(";");
						List<String> values = new ArrayList<String>();
						for(String s : str) {
							String[] string = s.split(":");
							values.add(string[1]);
						}
						List<Integer> numberColumns = getStudentColumnForSearch(searchString);
						
						int brojac = 0;
						for(Integer i : numberColumns) {
							list.add(RowFilter.regexFilter(values.get(brojac++),i));
						}
						sorter.setRowFilter(RowFilter.andFilter(list));
						
					}else {
						sorter.setRowFilter(null);
					}
				}
				
				MyMainFrame.getInstance().azurirajPrikaz();
			}
		});
		
//		// Button addStudent treba da doda studente na predmet!
//		icon = new ImageIcon("slike\\ikonice\\1800_Icon_Pack_20x20\\PNG1_black_icons\\profile_plus [#1357].png");
//		btnAddStudent = new JButton(icon);
//		btnAddStudent.setPreferredSize(new Dimension(30,30));
//		btnAddStudent.setToolTipText("Add Student to subject");
//		btnAddStudent.setEnabled(false);
//		
//		// Button proffesor treba da doda predmetnog profesora predmetu
//		icon = new ImageIcon("slike\\ikonice\\1800_Icon_Pack_20x20\\PNG1_black_icons\\profile_image_favorite_round [#1331].png");
//		btnAddProfessor = new JButton(icon);
//		btnAddProfessor.setPreferredSize(new Dimension(30,30));
//		btnAddProfessor.setToolTipText("Add Professor to subject");
		
		
		Font f1 = textField.getFont();
		Font f = new Font("Verdana", Font.ITALIC, 12);
		textField.setFont(f);
		textField.setPreferredSize(new Dimension(450,20));
//		textField.addKeyListener(new KeyListener() {
//			
//			@Override
//			public void keyTyped(KeyEvent e) {
//				if(textField.getText().isEmpty()) {
//					//textField.setText("Type here to search");
//					textField.setToolTipText("BlaBla");
//					Font f = new Font("Verdana", Font.ITALIC, 12);
//					textField.setFont(f);
//				}else if(textField.getText().equals("Type here to search")){
//					textField.setText("");
//				}else {
//					
//					textField.setCaretColor(Color.BLACK);
//					textField.setFont(f1);
//				}
//				
//			}
//			
//			@Override
//			public void keyReleased(KeyEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//			
//			@Override
//			public void keyPressed(KeyEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//		});
		textField.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				if(textField.getText().isEmpty()) {
					textField.setText("Type here to search");
					
					Font f = new Font("Verdana", Font.ITALIC, 12);
					textField.setFont(f);
				}
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				if(textField.getText().equals("Type here to search")) {
					textField.setText("");
				}
				textField.setCaretColor(Color.BLACK);
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
//		leviDeo.add(btnAddStudent);
//		leviDeo.add(btnAddProfessor);
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

	public List<Integer> getStudentColumnForSearch(String userInput) {
		userInput.trim();
		String[] kolone = userInput.split(";");

		List<Integer> columns = new ArrayList<Integer>();
		for(String str : kolone) {
			String[] value = str.split(":");
			switch(value[0]) {
			case "Broj indeksa":
				columns.add(0);
				break;
			case "Ime":
				columns.add(1);
				break;
			case "Prezime":
				columns.add(2);
				break;
			case "Datum rodjenja":
				columns.add(3);
				break;
			case "Adresa stanovanja":
				columns.add(4);
				break;
			case "Kontakt telefon":
				columns.add(5);
				break;
			case "Email adresa":
				columns.add(6);
				break;
			case "Datum upisa":
				columns.add(7);
				break;
			case "Trenutna godina studija":
				columns.add(8);
				break;
			case "Status":
				columns.add(9);
				break;
			case "Prosecna ocena":
				columns.add(10);
				break;
			case "Spisak predmeta koje student slusa":	
				columns.add(11);
				break;
			}
		}
		return columns;
	}
	
	public List<Integer> getProfessorColumnForSearch(String userInput) {
		userInput.trim();
		String[] kolone = userInput.split(";");

		List<Integer> columns = new ArrayList<Integer>();
		for(String str : kolone) {
			String[] value = str.split(":");
			switch(value[0]) {
			case "ID broj":
				columns.add(0);
				break;
			case "Ime":
				columns.add(1);
				break;
			case "Prezime":
				columns.add(2);
				break;
			case "Datum rodjenja":
				columns.add(3);
				break;
			case "Adresa stanovanja":
				columns.add(4);
				break;
			case "Broj telefona":
				columns.add(5);
				break;
			case "Email adresa":
				columns.add(6);
				break;
			case "Radno mesto":
				columns.add(7);
				break;
			case "Zvanje":
				columns.add(8);
				break;
			case "Rang u hijerarhiji":
				columns.add(9);
				break;
			case "Predmeti":
				columns.add(10);
				break;
			}
		}
		return columns;
	}
	
	public List<Integer> getSubjectColumnForSearch(String userInput) {
		userInput.trim();
		String[] kolone = userInput.split(";");

		List<Integer> columns = new ArrayList<Integer>();
		for(String str : kolone) {
			String[] value = str.split(":");
			switch(value[0]) {
			case "Sifra predmeta":
				columns.add(0);
				break;
			case "Naziv predmeta":
				columns.add(1);
				break;
			case "Semestar":
				columns.add(2);
				break;
			case "Na Godini studiji":
				columns.add(3);
				break;
			case "Profesor":
				columns.add(4);
				break;
			case "Studenti":
				columns.add(5);
				break;
			}
		}
		return columns;
	}

}



