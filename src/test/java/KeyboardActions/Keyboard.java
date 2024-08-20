package KeyboardActions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Keyboard {
	WebDriver driver;
	@Test
	public void ratings() throws InterruptedException, AWTException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demoapps.qspiders.com/ui");
		
		driver.findElement(By.xpath("(//section[text()='Keyboard Actions'])")).click();
		driver.findElement(By.xpath("(//section[text()='Keyboard'])")).click();
		
		driver.navigate().refresh();
		WebElement email = driver.findElement(By.id("email"));
		email.click();
		email.sendKeys("abc@gmail.com");

//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].value='abc@gmail.com';", email);

		driver.findElement(By.id("password")).sendKeys("Veera@123");
		driver.findElement(By.id("confirmPassword")).sendKeys("Veera@123");
		driver.findElement(By.xpath("//button[.='Press Enter to Submit']")).submit();
		
	}

}
