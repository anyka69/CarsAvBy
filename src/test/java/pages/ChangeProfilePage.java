package pages;

import io.qameta.allure.Step;
import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import untils.AllureUtils;

public class ChangeProfilePage extends BasePage {
    By LOG_TO_PROFILE = By.xpath("//*[contains (text(),'Войти')]");
    By LOGIN = By.id("login");
    By PASSWORD = By.id("password");
    By LOGIN_TO_ACCOUNT = By.xpath("//*[@class='button button--action']//*[@class='button__text']");
    By DROPDOWN = By.xpath("//*[@class='nav__item nav__item--dropdown nav__item--user']//*[@class='nav__link']");
    By SETTING = By.xpath("//*[contains (text(),'Настройки')]");
    By NAME = By.id("name");
    By SAVE_CHANGES = By.xpath("//*[contains (text(),'Сохранить изменения')]");
    By LOG_OUT = By.xpath("//*[contains (text(),'Выйти')]");

    public ChangeProfilePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public LoginPage openPage() {
        return null;
    }

    @Override
    public LoginPage isPageOpened() {
        return null;
    }

    @Step("Sing In")
    public ChangeProfilePage singIn(User user) {
        driver.findElement(LOG_TO_PROFILE).click();
        driver.findElement(LOGIN).sendKeys(user.getLogin());
        driver.findElement(PASSWORD).sendKeys(user.getPassword());
        AllureUtils.takeScreenshot(driver);
        driver.findElement(LOGIN_TO_ACCOUNT).click();
        return this;
    }

    @Step("Change Profile")
    public ChangeProfilePage profileChange(String name) {
        Actions actions = new Actions(driver);
        WebElement menu = driver.findElement(DROPDOWN);
        actions.moveToElement(menu).perform();
        WebElement element = driver.findElement(SETTING);
        element.click();
        AllureUtils.takeScreenshot(driver);
        Actions navigator = new Actions(driver);
        WebElement firstName = driver.findElement(NAME);
        navigator.click(firstName)
                .sendKeys(Keys.END)
                .keyDown(Keys.SHIFT)
                .sendKeys(Keys.HOME)
                .keyUp(Keys.SHIFT)
                .sendKeys(Keys.BACK_SPACE)
                .sendKeys(name)
                .perform();
        String changedName = driver.findElement(NAME).getAttribute("value");
        Assert.assertEquals(changedName, name, "Names are different");
        driver.findElement(SAVE_CHANGES).click();
        AllureUtils.takeScreenshot(driver);
        return this;
    }

    @Step("Log Out")
    public ChangeProfilePage logOut() {
        Actions log = new Actions(driver);
        WebElement logOut = driver.findElement(LOG_OUT);
        log.click(logOut);
        return this;
    }
}
