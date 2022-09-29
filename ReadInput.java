package sportlog;

/* AUTHOR:Ronald Malema
 * This class reads the score lines from the specified file and returns a list of all the
 * score lines. This list will be parsed into the specific SportLog child to allocate the
 * scores accordingly as per each's implementation of the scoring system
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadInput {
	
	private List<String> scoreLines;

	protected List<String> readFile(String fileName){
		
		try {
			
			File file = new File(getClass().getResource("files/".concat(fileName)).getPath());
			scoreLines = new ArrayList<String>();
			Scanner scanner = new Scanner(file);
			
			while(scanner.hasNextLine()){
				scoreLines.add(scanner.nextLine());
			}
	    
			scanner.close();
		}
		catch(FileNotFoundException | NullPointerException e) {
			System.out.println("\n~~~The file specified: " + fileName + " was not found.~~~\nCheck file name in sportlog/files and try again.");
			System.exit(0);
		}
	     
	    return scoreLines;
	}
}
