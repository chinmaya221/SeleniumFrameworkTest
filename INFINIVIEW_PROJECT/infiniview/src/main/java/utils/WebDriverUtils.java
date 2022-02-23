package utils;

import java.io.File;
import java.util.concurrent.TimeUnit;
import com.google.common.base.Function;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;

public class WebDriverUtils {

	private static WebDriver webDriver = null;
	public static boolean willwait = false;

	public static final int ELEMENT_GENERAL_WAIT_TIME = 60;

	protected static final String SCREENSHOT_LOCATION = SystemConfig.getProperty("maven.testng.output.dir");

	public static final String INFINIVIEW_URL = "http://10.21.0.108:9000/InfiniView/index.html#/index/signIn";

	public WebDriverUtils() throws Exception {
		getDriver();
	}

	public static WebDriver getDriver() {
		return webDriver;
	}

	public static WebDriver startWebDriver() {
		if (SystemConfig.BROWSER_TYPE.contains("firefox")) {
			ProfilesIni profile = new ProfilesIni();
			FirefoxProfile firefoxProfile = profile.getProfile("C:\\Personal\\seleniumProfile");
			webDriver = new FirefoxDriver(firefoxProfile);
			webDriver.manage().window().maximize();
			return webDriver;
		} else if (SystemConfig.BROWSER_TYPE.contains("chrome")) {
			if (SystemConfig.OS_TYPE.contains("mac")){
				System.setProperty("webdriver.chrome.driver", SystemConfig.USER_CONFIG + "/chromedriver");
			} else {
				System.setProperty("webdriver.chrome.driver", SystemConfig.USER_CONFIG + "/chromedriver.exe");
			}
			ChromeOptions options = new ChromeOptions();
			//options.addArguments("start-maximized", "forced-maximize-mode", "--kiosk", "--disable-extensions");
			DesiredCapabilities capabilities = new DesiredCapabilities(DesiredCapabilities.chrome());
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			webDriver = new ChromeDriver(capabilities);
			webDriver.manage().window().maximize();
			return webDriver;
		} else if (SystemConfig.BROWSER_TYPE.contains("ie")) {
			System.setProperty("webdriver.ie.driver", SystemConfig.USER_CONFIG + "/IEDriverServer.exe");
			DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
			caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			caps.setCapability("ignoreZoomSetting", true);
			webDriver = new InternetExplorerDriver(caps);
			webDriver.manage().window().maximize();
			return webDriver;
		}
		return null;
	}

	public boolean isElementPresent(By by, int timeoutSeconds) {
		// we do this so it is slightly more responsive. half a second here and
		// half a second there adds up over hundreds of tests.
		int halfSeconds = timeoutSeconds * 2;

		for (int halfSecond = 0;; halfSecond++) {
			try {
				if (webDriver.findElement(by) != null) {
					return true;
				}
			} catch (NotFoundException e) {
				// if the page is refreshing while we're checking the text, it
				// will throw an exception, which we can safely ignore
			}

			if (halfSecond >= halfSeconds) {
				return false;
			}

			try {
				Thread.sleep(500);
			} catch (InterruptedException interruption) {
				// ignore it
			}
		}
	}

	public boolean isElementPresent(By by) {
		return isElementPresent(by, WebDriverUtils.ELEMENT_GENERAL_WAIT_TIME);
	}

	public void waitForElement(By by, int timeoutInSeconds) {
//		Assert.assertTrue(isElementPresent(by, timeoutInSeconds),
//				"The element " + by + " did not appear in " + timeoutInSeconds + " seconds");
	}

	public void waitForElement(By by) {
		waitForElement(by, WebDriverUtils.ELEMENT_GENERAL_WAIT_TIME);
	}

	public void getscreenshot() throws Exception {
		File scrFile = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("/target/surefire-reports/screenshot.png"));
	}

	public void waitForElement(WebElement element, int timeoutInSeconds) {
//		Assert.assertTrue(isElementPresent(element, timeoutInSeconds),
//				"The element " + element + " did not appear in " + timeoutInSeconds + " seconds");
	}

	public boolean isElementPresent(WebElement element, int timeoutSeconds) {
		boolean isPresent = false;

		int halfSeconds = timeoutSeconds * 2;
		for (int halfSecond = 0;; halfSecond++) {
			try {
				if (element.isDisplayed() & element.isEnabled()) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				return true;
			} catch (NoSuchElementException e) {
	            System.out.println("NoSuchElementException" + e.getMessage());
			}

			if (halfSecond >= halfSeconds) {
				return isPresent;
			}

			try {
				Thread.sleep(500);
			} catch (InterruptedException interruption) {
	            System.out.println("InterruptedException" + interruption.getMessage());
			}
		}
	}
	
	public void assertElementPresent(WebElement element, int timeoutSeconds) {
		boolean isPresent = false;
		int halfSeconds = timeoutSeconds * 2;
		for (int halfSecond = 0;; halfSecond++) {
			try {
				if (element.isDisplayed() & element.isEnabled()) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				isPresent = true;
				return;
			} catch (NoSuchElementException e) {
	            System.out.println("NoSuchElementException" + e.getMessage());
			}

			if (halfSecond >= halfSeconds) {
				isPresent = false;
				return;
			}

			try {
				Thread.sleep(500);
			} catch (InterruptedException interruption) {
	            System.out.println("InterruptedException" + interruption.getMessage());
			}
			//Assert.assertTrue(isPresent, "Expected element not found in the page");
			isPresent = false;
		}
	}
	
	public boolean isElementPresent(WebElement webelement) {	
		boolean exists = false;
		webDriver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);

		try {
			webelement.getTagName();
			exists = true;
		} catch (NoSuchElementException e) {
			// nothing to do.
		}
		webDriver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
		return exists;
	}


	public void assertElementEnabled(final WebElement element) {
		// WebDriverWait wait = new WebDriverWait(webdriver,
		// ConsoleUtils.ELEMENT_GENERAL_WAIT_TIME);
		// wait.until(ExpectedConditions.visibilityOfElementLocated((By)
		// element));
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(webDriver);
		wait.pollingEvery(30, TimeUnit.SECONDS);
		wait.withTimeout(2, TimeUnit.MINUTES);
		wait.ignoring(NoSuchElementException.class);

		Function<WebDriver, WebElement> function = new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver arg0) {
				if (element != null) {
					System.out.println("A new dynamic object is found.");
				}
				return element;
			}
		};

		wait.until(function);
		//Assert.assertTrue(element.isEnabled(), element + "is not enabled for edit");
	}

	public void waitForPageLoaded() {
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete");
			}
		};
		Wait<WebDriver> wait = new WebDriverWait(webDriver, 30000);
		try {
			wait.until(expectation);
		} catch (Throwable error) {
		}
	}
}