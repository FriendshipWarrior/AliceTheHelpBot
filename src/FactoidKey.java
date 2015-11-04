/**
 * @author Dustin Hurst CS 3250 Assignment 4 The Alice Server Bot that will make
 *         simple dynamic replies to the clients messages (questions)
 **/

class FactoidKey {


	private FactoidData.Category category; // The most basic type of description
	private String subject;

	/**
	 * @return the str1
	 */
	public FactoidData.Category getCategory() {
		return category;
	}

	/**
	 * @param category
	 *            the {@link FactoidKey}Category to set
	 */
	public void setCategory(FactoidData.Category category) {
		this.category = category;
	}

	/**
	 * @return the str2
	 */
	public String getStr2() {
		return subject;
	}

	/**
	 * @param str2
	 *            the str2 to set
	 */
	public void setStr2(String str2) {
		this.subject = str2;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof FactoidKey) {
			FactoidKey key = (FactoidKey) obj;
			return category.equals(key.category) && subject.equals(key.subject);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return (category.toString() + subject).hashCode();
	}
}