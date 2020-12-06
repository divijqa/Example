package com.Amensys.testSuite.SignUpPage;

import com.Amensys.Base.commonFunctions;
import com.Amensys.Base.testBase;
import com.Amensys.Pages.logIn;
import com.Amensys.Pages.signUp;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class testSignUP extends testBase {

    signUp signup;
    logIn login;
    commonFunctions commonfunctions;

    /**
     * Selenium Web Driver
     */
    public testSignUP() {
        super(driver);
    }

    @BeforeMethod
    public void setUP(){
        intialization();
        signup = new signUp(driver);
        login = new logIn(driver);
        commonfunctions = new commonFunctions();
    }

    @Test
    public void testSignUpFields(){
        commonfunctions.elementToClick(login.buttonCreateAccount, 5);
        commonfunctions.sendText(signup.firstName, 5, "fname");
        commonfunctions.sendText(signup.lastName, 5, "lname");
        commonfunctions.sendText(signup.emailORMobile, 5, "fname.lname@gmail.com");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        commonfunctions.sendText(signup.reEnterEmail, 5, "fname.lname@gmail.com");
        commonfunctions.sendText(signup.password, 5, "Fl12345678");
        //commonfunctions.elementToClick(signup.male, 5);
        commonfunctions.dropDown(signup.month, "Jan", 5);
        commonfunctions.dropDown(signup.date, "1", 5);
        commonfunctions.dropDown(signup.year, "1999", 5);
        //should fix.....!
        //commonfunctions.selectRadioButton(signup.male, 15, 1);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        /**
         * validations
         */
        //String logosignup = signup.logoSignUp.getText();
        //String logotext = signup.logoText.getText();
        //String agreementtext = signup.agreement.getText();

        Assert.assertEquals(true, signup.firstName.isEnabled());
        Assert.assertEquals(true, signup.lastName.isEnabled());
        Assert.assertEquals(true, signup.emailORMobile.isEnabled());
        Assert.assertEquals(true, signup.reEnterEmail.isEnabled());
        Assert.assertEquals(true, signup.password.isEnabled());
        Assert.assertEquals(true, signup.logoSignUp.isDisplayed());
        Assert.assertEquals(true, signup.logoText.isDisplayed());
        Assert.assertEquals(true, signup.buttonSignUp.isDisplayed());
        Assert.assertEquals(true, signup.agreement.isDisplayed());

        //Assert.assertEquals(logosignup,"Sign Up" );
        //Assert.assertEquals(logotext, "It’s quick and easy.");
        //Assert.assertEquals(agreementtext, agreementtext);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
