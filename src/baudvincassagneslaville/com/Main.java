package baudvincassagneslaville.com;

import java.io.IOException;
import java.util.List;




public class Main {

	

	final static String FILE_NAME = "LogsFile";	
	
	public static void main(String[] args) throws IOException {
		System.out.println("Bonjour");
		
		String level = "debug";
		
		Logger logger = new Logger(level, Main.class.getName());
		
		System.out.println("level : " + level);
		
		
		logger.debug("test debug");
		logger.info("test info");
		logger.error("test error");
		
		
		
		
		/*
		 * writes the content of the log file after tests
		 * 
		 */
		FileLogReader fileLogReader = new FileLogReader();
		List<String> logs = fileLogReader.readSmallTextFile(FILE_NAME);
		
		System.out.println(logs);
	
	
		
	}

	
	
	
}
