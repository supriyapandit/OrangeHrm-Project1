package TC;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.util;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import pages.signuploginpage;


public class tc3 extends basictc {
	 @Test(description = "tc 3: Login User with incorrect email and password")
	    @Severity(SeverityLevel.CRITICAL)
	    @Story("Login User with incorrect email and password")
	    @Description("""
	            1. Launch browser
	            2. Navigate to url 'http://automationexercise.com'
	            3. Verify that home page is visible successfully
	            4. Click on 'Signup / Login' button
	            5. Verify 'Login to your account' is visible
	            6. Enter incorrect email address and password
	            7. Click 'login' button
	            8. Verify error 'Your email or password is incorrect!' is visible""")
	    public void loginUserWithIncorrectEmailAndPassword() {
	        tc1.verifyThatHomePageIsVisibleSuccessfully();
	        tc2.verifyLoginToYourAccountIsVisible();
	        verifyErrorYourEmailOrPasswordIsIncorrectIsVisible();
	    }

	    @Step("Verify error 'Your email or password is incorrect!' is visible")
	    private void verifyErrorYourEmailOrPasswordIsIncorrectIsVisible() {
	        String email = "email" + util.generateCurrentDateAndTime() + "@incorrect.pl";
	        String password = "pass" + util.generateCurrentDateAndTime();

	        String errorLoginText = new signuploginpage(getDriver())
	                .fillIncorrectLogin(email, password)
	                .getErrorLogin()
	                .getText();
	        Assert.assertEquals(errorLoginText, "Your email or password is incorrect!", "Verify error 'Your email or password is incorrect!' is visible");
	    }
}
