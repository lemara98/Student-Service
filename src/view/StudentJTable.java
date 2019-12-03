package view;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

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
		setModel(absStudent);
		
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
