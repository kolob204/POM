package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement; 

public class Rambler extends AbstractPage {

 
	public Rambler(WebDriver driver) {
		super(driver); 
		URL = "https://www.rambler.ru/";
		mailBox = "podonok204@rambler.ru";
		mailBoxPass = "P@ssw0rd";
		
		inputSearch = By.xpath("//input[@placeholder='Поиск по интернету']");
		btnSearch = By.xpath("//button[@class='rui__K3edI rui__3Mzuh']");
		
		btnLoginToMailBox = By.xpath("//button[@data-cerber-id='login_form::main::login_button']");		
		btnAuthorize = By.id("passp:sign-in");
		inputEmailLogin = By.id("login");
		inputEmailpassword = By.id("password");
	}
	
	public WebElement getSearchResultElement(String searchingText) {
		return getDriver().findElement(By.xpath("//h2/a/b[contains(.,'"+searchingText+"')]"));		 
	}
	
}
