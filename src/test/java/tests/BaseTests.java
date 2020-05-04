package tests;

import models.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.ChangeProfilePage;
import pages.LoginPage;
import pages.SearchCarPage;
import steps.SearchCarSteps;
import untils.CapabilitiesGenerator;

import java.util.concurrent.TimeUnit;

public class BaseTests {
    LoginPage loginPage;
    private WebDriver driver;
    SearchCarPage searchCarPage;
    SearchCarSteps searchCarSteps;
    ChangeProfilePage changeProfilePage;
    User user;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver(CapabilitiesGenerator.getChromeOptions());
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        searchCarPage = new SearchCarPage(driver);
        searchCarSteps = new SearchCarSteps(driver);
        changeProfilePage = new ChangeProfilePage(driver);
        user = new User("audi@mailinator.com", "qwerty123");

    }

    @AfterMethod(alwaysRun = true)
    public void closeDriver() {
        driver.quit();
    }
}
