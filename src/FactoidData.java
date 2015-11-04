import java.util.HashMap;
import java.util.Map;

public class FactoidData {

	/**
	 * A list of possible category keys
	 */
	public static enum Category {
		WEB, 
		LOCATIONS, 
		CHAIRS, 
		PHONES, 
		LISTS, 
		FACTS
	}

	/**
	 * A mapping of keywords that will set a category
	*/
	public static Map<Category, String[]> catKeywords;
	static {
			 catKeywords = new HashMap<Category, String[]>();
			 
			 String[] web = {
					 "url",
					 "internet",
					 "online",
					 "web",
					 "email",
					 "canvas",
					 "page",
					 "web address"
			 };
			 catKeywords.put(Category.WEB, web);
			 
			 String[] locations = {
					 "address",
					 "where",
					 "location",
					 "street",
					 "directions"
			 };
			 catKeywords.put(Category.LOCATIONS, locations);
			 
			 String[] chairs = {
					 "chair",
					 "chairman",
					 "chairwoman",
					 "department",
					 "who",
					 "head of"
			 };
			 catKeywords.put(Category.CHAIRS, chairs);
			 
			 String[] phones = {
					 "phone",
					 "number",
					 "call",
					 "telephone"
			 };
			 catKeywords.put(Category.PHONES, phones);
			 
			 String[] lists = {
					 "list",
					 "all of",
					 "all the",
					 "each of"
			 };
			 catKeywords.put(Category.LISTS, lists);
			 
			 String[] facts= {
					 "what",
					 "when",
					 "how",
					 "where"
			 };
			 catKeywords.put(Category.FACTS, facts);
		}
	
	/**
	 * The main database of factoids
	*/
	
	
}
