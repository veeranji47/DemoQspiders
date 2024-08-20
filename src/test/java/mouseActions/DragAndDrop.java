package mouseActions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DragAndDrop {
	
	WebDriver driver;
	Actions actions;
	@Test
	public void defaultDragAndDrop() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demoapps.qspiders.com/ui");

		driver.findElement(By.xpath("(//section[text()='Mouse Actions'])")).click();
		driver.findElement(By.xpath("(//section[text()='Drag & Drop'])")).click();
		
		actions = new Actions(driver);
		WebElement drag = driver.findElement(By.xpath("//div[.='Drag Me' and contains(@class,'react-draggable')]"));
		actions.dragAndDropBy(drag, 177, -66).perform();
		
		
		
		Thread.sleep(2000);
		driver.close();
		
		
		
	}
	@Test
	public void dragPosition() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demoapps.qspiders.com/ui");
		
		driver.findElement(By.xpath("(//section[text()='Mouse Actions'])")).click();
		driver.findElement(By.xpath("(//section[text()='Drag & Drop'])")).click();
		driver.findElement(By.xpath("//a[contains(@href,'dragToCorrect?sublist')]")).click();
		
		WebElement mblcharger = driver.findElement(By.xpath("//div[.='Mobile Charger']"));
		WebElement lapcharger = driver.findElement(By.xpath("//div[.='Laptop Charger']"));
		WebElement mblcover = driver.findElement(By.xpath("//div[.='Mobile Cover']"));
		WebElement lapcover = driver.findElement(By.xpath("//div[.='Laptop Cover']"));
		WebElement mblAccessorie = driver.findElement(By.xpath("//div[contains(@class,'drop-column')]/div[.='Mobile Accessories']"));
		WebElement lapAccessorie = driver.findElement(By.xpath("//div[contains(@class,'drop-column')]/div[.='Laptop Accessories']"));
		actions = new Actions(driver);
		actions.dragAndDrop(mblcharger, mblAccessorie).perform();
		actions.dragAndDrop(mblcover, mblAccessorie).perform();
		actions.dragAndDrop(lapcharger, lapAccessorie).perform();
		actions.dragAndDrop(lapcover, lapAccessorie).perform();
		
	
		
	}
	@Test
	public void dragMultliple() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demoapps.qspiders.com/ui");
		
		driver.findElement(By.xpath("(//section[text()='Mouse Actions'])")).click();
		driver.findElement(By.xpath("(//section[text()='Drag & Drop'])")).click();
		driver.findElement(By.xpath("//a[contains(@href,'dragToMultiple?sublist')]")).click();
		
		//WebElement mblcharger = driver.findElement(By.xpath("//div[.='Mobile Charger']"));
		WebElement lapcharger = driver.findElement(By.xpath("//div[.='Laptop Charger']"));
		//WebElement mblcover = driver.findElement(By.xpath("//div[.='Mobile Cover']"));
		WebElement lapcover = driver.findElement(By.xpath("//div[.='Laptop Cover']"));
		WebElement mblAccessorie = driver.findElement(By.xpath("//div[contains(@class,'drop-column')]/div[.='Mobile Accessories']"));
		WebElement lapAccessorie = driver.findElement(By.xpath("//div[contains(@class,'drop-column')]/div[.='Laptop Accessories']"));
		
		List<WebElement> mblparts = driver.findElements(By.xpath("//div[@id ='dragElement2' or @id = 'dragElement4']"));
		actions = new Actions(driver);
		for(int i = 0; i < mblparts.size(); i++) {
			actions.dragAndDrop(mblparts.get(i), mblAccessorie).release().perform();
			Thread.sleep(900);
		}
		
		
		
	}

}
