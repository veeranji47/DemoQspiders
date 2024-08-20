package webElements;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Links {
	WebDriver driver;
	@Test
	public void defaultLink() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demoapps.qspiders.com/ui");
		
		driver.findElement(By.xpath("//section[text()='Link']")).click();
		driver.findElement(By.xpath("//a[text()='Default Link']")).click();
		
		List<WebElement> countAllLinks = driver.findElements(By.tagName("a"));
		int size = countAllLinks.size();
		for(int i = 0; i < size; i++) {
			System.out.println(countAllLinks.get(i).getText());
//			Thread.sleep(800);
//			countAllLinks.get(i).click();
//			Thread.sleep(800);
//			System.out.println(driver.getCurrentUrl());
//			System.out.println(driver.getTitle());
//			System.out.println("----------------------------------------");
//			
//			
		}
		
	}
	@Test
	public void defaultClick() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demoapps.qspiders.com/ui");
		
		driver.findElement(By.xpath("//section[text()='Link']")).click();
		
		
	}


}
