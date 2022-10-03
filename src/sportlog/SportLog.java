package sportlog;

/* AUTHOR:Ronald Malema
 * This class serves as the parent class for all sport logs, be it soccer log, rugby log, basketball log, etc
 * It is abstract as it implements the Scorable interface methods whose implementation is defined in the child
 * class hereof.
 * 
 * I would personally comment out the shorthand notation (line 20) for better log display. I have retained it as per instruction
 */

import java.util.ArrayList;
import java.util.List;

public abstract class SportLog implements Scorable{
	
	private List<String> scoreLines;
	
	public SportLog(String fileName) {

		ReadInput myReadInput = new ReadInput();
		
		try {
			scoreLines = myReadInput.readFile(fileName);
		}
		catch(NullPointerException e) {
			System.out.println("~~~InSoccerLog:Error in the file you specified. Check file name and try again");
		}
	}

	protected void displayLog(List<String> teamNames, ArrayList<Integer> teamPoints) {
		
		for(String s:teamNames) 
			System.out.println((teamNames.indexOf(s)+1) + ".  " + justify(s) + "\t" + teamPoints.get(teamNames.indexOf(s)) +
			(teamPoints.get(teamNames.indexOf(s)) == 1 ? " pt" : " pts") +			//shorthand notation to put "pt" or "pts"
			"");
	}
	
	protected static void printScoreLines(List<String> scoreLines) {
		for (String s:scoreLines)
			if(s.trim().length() != 0)
				System.out.println(s);
	}
	
	protected StringBuilder justify(String teamName) {	// this method is purely for cosmetic purposes to display the log table
		
		StringBuilder theTeamName = new StringBuilder(teamName);

		for(int i = 0;++i < MAX_TEAMNAME_LENGTH - teamName.length();)
			theTeamName.append(" ");
		
		return theTeamName;
	}
	
	public List<String> getScoreLines() {
		return scoreLines;
	}
}
