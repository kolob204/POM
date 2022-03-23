package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement; 

public class Yandex extends AbstractPage {

	//@FindBy(id = "text")
	//public WebElement inputSearch; 
		
	//@FindBy(xpath = "//span[contains(@text,'Найти')]//ancestor::button[1]")
	//public WebElement btnSearch; 
	
	public Yandex(WebDriver driver) {
		super(driver); 
		URL = "https://yandex.ru/";
		mailBox = "email@yandex.ru";
		mailBoxPass = "pass";
		
		inputSearch = By.id("text");
		btnSearch = By.xpath("//span[contains(.,'Найти')]//ancestor::button[1]");
		
		btnLoginToMailBox = By.xpath("//div[contains(.,'Войти')]/parent::a");		
		btnAuthorize = By.id("passp:sign-in");
		inputEmailLogin = By.id("passp-field-login");
		inputEmailpassword = By.id("passp-field-passwd");
	}
	
	public WebElement getSearchResultElement(String searchingText) {
		return getDriver().findElement(By.xpath("//ul[@aria-label='Результаты поиска']//span[@class='OrganicTitleContentSpan organic__title']/b[contains(.,'"+searchingText+"')]"));		 
	}
	
}
