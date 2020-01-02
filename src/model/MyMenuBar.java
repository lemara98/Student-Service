package model;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;

import controller.MyController;

public class MyMenuBar extends JMenuBar { // Milan Knezevic
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -822368112626186686L;
	
	private static MyMenuBar instance = null;
	
	private MyMenuBar() {
		// JMenuBar osnova
		super();
		
		// JMenu dugmici u vrsti
		JMenu file = new JMenu("File");
		file.setMnemonic(KeyEvent.VK_F);
		
		JMenu edit = new JMenu("Edit");
		edit.setMnemonic(KeyEvent.VK_E);
		
		JMenu help = new JMenu("Help");
		help.setMnemonic(KeyEvent.VK_H);
		
		// Ikonice za sve dugmice meni bara u opadajucem meniju
		// Close image - ci
		ImageIcon ci = resizeIcon(new ImageIcon("slike\\ikonice\\1800_Icon_Pack_20x20\\PNG2_black_icons\\shut_down [#1431].png"));
		// New image - ni
		ImageIcon ni = resizeIcon(new ImageIcon("slike\\ikonice\\1800_Icon_Pack_20x20\\PNG1_black_icons\\inbox_plus [#1554].png"));
		// Delete image - oi (obrisi image)
		ImageIcon oi = resizeIcon(new ImageIcon("slike\\ikonice\\1800_Icon_Pack_20x20\\PNG2_black_icons\\delete [#1487].png"));
		// Edit image -- ii (eto tako)
		ImageIcon ii = resizeIcon(new ImageIcon("slike\\ikonice\\1800_Icon_Pack_20x20\\PNG2_black_icons\\pen [#1319].png"));
		// Help image -- hi
		ImageIcon hi = resizeIcon(new ImageIcon("slike\\ikonice\\1800_Icon_Pack_20x20\\PNG2_black_icons\\question [#1445].png"));
		// About image - ai
		ImageIcon ai = resizeIcon(new ImageIcon("slike\\ikonice\\1800_Icon_Pack_20x20\\PNG2_black_icons\\mr_robot [#120].png"));
		
		// new dugme
		JMenuItem novi = new JMenuItem("New", ni);
		novi.setMnemonic(KeyEvent.VK_N);
		novi.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.ALT_MASK));
		novi.addActionListener(new ActionListener() {
					
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
		
		// Close dugme
		JMenuItem close = new JMenuItem("Close", ci);
		close.setMnemonic(KeyEvent.VK_C);
		close.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.ALT_MASK));
		
		// otkomentarisati JOptionPane
		close.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
					int potvrda = JOptionPane.showConfirmDialog(null, "You are now exiting the program.\nDo you want to save changes?", "Exit program confirmation", JOptionPane.YES_NO_CANCEL_OPTION);
						
						if (potvrda == JOptionPane.YES_OPTION) {
							// Cuo sam povike , UBI GA UBI SVINJU
							MyBase.getInstance().izvoz();
							System.exit(0);
						}
						else if (potvrda == JOptionPane.NO_OPTION) {
							System.exit(0);
						}
					}
				});
	
		
		// Edit dugme
		JMenuItem izmeni = new JMenuItem("Edit", ii);
		izmeni.setMnemonic(KeyEvent.VK_E);
		izmeni.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.ALT_MASK));
		
		izmeni.addActionListener(new ActionListener() {
					
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
		
		
		// Delete dugme
		JMenuItem obrisi = new JMenuItem("Delete", oi);
		obrisi.setMnemonic(KeyEvent.VK_D);
		obrisi.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.ALT_MASK));
		
		obrisi.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
					
							if(MyMainFrame.getInstance().getSelectedTabbedPane() == 0) {
								//index of selected row --> this gives us a professor
								{
									int idx = MyMainFrame.getInstance().getProfessorJTable().getSelectedRow();
									if(idx != -1) {
										
										int dialogButton = JOptionPane.showConfirmDialog(obrisi, "Are you sure ?","Delete",JOptionPane.YES_NO_OPTION);
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
										int dialogButton = JOptionPane.showConfirmDialog(obrisi, "Are you sure ?","Delete",JOptionPane.YES_NO_OPTION);
										if(dialogButton == JOptionPane.YES_OPTION) 
											MyController.getInstance().deleteSubject(idx);
									
									} else {
										JOptionPane.showMessageDialog(MyMainFrame.getInstance(), "You must first select something to delete", "WARNING", JOptionPane.WARNING_MESSAGE);
									}
							}
							else {
								
									int idx = MyMainFrame.getInstance().getStudentJTable().getSelectedRow();
									if(idx != -1) {
										int dialogButton = JOptionPane.showConfirmDialog(obrisi, "Are you sure ?","Delete",JOptionPane.YES_NO_OPTION);
										if(dialogButton == JOptionPane.YES_OPTION) 
										MyController.getInstance().deleteStudent(idx);
										
									} else {
										JOptionPane.showMessageDialog(MyMainFrame.getInstance(), "You must first select something to delete", "WARNING", JOptionPane.WARNING_MESSAGE);
									}
							}
						
					}
				});
		
		// Help dugme
		JMenuItem pomoc = new JMenuItem("Help", hi);
		pomoc.setMnemonic(KeyEvent.VK_H);
		pomoc.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.ALT_MASK));
		pomoc.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						HelpProzor.getInstance(hi);
					}
				});
		
		
		// About dugme
		JMenuItem about = new JMenuItem("About", ai);
		about.setMnemonic(KeyEvent.VK_A);
		about.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.ALT_MASK));
		about.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				aboutProzor(ai);
			}
		});
		
		// File - opadajuci meni
		file.add(novi);
		file.add(close);
		
		// Edit - opadajuci meni
		edit.add(izmeni);
		edit.add(obrisi);
		
		// Help - opadajuci meni
		help.add(pomoc);
		help.add(about);
		
		// Dodavanje u meni vrstu redom File, Edit, Help
		this.add(file);
		this.add(edit);
		this.add(help);
	}
	
	/**
	 * Function for making only one MyMenuBarInstance
	 * @return MyMenuBar
	 */
	public static MyMenuBar getInstance() {
		if (instance == null) instance = new MyMenuBar();
		return instance;
	}
	
	/**
	 * Function which resizes any picture to a 20x20 picture for Menu Bar
	 * @param ul -- Image
	 * @return  Same but resized image
	 */
	public static ImageIcon resizeIcon(ImageIcon ul) {
		Image slika = ul.getImage();
		BufferedImage bi = new BufferedImage(20, 20, BufferedImage.TYPE_INT_ARGB);
		Graphics g = bi.getGraphics();
		g.drawImage(slika, 0, 0, 20, 20, null);
		return new ImageIcon(bi);
	}
	
	/**
	 * Ukljucuje novi prozor koji prikazuje:
	 * 	1) verziju aplikacije
	 * 	2) kratak opis iste
	 * 	3) Biografije izumitelja
	 */
	private void aboutProzor(ImageIcon ai) {
		
		Prozor.getInstance(ai);
		Prozor.getInstance(ai).setVisible(true);
	}

}

/**
 * Klasa Prozor koja ce biti upotrebljena kad se pritisne dugme About
 * @author Mile
 *
 */
class Prozor extends JFrame {
	


	/**
	 * 
	 */
	private static final long serialVersionUID = 3652029260766755004L;
	
	private static Prozor instance = null;
	
	

	private Prozor(ImageIcon ai) {
		super();
		
		// osnove novog prozora
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension ss = kit.getScreenSize();
		setTitle("About");
		setIconImage(ai.getImage());
		setSize(ss.width*7/9, ss.height*8/9);
		setResizable(true);
		setMinimumSize(new Dimension(ss.width/2, ss.height/3));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		
		// Mozda i ne mora ovaj!
		setLayout(new BorderLayout());
		
		// Slika Milan Knezevic
		ImageIcon mk = new ImageIcon("src\\podaci\\MK_slika.jpg");
		Image slika = mk.getImage();
		BufferedImage bi = new BufferedImage(300, 300, BufferedImage.TYPE_INT_ARGB);
		Graphics g = bi.getGraphics();
		g.drawImage(slika, 0, 0, 300, 300, null);
		mk = new ImageIcon(bi);
		JLabel mile = new JLabel(mk);
		
		// Slika Aleksandar Hadzibabic
		ImageIcon sh = new ImageIcon("src\\podaci\\AH_slika.jpg");
		slika = sh.getImage();
		bi = new BufferedImage(300, 300, BufferedImage.TYPE_INT_ARGB);
		g = bi.getGraphics();
		g.drawImage(slika, 0, 0, 300, 300, null);
		sh = new ImageIcon(bi);
		JLabel sale = new JLabel(sh);
		
		
		// Videcemo sta cemo sa ovim -- nije gotovo!
		
		File biografije = new File("src\\podaci\\Biografije.txt");
		JTextArea txt = new JTextArea(readFromFile(biografije));
		txt.setEditable(false);
		JScrollPane bioP = new JScrollPane(txt);
		bioP.setMinimumSize(new Dimension(500,400));
		

		File aplikacije = new File("src\\podaci\\Aplikacija.txt");
		JTextArea txt2 = new JTextArea(readFromFile(aplikacije));
		txt2.setEditable(false);
		JScrollPane appP = new JScrollPane(txt2);
		appP.setMinimumSize(new Dimension(500,400));
		
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, bioP, appP);
		splitPane.setOneTouchExpandable(false);
		splitPane.setMinimumSize(new Dimension(ss.width/2, ss.height/3));
		splitPane.setMaximumSize(new Dimension(ss.width/2, ss.height/3));
		
		add(splitPane);
		
		// JPanel sa slikama
		JPanel panel = new JPanel(new BorderLayout());
		
		panel.add(sale, BorderLayout.EAST);
		panel.add(mile, BorderLayout.WEST);
		
		// centralni tekst i slike
		JPanel centralniPanel = new JPanel(new BorderLayout());
		
		JLabel imem = new JLabel("<html>Prvi student: <br/> Milan Knezevic</html>");
		
		JLabel imes = new JLabel("<html>Drugi student: <br/>Aleksandar Hadzibabic </html>");
		
		ImageIcon naruto = new ImageIcon("src\\podaci\\naruto.png");
		Image slikan = naruto.getImage();
		BufferedImage bufim = new BufferedImage(300, 300, BufferedImage.TYPE_INT_ARGB);
		Graphics gn = bufim.getGraphics();
		gn.drawImage(slikan, 0, 0, 300, 300, null);
		naruto = new ImageIcon(bufim);
		JLabel narutoLabela = new JLabel(naruto);
		
		narutoLabela.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				AudioInputStream audioInputStream;
				Clip clip;
				File zvuk = new File("src\\podaci\\naruto.wav");
				
				try {
					audioInputStream = AudioSystem.getAudioInputStream(zvuk);
					clip = AudioSystem.getClip();
					clip.open(audioInputStream);
					clip.start();
				} catch (UnsupportedAudioFileException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (LineUnavailableException e1) {
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		centralniPanel.add(imem, BorderLayout.WEST);
		centralniPanel.add(imes, BorderLayout.EAST);
		centralniPanel.add(narutoLabela, BorderLayout.CENTER);
		
		
		panel.add(centralniPanel, BorderLayout.CENTER);
		
		add(panel, BorderLayout.SOUTH);
		
		}
	
	/**
	 * Reading text from a file
	 * @param fajl - File
	 * @return String from a file
	 */
	public static String readFromFile(File fajl) {
		
		StringBuilder sadrzaj = new StringBuilder();
		try(BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fajl.getPath()), "UTF-8"))) {
			
			String trenutni;
			while ((trenutni = br.readLine()) != null) {
				sadrzaj.append(trenutni).append("\n");
			}	
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sadrzaj.toString();
	}
	
	/**
	 * A Deroka mladog kapetana mucki ubi ceta partizana
	 * @param ai - ImageIcon (AboutIcon)
	 * @return singleton JFrame
	 */
	public static Prozor getInstance(ImageIcon ai) {
		if (instance == null)
			instance = new Prozor(ai);
		return instance;
	}
	
	
	
}

	
	
class HelpProzor extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2097143162463813774L;
	
	private static HelpProzor instance = null;

	private HelpProzor(ImageIcon ai) {
		// osnove novog prozora
		super();
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension ss = kit.getScreenSize();
		setTitle("Help");
		setIconImage(ai.getImage());
		setSize(ss.width*7/9, ss.height*8/9);
		setResizable(true);
		setMinimumSize(new Dimension(ss.width/2, ss.height/3));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		
		File help = new File("src\\podaci\\Help.txt");
		JTextArea txt = new JTextArea(Prozor.readFromFile(help));
		txt.setEditable(false);
		JScrollPane helpP = new JScrollPane(txt);
		helpP.setMinimumSize(new Dimension(500,400));
		this.add(helpP);
		
		setVisible(true);
		
	}
	
	public static HelpProzor getInstance(ImageIcon ai) {
		if (instance == null)
			instance = new HelpProzor(ai);
		instance.setVisible(true);
		return instance;
			
	}
}
	
	

