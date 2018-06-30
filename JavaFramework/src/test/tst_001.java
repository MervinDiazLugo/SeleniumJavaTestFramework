package test;
import functions.Config;
import functions.Functions;
import pages.Registro;
import java.io.FileNotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

public class tst_001 {
	Config Config = new Config();
	Functions Selenium = new Functions();
	WebDriver driver = Selenium.GChrome();
	Registro Registro = new Registro();	
	String TestCaptura = this.getClass().getName();
	
	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
		
		driver.get(Config.UrlRegistroGmail);
		
		
	}
	
	@Test
	 public void Test_001() throws InterruptedException, FileNotFoundException{
		
		String Nombre = Selenium.LeerExcel(3, 1);
		String Apellido	= Selenium.LeerExcel(3, 2);
		String NombreDeUsuario = Selenium.LeerExcel(3, 3);
		
		Selenium.Xpath_Elements(driver, Registro.txt_Nombre_xpath).sendKeys(Nombre);
		Selenium.Xpath_Elements(driver, Registro.txt_Apellido_xpath).sendKeys(Apellido);
		Selenium.Xpath_Elements(driver, Registro.txt_Usuario_xpath).sendKeys(NombreDeUsuario);
		
		Selenium.ScreenShot(driver, TestCaptura);
		
		

	}
	
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}

}
