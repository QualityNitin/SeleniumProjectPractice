package SeleniumCode;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class LaunchCode {

	public static void main(String[] args) {
		
		
		WebDriver driver = new ChromeDriver();
		
		

        // 2. Navigate to a URL
        driver.get("https://artoftesting.com/samplesiteforselenium");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(10 , TimeUnit.SECONDS);
        driver.findElement(By.linkText("This is a link")).click();
        Actions action = new Actions(driver);
//        driver.findElement(By.id("dblClkBtn")).click();
        
        WebElement element = driver.findElement(By.id("dblClkBtn"));
        
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        
        action.doubleClick(driver.findElement(By.id("dblClkBtn"))).perform();
        
        System.out.println("Double click performed successfully.");
        
        driver.switchTo().alert().accept();
        System.out.println("Alert handled");
        
//        driver.close();
        driver.quit();
	}

}
