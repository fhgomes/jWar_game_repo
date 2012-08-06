package components.table;

import java.lang.reflect.Field;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;

import javax.swing.ImageIcon;

public class Sorter{ 
        
        
    public static Object getValueField (Object obj, String field)
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
    
   
            
    public static ArrayList sortByAttribute(String attName, ArrayList vDados, boolean isAscent) 
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
        			if (compare(getValueField(vDados.get(idx1.intValue()), attName), getValueField(vDados.get(idx2.intValue()), attName)) > 0)
        				idx1 = idx2;
        		}
        		else
        		{
        			if (compare(getValueField(vDados.get(idx1.intValue()), attName), getValueField(vDados.get(idx2.intValue()), attName)) < 0)
        				idx1 = idx2;
        		}
        	}
        	
        	array.add(vDados.get(idx1.intValue()));
        	indexes.remove(idx1);
        	
        }
        
        return array;
    }
    
    public static int compare(Object o1, Object o2) {
        
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
        	Class type = o1.getClass();
		  if (type.getSuperclass() == Number.class) {
		    return compare((Number) o1, (Number) o2);
		  } else if (type == String.class) {
		    return ((String) o1).compareTo((String) o2);
		  } else if (type == Date.class) {
		    return compare((Date) o1, (Date) o2);
		  } else if (type == Timestamp.class) {
			return compare((Date) o1, (Date) o2);
		  } else if (type == java.sql.Date.class) {
			return compare((Date) o1, (Date) o2);
		  } else if (type == Time.class) {
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

      public static int compare(Number o1, Number o2) {
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

      public static int compare(Date o1, Date o2) {
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

      public static int compare(Boolean o1, Boolean o2) {
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
      
      public static void sortStrings(ArrayList<String> vDados) {
    	  	String[] itens = new String[vDados.size()];
  			int i = 0;
  			for(String s: vDados){
  				itens[i] = s;
  				i++;
  			}
  		
  			Arrays.sort(itens);
  			vDados.clear();
  			
  			for(String s: itens) {
  				vDados.add(s);
  			}
  			
      }
}