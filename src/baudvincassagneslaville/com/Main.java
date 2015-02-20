package baudvincassagneslaville.com;


public class Main {
	
	//final static String LOG_FILE_NAME = "FileLog.txt";	
	
	
	public static void main(String[] args){
		System.out.println("Bonjour");
		
		
		Logger logger = new Logger(Main.class.getName());
		
		System.out.println("level : " + logger.getLevel());
		
		
		logger.debug("test debug");
		logger.info("test info");
		logger.error("test error");
		
		
		
		/*
		 * writes the content of the log file after tests
		 * 
		 * uncomment the final static variable above and change 
		 * its value to match your properties to test
		 * 
		 */
		//FileLogReader fileLogReader = new FileLogReader();
		//fileLogReader.printLogFile(LOG_FILE_NAME);
	
	}
	
}
