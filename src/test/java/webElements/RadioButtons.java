package webElements;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class RadioButtons {
	WebDriver driver;
	@Test
	public void defaultRadioBtn() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demoapps.qspiders.com/ui");

		driver.findElement(By.xpath("//section[text()='Radio Button']")).click();
		driver.findElement(By.xpath("//input[@value='Upi']")).click();
		driver.findElement(By.xpath("//input[@value='home']")).click();
		driver.findElement(By.xpath("//button[@id='btn']")).click();
		
		List<WebElement> allRadioBtns = driver.findElements(By.xpath("//input[@type='radio']"));
		System.out.println("All radio buttons are : "+allRadioBtns.size());
		driver.close();	
	}
	@Test
	public void selectedRadioBtn() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demoapps.qspiders.com/ui");
		
		driver.findElement(By.xpath("//section[text()='Radio Button']")).click();
		
		WebElement paymentRDBtn = driver.findElement(By.xpath("//input[@value='Upi']"));
		if(paymentRDBtn.isSelected())
			System.out.println("Selected");
		else
			System.out.println("Not selected");
		
		driver.findElement(By.xpath("//input[@value='home']")).click();
		driver.findElement(By.xpath("//button[@id='btn']")).click();
		driver.close();	
	}
	
	@Test 
	public void disableRadioBtn() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demoapps.qspiders.com/ui");
		
		driver.findElement(By.xpath("//section[text()='Radio Button']")).click();
		driver.findElement(By.xpath("//a[contains(@href,'disabled?sublist')]")).click();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement paymentRBtn =  driver.findElement(By.id("attended31"));
		js.executeScript("arguments[0].disabled=false", paymentRBtn);
		paymentRBtn.click();
		WebElement deliverRBtn =  driver.findElement(By.id("willing21"));
		js.executeScript("arguments[0].disabled=false", deliverRBtn);
		deliverRBtn.click();
		
		driver.findElement(By.id("continuebtn")).click();
		
		driver.close();
		
	}
	

}
