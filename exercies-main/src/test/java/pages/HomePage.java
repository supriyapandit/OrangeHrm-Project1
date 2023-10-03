package pages;
import java.io.IOException;

import org.apache.commons.math3.stat.descriptive.summary.Product;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import TC.basictc;
import base.reader;
import base.seleniumhelper;

public class HomePage extends basictc {
	 @FindBy(css = "div[class='item active'] img[alt='demo website for practice']")
	    private WebElement girlImgResponsive;

	    @FindBy(css = "a[href='/login']")
	    private WebElement signupLoginButton;

	    @FindBy(css = "a[href='/contact_us']")
	    private WebElement contactUsButton;

	    @FindBy(css = "a[href='/test_cases']")
	    private WebElement testCasesButton;

	    @FindBy(css = "a[href='/products']")
	    private WebElement productsButton;
	    @FindBy(css = "a[href='/view_cart']")
	    private WebElement cartButton;

	    @FindBy(css = "a[href='/product_details/1']")
	    private WebElement viewProduct1Button;

	    @FindBy(id = "accordian")
	    private WebElement categories;

	    @FindBy(xpath = "//*[@id='accordian']/div[1]/div[1]/h4/a/span/i")
	    private WebElement womenCategory;

	    @FindBy(css = "a[href='/category_products/1']")
	    private WebElement dressCategory;

	    @FindBy(css = "div[class='recommended_items'] h2")
	    private WebElement recommendedItems;

	    @FindBy(css = "div[id='recommended-item-carousel'] a[class='btn btn-default add-to-cart']")
	    private WebElement blueTopAddToCartButton;

	    @FindBy(css = "div[class='modal-content'] a[href='/view_cart']")
	    private WebElement viewCartButton;

	    @FindBy(id = "scrollUp")
	    private WebElement scrollUpButton;

	    @FindBy(xpath = "//section[1]/div/div/div/div/div/div[1]/div[1]/h2")
	    private WebElement fullFledgedPracticeWebsiteForAutomationEngineers;

	    //footer
	    @FindBy(css = "div[class='single-widget'] h2")
	    private WebElement subscription;

	    @FindBy(id = "susbscribe_email")
	    private WebElement subscribeEmailInput;

	    @FindBy(id = "subscribe")
	    private WebElement subscribeButton;

	    @FindBy(id = "success-subscribe")
	    private WebElement alertSuccessSubscribe;


	    private WebDriver driver;

	    public HomePage(WebDriver driver) {
	        PageFactory.initElements(driver, this);
	        this.driver = driver;
	    }

	    public WebElement homePageIsVisible() {
	        return girlImgResponsive;
	    }

	    public signuploginpage signupLoginClick() {
	        signupLoginButton.click();
	        return new signuploginpage(driver);
	    }

	    public contact contactUsButtonClick() {
	        contactUsButton.click();
	        return new contact(driver);
	    }

	    public testcasepage testCasesButtonClick() {
	        testCasesButton.click();
	        return new testcasepage(driver);
	    }

	    public product productsButtonClick() {
	        productsButton.click();
	        return new product(driver);
	    }

	    public cart cartButtonClick() {
	        cartButton.click();
	        return new cart(driver);
	    }

	    public productdetial viewProduct1ButtonClick() {
	        seleniumhelper.waitForElementToBeClickable(driver, viewProduct1Button);
	        viewProduct1Button.click();
	        return new productdetial(driver);
	    }

	    public WebElement getCategories() {
	        return categories;
	    }

	    public HomePage womenCategoryClick() {
	    	seleniumhelper.waitForElementToBeClickable(driver, womenCategory);
	        womenCategory.click();
	        return this;
	    }

	    public product dressCategoryClick() {
	    	seleniumhelper.waitForElementToBeClickable(driver, dressCategory);
	        dressCategory.click();
	        return new product(driver);
	    }

	    public WebElement getRecommendedItems() {
	        return recommendedItems;
	    }

	    public HomePage blueTopAddToCartButtonClick() {
	    	seleniumhelper.waitForElementToBeClickable(driver, blueTopAddToCartButton);
	        blueTopAddToCartButton.click();
	        return this;
	    }

	    public cart viewCartButtonClick() {
	    	seleniumhelper.waitForElementToBeVisible(driver, viewCartButton);
	        viewCartButton.click();
	        return new cart(driver);
	    }

	    public HomePage scrollUpButtonClick() {
	        scrollUpButton.click();
	        return this;
	    }

	    public WebElement getFullFledgedPracticeWebsiteForAutomationEngineers() {
	    	seleniumhelper.waitForElementToBeVisible(driver, fullFledgedPracticeWebsiteForAutomationEngineers);
	        return fullFledgedPracticeWebsiteForAutomationEngineers;
	    }


	    //footer
	    public WebElement getSubscription() {
	        return subscription;
	    }

	    public HomePage fillSubscribe() throws IOException, ParseException {
	        subscribeEmailInput.sendKeys(reader.existingUser("email"));
	        seleniumhelper.waitForElementToBeClickable(driver, subscribeButton);
	        subscribeButton.click();
	        return this;
	    }

	    public WebElement getAlertSuccessSubscribe() {
	        return alertSuccessSubscribe;
	    }	
}
