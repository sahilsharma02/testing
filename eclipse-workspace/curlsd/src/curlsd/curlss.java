package curlsd;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class curlss {

	public static void main(String[] args) throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C://Users//abc//Downloads//chromedriver_win32//chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		String url = "https://devorder.crowndigital.io/login";
		driver.get(url);
		driver.findElement(By.className("native-input")).sendKeys("98687789");
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		Thread.sleep(3000);
		
		URL obj = new URL(url);
		HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
		con.setRequestMethod("POST");
		String urlParameters = "sn=C02G8416DRJM&cn=&locale=&caller=&num=12345";

		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(urlParameters);
		wr.flush();
		wr.close();
		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Post parameters : " + urlParameters);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		// print result
		System.out.println(response.toString());

	}

}
