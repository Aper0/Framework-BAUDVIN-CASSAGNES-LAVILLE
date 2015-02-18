package baudvincassagneslaville.com;



import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
//import java.util.Arrays;
import java.util.List;


public class FileLogReader {

	
	final static Charset ENCODING = StandardCharsets.UTF_8;
	
	
	List<String> readSmallTextFile(String aFileName) throws IOException {
	    Path path = Paths.get(aFileName);
	    return Files.readAllLines(path, ENCODING);
	}
	
}
