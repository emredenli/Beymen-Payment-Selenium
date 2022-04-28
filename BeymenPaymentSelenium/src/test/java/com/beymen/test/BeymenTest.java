package com.beymen.test;

import com.beymen.driver.BaseTest;
import com.beymen.pages.BeymenPage;
import com.beymen.pages.HomePage;
import org.junit.Test;

public class BeymenTest extends BaseTest {

    @Test
    public void beymenTest(){
        HomePage homePage = new HomePage(driver);
        BeymenPage beymenPage = new BeymenPage(driver);

        homePage.home();
        homePage.infoClose();
        beymenPage.textControl();
        beymenPage.searchButtonControl();
        beymenPage.sendSearch();
        beymenPage.searchButtonControl();
        beymenPage.clickSearchButton();
        beymenPage.randomChoose();
        beymenPage.sizeChoose();
        beymenPage.addBasket();
        beymenPage.amountIncreases();
        beymenPage.continueButton();
        beymenPage.forgotPasswordButton();
        beymenPage.formFill();

    }
}
