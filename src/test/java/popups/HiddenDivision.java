package popups;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class HiddenDivision {
	
	WebDriver driver;
	@Test
	public void defaultModal() throws InterruptedException {
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demoapps.qspiders.com/ui");

		driver.findElement(By.xpath("//section[text()='Popups']")).click();
		driver.findElement(By.xpath("//section[text()='Hidden division']")).click();
		driver.findElement(By.xpath("(//input[contains(@class,'border-stone')])[1]")).sendKeys("Hello");
		driver.findElement(By.xpath("(//input[contains(@class,'border-stone')])[2]")).sendKeys("abc@gmail.com");
		WebElement product = driver.findElement(By.xpath("//select[contains(@class,'border-stone')]"));
		Select select = new Select(product);
		select.selectByVisibleText("Laptop");
		driver.findElement(By.xpath("//textarea[contains(@class,'border-stone')]")).sendKeys("Welcome to Tek pyramid :)");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		
	}
}
