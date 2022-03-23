package pages;

import org.openqa.selenium.WebDriver;

public class WorkPageFactory {

	WebDriver driver;
	 
	public WorkPageFactory(WebDriver driver) {
		this.driver = driver;
	}

 
	public AbstractPage initSite(String site) {
		switch (site) {
		case "yandex":
			return new Yandex(driver);
		 
		case "mail":
			return new Mail(driver);
		default:
			return null; 
		}
	}
}
