package dateAndTimePicker;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class TimePicker {
	WebDriver driver;

	@Test
	public void defaultTimePicker() throws InterruptedException, AWTException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demoapps.qspiders.com/ui");

		driver.findElement(By.xpath("(//section[text()='Date & Time Picker'])")).click();
		driver.findElement(By.xpath("(//section[text()='Time Picker'])")).click();

		WebElement time = driver.findElement(By.xpath("//input[contains(@placeholder,'hh:mm aa')]"));
		time.click();
		time.sendKeys("09:45:AM");
	}

	@Test
	public void timePickerClock() throws InterruptedException, AWTException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demoapps.qspiders.com/ui");

		driver.findElement(By.xpath("(//section[text()='Date & Time Picker'])")).click();
		driver.findElement(By.xpath("(//section[text()='Time Picker'])")).click();
		// driver.findElement(By.xpath("//a[contains(@href,'timeClock?sublist')]")).click();

		WebElement time = driver.findElement(By.xpath("//button[contains(@class,'MuiButtonBase-root')]"));
		time.click();
		String reqHour = "9";
		String reqMins = "50";
		String meridium = "AM";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement hr = driver.findElement(By.xpath(
				"//div[contains(@class,'MuiMultiSectionDigitalClock')]/ul[contains(@class,'MuiMultiSectionDigitalClockSection')]/li[contains(@aria-label,'"
						+ reqHour + " hours')]"));
		Thread.sleep(2000);
		js.executeScript("arguments[0].click()", hr);
		WebElement min = driver.findElement(By.xpath(
				"//div[contains(@class,'MuiMultiSectionDigitalClock')]/ul[contains(@class,'MuiMultiSectionDigitalClockSection')]/li[contains(@aria-label,'"
						+ reqMins + " minutes')]"));
		js.executeScript("arguments[0].click()", min);
		Thread.sleep(2000);
		WebElement ap = driver.findElement(By.xpath(
				"//div[contains(@class,'MuiMultiSectionDigitalClock')]/ul[contains(@class,'MuiMultiSectionDigitalClockSection')]/li[contains(@aria-label,'"
						+ meridium + "')]"));
		js.executeScript("arguments[0].click()", ap);

	}

	@Test
	public void analogClock() throws InterruptedException, AWTException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		driver.get("https://demoapps.qspiders.com/ui");

		driver.findElement(By.xpath("(//section[text()='Date & Time Picker'])")).click();
		driver.findElement(By.xpath("(//section[text()='Time Picker'])")).click();
		driver.findElement(By.xpath("//a[contains(@href,'timeClock?sublist')]")).click();

		driver.navigate().refresh();
		WebElement time = driver.findElement(By.xpath("//input[@placeholder='hh:mm aa']"));
		time.click();
		String reqHour = "5";
		String reqMins = "30";
		String meridium = "AM";

		Thread.sleep(2000);
		WebElement clockLine = driver.findElement(By.xpath("//div[contains(@class,'MuiClockPointer-root')]"));
		WebElement hour = driver.findElement(By.xpath(
				"//div[contains(@class,'MuiPickersLayout-root')]/descendant::div[contains(@class,'MuiClockPointer-root')]/../div[contains(@class,'MuiClock-wrapper')]/span[contains(@aria-label,'"+reqHour+" hours')]"));
		
		Actions actions = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		actions.dragAndDrop(clockLine, hour).click().perform();
		Thread.sleep(1400);
		
//		WebElement nextButton = driver.findElement(By.xpath(
//				"//button[contains(@class,'MuiButtonBase-root')]/*[name()='svg' and @data-testid='ArrowRightIcon']"));
//		actions.click(nextButton).perform();
	
		//Thread.sleep(1600);
		WebElement min = driver.findElement(By.xpath("//div[contains(@class,'MuiClock-clock')]/descendant::div[contains(@class,'MuiClock-wrapper')]/span[contains(@aria-label,'"+reqMins+" minutes')]"));
		actions.dragAndDrop(clockLine, min).click().perform();
		Thread.sleep(1600);
		driver.findElement(By.xpath("//div[contains(@class,'MuiTimePickerToolbar')]/button/span[.='"+meridium+"']")).click();
		driver.findElement(By.xpath("//button[.='OK']")).click();
		
		WebElement reqTime = driver.findElement(By.xpath("//input[contains(@placeholder,'hh:mm aa')]"));
		System.out.println("Required time is : "+reqTime.getAttribute("value"));
	}

}
