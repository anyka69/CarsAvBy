package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.ChangeProfilePage;
import pages.LoginPage;
import pages.SearchCarPage;
import steps.SearchCarSteps;
import steps.SingInSteps;
import untils.CapabilitiesGenerator;
import untils.TestListener;

import java.util.concurrent.TimeUnit;

@Listeners(TestListener.class)
public class BaseTests {
    LoginPage loginPage;
    private WebDriver driver;
    SearchCarPage searchCarPage;
    SearchCarSteps searchCarSteps;
    ChangeProfilePage changeProfilePage;
    SingInSteps singInSteps;

    @BeforeMethod
    public void setUp(ITestContext context) {
        driver = new ChromeDriver(CapabilitiesGenerator.getChromeOptions());
        context.setAttribute("driver", driver);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        searchCarPage = new SearchCarPage(driver);
        searchCarSteps = new SearchCarSteps(driver);
        changeProfilePage = new ChangeProfilePage(driver);
        singInSteps = new SingInSteps(driver);

    }

    @AfterMethod(alwaysRun = true)
    public void closeDriver() {
        driver.quit();
    }
}
