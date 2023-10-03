package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.seleniumhelper;

import java.util.List;
import java.util.stream.Collectors;

//import static org.aspectj.runtime.internal.Conversions.intValue;

public class product {
	 @FindBy(css = ".title.text-center")
	    private WebElement titleTextCenter;

	    @FindBy(css = "a[href='/product_details/1']")
	    private WebElement viewProductOfFirstProductButton;

	    @FindBy(id = "search_product")
	    private WebElement searchProductInput;

	    @FindBy(id = "submit_search")
	    private WebElement submitSearchInput;

	    @FindBy(xpath = "//div[contains(@class, 'productinfo text-center')]//p")
	    private List<WebElement> searchResultsNames;

	    @FindBy(css = "a[data-product-id='1']")
	    private WebElement addToCartButton1;

	    @FindBy(css = "a[data-product-id='2']")
	    private WebElement addToCartButton2;

	    @FindBy(css = "button[data-dismiss='modal']")
	    private WebElement continueShoppingButton;

	    @FindBy(css = "a[href='/view_cart'] u")
	    private WebElement viewCartButton;

	    @FindBy(css = "a[href='#Men']")
	    private WebElement menCategory;

	    @FindBy(css = "a[href='/category_products/3']")
	    private WebElement tShirtsCategory;

	    @FindBy(css = "div[class='brands-name']")
	    private WebElement brands;

	    @FindBy(css = "a[href='/brand_products/Polo']")
	    private WebElement poloBrand;

	    @FindBy(css = "a[href='/brand_products/Madame']")
	    private WebElement madameBrand;

	    @FindBy(css = "a[class='btn btn-default add-to-cart']")
	    List<WebElement> addButtons;

	    private WebDriver driver;

	    public product(WebDriver driver) {
	        PageFactory.initElements(driver, this);
	        this.driver = driver;
	    }

	    public WebElement getTitleTextCenter() {
	        return titleTextCenter;
	    }

	    public productdetial viewProductOfFirstProductButtonClick() {
	        viewProductOfFirstProductButton.click();
	        return new productdetial(driver);
	    }

	    public product fillSearchProductInput(String searchProduct) {
	        searchProductInput.sendKeys(searchProduct);
	        submitSearchInput.click();
	        return this;
	    }

	    public List<String> getProductsSearchNames() {
	        return searchResultsNames
	                .stream()
	                .map(WebElement::getText)
	                .collect(Collectors.toList());
	    }

	    public cart addProductsToCart() {
	        seleniumhelper.waitForElementToBeClickable(driver, addToCartButton1);
	        addToCartButton1.click();
	        seleniumhelper.waitForElementToBeClickable(driver, continueShoppingButton);
	        continueShoppingButton.click();
	        seleniumhelper.waitForElementToBeClickable(driver, addToCartButton2);
	        addToCartButton2.click();
	        seleniumhelper.waitForElementToBeClickable(driver, viewCartButton);
	        viewCartButton.click();
	        return new cart(driver);
	    }

	    public product menCategoryClick() {
	        menCategory.click();
	        return this;
	    }

	    public product tShirtsCategoryClick() {
	        tShirtsCategory.click();
	        return this;
	    }

	    public WebElement getBrands() {
	        return brands;
	    }

	    public product poloBrandClick() {
	        poloBrand.click();
	        return this;
	    }

	    public product madameBrandClick() {
	        madameBrand.click();
	        return this;
	    }

	    public product addAllProducts() {
	        for (int i = 0; i < addButtons.size(); i = i + 2) {
	            seleniumhelper.waitForElementToBeClickable(driver, addButtons.get(i));
	            addButtons.get(i).click();
	            seleniumhelper.waitForElementToBeClickable(driver, continueShoppingButton);
	            continueShoppingButton.click();
	        }
	        return this;
	    }

		
}
