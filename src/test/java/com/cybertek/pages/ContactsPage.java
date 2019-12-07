package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage extends BasePage {

    public WebElement getContactEmail(String email){
        String xpath = "//*[contains(text(), '"+email+"') and @data-column-label='Email']";
        return Driver.get().findElement(By.xpath(xpath));
    }
}
