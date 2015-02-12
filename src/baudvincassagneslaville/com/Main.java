package baudvincassagneslaville.com;

public class Main {

	public static void main(String[] args) {
		System.out.println("Bonjour");
		
		String level = "error";
		
		Logger logger = new Logger(level);
		
		System.out.println("level : " + level);
		
		
		logger.debug("test debug");
		logger.info("test info");
		logger.error("test error");
		

	}

}
