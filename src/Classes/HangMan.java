package Classes;

import javax.swing.JOptionPane;

public class HangMan{

     private String lettersTaken = "";
     private String word;
     private int noFaults = 0;

     
     /**
 	 * Der Konstruktor der das uebergebene Wort in die Eigenschaft WOrt initialisiert.
 	 */
     public HangMan(String word){
    	 this.word = word;
     }
     
     public String getLettersTaken(){
    	 return lettersTaken;
     }
     
     /**
 	 * Ein Buchstabe wird uebergeben, kontrolliert ob er vorkommt und nicht bereits genutzt wurde
 	 * und wird dann hinzugefuegt. Wenn er im Wort nicht vorkommt, wird der noFaults-Counter erhoeht.
 	 */
     public int addChar(char c){
    	 
    	 //wenn Buchstabe bereits genannt wurde
    	 if(StringUtils.howOften(this.lettersTaken, c) != 0){
    		 JOptionPane.showMessageDialog(null, "Dieser Buchstabe wurde schon erfolgreich eingesetzt!");
    	 }
    	 //Wenn Buchstabe im gesuchten Wort ist
    	 else if(StringUtils.howOften(this.word, c) == 0){
    		 this.noFaults++;
    	 }
    	 //wenn er es nicht ist und noch nicht genannt wurde
    	 else if(StringUtils.howOften(this.lettersTaken, c) == 0)
    		 lettersTaken += " "+c;
    	 
    	 return StringUtils.howOften(this.word, c);
     }

     /**
	 * Das HangMan Wort wird mit lettersTaken abgeglichen und ein maskierter
	 * Output wird je nach Spielfortschritt erstellt. Noch nicht aufgedeckte
	 * Felder sind ein "_"
	 */
     public String mask(){
    	 
    	 String maskWord = "";
    	 
    	 for(int i = 0; i < this.word.length(); i++){ 
    		 if(StringUtils.howOften(lettersTaken, word.charAt(i)) > 0) 
    		 {
    			 maskWord += this.word.charAt(i);
    		 }
    		 else
    		 {
    			 maskWord += "_";
    		 }
    	 } 
    	 return maskWord;
     }
     
     /**
 	 * Get Methode fuer das HangMan Wort
 	 */
     public String getWord(){
    	 
    	 return this.word;
     }
     
     /**
 	 * Methode, welche einen direkten Wortvergleich zulaesst.
 	 */
     public boolean solve(String word)
 	{
    	Boolean equal = word.equals(this.word);
    	
 		if (!equal)
 			this.noFaults++;
 		else{
			for(int i = 0; i< word.length(); i++){
				if(StringUtils.howOften(this.getLettersTaken(), word.charAt(i)) == 0)
					this.addChar(word.charAt(i));
			}
 		}

 		return equal;
 	}

     
     /**
 	 * Methode, welche das Spielende abfragt.
 	 */
     public Boolean isOver(){
    	 
    	return (this.word.equals(this.mask()) || noFaults == 10);
     }
     
     /**
 	 * Get Methode fuer die aktuelle Fehleranzahl
 	 */
     public int getNoFaults(){
    	 
    	 return this.noFaults;
     }
}