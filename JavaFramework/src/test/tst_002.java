package test;
import functions.Config;
import functions.Functions;
import pages.Registro;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

public class tst_002 {
	Config Config = new Config();
	Functions Selenium = new Functions();
	WebDriver driver = Selenium.GChrome();
	Registro Registro = new Registro();	
	String TestCaptura = this.getClass().getName();
	Object Excel;
	
	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
		driver.get(Config.UrlRegistroGmail);
	}
	
	@Test
	 public void Test_002() throws InterruptedException{
		Selenium.Xpath_Elements(driver, Registro.txt_Nombre_xpath).sendKeys("Mervin");
		Selenium.Xpath_Elements(driver, Registro.txt_Apellido_xpath).sendKeys("Diaz");
		Selenium.Xpath_Elements(driver, Registro.txt_Usuario_xpath).sendKeys("AutomationTest");
		
		
		// RETORNO CUANDO UN WEB ELEMENT NO EXISTE / EXISTE
		WebElement Z = Selenium.Esperar_Element(driver, Registro.txt_Nombre_xpath);
		System.out.println(Z);
		
		//Assertion CUANDO UN ELEMENTO EXISTE
		Assert.assertNotNull(Z);
		
		WebElement X = Selenium.Esperar_Element(driver, Registro.txt_ApellidoMAL_xpath);
		System.out.println(X);
		
		//Assertion CUANDO UN ELEMENTO NO EXISTE
		Assert.assertNull(X);
		
		//ASSERTION DE TEXTO
		Assert.assertEquals("Crear tu cuenta de Google", Selenium.Xpath_Elements(driver, Registro.lbl_Titulo_xpath).getText());
		
		Selenium.ScreenShot(driver, TestCaptura);
	}
	
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}

}
