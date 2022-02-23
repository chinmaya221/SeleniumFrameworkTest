package auto;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import utils.HomePage;
import utils.WebDriverUtils;

public class TestBase {

	protected static final String AUTOMATION_OBJECT_PREFIX = "auto";
	protected static final String INFINIVIEW_VALID_USERNAME = "admin@gen-etech.com";
	protected static final String INFINIVIEW_VALID_PASSWORD = "geneAdmin@123";
	protected WebDriverUtils driverUtils;
	protected static WebDriver webdriver;
	protected boolean oneTimeSetUp = true;
	protected boolean oneTimeTearDown = true;
	protected static boolean logSettingUpdated = false;
	protected final Logger logger = Logger.getLogger(TestBase.class);
	protected HomePage homePage;

	@BeforeClass
	public void oneTimeSetUp() throws Exception {
		driverUtils = new WebDriverUtils();
		setSystemOut();
		startWebdriver();
		oneTimeSetUp = false;
		oneTimeTearDown = false;
		webdriver.get(WebDriverUtils.INFINIVIEW_URL);
	}

	public void loginInInfiniview(String userName, String password)
			throws Exception {
		homePage = new HomePage();
		homePage.logon(userName, password);
		Thread.sleep(1*60000);
	}

	private void setSystemOut() throws Exception {
		System.out.println("test class: " + this.getClass().getCanonicalName());
		System.out.println("current time: "
				+ DateFormat.getInstance().format(
						Calendar.getInstance().getTime()));
	}

	protected void startWebdriver() {
		webdriver = WebDriverUtils.startWebDriver();
		webdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@BeforeMethod
	public void setUp() throws Exception {
//		if (oneTimeSetUp) {
//			driverUtils = new WebDriverUtils();
//			setSystemOut();
//			startWebdriver();
//			webdriver.get(WebDriverUtils.INFINIVIEW_URL);
//		}
			driverUtils = new WebDriverUtils();
			setSystemOut();
			startWebdriver();
			webdriver.get(WebDriverUtils.INFINIVIEW_URL);
	}

	public static String getRandomAutomationObjectName() {
		return getRandomAutomationObjectName(AUTOMATION_OBJECT_PREFIX);
	}

	public static String getRandomAutomationObjectName(String customPrefix) {
		return customPrefix + RandomStringUtils.randomAlphanumeric(8);
	}

	// @AfterSuite(alwaysRun = true)
	protected void stopWebdriver() throws Exception {
		if (webdriver != null)
			webdriver.close();
		webdriver.quit();

	}

	@AfterMethod
	public void tearDown() throws Exception {
//		if (oneTimeTearDown) {
//			stopWebdriver();
//		}
			stopWebdriver();
	}

	@AfterClass
	public void oneTimeTearDown() throws Exception {
		stopWebdriver();
	}
}