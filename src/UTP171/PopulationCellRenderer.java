package UTP171;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class PopulationCellRenderer extends DefaultTableCellRenderer {

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		Component popCell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		if(value != null) {
			double val = ((Integer)value).intValue();
			if(val > 20000000) {
				setForeground(Color.RED);
			} else {
				setForeground(table.getForeground());
			}
		}
		super.setHorizontalAlignment(SwingConstants.RIGHT);
		return popCell;
	}
}
