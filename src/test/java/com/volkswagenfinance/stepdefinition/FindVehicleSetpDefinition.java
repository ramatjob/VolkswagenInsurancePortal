package com.volkswagenfinance.stepdefinition;


import com.volkswagenfinance.pages.FindVehiclePage;
import com.volkswagenfinance.utility.TestBase;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;

public class FindVehicleSetpDefinition extends TestBase{
    WebDriver driver;

    private FindVehiclePage volksWagenFinancialServicesPageObject;

    @Before
    public void setUpClass() {
        driver = initializeDriver();
    }

    @Given("^I launch the VolksWagen Financial Services home page$")
    public void luanchVolksWagenFinancialHomePage() {
        String url = getUrl("VWFSInsurancePortal");
        driver.get(url);
        volksWagenFinancialServicesPageObject = new FindVehiclePage(driver);
        volksWagenFinancialServicesPageObject.verifyThePageMainTitle();
        volksWagenFinancialServicesPageObject.verifyThePageSubTitle();
    }

    @And("^I enter \"([^\"]*)\" into the search box$")
    public void enterRegNumberIntoSearchBox(String RegistrationNumber) throws InterruptedException {
        volksWagenFinancialServicesPageObject.enterSearchTextIntoSearchBox(RegistrationNumber);
    }

    @And("^I click on the Find Vehicle button$")
    public void clickOnTheFindVehicleButton() throws InterruptedException {
        volksWagenFinancialServicesPageObject.clickOnFindVehicleButton();
    }

    @Then("^I can verify the corresponding search vehicle details for \"([^\"]*)\"$")
    public void verifyTheVehicleDetails(String RegistrationNumber){
        volksWagenFinancialServicesPageObject.verifyTheSearchResult(RegistrationNumber);
    }

    @Then("^I can see a valid \"([^\"]*)\"$")
    public void verifyTheSearchResultWhenNoVehicleFound(String expectedNoResultMessage){
        volksWagenFinancialServicesPageObject.verifyWhenNoVehicleFoundDuringSearch(expectedNoResultMessage);
    }

    @And("^I do not enter anything into the search box$")
    public void doNotEnterRegNumberIntoSearchBox() throws InterruptedException {

    }

    @Then("^I can see a valid message \"([^\"]*)\"$")
    public void verifyErrorMessageWhenNothingEntered(String expectedNothingEnteredErrorMessage){
        volksWagenFinancialServicesPageObject.verifyWErrorWhenNothingenetereInSearchBox(expectedNothingEnteredErrorMessage);
    }

    @After
    public void closedDriver() {
        tearDown();
    }

}
