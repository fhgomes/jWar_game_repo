package components.table;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

import util.DateUtil;

public class ColumnRenderer extends DefaultTableCellRenderer
{
	
	private SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
	
	public ColumnRenderer(){}
	
	public ColumnRenderer(SimpleDateFormat sdf)
	{
		this.sdf = sdf;
	}

	protected void setValue(Object value) 
	{
		if (value instanceof ImageIcon) 
		{			
			ImageIcon icon = (ImageIcon) value;
			setIcon(icon);
			if (icon.getDescription()!=null && !icon.getDescription().equals("")) //$NON-NLS-1$
				setToolTipText(icon.getDescription());
			
		}else if (value instanceof Date){
			setHorizontalAlignment(CENTER);
			if (sdf != null)
				setText(sdf.format((Date)value));
			
			else
				super.setValue(value);
			
		}else if (value instanceof java.sql.Date){
			
			Date data = DateUtil.convertSQLDateToDate((java.sql.Date)value);
			if (sdf != null)
				setText(sdf.format((Date)data));
			else
				super.setValue(data);
			
		}else if (value instanceof java.sql.Timestamp){
			
			Date data = DateUtil.convertTimestampToDate((java.sql.Timestamp)value);
			if (sdf != null)
				setText(sdf.format((Date)data));
			else
				super.setValue(data);
			
		}else if (value instanceof java.sql.Time){
			
			java.sql.Time time = ((java.sql.Time)value);
			if (sdf != null)
				setText(sdf.format(time));
			else
				super.setValue(time);
			
		}else if (value instanceof Double){
			
			Double valor = (Double) value;
			
			this.setHorizontalAlignment(SwingConstants.RIGHT);
			
			super.setValue(new BigDecimal(valor.doubleValue()).setScale(2, BigDecimal.ROUND_HALF_EVEN));
			
		}else if (value ==null){
			super.setValue("");
		}
		else {
			super.setValue(value);
		}
	}
}
