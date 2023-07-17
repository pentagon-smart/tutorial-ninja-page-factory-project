package com.tutorialsninja.pages;

import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*")
    List<WebElement> topMenu;
    @CacheLookup
    @FindBy(xpath = "//a[text()='Desktops']")
    WebElement desktopLink;
    @CacheLookup
    @FindBy(xpath = "//a[text()='Laptops & Notebooks']")
    WebElement laptopsAndNotebooksLink;
    @CacheLookup
    @FindBy(xpath = "//a[text()='Components']")
    WebElement componentsLinks;
    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Currency')]")
    WebElement currencyTab;
    @CacheLookup
    @FindBy(xpath = "//ul[@class = 'dropdown-menu']/li")
    List<WebElement> currencyList;


    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'My Account')]")
    WebElement myAccountTab;
    @CacheLookup
    @FindBy(xpath = "//div[@id='top-links']//li[contains(@class,'open')]/ul/li")
    List<WebElement> myAccountOptions;
    @CacheLookup
    @FindBy(xpath = "//div[@class='list-group']//a[text()='My Account']")
    WebElement myAccount;


    public void selectMenu(String menu) {
        List<WebElement> topMenuList = getListOfElements(topMenu);
        try {
            for (WebElement element : topMenuList) {
                if (element.getText().equalsIgnoreCase(menu)) {
                    element.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            topMenuList = getListOfElements(topMenu);
        }
    }

    public void mouseHoverOnDesktopsLinkAndClick() {
        mouseHoverToElementAndClick(desktopLink);
    }

    public void mouseHoverOnLaptopsAndNotebooksLinkAndClick() {
        mouseHoverToElementAndClick(laptopsAndNotebooksLink);
    }

    public void mouseHoverOnComponentLinkAndClick() {
        mouseHoverToElementAndClick(componentsLinks);
    }

    public void selectCurrency(String currency) {
        clickOnElement(currencyTab);
        List<WebElement> listOfElements = getListOfElements(currencyList);
        for (WebElement e : listOfElements) {
            if (e.getText().equalsIgnoreCase(currency)) {
                e.click();
                break;
            }
        }
    }

    public void clickOnMyAccountTab() {
        clickOnElement(myAccountTab);
    }

    public void clickOnMyAccountLink1(){
        clickOnElement(myAccount);
    }

    public void selectMyAccountOptions(String option) {
        List<WebElement> myAccountList = getListOfElements(myAccountOptions);
        try {
            for (WebElement options : myAccountList) {
                if (options.getText().equalsIgnoreCase(option)) {
                    options.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            myAccountList = getListOfElements(myAccountOptions);
        }
    }
}
