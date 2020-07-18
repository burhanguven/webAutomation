package Hepsiburada;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Main{

	public static void main(String[] args) throws InterruptedException, IOException {
		
		LoginCase login=new LoginCase();
		PageScreenshot screenShot=new PageScreenshot();
		ProductSearch p=new ProductSearch();
		//Create driver object for chrome Browser
		System.setProperty("webdriver.chrome.driver","C:\\Users\\CAN\\Desktop\\chromedriver_win32\\chromedriver.exe");
		//yönlendirilen saysa
		ChromeDriverSingleton.getInstance().get("https://www.hepsiburada.com");
		//notifications engellemek için
		ChromeOptionsSingleton.getInstance().addArguments("--disable-notifications");
		//full screen
		ChromeDriverSingleton.getInstance().manage().window().maximize();
		
		try {
			login.Login();
			try {
				p.ProductVisiting();
				ChromeDriverSingleton.getInstance().quit();
			} catch (Exception e) {
				System.out.println(e);
				screenShot.ScreenShot();
			}
		} catch (Exception e) {
			System.out.println(e);
			screenShot.ScreenShot();
		}

	}

}
