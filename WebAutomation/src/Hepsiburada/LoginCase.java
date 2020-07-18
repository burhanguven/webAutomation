package Hepsiburada;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;



public class LoginCase {
	
	private static WebElement element;
	
	
	public void Login() throws InterruptedException
	{
		String StartPageTrue="T�rkiye'nin En B�y�k Online Al��veri� Sitesi Hepsiburada.com";
		String LoginButtonTextTrue="Giri� Yap";
		String LoginDropDownTextTrue="Giri� yap";
		String LoginFullPageTrue="�ye Giri� Sayfas� & �ye Ol - Hepsiburada";
		String UserControlTrue="Burhan G�ven";
		String email="";
		String password="";

		String HomePageTitle=ChromeDriverSingleton.getInstance().getTitle();		
		
		if (HomePageTitle.contains(StartPageTrue)) {
			
			System.out.println("Hepsiburada sitesi a��ld�.");
			
			String LoginButtonText=ChromeDriverSingleton.getInstance().findElement(By.xpath("//*[@id=\"myAccount\"]/span/span[1]")).getAttribute("title");
			if (LoginButtonText.contains(LoginButtonTextTrue)) {
				System.out.println("Login Butonunun geldi�i g�r�ld�");
				try {
					//login butonuna t�kla
					ChromeDriverSingleton.getInstance().findElement(By.xpath("//*[@id=\"myAccount\"]/span/span[1]")).click();  
					
					String LoginDropDownText=ChromeDriverSingleton.getInstance().findElement(By.xpath("//*[@id=\"login\"]")).getAttribute("title");
					
					if (LoginDropDownText.contains(LoginDropDownTextTrue)) {
						System.out.println("Dropdown a��ld�");
						Thread.sleep(2000);	
						try {
							ChromeDriverSingleton.getInstance().findElement(By.xpath("//*[@id=\"login\"]")).click();
							
							Thread.sleep(2000);
							String LoginFullPage=ChromeDriverSingleton.getInstance().getTitle();
							if (LoginFullPage.contains(LoginFullPageTrue)) {
								System.out.println("Login full page a��ld�.");
								Thread.sleep(2000);
								try {
									ChromeDriverSingleton.getInstance().findElement(By.xpath("//*[@id=\"txtUserName\"]")).sendKeys(email);
									
									Thread.sleep(2000);
									try {
										ChromeDriverSingleton.getInstance().findElement(By.xpath("//*[@id=\"txtPassword\"]")).sendKeys(password);
										
										Thread.sleep(2000);
										try {
											ChromeDriverSingleton.getInstance().findElement(By.xpath("//*[@id=\"btnLogin\"]")).click();
											System.out.println("Login Olundu.");
											
											Thread.sleep(4000);
											String UserControl=ChromeDriverSingleton.getInstance().findElement(By.xpath("//*[@id=\"myAccount\"]/span/a/span[2]")).getText();
											//login oldukran sonra anasayfada user kontrol�
											if (UserControl.contains(UserControlTrue)) {
												System.out.println("Login oldu�u g�r�ld�.");						
											}
										} catch (Exception e) {
											System.out.println("Login olurken sorun ya�and�!!");
										}	
										
									} catch (Exception e) {
										System.out.println("�ifre girilemedi!!!");
									}
									
								} catch (Exception e) {
									System.out.println("email girilemedi!!!");
								}
								
							}
						} catch (Exception e) {
							System.out.println("DropDown Login butonuna t�klanamad�");
						}
						
					}
				} catch (Exception e) {
					System.out.println("Login butonuna t�klanamad�");
				}		
			}	
		}
	}
	
}
