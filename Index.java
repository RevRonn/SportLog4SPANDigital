package sportlog;

/* AUTHOR:Ronald Malema
 * This is the main class, the front end of the entire project where one can display score lines and logs
 * of whatever sport, i.e. football, rugby, tennis, etc. One needs only specify the readable file where the
 * score lines are for sport in question, e.g. span.txt & scores.txt. The format of the scoreline should be:
 * 
 * 					teamNameA x, teamNameB y
 * 	
 * where x and y represent the respective scores
 */

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Index {

	public static void main(String[] args) throws FileNotFoundException{
	
		SoccerLog soccerLog = new SoccerLog("span.txt");
		SportLog.printScoreLines(soccerLog.getScoreLines());
		
		System.out.println("\nPremier Soccer League Log\n\t Club \t        Pts \n-----------------------------");
		
		soccerLog.displayLog(soccerLog.getSortedTeamNames(), (ArrayList<Integer>) soccerLog.getSortedTeamPoints());
	}
}
