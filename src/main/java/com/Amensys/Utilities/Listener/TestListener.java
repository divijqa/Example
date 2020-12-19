package com.Amensys.Utilities.Listener;

import com.Amensys.Base.testBase;
//import org.apache.tools.ant.util.FileUtils;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestListener extends testBase implements ITestListener {


    /**
     * Selenium Web Driver
     */
    public TestListener() {
        super(driver);
    }

    public static String getTestMethod(ITestResult result) {
        return result.getMethod().getConstructorOrMethod().getName();
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println(" Test Method " + getTestMethod(result) + "started");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println(" Test Method " + getTestMethod(result) + "Success");
        captureScreenShot(result, "pass");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println(" Test Method " + getTestMethod(result) + "Failed");
        captureScreenShot(result, "fail");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test Method" + getTestMethod(result) + "Skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("Test Method" + getTestMethod(result) + "Passes with in success percentage");
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        System.out.println("Test Method" + getTestMethod(result) + "Failed with timeout");

    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Started Test Suite" + context.getName());
        context.setAttribute("Web Driver", this.driver);
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Finished Test Suite" + context.getName());
        context.setAttribute("Web Driver", this.driver);
    }

    public void captureScreenShot(ITestResult result, String status){

        String destinationDir = null;
        String methodPassFail = result.getMethod().getRealClass().getSimpleName() + "." + result.getMethod().getMethodName();
        /**
         * Capture Screen shot
         */
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
        if (status.equalsIgnoreCase("fail")){
            destinationDir = "ScreenShots/Failure";
        }else if (status.equalsIgnoreCase("pass")){
            destinationDir = "ScreenShots/Success";
        }
        new File(destinationDir).mkdirs();
        //Set File Name
        String destinationFile = methodPassFail + "-" + dateFormat.format(new Date()) + ".png";
        try {
            FileUtils.copyFile(srcFile, new File(destinationDir + "/" + destinationFile));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
