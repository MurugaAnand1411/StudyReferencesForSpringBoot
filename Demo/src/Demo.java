
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

import net.minidev.json.JSONObject;

public class Demo {
	
	public static void main(String[] args) {
		Date dt = new Date();
		Calendar c = Calendar.getInstance(); 
		c.setTime(dt);
		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:sss");  
        String strDate = dateFormat.format(dt);
    	System.out.println("from"+strDate);
        c.add(Calendar.DATE, 1);
        dt = c.getTime();
       String strdate2=dateFormat.format(dt);
   	   System.out.println("to"+strdate2);
   	JSONObject obj = new JSONObject();
        
//        {
//            "fromdate": strDatestrDate,
//            "fromdate": strDatestrDate,
//            
//        }
//		
//		LocalDateTime ldt= LocalDateTime.now();
//	    System.out.println("In : :"+ldt);
//	    DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:sss");  
//	  String str = dateFormat.format(ldt);
//	  System.out.println("o"+str);
//	  
//	    LocalDateTime ldt1= ldt.plusDays(1);
//	    System.out.println("after plus one day"+ldt1);
		 
        
	}

}
