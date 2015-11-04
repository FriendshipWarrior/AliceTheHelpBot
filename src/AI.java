/**
* @author Dustin Hurst
* CS 3250
* Assignment 4
* The Alice Server Bot that will make simple dynamic replies to the clients messages (questions)
**/

import java.util.HashMap;
import java.util.Map;

public class AI {

	//Convert a String line into an String array of the space delimited words
	private static String[] lineToWords(String line) {
		String[] words = line.split("\\s+");
		
		for (int i = 0; i < words.length; i++) {
		    words[i] = words[i].replaceAll("[^\\w]", "");
		}
		
		return words;
	}
	
	//This method will search the presence of a key word in the inputString parameter by checking it against 
	//all the values in the first column of the 2D String array.
	//If it detects the presence of a keyword it will return the value of the response in the corresponding 
	//second column of the 2D String array. It returns a default response if no match is found.
	//One limitation is that it will return the first match it finds and stop searching.
	public static String getResponse(String inputString) {
		String response = "";
		String formattedInput = inputString.toLowerCase();
		
		//Using a for-each style for loop will make certain all terms are searched even if more are added later.

		
		return "I'm affraid I have no Idea what you're talking about.";
	}
	
	public interface AliceDatabase {
		
	}
}
