package pages;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import base.reader;
import java.io.IOException;
import base.seleniumhelper;
public class productdetial {

	    @FindBy(css = "div[class='product-information'] h2")
	    private WebElement productName;

	    @FindBy(xpath = "//section/div/div/div[2]/div[2]/div[2]/div/p[1]")
	    private WebElement productCategory;

	    @FindBy(css = "div[class='product-information'] span span")
	    private WebElement productPrice;

	    @FindBy(xpath = "//section/div/div/div[2]/div[2]/div[2]/div/p[2]")
	    private WebElement productAvailability;

	    @FindBy(xpath = "//section/div/div/div[2]/div[2]/div[2]/div/p[3]")
	    private WebElement productCondition;

	    @FindBy(xpath = "//section/div/div/div[2]/div[2]/div[2]/div/p[4]")
	    private WebElement productBrand;

	    @FindBy(id = "quantity")
	    private WebElement quantityInput;

	    @FindBy(css = "button[class='btn btn-default cart']")
	    private WebElement addToCartButton;

	    @FindBy(css = "a[href='/view_cart'] u")
	    private WebElement viewCartButton;

	    @FindBy(css = "a[href='#reviews']")
	    private WebElement writeYourReview;

	    @FindBy(id = "name")
	    private WebElement yourNameInput;

	    @FindBy(id = "email")
	    private WebElement emailAddress;

	    @FindBy(id = "review")
	    private WebElement addReviewHere;

	    @FindBy(id = "button-review")
	    private WebElement submitButton;

	    @FindBy(css = "div[class='alert-success alert'] span")
	    private WebElement successMessage;

	    private WebDriver driver;

	    public productdetial(WebDriver driver) {
	        PageFactory.initElements(driver, this);
	        this.driver = driver;
	    }

	    public WebElement getProductName() {
	        return productName;
	    }

	    public WebElement getProductCategory() {
	        return productCategory;
	    }

	    public WebElement getProductPrice() {
	        return productPrice;
	    }

	    public WebElement getProductAvailability() {
	        return productAvailability;
	    }

	    public WebElement getProductCondition() {
	        return productCondition;
	    }

	    public WebElement getProductBrand() {
	        return productBrand;
	    }

	    public productdetial increaseQuantity(String value) {
	        quantityInput.clear();
	        quantityInput.sendKeys(value);
	        return this;
	    }

	    public productdetial addToCartButtonClick() {
	        addToCartButton.click();
	        return this;
	    }

	    public cart viewCartButtonClick() {
	        seleniumhelper.waitForElementToBeClickable(driver, viewCartButton);
	        viewCartButton.click();
	        return new cart(driver);
	    }

	    public WebElement getWriteYourReview() {
	        return writeYourReview;
	    }

	    public productdetial fillReview() throws IOException, ParseException {
	        yourNameInput.sendKeys(reader.existingUser("name"));
	        emailAddress.sendKeys(reader.existingUser("email"));
	        addReviewHere.sendKeys("Lorem ipsum dolor sit amet, consectetur adipiscing elit." +
	                " Sed viverra, elit quis interdum feugiat, mi urna aliquam est, at venenatis quam odio et nisl." +
	                " In at massa sit amet dui hendrerit mattis ac sit amet erat.");
	        submitButton.click();
	        return this;
	    }

	    public WebElement getSuccessMessage() {
	        return successMessage;
	    }
}
