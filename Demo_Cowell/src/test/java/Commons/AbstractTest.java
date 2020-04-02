package Commons;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.Reporter;


public class AbstractTest {

	public static Logger log;

	public AbstractTest() {
		log = LogManager.getLogger(getClass());
	}

	public boolean verifyTrue(boolean condition) {
		try {
			Assert.assertTrue(condition);
			log.info(" --- PASSED ---");
			
			return true;
		} catch (Throwable e) {
			log.info(" --- FAILED ---");
			Reporter.getCurrentTestResult().setThrowable(e);

			return false;
			// TODO: Log error message into Log file
		}
	}

	public boolean verifyFalse(boolean condition) {
		try {
			Assert.assertFalse(condition);
			log.info(" --- PASSED ---");
			return true;
		} catch (Throwable e) {
			log.info(" --- FAILED ---");
			Reporter.getCurrentTestResult().setThrowable(e);
			return false;
			// TODO: handle exception
		}
	}

	public boolean verifyEquals(Object expected, Object actual) {
		try {
			Assert.assertEquals(actual, expected);
			log.info(" --- PASSED ---");
			return true;
		} catch (Throwable e) {
			log.info(" --- FAILED ---");
			Reporter.getCurrentTestResult().setThrowable(e);
			return false;
			// TODO: handle exception
		}
	}	
}
