package com.tutorialsninja.testsuite;


import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.pages.ComponentsPage;
import com.tutorialsninja.pages.DesktopPage;
import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.pages.LaptopsAndNotebooksPage;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class TopMenuTest extends BaseTest {
    HomePage homePage;
    DesktopPage desktopPage;
    LaptopsAndNotebooksPage laptopsAndNotebooksPage;
    ComponentsPage componentsPage;
    @BeforeMethod(alwaysRun = true)
    public void inIT()
    {
        homePage = new HomePage();
        desktopPage = new DesktopPage();
        laptopsAndNotebooksPage = new LaptopsAndNotebooksPage();
        componentsPage = new ComponentsPage();

    }

    @Test(groups = {"sanity","regression"})
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
        homePage.mouseHoverOnDesktopsLinkAndClick();
        homePage.selectMenu("Show AllDesktops");
        String expectedText = "Desktops";
        String actualText = desktopPage.getDesktopsText();
        Assert.assertEquals(actualText, expectedText, "Not navigate to Desktop page");
    }

    @Test(groups = {"sanity", "smoke","regression"})
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() {
        homePage.mouseHoverOnLaptopsAndNotebooksLinkAndClick();
        homePage.selectMenu("Show AllLaptops & Notebooks");
        Assert.assertEquals(laptopsAndNotebooksPage.getLaptopsAndNotebooksText(),
                "Laptops & Notebooks", "Not navigate to Laptops and Notebooks page");
    }

    @Test(groups = {"smoke","regression"})
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() throws InterruptedException {
        homePage.mouseHoverOnComponentLinkAndClick();
        Thread.sleep(1000);
        homePage.selectMenu("Show AllComponents");
        Assert.assertEquals(componentsPage.getComponentsText(),
                "Components", "Not navigate to Laptops and Notebooks page");
    }
}
