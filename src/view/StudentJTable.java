package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

import model.MyBase;
import model.MyMainFrame;
import model.Student;

public class StudentJTable extends JTable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -729251922543511523L;

	public StudentJTable() {
		super();
		setColumnSelectionAllowed(true);
		setRowSelectionAllowed(true);
		AbstractTableModelStudent absStudent = new AbstractTableModelStudent();
		setAutoCreateRowSorter(true);	// za sortiranje (Radi) !
		setModel(absStudent);
		
		this.addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				      JTable target = (JTable)e.getSource();
				      if((target.columnAtPoint(e.getPoint()) == 11)) 
				    	  setCursor(new Cursor(Cursor.HAND_CURSOR)); 
				      else 
				    	  setCursor(new Cursor(0));

			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		this.addMouseListener(new MouseAdapter() {
			  public void mouseClicked(MouseEvent e) {
			    if (e.getClickCount() == 1) {
			      JTable target = (JTable)e.getSource();
			      int row = target.getSelectedRow();
			      int column = target.getSelectedColumn();
			     // do some stuff
			      if (column == 11) {
			    	  JDialog prozor = new JDialog(MyMainFrame.getInstance(), "Spisak predmeta koje student polaze");
			    	  prozor.setResizable(true);
			    	  prozor.setSize(new Dimension(500,400));
			    	  prozor.setModal(true);
			    	  
			    	  JPanel panel = new JPanel(new GridBagLayout());
			    	  panel.setPreferredSize(new Dimension(300,300));
			    	  
			    	  
			    	  Student s = MyBase.getInstance().getStudentRow(row);
			    	  prozor.setTitle("Spisak predmeta koje polaze student: " + s.getBrojIndeksa() + " " + s.getIme() + " " + s.getPrezime());

			    	  if (s.getSpisakPredmetaKojeStudentSlusa().isEmpty()) {
			    		  JOptionPane.showMessageDialog(MyMainFrame.getInstance(), "Ne polaze nijedan predmet!");
			    		  return;
			    	  }
			    	  
			    	  GridBagConstraints gbc = new GridBagConstraints();
			    	  	gbc.gridx = 0;
		    			
		    			gbc.gridwidth = 1;
		    			gbc.gridheight = 1;
		    			gbc.anchor = GridBagConstraints.WEST;
		    			JLabel predmet;
			    	  for (int i = 0; i < s.getSpisakPredmetaKojeStudentSlusa().size(); i++) {
			    		  predmet = new JLabel(s.getSpisakPredmetaKojeStudentSlusa().get(i).getCode() + " | " +s.getSpisakPredmetaKojeStudentSlusa().get(i).getName());
			    		  gbc.gridy = i;
			    		  panel.add(predmet,gbc);
			    	  }
			    	  
			    	  JScrollPane scrolPanel = new JScrollPane(panel);
			    	  
			    	  prozor.add(scrolPanel);
			    	  prozor.setLocationRelativeTo(null);
			    	  prozor.setVisible(true);
			      }
			      
			    }
			  }
			});
		
	}
	
	
	
	@Override
	public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		Component c = super.prepareRenderer(renderer, row, column);
		if(isRowSelected(row)) {
			c.setBackground(Color.LIGHT_GRAY);
		}else {
			c.setBackground(Color.WHITE);
		}
		return c;
	}
	
	

}
