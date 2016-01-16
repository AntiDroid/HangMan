package Tests;
import Classes.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StringUtilsTest {
	
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * Die Methode funktioniert, wenn sie bei den uebergebenen Parametern "Wort: Hallo" und "Buchstabe l" 2 zurueckgibt
	 */
	@Test
	public void testhowOften() {
		assertTrue(StringUtils.howOften("Hallo", 'l') == 2);
	}

}
