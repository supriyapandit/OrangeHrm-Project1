package methods;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.List;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.LoginObject;

public class Base {
	
	
	// Creating constant global variables
	public static final String filePath = "C:\\Users\\Dell\\Desktop\\dell-Selenium\\url data.xlsx";
	public static final String sheetName = "Generic";
	public static final String sheetNameTest = "Orane HRM Login";
	
	
	// Creating driver instance
	
	public static WebDriver driver = new FirefoxDriver();
	
	// Importing required classes and objects
	
	SoftAssert a = new SoftAssert();
	LoginObject page = new LoginObject(driver);
	
	// Method to launch application
	public void launchApp(String url) {
		Reporter.log("=====Browser Session Started=====", true);
		WebDriverManager.firefoxdriver().setup();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		Reporter.log("=====Application Started=====", true);
	}

	// Method to close the brower instance
	public void closeApp() {
		driver.close();
		Reporter.log("=====Browser Session End=====", true);
	}
	
	// Method to login to the application
	public void login() {
		page.uid_text.sendKeys(readDataFromExcel(3, 2, filePath, sheetNameTest));
		page.pwd_text.sendKeys(readDataFromExcel(3, 3, filePath, sheetNameTest));
		page.login_btn.click();
		Reporter.log("=====Application Logged in successfully=====", true);
	}
	
	// Method to logout the application
	public void logOut() {
		page.user_dropDown.click();
		page.logout.click();
		Reporter.log("=====Application Logged out=====", true);
	}
	
	

	// Method to check whether the url equals to specific string or not
	public void urlEquals(String expectedUrl) {
		String actualUrl = driver.getCurrentUrl();
		assertEquals(actualUrl, expectedUrl, "Actual Url is equal to the expected URL(" + expectedUrl + ")Url");
	}
	
	// Method to check whether url contains specifx string or not
	
	public void urlContains(String expectedUrl) {
		String actualUrl = driver.getCurrentUrl();
		if(actualUrl.contains(expectedUrl)) {
			System.out.println("Pass");	
		}
		else {
			System.out.println("Fail");
		}
	}

	// Method to verify the title is equal to expected title
	public void titleEquals(String expectedTitle) {
		String actualTitle = driver.getTitle();
		assertEquals(actualTitle, expectedTitle,"Actual Title is equal to the expected Title(" + expectedTitle + ")");
	}

	// Method to verify the innerHtmlText of the single webelement is equal to the expected text
	public void innerTextEquals(WebElement element, String expectedText) {
		String actualText = element.getText();
		assertEquals(actualText, expectedText);
	}
	
	// Method to verify the innerHtmlText of the multiple webelement is equal to the expected text
	public void multipleInnerTextEquals(List<WebElement> element, String expectedText) {
		for(WebElement data: element) {
			String actualText = data.getText();
			assertEquals(actualText, expectedText);	
		}
			
	}

	// Method to verify whether the element is available in the application or not
	public void elementAvailable(WebElement element, boolean expectedValue) {
		boolean actualValue = element.isDisplayed();
		assertEquals(actualValue, expectedValue);
	}

	// Method to verify whether the element is enabled in the application or not
	public void elementEnabled(WebElement element, boolean expectedValue) {
		boolean actualValue = element.isEnabled();
		assertEquals(actualValue, expectedValue);
	}

	// Method to verify whether the element is selected in the application or not
	public void elementSelected(WebElement element, boolean expectedValue) {
		boolean actualValue = element.isEnabled();
		assertEquals(actualValue, expectedValue);
	}
	
	// Import workbook to get the data from the excel
	public String readDataFromExcel(int rowcount,int columncount,String filepath,String Sheetname)
    {
        String data = null;
        try
        {
            FileInputStream input= new FileInputStream(filepath);
            @SuppressWarnings("resource")
			XSSFWorkbook wb=new XSSFWorkbook(input);
            XSSFSheet sh=wb.getSheet(Sheetname);
            XSSFRow row=sh.getRow(rowcount);
            DataFormatter df = new DataFormatter();
            data = df.formatCellValue(row.getCell(columncount));
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return data;
     }
	

}
