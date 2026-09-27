package SeleniumInterviewCodePractice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ReadAndWriteFromProportiesFile {

	public static void main(String[] args) throws IOException {

		WebDriver driver = new ChromeDriver();
		
		
		System.out.println(System.getProperty("user.dir"));
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/TestDataExternalFiles/Data.properties");
		prop.load(fis);
		
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		String url = prop.getProperty("url");
		
		System.out.println("Username : "+username +" "+"Password : "+password);
		
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.numberOfWindowsToBe(4));
		
		driver.findElement(By.id("submit")).click();
		
		driver.findElement(By.className("post-title")).isDisplayed();
		
		
		prop.setProperty("status", "success");
		prop.setProperty("Tester", "Nitin Gadade");
		FileOutputStream fio = new FileOutputStream(System.getProperty("user.dir")+"/Data.properties");
		prop.store(fio, "status added");
		
		driver.quit();		
	}

}
