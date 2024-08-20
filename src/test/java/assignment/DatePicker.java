package assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DatePicker {
	WebDriver driver;

	@Test
	public void defaultDatePicker() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demoapps.qspiders.com/ui");

		driver.findElement(By.xpath("(//section[text()='Date & Time Picker'])")).click();
		driver.findElement(By.xpath("(//section[text()='Date Picker'])")).click();

		driver.findElement(By.xpath("//div[@class='react-datepicker-wrapper']")).click();
		String reqYear = "2024";
		String reqMonth = "Augest";
		String date = "28th";
		driver.findElement(By.xpath("//div[contains(@aria-label,'"+reqMonth+" "+date+", "+reqYear+"')]")).click();
		
		
		
	}

}
