package webElements;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Toggle {
	WebDriver driver;
	@Test
	public void disabledToggles() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demoapps.qspiders.com/ui");

		driver.findElement(By.xpath("//section[text()='Toggle']")).click();
		driver.findElement(By.xpath("//a[contains(@href,'disabled?sublist')]")).click();
		
		driver.navigate().refresh();
		List<WebElement> fields = driver.findElements(By.xpath("//label[contains(@class,'inline-flex items-center cursor')]/span/input[@type='checkbox']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		for(WebElement options : fields) {
			js.executeScript("arguments[0].removeAttribute('disabled')", options);
			js.executeScript("arguments[0].click()", options);
			Thread.sleep(900);
		}
		
		//driver.findElement(By.xpath("//label[contains(@class,'inline-flex items-center cursor-pointer')]"));
		
		driver.findElement(By.id("togglers")).click();
	}
	@Test
	public void defaultToggles() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demoapps.qspiders.com/ui");

		driver.findElement(By.xpath("//section[text()='Toggle']")).click();
		List<WebElement> fields = driver.findElements(By.xpath("//label[contains(@class,'inline-flex items-center cursor-pointer')]"));
		
		for(WebElement options : fields) {
			options.click();
			Thread.sleep(900);
		}
		
		driver.findElement(By.id("togglers")).click();
	}
	

}
