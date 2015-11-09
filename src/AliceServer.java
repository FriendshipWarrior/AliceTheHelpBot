
/**
* @author Dustin Hurst
* CS 3250
* Assignment 4
* The Alice Server Bot that will make simple dynamic replies to the clients messages (questions)
**/

import java.net.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.io.*;

public class AliceServer {

	private static final String EXIT_CODE = "@@@@SERVER_EXIT";

	private static Map<String, Factoid> factDB;
	private static Map<String, List<Factoid>> invertDB;

	public static void main(String[] args) throws IOException {
		factDB = makeDatabase();
		invertDB = getInvertDatabase(factDB);

		while (true) {
			ServerSocket serverSocket = null;

			try {
				serverSocket = new ServerSocket(9000);
			} catch (IOException e) {
				System.err.println("Could not listen on port: 9000.");
				System.exit(1);
			}

			Socket clientSocket = null;
			System.out.println("Waiting for connection.....");

			try {
				clientSocket = serverSocket.accept();
			} catch (IOException e) {
				System.err.println("Accept failed.");
				System.exit(1);
			}

			System.out.println("You are now connected to Alice");

			PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

			String inputLine;
			String botResponse = "";
			String formatedResponse = "";

			while ((inputLine = in.readLine()) != null && botResponse != EXIT_CODE) {
				String userEcho = "You: " + inputLine;

				botResponse = getResponse(inputLine);
				formatedResponse = "Alice: " + botResponse;

				if (botResponse != EXIT_CODE) {
					System.out.println(userEcho);
					System.out.println(formatedResponse);
				} else {
					System.out.printf("Alice: Goodbye! \n");
				}
				out.println(formatedResponse);
			}
			
			out.close();
			in.close();
			clientSocket.close();
			serverSocket.close();
		}
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
	 * Returns the most plural Factoid in a list of Factoids
	 **/
	public static Factoid mostCommonElement(List<Factoid> list) {
		Map<Factoid, Integer> elementCount = new HashMap<>();

		for (Factoid factoid : list) {
			Integer val = elementCount.get(factoid);
			elementCount.put(factoid, val == null ? 1 : val + 1);
		}

		Entry<Factoid, Integer> max = null;

		for (Map.Entry<Factoid, Integer> factoidEntry : elementCount.entrySet()) {
			if (max == null || factoidEntry.getValue() > max.getValue())
				max = factoidEntry;
		}

		return max.getKey();
	}

	/**
	 * 
	 * Use @param inputString to pass in a grammatical sentance
	 * 
	 * @return
	 */
	public static String getResponse(String inputString) {
		String response = "";
		// Make the input line into an array of word Strings, and format each to
		// lower case with only alpha numeric
		String[] inputWords = lineToWords(inputString.toLowerCase().replaceAll("[^A-Za-z0-9 ]", "")); // Apply some formatting
		List<Factoid> potentialFactiods = new ArrayList<Factoid>();
		List<Factoid> factoidKeysTemp = new ArrayList<Factoid>();

		// Iterate throught each word in the input string
		for (String word : inputWords) {
			factoidKeysTemp.clear();
			// Search the inverse database for that value and set temp variable
			// to array of Factiods containing that keyword
			if (invertDB.containsKey(word)) {
				factoidKeysTemp = invertDB.get(word);
				if (factoidKeysTemp != null) {
					// Assert that temp is not null, and add the list of
					// factoids to potential matches list
					potentialFactiods.addAll(factoidKeysTemp);
				}
			}
		}

		if (potentialFactiods.isEmpty()) {
			// Which ever Factoid appears most in the list of potentials is
			// selected
			response = factDB.get("i dont know").getresponse();
		} else {
			response = mostCommonElement(potentialFactiods).getresponse();
		}

		return response;
	}

	/*----------------  inner classes  --------------------*/

	public static class Factoid {

		private String[] keywords;
		private String response;

		public Factoid(String[] keywords, String response) {
			this.keywords = keywords;
			this.response = response;
		}

		/**
		 * @return the keywords
		 */
		public String[] getKeywords() {
			return keywords;
		}

		/**
		 * @param keywords
		 *            the keywords to set
		 */
		public void setKeywords(String[] keywords) {
			this.keywords = keywords;
		}

		/**
		 * @return the response
		 */
		public String getresponse() {
			return response;
		}

		/**
		 * @param response
		 *            the response to set
		 */
		public void setresponse(String response) {
			this.response = response;
		}
	}

	/**
	 * The main database of Factoids.
	 * 
	 * A short description of the answer is used as the key, and Factoid object
	 * is the value. The Factiod objects are instantiated on entry with an array
	 * of keywords to trigger the response as well as the response for the
	 * factiod
	 * 
	 * LOWER CASE ONLY DO NOT USE APPOSTROPHE
	 */

	private static Map<String, List<Factoid>> getInvertDatabase(Map<String, Factoid> DB) {
		Map<String, List<Factoid>> invertDB = new HashMap<String, List<Factoid>>();

		// Iterate all entries in the Factoid database
		for (Map.Entry<String, Factoid> entry : DB.entrySet()) {
			// Iterate all keywords for each Factoid: get factoid from entry
			// then get keyword array from factiod and iterate
			for (String keyword : entry.getValue().getKeywords()) {
				// Check if keyword is in the inverted database already
				if (!invertDB.containsKey(entry.getValue())) {
					// If keyword is not yet in the inverted database,
					// put the keyword entry in as the map key and make new a
					// List for the value
					invertDB.put(keyword, new ArrayList<Factoid>());
				}
				// Add the Factiod object that contains the keyword to list of
				// Factoids for this keyword
				invertDB.get(keyword).add(entry.getValue());
			}
		}

		return invertDB;
	}
	
	private static Map<String, Factoid> makeDatabase() { 
		Map<String, Factoid> DB = new HashMap<String, Factoid>();
		
		//TODO: populate this list
		DB.put("canvas web address", new Factoid( 
				new String[] {
				    "internet",
					"web",
					"online",
					"canvas",
					"student", 
					"portal"
					},
				"The Canvas student portal may be reached at web adress INSERT HERE"));
		
		DB.put("chair of accounting", new Factoid( 
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
		
		DB.put("exit code", new Factoid( 
				new String[] {
				    "exit",
					"good",
					"bye",
					"bye",
					"see",
					"you",
					"later",
					"peace",
					"out",
					"goodbye"
					},
				EXIT_CODE));
		
		DB.put("i dont know", new Factoid(
				new String[] {},
				"I'm affaid I can't do that Dave..."));
		
		return DB;
	}
} 
