import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;;

public class FactoidData {

	/**
	 * The main database of Factoids.
	 * 
	 * A short description of the answer is used as the key, and Factoid object is the value.
	 * The Factiod objects are instantiated on entry with an array of keywords to trigger the response
	 * as well as the response for the factiod
	 * 
	 * LOWER CASE ONLY
	 * DO NOT USE APPOSTROPHE
	*/
	public static Map<String, Factoid> factDB;
	static { 
		factDB = new HashMap<String, Factoid>();
		
		//TODO: populate this list
		factDB.put("canvas web address", new Factoid( 
				new String[] {
				    "internet",
					"web",
					"online",
					"canvas",
					"student portal"
					},
				"The Canvas student portal may be reached at web adress INSERT HERE"));
		
		factDB.put("chair of accounting", new Factoid( 
				new String[] {
				    "stanley",
					"jenne",
					"accounting",
					"name",
					"department",
					"chair",
					"who"
					},
				"The chair of accounting is Professor Stanley E Jenne Ph.D."));
		
	}
	
	
	/**
	 *  This is an inverted mapping from the Factiod database.
	 *  Since it is not one to one, the Factiod keys are stored within a List.
	 */
	public static Map<String, List<Factoid>> invertDB;
	static {
		// Iterate all entries in the Factoid database
		for (Map.Entry<String, Factoid> entry : factDB.entrySet()) {
			// Iterate all keywords for each Factoid: get factoid from entry then get keyword array from factiod and iterate
			for (String keyword : entry.getValue().getKeywords()) {
				// Check if keyword is in the inverted database already
				if (!invertDB.containsKey(entry.getValue())){
					// If keyword is not yet in the inverted database, 
					// put the keyword entry in as the map key and make new a List for the value
					invertDB.put(keyword, new ArrayList<Factoid>());
				} 
				// Add the Factiod object that contains the keyword to list of Factoids for this keyword
				invertDB.get(keyword).add(entry.getValue());
			}
		}
	}
}













