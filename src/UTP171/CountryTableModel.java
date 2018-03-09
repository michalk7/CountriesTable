package UTP171;

import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.table.AbstractTableModel;

public class CountryTableModel extends AbstractTableModel {
	
	private List<Country> rows;
	private String[] columnNames;
	
	public CountryTableModel(List<Country> rows, String[] columnNames) {
		this.rows = rows;
		this.columnNames = columnNames;
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return rows.size();
	}
	

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return getValueAt(0, columnIndex).getClass();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Country c = rows.get(rowIndex);
		switch(columnIndex) {
		case 0: return c.getName();
		case 1: return c.getCapital();
		case 2: return c.getPopulation();
		case 3: return c.getFlag();
		}
		return null;
	}

	@Override
	public String getColumnName(int column) {
		return columnNames[column];
	}

	@Override
	public void setValueAt(Object val, int rowIndex, int columnIndex) {
		Country c = rows.get(rowIndex);
		switch(columnIndex) {
		case 0:
			c.setName((String)val);
			break;
		case 1:
			c.setCapital((String)val);
			break;
		case 2:
			c.setPopulation((int)val);
			break;
		case 3:
			c.setFlag((ImageIcon)val);
			break;
		}
		fireTableCellUpdated(rowIndex, columnIndex);
	}
}
