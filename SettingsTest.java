import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class SettingsTest {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://stackoverflow.com/";
    
    driver.get(baseUrl + "/");
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    driver.findElement(By.xpath("(//a[contains(text(),'log in')])[2]")).click();
    driver.findElement(By.xpath("//div[@id='se-signup-legend']/p/span[2]")).click();
    driver.findElement(By.name("email")).clear();
    driver.findElement(By.name("email")).sendKeys("rol41@pitt.edu");
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("Laboon123");
    driver.findElement(By.id("submit-button")).click();
    
    driver.findElement(By.cssSelector("img.avatar-me.js-avatar-me")).click();
    driver.findElement(By.linkText("Edit Profile & Settings")).click();
    driver.findElement(By.name("DisplayName")).click();
    driver.findElement(By.name("DisplayName")).clear();
    driver.findElement(By.name("DisplayName")).sendKeys("deliverable5");
    Thread.sleep(2000);
    driver.findElement(By.cssSelector("input[type=\"button\"]")).click();
    
  }

  @Test
  public void testChangeName() throws Exception {
	String name;
    driver.findElement(By.cssSelector("img.avatar-me.js-avatar-me")).click();
    driver.findElement(By.linkText("Edit Profile & Settings")).click();
    driver.findElement(By.name("DisplayName")).click();
    driver.findElement(By.name("DisplayName")).clear();
    driver.findElement(By.name("DisplayName")).sendKeys("deliverable5v2");
    Thread.sleep(2000);
    driver.findElement(By.cssSelector("input[type=\"button\"]")).click();
    driver.findElement(By.linkText("Profile")).click();
    name = driver.findElement(By.cssSelector("h2.user-card-name")).getText();
    assertEquals("deliverable5v2", name);
  }

  @Test
  public void testLocation() throws Exception {
	String message;
    driver.get(baseUrl + "/users/edit/4803079");
    driver.findElement(By.name("Location")).clear();
    driver.findElement(By.name("Location")).sendKeys("Pittsburgh");
    Thread.sleep(2000);
    driver.findElement(By.cssSelector("input[type=\"button\"]")).click();
    message = driver.findElement(By.cssSelector("p.val-textemphasis")).getText();
    assertEquals("Your profile has been saved successfully.", message);
  }
  
  @Test
  public void testAboutme() throws Exception {
	  String message;
    driver.get(baseUrl + "/");
    driver.findElement(By.cssSelector("img.avatar-me.js-avatar-me")).click();
    driver.findElement(By.linkText("Edit Profile & Settings")).click();
    driver.findElement(By.id("wmd-input")).click();
    driver.findElement(By.id("wmd-input")).clear();
    driver.findElement(By.id("wmd-input")).sendKeys("Something about me.");
    Thread.sleep(2000);
    driver.findElement(By.cssSelector("input[type=\"button\"]")).click();
    message = driver.findElement(By.cssSelector("p.val-textemphasis")).getText();
    assertEquals("Your profile has been saved successfully.", message);
  }
  
  @Test
  public void testDate() throws Exception {
	String message;
    driver.get(baseUrl + "/");
    driver.findElement(By.cssSelector("img.avatar-me.js-avatar-me")).click();
    driver.findElement(By.linkText("Edit Profile & Settings")).click();
    driver.findElement(By.name("Birthday")).clear();
    driver.findElement(By.name("Birthday")).sendKeys("1993/07/13");
    Thread.sleep(2000);
    driver.findElement(By.cssSelector("input[type=\"button\"]")).click();
    message = driver.findElement(By.cssSelector("p.val-textemphasis")).getText();
    assertEquals("Your profile has been saved successfully.", message);
  }
  
  
  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
