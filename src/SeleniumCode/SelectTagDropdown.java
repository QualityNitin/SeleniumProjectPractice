package SeleniumCode;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class SelectTagDropdown {

	public static void main(String[] args) {

		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		driver.navigate().to("https://demoqa.com/select-menu");
		
//		Select dropdown = new Select(driver.findElement(By.id("oldSelectMenu")));
//		dropdown.selectByValue("5");
//		
//		
//		////b[text()='Multiselect drop down']//parent::p//following-sibling::div
//		/// 
//		
//		
//		driver.findElement(By.id("react-select-4-input")).sendKeys("green");
//		drive
		
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 
		// Click the multi-select dropdown
        WebElement dropdown = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//div[contains(@class,'css-1hwfws3')]")
                )
        );

        dropdown.click();

        // Select Green
        WebElement green = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.id("react-select-4-input"))
                
        );

        green.sendKeys("green");

        System.out.println("Green selected successfully");

	}

}
