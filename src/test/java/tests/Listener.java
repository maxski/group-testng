package tests;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by pc on 07.05.2016.
 */
public class Listener implements org.testng.ITestListener {
    private int i = 0;

    @Override
    public void onTestStart(ITestResult result) {
        System.setProperty("org.uncommons.reportng.escape-output", "false");
        Reporter.log("<br/><a href=../../" + getScreenshot(result.getName() + ++i) + " color='red'>click to open screenshot</a>", true);
    }

    public String getScreenshot(String name){
        String path = "target/" + name + ".png";
        System.setProperty("webdriver.chrome.driver", "c:/job/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        driver.quit();
        System.out.println(path);
        scrFile.renameTo(new File(path));
        return name + ".png";
    }


    @Override
    public void onTestSuccess(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {

    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {
    }
}
