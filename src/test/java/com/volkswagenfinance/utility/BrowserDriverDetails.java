package com.volkswagenfinance.utility;


public enum BrowserDriverDetails {
    chromeForMac("src/test/resources/drivers/chromeForMac/chromedriver"),
    chromeForLinux32("src/test/resources/drivers/chromeForMac.chromeForLinux32/chromedriver"),
    chromeForLinux64("src/test/resources/drivers/chromeForLinux64/chromedriver"),
    chromeForWin32("src/test/resources/drivers/chromeForWin32/chromedriver.exe"),
    chromeForWin64("src/test/resources/drivers/chromeForWin64/chromedriver.exe");

    private String property;

    public void setProperty(String property){
        this.property = property;
    }

    public String getProperty(){
        return property;
    }

    BrowserDriverDetails(String property) {
        this.property = property;
    }


}
