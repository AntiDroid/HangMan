package Classes;
import java.io.FileNotFoundException;
import java.util.*;


public class HangManManager {

	private List<String> alreadyUsedWords;
	private WordReader reader;
	
	public HangManManager(String fPath) throws FileNotFoundException{
		reader = new WordReader(fPath);
		alreadyUsedWords = new ArrayList<String>();
	}
	
	/**
	 * Diese Methode bereitet den naechsten HangMan vor. Eine Mindestbuchstabenanzahl wird uebergeben.
	 * Das HangMan Wort muss mit diesem Kriterium und zufaellig ausgewaehlt werden.
	 * @throws FileNotFoundException 
	 */
	public HangMan newGame(int noChars) throws FileNotFoundException{
		
		int i = 0;
		
		do{
			
		i = (int) (Math.random()*reader.getWords().size());
		
		}while((reader.getWords().get(i).length() < noChars) || (alreadyUsedWords.contains(reader.getWords().get(i))));
		
		return new HangMan(reader.getWords().get(i));
	}
	
	public void addUsedWords(String wort){
		this.alreadyUsedWords.add(wort);
	}
}
