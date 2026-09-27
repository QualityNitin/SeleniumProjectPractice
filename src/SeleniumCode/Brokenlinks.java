package SeleniumCode;

import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Brokenlinks {

	public static void main(String[] args) 
	{
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Total number of links : "+links.size());
	
		int brokenLinksCount = 0;
		
		for(WebElement link : links)
		{
			String url = link.getAttribute("href");
			
			if(url == null || url.isEmpty())
			{
				System.out.println("Link is empty or null");
			}
			
			try
			{
				URL urllink = new URL(url);
				HttpURLConnection urlcon = (HttpURLConnection) urllink.openConnection();
				urlcon.setConnectTimeout(3000);
				urlcon.connect();
				
				int responseCode = urlcon.getResponseCode();
				
				if(responseCode >= 400)
				{
					System.out.println(url + " --> BROKEN ("
                            + responseCode + ")");
                    brokenLinksCount++;
				}
				else
				{
					System.out.println(url + " --> VALID ("
                            + responseCode + ")");
				}
				
				
			}
			catch(Exception e)
			{
				System.out.println(url + " --> Exception occurred");
			}
			
			
		}
		System.out.println("Broken Link Count is :"+brokenLinksCount);
		driver.quit();
	}

}
