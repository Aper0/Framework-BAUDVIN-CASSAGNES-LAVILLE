package baudvincassagneslaville.com;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class Logger {

	
	final static String PROPERTIES_FILE_NAME = "config.properties";	
	
	private Date date;
	private DateFormat dateFormat;
	
	private String logFileName;
	private String level;
	
	private AbstractLogWriter consoleLogWriter = null;
	private AbstractLogWriter fileLogWriter = null;
	
	
	
	private String className;	
	
	public Logger(String className){
		this.initDate();
		this.className = className;
		this.initProperties();
	}
	
	
	
	
	
	/**
	 * initialize the dateFormat
	 */
	private void initDate(){
		date = new Date();
		dateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yy");
	}
	
	
	
	
	
	/**
	 * initialize the log properties from the config.properties file
	 * 
	 */
	private void initProperties() {
		
		Properties properties = new Properties();
		
		try {
			FileInputStream in = new FileInputStream(PROPERTIES_FILE_NAME);
			properties.load(in);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		this.level = properties.getProperty("logger.level", "DEBUG");
		
		if(properties.getProperty("logger.cibleConsole", "TRUE").equals("TRUE")) {
			this.consoleLogWriter = new ConsoleLogWriter();
		}
		
		if(properties.getProperty("logger.cibleFile", "TRUE").equals("TRUE")) {
			this.logFileName = properties.getProperty("logger.pathFile", "LogsFile.txt");
			this.fileLogWriter = new FileLogWriter(logFileName);
		}
		
		
		
	}
	
	
	
	
	
	public void debug(String log) {
		if(this.level.equalsIgnoreCase("DEBUG")) {
			if(this.consoleLogWriter != null)
				this.consoleLogWriter.writeLog("DEBUG" + printLog(log));
			if(this.fileLogWriter != null)
				this.fileLogWriter.writeLog("DEBUG" + printLog(log));
		}
	}	
	
	public void info(String log) {
		if(this.level.equalsIgnoreCase("DEBUG") || this.level.equalsIgnoreCase("INFO")) {
			if(this.consoleLogWriter != null)
			this.consoleLogWriter.writeLog("INFO" + printLog(log));
		if(this.fileLogWriter != null)
			this.fileLogWriter.writeLog("INFO" + printLog(log));
		}
	}
	
	public void error(String log) {
		if(this.level.equalsIgnoreCase("DEBUG") || this.level.equalsIgnoreCase("INFO") || this.level.equalsIgnoreCase("ERROR")) {	
			if(this.consoleLogWriter != null)
				this.consoleLogWriter.writeLog("INFO" + printLog(log));
			if(this.fileLogWriter != null)
				this.fileLogWriter.writeLog("INFO" + printLog(log));
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


	public String getLevel() {
		return this.level;
	}


	
	
}
