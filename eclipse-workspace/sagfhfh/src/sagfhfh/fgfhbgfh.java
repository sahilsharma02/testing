package sagfhfh;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class fgfhbgfh {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				"C://Users//abc//Downloads//chromedriver_win32//chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// https://devsapkiosk.crowndigital.io/kioskautologin/50af53b1204c9fcccca2fb30418ec62b/82d5984c2a2ad4c62caf1dd073b1c91c/1
		// App url "https://devorder.crowndigital.io/login";
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

		// after login
		Thread.sleep(5000);
		driver.findElement(By.cssSelector(".me")).click();
		Thread.sleep(5000);

		//
		WebElement shadowRoot1 = expandRootElement(driver.findElement(By.cssSelector("ion-router-outlet")));

		WebElement root2 = shadowRoot1.findElement(By.cssSelector("ion-router-outlet"));
		WebElement shadowRoot2 = expandRootElement(root2);

		WebElement root3 = shadowRoot2.findElement(By.cssSelector("ion-toolbar"));
		WebElement shadowRoot3 = expandRootElement(root3);

		WebElement root4 = shadowRoot3.findElement(By.cssSelector("ion-tab-bar"));
		root4.click();
		// WebElement shadowRoot4 = expandRootElement(root4);

		// WebElement root5 = shadowRoot4.findElement(By.cssSelector("ion-tab-button"));

		// root5.click();
		// wait.until(ExpectedConditions.invisibilityOf(root5));

	}

	private static WebElement expandRootElement(WebElement findElement) {
		// TODO Auto-generated method stub
		return null;
	}

}
