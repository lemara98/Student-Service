package view;

import javax.swing.table.AbstractTableModel;

import model.MyBase;

public class AbstractTableModelProfessor extends AbstractTableModel {

	@Override
	public int getColumnCount() {
		return MyBase.getInstance().getProfessorColumnCount();
	}

	@Override
	public int getRowCount() {
		return MyBase.getInstance().getProfessors().size();
	}

	@Override
	public Object getValueAt(int row, int column) {
		return MyBase.getInstance().getProfessorValueAt(row, column);
	}
	
	@Override
	public String getColumnName(int column) {
		return MyBase.getInstance().getProfessorColumnName(column);
	}
	
	
	
}
