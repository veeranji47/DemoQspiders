package popups;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Download {
	
	WebDriver driver;
	@Test
	public void defaultModal() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demoapps.qspiders.com/ui");

		driver.findElement(By.xpath("//section[text()='Popups']")).click();
		driver.findElement(By.xpath("//section[text()='Download ']")).click();
		driver.findElement(By.id("writeArea")).sendKeys("Hello");
		WebElement file = driver.findElement(By.id("fileName"));
		file.clear();
		file.sendKeys("hello.txt");
		driver.findElement(By.id("downloadButton")).click();
		
		
	}

}
