package Tests;
import Classes.*;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class HangManTest {

	HangMan testHM;
	String str = "Hangmaaan";
	int maxTries = 10;
	
	/**
	 * Zu Beginn wird das Objekt initialisiert.
	 */
	@Before
	public void setUp() throws Exception {
		testHM = new HangMan(str);
	}

	/**
	 * Die Get-Methode fuer den String word wird gecheckt.
	 * Der Konstruktor wird dabei auch geprueft.
	 */
	@Test
	public void TestGetWord() {
		assertTrue(testHM.getWord() == str);
	}
	
	/**
	 * Die Get-Methode fuer den String noFaults wird gecheckt.
	 */
	@Test
	public void TestGetNoFaults() {
		assertTrue(testHM.getNoFaults() == 0);
	}
	
	/**
	 * Die funktionierende addChar Methode gibt bei dem Parameter 'a' 4 zurueck.
	 */
	@Test
	public void TestaddChar() {
		assertTrue(testHM.addChar('a')==4);
	}
	
	/**
	 * benutzte Buchstaben werden durchsucht und aktuelles Wort mit fehlenden Buchstaben wird zurueckgegeben
	 */
	@Test
	public void Testmask() {
		testHM.addChar('H');
		assertTrue(testHM.mask().equals("H________"));
	}

	/**
	 * Die funktionierende solve Methode gibt bei dem Parameter "Hangmaaan" true zurueck.
	 */
	@Test
	public void Testsolve() {
		assertTrue(testHM.solve(str));
	}
	
	/**
	 * Die funktionierende isOver Methode gibt bei geloestem Hangman true zurueck.
	 */
	@Test
	public void TestisOverWIN() {
   	 	testHM.solve(str);
		assertTrue(testHM.isOver());
	}
	
	/**
	 * Die funktionierende isOver Methode gibt bei verbrauchten Versuchen auch true zurueck.
	 */
	@Test
	public void TestisOverLOSE() {
		for(int i = 0; i < maxTries; i++){
			testHM.addChar('x');
		}
		assertTrue(testHM.isOver());
	}
}
