package com.saucedemo.pages;

import com.saucedemo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage extends Utility {

    private static final Logger log = LogManager.getLogger(CheckOutPage.class.getName());

    public CheckOutPage() {
        PageFactory.initElements(driver, this);
    }
    @CacheLookup
    @FindBy(xpath = "//button[@id='checkout']")
    WebElement checkOutButton;
    @CacheLookup
    @FindBy(xpath = "//input[@id='first-name']")
    WebElement firstName;
    @CacheLookup
    @FindBy(xpath = "//input[@id='last-name']")
    WebElement lastName;
    @CacheLookup
    @FindBy(xpath = "//input[@id='postal-code']")
    WebElement postCode;
    @CacheLookup
    @FindBy(xpath = "//input[@id='continue']")
    WebElement continueButton;
    @CacheLookup
    @FindBy(xpath = "//button[@id='finish']")
    WebElement finishButton;
    @CacheLookup
    @FindBy(xpath = "//h2[@class='complete-header']")
    WebElement confirmMessage;

    public void clickOnCheckOutButton() {
        clickOnElement(checkOutButton);
        log.info("Clicking on Checkout button : " + checkOutButton.toString());

    }

    public void enterFirstName(String text) {
        sendTextToElement(firstName, text);
        log.info("enter first name : " + firstName.toString());
    }

    public void enterLastName(String text) {
        sendTextToElement(lastName, text);
        log.info("enter Last name : " + lastName.toString());
    }

    public void enterPostCode(String text) {
        sendTextToElement(postCode, text);
        log.info("enter Postcode : " + postCode.toString());
    }

    public void clickOnContinueButton() {
        clickOnElement(continueButton);
        log.info("Clicking on Continue Button : " + continueButton.toString());
    }

    public void clickOnFinishButton() {
        clickOnElement(finishButton);
        log.info("Clicking on Finish Button : " + finishButton.toString());
    }

    public String confirmationMessage() {
        log.info("Getting Confirm Message : " + confirmMessage.toString());
        return getTextFromElement(confirmMessage);
    }

}
