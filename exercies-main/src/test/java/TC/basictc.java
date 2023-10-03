package TC;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import base.Base;
import base.loader;

public class basictc {
	 protected static ThreadLocal<WebDriver> tdriver = new ThreadLocal<>();

	    public static synchronized WebDriver getDriver() {
	        return tdriver.get();
	    }

	    @BeforeMethod
	    public void setup() throws IOException {
	        String url = loader.loadProperty("url");
	        WebDriver driver = Base.doBrowserSetup();
	        tdriver.set(driver);
	        getDriver().get(url);
	    }

	    @AfterMethod
	    public void tearDown() {
	        getDriver().quit();
	        tdriver.remove();
	    }

}
