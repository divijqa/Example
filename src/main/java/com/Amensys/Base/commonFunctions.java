package com.Amensys.Base;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;
import java.security.SecureRandom;


public class commonFunctions extends testBase{

    public static SecureRandom secureRnd;
    public static  Random random;
    public static WebDriverWait wait;

    /**
     * Selenium Web Driver
     *
     * @param
     */
    public commonFunctions() {
        super(driver);
    }

    /**
     * Accepting Alert Notifications
     * @param waitTime
     */
    public boolean acceptAlert(int waitTime){
        try {
            wait = new WebDriverWait(driver, waitTime);
            wait.until(ExpectedConditions.alertIsPresent());
            driver.switchTo().alert().accept();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            System.err.println("  no Alert visible after " + waitTime + "sec.");
            return false;
        }
    }

    /**
     * Dismissing Alert Notifications
     * @param waitTime
     * @return
     */
    public boolean declineAlert(int waitTime){
        try {
            wait = new WebDriverWait(driver, waitTime);
            wait.until(ExpectedConditions.alertIsPresent());
            driver.switchTo().alert().dismiss();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            System.err.println("  No Alert Visible after "+ waitTime + "sec.");
            return false;
        }
    }

    /**
     * Click method
     * @param element
     * @param waitTime
     */
    public void elementToClick(WebElement element, int waitTime){
        try {
            wait = new WebDriverWait(driver, waitTime);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
        }catch (NoSuchElementException e){
            e.printStackTrace();
            System.err.println(element + "Not found after waiting for" + waitTime);
        }
    }

    /**
     * Send keys method
     * @param element
     * @param waitTime
     * @param text
     */
    public void sendText(WebElement element, int waitTime, String text){
        try{
            //wait = new WebDriverWait(driver, waitTime);
            //wait.until(ExpectedConditions.visibilityOf(element));
            element.sendKeys(text);
        }catch (NoSuchElementException e){
            e.printStackTrace();
            System.err.println(element + "Not found after waiting for" + waitTime);
        }
    }

    /**
     * Radiobutton Selection
     * @param element
     * @param waitTime
     * @param attribute
     */
    public void selectRadioButton(WebElement element, int waitTime, int attribute){
        List<WebElement> radiobutton = driver.findElements(By.xpath(String.valueOf(element)));
        System.out.println(radiobutton.size());

        try{
            wait = new WebDriverWait(driver, waitTime);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            //element.click();
            radiobutton.get(attribute).click();

        }catch (NoSuchElementException e){
            e.printStackTrace();
            System.err.println(element + "Not found after waiting for" + waitTime);
        }
    }

    /**
     * drop down selection by visible text
     * @param element
     * @param value
     */
    public void dropDown(WebElement element, String value, int waitTime){
        try {
            wait = new WebDriverWait(driver, waitTime);
            wait.until(ExpectedConditions.visibilityOf(element));
           // Select drp = new Select(driver.findElement(By.name(String.valueOf(element))));
            Select selobj = new Select(element);
            //drp.selectByValue(value);
            selobj.selectByVisibleText(value);
        }catch (NoSuchElementException e){
            e.printStackTrace();
            System.err.println(element + "Not found after waiting for" + waitTime);
        }

    }

    /**
     * Random Alpha numeric String
     * @param length
     * @return
     */
    public String randomString(int length){
        final String SOURCE = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "abcdefghijklmnopqrstuvwxyz" ;
        secureRnd = new SecureRandom();
        StringBuilder stringBuilder = new StringBuilder(length);
        for (int i=0; i<length; i++){
            stringBuilder.append(SOURCE.charAt(secureRnd.nextInt(SOURCE.length())));
        }
        return stringBuilder.toString();
    }
}
