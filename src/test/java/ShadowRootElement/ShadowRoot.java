package ShadowRootElement;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ShadowRoot {
	WebDriver driver;
	@Test
	public void openShadowRooth(){
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demoapps.qspiders.com/ui");
		
		driver.findElement(By.xpath("//section[text()='Web Elements']")).click();
		driver.findElement(By.xpath("//section[text()='Shadow Root Elements']")).click();
		driver.findElement(By.xpath("(//section[text()='Shadow Root'])")).click();
//		
		WebElement shadowRoot = driver.findElement(By.xpath("(//div[contains(@class,'my-3')])[1]"));
		WebElement parent = shadowRoot.getShadowRoot().findElement(By.xpath("//label[.='Username']"));
		parent.findElement(By.xpath("//input[contains(@placeholder,'Enter your username')]")).sendKeys("Hello");
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		WebElement header = (WebElement) js.executeScript("return arguments[0].shadowRoot", name);
//		header.findElement(By.xpath(""));
		 
		
	}

}
