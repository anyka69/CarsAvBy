package steps;

import io.qameta.allure.Step;
import models.User;
import org.openqa.selenium.WebDriver;
import pages.ChangeProfilePage;

public class SingInSteps {
    ChangeProfilePage changeProfilePage;

    public SingInSteps(WebDriver driver) {
        changeProfilePage = new ChangeProfilePage(driver);
    }

    @Step("Sing In")
    public SingInSteps singIn() {
        User user = new User("audi@mailinator.com", "qwerty123");
        changeProfilePage.
                singIn(user);
        return this;
    }

}
