package webElements;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

@Test
public class TextBox {
	WebDriver driver;
	@Test
	public void withPlaceHolder() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demoapps.qspiders.com/ui");
		
		driver.findElement(By.xpath("//section[text()='Text Box']")).click();
		
		driver.findElement(By.id("name")).sendKeys("Veera");
		driver.findElement(By.id("email")).sendKeys("veera@gmail.com");
		driver.findElement(By.id("password")).sendKeys("veera123");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//*[name()='svg' and @stroke='currentColor'])[1]")).click();
		driver.findElement(By.xpath("//button[text()='Register']")).click();
		Thread.sleep(2000);
		driver.close();
	}
	
	@Test
	public void withoutPlaceHolder() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demoapps.qspiders.com/ui");
		
		driver.findElement(By.xpath("//li[text()='Without placeholder']")).click();
		
		driver.findElement(By.id("name")).sendKeys("Veera");
		driver.findElement(By.id("email")).sendKeys("veera@gmail.com");
		driver.findElement(By.id("password")).sendKeys("veera123");
		driver.findElement(By.xpath("//button[text()='Register']")).click();
		Thread.sleep(2000);
		driver.close();
	}
	
	@Test
	public void withToolTip() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demoapps.qspiders.com/ui");
		
		driver.findElement(By.xpath("//li[text()='Without placeholder']")).click();
		
		driver.findElement(By.id("name")).sendKeys("Veera");
		driver.findElement(By.id("email")).sendKeys("veera@gmail.com");
		driver.findElement(By.id("password")).sendKeys("veera123");
		driver.findElement(By.xpath("//button[text()='Register']")).click();
		Thread.sleep(2000);
		driver.close();
	}
	
	@Test
	public void multilineTextArea() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demoapps.qspiders.com/ui");
		
		driver.findElement(By.xpath("//li[text()='Multiline Text Area']")).click();
		
		driver.findElement(By.id("name")).sendKeys("Veera");
		driver.findElement(By.id("email")).sendKeys("veera@gmail.com");
		driver.findElement(By.id("password")).sendKeys("veera123");
		driver.findElement(By.xpath("//button[text()='Register']")).click();
		Thread.sleep(2000);
		driver.close();
	}
	
	@Test
	public void disable() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demoapps.qspiders.com/ui");
		
		driver.findElement(By.xpath("//li[text()='Disabled']")).click();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		WebElement name = driver.findElement(By.id("name"));
		js.executeScript("arguments[0].removeAttribute('disabled')", name);
		name.sendKeys("Veera");
		
		WebElement email = driver.findElement(By.id("email"));
		js.executeScript("arguments[0].removeAttribute('disabled')", email);
		email.sendKeys("veera@gmail.com");
		
		WebElement pass = driver.findElement(By.id("password"));
		js.executeScript("arguments[0].removeAttribute('disabled')", pass);
		pass.sendKeys("veera123");
		
		driver.findElement(By.xpath("//button[text()='Register']")).click();	
		Thread.sleep(2000);
		driver.close();
	}
}
