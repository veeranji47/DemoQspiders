package mouseActions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ClickAndHold {
	WebDriver driver;
	Actions actions;
	@Test
	public void defaultDragAndDrop() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demoapps.qspiders.com/ui");

		driver.findElement(By.xpath("(//section[text()='Mouse Actions'])")).click();
		driver.findElement(By.xpath("(//section[text()='Click & Hold'])")).click();
		
		actions = new Actions(driver);
		WebElement click = driver.findElement(By.id("circle"));
		actions.clickAndHold(click).perform();
		Thread.sleep(2000);
		actions.release(click).perform();
		Thread.sleep(1000);
		
		driver.close();
		
		
		
	}

}
