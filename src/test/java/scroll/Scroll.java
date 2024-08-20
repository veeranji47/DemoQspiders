package scroll;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Scroll {
	
	WebDriver driver;
	Actions actions;
	@Test
	public void newTab() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demoapps.qspiders.com/ui");

		driver.findElement(By.xpath("(//section[text()='Scroll'])[1]")).click();
		driver.findElement(By.xpath("(//section[text()='Scroll'])[2]")).click();
		
		String parentId = driver.getWindowHandle();
		driver.findElement(By.xpath("//a[.='Open In New Tab']")).click();
		Set<String> newWindowId = driver.getWindowHandles();
		for(String ids : newWindowId) {
			if(!parentId.equals(ids)) {
				driver.switchTo().window(ids);
				break;
			}
				
		}
		Thread.sleep(2000);
		WebElement checkBox = driver.findElement(By.xpath("//section[contains(@class,'flex items')]/input[@type='checkbox']"));
		actions = new Actions(driver);
		actions.scrollToElement(checkBox).perform();
		Thread.sleep(1300);
		checkBox.click();
		driver.findElement(By.xpath("//button[.='Accept Our Policy']")).click();
		
		
		}
	@Test
	public void horizontalScroll() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demoapps.qspiders.com/ui");

		driver.findElement(By.xpath("(//section[text()='Scroll'])[1]")).click();
		driver.findElement(By.xpath("(//section[text()='Scroll'])[2]")).click();
		driver.findElement(By.xpath("//a[contains(@href,'newHorizontal')]")).click();
		
		String parentId = driver.getWindowHandle();
		System.out.println(parentId);
		driver.navigate().refresh();
		driver.findElement(By.xpath("//a[.='Open In New Tab']")).click();
		Set<String> newWindowId = driver.getWindowHandles();
		for(String ids : newWindowId) {
			if(!parentId.equals(ids)) {
				driver.switchTo().window(ids);
				break;
			}		
		}
		System.out.println(driver.getWindowHandle());
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(1500, 0);");
		//js.executeScript("window.scrollBy(3500,0);");
		Thread.sleep(2000);
		driver.close();
		
	}
	
	@Test
	public void frameVerticalScroll() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demoapps.qspiders.com/ui");

		driver.findElement(By.xpath("(//section[text()='Scroll'])[1]")).click();
		driver.findElement(By.xpath("(//section[text()='Scroll'])[2]")).click();
		driver.findElement(By.xpath("//section[contains(.,'Within The Frame') and contains(@class,'poppins')]")).click();
		driver.findElement(By.xpath("//a[.='Vertical']")).click();
		
		WebElement frame = driver.findElement(By.xpath("//iframe[contains(@class,'w-full')]"));
		driver.switchTo().frame(frame);
		
		WebElement checkBox = driver.findElement(By.xpath("//section[contains(@class,'flex items')]/input[@type='checkbox']"));
		actions = new Actions(driver);
		actions.scrollToElement(checkBox).perform();
		Thread.sleep(1300);
		checkBox.click();
		driver.findElement(By.xpath("//button[.='Accept Our Policy']")).click();
		
		
		}
	@Test
	public void frameHorizontalScroll() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demoapps.qspiders.com/ui");

		driver.findElement(By.xpath("(//section[text()='Scroll'])[1]")).click();
		driver.findElement(By.xpath("(//section[text()='Scroll'])[2]")).click();
		driver.findElement(By.xpath("//section[contains(.,'Within The Frame') and contains(@class,'poppins')]")).click();
		driver.findElement(By.xpath("//a[.='Horizontal']")).click();
		
		WebElement frame = driver.findElement(By.xpath("//iframe[contains(@class,'w-full')]"));
		driver.switchTo().frame(frame);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(1600,0);");		
		}
}
