package com.automationexercise.tests;

import com.automationexercise.pages.HomePage;
import io.qameta.allure.*;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

@Epic("Regression Tests")
@Feature("Product")
public class TestCase20 extends TestBasic {
    @Test(description = "Test Case 20: View and Cart Brand Products")
    @Severity(SeverityLevel.CRITICAL)
    @Story("View and Cart Brand Products")
    @Description("""
            1. Launch browser
            2. Navigate to url 'http://automationexercise.com'
            3. Click on 'Products' button
            4. Verify user is navigated to ALL PRODUCTS page successfully
            5. Enter product name in search input and click search button
            6. Verify 'SEARCHED PRODUCTS' is visible
            7. Verify all the products related to search are visible
            8. Add those products to cart
            9. Click 'Cart' button and verify that products are visible in cart
            10. Click 'Signup / Login' button and submit login details
            11. Again, go to Cart page
            12. Verify that those products are visible in cart after login as well""")

    public void searchProductVerifyCart() throws IOException, ParseException {
        TestCase1.verifyThatHomePageIsVisibleSuccessfully();
        TestCase8.verifyUserIsNavigatedToAllProductsPageSuccessfully();
        TestCase9.verifySearchedProductsIsVisible();
        TestCase9.verifyAllTheProductsRelatedToSearchAreVisible();
        verifyAllProductsAreAddedToCart();
        new HomePage(getDriver()).cartButtonClick();
        TestCase2.verifyLoginToYourAccountIsVisible();
        TestCase2.loginUserWithCorrectEmailAndPassword();
        new HomePage(getDriver()).viewCartButtonClick();
        verifyAllProductsAreAddedToCart();
    }

    @Step("Verify all products are added to Cart")
    private void verifyAllProductsAreAddedToCart() {
        List<String> productNames = new HomePage(getDriver())
                .productsButtonClick()
                .addAllProductToCart()
                .getProductsNames();
        Assert.assertEquals(productNames.size(), 7, "Verify all products are added to Cart");
    }
}
