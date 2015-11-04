/**
* @author Dustin Hurst
* CS 3250
* Assignment 4
* The Alice Server Bot that will make simple dynamic replies to the clients messages (questions)
**/

class StringKey {
	    private String str1;
	    private String str2;
	    private String str3;

	  
	    
	    @Override
	    public boolean equals(Object obj) {
	        if(obj != null && obj instanceof StringKey) {
	            StringKey s = (StringKey)obj;
	            return str1.equals(s.str1) && str2.equals(s.str2);
	        }
	        return false;
	    }

	    @Override
	    public int hashCode() {
	        return (str1. + str2 + str3).hashCode();
	    }
	}