package baudvincassagneslaville.com;



import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class FileLogReader {

	
	final static Charset ENCODING = StandardCharsets.UTF_8;
	
	
	void printLogFile(String fileName) {
		
	    Path path = Paths.get(fileName);
	    
	    try{
	    	BufferedReader bufferedReader = Files.newBufferedReader(path, ENCODING);
	    	String line = null;
	    	while((line = bufferedReader.readLine()) != null){
	    		System.out.println(line);
	    	}
	    } catch(IOException e) {
	    	e.printStackTrace();
	    }
	    
	}
	
}
