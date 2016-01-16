package Tests;
import Classes.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class WordReaderTest {

	WordReader wr;
	String str = "Halloooo";
	
	@Before
	public void setUp() throws Exception {
		wr = new WordReader("TestText");
	}

	/**
	 * Bei erfolgreicher Lokalisierung mithilfe des Konstruktorparameters und Initialisierung kann das Wort 
	 * des Testtext ausgelesen werden.
	 * Die getWords Methode muss dazu natuerlich auch funktionieren.
	 */
	@Test
	public void testKonstruktorANDgetWords() {
		assertTrue(wr.getWords().contains(str));
	}

}
