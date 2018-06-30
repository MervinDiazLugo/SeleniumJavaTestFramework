package test;
import functions.Functions;
import pages.Migraciones;
import functions.Config;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class tst_003{
	Config Config = new Config();
	Functions Selenium = new Functions();
	WebDriver driver = Selenium.GChrome();
	Migraciones Migraciones = new Migraciones();	
	String TestCaptura = this.getClass().getName();
	Object Excel;
	
	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
		
		driver.get(Config.UrlMigraciones);
		
	}
	
	@Test
	 public void Test_003() throws InterruptedException{
		Selenium.ScreenShot(driver, TestCaptura);
		
		Selenium.Select_Elements_Xpath(driver, Migraciones.dpd_Provincia_xpath).selectByVisibleText("BUENOS AIRES");

		Selenium.ScreenShot(driver, TestCaptura);
		
		Thread.sleep(5000);//No Usar Thread.sleep, de describira una funcion mas adelante
		
		Selenium.Select_Elements_Xpath(driver, Migraciones.dpd_Municipio_xpath).selectByIndex(5);
		
		
		Selenium.ScreenShot(driver, TestCaptura);
	}
	
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}

}
