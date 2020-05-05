package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.SearchCarPage;

public class SearchCarSteps {
    SearchCarPage searchCarPage;

    public SearchCarSteps(WebDriver driver) {
        searchCarPage = new SearchCarPage(driver);
    }

    @Step("Search Car Porsche")
    public SearchCarSteps searchCarPorsche() {
        searchCarPage.
                searchCar("Porsche", "911", "с", "по", "от",
                        "до");
        return this;
    }

    @Step("Search Car Moskvich")
    public SearchCarSteps searchCarMoskvich() {
        searchCarPage.
                searchCar("Москвич", "2138", "2018", "по", "от",
                        "до");
        return this;
    }

    @Step("Search Car Audi")
    public SearchCarSteps searchCarAudi() {
        searchCarPage.
                searchCar("Audi", "A8", "2012", "2020", "от",
                        "95000");
        return this;
    }
}
