package test;
import functions.Functions;
import pages.Registro;
import functions.Config;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;


public class tst_005{
	Config Config = new Config();
	Functions Selenium = new Functions();
	WebDriver driver;
	Registro Registro = new Registro();	
	String TestCaptura = this.getClass().getName();
	
	@BeforeTest(alwaysRun = true)
	public void setUp() throws Exception{
		driver = Selenium.AbrirNavegador();
		driver.get(Config.UrlMercadoLibre);
	} 

	
	@Test
	 public void Test_005() throws InterruptedException{
		
		Selenium.Esperar_Finalizar_Carga(4);
		
		Selenium.ScreenShot(driver, TestCaptura);
		
		Selenium.ir_a_Xpath(driver, Registro.btn_app_xpath);
		
		Selenium.JS_Click_Xpath(driver, Registro.btn_app_xpath);
		
		Selenium.Esperar_Finalizar_Carga(4);
		
		Selenium.ScreenShot(driver, TestCaptura);
	}
	
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}

}
