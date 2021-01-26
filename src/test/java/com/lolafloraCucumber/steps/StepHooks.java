package com.lolafloraCucumber.steps;

import com.lolafloraCucumber.driver.DriverFactory;
import com.lolafloraCucumber.jira.JiraServiceProvider;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import net.rcarz.jiraclient.JiraException;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;

public class StepHooks{

    private Logger logger;
    protected static WebDriver driver;

    @Before
    public void initialize() throws IOException {
        driver = DriverFactory.getDriver();
        logger = Logger.getLogger("RESULT");
    }

    @After
    public void tearDown(Scenario scenario) throws IOException, JiraException {
        if(scenario.isFailed()){
            logger.error("Test case has been failed");
            String screenshotName = scenario.getName().replaceAll(" ", "_");
            TakesScreenshot ts = (TakesScreenshot) driver;
            byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
            File file = ts.getScreenshotAs(OutputType.FILE);
            scenario.attach(screenshot, "image/png", screenshotName);

            JiraServiceProvider jiraServiceProvider = new JiraServiceProvider("https://team-1611692544842.atlassian.net/",
                    "erendegerli@hotmail.com", "1iYJ1ZJvHAmxgkAC7gGA2ACC", "EREN");

            jiraServiceProvider.createJiraTicket("Bug", scenario.getName(), scenario.getName() + " Bug Issue", file);

        }else logger.info("Test case has been successful");

        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
