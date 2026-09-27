package DynamicWebTable;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class ReadDynamicCPUusage {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.get("https://practice.expandtesting.com/dynamic-table");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		List<WebElement> headers = driver.findElements(By.xpath("//table/thead/tr/th"));
		System.out.println(headers.size());
		
		int cpuColumnIndex = 0;

		for (int i = 0; i < headers.size(); i++) {
			if (headers.get(i).getText().trim().equalsIgnoreCase("CPU")) {
				cpuColumnIndex = i;
				break;
			}
		}

		List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));

		System.out.println(rows.size());

		List<WebElement> cols = null;
		
		String chromeCpu = null;
		
		for (int i = 0; i < rows.size(); i++) {

			cols = rows.get(i).findElements(By.tagName("td"));

			for (int j = 0; j < cols.size(); j++) {

				if (cols.get(j).getText().equals("Chrome")) {

					chromeCpu = cols.get(cpuColumnIndex).getText().trim();
					System.out.println("Chrome CPU Load: " + chromeCpu);
					break;

				}
			}

		}
		
		String lblchromeCpu = driver.findElement(By.id("chrome-cpu")).getText();
		
		Assert.assertTrue(lblchromeCpu.contains(chromeCpu), "CPU matched");
		
		driver.quit();
		
		
		
	}

}
