package TC;
import io.qameta.allure.*;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import pages.*;
import java.io.IOException;
public class Tc11 extends basictc {
	 @Test(description = "Tc 11: Verify Subscription in Cart page")
	    @Severity(SeverityLevel.TRIVIAL)
	    @Story("Verify Subscription in Cart page")
	    @Description("""
	            1. Launch browser
	            2. Navigate to url 'http://automationexercise.com'
	            3. Verify that home page is visible successfully
	            4. Click 'Cart' button and scroll down to footer
	            5. Verify text 'SUBSCRIPTION'
	            6. Enter email address in input and click arrow button
	            7. Verify success message 'You have been successfully subscribed!' is visible""")
	    public void verifySubscriptionInCartPage() throws IOException, ParseException {
	        tc1.verifyThatHomePageIsVisibleSuccessfully();
	        new HomePage(getDriver())
	        .cartButtonClick();
	        tc10.verifyTextSubscription();
	        tc10.verifySuccessMessageYouHaveBeenSuccessfullySubscribedIsVisible();
	    }
}
