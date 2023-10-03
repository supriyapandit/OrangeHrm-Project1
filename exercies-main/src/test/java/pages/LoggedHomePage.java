package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoggedHomePage {
	 @FindBy(xpath = "//*[@id='header']/div/div/div/div[2]/div/ul/li[10]/a/b")
	    private WebElement username;

	    @FindBy(xpath = "//header/div/div/div/div[2]/div/ul/li[5]/a")
	    private WebElement deleteAccountButton;

	    @FindBy(xpath = "//header/div/div/div/div[2]/div/ul/li[4]/a")
	    private WebElement logoutButton;

	    private WebDriver driver;

	    public LoggedHomePage(WebDriver driver) {
	        PageFactory.initElements(driver, this);
	        this.driver = driver;
	    }

	    public WebElement getUsername() {
	        return username;
	    }

	    public accountdel deleteAccountButtonClick() {
	        deleteAccountButton.click();
	        return new accountdel(driver);
	    }

	    public signuploginpage logoutButtonClick() {
	        logoutButton.click();
	        return new signuploginpage(driver);
	    }
}
