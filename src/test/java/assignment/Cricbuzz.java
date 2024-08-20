package assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Cricbuzz {

	WebDriver driver;
	@Test
	public void newTab() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.cricbuzz.com/");
		driver.findElement(By.xpath("//span[@class='text-normal' and @title='Ireland Women']")).click();
		driver.findElement(By.xpath("//a[text()='Scorecard']")).click();
		String hunterScore = driver.findElement(By.xpath("//a[text()=' Amy Hunter (wk) ']/ancestor::div[contains(@class,'cb-col cb-col-100 cb-s')]/descendant::div[contains(@class,'cb-col cb-col-8 text-right ')]")).getText();
		String rebeccaScore = driver.findElement(By.xpath("//a[text()=' Rebecca Stokell ']/ancestor::div[contains(@class,'cb-col cb-col-100 cb-s')]/descendant::div[contains(@class,'cb-col cb-col-8 text-right ')]")).getText();
		System.out.println("Hunter score :) "+hunterScore);
		System.out.println("Rebecca score :) "+rebeccaScore);	
	}

}
