package com.Amensys.Pages;

import com.Amensys.Base.testBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class signUp extends testBase {

    //private final Object signUp;

    /**
     * Selenium Web Driver
     *
     * @param driver
     * @param
     */
    public signUp(WebDriver driver) {
        super(driver);
       // this.signUp = signUp;
        PageFactory.initElements(driver, this);
    }

    /**
     * Web elements
     */
    @FindBy (xpath = "//*[@id=\"facebook\"]/body/div[5]/div[2]/div/div/div[1]/div[1]")
    public WebElement logoSignUp;

    @FindBy (xpath = "//*[@id=\"facebook\"]/body/div[5]/div[2]/div/div/div[1]/div[2]")
    public WebElement logoText;

    @FindBy (name = "firstname")
    //@FindBy (id = "u_19_a")
    public WebElement firstName;

    @FindBy (name = "lastname")
    public WebElement lastName;

    @FindBy (name = "reg_email__")
    public WebElement emailORMobile;

    @FindBy (name = "reg_passwd__")
    public WebElement password;

    @FindBy (name = "reg_email_confirmation__")
    public  WebElement reEnterEmail;

    @FindBy (name = "birthday_month")
    //@FindBy (id = "month")
    //@FindBy(css = "#month")
    //@FindBy (xpath = "/html/body/div[5]/div[2]/div/div/div[2]/div[1]/div/div[1]/form/div[1]/div[5]/div[2]/span/span/select[1]")
    public WebElement month;

    @FindBy (name = "birthday_day")
    public WebElement date;

    @FindBy (name = "birthday_year")
    public WebElement year;

    @FindBy (id = "u_19_2")
    //@FindBy (xpath = "//*[@id=\"u_19_2\"]")
    public WebElement female;

    //@FindBy (id = "u_19_3")
    @FindBy (xpath = "//input[@type=’radio’]")
    //@FindBy (css = "#u_19_3")
    //@FindBy (className = "_5k_2 _5dba")
    public WebElement male;

    @FindBy (id = "u_19_4")
    public WebElement custom;

    @FindBy (xpath = "//*[@id=\"u_19_r\"]")
    public WebElement agreement;

    @FindBy (name = "websubmit")
    public WebElement buttonSignUp;


}
