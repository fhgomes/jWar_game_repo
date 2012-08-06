package components.table;

import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

public class TableModelBase extends DefaultTableModel{ 
    
    private ArrayList vDados    = null; 
    private String[]  columns   = null;
    private String[]  atributos = null;
    private Boolean[] editable  = null;
    
    private Map converters = new HashMap();
    
    public TableModelBase()
    {
    }
    
    public TableModelBase(ArrayList vDados, String[] columns, String[] atributos)
    {
        this.vDados=(vDados==null)?new ArrayList():vDados;
        this.columns=columns;
        this.atributos=atributos;        
    }
    
    public TableModelBase(ArrayList vDados, String[] columns, String[] atributos, Boolean[] editable)
    {
        this.vDados=(vDados==null)?new ArrayList():vDados;
        this.columns=columns;
        this.atributos=atributos;
        this.editable=editable;
    }
    
    public TableModelBase(ArrayList vDados, String[] columns, String[] atributos, Boolean[] editable, Map converters)
    {
        this.vDados=(vDados==null)?new ArrayList():vDados;
        this.columns=columns;
        this.atributos=atributos;
        this.editable=editable;
        this.converters = converters;
    }
    
    public Object getValueAt(int row, int column) 
	{
    	Object objeto = getValueField(getObjectField(vDados.get(row), atributos[column], row, column), getNameField(atributos[column]), row);
    	
    	if (converters.size()>0)
    	{
    		if (converters.containsKey(atributos[column]))
    		{    
    			return getValorConvert(atributos[column], objeto, converters);    			    			
    		}
    	}
    	
    	return objeto;
	}
    
    public Object getValorConvert (String key, Object objeto, Map converters)
    {
    	Map values = (Map) converters.get(key);
		if (values.size()>0)
		{    				
			if (values.containsKey(objeto))
			{
				return values.get(objeto);
			}
		}
		
		return objeto;
    }
    
    public void setValueAt(Object value, int row, int col) 
    {
    	Object obj = getObjectField(vDados.get(row), atributos[col], row, col);
    	String atributo = getNameField(atributos[col]);
    	
    	try {
			Field field = obj.getClass().getDeclaredField(atributo);
			field.setAccessible(true);
			field.set(obj, value);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
    	fireTableCellUpdated(row, col);
	}

	public boolean isCellEditable(int row, int col) 
    {
    	if (editable == null)
    		return false;
    	
    	if (col < editable.length && col >= 0)
    		return editable[col];
    	
    	return false;
	}
    
	public String getNameField (String field)
    {
    	if (field.contains(".")) //$NON-NLS-1$
    		return getNameField(field.substring(field.indexOf('.')+1));
    	return field;    	    		
    }
    
    public Object getObjectField (Object obj, String field, int row, int column)
    {    
    	if (field.contains(".")) //$NON-NLS-1$
    	{
    		
    		Field[] fields = obj.getClass().getDeclaredFields();        	
        	try {
        		
    	    	for (int i = 0; i < fields.length; i++)
    	    	{
    	    		fields[i].setAccessible(true);
    	    		if (fields[i].getName().equals(field.substring(0, field.indexOf(".")))) //$NON-NLS-1$
    	    		{
    	    			if (fields[i].get(obj) != null)    	    				
    	    				return getObjectField(fields[i].get(obj), field.substring(field.indexOf('.')+1), row, column);    	    				
    	    			
    	    			return null;
    	    		}
    	    	}
        	} catch (IllegalArgumentException e) {
    			e.printStackTrace();
    		} catch (IllegalAccessException e) {
    			e.printStackTrace();
    		}    		
    	}
    		
    	return obj;
    }
    
    public Object getValueField (Object obj, String field, int row)
    {    	
    	if (obj == null)
    		return null; 
    	
    	Field[] fields = obj.getClass().getDeclaredFields();
    	
    	try {
    		
	    	for (int i = 0; i < fields.length; i++)
	    	{
	    		fields[i].setAccessible(true);
	    		if (fields[i].getName().equals(field))
	    			return fields[i].get(obj);	    			
	    	}
    	} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
    	return null;
    }
    
    public int getColumnCount() {
		return columns.length;
	}
    
    public String getColumnName(int column) {
		return columns[column];
	}
        
    public Class getColumnClass(int c){
        try{        	
        	if (getValueAt(0, c) == null)
        		return String.class;
        	
        	Class cls=getValueAt(0, c).getClass();
            return cls;
        }catch (NullPointerException e){
            throw e;
        }
    }
        
    
    public Object getRow(int row)
    {
        return vDados.get(row);
    }
    
    @SuppressWarnings("unchecked") //$NON-NLS-1$
	public void addAll(Collection collection){
        vDados.addAll(collection);
    }
    
    @SuppressWarnings("unchecked") //$NON-NLS-1$
	public void add(Object obj){
        vDados.add(obj);
    }
    
    public void remover(Object index){
        vDados.remove(index);
    }
    
    public void remover(int index){
        vDados.remove(index);
    }
    
    public void removerAll(){
        vDados.clear();
    }
    
    @SuppressWarnings("unchecked") //$NON-NLS-1$
	public void removerAll(Collection col){
        vDados.removeAll(col);
    }
    
    public ArrayList getDados(){
        return vDados;
    }
        
    public int getRowCount()
    {
        if(vDados==null)
            return 0;
        return vDados.size();
    }
    
    public boolean validaRegistro(Object obj){
        return true;
    }
    
    public void sortByColumnInverse(int column)
    {
    }
    
    public void sortByColumn(String column, boolean isAscent){
    	
    	if (columns!=null){
    		
    		for (int i = 0; i < columns.length; i++) {
				String col = columns[i];
				if (col !=null && col.equals(column)){
					sortByColumn(i, isAscent);
					break;
				}
			}
    	}
    }
    
    @SuppressWarnings("unchecked") //$NON-NLS-1$
	public void sortByColumn(int column, boolean isAscent) 
    {
    	ArrayList array = new ArrayList();
    	ArrayList indexes = new ArrayList();
    	
    	for (int i = 0; i < vDados.size(); i++) 
        	indexes.add(new Integer(i));
            
        Integer idx1;
        Integer idx2;
        while(indexes.size() > 0)
        {
        	idx1 = (Integer)indexes.get(0);
        	
        	Iterator it = indexes.iterator();
        	while(it.hasNext())
        	{
        		idx2 = (Integer) it.next();
        		
        		if (isAscent)
        		{        		
        			if (compare(column, idx1, idx2) > 0)
        				idx1 = idx2;
        		}
        		else
        		{
        			if (compare(column, idx1, idx2) < 0)
        				idx1 = idx2;
        		}
        	}
        	
        	array.add(vDados.get(idx1.intValue()));
        	indexes.remove(idx1);
        	
        }
        vDados.clear();
        vDados.addAll(array);
        
    	fireTableDataChanged();
    }
    
    public int compare(int column, int row1, int row2) {
        Object o1 = this.getValueAt(row1, column);
        Object o2 = this.getValueAt(row2, column);
        if (o1 == null && o2 == null) 
        {
          return 0;
        } 
        else if (o1 == null) 
        {
        	return -1;
        } 
        else if (o2 == null) 
        {
          return 1;
        } 
        else 
        {
        	Class type = this.getColumnClass(column);
        	if(o1.getClass() != type){
        		type = o1.getClass();
        	}
		  if (type.getSuperclass() == Number.class) {
		    return compare((Number) o1, (Number) o2);
		  } else if (type == Date.class) {
		    return compare((Date) o1, (Date) o2);
		  }else if (type.equals(java.sql.Date.class)) {
		    return compare((Date) o1, (Date) o2);
		  }else if (type == java.sql.Time.class) {
		    return compare((Date) o1, (Date) o2);
		  }else if (type == Timestamp.class) {
			return compare((Date) o1, (Date) o2);
		  } else if (type == Boolean.class) {
		    return compare((Boolean) o1, (Boolean) o2);
		  } else if (type == ImageIcon.class) {
			    return  ((ImageIcon) o1).getDescription().compareTo(((ImageIcon) o2).getDescription());
		  } else {
		    return ((String) o1).compareTo((String) o2);
		  }
        }
      }

      public int compare(Number o1, Number o2) {
        double n1 = o1.doubleValue();
        double n2 = o2.doubleValue();
        if (n1 < n2) {
          return -1;
        } else if (n1 > n2) {
          return 1;
        } else {
          return 0;
        }
      }

      public int compare(Date o1, Date o2) {
        long n1 = o1.getTime();
        long n2 = o2.getTime();
        if (n1 < n2) {
          return -1;
        } else if (n1 > n2) {
          return 1;
        } else {
          return 0;
        }
      }

      public int compare(Boolean o1, Boolean o2) {
        boolean b1 = o1.booleanValue();
        boolean b2 = o2.booleanValue();
        if (b1 == b2) {
          return 0;
        } else if (b1) {
          return 1;
        } else {
          return -1;
        }
      }
}