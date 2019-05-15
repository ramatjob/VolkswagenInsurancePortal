package com.volkswagenfinance.utility;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class CommonFunctions {
    WebDriver driver;

    public CommonFunctions(WebDriver driver){
        this.driver = driver;
    }

    public void wait_explicit_till_element_loaded(By by){
        WebDriverWait waitnew=new WebDriverWait(driver,20);
        WebElement element = (WebElement) waitnew.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void enterText(By byProp, String searchText) throws InterruptedException {
        wait_explicit_till_element_loaded(byProp);
        driver.findElement(byProp).sendKeys(searchText);
    }

    public void click(By byProp) throws InterruptedException {
        wait_explicit_till_element_loaded(byProp);
        driver.findElement(byProp).click();
    }

    public String getAnyTextFromWebPage(By prop){
        wait_explicit_till_element_loaded(prop);
        return driver.findElement(prop).getText();
    }

    public void isElementPresentOnWebPage(By byProp,String str1,String str2){
        boolean isElementPresent = false;
        wait_explicit_till_element_loaded(byProp);
        if(driver.findElement(byProp).isDisplayed()){
            isElementPresent = true;
        }

        if(isElementPresent){
            System.out.println(str1+" is present on the "+str2);
        }else{
            System.out.println(str1+" is not present on the "+str2);
            Assert.fail(str1+" is not present on the "+str2+" screen");
        }
    }

    public boolean compareAnyText(String actualString,String expectedString){
        boolean finalResult;
        if(expectedString.equalsIgnoreCase(actualString)){
            System.out.println("Actual string ("+actualString+")  is matched with the Expected string ("+expectedString+")");
            finalResult = true;
        }else{
            System.out.println("Actual string ("+actualString+")  is not matched with the Expected string ("+expectedString+")");
            finalResult = false;
        }
        return finalResult;
    }

    public long compareAnyTwoDates(String coverStartDate, String coverEndDate) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy : hh : mm");
        String dateInString1 = coverStartDate.trim();
        Date startDate = formatter.parse(dateInString1);

        LocalDateTime startDateTime = LocalDateTime.ofInstant(startDate.toInstant(), ZoneId.systemDefault());

        String dateInString2 = coverEndDate.trim();
        Date endDate = formatter.parse(dateInString2);

        LocalDateTime endDateTime = LocalDateTime.ofInstant(endDate.toInstant(), ZoneId.systemDefault());

        return Duration.between(startDateTime,endDateTime).toDays();

    }

}
