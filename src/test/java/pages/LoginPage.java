package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;


public class LoginPage extends BasePage {

    String url = "https://av.by/";

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public LoginPage openPage() {
        driver.get(url);
        isPageOpened();
        return this;
    }

    @Override
    public LoginPage isPageOpened() {
        return this;
    }

    @Step("Create Account")
    public LoginPage createAccount(String name, String email, String password) {
        driver.findElement(By.xpath("//*[contains (text(),'Войти')]")).click();
        driver.findElement(By.xpath("//*[contains (text(),'Регистрация')]")).click();
        driver.findElement(By.id("name")).sendKeys(name);
        String nameField = driver.findElement(By.id("name")).getAttribute("value");
        Assert.assertEquals(nameField, name, "Error!Enter a name in Cyrillic");
        driver.findElement(By.id("email")).sendKeys(email);
        String emailField = driver.findElement(By.id("email")).getAttribute("value");
        Assert.assertEquals(emailField, email, "Repeat the empty");
        driver.findElement(By.id("password")).sendKeys(password);
        String passwordField = driver.findElement(By.id("password")).getAttribute("value");
        Assert.assertEquals(passwordField, password, "The password must contains numbers and latin letters");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains (text(),'Зарегистрироваться')]")));
        driver.findElement(By.xpath("//*[contains (text(),'Зарегистрироваться')]")).click();
        return this;
    }
}
