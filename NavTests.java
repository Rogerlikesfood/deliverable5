import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class NavTests {
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
    
  }

  @Test
  public void testNavQuestions() throws Exception {
	String currentURL;
	driver.get(baseUrl + "/");
    driver.findElement(By.id("nav-questions")).click();
    currentURL = driver.getCurrentUrl();
    assertEquals("https://stackoverflow.com/questions", currentURL);
    
  }
  
  @Test
  public void testNavTags() throws Exception {
	  String currentURL;
    driver.get(baseUrl + "/");
    driver.findElement(By.id("nav-tags")).click();
	  currentURL = driver.getCurrentUrl();
	  assertEquals("https://stackoverflow.com/tags", currentURL);
    
  }
  
  @Test
  public void testNavUsers() throws Exception {
	String currentURL;
	driver.get(baseUrl + "/");
    driver.findElement(By.id("nav-users")).click();
    currentURL = driver.getCurrentUrl();
    assertEquals("https://stackoverflow.com/users", currentURL);
    
  }
  
  @Test
  public void testNavBadges() throws Exception {
	String currentURL;
	driver.get(baseUrl + "/");
    driver.findElement(By.id("nav-badges")).click();
    currentURL = driver.getCurrentUrl();
    assertEquals("https://stackoverflow.com/help/badges", currentURL);
    
  }
 
  @Test
  public void testNavUnanswered() throws Exception {
	String currentURL;
	driver.get(baseUrl + "/");
    driver.findElement(By.id("nav-unanswered")).click();
    currentURL = driver.getCurrentUrl();
    assertEquals("https://stackoverflow.com/unanswered", currentURL);
    
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
