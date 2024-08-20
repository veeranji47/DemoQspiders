package mouseActions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class MouseHover {
	WebDriver driver;
	Actions actions;
	@Test
	public void icon() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demoapps.qspiders.com/ui");
		
		driver.findElement(By.xpath("(//section[text()='Mouse Actions'])")).click();
		driver.findElement(By.xpath("(//section[text()='Mouse Hover'])")).click();
		
		WebElement hint = driver.findElement(By.xpath("//div[@class='hidden']"));
		actions = new Actions(driver);
		actions.moveToElement(hint).perform();
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Veera@123");
		Thread.sleep(900);
		
		driver.close();
		
	}

	@Test
	public void image() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demoapps.qspiders.com/ui");
		
		driver.findElement(By.xpath("(//section[text()='Mouse Actions'])")).click();
		driver.findElement(By.xpath("(//section[text()='Mouse Hover'])")).click();
		driver.findElement(By.xpath("//a[contains(@href,'rating?sublist')]")).click();
		
		
		WebElement rating = driver.findElement(By.xpath("//div[contains(@class,'flex justify-center')]/descendant::input[contains(@value,'4')]/../*[name()='svg' and @class='Rating cursor-pointer']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scroll=true", rating);
		actions = new Actions(driver);
		actions.moveToElement(rating).perform();
		Thread.sleep(2000);
		
		driver.close();
		
	}
	
	@Test
	public void ratings() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demoapps.qspiders.com/ui");
		
		driver.findElement(By.xpath("(//section[text()='Mouse Actions'])")).click();
		driver.findElement(By.xpath("(//section[text()='Mouse Hover'])")).click();
		driver.findElement(By.xpath("//a[contains(@href,'mouseHoverimage?sublist')]")).click();
		
		WebElement img = driver.findElement(By.xpath("//img[contains(@src,'orderPlaced-fB7gNxPF.jpg')]"));
		actions = new Actions(driver);
		actions.moveToElement(img).perform();
		WebElement toolTip = driver.findElement(By.xpath("//img[@title='Order Placed Image']"));
		String txt = toolTip.getAttribute("title");
		System.out.println("Tooltip text : "+txt);
		
		Thread.sleep(900);
		
		driver.close();
		
	}

}
