package com.lolafloraCucumber.steps;

import com.lolafloraCucumber.pages.DashBoardPage;
import com.lolafloraCucumber.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.eo.Se;
import io.cucumber.java.hu.De;
import io.qameta.allure.*;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Severity(SeverityLevel.CRITICAL)
@Feature("Title Feature Check")
@Epic("Title Epic Check")
public class LoginTitle {

    private final LoginPage loginPage;
    private final DashBoardPage dashBoardPage;
    private final Logger logger;

    public LoginTitle() {
        WebDriver driver = StepHooks.driver;
        loginPage = new LoginPage(driver);
        dashBoardPage = new DashBoardPage(driver);
        logger = Logger.getLogger("Sign In Title");
    }

    @Then("User see {string} title on the page")
    @Severity(SeverityLevel.BLOCKER)
    public void user_see_title_on_the_page(String title) {
        logger.info("Check whether 'Sign In' title exists");
        assertEquals(title , loginPage.getHeadingOfLoginPage());
    }

}
