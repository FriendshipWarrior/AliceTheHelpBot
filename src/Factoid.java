/**
 * @author Dustin Hurst CS 3250 Assignment 4 The Alice Server Bot that will make
 *         simple dynamic replies to the clients messages (questions)
 **/
	
public class Factoid {
	
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
	 * @param keywords the keywords to set
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
	 * @param response the response to set
	 */
	public void setresponse(String response) {
		this.response = response;
	}
}
