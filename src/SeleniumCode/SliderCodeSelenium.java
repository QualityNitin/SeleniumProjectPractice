package SeleniumCode;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SliderCodeSelenium {

	public static void main(String[] args) throws IOException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://practice.expandtesting.com/horizontal-slider");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement slider = driver.findElement(By.className("sliderContainer"));
		
		Actions action = new Actions(driver);
		action.clickAndHold(slider)
				.moveByOffset(50, 0)
				.release()
				.perform();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String Projectpath = System.getProperty("user.dir");
		File destination = new File(Projectpath+"/screenshot/SliderCapture.PNG");
		FileUtils.copyFile(source , destination);
		
		driver.quit();
		
	}

}
