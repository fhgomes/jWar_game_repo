package util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil 
{
	
	/**
     * 
     * @param data1 data menor;
     * @param data2 data maior;
     * 
     * @return 
     * 		data1 > data2 = 1;
     *      data1 = data2 = 0;
     *      data1 < data2 = -1;
     */
    public static int compareOnlyDates (Date data1, Date data2){
    	
    	Calendar calendar1 = Calendar.getInstance();
    	calendar1.setTime(data1);
    	
    	Calendar calendar2 = Calendar.getInstance();
    	calendar2.setTime(data2);
    	
    	if (calendar1.get(Calendar.YEAR) ==	calendar2.get(Calendar.YEAR)){
    		
    		if (calendar1.get(Calendar.MONTH) == calendar2.get(Calendar.MONTH)){
        		
    			if (calendar1.get(Calendar.DAY_OF_MONTH) == calendar2.get(Calendar.DAY_OF_MONTH)){
            		
    				return 0;
            		
            	}else{        		
            		if (calendar1.get(Calendar.DAY_OF_MONTH) > calendar2.get(Calendar.DAY_OF_MONTH)){
                		return 1;
                	}else{
                		return -1;
                	}
            	}
    			
        	}else{        		
        		if (calendar1.get(Calendar.MONTH) > calendar2.get(Calendar.MONTH)){
            		return 1;
            	}else{
            		return -1;
            	}
        	}
    	}else{
    		
    		if (calendar1.get(Calendar.YEAR) > calendar2.get(Calendar.YEAR)){
        		return 1;
        	}else{
        		return -1;
        	}
    	}
    }
    
    public static Date adicionaDias (Date data, int dias){
    	
    	Calendar calendar = Calendar.getInstance();
		calendar.setTime(data);
		calendar.add(Calendar.DAY_OF_MONTH, dias);
		
		return calendar.getTime();
    }
    
    /**
     * Metodo que calcula a diferença de dias entre duas datas.
     * @param data1
     * @param data2
     * @return
     */
    public static int diferencaDias (Date data1, Date data2){
    	
    	long m1 = data1.getTime();
		long m2 = data2.getTime();
		
	    return (int) ((m2 - m1) / (24*60*60*1000));
		
    }
    
    public static int diferencaMeses (Date data1, Date data2){
    	
    	if (data1==null || data2==null)
    		return -1;
    	
    	int mesFinal = 0;
		int anoFinal = 0;
		
		int mes = 0;
		int ano = 0;
		
		int mult = 1;
		
    	Calendar c1 = Calendar.getInstance();
    	c1.setTime(data1);
    	
    	Calendar c2 = Calendar.getInstance();
    	c2.setTime(data2);
    	
    	if (compareOnlyDates(data1, data2)==1){
    		
    		mesFinal = c2.get(Calendar.MONTH);
    		anoFinal = c2.get(Calendar.YEAR);
    		
    		mes = c1.get(Calendar.MONTH);
    		ano = c1.get(Calendar.YEAR);
    		
    	}else{
    		
    		mesFinal = c1.get(Calendar.MONTH);
    		anoFinal = c1.get(Calendar.YEAR);
    		
    		mes = c2.get(Calendar.MONTH);
    		ano = c2.get(Calendar.YEAR);
    		
    		mult = -1;
    	}
    	
    	int meses = 0;
		
		while (mesFinal > mes || anoFinal > ano){
			
			meses += 1;
			
			if (mes==11){
				mes = 0;
				ano += 1;
			}else
				mes+=1;    			
			
		}
    	
		return meses*(mult);
		
    }
    
    public static java.sql.Date getSQLDate(Date data)
    {
    	Calendar calendar = Calendar.getInstance();
    	calendar.setTime(data);
    	
    	//return new java.sql.Date(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
    	
    	return new java.sql.Date(data.getTime());
    }
    
    public static Date convertSQLDateToDate(java.sql.Date data)
    {
    	Calendar calendar = Calendar.getInstance();
    	calendar.setTimeInMillis(data.getTime());
    	
    	//return new java.sql.Date(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
    	
    	return calendar.getTime();
    }
    
    public static Date convertTimestampToDate(java.sql.Timestamp data)
    {
    	if (data!=null){
    		
    		Calendar calendar = Calendar.getInstance();
        	calendar.setTimeInMillis(data.getTime());
        	
        	return calendar.getTime();
    	
    	}
    	return null;
    	
    }
    
    public static Date getCurrentDate(){
    	return Calendar.getInstance().getTime();
    }
    
    public static String getDataDDMMYYYY(Date data){
    	return new SimpleDateFormat("dd/MM/yyyy").format(data);
    }
    
    public static String getDataDDMMYYYY(){
    	return getDataDDMMYYYY(Calendar.getInstance().getTime());
    }
    
    public static String getHoraHHMM(Date data){
    	return new SimpleDateFormat("HH:mm").format(data);
    }
    
    public static String getHoraHHMM(){
    	return getHoraHHMM(Calendar.getInstance().getTime());
    }
    
    public static int getMesCorrespondente(int mesNormal){
    	
    	if (mesNormal == 1)
    		return Calendar.JANUARY;
    	else if (mesNormal == 2)
    		return Calendar.FEBRUARY;
    	else if (mesNormal == 3)
    		return Calendar.MARCH;
    	else if (mesNormal == 4)
    		return Calendar.APRIL ;
    	else if (mesNormal == 5)
    		return Calendar.MAY;
    	else if (mesNormal == 6)
    		return Calendar.JUNE;
    	else if (mesNormal == 7)
    		return Calendar.JULY;
    	else if (mesNormal == 8)
    		return Calendar.AUGUST;
    	else if (mesNormal == 9)
    		return Calendar.SEPTEMBER;
    	else if (mesNormal == 10)
    		return Calendar.OCTOBER;
    	else if (mesNormal == 11)
    		return Calendar.NOVEMBER;
    	else if (mesNormal == 12)
    		return Calendar.DECEMBER;
    	else
    		return 0;
    }
    
    
    public static String getDiferencaDataExtenso(Date dataInicio, Date dataFim){
    	
    	int dias = diferencaDias(dataInicio, dataFim);
    	int anos = (int) dias/360;
    	dias = dias - (anos*360);
    	int meses = (int) dias/30;
    	
    	String str = "";
    	if(anos>0){
    		str = anos+" "+((anos == 1)?"ano": "anos");
    	}
    	
    	if(meses>0){
    		if(!str.equals("")){
    			str += " e ";
    		}
    		str += meses+" "+((meses == 1)?"mês": "meses");
    	}
    	
    	return str;
    }
    
    public static Date getProximoDiaUtil(Date data){
    	
    	if(data==null)
    		return data;
    	
    	Calendar calendar = Calendar.getInstance();
    	calendar.setTime(data);
    	
    	boolean diaUtil = true;
    	while (diaUtil) {
			
    		if(calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY ||
    				calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY){
    			calendar.add(Calendar.DAY_OF_MONTH, 1);
    		}else{
    			diaUtil = false;
    		}			
		}
    	 
    	return DateUtil.getSQLDate(calendar.getTime());
    }
     
	public static Date getPrimeiroDiaDoMes(Date date)
	{
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_MONTH,calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
		return calendar.getTime();
	}
	
	public static Date getUltimoDiaDoMes(Date date)
	{
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_MONTH,calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		return calendar.getTime();
	}

}
