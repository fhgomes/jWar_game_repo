package components.table;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.table.JTableHeader;


public class HeaderListener extends MouseAdapter {
    
	private JTableHeader header;
	private TableModelBase model;
	private SortButtonRenderer renderer;
	private int column;
	private boolean isAscent;
    
    public HeaderListener(JTableHeader header, TableModelBase model) 
    {
    	this.header = header;
    	this.model = model;
    	this.renderer = new SortButtonRenderer();
    	for (int i=0; i < this.header.getTable().getColumnCount(); i++)
    	{
    		this.header.getTable().getColumnModel().getColumn(i).setHeaderRenderer(this.renderer);
    	}
    }

    public void mousePressed(MouseEvent e) 
    {
      int col = header.columnAtPoint(e.getPoint());
      
      renderer.setPressedColumn(col);
      renderer.setSelectedColumn(col);
     
      
      if (col == column)
      {
    	  this.isAscent = !this.isAscent;
      }
      else
      {
    	  this.column  = col;
    	  this.isAscent = true;
      }
      
      this.model.sortByColumn(col, this.isAscent);
      
      this.header.getTable().updateUI();   
      header.repaint();
           
    }

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	public boolean isAscent() {
		return isAscent;
	}

	public void setAscent(boolean isAscent) {
		this.isAscent = isAscent;
	}
    
}
