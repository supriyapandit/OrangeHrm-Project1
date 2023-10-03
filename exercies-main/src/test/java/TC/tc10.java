package TC;
import pages.*;
import base.util;
import io.qameta.allure.*;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import java.io.IOException;
import base.*;
public class tc10 extends basictc {
	 @Test(description = "Test Case 10: Verify Subscription in home page")
	    @Severity(SeverityLevel.TRIVIAL)
	    @Story("Verify Subscription in home page")
	    @Description("""
	            1. Launch browser
	            2. Navigate to url 'http://automationexercise.com'
	            3. Verify that home page is visible successfully
	            4. Scroll down to footer
	            5. Verify text 'SUBSCRIPTION'
	            6. Enter email address in input and click arrow button
	            7. Verify success message 'You have been successfully subscribed!' is visible""")
	    public void verifySubscriptionInHomePage() throws IOException, ParseException {
	        tc1.verifyThatHomePageIsVisibleSuccessfully();
	        verifyTextSubscription();
	        verifySuccessMessageYouHaveBeenSuccessfullySubscribedIsVisible();
	    }

	    @Step("Verify text 'SUBSCRIPTION")
	    public static void verifyTextSubscription() {
	        String subscriptionText = new HomePage(getDriver())
	                .getSubscription()
	                .getText();
	        Assert.assertEquals(subscriptionText, "SUBSCRIPTION", "Verify text 'SUBSCRIPTION'");
	    }

	    @Step("Verify success message 'You have been successfully subscribed!' is visible")
	    public static void verifySuccessMessageYouHaveBeenSuccessfullySubscribedIsVisible() throws IOException, ParseException {
	        String messageAlert = new HomePage(getDriver())
	                .fillSubscribe()
	                .getAlertSuccessSubscribe()
	                .getText();
	        Assert.assertEquals(messageAlert, "You have been successfully subscribed!", "Verify success message 'You have been successfully subscribed!' is visible");
	    }
	}
