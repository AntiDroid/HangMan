package Tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ HangManManagerTest.class,
		HangManTest.class, StringUtilsTest.class, WordReaderTest.class })
public class AllTests {

}
