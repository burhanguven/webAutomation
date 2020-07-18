package Hepsiburada;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverSingleton {
	

	private static WebDriver driver;
	
    private ChromeDriverSingleton(){}

    public static WebDriver getInstance(){

        if (driver==null) {
			driver=new ChromeDriver();
		}
        return driver;
    }
}
