package fileupload;

import java.io.*;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import au.com.bytecode.opencsv.CSVReader;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class csvfile {
	
	 String CSV_file = "C://Users//abc//Downloads//captcha_score.csv";
	 WebDriver driver;
	 private CSVReader csvReader;
	 String[] csvCell;
	 
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C://Users//abc//Downloads//chromedriver_win32//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://devorder.crowndigital.io/login");
	    //driver.findElement(By.className("native-input")).sendKeys("CustomerName");
		// driver.findElement(By.cssSelector("button[type='submit']")).click();
		}
	
	public void verify_search() throws IOException, InterruptedException { 
		
		Reader reader = new FileReader(CSV_file);
		CSVReader csvreader = new CSVReader(reader);
		driver.findElement(By.className("native-input")).click();
		while ((csvCell = csvReader.readNext()) != null) {
            String CustomerName = csvCell[0];
			driver.findElement(By.className("native-input")).sendKeys("CustomerName");
            driver.findElement(By.cssSelector("button[type='submit']")).click();
            driver.quit();
            
            
			}
		}

				 
	}         

		


			
		
		
		
		 
	    


