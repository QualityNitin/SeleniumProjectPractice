package SeleniumCode;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FileUpload {

	public static void main(String[] args) throws AWTException, InterruptedException {
		
		WebDriver driver = new ChromeDriver();

        // 2. Navigate to a URL
//        driver.get("https://the-internet.herokuapp.com/");
		driver.get("https://demoqa.com/upload-download");
        driver.manage().window().maximize();
//        WebElement upload = driver.findElement(By.id("file-upload"));
//        upload.sendKeys("D:\\Nitin_InterviewStudyMaterial");	
        
        String filePath = "D:\\Nitin_InterviewStudyMaterial\\Automation Tester PDF.pdf";
        StringSelection selection = new StringSelection(filePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
        
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.id("uploadFile")));
        Thread.sleep(3000);
        driver.findElement(By.id("uploadFile")).click();
        
        Robot rb = new Robot();
        rb.delay(1000);
        rb.keyPress(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_V);
        rb.keyRelease(KeyEvent.VK_V);
        rb.keyRelease(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);
        
        
        driver.findElement(By.id("file-submit")).click();
	}

}
