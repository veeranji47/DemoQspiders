package webElements;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Image {
	WebDriver driver;
	@Test
	public void defaultImg() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demoapps.qspiders.com/ui");
		
		driver.findElement(By.xpath("(//section[text()='Image'])")).click();
		WebElement img = driver.findElement(By.xpath("//img[contains(@src,'orderPlaced-fB7gNxPF.jpg')]"));
		
		Dimension dsize =img.getSize();
		System.out.println("Height of imgage : "+dsize.getHeight()+"\n"+"width of image : "+dsize.getWidth());
	}
	
	@Test
	public void linkImg() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demoapps.qspiders.com/ui");
		
		driver.findElement(By.xpath("(//section[text()='Image'])")).click();
		driver.findElement(By.xpath("//a[contains(@href,'linkImage?sublist')]")).click();
		
		List<WebElement> img = driver.findElements(By.xpath("//img[@alt='broken image']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		for(int i = 0; i < img.size(); i++) {
			//WebElement ele = driver.findElement(By.xpath("//img[@alt='broken image']"+"["+i+"]"));
			//img.get(i).click();
			Thread.sleep(900);
			js.executeScript("arguments[0].click()", img.get(i));
			Thread.sleep(900);
			driver.navigate().back();
			Thread.sleep(600);
		}
		
		
	}

}
