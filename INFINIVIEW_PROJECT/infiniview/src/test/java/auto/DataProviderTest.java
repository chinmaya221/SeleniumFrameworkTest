package auto;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utils.ExcelUtils;

public class DataProviderTest extends TestBase {

	private final String invalidUserName = "demoUserName";
	private final String invalidPassword = "demoPassword";
	private int sleepTime = 1 * 30000;

	public void setUp() throws Exception {
		super.setUp();
	}

	@Test
	public void testDataProviderWithExcel() throws Exception {
		try {
			ExcelUtils.setExcelFile("Sheet1");
			String sUserName = ExcelUtils.getCellData(1, 1);
			System.out.println("UserName ::::> " + sUserName);
			String sPassword = ExcelUtils.getCellData(1, 2);
			System.out.println("password ::::>" + sPassword);
			loginInInfiniview(sUserName, sPassword);
			Thread.sleep(sleepTime);
			System.out.println("Login Successfull");
			webdriver.navigate().refresh();
			Assert.assertEquals("InifiniView", webdriver.getTitle());
		} catch (Exception ex){
			ExcelUtils.setCellData("Fail", 1, 3);
		} finally {
			homePage.logout();
			ExcelUtils.setCellData("Pass", 1, 3);
		}
	}

	@DataProvider(name = "Credentials")
	public static Object[][] credentials() {
		return new Object[][] { { "admin@gen-etech.com", "geneAdmin@123" },
				{ "invalidUserName", "invalidUserName" } };
	}

	@Test(dataProvider = "Credentials")
	public void testDataProviderWithTestNgAnnotation(String userName,
			String Password) throws Exception {
		System.out.println("UserName :::> " + userName);
		System.out.println("password :::>" + Password);
		if (userName == "invalidUserName") {
			loginInInfiniview(invalidUserName, invalidPassword);
			String invalidErrorMsg = homePage.clickOkOnAlert();
			Assert.assertEquals("Invalid Credentials", invalidErrorMsg);
			Thread.sleep(sleepTime);
		} else {
			loginInInfiniview(userName, Password);
			Thread.sleep(sleepTime);
			System.out.println("Login Successfull");
			webdriver.navigate().refresh();
			Assert.assertEquals("InifiniView", webdriver.getTitle());
			homePage.logout();
		}
	}

	public void tearDown() throws Exception {
		super.tearDown();
	}
}
