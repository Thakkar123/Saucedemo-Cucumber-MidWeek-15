package com.saucedemo.steps;

import com.saucedemo.pages.CheckOutPage;
import com.saucedemo.pages.HomePage;
import com.saucedemo.pages.ProductPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class PurchaseSteps {
    @Given("^I am on saucedemo page$")
    public void iAmOnSaucedemoPage() {
    }


    @When("^I login with credential username \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void iLoginWithCredentialUsernameAndPassword(String username, String password) {

        new HomePage().inputUsername(username);
        new HomePage().inputPassword(password);

    }

    @And("^I click on Login button$")
    public void iClickOnLoginButton() {
        new HomePage().clickOnLoginButton();
    }

    @And("^I filter the products by Price \"([^\"]*)\"$")
    public void iFilterTheProductsByPrice(String text)  {
        new ProductPage().sortProductBy(text);

    }

    @And("^I select cheapest & costliest products and add to basket$")
    public void iSelectCheapestCostliestProductsAndAddToBasket() {
        new ProductPage().selectCheapestProduct();
        new ProductPage().selectCostlierProduct();

    }

    @And("^I open shopping cart$")
    public void iOpenShoppingCart() {
        new ProductPage().clickingOnShoppingCartButton();
    }
    @And("^I go to checkout$")
    public void iGoToCheckout() {
        new CheckOutPage().clickOnCheckOutButton();
    }

    @And("^I enter details firstname \"([^\"]*)\", lastName \"([^\"]*)\" and zipPostalCode \"([^\"]*)\"$")
    public void iEnterDetailsFirstnameLastNameAndZipPostalCode(String firstname, String lastname, String postalcode) {
        new CheckOutPage().enterFirstName(firstname);
        new CheckOutPage().enterLastName(lastname);
        new CheckOutPage().enterPostCode(postalcode);
    }


    @And("^I click on continue button$")
    public void iClickOnContinueButton() {
        new CheckOutPage().clickOnContinueButton();
    }

    @And("^I click on finish button$")
    public void iClickOnFinishButton() {
        new CheckOutPage().clickOnFinishButton();
    }

    @Then("^I should be able to see message 'Thank you for your order'$")
    public void iShouldBeAbleToSeeMessageThankYouForYourOrder() {
        String expectedMessage = "THANK YOU FOR YOUR ORDER";
        String actualMessage = new CheckOutPage().confirmationMessage();
        Assert.assertEquals("confirmation message not displayed",expectedMessage,actualMessage);
    }

}
