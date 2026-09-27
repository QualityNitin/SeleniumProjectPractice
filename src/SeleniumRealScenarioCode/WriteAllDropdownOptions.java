package SeleniumRealScenarioCode;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WriteAllDropdownOptions {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("file:///D:/Nitin_InterviewPreparation_12Sep2026/Program/test.html");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

		WebElement ddDown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("country")));

		String text = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h2"))).getText();
		System.out.println(text);

		Select dropdown = new Select(ddDown);

		List<WebElement> lists = dropdown.getOptions();

		wait.until(ExpectedConditions.visibilityOfAllElements(lists));

		HashMap<String, Integer> map = new HashMap<String, Integer>();

		for (WebElement option : lists) {
			String ele = wait.until(ExpectedConditions.visibilityOf(option)).getText();
			if (map.containsKey(ele)) {
				map.put(ele, map.get(ele) + 1);
			} else {
				map.put(ele, 1);
			}
		}

		for (Map.Entry<String, Integer> entry : map.entrySet()) {

			System.out.println(entry.getKey() + "= " + entry.getValue());

		}

		driver.close();

	}

}
