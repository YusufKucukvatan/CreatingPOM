package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactInformationPage extends BasePage {

    @FindBy(className="user-name")
    public WebElement contactFullName;
    @FindBy(css="a.phone")
    public WebElement phone;
    @FindBy(css="a.email")
    public WebElement email;

    public WebElement getUsername(){
        return contactFullName;
    }
    public WebElement getPhone(){
        return contactFullName;
    }
    public WebElement getEmail(){
        return contactFullName;
    }

}
