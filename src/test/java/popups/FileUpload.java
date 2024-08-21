package popups;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class FileUpload {
	
	WebDriver driver;
	@Test
	public void fileUpload() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demoapps.qspiders.com/ui");

		driver.findElement(By.xpath("//section[text()='Popups']")).click();
		driver.findElement(By.xpath("//section[text()='File Uploads']")).click();
		
		WebElement fileUpload = driver.findElement(By.xpath("//input[@type='file']"));
		
		fileUpload.sendKeys("C:\\Users\\ASHOK KUMAR\\Desktop\\Selenium\\veera.docx");
		
		
	}
	@Test
	public void customButton() throws InterruptedException, AWTException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demoapps.qspiders.com/ui");
		
		driver.findElement(By.xpath("//section[text()='Popups']")).click();
		driver.findElement(By.xpath("//section[text()='File Uploads']")).click();
		driver.findElement(By.xpath("//a[contains(@href,'custom?sublist')]")).click();
		
		WebElement fileUpload = driver.findElement(By.xpath("//div[.='Upload File']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", fileUpload);
		
		Thread.sleep(2000);
		
//		fileUpload.sendKeys("C:\\Users\\ASHOK KUMAR\\Desktop\\Selenium\\veera.docx");
		Robot robot  = new Robot();
		StringSelection str = new StringSelection("C:\\Users\\ASHOK KUMAR\\Desktop\\Selenium\\veera.docx");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
		
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		
	}
	
	@Test
	public void dragAndDropFile() throws InterruptedException, AWTException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demoapps.qspiders.com/ui");
		
		driver.findElement(By.xpath("//section[text()='Popups']")).click();
		driver.findElement(By.xpath("//section[text()='File Uploads']")).click();
		driver.findElement(By.xpath("//a[contains(@href,'drag?sublist')]")).click();
		
		WebElement fileUpload = driver.findElement(By.xpath("//input[@id='fileInput']"));
		fileUpload.click();
		String file = Paths.get("C:\\Users\\ASHOK KUMAR\\Desktop\\Selenium\\veera.docx").toString();
		
		fileUpload.sendKeys(file);
//		System.out.println(fileUpload.getLocation());
//		Actions actions = new Actions(driver);
//		actions.dragAndDropBy(fileUpload, 0, 0);
		
	}

}
