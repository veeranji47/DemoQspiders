package KeyboardActions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class VirtualKeyboard {
	WebDriver driver;
	@Test
	public void ratings() throws InterruptedException, AWTException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demoapps.qspiders.com/ui");
		
		driver.findElement(By.xpath("(//section[text()='Keyboard Actions'])")).click();
		driver.findElement(By.xpath("(//section[text()='Virtual Keyboard'])")).click();
		
		driver.navigate().refresh();
		WebElement email = driver.findElement(By.id("email"));
		email.click();
		email.sendKeys("abc@gmail.com");
		driver.findElement(By.xpath("//div[contains(@class,'font-medium')]")).click();
		WebElement password = driver.findElement(By.id("password"));
		password.click();
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyPress(KeyEvent.VK_E);
		robot.keyRelease(KeyEvent.VK_E);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[.='Submit']"));
		
//		String pass = "Veera@123";
//		for(int i = 0; i < pass.length(); i++) {
//			driver.findElement(By.xpath("//div[contains(@class,'hg-rows')]/div/div[contains(@class,'hg-button') and contains(@data-skbtn,'"+pass.charAt(i)+"')]")).click();
//			
//		}
		
	}

}
