package tests;

import org.testng.annotations.Test;

public class SearchCarTest extends BaseTests {
    @Test
    public void SearchCarPorsche() throws InterruptedException {
        loginPage.
                openPage();
        searchCarSteps.
                searchCarPorsche();
    }

    @Test
    public void SearchCarBMW() throws InterruptedException {
        loginPage.
                openPage();
        searchCarSteps.
                searchCarBMW();
    }

    @Test
    public void SearchCarMoskvich() throws InterruptedException {
        loginPage.
                openPage();
        searchCarSteps.
                searchCarMoskvich();
    }
}

