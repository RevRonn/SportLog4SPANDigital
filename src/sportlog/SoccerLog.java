package sportlog;

/* AUTHOR:Ronald Malema		DATE: 26 Sept 2022
 * EDITED:Name Surname		DATE: 27 Sept 2022
 * This is the main engine for this project. It takes the score lines [from ReadInput.readFile()]
 * and allocates the scores accordingly: 3pts for the winning team, 0 points for the losing team
 * OR 1 point each if the score is a draw/tie.
 */

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SoccerLog extends SportLog {	//indirectly implements Scorable interface by inheritance{

	private LinkedHashMap<String, Integer> reverseSortedMap, finalHashMap;
	private List<String> teamNames, scoreLines;
	private List<Integer> teamPoints;
	private String fileName;
	
	public SoccerLog(String fileName) throws FileNotFoundException{
		
		this.fileName = fileName; 
		reverseSortedMap = new LinkedHashMap<>();
		finalHashMap = new LinkedHashMap<>();
		
		ReadInput myReadInput = new ReadInput();
		try {
		scoreLines = myReadInput.readFile(fileName);
		}
		catch(NullPointerException e) {
			System.out.println("~~~InSoccerLog:Error in the file you specified. Check file name and try again");
		}
		allocatePoints(scoreLines);
		
		reverseSortedMap.entrySet()
		  .stream()
		  .sorted(Map.Entry.<String,Integer>comparingByValue(Comparator.reverseOrder())
		  .thenComparing(Map.Entry.comparingByKey()))
		  .forEachOrdered(x -> finalHashMap.put(x.getKey(), x.getValue()));

		teamNames = new ArrayList<String>(finalHashMap.keySet());
		teamPoints = new ArrayList<Integer>(finalHashMap.values());
		
	}
	
	protected void allocatePoints(List<String> scoreLine) {
		int scoreOne, scoreTwo, index;
		String teamOne, teamTwo;
		
		/*if(scoreLine == null) {
			System.out.println("@@@ Error: File was not found.");
		}*/
			
		
		for (String s:scoreLine) {
			index = s.indexOf(",");
			
			if(s.trim().length() == 0)		//this ensures that if the score line is empty, it goes to the next line
				continue;
			
			if(index == -1) {
				System.out.print("\nError in the score you entered!  Please check score line in file: " + fileName);
				System.out.println(", line number: " + (1 + scoreLine.indexOf(s)));
				System.out.println("\t\t Score line should be in the format: \t teamA x, teamB y \n\n");
				
				System.exit(0);
			}
			
			teamOne = s.substring(0, index - 2);
			teamTwo = s.substring(index + 1, s.length() - 1).trim();
			
			try {
				scoreOne = Integer.parseInt(s.substring(index - 2, index).trim());
				scoreTwo = Integer.parseInt(s.substring(s.length() - 2, s.length()).trim());
				
				if(!reverseSortedMap.containsKey(teamOne))
					reverseSortedMap.put(teamOne, 0);
				if(!reverseSortedMap.containsKey(teamTwo))
					reverseSortedMap.put(teamTwo, 0);
				
				if(scoreOne > scoreTwo) 					//Add 3 points to team one
					reverseSortedMap.put(teamOne, (reverseSortedMap.get(teamOne) + 3));	
				
				else if(scoreOne < scoreTwo)				//Add 3 points to team two
					reverseSortedMap.put(teamTwo, (reverseSortedMap.get(teamTwo) + 3));
					
				else {					 //I would prefer using an else if here as well
					reverseSortedMap.put(teamOne, (reverseSortedMap.get(teamOne) + 1));
					reverseSortedMap.put(teamTwo, (reverseSortedMap.get(teamTwo) + 1));
				}
			}
			catch(NullPointerException | NumberFormatException e) {
				System.out.println("\nError in the score you entered!\n\n");
				System.out.println("In file: " + fileName + ", at line number: " + (1 + scoreLine.indexOf(s)));
				System.exit(0);
				//e.printStackTrace();
			}
		}
	}

	public List<String> getSortedTeamNames(){
	
		return teamNames;
	}
	
	public List<Integer> getSortedTeamPoints(){
		
		return teamPoints;
	}

	public List<String> getScoreLines() {
		return scoreLines;
	}
}
