package step_definitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.HomePage;
import ui_utils.Driver;
import ui_utils.Selenium_utils;

import java.util.List;

public class HomePageStepDefs {

    HomePage homePage = new HomePage();

    @Given("user is on homepage")
    public void userIsOnHomepage() {
    }

    @Then("verify page is title is {string}")
    public void verifyPageIsTitleIs(String pageTitile) {
        Assert.assertEquals(Driver.get().getTitle(), pageTitile);
    }

    @And("verify top page banner has following links")
    public void verifyTopPageBannerHasFollowingLinks(DataTable table) {
        List <String> list = table.asList();
       Assert.assertTrue(Selenium_utils.getElementsText(homePage.bannerElements).containsAll(list));
    }

}
