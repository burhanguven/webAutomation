package Hepsiburada;



import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class ProductSearch {

	
	static JavascriptExecutor je=(JavascriptExecutor) ChromeDriverSingleton.getInstance();
	private static WebElement element;
	String productControlTrue1,productControlTrue2,productControlTrue3;
	
	
	public void ProductVisiting() throws InterruptedException{
		
		String SepetTrue="Sepet";
		String LastVisitedTrue="Son gezdiðiniz ürünler";
		
		//1. ürün için ürün detayý kontrolü
		element=ChromeDriverSingleton.getInstance().findElement(By.xpath("//*[@id=\"dealoftheday_5\"]/div/div/div[2]/div/div/div/div/div[2]/div/div/a"));
		je.executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		productControlTrue1=element.getAttribute("title");
		try {
			element.click();
			Thread.sleep(2000);
			System.out.println("Ürün detay sayfasý açýldý");
			
			String productDetail=ChromeDriverSingleton.getInstance().findElement(By.xpath("//*[@id=\"product-name\"]")).getText();
			if (productDetail.contains(productControlTrue1)) {
				try {
					ChromeDriverSingleton.getInstance().navigate().back();
					Thread.sleep(2000);
					
					//2. ürün için ürün detayý kontrolü
					element=ChromeDriverSingleton.getInstance().findElement(By.xpath("//*[@id=\"dealoftheday_5\"]/div/div/div[2]/div/div/div/div/div[3]/div/div/a"));
					je.executeScript("arguments[0].scrollIntoView(true);", element);
					Thread.sleep(1000);
					productControlTrue2=element.getAttribute("title");
					try {
						element.click();
						Thread.sleep(2000);
						System.out.println("Ürün detay sayfasý açýldý");
						
						String productDetail2=ChromeDriverSingleton.getInstance().findElement(By.xpath("//*[@id=\"product-name\"]")).getText();
						if (productDetail2.contains(productControlTrue2)) {
							try {
								ChromeDriverSingleton.getInstance().navigate().back();
								Thread.sleep(2000);
								
								//3. ürün detayý kontrolü
								element=ChromeDriverSingleton.getInstance().findElement(By.xpath("//*[@id=\"dealoftheday_5\"]/div/div/div[2]/div/div/div/div/div[4]/div/div/a/span"));
								je.executeScript("arguments[0].scrollIntoView(true);", element);
								Thread.sleep(1000);
								productControlTrue3=element.getAttribute("title");
								try {
									element.click();
									Thread.sleep(2000);
									
									System.out.println("Ürün detay sayfasý açýldý");
									String productDetail3=ChromeDriverSingleton.getInstance().findElement(By.xpath("//*[@id=\"product-name\"]")).getText();
									
									if (productDetail3.contains(productControlTrue3)) {
										try {
											ChromeDriverSingleton.getInstance().navigate().back();
											Thread.sleep(2000);
											element=ChromeDriverSingleton.getInstance().findElement(By.xpath("//*[@id=\"shoppingCart\"]"));
											je.executeScript("arguments[0].scrollIntoView(true);", element);
											Thread.sleep(1000);
											String Sepet=element.getText();
											if (Sepet.contains(SepetTrue)) {
												try {
													element.click();
													System.out.println("Septe sayfasý açýldý");
													
													Thread.sleep(2000);
													element=ChromeDriverSingleton.getInstance().findElement(By.xpath("//*[@id=\"recommended-products\"]/div[2]/div[1]"));
													je.executeScript("arguments[0].scrollIntoView(true);", element);
													Thread.sleep(1000);
													String LastVisited=element.getText();
													if (LastVisited.contains(LastVisitedTrue)) {
														System.out.println("Son ziyaret eldilenler açýldý");
																																			
														String hamperLastVisited1=ChromeDriverSingleton.getInstance().findElement(By.xpath("//*[@id=\"recommended-products\"]/div[2]/ul/div[1]/div/li[1]/li/div/div/div/a/h3")).getAttribute("title");
														String hamperLastVisited2=ChromeDriverSingleton.getInstance().findElement(By.xpath("//*[@id=\"recommended-products\"]/div[2]/ul/div[1]/div/li[2]/li/div/div/div/a/h3")).getAttribute("title");
														String hamperLastVisited3=ChromeDriverSingleton.getInstance().findElement(By.xpath("//*[@id=\"recommended-products\"]/div[2]/ul/div[1]/div/li[3]/li/div/div/div/a/h3")).getAttribute("title");
														
														try {
															if (hamperLastVisited1.contains(productDetail3)) {
																System.out.println(hamperLastVisited1);
																if (hamperLastVisited2.contains(productDetail2)) {
																	System.out.println(hamperLastVisited2);
																	if (hamperLastVisited3.contains(productDetail)) {
																		System.out.println(hamperLastVisited3);
																		Thread.sleep(2000);
																	}
																}
															}											
														} catch (Exception e) {
															System.out.println("Gezilen ürünler 'Son Gezdikleriniz' alanýnda bulunmamamaktadýr."+e);
														}
													}
												} catch (Exception e) {
													System.out.println("Sepete týklanamadý!!: "+e);
												}
											}
											
										} catch (Exception e) {
											System.out.println("Bir önceki sayfaya gidilemedi!!: "+e);
										}
									}
								} catch (Exception e) {
									System.out.println("Ürün detayýna gidilemedi"+e);
								}
			
							} catch (Exception e) {
								System.out.println("Bir önceki sayfaya gidilemedi!!: "+e);
							}
						}

					} catch (Exception e) {
						System.out.println("Ürün detayýna gidilemedi!!"+e);
					}
				} catch (Exception e) {
					System.out.println("Bir önceki sayfaya gidilemedi!!: "+e);
				}
			}

		} catch (Exception e) {
			System.out.println("Ürün detayýna gidilemedi");
		}		
	}
}
