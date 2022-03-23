package tests;
 
import org.testng.annotations.Test;

import pages.AbstractPage;
import pages.WorkPageFactory;

public class Test001 extends BaseTest {


	WorkPageFactory factory = new WorkPageFactory(getWebDriver());
    AbstractPage activeSite = factory.initSite(System.getProperty("site"));
    
	@Test 
	public void test1() {
	 
		activeSite.open();
		
		activeSite.search("Авто");
		activeSite.loginToMailBox();
		
		sleep(10000);
	}
}
