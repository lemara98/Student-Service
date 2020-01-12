package model;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

import controller.MyController;

/**
 * Klasa opadajuceg menija
 * @author Mile
 *
 */
public class MyPopupMenu extends JPopupMenu {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7537086787944602331L;

	/**
	 * Bukvalno skoro pa ista kopija Toolbara i Menubara
	 */
	public MyPopupMenu() {
		super();
		
		// Delete image - oi (obrisi image)
		ImageIcon oi = MyMenuBar.resizeIcon(new ImageIcon("slike\\ikonice\\1800_Icon_Pack_20x20\\PNG2_black_icons\\delete [#1487].png"));
		// Edit image -- ii (eto tako)
		ImageIcon ii = MyMenuBar.resizeIcon(new ImageIcon("slike\\ikonice\\1800_Icon_Pack_20x20\\PNG2_black_icons\\pen [#1319].png"));

		
		
		// Edit dugme
		JMenuItem izmeni = new JMenuItem("Edit", ii);
		izmeni.setMnemonic(KeyEvent.VK_E);
		izmeni.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.ALT_MASK));
		
		izmeni.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedPane = MyMainFrame.getInstance().getSelectedTabbedPane();
				if(selectedPane == MyToolBar.KARTICA_PROFESORI) {
					//professors // Ovde se mora dodati!
					int idx = MyMainFrame.getInstance().getProfessorJTable().getSelectedRow();
					if (idx != -1) {
						MyController.getInstance().editProfessor(idx);
					}
					else
						JOptionPane.showMessageDialog(MyMainFrame.getInstance(), "You must first select something to edit", "WARNING", JOptionPane.WARNING_MESSAGE);
				}else if(selectedPane == MyToolBar.KARTICA_PREDMETI) {
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
			
					if(MyMainFrame.getInstance().getSelectedTabbedPane() == MyToolBar.KARTICA_PROFESORI) {
						//index of selected row --> this gives us a professor
						{
							int idx = MyMainFrame.getInstance().getProfessorJTable().getSelectedRow();
							if(idx != -1) {
								
								int dialogButton = JOptionPane.showConfirmDialog(obrisi, "Are you sure ?","Delete",JOptionPane.YES_NO_OPTION);
								if(dialogButton == JOptionPane.YES_OPTION)
									MyController.getInstance().deleteProfessor(idx);
								
							} else {
								JOptionPane.showMessageDialog(MyMainFrame.getInstance(), "You must first select something to delete", "WARNING", JOptionPane.WARNING_MESSAGE);
							}
						}
					}
					else if (MyMainFrame.getInstance().getSelectedTabbedPane() == MyToolBar.KARTICA_PREDMETI) {
						
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
		
		
		add(izmeni); 
		add(obrisi);
		
	}
	
	/**
	 * Klasa koja sluzi kao listener
	 * @author Mile
	 *
	 */
	static public class PopClickListener extends MouseAdapter {
		
	    public void mousePressed(MouseEvent e) {
	        if (e.isPopupTrigger())
	            doPop(e);
	    }

	    public void mouseReleased(MouseEvent e) {
	        if (e.isPopupTrigger())
	            doPop(e);
	    }

	    private void doPop(MouseEvent e) {
	    	boolean rc = SwingUtilities.isRightMouseButton(e);
	    	if(rc) {
	        MyPopupMenu menu = new MyPopupMenu();
	        menu.show(e.getComponent(), e.getX(), e.getY());
	    	}
	    }
	}
}
