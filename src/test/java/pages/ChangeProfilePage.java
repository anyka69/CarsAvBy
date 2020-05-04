package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class ChangeProfilePage extends BasePage {
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

    public ChangeProfilePage singIn(String login, String email) {
        driver.findElement(By.xpath("//*[contains (text(),'Войти')]")).click();
        driver.findElement(By.id("login")).sendKeys(login);
        driver.findElement(By.id("password")).sendKeys(email);
        driver.findElement(By.xpath("//*[@class='button button--action']//*[@class='button__text']")).click();
        return this;
    }

    public ChangeProfilePage profileChange(String name) {
        Actions actions = new Actions(driver);
        //Локаторы
        WebElement menu = driver.findElement(By.xpath("/html/body/div[4]/div[1]/header/div/nav/ul[2]/li[3]/button"));
        actions.moveToElement(menu).perform();
        WebElement element = driver.findElement(By.xpath("//*[contains (text(),'Настройки')]"));
        element.click();
        Actions navigator = new Actions(driver);
        WebElement firstName = driver.findElement(By.id("name"));
        navigator.click(firstName)
                .sendKeys(Keys.END)
                .keyDown(Keys.SHIFT)
                .sendKeys(Keys.HOME)
                .keyUp(Keys.SHIFT)
                .sendKeys(Keys.BACK_SPACE)
                .sendKeys(name)
                .perform();
        String changedName = driver.findElement(By.id("name")).getAttribute("value");
        Assert.assertEquals(changedName, name, "Names are different");
        driver.findElement(By.xpath("//*[contains (text(),'Сохранить изменения')]")).click();
        return this;
    }

    public ChangeProfilePage logOut() {
        Actions log = new Actions(driver);
        WebElement logOut = driver.findElement(By.xpath("//*[contains (text(),'Выйти')]"));
        log.click(logOut);
        return this;
    }

}
