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
	
	
	/**
	 * Logger constructor
	 * 
	 * @param currentClass
	 */
	public Logger(Class<?> currentClass){
		this.initDate();
		this.className = currentClass.getName();
		this.initAllProperties();
	}
	
	
	/**
	 * Logger constructor that overwrites level property
	 *
	 * @param currentClass
	 * @param level
	 */
	public Logger(Class<?> currentClass, Level level) {
		this.initDate();
		this.level = level;
		this.className = currentClass.getName();
		this.initWriterProperties();
	}
	
	/**
	 * Method for debug log level
	 * 
	 * @param log
	 */
	public void debug(String log) {
		if(compareLevels(DEBUG)) {
			printLog("DEBUG",log);
		}
	}	
	
	/**
	 * Method for info log level
	 * 
	 * @param log
	 */
	public void info(String log) {
		if(compareLevels(INFO)) {
			printLog("INFO",log);
		}
	}
	
	/**
	 * Method for error log level
	 * 
	 * @param log
	 */
	public void error(String log) {
		if(compareLevels(ERROR)) {	
			printLog("ERROR",log);
		}
	}

	
	/**
	 * Display log parameters for each writer initialized
	 * 
	 * @param log message written by the user
	 * @return String corresponding to the log
	 */
	private void printLog(String level, String log){
		//full log string with : log level, class calling the log, log text, date and time
		String fullLog = (level + " class : " + this.getClassName() + " - " + log + " - " + this.dateFormat.format(date));
		
		if(isCLWInitialized()){
			this.consoleLogWriter.writeLog(fullLog);
		}
		if(isFLWInitialized()){
			this.fileLogWriter.writeLog(fullLog);
		}
		
	}
	
	
	/**
	 * Checks if the console log writer is initialized (set at TRUE in the properties)
	 * @return boolean
	 */
	private boolean isCLWInitialized(){
		if(this.consoleLogWriter == null) {
			return false;
		} else {
			return true;
		}
	}
	
	/**
	 * Checks if the file log writer is initialized (set at TRUE in the properties)
	 * @return boolean
	 */
	private boolean isFLWInitialized(){
		if(this.fileLogWriter == null) {
			return false;
		} else {
			return true;
		}
	}
	
	
	
	/**
	 * Initialize the dateFormat
	 */
	private void initDate(){
		date = new Date();
		dateFormat = new SimpleDateFormat("HH:mm:ss.SSS dd/MM/yy");
	}
	
	
	/**
	 * Read the properties from the config.properties file
	 * 
	 * @return the properties
	 */
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
	 * Initialize ALL the log properties from the config.properties file
	 * 
	 */
	private void initAllProperties() {
		Properties properties = readProperties();
		
		this.level = getLevelProperty(properties);
		this.consoleLogWriter = getCLWProperty(properties);
		this.fileLogWriter = getFLWProperty(properties);
	}
	
	
	/**
	 * Initialize only the writers from the config.properties file
	 * 
	 */		
	private void initWriterProperties() {
		Properties properties = readProperties();
		
		this.consoleLogWriter = getCLWProperty(properties);
		this.fileLogWriter = getFLWProperty(properties);
	}
	
	
	/**
	 * Get the level property of the logger
	 * 
	 * @param properties
	 * @return
	 */
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
	
	
	/**
	 * ConsoleLogWriter to display the information in the console
	 * 
	 * @param properties
	 * @return
	 */
	private ConsoleLogWriter getCLWProperty(Properties properties){
		if(properties.getProperty("logger.cibleConsole", "TRUE").equals("TRUE")) {
			return new ConsoleLogWriter();
		} else {
			return null;
		}
	}
	
	
	/**
	 * FileLogWriter to write the logger informations into a file
	 * 
	 * @param properties
	 * @return
	 */
	private FileLogWriter getFLWProperty(Properties properties) {
		if(properties.getProperty("logger.cibleFile", "TRUE").equals("TRUE")) {
			this.logFileName = properties.getProperty("logger.pathFile", "LogsFile.txt");
			return new FileLogWriter(logFileName);
		} else {
			return null;
		}
	}
	
	
	/**
	 * Compare the log level from user with the log level of the Class
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
	 * Getter for className
	 * 
	 * @return String 
	 */
	private String getClassName() {
		return this.className;
	}

	
	/**
	 * Getter for level
	 * 
	 * @return
	 */
	public Level getLevel() {
		return this.level;
	}


	
	
}
