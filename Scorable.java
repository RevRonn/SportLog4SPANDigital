package sportlog;

/* AUTHOR:Ronald Malema
 * Every sport implements this interface to sign a contract that says it will return two lists
 * of sorted team names and sorted team points so as to construct a log table for all teams
 */

import java.util.List;

public interface Scorable {
	
	int MAX_TEAMNAME_LENGTH = 20;			//Implicitly public static final
	
	List<String> getSortedTeamNames();		//All methods implicitly public abstract
	List<Integer> getSortedTeamPoints();

}
