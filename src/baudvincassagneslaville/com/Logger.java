package baudvincassagneslaville.com;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {

	
	final static String FILE_NAME = "LogsFile";	
	
	private Date date;
	private DateFormat dateFormat;
	
	
	private String level;
	private String className;	
	
	public Logger(String level, String className){
		this.initDate();
		this.level = level;
		this.className = className;
	}
	
	AbstractLogWriter consoleLogWriter = new ConsoleLogWriter();
	AbstractLogWriter fileLogWriter = new FileLogWriter(FILE_NAME);
	
	
	/**
	 * initialize the dateFormat
	 */
	private void initDate(){
		date = new Date();
		dateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yy");
	}
	
	
	
	
	public void debug(String log) {
		if(this.level.equalsIgnoreCase("debug")) {
			consoleLogWriter.writeLog("DEBUG" + printLog(log));
			fileLogWriter.writeLog("DEBUG" + printLog(log));
		}
	}	
	
	public void info(String log) {
		if(this.level.equalsIgnoreCase("debug") || this.level.equalsIgnoreCase("info")) {
			consoleLogWriter.writeLog("INFO" + printLog(log));
			fileLogWriter.writeLog("INFO" + printLog(log));
		}
	}
	
	public void error(String log) {
		if(this.level.equalsIgnoreCase("debug") || this.level.equalsIgnoreCase("info") || this.level.equalsIgnoreCase("error")) {
			consoleLogWriter.writeLog("ERROR" + printLog(log));
			fileLogWriter.writeLog("ERROR" + printLog(log));
		}
	}
	
	
	
	
	/**
	 * 
	 * @param log message written by the user
	 * @return String corresponding to the log
	 */
	private String printLog(String log){
		return(" class : " + this.getClassName() + " - " + log + " - " + dateFormat.format(date));
	}
	
	
	
	
	
	/**
	 * getter for className
	 * 
	 * @return String 
	 */
	private String getClassName() {
		return this.className;
	}
	
	
}
