package webElements;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Audio {
	WebDriver driver;
	@Test 
	public void disableRadioBtn() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demoapps.qspiders.com/ui");
		
		driver.findElement(By.xpath("//section[text()='Audio']")).click();
		WebElement audio = driver.findElement(By.xpath("//audio[contains(@src,'audiofile-zzjK-tOl.mp3')]"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].play()", audio);
		Thread.sleep(10000);
		js.executeScript("arguments[0].pause()", audio);
		Thread.sleep(2000);
		driver.close();
		
	}
}
