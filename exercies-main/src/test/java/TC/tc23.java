package TC;
import base.util;
import io.qameta.allure.*;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;
@Epic("Regression Tests")
@Feature("Verify")

public class tc23 extends basictc {
	 String name = "name" + util.generateCurrentDateAndTime();
	    String email = "email" + util.generateCurrentDateAndTime() + "@o2.pl";

	    @Test(description = "tc 23: Verify address details in checkout page")
	    @Severity(SeverityLevel.CRITICAL)
	    @Story("Verify address details in checkout page")
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
	            12. Verify that the delivery address and the billing address is same address filled at the time registration of account
	            13. Click 'Delete Account' button
	            14. Verify 'ACCOUNT DELETED!' and click 'Continue' button""")
	    public void verifyAddressDetailsInCheckoutPage() throws IOException, ParseException {
	        tc1.verifyThatHomePageIsVisibleSuccessfully();
	        tc14.verifyAccountCreatedAndClickContinueButton(name, email);
	        tc14.verifyLoggedInAsUsernameAtTop(name);
	        tc14.verifyThatCartPageIsDisplayed();
	        verifyThatTheDeliveryAddressAndTheBillingAddressIsSameAddressFilledAtTheTimeRegistrationOfAccount();
	        tc1.verifyThatAccountDeletedIsVisibleAndClickContinueButton();
	    }

	    @Step("Verify that the delivery address and the billing address is same address filled at the time registration of account")
	    private void verifyThatTheDeliveryAddressAndTheBillingAddressIsSameAddressFilledAtTheTimeRegistrationOfAccount() throws IOException, ParseException {
	        tc14.verifyAddressDetails();
	    }
}
