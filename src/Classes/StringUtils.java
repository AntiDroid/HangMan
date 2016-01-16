package Classes;

public class StringUtils {

	
	/**
	 * Diese Methode gibt zurueck wie oft ein Buchstabe c in einem String str vorkommt.
	 */
	static public int howOften(String str, char c){
		
		int counter = 0;
		c = Character.toLowerCase(c);
		
		for(int i = 0; i < str.length(); i++){
			if(Character.toLowerCase(str.charAt(i)) == c){
				counter++;
			}
		}
		
		return counter;
	}	
}
