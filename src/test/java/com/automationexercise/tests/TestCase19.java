package com.automationexercise.tests;

import com.automationexercise.pages.HomePage;
import com.automationexercise.pages.ProductsPage;
import io.qameta.allure.*;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

@Epic("Regression Tests")
@Feature("Product")
public class TestCase19 extends TestBasic {
    @Test(description = "Test Case 19: View and Cart Brand Products")
    @Severity(SeverityLevel.CRITICAL)
    @Story("View and Cart Brand Products")
    @Description("""
            1. Launch browser
            2. Navigate to url 'http://automationexercise.com'
            3. Click on 'Products' button
            4. Verify that Brands are visible on left side bar
            5. Click on any brand name
            6. Verify that user is navigated to brand page and brand products are displayed
            7. On left side bar, click on any other brand link
            8. Verify that user is navigated to that brand page and can see products""")

    public void ViewCartBrandProduct(){
        TestCase1.verifyThatHomePageIsVisibleSuccessfully();
        new HomePage(getDriver()).productsButtonClick();
        verifyBrandsAreVisible();
        new ProductsPage(getDriver()).poloBrandClick();
        TestCase18.verifyClothesPageIsVisible();
        new ProductsPage(getDriver()).madameBrandClick();
        TestCase18.verifyClothesPageIsVisible();

    }
    @Step("Verify Brands Are Visible")
    public static void verifyBrandsAreVisible(){
        String productBrandsVisible = new ProductsPage(getDriver())
                .getBrands()
                .getText();
        assertThat(productBrandsVisible, containsString ("POLO"));
    }

}
