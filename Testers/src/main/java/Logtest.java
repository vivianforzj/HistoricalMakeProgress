package main.java;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Logtest {
	final Logger log = LoggerFactory.getLogger(Logtest.class);
	 private String name;  
	    private int id;  
	      
	    public static void main(String[] args) {  
//	    	Logtest holder = new Logtest();  
//	        holder.setName("banxi");  
	    	
	    }  
	  
	    public void testPrintStackTrace() {
	    	
	    }
	    
	    public void setName(String name) {  
	        String oldName = name;  
	        this.name = name;  
	        log.error("name set to {},old name is {}",name,oldName);  

	        log.debug("name set to {},old name is {}",name,oldName);  
	        log.warn("name set to {},old name is {}",name,oldName);  
	          
	        if(name.equals("banxi")){  
	            log.info("welcome,{} is coming",name);  
	        }  
	          
	          
	    }  

}
