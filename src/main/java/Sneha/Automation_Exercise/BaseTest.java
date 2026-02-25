package Sneha.Automation_Exercise;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
 public static WebDriver driver;
   


    /**
     * Initialize WebDriver with Chrome browser
     */
    public WebDriver initializeDriver() {
       // WebDriverManager.chromedriver().setup();
       driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    /**
     * Initialize WebDriver with Firefox browser
     */
    public void initializeDriverFirefox() {
       // WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    /**
     * Initialize WebDriver with Edge browser
     */
    public void initializeDriverEdge() {
       // WebDriverManager.edgedriver().setup();
      driver = new EdgeDriver();
        driver.manage().window().maximize();
    }
   
        
       

    /**
     * Close the WebDriver
     */
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    /**
     * Navigate to URL
     */
    public void navigateToUrl(String url) {
        driver.navigate().to(url);
    }
    
   
}
