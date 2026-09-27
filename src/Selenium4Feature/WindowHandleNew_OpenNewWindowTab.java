package Selenium4Feature;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandleNew_OpenNewWindowTab {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://vinothqaacademy.com/mouse-event/");
		
		driver.manage().window().maximize();
		
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
		
//		========== Window Handle - Tab===================	
		
		driver.get("https://vinothqaacademy.com/multiple-windows/");
		
		driver.findElement(By.xpath("//button[contains(text(),'New Browser Tab')]")).click();
		//this click is opening new window
		
		driver.findElement(By.xpath("//h2[text()='Project Details']")).isDisplayed();
		//element of new window
		
	}

}
