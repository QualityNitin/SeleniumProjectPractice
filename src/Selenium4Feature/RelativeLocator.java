package Selenium4Feature;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class RelativeLocator {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://vinothqaacademy.com/mouse-event/");
		
		driver.manage().window().maximize();
		
		
//		========== Relative locater ===================
		
		WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(5));
		WebElement heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[contains(text(),'Context Click')]")));
		
		Actions action = new Actions(driver);
		WebElement button = driver.findElement(with(By.tagName("button")).below(heading));
		
		action.doubleClick(button).perform();
		
		String ActionName = driver.findElement(By.id("demo")).getText();
		System.out.println(ActionName);
		
		driver.quit();
		
//		========== Window Handle - Window===================		

		String originalWindowHandle = driver.getWindowHandle();
		
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("https://www.cricbuzz.com");
		driver.close();
		driver.switchTo().window(originalWindowHandle); // Switches focus back
		
//		========== Window Handle - Tab===================		

		
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://www.cricbuzz.com");
		driver.close();
		driver.switchTo().window(originalWindowHandle); // Switches focus back
		
		
		
	}

}
