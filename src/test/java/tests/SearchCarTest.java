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
    public void SearchCarZhiguli() throws InterruptedException {
        loginPage.
                openPage();
        searchCarSteps.
                searchCarMoskvich();
    }

    @Test
    public void SearchCarAudi() throws InterruptedException {
        loginPage.
                openPage();
        searchCarSteps.
                searchCarAudi();
    }
}

