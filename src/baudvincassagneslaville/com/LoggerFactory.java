package baudvincassagneslaville.com;



public class LoggerFactory {

	
	
	public static Logger getLogger(Class<?> currentClass) {
		return new Logger(currentClass);		
	}
	
	/**
	 *overwrites the level in the properties
	 * 
	 * @param currentClass
	 * @param level
	 * @return
	 */
	public static Logger getLogger(Class<?> currentClass, Level level) {
		return new Logger(currentClass, level);
	}
		
}