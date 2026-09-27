package TestNgPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderAnotherClass 
{
	
	@Test(dataProvider = "loginTestCase" , dataProviderClass = sampleTest.class)
	public void loginTest(String username, String password) {
		
		WebDriver driver = new ChromeDriver();
	    driver.get("https://www.saucedemo.com");

	    driver.findElement(By.id("user-name")).sendKeys(username);
	    driver.findElement(By.id("password")).sendKeys(password);
	    driver.findElement(By.id("login-button")).click();
	    
	    driver.quit();
	}
	
	

}
