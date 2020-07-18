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
		String StartPageTrue="Türkiye'nin En Büyük Online Alýþveriþ Sitesi Hepsiburada.com";
		String LoginButtonTextTrue="Giriþ Yap";
		String LoginDropDownTextTrue="Giriþ yap";
		String LoginFullPageTrue="Üye Giriþ Sayfasý & Üye Ol - Hepsiburada";
		String UserControlTrue="Burhan Güven";
		String email="";
		String password="";

		String HomePageTitle=ChromeDriverSingleton.getInstance().getTitle();		
		
		if (HomePageTitle.contains(StartPageTrue)) {
			
			System.out.println("Hepsiburada sitesi açýldý.");
			
			String LoginButtonText=ChromeDriverSingleton.getInstance().findElement(By.xpath("//*[@id=\"myAccount\"]/span/span[1]")).getAttribute("title");
			if (LoginButtonText.contains(LoginButtonTextTrue)) {
				System.out.println("Login Butonunun geldiði görüldü");
				try {
					//login butonuna týkla
					ChromeDriverSingleton.getInstance().findElement(By.xpath("//*[@id=\"myAccount\"]/span/span[1]")).click();  
					
					String LoginDropDownText=ChromeDriverSingleton.getInstance().findElement(By.xpath("//*[@id=\"login\"]")).getAttribute("title");
					
					if (LoginDropDownText.contains(LoginDropDownTextTrue)) {
						System.out.println("Dropdown açýldý");
						Thread.sleep(2000);	
						try {
							ChromeDriverSingleton.getInstance().findElement(By.xpath("//*[@id=\"login\"]")).click();
							
							Thread.sleep(2000);
							String LoginFullPage=ChromeDriverSingleton.getInstance().getTitle();
							if (LoginFullPage.contains(LoginFullPageTrue)) {
								System.out.println("Login full page açýldý.");
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
											//login oldukran sonra anasayfada user kontrolü
											if (UserControl.contains(UserControlTrue)) {
												System.out.println("Login olduðu görüldü.");						
											}
										} catch (Exception e) {
											System.out.println("Login olurken sorun yaþandý!!");
										}	
										
									} catch (Exception e) {
										System.out.println("þifre girilemedi!!!");
									}
									
								} catch (Exception e) {
									System.out.println("email girilemedi!!!");
								}
								
							}
						} catch (Exception e) {
							System.out.println("DropDown Login butonuna týklanamadý");
						}
						
					}
				} catch (Exception e) {
					System.out.println("Login butonuna týklanamadý");
				}		
			}	
		}
	}
	
}
