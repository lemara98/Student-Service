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
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;

import model.MyBase;
import model.MyMainFrame;
import model.Subject;

public class SubjectJTable extends JTable {

	private static final long serialVersionUID = 1260863360238058355L;

	public SubjectJTable() {
		setRowSelectionAllowed(true);
		setColumnSelectionAllowed(true);
		setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		AbstractTableModelSubject abs = new AbstractTableModelSubject();
		setModel(abs);

	
	this.addMouseMotionListener(new MouseMotionListener() {
		
		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
			      JTable target = (JTable)e.getSource();
			      if((target.columnAtPoint(e.getPoint()) == 5)) 
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
		      if (column == 5) {
		    	  JDialog prozor = new JDialog(MyMainFrame.getInstance(), "Spisak studenata koji pohadjaju predmet");
		    	  prozor.setResizable(true);
		    	  prozor.setSize(new Dimension(500,400));
		    	  prozor.setModal(true);
		    	  
		    	  JPanel panel = new JPanel(new GridBagLayout());
		    	  panel.setPreferredSize(new Dimension(300,300));
		    	  
		    	  Subject stud = MyBase.getInstance().getSubjectRow(row);
		    	  prozor.setTitle("Spisak studenata koji pohadjaju predmet: " + stud.getCode() + " " + stud.getName());
		    	  
		    	  GridBagConstraints gbc = new GridBagConstraints();
		    	  	gbc.gridx = 0;
	    			
	    			gbc.gridwidth = 1;
	    			gbc.gridheight = 1;
	    			gbc.anchor = GridBagConstraints.WEST;
	    			JLabel subject;
	    		
	    			
	    		  if (stud.getStudents().isEmpty()) {
	    			  JOptionPane.showMessageDialog(MyMainFrame.getInstance(), "Nijedan student ne pohadja ovaj predmet");
		    		  return;
		    	  }else {
		    		  for (int i = 0; i < stud.getStudents().size(); i++) {
			    		  subject = new JLabel(stud.getStudents().get(i).getBrojIndeksa() + " | "+ stud.getStudents().get(i).getIme() + " " + stud.getStudents().get(i).getPrezime());
			    		  gbc.gridy = i;
			    		  panel.add(subject,gbc);
			    	  }
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
