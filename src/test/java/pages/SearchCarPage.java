package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import untils.AllureUtils;

import static org.testng.AssertJUnit.assertEquals;

public class SearchCarPage extends BasePage {
    By SUBMIT_PRE_SEARCH = By.id("submit_presearch");
    public SearchCarPage(WebDriver driver) {
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

    @Step("Search Cars")
    public SearchCarPage searchCar(String markaCar, String modelCar, String yearFrom, String yearTo,
                                   String priceValueMinPre, String priceValueMaxPre) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("brand_id[]")));
        Select marka = new Select(driver.findElement(By.name("brand_id[]")));
        marka.selectByVisibleText(markaCar);
        Select model = new Select(driver.findElement(By.id("model_id")));
        model.selectByVisibleText(modelCar);
        driver.findElement(By.xpath("//*[contains(text(), '\n" +
                "                                Год выпуска\n" +
                "                            ')]")).click();
        Select from = new Select(driver.findElement(By.name("year_from")));
        from.selectByVisibleText(yearFrom);
        Select to = new Select(driver.findElement(By.name("year_to")));
        to.selectByVisibleText(yearTo);
        driver.findElement(By.xpath("//*[contains(text(), '\n" +
                "                                Цена\n" +
                "                            ')]")).click();
        Select priceMinPre = new Select(driver.findElement(By.id("price_value_pre")));
        priceMinPre.selectByVisibleText(priceValueMinPre);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("price_value_max_pre")));
        Select priceMaxPre = new Select(driver.findElement(By.id("price_value_max_pre")));
        priceMaxPre.selectByVisibleText(priceValueMaxPre);
        driver.findElement(By.xpath("//*[contains(text(),'BYN')]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".js-tabsfilter-hint")));
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String search = driver.findElement(By.cssSelector(".js-tabsfilter-hint")).getText();
        AllureUtils.takeScreenshot(driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(SUBMIT_PRE_SEARCH));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(SUBMIT_PRE_SEARCH).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".heading-title")));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String searchCar = driver.findElement(By.cssSelector(".heading-title")).getText();
        AllureUtils.takeScreenshot(driver);
        assertEquals("Error", search, searchCar);
        return this;
    }
}
