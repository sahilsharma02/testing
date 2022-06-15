package dome;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;

import junit.framework.Test;

public class domes {
	// WebDriver driver = new ChromeDriver();
	 public static void main(String[] args) throws AWTException, InterruptedException {
		 //System.setProperty("webdriver.chrome.driver",
				//	"C://Users//abc//Downloads//chromedriver_win32//chromedriver.exe");	
		    String website = "https://devorder.crowndigital.io/login";
	         String website2 = "https://devorder.crowndigital.io/login";
	         String website3 = "https://devorder.crowndigital.io/login";
	         String website4 = "https://devorder.crowndigital.io/login";
	         String website5 = "https://devorder.crowndigital.io/login";

	        String controlpath = "C://Users//abc//Downloads//chromedriver_win32//chromedriver.exe";
	        System.setProperty("webdriver.chrome.driver", controlpath);
	        WebDriver driver = new ChromeDriver();
	        driver.manage().window().maximize(); //  Maximize browser
	        driver.get(website);
	        System.out.println("Google page");
	        
	        Robot robot = new Robot();                          
	        robot.keyPress(KeyEvent.VK_CONTROL); 
	        robot.keyPress(KeyEvent.VK_T); 
	        robot.keyRelease(KeyEvent.VK_CONTROL); 
	        robot.keyRelease(KeyEvent.VK_T);
	        robot.keyRelease(KeyEvent.VK_CONTROL); 
	        robot.keyRelease(KeyEvent.VK_T);
	        robot.keyRelease(KeyEvent.VK_CONTROL); 
	        robot.keyRelease(KeyEvent.VK_T);
	        robot.keyRelease(KeyEvent.VK_CONTROL); 
	        robot.keyRelease(KeyEvent.VK_T);
	        
	        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	        driver.switchTo().window(tabs.get(0));
	        
	        driver.get(website);
	        driver.get(website2);
	        driver.get(website3);
	        driver.get(website4);
	        driver.get(website5);

	        System.out.println("msn page");
	        Thread.sleep(5000);
	        driver.switchTo().window(tabs.get(1));
	        Thread.sleep(5000);
	        driver.switchTo().window(tabs.get(2));
	        Thread.sleep(5000);
	        driver.switchTo().window(tabs.get(3));

	        Thread.sleep(5000);
	        driver.switchTo().window(tabs.get(4));




		 
	 }	
	
	}	 		
	