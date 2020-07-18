package Hepsiburada;

import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeOptionsSingleton {
	
	private static ChromeOptions option;
	
    private ChromeOptionsSingleton(){}

    public static ChromeOptions getInstance(){

        if (option==null) {
        	option=new ChromeOptions();
		}
        return option;
    }
}
