package DynamicWebTable;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PrintTable {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.get("https://practice.expandtesting.com/dynamic-table");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		List<WebElement> headings = driver.findElements(By.xpath("//table/thead/tr/th"));
		System.out.println(headings.size());

		for (int i = 0; i < headings.size(); i++) {
			System.out.print(headings.get(i).getText() + "	|	");

		}
		System.out.println();

		List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));

		for (int i = 0; i < rows.size(); i++) {
			List<WebElement> cols = rows.get(i).findElements(By.xpath("td"));

			for (int j = 0; j < cols.size(); j++) {
				System.out.print(cols.get(j).getText() + "	|	");
			}
			System.out.println();
		}

		driver.quit();
	}

}
