package TC;
import base.reader;
import io.qameta.allure.*;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import java.io.IOException;

@Epic("Regression Tests")
@Feature("Place Order")

public class tc16 extends basictc {
	 @Test(description = "tc 16: Place Order: Login before Checkout")
	    @Severity(SeverityLevel.CRITICAL)
	    @Story("Place Order: Login before Checkout")
	    @Description("""
	            1. Launch browser
	            2. Navigate to url 'http://automationexercise.com'
	            3. Verify that home page is visible successfully
	            4. Click 'Signup / Login' button
	            5. Fill email, password and click 'Login' button
	            6. Verify 'Logged in as username' at top
	            7. Add products to cart
	            8. Click 'Cart' button
	            9. Verify that cart page is displayed
	            10. Click Proceed To Checkout
	            11. Verify Address Details and Review Your Order
	            12. Enter description in comment text area and click 'Place Order'
	            13. Enter payment details: Name on Card, Card Number, CVC, Expiration date
	            14. Click 'Pay and Confirm Order' button
	            15. Verify success message 'Congratulations! Your order has been confirmed!'""")
	    public void placeOrderLoginBeforeCheckout() throws IOException, ParseException {
	        tc1.verifyThatHomePageIsVisibleSuccessfully();
	        new HomePage(getDriver())
	                .signupLoginClick()
	                .fillCorrectLogin(reader.existingUser("email"), reader.existingUser("password"));
	        verifyLoggedInAsUsernameAtTop();
	        tc14.verifyThatCartPageIsDisplayed();
	        new cart(getDriver()).proceedToCheckoutButtonClick();
	        tc14.verifyAddressDetailsAndReviewYourOrder();
	        tc14.verifySuccessMessageCongratulationsYourOrderHasBeenConfirmed();
	    }

	    @Step("Verify 'Logged in as username' at top")
	    private void verifyLoggedInAsUsernameAtTop() throws IOException, ParseException {
	        String username = new LoggedHomePage(getDriver())
	                .getUsername()
	                .getText();
	        Assert.assertEquals(username, reader.existingUser("name"), "Verify 'Logged in as username' at top");
	    }
}
