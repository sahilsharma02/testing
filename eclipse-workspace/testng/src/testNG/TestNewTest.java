package testNG;

import org.testng.annotations.Test;

import com.opencsv.CSVReader;

import org.testng.annotations.BeforeMethod;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;

public class TestNewTest {
	WebDriver driver;
	private static CSVReader csvReader;
	static String[] csvCell;

	@Test
	public void f() throws InterruptedException, IOException {
		String finalScore = "";
		System.setProperty("webdriver.chrome.driver",
				"C://Users//abc//Downloads//chromedriver_win32//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String baseurl = "https://devorder.crowndigital.io/login";
		driver.get(baseurl);
		Thread.sleep(3000);

		CSVReader reader = new CSVReader(new FileReader("C://Users//abc//Downloads//ThousandRecoredsS.csv"));
		driver.findElement(By.className("native-input")).click();
		List<String[]> list = reader.readAll();
		System.out.println("Total rows which we have is " + list.size());

		Iterator<String[]> iterator = list.iterator();
		while (iterator.hasNext()) {
			String[] str = iterator.next();
			System.out.print(" Values are ");

			for (int i = 0; i < str.length; i++) {

				driver.navigate().to(baseurl);
				driver.findElement(By.className("native-input")).sendKeys(str[i]);
				driver.findElement(By.cssSelector("button[type='submit']")).click();
				Thread.sleep(3000);
				WebElement l = driver.findElement(By.tagName("body"));
				
				System.out.println("Text content: " + l.getText());
				System.out.println(" " + str[i]);
				JavascriptExecutor js = (JavascriptExecutor) driver;
				String lastFive = l.getText().substring(l.getText().length() - 3);

				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
				LocalDateTime now = LocalDateTime.now();
				System.out.println(dtf.format(now));

				String filepath = "C://Users//abc//Downloads//ResponsE.csv";
				FileWriter fw = new FileWriter(filepath, true);
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter pw = new PrintWriter(bw);

				pw.println(l.getText().substring(l.getText().length() - 3) + "     " + dtf.format(now));
				pw.flush();
				pw.close();
			}
		}
	}
}
