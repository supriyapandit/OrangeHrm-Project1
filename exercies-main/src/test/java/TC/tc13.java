package TC;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import java.util.List;
@Epic("Regression Tests")
@Feature("Cart")

public class tc13 extends basictc {
	 @Test(description = "tc 13: Verify Product quantity in Cart")
	    @Severity(SeverityLevel.CRITICAL)
	    @Story("Verify Product quantity in Cart")
	    @Description("""
	            1. Launch browser
	            2. Navigate to url 'http://automationexercise.com'
	            3. Verify that home page is visible successfully
	            4. Click 'View Product' for any product on home page
	            5. Verify product detail is opened
	            6. Increase quantity to 4
	            7. Click 'Add to cart' button
	            8. Click 'View Cart' button
	            9. Verify that product is displayed in cart page with exact quantity""")
	    public void verifyProductQuantityInCart() {
	        tc1.verifyThatHomePageIsVisibleSuccessfully();
	        verifyProductDetailIsOpened();
	        verifyThatProductIsDisplayedInCartPageWithExactQuantity();
	    }

	    @Step("Verify product detail is opened")
	    private void verifyProductDetailIsOpened() {
	        new HomePage(getDriver()).viewProduct1ButtonClick();
	        Assert.assertEquals(getDriver().getTitle(), "Automation Exercise - Product Details", "Verify product detail is opened");
	    }

	    @Step("Verify that product is displayed in cart page with exact quantity")
	    private void verifyThatProductIsDisplayedInCartPageWithExactQuantity() {
	        List<String> quantity = new productdetial(getDriver()).increaseQuantity("4")
	                .addToCartButtonClick()
	                .viewCartButtonClick().getQuantity();
	        Assert.assertEquals(quantity.get(0), "4", "Verify that product is displayed in cart page with exact quantity");
	    }
}
