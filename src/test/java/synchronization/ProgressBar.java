package synchronization;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class ProgressBar {
	
	WebDriver driver;
	@Test
	public void defaultProgressBar() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demoapps.qspiders.com/ui");
		
		driver.findElement(By.xpath("(//section[text()='Synchronization'])")).click();
		driver.findElement(By.xpath("(//section[text()='Progress Bar'])")).click();
		
		WebElement startAndStopBtn = driver.findElement(By.xpath("//div[@class='flex justify-center pb-4']/button[contains(@class,'active:border-green-400')]"));
		startAndStopBtn.click();
		
	}
	@Test
	public void withTimerProgressBar() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demoapps.qspiders.com/ui");
		
		driver.findElement(By.xpath("(//section[text()='Synchronization'])")).click();
		driver.findElement(By.xpath("(//section[text()='Progress Bar'])")).click();
		driver.findElement(By.xpath("//a[contains(@href,'timer?sublist')]")).click();
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[contains(@type,'text') and contains(@class,'focus:ring-primary-')]")).sendKeys("5");
		String percentage = driver.findElement(By.xpath("//div[@class='relative pt-1']/descendant::span[contains(@class,'text-xs font')]")).getText();
		WebElement startAndStopBtn = driver.findElement(By.xpath("//div[@class='flex justify-center pb-4']/button[contains(@class,'active:border-green-400')]"));
		startAndStopBtn.click();
		String text = startAndStopBtn.getText();
//		while(true) {
//			if(text.equals("start")) {
//				Thread.sleep(2000);
//				System.out.println(percentage);
//				startAndStopBtn.click();
//			}
//			else if(text.equals("stop")) {
//				startAndStopBtn.click();
//				Thread.sleep(2000);
//				System.out.println(percentage);
//			}
//		}
		
	}
	@Test
	public void withElementProgressBar() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demoapps.qspiders.com/ui");
		
		driver.findElement(By.xpath("(//section[text()='Synchronization'])")).click();
		driver.findElement(By.xpath("(//section[text()='Progress Bar'])")).click();
		driver.findElement(By.xpath("//a[contains(@href,'element?sublist')]")).click();
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[contains(@type,'text') and contains(@class,'focus:ring-primary-')]")).sendKeys("2");
		String percentage = driver.findElement(By.xpath("//div[@class='relative pt-1']/descendant::span[contains(@class,'text-xs font')]")).getText();
		WebElement startAndStopBtn = driver.findElement(By.xpath("//div[@class='flex justify-center pb-4']/button[contains(@class,'active:border-green-400')]"));
		startAndStopBtn.click();
		String text = startAndStopBtn.getText();
		
		WebElement ele = driver.findElement(By.xpath("//select[contains(@class,'placeholder-blueGray')]"));
		Select select = new Select(ele);
		Thread.sleep(800);
		select.selectByVisibleText("Yes");
		Thread.sleep(1000);
		
		driver.close();
		
	}

}
