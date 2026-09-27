package TestNgPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;

public class sampleTest {
		
	    public void testMethod() {
	        System.out.println("TestNG Project Created");
	    }
		
	    
		@Test(dataProvider = "loginTestCase")
		public void loginTestName(String username, String password) {
			
			WebDriver driver = new ChromeDriver();
		    driver.get("https://www.saucedemo.com");

		    driver.findElement(By.id("user-name")).sendKeys(username);
		    driver.findElement(By.id("password")).sendKeys(password);
		    driver.findElement(By.id("login-button")).click();
		    
		    driver.quit();
		}
		
		@DataProvider(name = "loginTestCase")
		public Object[][] loginTest()
		{
			return new Object[][] 
			{
				{"standard_user","secret_sauce"},
				{"locked_out_user","secret_sauce"}
			};
			
		}
				
		
		
		
	}
