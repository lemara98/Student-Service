package view;

import javax.swing.table.AbstractTableModel;

import model.MyBase;

public class AbstractTableModelProfessor extends AbstractTableModel {

	private static final long serialVersionUID = -7675477797470185997L;

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
