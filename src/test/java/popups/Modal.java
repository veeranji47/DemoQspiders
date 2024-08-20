package popups;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Modal {
	
	WebDriver driver;
	@Test
	public void defaultModal() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demoapps.qspiders.com/ui");

		driver.findElement(By.xpath("//section[text()='Popups']")).click();
		driver.findElement(By.xpath("//section[text()='Modal']")).click();
		
		driver.findElement(By.id("modal1")).click();
		Thread.sleep(900);
		driver.findElement(By.id("closeModal")).click();
		Thread.sleep(900);
		driver.close();
	}
	
	@Test
	public void multipleModel() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demoapps.qspiders.com/ui");
		
		driver.findElement(By.xpath("//section[text()='Popups']")).click();
		driver.findElement(By.xpath("//section[text()='Modal']")).click();
		driver.findElement(By.xpath("//a[contains(@href,'multiModal?sublist')]")).click();
		driver.findElement(By.id("multiModalButton")).click();
		Thread.sleep(900);
		
		driver.findElement(By.id("multiClosemodal")).click();
		Thread.sleep(900);
		String secModel = driver.findElement(By.xpath("//h3[text()='secondary Modal']")).getText();
		if(secModel.contains("secondary"))
			System.out.println("Secondary model :)");
		else
			System.out.println("not opened secondary model :");
		
		driver.findElement(By.xpath("(//button[text()='close'])[1]")).click();
		Thread.sleep(900);
		driver.findElement(By.id("multiclose2")).click();
		Thread.sleep(900);
		driver.close();
	}

}
