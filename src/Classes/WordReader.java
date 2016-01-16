package Classes;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class WordReader 
{
	private ArrayList<String> words = new ArrayList<String>();
	
	/**
	 *	Der WordReader bekommt den Pfad uebergeben, durchsucht die Textdatei nach Woertern
	 *	und filtert bereits genutzte Worte raus.
	 * @throws FileNotFoundException 
	 */
	public WordReader(String fPath) throws FileNotFoundException
	{
		String word = "";
		Scanner scan = new Scanner(new File(fPath));
		
		scan.useDelimiter("[!-/]|\\s|[:-\\?]");
		
		while(scan.hasNext()){
			word = scan.next();
			if(!words.contains(word) && !word.isEmpty())
			words.add(word);
		}
		scan.close();
	}
	
	/**
	 * Die Get-Methode fuer die Liste mit den Woertern
	 */
	public ArrayList<String> getWords()
	{
		return words;
	}
}