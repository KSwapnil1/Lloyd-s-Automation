package appHooks;


import com.incessant.bon34.core.GenericMethods;
import utilities.BrowserUtil;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.plugin.event.Result;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class ApplicationHooks extends GenericMethods {


    @Before(order = 0)
    public void initExtentReport(Scenario scenario) {


        try {
            readProperties();
            BrowserUtil browserUtil = new BrowserUtil();
            browserUtil.initialiseBrowser(scenario.getName().replaceAll("[^a-zA-Z0-9]", ""));
            this.getDriver().manage().window().maximize();
            this.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            this.getBrowser().getDriver().get(this.getBrowser().getBrowserProperties().getEnvironmentURL());
            ((JavascriptExecutor) getDriver()).executeScript("window.focus();");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @After(order = 0)
    public void quitBrowser() {
//        getDriver().manage().deleteAllCookies();
//        getDriver().quit();
    }

    @After(order = 1)
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            GenericMethods genericMethods = new GenericMethods();
            String screenshotname = scenario.getName().replaceAll(" ", "_");
            byte[] sourcePath = ((TakesScreenshot) genericMethods.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(sourcePath, "image/png", screenshotname);
        }
        else {
           // attachScreenshot(scenario);
        }


    }
    public void result(Result result) {
        //Code to create logs or store to a database etc...
        result.getError();
        result.getError().getMessage();
    }
}
