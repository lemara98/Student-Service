package view;

import javax.swing.table.AbstractTableModel;

import model.MyBase;


/**
 * Znaci koja ce da uzima podatke iz tabele sa profesorima
 * @author Mile
 *
 */
public class AbstractTableModelStudent extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -538526045258933971L;

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return MyBase.getInstance().getStudents().size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return MyBase.getInstance().getStudentsColumnCount();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return MyBase.getInstance().getStudentsValueAt(rowIndex, columnIndex);
	}
	
	@Override
	public String getColumnName(int column) {
		return MyBase.getInstance().getStudentsColumnName(column);
	}


}
