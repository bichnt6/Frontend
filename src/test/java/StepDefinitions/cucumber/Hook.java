package StepDefinitions.cucumber;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hook {
	public static WebDriver driver;

	@Before
	public void BeforeScenario() {
		String webdriver = System.getProperty("browser", "firefox");
		switch (webdriver) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver",
					"D:\\BICHNT6_SELENIUM\\SPGP\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver",
					"D:\\BICHNT6_SELENIUM\\SPGP\\geckodriver-v0.23.0-win32\\geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		default:
			throw new RuntimeException("Unsupported webdriver: " + webdriver);
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
	}

	@After
	public void AfterScenario(Scenario scenario) {
		if (scenario.isFailed()) {
			try {
				byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				scenario.embed(screenshot, "image/png");
			} catch (WebDriverException platformdontsupportscreenshot) {
				System.err.println(platformdontsupportscreenshot.getMessage());
			}
		}
		driver.quit();
	}
}
