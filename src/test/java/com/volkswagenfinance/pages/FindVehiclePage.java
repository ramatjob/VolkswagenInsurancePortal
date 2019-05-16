package com.volkswagenfinance.pages;


import com.volkswagenfinance.pageproperties.FindVehiclePageProperty;
import com.volkswagenfinance.utility.CommonFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.text.ParseException;

public class FindVehiclePage extends CommonFunctions {

    By VWFSMainTitleLocator = By.xpath(FindVehiclePageProperty.VWFSMainTitle);
    By VWFSSubTitleLocator = By.xpath(FindVehiclePageProperty.VWFSSubTitile);
    By NoVehicleFoundLocator = By.xpath(FindVehiclePageProperty.NoVehicleFound);
    By ErrorWhenNothingEnteredLocator = By.xpath(FindVehiclePageProperty.ErrorWhenNothingEntered);
    By RegNumberSearchBoxLocator = By.xpath(FindVehiclePageProperty.RegNumberSearchBox);
    By FindVehicleButtonLocator = By.xpath(FindVehiclePageProperty.FindVehicleButton);
    By RegNumberInSearchResultLocator = By.xpath(FindVehiclePageProperty.RegNumberInSearchResult);
    By CoverStartDateLocator = By.xpath(FindVehiclePageProperty.CoverStartDate);
    By CoverEndDateLocator = By.xpath(FindVehiclePageProperty.CoverEndDate);


    WebDriver driver;

    public FindVehiclePage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public void verifyThePageMainTitle(){
        String actualMainTitile = driver.findElement(VWFSMainTitleLocator).getAttribute("href");
        String expectedMainTitle = "http://vwfsinsuranceportal.co.uk/Home.aspx";
        Assert.assertTrue(compareAnyText(actualMainTitile,expectedMainTitle));
    }

    public void verifyThePageSubTitle(){
        String actualSubTitile = getAnyTextFromWebPage(VWFSSubTitleLocator);
        String expectedSubTitle = "Drive Away Insurance";
        Assert.assertTrue(compareAnyText(actualSubTitile,expectedSubTitle));
    }

    public void enterSearchTextIntoSearchBox(String searchText) throws InterruptedException {
        isElementPresentOnWebPage(RegNumberSearchBoxLocator,"Registration Number Search Box", "Volks Wagen Financial Services Page");
        enterText(RegNumberSearchBoxLocator,searchText);
    }

    public void clickOnFindVehicleButton() throws InterruptedException {
        isElementPresentOnWebPage(FindVehicleButtonLocator,"Find Vehicle Button", "Volks Wagen Financial Services Page");
        click(FindVehicleButtonLocator);
    }

    public void verifyTheSearchResult(String expectedRegistrationNumber){

        String actualRegNumber = getAnyTextFromWebPage(RegNumberInSearchResultLocator);
        Assert.assertTrue(actualRegNumber.trim().toLowerCase().contains(expectedRegistrationNumber.toLowerCase()));

        String actualCoverStartDate = getAnyTextFromWebPage(CoverStartDateLocator);
        Assert.assertNotNull(actualCoverStartDate);

        String actualCoverEndDate = getAnyTextFromWebPage(CoverEndDateLocator);
        Assert.assertNotNull(actualCoverEndDate);
    }

    public void verifyTheCoverStartDate(String expectedCoverStartDate){
        String actualCoverStartDate = getAnyTextFromWebPage(CoverStartDateLocator);
        Assert.assertTrue(actualCoverStartDate.trim().equalsIgnoreCase(expectedCoverStartDate.trim()));
    }

    public void verifyTheCoverEndDate(String expectedCoverEndDate){
        String actualCoverEndDate = getAnyTextFromWebPage(CoverEndDateLocator);
        Assert.assertTrue(actualCoverEndDate.trim().equalsIgnoreCase(expectedCoverEndDate.trim()));
    }

    public void verifyCoverEndDateIsGraterThanCoverStartDate() throws ParseException {
        String actualCoverStartDate = getAnyTextFromWebPage(CoverStartDateLocator);
        String actualCoverEndDate = getAnyTextFromWebPage(CoverEndDateLocator);
        Long days = compareAnyTwoDates(actualCoverStartDate,actualCoverEndDate);
        Assert.assertTrue(days >= 1);
    }

    public void verifyWhenNoVehicleFoundDuringSearch(String expectedNoResultMessage){
        String actualNoResultMessage = getAnyTextFromWebPage(NoVehicleFoundLocator);
        Assert.assertTrue(actualNoResultMessage.trim().toLowerCase().contains(expectedNoResultMessage.toLowerCase()));
    }

    public void verifyWErrorWhenNothingenetereInSearchBox(String expectedNothingEnteredErrorMessage){
        String actualNothingEnteredErrorMessage = getAnyTextFromWebPage(ErrorWhenNothingEnteredLocator);
        Assert.assertTrue(actualNothingEnteredErrorMessage.trim().toLowerCase().contains(expectedNothingEnteredErrorMessage.toLowerCase()));
    }

}
