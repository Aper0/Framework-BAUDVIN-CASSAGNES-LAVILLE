package baudvincassagneslaville.com;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import static baudvincassagneslaville.com.Level.*;

public class Logger {

	final static String PROPERTIES_FILE_NAME = "config.properties";
	
	private Date date;
	private DateFormat dateFormat;
	
	private String logFileName;
	private Level level;
	
	private AbstractLogWriter consoleLogWriter = null;
	private AbstractLogWriter fileLogWriter = null;
	
	private String className;	
	
	
	
	public Logger(Class<?> currentClass){
		this.initDate();
		this.className = currentClass.getName();
		this.initAllProperties();
	}
	
	
	
	public Logger(Class<?> currentClass, Level level) {
		this.initDate();
		this.level = level;
		this.className = currentClass.getName();
		this.initWriterProperties();
	}
	
	
	
	
	public void debug(String log) {
		if(compareLevels(DEBUG)) {
			if(this.consoleLogWriter != null)
				this.consoleLogWriter.writeLog("DEBUG" + printLog(log));
			if(this.fileLogWriter != null)
				this.fileLogWriter.writeLog("DEBUG" + printLog(log));
		}
	}	
	
	public void info(String log) {
		if(compareLevels(INFO)) {
			if(this.consoleLogWriter != null)
			this.consoleLogWriter.writeLog("INFO" + printLog(log));
		if(this.fileLogWriter != null)
			this.fileLogWriter.writeLog("INFO" + printLog(log));
		}
	}
	
	public void error(String log) {
		if(compareLevels(ERROR)) {	
			if(this.consoleLogWriter != null)
				this.consoleLogWriter.writeLog("ERROR" + printLog(log));
			if(this.fileLogWriter != null)
				this.fileLogWriter.writeLog("ERROR" + printLog(log));
		}
	}
	
	
	
	
	/**
	 * 
	 * @param log message written by the user
	 * @return String corresponding to the log
	 */
	private String printLog(String log){
		return(" class : " + this.getClassName() + " - " + log + " - " + this.dateFormat.format(date));
	}
	
	
	
	
	
	

	/**
	 * initialize the dateFormat
	 */
	private void initDate(){
		date = new Date();
		dateFormat = new SimpleDateFormat("HH:mm:ss.SSS dd/MM/yy");
	}
	
	
	
	
	
	
	private Properties readProperties() {
		Properties properties = new Properties();
		
		try {
			FileInputStream in = new FileInputStream(PROPERTIES_FILE_NAME);
			properties.load(in);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return properties;
	}
	
	
	/**
	 * initialize ALL the log properties from the config.properties file
	 * 
	 */
	private void initAllProperties() {
		Properties properties = readProperties();
		
		this.level = getLevelProperty(properties);
		this.consoleLogWriter = getCLWProperty(properties);
		this.fileLogWriter = getFLWProperty(properties);
	}
	
	/**
	 * initialize only the writers from the config.properties file
	 * 
	 */		
	private void initWriterProperties() {
		Properties properties = readProperties();
		
		this.consoleLogWriter = getCLWProperty(properties);
		this.fileLogWriter = getFLWProperty(properties);
	}
	
	
	private Level getLevelProperty(Properties properties) {
		
		String l = properties.getProperty("logger.level", "DEBUG");
		l.toUpperCase();
		
		switch(l) {
			case "DEBUG":
				return DEBUG;
			case "INFO":
				return INFO;
			case "ERROR":
				return ERROR;
			default:
				return DEBUG;
		}

	}
	
	private ConsoleLogWriter getCLWProperty(Properties properties){
		if(properties.getProperty("logger.cibleConsole", "TRUE").equals("TRUE")) {
			return new ConsoleLogWriter();
		} else {
			return null;
		}
	}
	
	private FileLogWriter getFLWProperty(Properties properties) {
		if(properties.getProperty("logger.cibleFile", "TRUE").equals("TRUE")) {
			this.logFileName = properties.getProperty("logger.pathFile", "LogsFile.txt");
			return new FileLogWriter(logFileName);
		} else {
			return null;
		}
	}
	
	
	/**
	 * compare the log level from user with level Class
	 * 
	 */
	private boolean compareLevels(Level logLevel) {
		if(this.level.ordinal() <= logLevel.ordinal()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	
	
	/**
	 * getter for className
	 * 
	 * @return String 
	 */
	private String getClassName() {
		return this.className;
	}


	public Level getLevel() {
		return this.level;
	}


	
	
}
