package baudvincassagneslaville.com;
import static baudvincassagneslaville.com.Level.*;

public class Main {
	
	//final static String LOG_FILE_NAME = "FileLog.txt";	
	
	
	public static void main(String[] args){
		
		Logger logger = LoggerFactory.getLogger(Main.class);
		
		System.out.println("level : " + logger.getLevel());
		
		
		//int i;
		//for(i = 0; i< 300; i++){
			logger.debug("test debug");
			logger.info("test info");
			logger.error("test error");
		//}
		
		
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
