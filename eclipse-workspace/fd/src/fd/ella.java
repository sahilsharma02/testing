package fd;

import java.io.BufferedWriter;
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
import java.util.StringTokenizer;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileReader;
import java.util.Iterator;
import java.util.List;

import com.gargoylesoftware.htmlunit.javascript.host.file.File;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

public class ella {

	WebDriver driver;
	private static CSVReader csvReader;
	static String[] csvCell;

	public static void main(String[] args) throws IOException, InterruptedException {
		String finalScore = "";
		// webdriver define

		System.setProperty("webdriver.chrome.driver",
				"C://Users//abc//Downloads//chromedriver_win32//chromedriver.exe");

		/*Proxy proxy = new Proxy();
		proxy.setAutodetect(false);
		proxy.setHttpProxy("<23.227.38.177:8080>");// Canada
		proxy.setSslProxy("<203.24.109.115:8080>");// Belize
		proxy.setFtpProxy("<185.162.230.132:8080>");// Armenia
		// System.setProperty("https://devorder.crowndigital.io/login", "127.0.0.1");

		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability("proxy", proxy);

		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);

		@SuppressWarnings("deprecation")*/
		WebDriver driver = new ChromeDriver();

		String baseurl = "https://devorder.crowndigital.io/login";
		driver.get(baseurl);
		Thread.sleep(5000);
		// csv read
		CSVReader reader = new CSVReader(new FileReader("C://Users//abc//Downloads//ThousandRecordsS.csv"));
		driver.findElement(By.className("native-input")).click();
		List<String[]> list = reader.readAll();
		System.out.println("Total rows which we have is " + list.size());
		Iterator<String[]> iterator = list.iterator();

		while (iterator.hasNext()) {
			String[] str = iterator.next();
			System.out.print(" Values are ");

			for (int i = 0; i < str.length; i++) {

				driver.navigate().to("https://devorder.crowndigital.io/login");

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
				// System.out.println(dtf.format(dtf));

				String filepath = "C://Users//abc//Downloads//Responsee.csv";
				FileWriter fw = new FileWriter(filepath, true);
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter pw = new PrintWriter(bw);

				pw.println(l.getText().substring(l.getText().length() - 3)+"     "+dtf.format(now));
				pw.flush();
				pw.close();

				// csv write
				/*
				 * CSVWriter writecsv = new CSVWriter(new
				 * FileWriter("C://Users//abc//Downloads//differentnumber1"+i+".csv")); String
				 * set[] = { l.getText()}; writecsv.writeNext(set); writecsv.flush();
				 */

			}
			System.out.println("    ");

		}

	}

}
