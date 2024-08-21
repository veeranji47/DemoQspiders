package dateAndTimePicker;

import java.time.Duration;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DatePicker {

	WebDriver driver;

	@Test
	public void defaultDatePicker() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demoapps.qspiders.com/ui");

		driver.findElement(By.xpath("(//section[text()='Date & Time Picker'])")).click();
		driver.findElement(By.xpath("(//section[text()='Date Picker'])")).click();

		driver.findElement(By.xpath("//div[@class='react-datepicker-wrapper']")).click();
		int reqYear = 2027;
		String reqMonth = "March";
		String date = "25";

		String currentMonthYear = driver
				.findElement(By.xpath("//div[contains(@class,'react-datepicker__current-month')]")).getText();
		String[] monthYear = currentMonthYear.split(" ");
		int currentYear = Integer.parseInt(monthYear[1]);

		while (currentYear < reqYear) {
			driver.findElement(By.xpath("//button[contains(@class,'react-datepicker__navigation--next')]")).click();
			currentMonthYear = driver.findElement(By.xpath("//div[contains(@class,'react-datepicker__current-month')]"))
					.getText();
			monthYear = currentMonthYear.split(" ");
			currentYear = Integer.parseInt(monthYear[1]);
		}
		int currentMonth = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(monthYear[0])
				.get(ChronoField.MONTH_OF_YEAR);

		int reqMonthNum = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(reqMonth)
				.get(ChronoField.MONTH_OF_YEAR);

		while (currentMonth < reqMonthNum) {

			driver.findElement(By.xpath("//button[contains(@class,'react-datepicker__navigation--next')]")).click();
			currentMonthYear = driver.findElement(By.xpath("//div[contains(@class,'react-datepicker__current-month')]"))
					.getText();
			monthYear = currentMonthYear.split(" ");
			currentMonth = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(monthYear[0])
					.get(ChronoField.MONTH_OF_YEAR);

		}
		while (currentMonth > reqMonthNum) {

			driver.findElement(By.xpath("//button[contains(@class,'react-datepicker__navigation--previous')]")).click();
			currentMonthYear = driver.findElement(By.xpath("//div[contains(@class,'react-datepicker__current-month')]"))
					.getText();
			monthYear = currentMonthYear.split(" ");
			currentMonth = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(monthYear[0])
					.get(ChronoField.MONTH_OF_YEAR);

		}
		while (currentYear > reqYear) {
			driver.findElement(By.xpath("//button[contains(@class,'react-datepicker__navigation--previous')]")).click();
			currentMonthYear = driver.findElement(By.xpath("//div[contains(@class,'react-datepicker__current-month')]"))
					.getText();
			monthYear = currentMonthYear.split(" ");
			currentYear = Integer.parseInt(monthYear[1]);
		}

		driver.findElement(By.xpath(
				"//div[contains(@class,'react-datepicker__month-container')]/descendant::div[@class='react-datepicker__month']/descendant::div[contains(.,'"
						+ date + "')]"))
				.click();
		Thread.sleep(2000);
		driver.quit();
	}

	@Test
	public void dropDownDatePicker() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demoapps.qspiders.com/ui");

		driver.findElement(By.xpath("(//section[text()='Date & Time Picker'])")).click();
		driver.findElement(By.xpath("(//section[text()='Date Picker'])")).click();
		driver.findElement(By.xpath("//a[contains(@href,'datedropdown?sublist')]")).click();

		driver.navigate().refresh();
		driver.findElement(By.xpath("//div[@class='react-datepicker-wrapper']")).click();
		int reqYear = 2026;
		String reqMonth = "Dec";
		String date = "25";

		String currentMonthYear = driver
				.findElement(By.xpath("//div[contains(@class,'react-datepicker__current-month')]")).getText();
		String[] monthYear = currentMonthYear.split(" ");
		int currentYear = Integer.parseInt(monthYear[1]);

		while (currentYear < reqYear) {
			driver.findElement(By.xpath("//span[contains(@class,'react-datepicker__year-read-view--down-arrow')]"))
					.click();
			driver.findElement(By.xpath(
					"//div[contains(@class,'react-datepicker__year-dropdown')]/descendant::div[contains(@class,'react-datepicker__year-option') and contains(.,'"
							+ reqYear + "')]"))
					.click();
			currentMonthYear = driver.findElement(By.xpath("//div[contains(@class,'react-datepicker__current-month')]"))
					.getText();
			monthYear = currentMonthYear.split(" ");
			currentYear = Integer.parseInt(monthYear[1]);
		}
		int currentMonth = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(monthYear[0])
				.get(ChronoField.MONTH_OF_YEAR);

		int reqMonthNum = DateTimeFormatter.ofPattern("MMM").withLocale(Locale.ENGLISH).parse(reqMonth)
				.get(ChronoField.MONTH_OF_YEAR);

		while (currentMonth < reqMonthNum) {

			driver.findElement(By.xpath("//span[contains(@class,'react-datepicker__month-read-view--down-arrow')]"))
					.click();
			driver.findElement(By.xpath(
					"//div[contains(@class,'react-datepicker__month-dropdown')]/div[contains(@class,'month-option') and contains(.,'"
							+ reqMonth + "')]"))
					.click();
			currentMonthYear = driver.findElement(By.xpath("//div[contains(@class,'react-datepicker__current-month')]"))
					.getText();
			monthYear = currentMonthYear.split(" ");
			currentMonth = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(monthYear[0])
					.get(ChronoField.MONTH_OF_YEAR);

		}
		while (currentMonth > reqMonthNum) {

			driver.findElement(By.xpath("//span[contains(@class,'react-datepicker__month-read-view--down-arrow')]"))
					.click();
			driver.findElement(By.xpath(
					"//div[contains(@class,'react-datepicker__month-dropdown')]/div[contains(@class,'month-option') and contains(.,'"
							+ reqMonth + "')]"))
					.click();
			currentMonthYear = driver.findElement(By.xpath("//div[contains(@class,'react-datepicker__current-month')]"))
					.getText();
			monthYear = currentMonthYear.split(" ");
			currentMonth = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(monthYear[0])
					.get(ChronoField.MONTH_OF_YEAR);

		}
//		while (currentYear > reqYear) {
//			driver.findElement(By.xpath("//button[contains(@class,'react-datepicker__navigation--previous')]")).click();
//			currentMonthYear = driver.findElement(By.xpath("//div[contains(@class,'react-datepicker__current-month')]"))
//					.getText();
//			monthYear = currentMonthYear.split(" ");
//			currentYear = Integer.parseInt(monthYear[1]);
//		}

		driver.findElement(By.xpath(
				"//div[contains(@class,'react-datepicker__month-container')]/descendant::div[@class='react-datepicker__month']/descendant::div[contains(.,'"
						+ date + "')]"))
				.click();
		
		Thread.sleep(2000);
		driver.quit();
	}

	@Test
	public void date() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demoapps.qspiders.com/ui/");
		
		driver.findElement(By.xpath("(//section[text()='Date & Time Picker'])")).click();
		driver.findElement(By.xpath("(//section[text()='Date Picker'])")).click();
		driver.findElement(By.xpath("//a[contains(@href,'iconstrigger?sublist')]")).click();
		
		driver.navigate().refresh();
		// 1st datepicker
		String month_year = "June 2023";
		String date = "26";

		driver.findElement(By.xpath("//div[contains(@class,'relative flex')]/*[name()='svg' and @stroke='currentColor']")).click();
		//driver.findElement(By.xpath("//div[@class='react-datepicker__input-container']")).click();
		while (true) {

			String mon_yr = driver.findElement(By.xpath("//div[contains(@class,'react-datepicker__current-month')]"))
					.getText();
			if (mon_yr.equalsIgnoreCase(month_year)) {
				break;
			} else {
				Thread.sleep(800);
				WebElement ele = driver.findElement(
						By.xpath("//button[contains(@class,'react-datepicker') and @aria-label='Previous Month']"));
				ele.click();
			}
		}
	 
		Thread.sleep(2000);
		driver.navigate().refresh();
		List<WebElement> alldt = driver.findElements(By.xpath("//div[contains(@class,'react-datepicker__day react-datepicker')]"));
		
		for (WebElement element : alldt) {
			String dt = element.getText();
			if (dt.equals(date)) {
				Thread.sleep(2000);
				element.click();
				break;
			}
		}
		
		Thread.sleep(2000);
		driver.quit();

	}
}
