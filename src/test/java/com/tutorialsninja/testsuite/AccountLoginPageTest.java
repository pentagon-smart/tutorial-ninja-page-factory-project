package com.tutorialsninja.testsuite;


import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.pages.AccountLoginPage;
import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.pages.MyAccountPage;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class AccountLoginPageTest extends BaseTest {
    HomePage homePage;
    AccountLoginPage accountLoginPage;
    MyAccountPage accountPage;

    @BeforeMethod(alwaysRun = true)
    public void inIT()
    {
        homePage = new HomePage();
        accountLoginPage = new AccountLoginPage();
        accountPage = new MyAccountPage();
    }

    @Test(groups = {"sanity","regression"})
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
        homePage.clickOnMyAccountTab();
        homePage.selectMyAccountOptions("Login");
        Assert.assertEquals(accountLoginPage.getReturningCustomerText(),
                "Returning Customer", "Login page not displayed");
    }

    @Test(groups = {"sanity", "smoke","regression"})
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() {
        homePage.clickOnMyAccountTab();
        homePage.selectMyAccountOptions("Login");
        accountLoginPage.enterEmailAddress("Poonam2111@gmail.com");
        accountLoginPage.enterPassword("test123");
        accountLoginPage.clickOnLoginButton();
        //homePage.clickOnMyAccountTab();
        homePage.selectMyAccountOptions("Logout");
//        Assert.assertEquals(accountPage.getAccountLogoutText(), "Account Logout", "Not logged out");
    }
}
