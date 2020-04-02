package Commons;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import PageObjects.PageGeneratorManager;
public class DriverManager {

	static WebDriver driver;
	static String chromePath = System.getProperty("user.dir") + "\\src\\test\\resources\\chromedriver.exe";
	static String firefoxPath = System.getProperty("user.dir") + "\\src\\test\\resources\\geckodriver.exe";	

	public static PageGeneratorManager pageGenerator;

	public static WebDriver createDriver(String drivername) {
		driver = initDriver(drivername);
		return driver;
	}

	@SuppressWarnings("deprecation")
	public static WebDriver initDriver(String drivername) {
		if (drivername.equalsIgnoreCase("firefox")) {
			DesiredCapabilities handErr = DesiredCapabilities.firefox();
			handErr.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
			System.setProperty("webdriver.gecko.driver", firefoxPath);
			driver = new FirefoxDriver(handErr);
		} else if (drivername.equalsIgnoreCase("chrome")) {
			DesiredCapabilities handErr = DesiredCapabilities.chrome();
			handErr.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);

			System.setProperty("webdriver.chrome.driver", chromePath);
			driver = new ChromeDriver(handErr);
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		pageGenerator = new PageGeneratorManager();
		
		return driver;
	}
}
