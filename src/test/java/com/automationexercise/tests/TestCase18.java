package com.automationexercise.tests;

import com.automationexercise.pages.HomePage;
import com.automationexercise.pages.ProductsPage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

@Epic("Regression Tests")
@Feature("Cart")
public class TestCase18 extends TestBasic {

    @Test(description = "Test Case 18: View Category Products")
    @Severity(SeverityLevel.CRITICAL)
    @Story("View Category Products")
    @Description("""
            1. Launch browser
            2. Navigate to url 'http://automationexercise.com'
            3. Verify that categories are visible on left side bar
            4. Click on 'Women' category
            5. Click on any category link under 'Women' category, for example: Dress
            6. Verify that category page is displayed and confirm text 'WOMEN - DRESS PRODUCTS'
            7. On left side bar, click on any sub-category link of 'Men' category
            8. Verify that user is navigated to that category page""")

    public void productCategory(){
        TestCase1.verifyThatHomePageIsVisibleSuccessfully();
        verifyCategoriesAreVisible();
        new HomePage(getDriver()).womenCategoryClick();
        new HomePage(getDriver()).dressCategoryClick();
        verifyClothesPageIsVisible();
        new ProductsPage(getDriver()).menCategoryClick();
        new ProductsPage(getDriver()).tShirtsCategoryClick();
        verifyClothesPageIsVisible();
    }

    @Step("Verify Categories are visible")
    public static void verifyCategoriesAreVisible() {
        String categoriesAreVisible = new HomePage(getDriver())
                .getCategories()
                .getText();
        Assert.assertEquals(categoriesAreVisible, "WOMEN\n" +
                "MEN\n" +
                "KIDS", "Verify Categories are visible");
    }

    @Step("Verify Clothes Product Page is Visible")
    public static void verifyClothesPageIsVisible(){
        String clothesProductIsVisible = new ProductsPage(getDriver())
                .getTitleTextCenter()
                .getText();
        assertThat(clothesProductIsVisible, containsString ("PRODUCTS"));
    }

}
