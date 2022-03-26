package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {

	abstract WebElement getSearchResultElement(String searchingText);

	public String		URL,
			mailBox,
			mailBoxPass;

	public By			inputSearch;
	public By			btnSearch;

	public By			btnLoginToMailBox;
	
	//public By btnPreAuthorize;
	public By btnAuthorize;
	public By inputEmailLogin;
	public By inputEmailpassword;
	public By fieldActivator; 
	
	/*
	 * @FindBy(xpath = inputSearchXpathLocator)
	 * public WebElement inputSearch;
	 * 
	 * @FindBy(xpath = "//span[contains(@text,'Найти')]//ancestor::button[1]")
	 * public WebElement btnSearch;
	 */

	private WebDriver	driver;

	public WebDriver getDriver() {
		return driver;
	}

	public AbstractPage(WebDriver driver) {
		this.driver = driver;
	}

	public void open() {
		driver.get(URL);
	}
	
	private void click(By by) {
		driver.findElement(by).click();		
	}
	
	public void waitForElement(By element) {
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(element));
	}


	public void search(String searchingText) {
		// inputSearch.sendKeys(searchingText);
		// btnSearch.click();
		driver.findElement(inputSearch).sendKeys(searchingText);
		driver.findElement(btnSearch).click();
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(getSearchResultElement(searchingText)));
	}

	public void loginToMailBox() {
		click(btnLoginToMailBox);
		
		 
		waitForElement(inputEmailLogin);
		
		driver.findElement(inputEmailLogin).sendKeys(mailBox);
	 
		
		try {
			driver.findElement(inputEmailpassword).sendKeys(mailBoxPass);
		} catch (Exception e) {
			//Вариант страниц авторизаций, где нет изначально поля для ввода пароля
			//и чтобы оно появилось, необходимо нажать кнопку ВОЙТИ (вот авторизационная такая ЧУШЬ от Яндекса)
			click(btnAuthorize);
			driver.findElement(inputEmailpassword).sendKeys(mailBoxPass);
		}
		
		//А затем снова Войти! Тестируем не поддающееся тестированию
		click(btnAuthorize);
		
	}



}
