package xpathFuntions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class XpathFunctions {
	WebDriver driver;
	@Test
	public void xpathFUnctions() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.flipkart.com/");
		
		System.out.println(driver.findElement(By.xpath("//a[contains(text(),'Seller')]")).getText());
		System.out.println(driver.findElement(By.xpath("//span[normalize-space()='TVs & Appliances']")).getText());
		System.out.println(driver.findElement(By.xpath("(//span[@class='_1XjE3T']/span[substring(.,1,4)])[2]")).getText());
		System.out.println(driver.findElement(By.xpath("//span[@class='_1XjE3T']/span[text()='Fashion'][string-length('F')]")).getText());
		System.out.println(driver.findElement(By.xpath("//span[text()='Beauty']")).getText());
		System.out.println(driver.findElement(By.xpath("//span[@class='_1XjE3T']/span[text()='TVs & Appliances'][translate('TVs & Appliances','&','||')]")).getText());
	}

}
