package baudvincassagneslaville.com;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {

	
	private Date date;
	private DateFormat dateFormat;
	
	
	public Logger(){
		this.initDate();
	}
	

	private void initDate(){
		date = new Date();
		dateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yy");
	}
	
	
	public void debug(String log) {
		System.out.println("DEBUG - " + log + " - " +dateFormat.format(date));
	}	
	
	public void info(String log) {
		System.out.println("INFO - " + log + " - " +dateFormat.format(date));
	}
	
	public void error(String log) {
		System.out.println("ERROR - " + log + " - " +dateFormat.format(date));
	}
	
	
	
	
}
