import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TestScriptsLibrary extends ProjectFunctionLibrary {
	
	public static void connectToWW() throws IOException, InterruptedException{
		
		
		startReport("Login","/Users/YourProject/eclipse-workspace/AAExampleFramework/Report/");
		mainDriver.driver = new ChromeDriver();
		mainDriver.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		mainDriver.driver.manage().window().maximize();
		mainDriver.driver.get("https://www.weightwatchers.com/us/sitemap");
		
		
		// Select Find a Meeting
		clickObject("//*[@id='find-a-meeting']", "Find a Meeting");
		// Enter Meeting Search
		enterText("//input[@id='meetingSearch']", "10011", "meetingSearch");
		
		bw.close();
		}
	
	
}
