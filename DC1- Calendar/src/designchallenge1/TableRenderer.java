package designchallenge1;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;


public class TableRenderer extends DefaultTableCellRenderer
{
	private ArrayList<String> colors; 
	
    public TableRenderer(ArrayList<String> colors) {
		this.colors = colors;
	}

	public Component getTableCellRendererComponent (JTable table, Object value, boolean selected, boolean focused, int row, int column)
    {
            super.getTableCellRendererComponent(table, value, selected, focused, row, column);
            if (column == 0 || column == 6)
                    setBackground(new Color(220,220,255));
            else
                    setBackground(Color.WHITE);
           
            for (int i=0; i<colors.size(); i=i+3)
            {
            	if (row == Integer.parseInt(colors.get(i)) && column == Integer.parseInt(colors.get(i+1)))
            		setBackground(colorSetter(colors.get(i+2)));
            }
            
            setForeground(Color.black);
            
            return this;  
    }
	
	public Color colorSetter(String c) {
		switch(c.toLowerCase().replaceAll(" ", "")) {		
			case "green": return Color.GREEN;
			case "red": return Color.RED; 
			case "blue":return Color.BLUE;
			case "orange": return Color.ORANGE;
			case "pink": return Color.PINK;
			case "yellow": return Color.YELLOW;
		}
		return Color.WHITE;
	}
}
