package tests;

import org.testng.annotations.Test;

public class LoginTest extends BaseTests {
    @Test
    public void createAccount() throws InterruptedException {
        loginPage
                .openPage()
                .createAccount("Иван", "audi@mailinator.com", "qwerty123");
    }
}
