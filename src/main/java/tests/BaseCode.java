package tests;

public class BaseCode {

	
	public void sleep(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) { 
			e.printStackTrace();
		}
	}
	
}
