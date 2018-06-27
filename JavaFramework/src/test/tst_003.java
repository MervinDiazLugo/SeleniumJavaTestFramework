package test;
import functions.Functions;
import pages.Registro;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class tst_003{
	Functions Selenium = new Functions();
	WebDriver driver = Selenium.GChrome();
	Registro Registro = new Registro();	
	String TestCaptura = this.getClass().getName();
	Object Excel;
	
	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
		
		Excel = Selenium.ExcelDataConfig();
		driver.get(Registro.Url2);
		
	}
	
	@Test
	 public void Test_003() throws InterruptedException{
		
		Selenium.Select_Elements_Xpath(driver, Registro.dpd_Provincia_xpath).selectByVisibleText("BUENOS AIRES");

		Selenium.ScreenShot(driver, TestCaptura);
		
		Thread.sleep(5000);
		
		Selenium.Select_Elements_Xpath(driver, Registro.dpd_Municipio_xpath).selectByIndex(5);
		
		Selenium.ScreenShot(driver, TestCaptura);
		
	}
	
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}

}
