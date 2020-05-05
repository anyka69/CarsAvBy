package tests;

import org.testng.annotations.Test;

public class ChangeProfileTest extends BaseTests {
    @Test
    public void profileChange() throws InterruptedException {
        loginPage.
                openPage();
        singInSteps.
                singIn();
        changeProfilePage
                .profileChange("Михаил")
                .logOut();
    }
}
