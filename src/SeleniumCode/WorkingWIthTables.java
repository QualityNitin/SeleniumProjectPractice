package SeleniumCode;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WorkingWIthTables {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.tutorialspoint.com/selenium/practice/webtables.php");
		
		
		
		List<WebElement> headers = driver.findElements(By.xpath("//table/thead/tr/th"));

		System.out.println("Table Headers:");
		for (WebElement header : headers) {
		    System.out.print(header.getText() + " | ");
		}
		System.out.println();
		
		
		List<WebElement> row = driver.findElements(By.xpath("//table/tbody/tr"));
//		System.out.println(row.size());
		
		List<WebElement> cols = null;
		
		for(int i=0;i<row.size();i++)
		{
			cols = row.get(i).findElements((By.tagName("td")));
			
			for(int j=0; j<cols.size();j++)
			{
				System.out.print(cols.get(j).getText() + " | ");
			}
			System.out.println();
		}
		
		
		 driver.quit();
		
	}

}
