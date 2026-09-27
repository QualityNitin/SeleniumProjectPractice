package SeleniumCode;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandlingNewVersion {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		driver.manage().window().maximize();
		
		
		// Selenium 3  code
//		String parentWindow = driver.getWindowHandle();
//		driver.findElement(By.id("newTabBtn")).click();
//		Set<String> childWindow = driver.getWindowHandles();
//		
//		for(String window : childWindow)
//		{
//			if(!window.equals(parentWindow))
//			{
//				driver.switchTo().window(window);
//			}
//		}
//		
//		driver.findElement(By.xpath("//span[text()='Buy me a coffee']")).click();
//		driver.switchTo().window(parentWindow);
//		driver.quit();
		
		// Selenium 4  code
		driver.findElement(By.id("newTabBtn")).click();
		driver.switchTo().newWindow(WindowType.WINDOW);
		
	}

}
