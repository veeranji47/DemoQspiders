package webElements;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FormValidation {
WebDriver driver;

	
	@Test
	public void formValidation() throws InterruptedException {
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demoapps.qspiders.com/ui");

		driver.findElement(By.xpath("//section[text()='FormValidation']")).click();
		driver.findElement(By.name("requiredfield")).sendKeys("Hello");
		driver.findElement(By.name("password")).sendKeys("Hello123");
		driver.findElement(By.name("confirmpass")).sendKeys("Hello123");
		driver.findElement(By.name("email")).sendKeys("hello@gmail.com");
		driver.findElement(By.name("url")).sendKeys("https://www.fb.com");
		driver.findElement(By.name("digits")).sendKeys("12345");
		driver.findElement(By.name("number")).sendKeys("123456");
		driver.findElement(By.name("alphanum")).sendKeys("abc123456");
		driver.findElement(By.name("minLength")).sendKeys("abc1234");
		driver.findElement(By.name("maxLength")).sendKeys("abc123");
		driver.findElement(By.name("rangeLength")).sendKeys("abc12345");
		driver.findElement(By.name("minValue")).sendKeys("8");
		driver.findElement(By.name("maxValue")).sendKeys("5");
		driver.findElement(By.name("rangeValue")).sendKeys("55");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Submit']")).submit();
		
		
	}


}
