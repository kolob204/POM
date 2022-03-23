package tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;


public class BaseTest extends BaseCode {

	private final String CHROMEDRIVERLOCALPATH = System.getProperty("user.dir")+ "\\webdriver\\chromedriver.exe";
	private final String YANDEXDRIVERLOCALPATH = System.getProperty("user.dir")+ "\\webdriver\\yandexdriver.exe";
	
	private final Duration defaultTimeout = Duration.ofSeconds(10); 
	
	//https://chromedriver.storage.googleapis.com/index.html
	//https://github.com/yandex/YandexDriver/releases
	private WebDriver webDriver;

	public WebDriver getWebDriver() {
		return webDriver;
	}

	@BeforeTest
	public void setUp() {
		switch (System.getProperty("browser")) {
		 
		case "chrome"  -> {
			System.setProperty("webdriver.chrome.driver", CHROMEDRIVERLOCALPATH);
			webDriver = new ChromeDriver();	 }
		
		case "yandex"-> {
			System.setProperty("webdriver.chrome.driver", YANDEXDRIVERLOCALPATH);
			webDriver = new ChromeDriver();
		}
			
		default-> {}
		}
		
		configureBrowserOptions();
	}
	
	private void configureBrowserOptions() {
		webDriver.manage().timeouts().implicitlyWait(defaultTimeout);
		
	}

	@BeforeClass
	public void prepareBeforeClass() {
		//webDriver.get(URL);
	}
	 
	@AfterSuite
	public void tearDown() {		
		webDriver.close();
		webDriver.quit();
	}
	
	
	public void wait(int sec) {
		try {
			webDriver.wait(sec);
		} catch (InterruptedException e) {			 
			System.out.println(e.toString());
		}
	}
	
	
}
