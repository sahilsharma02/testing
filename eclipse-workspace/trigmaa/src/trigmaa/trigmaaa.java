package trigmaa;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class trigmaaa {

	public static void main(String[] args) throws InterruptedException {
		//WEBDRIVER LOCATION
		System.setProperty("webdriver.chrome.driver", "C://Users//abc//Downloads//chromedriver_win32//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//DESIERD URL
		String baseurl= "https://trigma.com/";
		driver.get(baseurl);
		//MAXIMIZE WINDOW
		driver.manage().window().maximize();
		Thread.sleep(3000);
        //FOR SCROLL DOWN PAGE
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(3000);
        //FOR SCROLL PAGE UP
	    ((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
	   // js.executeScript("window.scrollBy(0,100000)");
	  
		Thread.sleep(3000);
		//ACCEPT COOKIES
        driver.findElement(By.cssSelector("button[aria-label='Accept']")).click();
        //HOVER AT LIST
        WebElement ele = driver.findElement(By.xpath("//header/div[1]/div[2]/nav[1]/div[1]/ul[1]/li[2]/a[1]"));
        //Creating object of an Actions class
        Actions action = new Actions(driver);
        action.moveToElement(ele).perform();
	    Thread.sleep(3000);

       WebElement ele1 = driver.findElement(By.xpath("//header/div[1]/div[2]/nav[1]/div[1]/ul[1]/li[3]/a[1]"));
       Actions action1 = new Actions(driver);
       action1.moveToElement(ele1).perform();
	   Thread.sleep(3000);

	   WebElement ele2 = driver.findElement(By.xpath("//header/div[1]/div[2]/nav[1]/div[1]/ul[1]/li[4]/a[1]"));
       Actions action2 = new Actions(driver);
       action2.moveToElement(ele2).perform();
	   Thread.sleep(5000);
	   //FOR CLICK AT ABOUT US
	   WebElement ele3 = driver.findElement(By.xpath("//a[contains(text(),'ABOUT US')]"));
       ele3.click();
       JavascriptExecutor js1 = (JavascriptExecutor) driver;
       //FOR SUBMIT THE FORM
       js1.executeScript("window.scrollTo(0, document.body.scrollHeight)");
       driver.findElement(By.name("your-name")).sendKeys("sahilMM");
       driver.findElement(By.name("your-email")).sendKeys("sahilT@yopmail.com");
       driver.findElement(By.name("phone")).sendKeys("7654345578");
       driver.findElement(By.name("your-message")).sendKeys("this is automation");
      
       Select dropdown = new Select(driver.findElement(By.name("find-us")));  
       dropdown.selectByValue("Clutch");
       // //WebElement browse = driver.findElement(By.name("file_upload"));
       //  browse.sendKeys("C://Users//abc//Downloads//DfgdfgTest"); 
       Thread.sleep(5000);
       driver.findElement(By.xpath("//input[@value = 'Send']")).click();
       Thread.sleep(3000);
	   ((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");


      //FOR CLICK AT INSIGHTES
	   WebElement ele4 = driver.findElement(By.xpath("//a[contains(text(),'INSIGHTS')]"));
       ele4.click();
       JavascriptExecutor js2 = (JavascriptExecutor) driver;
       js2.executeScript("window.scrollTo(0, document.body.scrollHeight)");
       Thread.sleep(3000);
       ((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");


	  
	   WebElement ele5 = driver.findElement(By.xpath("//header/div[1]/div[2]/nav[1]/div[1]/ul[1]/li[7]/a[1]"));
       Actions action5 = new Actions(driver);
       action5.moveToElement(ele5).perform();
	   Thread.sleep(3000);
	  //CLICK AT HOME
	  driver.findElement(By.xpath("//img[@id='logo']")).click();
	  driver.close();
	  

	
	//csvReader = new CSVReader( new fileReader(CSV_file));
			//driver.findElement(By.className("native-input")).click();
			 /*while ((csvCell = csvReader.readNext()) != null) {
		            String CustomerName = csvCell[0];
					driver.findElement(By.className("native-input")).sendKeys("CustomerName");
		            driver.findElement(By.cssSelector("button[type='submit']")).click();*/
       
	   
	}
	
}