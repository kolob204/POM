package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement; 

public class Mail extends AbstractPage {

	public Mail(WebDriver driver) {
		super(driver); 
		URL = "https://mail.ru/"; 
		mailBox = "email@mail.ru";
		mailBoxPass = "pass";
		
		inputSearch = By.id("q");
		btnSearch = By.id("search:submit"); 
		
		btnLoginToMailBox = By.xpath("//button[contains(@class,'ph-login')]");
		btnAuthorize = By.xpath("//button[@data-test-id='submit-button']");
	 
		fieldActivator= By.id( "//div[@data-test-id='login-app-ready']");   
		inputEmailLogin = By.xpath("//input[@name='username']"); // //input[@placeholder='Имя аккаунта']
		inputEmailpassword = By.xpath("//input[@placeholder='Пароль']");
	} 
	 
	public WebElement getSearchResultElement(String searchingText) {
		return getDriver()
				//.findElement(By.xpath("//h3[@class='AdvSnippet-title']/a/b[contains(.,'"+searchingText+"')]"));
				.findElement(By.xpath("//div[@id='layout']//a[contains(.,'"+searchingText+"')]"));
				
	}

}
