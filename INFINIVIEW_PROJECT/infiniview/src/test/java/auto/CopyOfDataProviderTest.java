package auto;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utils.ExcelUtils;

public class CopyOfDataProviderTest extends TestBase {

	private final String invalidUserName = "demoUserName";
	private final String invalidPassword = "demoPassword";

	public void setUp() throws Exception {
		super.setUp();
	}

	@Test
	public void testDataProviderWithExcel() throws Exception {
		ExcelUtils.setExcelFile("Sheet1");
		String sUserName = ExcelUtils.getCellData(1, 1);
		System.out.println("UserName" + sUserName);
		String sPassword = ExcelUtils.getCellData(1, 2);
		System.out.println("password" + sPassword);
		ExcelUtils.setCellData("Pass", 1, 3);
	}

	@DataProvider(name = "Credentials")
	public static Object[][] credentials() {
		return new Object[][] { { "admin@gen-etech.com", "geneAdmin@123" },
				{ "invalidUserName", "invalidUserName" } };
	}

	@Test(dataProvider = "Credentials")
	public void testDataProviderWithTestNgAnnotation(String userName,
			String Password) throws Exception {
		System.out.println("UserName" + userName);
		System.out.println("password" + Password);
	}

	public void tearDown() throws Exception {
		super.tearDown();
	}
}
