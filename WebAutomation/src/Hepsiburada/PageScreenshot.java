package Hepsiburada;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class PageScreenshot {

	public void ScreenShot() throws IOException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\CAN\\Desktop\\chromedriver_win32\\chromedriver.exe" );
		
		TakesScreenshot ts=(TakesScreenshot) ChromeDriverSingleton.getInstance();
		File source=ts.getScreenshotAs(OutputType.FILE);
		String dest=System.getProperty("user.dir")+"/ErrorScreenshot/ScreenshotName.png";
		File destination=new File(dest);
		FileUtils.copyFile(source, destination);
	}

}
