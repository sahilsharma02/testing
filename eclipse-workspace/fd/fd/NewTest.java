package fd;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;

public class ella {
	@Test
	WebDriver driver;
	private static CSVReader csvReader;
	static String[] csvCell;

	public void f() {
	  
		String finalScore = "";
		System.setProperty("webdriver.chrome.driver",
				"C://Users//abc//Downloads//chromedriver_win32//chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		String baseurl = "https://devorder.crowndigital.io/login";
		driver.get(baseurl);
		Thread.sleep(3000);
		CSVReader reader = new CSVReader(new FileReader("C://Users//abc//Downloads//sheet142.csv"));
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
				
				ZonedDateTime zdt = ZonedDateTime.now();
				DateTimeFormatter dtf = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL);
				String formatteDate = zdt.format(dtf);
				
				String filepath = "C://Users//abc//Downloads//sahil12-" + dtf + ".csv";
				FileWriter fw = new FileWriter(filepath, true);
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter pw = new PrintWriter(bw);

				pw.println(l.getText().substring(l.getText().length() - 3));
				pw.flush();
				pw.close();


			}
			System.out.println("    ");

		}

	}