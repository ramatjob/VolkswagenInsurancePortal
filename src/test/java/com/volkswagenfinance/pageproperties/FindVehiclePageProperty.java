package com.volkswagenfinance.pageproperties;


public interface FindVehiclePageProperty {
    public String VWFSMainTitle = "//div[@id='header']/a";
    public String VWFSSubTitile = "//div[@id='dlg-dealersearch-title']";
    public String NoVehicleFound = "//div[@class='result']";
    public String ErrorWhenNothingEntered = "//div[@class='error-required']";
    public String RegNumberSearchBox = "//input[@id='vehicleReg']";
    public String FindVehicleButton = "//button[@name='btnfind']";
    public String RegNumberInSearchResult = "//div[@id='page-container']/div[4]/div[@class='result']";
    public String CoverStartDate = "//div[@id='page-container']/div[4]/div[@class='resultDate-bold'][1]/span";
    public String CoverEndDate = "//div[@id='page-container']/div[4]/div[@class='resultDate-bold'][2]/span";
}
