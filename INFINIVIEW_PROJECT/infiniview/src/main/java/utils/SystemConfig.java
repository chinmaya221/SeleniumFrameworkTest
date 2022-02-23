package utils;

/**
 * This class provides a centralized point to reference system configuration
 * properties required by tests.
 */

public class SystemConfig extends TestProperties {

	public static final boolean SELENIUM_ENABLED = getBoolean("test.selenium.enabled");

	public static final String BROWSER_TYPE = getProperty("browsertype");
	
	public static final String USER_CONFIG = "src/test/java/config/";

	public static final String OS_TYPE = System.getProperty("os.name").toLowerCase();

}
