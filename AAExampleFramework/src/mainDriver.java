import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class mainDriver {

	public static String reportFlag = "Pass";
	public static WebDriver driver;
	
	public static void main(String[] args) throws IOException, InterruptedException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		// TODO Auto-generated method stub


		System.setProperty("webdriver.chrome.driver", "/Users/YourFolder/eclipse-workspace/AAExampleFramework/chromedriver");
		driver = new ChromeDriver();


		String testScriptName = "connectToWW";
		Method testCase = TestScriptsLibrary.class.getMethod(testScriptName);
		testCase.invoke(testCase);
				
	}

}
