package GlobalVariables;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class test1 {

		public WebDriver driver=null;
		
		@Test
		public void Login() throws IOException, InterruptedException{
			
			Properties prop= new Properties();
			FileInputStream fis = new FileInputStream("C:\\Users\\rodri\\Documents\\TestNGTutorial\\src\\GlobalVariables\\datavalues.properties");
			prop.load(fis);
			
			//GLOBAL VARIABLE: BROWSER
			if(prop.getProperty("browser").contains("chrome")) {
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\rodri\\Documents\\Selenium JARs & WebDrivers\\WebDrivers\\chromedriver.exe");
				driver= new ChromeDriver();	
			}
			else if(prop.getProperty("browser").contains("firefox")) {
				System.setProperty("webdriver.gecko.driver", "C:\\Users\\rodri\\Documents\\Selenium JARs & WebDrivers\\WebDrivers\\geckodriver.exe");
				driver= new FirefoxDriver();	
			}
			else {
				System.setProperty("webdriver.ie.driver", "C:\\Users\\rodri\\Documents\\Selenium JARs & WebDrivers\\WebDrivers\\IEDriverServer.exe");
				driver= new InternetExplorerDriver();	
			}
			
			//GLOBAL VARIABLE: URL
			driver.get(prop.getProperty("URL"));
			Thread.sleep(3);
			
			//GLOBAL VARIABLE: NAME
			System.out.println(prop.getProperty("name"));
			driver.quit();
			}	
	}
		
