import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Sneha.Automation_Exercise.BaseTest;

//import com.Sneha.Automation_exercise.utils.Driver;

public class Initial extends BaseTest {
	

public void initDriver()
{

WebDriver driver=initializeDriver();
driver.get("https://automationexercise.com/");
System.out.println("first here");


}

}
