package pages;
import base.seleniumhelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class testcasepage {
	 @FindBy(css = "h2[class='title text-center'] b")
	    private WebElement testCases;

	    private WebDriver driver;

	    public testcasepage(WebDriver driver) {
	        PageFactory.initElements(driver, this);
	        this.driver = driver;
	    }

	    public WebElement getTestCases() {
	        seleniumhelper.waitForElementToBeVisible(driver, testCases);
	        return testCases;
	    }
}
