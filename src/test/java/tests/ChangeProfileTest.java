package tests;

import org.testng.annotations.Test;

public class ChangeProfileTest extends BaseTests {
    @Test
    public void profileChange() {
        loginPage.
                openPage();
            changeProfilePage.
                    singIn("audi@mailinator.com", "qwerty123")
                    .profileChange("Михаил")
                    .logOut();
    }
}
