package shadow;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class dom {
	WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				"C://Users//abc//Downloads//chromedriver_win32//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String baseurl = "https://devorder.crowndigital.io/login";
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.get(baseurl);

		Thread.sleep(3000);

		driver.findElement(By.className("native-input")).sendKeys("98687789");
		Thread.sleep(3000);

		driver.findElement(By.cssSelector("button[type='submit']")).click();
		Thread.sleep(3000);

		WebElement otp = driver.findElement(By.xpath(
				"//body[1]/app-root[1]/ion-app[1]/ion-router-outlet[1]/app-otp[1]/ion-content[1]/form[1]/section[1]/div[2]/ng-otp-input[1]/div[1]/input[1]"));
		otp.click();
		otp.sendKeys("1");
		WebElement otp1 = driver.findElement(By.xpath(
				"//body[1]/app-root[1]/ion-app[1]/ion-router-outlet[1]/app-otp[1]/ion-content[1]/form[1]/section[1]/div[2]/ng-otp-input[1]/div[1]/input[2]"));
		otp1.sendKeys("1");
		WebElement otp2 = driver.findElement(By.xpath(
				"//body[1]/app-root[1]/ion-app[1]/ion-router-outlet[1]/app-otp[1]/ion-content[1]/form[1]/section[1]/div[2]/ng-otp-input[1]/div[1]/input[3]"));
		otp2.sendKeys("1");
		WebElement otp3 = driver.findElement(By.xpath(
				"//body[1]/app-root[1]/ion-app[1]/ion-router-outlet[1]/app-otp[1]/ion-content[1]/form[1]/section[1]/div[2]/ng-otp-input[1]/div[1]/input[4]"));
		otp3.sendKeys("1");
		Thread.sleep(5000);
		driver.findElement(By.cssSelector(".me")).click();
		Thread.sleep(5000);

		WebElement shadowHostL1 = driver.findElement(By.cssSelector("ion-router-outlet"));

		// now locate the shadowElement by traversing all shadow levels
		WebElement shadowElementL1 = getShadowElement(driver, shadowHostL1, "ion-router-outlet");
		WebElement shadowElementL2 = getShadowElement(driver, shadowElementL1, "ion-toolbar");

		WebElement shadowElementL3 = getShadowElement(driver, shadowElementL2, "ion-tab-bar");
		shadowElementL3.click();
		// WebElement clearData =
		// shadowElementL3.findElement(By.cssSelector("ion-tab-button"));
		// clearData.click();

	}

	private static WebElement getShadowElement(WebDriver driver, WebElement shadowHostL1, String string) {
		// TODO Auto-generated method stub
		return null;
	}

}
