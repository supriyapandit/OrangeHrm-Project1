package TC;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.json.simple.parser.ParseException;
import base.reader;
import base.util;

import pages.*;

import java.io.IOException;
import java.util.List;
@Epic("Regression Tests")
@Feature("place order")

public class tc14 extends basictc {
	String name = "name" + util.generateCurrentDateAndTime();
    String email = "email" + util.generateCurrentDateAndTime() + "@o2.pl";

    @Test(description = "Test Case 14: Place Order: Register while Checkout")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Place Order: Register while Checkout")
    @Description("""
            1. Launch browser
            2. Navigate to url 'http://automationexercise.com'
            3. Verify that home page is visible successfully
            4. Add products to cart
            5. Click 'Cart' button
            6. Verify that cart page is displayed
            7. Click Proceed To Checkout
            8. Click 'Register / Login' button
            9. Fill all details in Signup and create account
            10. Verify 'ACCOUNT CREATED!' and click 'Continue' button
            11. Verify ' Logged in as username' at top
            12. Click 'Cart' button
            13. Click 'Proceed To Checkout' button
            14. Verify Address Details and Review Your Order
            15. Enter description in comment text area and click 'Place Order'
            16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
            17. Click 'Pay and Confirm Order' button
            18. Verify success message 'Congratulations! Your order has been confirmed!'
            19. Click 'Delete Account' button
            20. Verify 'ACCOUNT DELETED!' and click 'Continue' button""")
    public void placeOrderRegisterWhileCheckout() throws IOException, ParseException {
        tc1.verifyThatHomePageIsVisibleSuccessfully();
        verifyThatCartPageIsDisplayed();
        verifyAccountCreatedAndClickContinueButton(name, email);
        verifyLoggedInAsUsernameAtTop(name);
        verifyAddressDetailsAndReviewYourOrder();
        verifySuccessMessageCongratulationsYourOrderHasBeenConfirmed();
        tc1.verifyThatAccountDeletedIsVisibleAndClickContinueButton();
    }

    @Step("Verify that cart page is displayed")
    public static void verifyThatCartPageIsDisplayed() {
        String shoppingCartText = new product(getDriver())
                .addProductsToCart()
                .getShoppingCart()
                .getText();
        Assert.assertEquals(shoppingCartText, "Shopping Cart", "Verify that cart page is displayed");
    }

    @Step("Verify 'ACCOUNT CREATED!' and click 'Continue' button")
    public static void verifyAccountCreatedAndClickContinueButton(String name, String email) throws IOException, ParseException {
        String accountCreatedText = new HomePage(getDriver())
                .signupLoginClick()
                .fillCorrectSignup(name, email)
                .fillAccountDetails()
                .getAccountCreated()
                .getText();
        Assert.assertEquals(accountCreatedText, "ACCOUNT CREATED!", "Verify 'ACCOUNT CREATED!'");
        new createaccount(getDriver()).continueButtonClick();
    }

    @Step("Verify ' Logged in as username' at top")
    public static void verifyLoggedInAsUsernameAtTop(String name) {
        String username = new LoggedHomePage(getDriver())
                .getUsername()
                .getText();
        Assert.assertEquals(username, name, "Verify ' Logged in as username' at top");
    }

    @Step("Verify Address Details and Review Your Order")
    public static void verifyAddressDetailsAndReviewYourOrder() throws IOException, ParseException, org.json.simple.parser.ParseException {
        verifyAddressDetails();

        List<String> productNames = new cart(getDriver()).getProductsNames();
        List<String> prices = new cart(getDriver()).getPrices();
        List<String> quantity = new cart(getDriver()).getQuantity();
        List<String> totalPrices = new cart(getDriver()).getTotalPrices();
        String totalAmount = new checkout(getDriver()).getTotalAmount().getText();

        for (int i = 0; i < 2; i++) {
            Assert.assertEquals(totalPrices.get(i), prices.get(i), "Verify Review Your Order");
            Assert.assertEquals(quantity.get(i), "1", "Verify Review Your Order");
        }

        Assert.assertEquals(productNames.get(0), "Blue Top", "Verify Review Your Order");
        Assert.assertEquals(productNames.get(1), "Men Tshirt", "Verify Review Your Order");
        Assert.assertEquals(totalAmount, "Rs. 900", "Verify Review Your Order");
    }

    public static void verifyAddressDetails() throws IOException, ParseException, org.json.simple.parser.ParseException {
        List<String> addressDelivery = new HomePage(getDriver())
                .cartButtonClick()
                .proceedToCheckoutLoggedButtonClick()
                .getAddressDelivery();
        List<String> addressInvoice = new checkout(getDriver()).getAddressInvoice();

        Assert.assertEquals(addressDelivery.get(0), "YOUR DELIVERY ADDRESS", "Verify Address Details");
        Assert.assertEquals(addressInvoice.get(0), "YOUR BILLING ADDRESS", "Verify Address Details");

        for (int i = 1; i < 8; i++) {
            Assert.assertEquals(addressDelivery.get(i), addressInvoice.get(i), "Verify Address Details");
        }

        String no1 = "Mr. " + reader.accountDetails("firstName") + " " + reader.accountDetails("lastName");
        String no2 = reader.accountDetails("company");
        String no3 = reader.accountDetails("address1");
        String no4 = reader.accountDetails("address2");
        String no5 = reader.accountDetails("city") + " " + reader.accountDetails("state") + " " + reader.accountDetails("zipcode");
        String no6 = reader.accountDetails("country");
        String no7 = reader.accountDetails("mobileNumber");

        Assert.assertEquals(addressDelivery.get(1), no1, "Verify Address Details");
        Assert.assertEquals(addressDelivery.get(2), no2, "Verify Address Details");
        Assert.assertEquals(addressDelivery.get(3), no3, "Verify Address Details");
        Assert.assertEquals(addressDelivery.get(4), no4, "Verify Address Details");
        Assert.assertEquals(addressDelivery.get(5), no5, "Verify Address Details");
        Assert.assertEquals(addressDelivery.get(6), no6, "Verify Address Details");
        Assert.assertEquals(addressDelivery.get(7), no7, "Verify Address Details");
    }

    @Step("Verify success message 'Congratulations! Your order has been confirmed!'")
    public static void verifySuccessMessageCongratulationsYourOrderHasBeenConfirmed() throws IOException, ParseException, org.json.simple.parser.ParseException {
        String alertSuccessText = new checkout(getDriver())
                .enterComment("Sed fringilla aliquet turpis, ut vestibulum orci vulputate sit amet.")
                .fillPaymentDetails()
                .getSuccessMessage()
                .getText();
        Assert.assertEquals(alertSuccessText, "Congratulations! Your order has been confirmed!", "Verify success message 'Congratulations! Your order has been confirmed!'");
    }
}
