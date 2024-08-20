package popups;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FileUpload {
	
	WebDriver driver;
	@Test
	public void fileUpload() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demoapps.qspiders.com/ui");

		driver.findElement(By.xpath("//section[text()='Popups']")).click();
		driver.findElement(By.xpath("//section[text()='File Uploads']")).click();
		
		WebElement fileUpload = driver.findElement(By.id("fileInput"));
		fileUpload.click();
		fileUpload.sendKeys("‪C:\\Users\\ASHOK KUMAR\\Desktop\\hlo.docx");
		
		
	}

}
