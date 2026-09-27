package Selenium4Feature;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ActionClassMethods {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://vinothqaacademy.com/mouse-event/");
		
		driver.manage().window().maximize();
		
		// Drag for one element to another element 
		
		WebElement drag = driver.findElement(By.id("dragItem"));
		WebElement drop = driver.findElement(By.id("dropZone"));
		
		Actions action = new Actions(driver);
		action.dragAndDrop(drag, drop).perform();
		
		String dragStatus = driver.findElement(By.id("dragStatus")).getText();
		Assert.assertEquals(dragStatus, "Dropped Successfully");
		
		// Double click method 
		
		WebElement ddclick = driver.findElement(By.id("dblclick"));
		action.doubleClick(ddclick).perform();
		
		// Right click method 
		
		WebElement rightClick = driver.findElement(By.id("rightclick"));
		action.contextClick(rightClick).perform();
		
		// Menu sub menu mouse hover element
		
		WebElement dd1 = driver.findElement(By.xpath("(//a[contains(text(),'About Me')])[2]"));
		WebElement dd2 = driver.findElement(By.xpath("(//a[contains(text(),'Online Training Feedback')])[2]"));
		
//		Action hoverOverMenu = action.moveToElement(dd1).moveToElement(dd2).click().build();
//		hoverOverMenu.perform();
		
//		action.moveToElement(dd1).moveToElement(dd2).click().perform();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		action.moveToElement(dd1).perform();           // Hover
		wait.until(ExpectedConditions.visibilityOf(dd2)); // Wait for submenu
		action.click(dd2).perform();                   // Click
		
		driver.findElement(By.xpath("//h2[contains(text(),'Corporate Company')]")).isDisplayed();
		
		// Canvas
		
		// WheelInput
		
		// Alternative for drag and drop
		
		//scroll method
		
		
		
		driver.quit();
	}

}
