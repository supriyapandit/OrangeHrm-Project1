package TC;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import java.util.List;

public class tc12 extends basictc {
	 @Test(description = "Test Case 12: Add Products in Cart")
	    @Severity(SeverityLevel.CRITICAL)
	    @Story("Add Products in Cart")
	    @Description("""
	            1. Launch browser
	            2. Navigate to url 'http://automationexercise.com'
	            3. Verify that home page is visible successfully
	            4. Click 'Products' button
	            5. Hover over first product and click 'Add to cart'
	            6. Click 'Continue Shopping' button
	            7. Hover over second product and click 'Add to cart'
	            8. Click 'View Cart' button
	            9. Verify both products are added to Cart
	            10. Verify their prices, quantity and total price""")
	    public void addProductsInCart() {
	        tc1.verifyThatHomePageIsVisibleSuccessfully();
	        verifyBothProductsAreAddedToCart();
	        verifyTheirPricesQuantityAndTotalPrice();
	    }

	    @Step("Verify both products are added to Cart")
	    private void verifyBothProductsAreAddedToCart() {
	        List<String> productNames = new HomePage(getDriver())
	                .productsButtonClick()
	               .addProductsToCart()
	                .getProductsNames();
	        //.blueTopAddToCartButtonClick();
	        Assert.assertEquals(productNames.size(), 2, "Verify both products are added to Cart");
	    }

	    @Step("Verify their prices, quantity and total price")
	    private void verifyTheirPricesQuantityAndTotalPrice() {
	        List<String> prices = new cart(getDriver()).getPrices();
	        List<String> quantity = new cart(getDriver()).getQuantity();
	        List<String> totalPrices = new cart(getDriver()).getTotalPrices();

	        for (int i = 0; i < 2; i++) {
	            Assert.assertEquals(totalPrices.get(i), prices.get(i), "Verify their prices and total price");
	            Assert.assertEquals(quantity.get(i), "1", "Verify their quantity");
	            System.out.println(i + ". Prices = Total Prices | " + prices.get(i) + " = " + totalPrices.get(i));
	            System.out.println(i + ". Quantity = 1 | " + quantity.get(i).equals("1"));
	        }
	    } 
}
