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
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import model.MyBase;
import model.MyMainFrame;
import model.Professor;

public class ProfessorJTable extends JTable {

	private static final long serialVersionUID = -6161298503549205515L;

	public ProfessorJTable() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		AbstractTableModelProfessor absModel = new AbstractTableModelProfessor();
		this.setModel(absModel);
		this.setAutoCreateRowSorter(true);
		this.getTableHeader().setReorderingAllowed(false);

		
		// Dodajemo Profesor Sorter
		TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(getModel());
		int zaSortiranje[] = {0,1,2,3,8,9};
		
		for(int i : zaSortiranje) {
			sorter.setSortable(i, true);
			if (i == 3)
				sorter.setComparator(i, new DateComparator());
		}
		int neSortirati[] = {4,5,6,7,10};
		
		for(int i : neSortirati) 
			sorter.setSortable(i, false);
		
		setRowSorter(sorter);

		
		this.addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				      JTable target = (JTable)e.getSource();
				      if((target.columnAtPoint(e.getPoint()) == 10)) 
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
			      if (column == 10) {
			    	  JDialog prozor = new JDialog(MyMainFrame.getInstance(), "Spisak predmeta koje profesor predaje");
			    	  prozor.setResizable(true);
			    	  prozor.setSize(new Dimension(500,400));
			    	  prozor.setModal(true);
			    	  
			    	  JPanel panel = new JPanel(new GridBagLayout());
			    	  panel.setPreferredSize(new Dimension(300,300));
			    	  
			    	  Professor pr = MyBase.getInstance().getProfessorRow(row);
			    	  prozor.setTitle("Spisak predmeta koje predaje profesor: " + pr.getIdNumber() + " " + pr.getFirstName() + " " + pr.getLastName());
			    	  
			    	  GridBagConstraints gbc = new GridBagConstraints();
			    	  	gbc.gridx = 0;
		    			
		    			gbc.gridwidth = 1;
		    			gbc.gridheight = 1;
		    			gbc.anchor = GridBagConstraints.WEST;
		    			JLabel predmet;
		    		
		    		  if (pr.getSubjects().isEmpty()) {
		    			  JOptionPane.showMessageDialog(MyMainFrame.getInstance(), "Ovaj profesor ne predaje nijedan predmet!");
			    		  return;
			    	  }else {
			    		  for (int i = 0; i < pr.getSubjects().size(); i++) {
				    		  predmet = new JLabel(pr.getSubjects().get(i).getCode() + " | " + pr.getSubjects().get(i).getName());
				    		  gbc.gridy = i;
				    		  panel.add(predmet,gbc);
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
	
	//kada selektujemo polje da bude druge boje
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
