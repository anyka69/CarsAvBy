package tests;

import org.testng.annotations.Test;

public class SearchCarTest extends BaseTests {
    @Test
    public void SearchCarPorsche() {
        loginPage.
                openPage();
        searchCarSteps.
                searchCarPorsche();
    }
    @Test
    public void SearchCarZhiguli() {
        loginPage.
                openPage();
        searchCarSteps.
                searchCarMoskvich();
    }

}

