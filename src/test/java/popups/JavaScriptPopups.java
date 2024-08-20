package popups;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class JavaScriptPopups {
	
	WebDriver driver;
	Alert alert;
	@Test 
	public void defaultAlert() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demoapps.qspiders.com/ui");

		driver.findElement(By.xpath("//section[text()='Popups']")).click();
		driver.findElement(By.xpath("//section[text()='Javascript']")).click();
		
		driver.findElement(By.id("buttonAlert2")).click();
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		driver.close();	
	}
	@Test 
	public void confirmAlert() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demoapps.qspiders.com/ui");

		driver.findElement(By.xpath("//section[text()='Popups']")).click();
		driver.findElement(By.xpath("//section[text()='Javascript']")).click();
		driver.findElement(By.xpath("//a[contains(@href,'confirm?sublist')]")).click();
		
		driver.findElement(By.id("buttonAlert5"));
		Thread.sleep(900);
		driver.switchTo().alert().dismiss();
		Thread.sleep(2000);
		driver.close();	
	}
	@Test 
	public void promptAlert() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demoapps.qspiders.com/ui");

		driver.findElement(By.xpath("//section[text()='Popups']")).click();
		driver.findElement(By.xpath("//section[text()='Javascript']")).click();
		driver.findElement(By.xpath("//a[contains(@href,'prompt?sublist')]")).click();
		
		driver.findElement(By.id("buttonAlert1")).click();
		alert = driver.switchTo().alert();
		Thread.sleep(900);
		alert.sendKeys("yes");
		Thread.sleep(900);
		alert.accept();
		Thread.sleep(900);
		String promptText = driver.findElement(By.xpath("//p[contains(text(),'You selected')]")).getText();
		Thread.sleep(900);
		System.out.println(promptText);
		Thread.sleep(2000);
		driver.close();	
	}


}
