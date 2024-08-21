package frames;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Iframe {
	WebDriver driver;
	@Test
	public void defaultFrame() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demoapps.qspiders.com/ui");
		
		driver.findElement(By.xpath("(//section[text()='Mouse Actions'])")).click();
		driver.findElement(By.xpath("(//section[text()='Frames'])")).click();
		driver.findElement(By.xpath("(//section[text()='iframes'])")).click();
		
		WebElement frame = driver.findElement(By.xpath("//iframe[@class='w-full h-96']"));
		driver.switchTo().frame(frame);
		
		driver.findElement(By.id("username")).sendKeys("Veera R");
		driver.findElement(By.id("password")).sendKeys("Veera@123");
		driver.findElement(By.id("submitButton")).click();
		
		Thread.sleep(2000);
		driver.quit();
		
	}
	@Test
	public void nestedIframe() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demoapps.qspiders.com/ui");
		
		driver.findElement(By.xpath("(//section[text()='Mouse Actions'])")).click();
		driver.findElement(By.xpath("(//section[text()='Frames'])")).click();
		driver.findElement(By.xpath("(//section[text()='iframes'])")).click();
		driver.findElement(By.xpath("//a[contains(@href,'nested?sublist')]")).click();
		
		WebElement frame = driver.findElement(By.xpath("//iframe[@class='w-full h-96']"));
		driver.switchTo().frame(frame);
		driver.findElement(By.xpath("//div[contains(@class,'form_container')][1]"));
		driver.switchTo().frame(0);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement name = driver.findElement(By.id("email"));
		name.click();
		js.executeScript("arguments[0].value='admin@gmail.com';", name);
//		driver.findElement(By.id("password")).sendKeys("Veera@123");
//		driver.findElement(By.id("submitButton")).click();
		
		
		
	}

}
