package view;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;

public class ProfessorJTable extends JTable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6161298503549205515L;

	public ProfessorJTable() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		AbstractTableModelProfessor absModel = new AbstractTableModelProfessor();
		this.setModel(absModel);
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
