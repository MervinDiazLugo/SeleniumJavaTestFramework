package functions;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.TimeoutException;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
public class Functions {
	boolean retorno;
	private static final WebElement False = null;
	XSSFWorkbook wb;
	XSSFSheet sheet1;
	File src;
	String URLInicial;
	String ruta;
	String ExcelPath = "C:\\workspace\\JavaFramework\\src\\data\\inputData.xlsx";;
	
	public String ScreenShot(WebDriver driver, String TestCaptura)
		
	  {
	      Date fechaActual = new Date();
	               
	        //Formateando la fecha:
	        DateFormat formatoHora = new SimpleDateFormat("HHmmss");
	        DateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
	        String hora = formatoHora.format(fechaActual);
	        String fecha = formatoFecha.format(fechaActual);
	        
	   try {
	    TakesScreenshot ts= (TakesScreenshot)driver;
	    
	    File source= ts.getScreenshotAs(OutputType.FILE);
	    
	    ruta= "C:\\workspace\\JavaFramework\\src\\data\\reportes\\screenshots\\"+fecha+"\\"+TestCaptura+"\\"+TestCaptura+"_("+hora+")"+".png";
	    //C:\\workspace\\GmailTest\\Reportes\\ScreenShots
	    
	    File destino= new File (ruta);
	    
	    FileUtils.copyFile(source, destino);
	    
	    System.out.println("Se tomo la Captura de pantalla en: " + ruta);
	    
	    return ruta;
	    
	   } catch (Exception e) {
	    System.out.println("Error Mientras se Tomaba la Captura de Pantalla "+e.getMessage());
	   }
	   return TestCaptura;
	   
	  }
	
	public Object ExcelDataConfig() throws FileNotFoundException{
		
			try {
				
				src= new File(ExcelPath);
				
				FileInputStream fis = new FileInputStream(src);
				
				wb = new XSSFWorkbook(fis);
				
				return wb;
				
			} catch (IOException e) {
				System.out.println(e.getMessage());
				return ExcelPath;
			}
			
			
			
		}


	public String GetData(int sheetNumber, int row, int colunm){
		
		sheet1 = wb.getSheetAt(sheetNumber);
		
		String data=sheet1.getRow(row).getCell(colunm).getStringCellValue();
		
		return data;
		
	}

	public int GetRowCount(int sheetIndex)
	{
		int row = wb.getSheetAt(sheetIndex).getLastRowNum()+1;
		
		return row;
	}


	public void WriteData(int sheetNumber, int row, int colunm, String Msj) throws IOException{
		

			sheet1 = wb.getSheetAt(sheetNumber);
			sheet1.getRow(row).createCell(colunm).setCellValue(Msj);
			FileOutputStream fout = new FileOutputStream(src);
			wb.write(fout);

		
	}

	public void closeExcel() throws IOException{
		wb.close();
	}
	
//DRIVERS
	public WebDriver GChrome() {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C:\\workspace\\JavaFramework\\src\\librerias\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;

	}
	
	public void IExplorer(String URLInicial) {
		WebDriver driver;
		System.setProperty("webdriver.ie.driver", "..\\librerias\\drivers\\IEDriverServer.exe");
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);

		driver = new InternetExplorerDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(URLInicial);

	}
	
//#########################################################
//######################SELENIUM###########################	
//#########################################################	
	
	public WebElement Xpath_Elements(WebDriver driver, String XPATH){
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			WebElement elemento = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(XPATH)));
			System.out.println("Xpath_Elements: " + XPATH);
			return elemento;
		} catch (WebDriverException e) {
			System.out.println(e);
			System.out.println("Xpath_Elements, No se encontr� el elemento: " + XPATH);
			return False;
		}
	}
	
	public WebElement ID_Elements(WebDriver driver, String ID){
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			WebElement elemento = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(ID)));
			System.out.println("ID_Elements: " + ID);
			return elemento;
		} catch (WebDriverException e) {
			System.out.println(e);
			System.out.println("ID_Elements, No se encontr� el elemento: " + ID);
			return False;
		}
	}
	
	public WebElement CCS_Elements(WebDriver driver, String CCS){
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			WebElement elemento = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(CCS)));
			System.out.println("CCS_Elements: " + CCS);
			return elemento;
		} catch (WebDriverException e) {
			System.out.println(e);
			System.out.println("CCS_Elements, No se encontr� el elemento: " + CCS);
			return False;
		}
	}
	
	public WebElement Link_Elements(WebDriver driver, String LINK){
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			WebElement elemento = wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText(LINK)));
			System.out.println("Link_Elements: " + LINK);
			return elemento;
		} catch (WebDriverException e) {
			System.out.println(e);
			System.out.println("Link_Elements, No se encontr� el elemento: " + LINK);
			return False;
		}
	}
	
	public Select Select_Elements_Xpath(WebDriver driver, String XPATH) throws InterruptedException{
		try {
			Select select = new Select(driver.findElement(By.xpath(XPATH)));
			System.out.println("Select_Elements_Xpath: " + XPATH);
			Thread.sleep(5);
			return select;
		} catch(TimeoutException e) {
			System.out.println(e);
			System.out.println("Select_Elements_Xpath, No se encontr� el elemento: " + XPATH);
			return (Select) False;
		}
	}
	
	public Select Select_Elements_ID(WebDriver driver, String ID) throws InterruptedException{
		try {
			Select select = new Select(driver.findElement(By.id(ID)));
			System.out.println("Select_Elements_ID: " + ID);
			Thread.sleep(4);
			return select;
		} catch (TimeoutException e) {
			System.out.println(e);
			System.out.println("Select_Elements_ID, No se encontr� el elemento: " + ID);
			return (Select) False;
		}
	}
	
	public Select Select_Elements_CSS(WebDriver driver, String CSS) throws InterruptedException{
		try {
			Select select = new Select(driver.findElement(By.cssSelector(CSS)));
			System.out.println("Select_Elements_CSS: " + CSS);
			Thread.sleep(4);
			return select;
		} catch (TimeoutException e) {
			System.out.println(e);
			System.out.println("Select_Elements_CSS, No se encontr� el elemento: " + CSS);
			return (Select) False;
		}
	}
	
	public Select Select_Elements_LINK(WebDriver driver, String LINK) throws InterruptedException{
		try {
			Select select = new Select(driver.findElement(By.partialLinkText(LINK)));
			System.out.println("Select_Elements_LINK: " + LINK);
			Thread.sleep(4);
			return select;
		} catch (TimeoutException e) {
			System.out.println(e);
			System.out.println("Select_Elements_LINK, No se encontr� el elemento: " + LINK);
			return (Select) False;
		}
	}
	
	public WebElement Esperar_Element(WebDriver driver, String XPATH){
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			WebElement elemento = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XPATH)));
			System.out.println("Esperar_Element: " + XPATH);
			return elemento;
		} catch (TimeoutException e) {
			System.out.println(e);
			System.out.println("Esperar_Element, No se encontr� el elemento: " + XPATH);
			return False;
		}
	}
}
	