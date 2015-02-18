package baudvincassagneslaville.com;

public class ConsoleLogWriter implements AbstractLogWriter {

	@Override
	public void writeLog(String log) {
		System.out.println(log);

	}

}
