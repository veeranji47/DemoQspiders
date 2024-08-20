package webElements;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Checkboxes {
	WebDriver driver;
	
	@Test
	public void defaultCheckbox() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demoapps.qspiders.com/ui");

		driver.findElement(By.xpath("//section[text()='Check Box']")).click();
		driver.findElement(By.xpath("//input[@id='domain2']")).click();
		driver.findElement(By.xpath("//input[@id='mode2']")).click();
		driver.findElement(By.xpath("//input[@id='mode5']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@id='mode6' and @value='Continue']")).click();
	}
	
	@Test
	public void selectedCheckbox() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demoapps.qspiders.com/ui");

		driver.findElement(By.xpath("//section[text()='Check Box']")).click();
		driver.findElement(By.xpath("//a[contains(@href,'selected?sublist')]")).click();
		
		WebElement reciverNotiCheckbox =  driver.findElement(By.id("domain1"));
		if(reciverNotiCheckbox.isSelected()) {
			System.out.println("Selected");
		}else
			System.out.println("Not selected");
		
		driver.findElement(By.id("mode1")).click();
		driver.findElement(By.id("mode5")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@id='mode6' and @value='Continue']")).click();
	}
	
	@Test
	public void disableCheckbox() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demoapps.qspiders.com/ui");

		driver.findElement(By.xpath("//section[text()='Check Box']")).click();
		driver.findElement(By.xpath("//a[contains(@href,'disabled?sublist')]")).click();
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		WebElement whatsappCheckBox = driver.findElement(By.xpath("//input[@id='domain2']"));
		js.executeScript("arguments[0].disabled=false;", whatsappCheckBox);
		whatsappCheckBox.click();
		WebElement shoeCheckBox = driver.findElement(By.xpath("//input[@id='mode2']"));
		js.executeScript("arguments[0].disabled=false;", shoeCheckBox);
		shoeCheckBox.click();
		WebElement sameCheckBox = driver.findElement(By.xpath("//input[@id='mode5']"));
		js.executeScript("arguments[0].disabled=false;", sameCheckBox);
		sameCheckBox.click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@id='mode6' and @value='Continue']")).click();
	}
	

}
