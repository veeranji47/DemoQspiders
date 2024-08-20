package webElements;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class SliderHandle {
WebDriver driver;

	
	@Test
	public void sliderHandle() throws InterruptedException {
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demoapps.qspiders.com/ui");

		driver.findElement(By.xpath("//section[text()='Slider']")).click();
		WebElement slider = driver.findElement(By.xpath("//input[@class=' rangeInputSlidebar']"));
		for( ; ; ) {
			if(slider.getAttribute("value").contains("75"))
				break;
			else {
				slider.sendKeys(Keys.ARROW_RIGHT);
				Thread.sleep(800);
			}
		}
		
	}
}
