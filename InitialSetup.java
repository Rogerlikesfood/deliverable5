import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.firefox.FirefoxDriver;

public class InitialSetup {
	// The amount of time allowed for the WebDriver to poll the DOM when trying to find an element
	// or elements if they are not immediately available (in seconds).
	private static final int IMPLICIT_WAIT_TIMEOUT = 30;
	
	public static FirefoxDriver firefoxDriver;
	
	/*
	 * Annotating a public static void no-arg method with @BeforeClass causes it to be run once
	 * before any of the test methods in the class. The @BeforeClass methods of superclasses will
	 * be run before those of the current class.
	 * 
	 * Opens the Firefox browser and sets the implicit wait timeout to 30 seconds.
	 */
	@BeforeClass
	public static void openBrowserAndSetImplicitWaitTimeout() {
		firefoxDriver = new FirefoxDriver();
		firefoxDriver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT_TIMEOUT, TimeUnit.SECONDS);
	}
	
	/*
	 
	 * Closes the previously opened Firefox browser.
	 */
	@AfterClass
	public static void closeBrowser() {
		firefoxDriver.quit();
	}
}