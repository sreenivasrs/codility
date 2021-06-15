package test.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;


public class DriverManager {
	
	WebDriver driver;
	String browser;
	
	public WebDriver drivermanager() throws IOException, Exception {

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("src\\test\\resources\\application.properties");
		prop.load(fis);
				
		if((prop.getProperty("browser")).equals("chrome")) {
		ChromeOptions options = new ChromeOptions();
		System.setProperty("webdriver.chrome.driver","src\\test\\resources\\drivers\\chromedriver.exe");
		options.setExperimentalOption("useAutomationExtension", false);
		options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation")); 
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		}
		return driver;
	}
}
