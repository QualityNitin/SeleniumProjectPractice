package SeleniumCode;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotCode {

	public static void main(String[] args) throws IOException {

		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.google.com/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		
		String ActualTitle = driver.getTitle();
		String expectedTitle = "Google";
		
		Assert.assertEquals(ActualTitle, expectedTitle);
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String Projectpath = System.getProperty("user.dir");
		File destination = new File(Projectpath+"/screenshot/Another.PNG");
		FileUtils.copyFile(source , destination);
		
		driver.quit();
	}

}
