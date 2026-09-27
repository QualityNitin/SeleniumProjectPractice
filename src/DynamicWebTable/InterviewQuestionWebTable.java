package DynamicWebTable;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class InterviewQuestionWebTable {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://demoqa.com/");

		String title = driver.getTitle();

		Assert.assertEquals(title, "demosite");

		driver.findElement(By.xpath("//h5[text()='Forms']")).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Practice Form']")));

		driver.findElement(By.xpath("//span[text()='Practice Form']")).click();
		
		String firstName = "Nitin";
		String lastName = "Gadade";
		String Name = firstName+" "+lastName;
		String gender = "Male";
		String phone = "1234567890";

		driver.findElement(By.id("firstName")).sendKeys(firstName);
		driver.findElement(By.id("lastName")).sendKeys(lastName);
		driver.findElement(By.xpath("//label[text()='" + gender + "']")).click();
		driver.findElement(By.id("userNumber")).sendKeys(phone);
		
		
		WebElement btnSubmit = driver.findElement(By.id("submit"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", btnSubmit);
		
		String actualName = "";
		String actualGender = "";
		String actualPhone = "";
		
		List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));
		
		for(int i=0; i<rows.size();i++)
		{
			List<WebElement> cols = rows.get(i).findElements(By.xpath("td"));
			
			for(int j=0; j<cols.size() ; j++)
			{
				if(cols.get(j).getText().equalsIgnoreCase("Student Name"))
				{
					actualName = cols.get(j+1).getText();
					System.out.println(actualName);
				}
				
				if(cols.get(j).getText().equalsIgnoreCase("Gender"))
				{
					actualGender = cols.get(j+1).getText();
					System.out.println(actualGender);
				}
				
				if(cols.get(j).getText().equalsIgnoreCase("Mobile"))
				{
					actualPhone = cols.get(j+1).getText();
					System.out.println(actualPhone);
				}
			}
			
		}
		
		Assert.assertEquals(Name, actualName,"Name not Matched");
		Assert.assertEquals(phone, actualPhone,"Gender not Matched");
		Assert.assertEquals(gender, actualGender,"Gender not Matched");
		driver.quit();
	}

}
