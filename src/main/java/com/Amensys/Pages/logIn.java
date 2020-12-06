package com.Amensys.Pages;

import com.Amensys.Base.testBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class logIn extends testBase {

    /**
     * Selenium Web Driver
     *
     * @param driver
     */
    public logIn(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /**
     * Web elements
     */

    @FindBy(id = "email")
    public WebElement emailORMobile;

    @FindBy(id = "pass")
    public WebElement passwrd;

    @FindBy(id = "u_0_b")
    public WebElement buttonLogIn;

    @FindBy()
    public WebElement forgotPassword;

    @FindBy(id = "u_0_2")
    public WebElement buttonCreateAccount;

    @FindBy()
    public WebElement buttonCreatePage;




}
