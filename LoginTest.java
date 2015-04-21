import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class LoginTest {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  private WebElement errorMessage;

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://stackoverflow.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testLogin() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.xpath("(//a[contains(text(),'log in')])[2]")).click();
    driver.findElement(By.xpath("//div[@id='se-signup-legend']/p/span[2]")).click();
    driver.findElement(By.name("email")).clear();
    driver.findElement(By.name("email")).sendKeys("rol41@pitt.edu");
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("Laboon123");
    driver.findElement(By.id("submit-button")).click();
  }
  
  @Test
  public void testWrongPW() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.xpath("(//a[contains(text(),'log in')])[2]")).click();
    driver.findElement(By.xpath("//div[@id='se-signup-legend']/p/span[2]")).click();
    driver.findElement(By.name("email")).clear();
    driver.findElement(By.name("email")).sendKeys("rol41@pitt.edu");
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("Laboon");
    driver.findElement(By.id("submit-button")).click();
    errorMessage = driver.findElement(By.cssSelector("div[class='message-text']"));
	assertEquals("The password is incorrect.", errorMessage.getText());
  }
  
  @Test
  public void testNoPW() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.xpath("(//a[contains(text(),'log in')])[2]")).click();
    driver.findElement(By.xpath("//div[@id='se-signup-legend']/p/span[2]")).click();
    driver.findElement(By.name("email")).clear();
    driver.findElement(By.name("email")).sendKeys("rol41@pitt.edu");
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.id("submit-button")).click();
    errorMessage = driver.findElement(By.cssSelector("div[class='message-text']"));
	assertEquals("Password cannot be empty.", errorMessage.getText());
  }
  
  
  @Test
  public void testWrongEmail() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.xpath("(//a[contains(text(),'log in')])[2]")).click();
    driver.findElement(By.xpath("//div[@id='se-signup-legend']/p/span[2]")).click();
    driver.findElement(By.name("email")).clear();
    driver.findElement(By.name("email")).sendKeys("rol42@pitt.edu");
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("Laboon123");
    driver.findElement(By.id("submit-button")).click();
    errorMessage = driver.findElement(By.cssSelector("div[class='message-text']"));
	assertEquals("We could not find an account for that email address.", errorMessage.getText());
  }
  
  @Test
  public void testNoEmail() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.xpath("(//a[contains(text(),'log in')])[2]")).click();
    driver.findElement(By.xpath("//div[@id='se-signup-legend']/p/span[2]")).click();
    driver.findElement(By.name("email")).clear();
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("Laboon123");
    driver.findElement(By.id("submit-button")).click();
    errorMessage = driver.findElement(By.cssSelector("div[class='message-text']"));
	assertEquals("Email cannot be empty.", errorMessage.getText());
  }
  
  

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }


}
