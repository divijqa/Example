package com.Amensys.Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class testBase {

    public static WebDriver driver;
    public static Properties prop;
    public static FileInputStream fs;
    public static InputStream inputStream;
    public static String filePath = null;


    /**
     * Selenium Web Driver
     * @param driver
     */
    public testBase(WebDriver driver){
        this.driver = driver;
        propFile();
    }

    /**
     * Selenium Web Driver
     * Getter
     */
    public WebDriver getDriver(){
        return driver;
    }

    /**
     * property File
     */
    public static void propFile(){

        String fileName = "Configuration.properties";
        //String filePath = "";
        try{
            prop = new Properties();
            inputStream = testBase.class.getClassLoader().getResourceAsStream(fileName);
            if(inputStream==null){
                System.out.println("Sorry, unable to find " + fileName);
                return;
            }
            prop.load(inputStream);
            filePath = prop.getProperty("ResourcesPath");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream!=null){
                try{
                    inputStream.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Intializing Browser
     */
    public static void intialization(){
        //propFile();
        String browser = prop.getProperty("browser");
        String webURL = prop.getProperty("url");
        //String fileName = "";

        if (browser.equals("chrome")){
            driver = new ChromeDriver();
        }
        else if (browser.equals("FireFox")){
            driver = new FirefoxDriver();
        }
        else if (browser.equals("Safari")){
            driver = new SafariDriver();
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        /**
         * Initialising URL
         */
        driver.get(webURL);

    }


}
