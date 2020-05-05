package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import untils.AllureUtils;


public class LoginPage extends BasePage {
    By LOG_TO_PROFILE = By.xpath("//*[contains (text(),'Войти')]");
    By REGISTRATION = By.xpath("//*[contains (text(),'Регистрация')]");
    By NAME = By.id("name");
    By EMAIL = By.id("email");
    By PASSWORD = By.id("password");
    By TO_REGISTER = By.xpath("//*[contains (text(),'Зарегистрироваться')]");
    String url = "https://av.by/";

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Opening Page")
    @Override
    public LoginPage openPage() {
        driver.get(url);
        AllureUtils.takeScreenshot(driver);
        isPageOpened();
        return this;
    }
    @Override
    public LoginPage isPageOpened() {
        return this;
    }
    @Step("Create Account")
    public LoginPage createAccount(String name, String email, String password) {
        driver.findElement(LOG_TO_PROFILE).click();
        driver.findElement(REGISTRATION).click();
        driver.findElement(NAME).sendKeys(name);
        String nameField = driver.findElement(NAME).getAttribute("value");
        Assert.assertEquals(nameField, name, "Error!Enter a name in Cyrillic");
        driver.findElement(EMAIL).sendKeys(email);
        String emailField = driver.findElement(EMAIL).getAttribute("value");
        Assert.assertEquals(emailField, email, "Repeat the empty");
        driver.findElement(PASSWORD).sendKeys(password);
        String passwordField = driver.findElement(PASSWORD).getAttribute("value");
        Assert.assertEquals(passwordField, password, "The password must contains numbers and latin letters");
        AllureUtils.takeScreenshot(driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains (text(),'Зарегистрироваться')]")));
        driver.findElement(TO_REGISTER).click();
        return this;
    }
}
