package Tests;

import Classes.*;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;

public class HangManManagerTest {
	
	HangManManager testHMM;
	String testStr = "";
	int minChars = 5;

	@Before
	public void setUp() throws Exception {
		testHMM = new HangManManager("TestText");
	}

	/**
	 * Die Methode newGame funktioniert korrekt, wenn sie mit dem Parameter 5 ein Wort mit dieser Anzahl 
	 * in dem HangMan Objekt zurueckgibt.
	 * @throws FileNotFoundException 
	 */
	@Test
	public void TestnewGame() throws FileNotFoundException {
		
		assertTrue(testHMM.newGame(minChars).getWord().length() > minChars);
	}

}
