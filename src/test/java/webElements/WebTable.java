package webElements;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WebTable {
	WebDriver driver;

	@Test
	public void staticWebTable() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demoapps.qspiders.com/ui");

		driver.findElement(By.xpath("//section[text()='Web Table']")).click();
		String colData = driver.findElement(By.xpath("//td[text()='4.5 Star']")).getText();
		System.out.println(colData);

		List<WebElement> tHead = driver.findElements(
				By.xpath("//table[contains(@class,'w-full text-sm text-left text-gray-500 ')]/thead/tr/th"));
		for (WebElement list : tHead) {
			System.out.print(list.getText() + "\t");
		}
		System.out.println();
		List<WebElement> tBody = driver
				.findElements(By.xpath("//table[contains(@class,'w-full text-sm text-left text-gray-500 ')]/tbody/tr"));
		for (WebElement listData : tBody) {
			System.out.println(listData.getText() + "\t");
		}
		
		driver.close();

	}

	@Test
	public void dynamicWebTable() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demoapps.qspiders.com/ui");

		driver.findElement(By.xpath("//section[text()='Web Table']")).click();

		driver.findElement(By.xpath("//a[contains(@href,'dynamicTable')]")).click();

		String iphoneCost = driver.findElement(By.xpath("//th[text()='Apple iPhone']/../td[4]")).getText();
		System.out.println(iphoneCost);

		List<WebElement> dHead = driver.findElements(By.xpath("//table[contains(@class,'full text')]/thead/tr/th"));
		for (WebElement dListHead : dHead) {
			System.out.print(dListHead.getText() + "\t");
		}
		System.out.println();
		List<WebElement> dynTblBody = driver.findElements(By.xpath("//table[contains(@class,'full text')]/tbody/tr"));
		for (WebElement dListData : dynTblBody) {
			System.out.println(dListData.getText() + "\t");
		}

		driver.close();
	}

	@Test
	public void tableWithSort() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demoapps.qspiders.com/ui");

		driver.findElement(By.xpath("//section[text()='Web Table']")).click();
		driver.findElement(By.xpath("//a[contains(@href,'tableSort')]")).click();

		String hpRating = driver.findElement(By.xpath("//td[text()='4.5']")).getText();
		System.out.println(hpRating);

		List<WebElement> dHead = driver.findElements(By.xpath("//table[contains(@class,'full text')]/thead/tr/th"));
		for (WebElement dListHead : dHead) {
			System.out.print(dListHead.getText() + "\t");
		}
		System.out.println();
		List<WebElement> dynTblBody = driver.findElements(By.xpath("//table[contains(@class,'full text')]/tbody/tr"));
		for (WebElement dListData : dynTblBody) {
			System.out.println(dListData.getText() + "\t");
		}

		driver.close();

	}

	@Test
	public void tablePagination() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demoapps.qspiders.com/ui");

		driver.findElement(By.xpath("//section[text()='Web Table']")).click();

		driver.findElement(By.xpath("//a[contains(@href,'tablePagination')]")).click();

		String hpRating = driver.findElement(By.xpath("//td[text()='4.5 Star']")).getText();
		System.out.println(hpRating);

		List<WebElement> pages = driver.findElements(By.xpath("//li[contains(@class,'cursor-pointer bg-orange')]"));
		for (int i = 0; i < pages.size(); i++) {
			List<WebElement> dHead = driver.findElements(By.xpath("//table[contains(@class,'full text')]/thead/tr/th"));
			for (WebElement dListHead : dHead) {
				System.out.print(dListHead.getText() + "\t");
			}
			System.out.println();
			List<WebElement> dynTblBody = driver
					.findElements(By.xpath("//table[contains(@class,'full text')]/tbody/tr"));
			for (WebElement dListData : dynTblBody) {
				System.out.println(dListData.getText() + "\t");
			}
			pages.get(i).click();
		}

		driver.close();

	}

	@Test
	public void tableWithCheckbox() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demoapps.qspiders.com/ui");

		driver.findElement(By.xpath("//section[text()='Web Table']")).click();
		driver.findElement(By.xpath("//a[contains(@href,'tableWithCheck')]")).click();

		WebElement smg = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
		smg.click();
		driver.findElement(By.id("deleteButton")).click();
		driver.findElement(By.xpath("//button[@id='deleteModalCheck']")).click();
		
		List<WebElement> allCheckboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
		for(int i = 0; i < allCheckboxes.size(); i++) {
			allCheckboxes.get(i).click();
		}
		driver.findElement(By.id("deleteButton")).click();
		driver.findElement(By.xpath("//button[@id='deleteModalCheck']")).click();

		driver.close();

	}

}
