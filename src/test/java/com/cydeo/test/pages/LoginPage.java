package com.cydeo.test.pages;


import com.cydeo.test.utility.ConfigurationReader;
import com.cydeo.test.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "inputEmail")
    public WebElement emailBox;

    @FindBy(id = "inputPassword")
    public WebElement passwordBox;

    @FindBy(tagName = "button")
    public WebElement loginButton;



    public void login(String userType){

        String username= ConfigurationReader.getProperty(userType+"_username");
        String password=ConfigurationReader.getProperty("password");


        emailBox.sendKeys(username);
        passwordBox.sendKeys(password);
        loginButton.click();

    }

}


