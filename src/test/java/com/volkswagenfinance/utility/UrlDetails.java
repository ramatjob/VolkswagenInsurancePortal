package com.volkswagenfinance.utility;


public enum UrlDetails {

    //QA environment details
    qa_url_VWFSInsurancePortal("https://covercheck.vwfsinsuranceportal.co.uk/"),

    //UAT environment details
    uat_url_VWFSInsurancePortal("https://covercheck.vwfsinsuranceportal.co.uk/"),

    //Prod environment details
    prod_url_VWFSInsurancePortal("https://covercheck.vwfsinsuranceportal.co.uk/");


    private String property;
    public void setProperty(String property){
        this.property = property;
    }

    public String getProperty(){
        return property;
    }

    UrlDetails(String property) {
        this.property = property;
    }
}
