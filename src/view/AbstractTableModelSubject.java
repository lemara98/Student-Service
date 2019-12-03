package view;

import javax.swing.table.AbstractTableModel;

import model.MyBase;

public class AbstractTableModelSubject extends AbstractTableModel {

	private static final long serialVersionUID = 4210673852788354694L;

	@Override
	public int getColumnCount() {
		return MyBase.getInstance().getSubjectColumnCount();
	}

	@Override
	public int getRowCount() {
		return MyBase.getInstance().getSubjects().size();
	}

	@Override
	public Object getValueAt(int row, int column) {
		return MyBase.getInstance().getSubjectValueAt(row, column);
	}
	
	@Override
	public String getColumnName(int column) {
		return MyBase.getInstance().getSubjectColumnName(column);
	}
	
}
