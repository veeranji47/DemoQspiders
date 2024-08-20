package webElements;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class DropDowns {
	WebDriver driver;
	Select select;
	
	@Test
	public void singleDropDown() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demoapps.qspiders.com/ui");

		driver.findElement(By.xpath("//section[text()='Dropdown']")).click();
		
		driver.findElement(By.id("phone")).sendKeys("6281507389");
		WebElement gender = driver.findElement(By.id("select2"));
		
		select = new Select(gender);
		select.selectByVisibleText("Male");
		WebElement country = driver.findElement(By.id("select3"));
		Select selectCountry = new Select(country);
		selectCountry.selectByVisibleText("India");
		WebElement state = driver.findElement(By.id("select5"));
		Select selectState = new Select(state);
		selectState.selectByVisibleText("Andhra Pradesh");
		WebElement city = driver.findElement(By.xpath("(//select[contains(@class,'border-0 px-3 py-3 placeholder-blueGray-300 text-blueGray')])[5]"));
		Select selectCity = new Select(city);
		selectCity.selectByVisibleText("Anantapur");
		WebElement shoe = driver.findElement(By.id("select7"));
		Select shoeQuantity = new Select(shoe);
		shoeQuantity.selectByVisibleText("2");
		Thread.sleep(2000);
		driver.findElement(By.id("continuebtn")).click();
		
		driver.findElement(By.xpath("//input[@value='Upi']")).click();
		driver.findElement(By.xpath("//input[@value='home']")).click();
		driver.findElement(By.xpath("//button[@id='btn']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@id='domain2']")).click();
		driver.findElement(By.xpath("//input[@id='mode2']")).click();
		driver.findElement(By.xpath("//input[@id='mode5']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@id='mode6' and @value='Continue']")).click();
		
		List<WebElement> fields = driver.findElements(By.xpath("//label[contains(@class,'inline-flex items-center cursor-pointer')]"));
		
		for(WebElement options : fields) {
			options.click();
			Thread.sleep(900);
		}
		
		driver.findElement(By.id("togglers")).click();
		
		driver.close();
	}
	
	@Test
	public void multiDropDown() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demoapps.qspiders.com/ui");
		
		driver.findElement(By.xpath("//section[text()='Dropdown']")).click();
		WebElement multiSelect = driver.findElement(By.xpath("//a[text()='Multi Select']"));
		multiSelect.click();

		
		driver.findElement(By.id("keypoint")).sendKeys("6281507389");
		WebElement gender = driver.findElement(By.id("select40"));
		
		Select sgender = new Select(gender);
		sgender.selectByVisibleText("Male");
		
		WebElement india = driver.findElement(By.xpath("(//select[@id='select-multiple-native'])[1]"));
		Select indiaSel = new Select(india);
		indiaSel.selectByVisibleText("India");
		WebElement state = driver.findElement(By.xpath("(//select[@id='select-multiple-native'])[2]"));
		Select stateSel = new Select(state);
		
		stateSel.selectByVisibleText("Telangana");
		Thread.sleep(2000);
		stateSel.selectByVisibleText("Andhra Pradesh");
		Thread.sleep(2000);
		
		WebElement city = driver.findElement(By.xpath("(//select[@id='select-multiple-native'])[3]"));
		Select citySel = new Select(city);
		citySel.selectByVisibleText("Anantapur");
		
		WebElement shoe = driver.findElement(By.xpath("(//select[contains(@class,'border-0 px-3 py-3 placeholder-blueGray-300 text-blueGray')])[3]"));
		Select shoeQuan = new Select(shoe);
		shoeQuan.selectByVisibleText("2");
		driver.findElement(By.xpath("//button[text()='Continue']")).click();
		
		driver.findElement(By.xpath("//input[@value='Upi']")).click();
		driver.findElement(By.xpath("//input[@id='willin2']")).click();
		driver.findElement(By.xpath("//button[@id='btn']")).click();
		
		driver.findElement(By.xpath("//input[@id='domain2']")).click();
		driver.findElement(By.xpath("//input[@id='mode2']")).click();
		driver.findElement(By.xpath("//input[@id='mode5']")).click();
		driver.findElement(By.xpath("//input[@id='mode6' and @value='Continue']")).click();
		
		List<WebElement> fields = driver.findElements(By.xpath("//label[contains(@class,'inline-flex items-center cursor-pointer')]"));
		
		for(WebElement options : fields) {
			options.click();
		}
		
		driver.findElement(By.id("togglers")).click();	
	}
	
	@Test
	public void searchWithSelect() throws InterruptedException, AWTException {
		driver = new ChromeDriver();
		
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demoapps.qspiders.com/ui");

		driver.findElement(By.xpath("//section[text()='Dropdown']")).click();
		driver.findElement(By.xpath("//a[contains(@href,'search?sublist')]")).click();
		
		driver.findElement(By.id("selectPhone")).sendKeys("9988774455");
		
		WebElement gender = driver.findElement(By.xpath("//input[@id='react-select-3-input']"));
		gender.click();
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
		Thread.sleep(900);
		WebElement country = driver.findElement(By.xpath("//input[@id='react-select-4-input']"));
		country.click();
		country.sendKeys("India");
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
		Thread.sleep(900);
		WebElement state = driver.findElement(By.xpath("//input[@id='react-select-5-input']"));
		state.click();
		state.sendKeys("Andhra Pradesh");
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
		Thread.sleep(900);
		WebElement city = driver.findElement(By.xpath("//input[@id='react-select-6-input']"));
		city.click();
		city.sendKeys("Krishna");
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(900);
		
		WebElement shoeQuatinty = driver.findElement(By.xpath("//input[@id='react-select-7-input']"));
		shoeQuatinty.click();
		shoeQuatinty.sendKeys("2");
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
		driver.findElement(By.id("continue")).click();
		
	}
	@Test
	public void disabledDropDOwn() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demoapps.qspiders.com/ui");

		driver.findElement(By.xpath("//section[text()='Dropdown']")).click();
		driver.findElement(By.xpath("//a[contains(@href,'disabled?sublist')]")).click();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		WebElement gender = driver.findElement(By.id("selectGen"));
		js.executeScript("arguments[0].removeAttribute('disabled')", gender);
		Select selectGender = new Select(gender);
		selectGender.selectByVisibleText("Male");
		Thread.sleep(900);
		
		WebElement country = driver.findElement(By.id("SelectCountry"));
		js.executeScript("arguments[0].removeAttribute('disabled')", country);
		Select selectCountry = new Select(country);
		selectCountry.selectByVisibleText("India");
		Thread.sleep(900);
		
		WebElement state = driver.findElement(By.id("slectState"));
		js.executeScript("arguments[0].removeAttribute('disabled')", state);
		Select selectState = new Select(state);
		selectState.selectByVisibleText("Maharashtra");
		Thread.sleep(900);
		
		WebElement city = driver.findElement(By.id("citySelect"));
		js.executeScript("arguments[0].removeAttribute('disabled')", city);
		Select selectCity = new Select(city);
		selectCity.selectByVisibleText("Mumbai");
		Thread.sleep(900);
		
		WebElement shoeQuatinty = driver.findElement(By.xpath("//select[contains(@class,'w-full cursor-not-allowed') ]"));
		js.executeScript("arguments[0].removeAttribute('disabled')", shoeQuatinty);
		Select selectShoe = new Select(shoeQuatinty);
		selectShoe.selectByVisibleText("2");
		Thread.sleep(900);
		
		driver.findElement(By.xpath("//button[.='Continue']")).click();
		
	}
	

	

}
