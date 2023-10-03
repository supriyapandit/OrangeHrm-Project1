package TC;
import pages.*;
import base.util;
import io.qameta.allure.*;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;
@Epic("Regression Tests")
@Feature("Place Order")

public class tc15 extends basictc {
	String name = "name" + util.generateCurrentDateAndTime();
    String email = "email" + util.generateCurrentDateAndTime() + "@o2.pl";

    @Test(description = "Test Case 15: Place Order: Register before Checkout")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Place Order: Register before Checkout")
    @Description("""
            1. Launch browser
            2. Navigate to url 'http://automationexercise.com'
            3. Verify that home page is visible successfully
            4. Click 'Signup / Login' button
            5. Fill all details in Signup and create account
            6. Verify 'ACCOUNT CREATED!' and click 'Continue' button
            7. Verify ' Logged in as username' at top
            8. Add products to cart
            9. Click 'Cart' button
            10. Verify that cart page is displayed
            11. Click Proceed To Checkout
            12. Verify Address Details and Review Your Order
            13. Enter description in comment text area and click 'Place Order'
            14. Enter payment details: Name on Card, Card Number, CVC, Expiration date
            15. Click 'Pay and Confirm Order' button
            16. Verify success message 'Congratulations! Your order has been confirmed!'
            17. Click 'Delete Account' button
            18. Verify that 'ACCOUNT DELETED!' and click 'Continue' button""")
    public void placeOrderRegisterBeforeCheckout() throws IOException, ParseException {
        tc1.verifyThatHomePageIsVisibleSuccessfully();
        tc14.verifyAccountCreatedAndClickContinueButton(name, email);
        tc14.verifyLoggedInAsUsernameAtTop(name);
        tc14.verifyThatCartPageIsDisplayed();
        new cart(getDriver()).proceedToCheckoutButtonClick();
        tc14.verifyAddressDetailsAndReviewYourOrder();
        tc14.verifySuccessMessageCongratulationsYourOrderHasBeenConfirmed();
        tc1.verifyThatAccountDeletedIsVisibleAndClickContinueButton();
    }
}
