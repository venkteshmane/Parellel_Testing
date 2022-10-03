package multiple_Browser_Launch_Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.Reporter;
import org.testng.annotations.*;

public class Launch_Firefox_And_ChromeTogether {

	static {
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\user\\Downloads\\geckodriver-v0.31.0-win64\\geckodriver.exe");
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\user\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
	}
	WebDriver driver;

	@Test
	@Parameters("browser")
	public void browserSetup(String browserName) throws InterruptedException {

//		if(browserName.equalsIgnoreCase("Chrome")) {
//			System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Downloads\\chromedriver_win32\\chromedriver.exe");
//			driver = new ChromeDriver();
//		}
//		
//		else if(browserName.equalsIgnoreCase("Firefox")) {
//			System.setProperty("webdriver.gecko.driver", "C:\\Users\\user\\Downloads\\geckodriver-v0.31.0-win64\\geckodriver.exe");
//			driver = new FirefoxDriver(); 
//		}
//		driver.manage().window().maximize();
//		driver.get("https://www.bookswagon.com/login");
//		
//		driver.close();
//	}
//}

//		Reporter.log(browser, true);
		if (browserName.equals("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
		}

//		FileInputStream configPath = new FileInputStream(
//				"C:\\Users\\user\\eclipse-workspace\\Multiple_Browser_Launch\\src\\main\\java\\com\\main\\qa\\config\\config.properties");
		Properties prop = new Properties();
//		prop.load(configPath);
//		String url = prop.getProperty("https://www.bookswagon.com/login");
		driver.get("https://www.bookswagon.com/login");
		WebElement un = driver.findElement(By.xpath("//input[@id='ctl00_phBody_SignIn_txtEmail']"));
//		WebElement pwd = driver.findElement(By.xpath("//input[@id='ctl00_phBody_SignIn_txtPassword']"));
		for (int i = 0; i < 10; i++) {
			un.sendKeys("9527872718" + i);
//			pwd.sendKeys("Venky@18" + i);
			Thread.sleep(2000);
			un.clear();
		}
		driver.close();
	}
}