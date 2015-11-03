/**
* @author Dustin Hurst
* CS 3250
* Assignment 4
* The Alice Server Bot that will make simple dynamic replies to the clients messages (questions)
**/

public class AI {

	//The following 2D array contain key words and responses, the first column (or row depending on convention here I say
	//column) is a keyword (or key phrase) to search for, and the second column is the corresponding response.
	private static String[][] thingsIKnow = {
			{"Hi", 			"Well hello there"},
			{"You stink", 	"Nuh uh!!"},
			{"Bye",			"Don't let the door hit your butt on the way out."},
			{"I'm hungry",	"Thats too bad I guess?  What would I know of hunger, I am a non physical entity.  I feel no hunger."},
			{"beep",		"boop"},
			{"Knock knock",	"Who's there?"}
	};
	
	//This method will search the presence of a key word in the inputString parameter by checking it against 
	//all the values in the first column of the 2D String array.
	//If it detects the presence of a keyword it will return the value of the response in the corresponding 
	//second column of the 2D String array. It returns a default response if no match is found.
	//One limitation is that it will return the first match it finds and stop searching.
	public static String RespondTo(String inputString) {
		String response = "";
		
		//Using a for-each style for loop will make certain all terms are searched even if more are added later.
		for (String[] infoPair : thingsIKnow) {
			if (inputString.contains(infoPair[0])) {
				response = infoPair[1];
				return response;
			}
		}
		
		return "I'm affraid I have no Idea what you're talking about.";
	}
	
}
