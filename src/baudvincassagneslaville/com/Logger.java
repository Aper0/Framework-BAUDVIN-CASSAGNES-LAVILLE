package baudvincassagneslaville.com;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {

	
	private Date date;
	private DateFormat dateFormat;
	
	
	private String level;
	
	public Logger(String level){
		this.initDate();
		this.level = level;
	}
	

	private void initDate(){
		date = new Date();
		dateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yy");
	}
	
	
	public void debug(String log) {
		if(this.level.equalsIgnoreCase("debug"))
			System.out.println("DEBUG - " + log + " - " +dateFormat.format(date));
	}	
	
	public void info(String log) {
		if(this.level.equalsIgnoreCase("debug") || this.level.equalsIgnoreCase("info"))
			System.out.println("INFO - " + log + " - " +dateFormat.format(date));
	}
	
	public void error(String log) {
		if(this.level.equalsIgnoreCase("debug") || this.level.equalsIgnoreCase("info") || this.level.equalsIgnoreCase("error"))
			System.out.println("ERROR - " + log + " - " +dateFormat.format(date));
	}
	
	
	
	
}
