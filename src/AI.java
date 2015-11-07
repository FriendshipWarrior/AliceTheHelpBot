import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
* @author Dustin Hurst
* CS 3250
* Assignment 4
* The Alice Server Bot that will make simple dynamic replies to the clients messages (questions)
**/

public class AI {

	
	/**
	 *  Returns the most plural Factoid in a list of Factoids
	**/
	public static Factoid mostCommonElement(List<Factoid> list) {
	    Map<Factoid, Integer> elementCount = new HashMap<>();

	    for (Factoid factoid : list) {
	        Integer val = elementCount.get(factoid);
	        elementCount.put(factoid, val == null ? 1 : val + 1);
	    }

	    Entry<Factoid, Integer>max = null;

	    for (Map.Entry<Factoid, Integer> factoidEntry : elementCount.entrySet()) {
	        if (max == null || factoidEntry.getValue() > max.getValue())
	            max = factoidEntry;
	    }

	    return max.getKey();
	}
		
	//TODO remove if not used
	public static int findMatchCount(final String [] a,final String [] b){
	    int matchCount = 0;

	    for(int i = 0, j = 0;i < a.length && j < b.length;){
	        int res = a[i].compareTo(b[j]);
	        if(res == 0){
	            matchCount++;
	            i++;
	            j++;
	        }else if(res < 0){
	            i++;
	        }else{
	            j++;
	        }
	    }
	    return matchCount;
	}
	
	/**
	 * Convert a String line into an String array of the space delimited words
	**/
	private static String[] lineToWords(String line) {
		String[] words = line.split("\\s+");
		
		for (int i = 0; i < words.length; i++) {
		    words[i] = words[i].replaceAll("[^\\w]", "");
		}
		
		return words;
	}
	
	/**
	 * 
	 * Use @param inputString to pass in a grammatical sentance 
	 * @return
	 */
	public static String getResponse(String inputString) {
		String response = "";
		// Make the input line into an array of word Strings, and format each to lower case with only alpha numeric
		String[] inputWords = lineToWords(inputString.toLowerCase().replaceAll("[^A-Za-z0-9 ]", "")); // Apply some formatting
		List<Factoid> potentialFactiods = new ArrayList<Factoid>();
		List<Factoid> factoidKeysTemp = new ArrayList<Factoid>();
		Factoid winner;
		
		// Iterate throught each word in the input string
		for (String word : inputWords) {
			factoidKeysTemp.clear();
			// Search the inverse database for that value and set temp variable to array of Factiods containing that keyword 
			factoidKeysTemp = FactoidData.invertDB.get(word);
			if (factoidKeysTemp != null) {
				// Assert that temp is not null, and add the list of factoids to potential matches list
				potentialFactiods.addAll(factoidKeysTemp);
			}
		}
		
		//Which ever Factoid appears most in the list of potentials is selected
		winner = mostCommonElement(potentialFactiods);
		
		return winner!=null? winner.getresponse() : "I'm affraid I don't know how to respond to that...";
	}
}
