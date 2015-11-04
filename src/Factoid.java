/**
 * @author Dustin Hurst CS 3250 Assignment 4 The Alice Server Bot that will make
 *         simple dynamic replies to the clients messages (questions)
 **/

public class Factoid {
	private FactoidKey key;
	private String[] keywords;
	private String value;
	
	public Factoid() {
		key = new FactoidKey();
	}
		
	public Factoid(FactoidKey key, String[] keywords, String value) {
		this.key = key;
		this.keywords = keywords;
		this.value = value;
	}
	
	/**
	 * @return the key
	 */
	public FactoidKey getKey() {
		return key;
	}

	/**
	 * @param key the key to set
	 */
	public void setKey(FactoidKey key) {
		this.key = key;
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
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}
}
