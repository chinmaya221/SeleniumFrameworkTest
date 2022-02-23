package auto;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import utils.HomePage;

public class LoginTest extends TestBase {

	private final String invalidUserName = "demoUserName";
	private final String invalidPassword = "demoPassword";

	public void setUp() throws Exception {
		super.setUp();
	}

	@Test
	public void testLoginWithValidCredentials() throws Exception {
		loginInInfiniview(INFINIVIEW_VALID_USERNAME, INFINIVIEW_VALID_PASSWORD);
		Thread.sleep(3*60000);
		webdriver.navigate().refresh();
		Assert.assertEquals("InifiniView", webdriver.getTitle());
		homePage.logout();
	}

	@Test
	public void testLoginWithInValidCredentials() throws Exception {
		loginInInfiniview(invalidUserName, invalidPassword);
		String invalidErrorMsg = homePage.clickOkOnAlert();
		Assert.assertEquals("Invalid Credentials", invalidErrorMsg);
		Thread.sleep(1 * 60000);
	}

	@Test
	public void testSubmitButtonDisabledAfterLoadPage() throws Exception {
		Assert.assertFalse(
				webdriver.findElement(By.xpath("//button[@type='submit']"))
						.isEnabled(),
				"Submit button is enable after loading page");
	}

	public void tearDown() throws Exception {
		super.tearDown();
	}
}
