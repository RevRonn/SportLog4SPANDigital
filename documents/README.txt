 * AUTHOR : Ronald Malema
 * DATE   : 26 Sept 2022
 * EDITED : 27 Sept 2022
 
 * While the core objective was to get the project working, and with the assumption of "good input", a fairly
 * good effort of making it robust has been given for immediate and obvious errors to be handled with fairly
 * informative error messages, including line numbers, empty lines, missing files, etc
 *---------------------------------------------------------------------------------------------------------- 
 
 * Index.java
 * This is the main class, the front end of the entire project where one can display score lines and logs
 * of whatever sport, i.e. football, rugby, tennis, etc. One needs only specify the readable file where the
 * score lines are for sport in question, e.g. span.txt & scores.txt. The format of the scoreline should be:
 * 
 * 					teamNameA x, teamNameB y
 * 	
 * where x and y represent the respective scores
 

 * SportLog.java
 * This class serves as the parent class for all sport logs, be it soccer log, rugby log, basketball log, etc
 * It is abstract as it implements the Scorable interface methods whose implementation is defined in the child
 * class hereof.
 * 
 * I would personally comment out the shorthand notation (line 20) for better log display. I have retained it as per instruction
 

 * Scorable.java		This is an interface
 * Every sport implements this interface to sign a contract that says it will return two lists
 * of sorted team names and sorted team points so as to construct a log table for all teams
 *

 * SoccerLog.java			
 * This is the main engine for this project. It takes the score lines [from ReadInput.readFile()]
 * and allocates the scores accordingly: 3pts for the winning team, 0 points for the losing team
 * OR 1 point each if the score is a draw/tie.
 */

 * ReadInput.java
 * This class reads the score lines from the specified file and returns a list of all the
 * score lines. This list will be parsed into the specific SportLog child to allocate the
 * scores accordingly as per each's implementation of the scoring system
 */



#StringBuffer/StringBuilder
#SOLID
#interface
#Comments > headers plus body
UML Architecture
#protected
#abstract
#unix-ish env
#remove unused imports
#explanatory comments
#specified log display
#on github