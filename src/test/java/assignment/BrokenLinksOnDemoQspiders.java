package assignment;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinksOnDemoQspiders {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demoapps.qspiders.com/ui");
		
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		System.out.println("all links :"+allLinks.size());
		
		String url = "";
		String linksName = "";
		for(int i = 0; i < allLinks.size(); i++) {
			linksName = allLinks.get(i).getText();
			WebElement link = allLinks.get(i);
			url = link.getAttribute("href");
			verifyLink(linksName, url);
		}
		
	}
	
	public static void verifyLink(String linksName, String links) {
		try {
			URL url = new URL(links);
			
			HttpsURLConnection codes = (HttpsURLConnection) url.openConnection();
			codes.setConnectTimeout(5000);
			codes.connect();
			if(codes.getResponseCode() >= 400) {
				System.out.println(linksName +"  --> " +codes.getResponseMessage());
			}else {
				System.out.println(linksName +"   --> "+codes.getResponseCode());
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
