package baudvincassagneslaville.com;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;


public class FileLogWriter implements AbstractLogWriter {

	
	final static Charset ENCODING = StandardCharsets.UTF_8;
	private String fileName;
	
	
	
	public FileLogWriter(String fileName) {
		this.fileName = fileName;
		initFile();
	}

	
	/*
	 * 
	 * Dumps the content of the file we are going to write the current logs into
	 * 
	 * 
	 */
	private void initFile() {
		
		FileOutputStream writer;
		try {
			writer = new FileOutputStream(fileName);
			writer.write((new String()).getBytes());
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
			
	}


	/*
	 * 
	 * Writes the current log into the specified file
	 * 
	 */

	@Override
	public void writeLog(String log) {
		
		 try {
			 FileWriter fileWriter = new FileWriter(fileName,true);
			 fileWriter.write(log + "\n");
		     fileWriter.close();
		 } catch (IOException e) {
			 e.printStackTrace();
		 }
		
	}

}
