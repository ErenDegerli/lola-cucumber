package com.lolafloraCucumber.pages;

import com.lolafloraCucumber.core.Base;
import com.lolafloraCucumber.core.PropKey;
import com.lolafloraCucumber.core.PropertyReader;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.io.IOException;

public class LoginPage extends Base {

    @FindBy(className = "login__heading")
    private WebElement heading;

    @FindBy(id = "EmailLogin")
    private WebElement emailInputField;

    @FindBy(id = "Password")
    private WebElement passwordInputField;

    @FindBy(css = "#userLogin > div:nth-child(6) > button")
    private WebElement signInButton;

    @FindBy(id = "EmailLogin-error")
    private WebElement emailValidationMessage;

    @FindBy(id = "Password-error")
    private WebElement passwordValidationMessage;

    @FindBy(className = "modal-body")
    private WebElement popupMessage;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public String getEmailValidationMessage() {
        return waitUntilVisible(emailValidationMessage).getText();
    }

    public String getPasswordValidationMessage() {
        return waitUntilVisible(passwordValidationMessage).getText();
    }

    public String getPopupMessage() {
        return waitUntilVisible(popupMessage).getText();
    }

    public void navigateToLoginPage() throws IOException {
        driver.get(PropertyReader.getInstance().getProperty(PropKey.URL.getPropVal()));
    }

    public String getHeadingOfLoginPage() {
        return waitUntilVisible(heading).getText();
    }

    public void doLogin(String email, String password){
        waitUntilClickable(emailInputField).sendKeys(email);
        passwordInputField.sendKeys(password);
        signInButton.click();
    }
}