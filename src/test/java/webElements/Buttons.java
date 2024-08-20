package webElements;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Buttons {
	WebDriver driver;
	Actions actions;
	@Test
	public void defaultClick() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demoapps.qspiders.com/ui");
		
		driver.findElement(By.xpath("//section[text()='Button']")).click();
		
		WebElement satisfiedBtn = driver.findElement(By.xpath("//button[@id='btn']"));
		actions = new Actions(driver);
		actions.click(satisfiedBtn).perform();
		String text = driver.findElement(By.xpath("//span[text()='You selected \"Yes\"']")).getText();
		
		if(text.contains("Yes"))
			System.out.println("Yes button Selected :) ");
		else
			System.out.println("Button not NotSelected :( ");
		
		WebElement concernBtn = driver.findElement(By.id("btn3"));
		actions.click(concernBtn).perform();
		
		driver.findElement(By.id("btn7")).click();
	}
	
	@Test
	public void rightClick() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demoapps.qspiders.com/ui");
		
		driver.findElement(By.xpath("//section[text()='Button']")).click();
		
		driver.findElement(By.xpath("//a[text()='Right Click']")).click();
		
		WebElement sfRightClickBtn = driver.findElement(By.id("btn30"));
		
		actions = new Actions(driver);
		
		actions.contextClick(sfRightClickBtn).perform();
		WebElement rightYes = driver.findElement(By.xpath("//div[text()='Yes']"));
		String yes = rightYes.getText();
		rightYes.click();
		if(yes.contains("Yes"))
			System.out.println("You Selected Yes :) ");
		else
			System.out.println("Not Selected :( ");
		
		WebElement concernRightClickBtn = driver.findElement(By.id("btn31"));
		actions.contextClick(concernRightClickBtn).perform();
		driver.findElement(By.xpath("//div[text()='No']")).click();
		
		WebElement rating = driver.findElement(By.id("btn32"));
		actions.contextClick(rating).perform();
		driver.findElement(By.xpath("//div[text()='5']")).click();	
	}
	
	@Test
	public void doubleClick() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demoapps.qspiders.com/ui");
		
		driver.findElement(By.xpath("//section[text()='Button']")).click();
		
		driver.findElement(By.xpath("//a[text()='Double Click']")).click();
		
		WebElement sfDoubleClickBtn = driver.findElement(By.id("btn20"));
		
		actions = new Actions(driver);
		
		actions.doubleClick(sfDoubleClickBtn).perform();
		String text = driver.findElement(By.xpath("//span[text()='You selected \"Yes\"']")).getText();
		if(text.contains("Yes"))
			System.out.println("You selected Yes button :) ");
		else
			System.out.println("Not selected button :( ");
		
		WebElement concernDoubleClickBtn = driver.findElement(By.id("btn23"));
		actions.doubleClick(concernDoubleClickBtn).perform();
		WebElement ratingBtn = driver.findElement(By.id("btn26"));
		actions.doubleClick(ratingBtn).perform();
	}
	
	@Test
	public void submitClick() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demoapps.qspiders.com/ui");
		
		driver.findElement(By.xpath("//section[text()='Button']")).click();
		
		driver.findElement(By.xpath("//a[text()='Submit Click']")).click();
		
		driver.findElement(By.id("sat1")).click();
		driver.findElement(By.id("btn40")).submit();
		String text = driver.findElement(By.xpath("//span[text()='You Selected \"Yes\"']")).getText();
		if(text.contains("Yes"))
			System.out.println("You selected Yes button :) ");
		else
			System.out.println("Not selected button :( ");
		
		driver.findElement(By.id("prob2")).click();
		driver.findElement(By.id("btn41")).submit();
		driver.findElement(By.xpath("//input[@name='rate' and @id = 'r4']")).click();
		driver.findElement(By.id("btn42")).submit();
	}
	
	
	@Test
	public void disable() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demoapps.qspiders.com/ui");
		
		driver.findElement(By.xpath("//section[text()='Button']")).click();
		
		driver.findElement(By.xpath("//a[text()='Disabled']")).click();
		
		driver.findElement(By.id("btn10")).click();
		String text = driver.findElement(By.xpath("//span[text()='You selected \"Yes\"']")).getText();
		if(text.contains("Yes"))
			System.out.println("You selected Yes button :) ");
		else
			System.out.println("Not selected button :( ");
		
		driver.findElement(By.id("btn12")).click();
		driver.findElement(By.id("btn19")).click();
		WebElement checkBox = driver.findElement(By.xpath("//input[@id='submit']"));
		if(checkBox.isEnabled()) {
			checkBox.click();
			System.out.println("Selected check box");
		}else
			System.out.println("Check box is not selected :( ");
		
		WebElement subBtn = driver.findElement(By.id("submitButton"));
		if(subBtn.isEnabled()) 
			subBtn.click();
		else
			System.out.println("Submit button is not enabled :( ");
	
	}	
}
