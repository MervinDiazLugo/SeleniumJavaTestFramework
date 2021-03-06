package test;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import functions.Config;
import functions.Functions;
import pages.Migraciones;

public class tst_004{
	Config Config = new Config();
	Functions Selenium = new Functions();
	WebDriver driver;
	Migraciones Migraciones = new Migraciones();	
	String TestCaptura = this.getClass().getName();
	
	@BeforeTest(alwaysRun = true)
	public void setUp() throws Exception {
		driver = Selenium.AbrirNavegador();
		driver.get(Config.UrlMigraciones);
		
	}
	
	@Test
	 public void Test_004() throws InterruptedException{
		Selenium.ScreenShot(driver, TestCaptura);
		
		Selenium.Select_Elements_Xpath(driver, Migraciones.dpd_Provincia_xpath).selectByVisibleText("BUENOS AIRES");

		Selenium.ScreenShot(driver, TestCaptura);
		
		Selenium.Esperar_Xpath(driver, Migraciones.dpd_MunicipioOpcion_xpath);
		
		Selenium.Esperar_Finalizar_Carga(3);
		
		Selenium.JS_Click_Xpath(driver, Migraciones.dpd_MunicipioOpcion_xpath);
		
		Selenium.Esperar_Finalizar_Carga(3);
		
		Selenium.JS_Click_Xpath(driver, Migraciones.btn_Siguiente_xpath);
		
		Selenium.Esperar_Finalizar_Carga(3);
		
		Selenium.ScreenShot(driver, TestCaptura);
	}
	
	@AfterTest(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}

}
