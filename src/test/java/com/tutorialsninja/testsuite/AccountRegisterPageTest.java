package com.tutorialsninja.testsuite;

import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.pages.AccountRegisterPage;
import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.pages.MyAccountPage;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class AccountRegisterPageTest extends BaseTest {
    HomePage homePage;
    AccountRegisterPage accountRegisterPage;
    MyAccountPage accountPage;


    @BeforeMethod(alwaysRun = true)
    public void inIT()
    {
        homePage = new HomePage();
        accountRegisterPage = new AccountRegisterPage();
        accountPage = new MyAccountPage();
    }

    @Test(groups = {"sanity","regression"})
    public void verifyUserShouldNavigateToLoginPageSuccessfully() throws InterruptedException {
        homePage.clickOnMyAccountTab();
        homePage.selectMyAccountOptions("Register");
        Thread.sleep(1000);
        Assert.assertEquals(accountRegisterPage.getRegisterAccountText(),
                "Register Account", "Register page not displayed");
    }

    @Test(groups = {"sanity", "smoke","regression"})
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() throws InterruptedException {
        homePage.clickOnMyAccountTab();
        homePage.selectMyAccountOptions("Register");
        Thread.sleep(1000);
        accountRegisterPage.enterFirstName("prime");
        accountRegisterPage.enterLastName("test");
        accountRegisterPage.enterEmail("Poonam2111@gmail.com");
        accountRegisterPage.enterTelephone("07988112233");
        accountRegisterPage.enterPassword("test123");
        accountRegisterPage.enterConfirmPassword("test123");

        accountRegisterPage.selectSubscription("Yes");
        accountRegisterPage.clickOnPrivacyPolicyCheckBox();
        accountRegisterPage.clickOnContinueButton();
//        Assert.assertEquals(accountPage.getYourAccountHasBeenCreatedText(), "Your Account Has Been Created!",
//                "Account not created");
        accountPage.clickOnContinueButton();
        homePage.clickOnMyAccountLink1();
        homePage.selectMyAccountOptions("Logout");
//        Assert.assertEquals(accountPage.getAccountLogoutText(), "Account Logout", "Not logged out");
        accountPage.clickOnContinueButton();
    }
}
