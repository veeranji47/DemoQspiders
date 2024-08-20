package popups;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BrowserWindow {
	WebDriver driver;
	@Test
	public void newWindow() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demoapps.qspiders.com/ui");

		driver.findElement(By.xpath("//section[text()='Popups']")).click();
		driver.findElement(By.xpath("//section[text()='Browser Windows']")).click();
		
		String parentWindowid = driver.getWindowHandle();
		driver.findElement(By.id("browserLink1")).click();
		Set<String> multiIds = driver.getWindowHandles();
		for(String ids : multiIds) {
			if(!parentWindowid.equals(ids)) {
				driver.switchTo().window(ids);
				break;
			}
		}
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("veera@gmail.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("veera123");
		driver.findElement(By.xpath("//input[@id='confirm-password']")).sendKeys("veera123");
		driver.findElement(By.xpath("//button[text()='Sign Up']")).click();
		
		driver.switchTo().window(parentWindowid);
	
	}
	
	@Test
	public void newTab() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demoapps.qspiders.com/ui");

		driver.findElement(By.xpath("//section[text()='Popups']")).click();
		driver.findElement(By.xpath("//section[text()='Browser Windows']")).click();		
		driver.findElement(By.xpath("//a[contains(@href,'newTab?sublist')]")).click();
		
		String parentWindowid = driver.getWindowHandle();
		driver.findElement(By.id("browserButton4")).click();

		Set<String> multipleWindowids = driver.getWindowHandles();
		for(String ids : multipleWindowids) {
			if(!parentWindowid.equals(ids)) {
				driver.switchTo().window(ids);
				break;
			}
		}
		
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("veera@gmail.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("veera123");
		driver.findElement(By.xpath("//input[@id='confirm-password']")).sendKeys("veera123");
		driver.findElement(By.xpath("//button[text()='Sign Up']")).click();
		driver.close();
		driver.switchTo().window(parentWindowid);
		
	}
	
	@Test
	public void multipleWindows() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demoapps.qspiders.com/ui");

		driver.findElement(By.xpath("//section[text()='Popups']")).click();
		driver.findElement(By.xpath("//section[text()='Browser Windows']")).click();
		driver.findElement(By.xpath("//a[contains(@href,'multipleWindow?sublist')]")).click();
		
		String parentWindowid = driver.getWindowHandle();
		driver.findElement(By.id("browserButton3")).click();
		Set<String> multipleWindowids = driver.getWindowHandles();
		String url = "https://demoapps.qspiders.com/ui/browser/Login";
		for(String ids : multipleWindowids) {
			if(!parentWindowid.equals(ids)) {
				driver.switchTo().window(ids);
				System.out.println( driver.getCurrentUrl());
				Thread.sleep(950);
				if(url.equals(driver.getCurrentUrl())) {
					System.out.println( driver.getWindowHandle());
					break;
				}else {
					driver.close();
				}	
			}
			
		}
		
		driver.findElement(By.id("username")).sendKeys("veera");
		driver.findElement(By.id("password")).sendKeys("veera123");
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		driver.close();
		driver.switchTo().window(parentWindowid);
		
		
		
	}
	
	@Test
	public void multipleTabs() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demoapps.qspiders.com/ui");

		driver.findElement(By.xpath("//section[text()='Popups']")).click();
		driver.findElement(By.xpath("//section[text()='Javascript']")).click();
		driver.findElement(By.xpath("//a[contains(@href,'prompt?sublist')]")).click();
		
	}

}
