package step_definitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
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
        //Verifying actual page title with expected title
        Assert.assertEquals(Driver.get().getTitle(), pageTitile);
    }

    @And("verify top page banner has following links")
    public void verifyTopPageBannerHasFollowingLinks(DataTable table) {
        //Putting data table in a list
        List <String> list = table.asList();
        //Using utils method to get text from WebElements list and verifying if that list contains expected items
       Assert.assertTrue(Selenium_utils.getElementsText(homePage.bannerElements).containsAll(list));
    }


    @And("user clicks on {string} on banner menu")
    public void userClicksOnOnBannerMenu(String button) {
        //If button doesn't present in banner, we will throw new exception with message
        if(!Selenium_utils.getElementsText(homePage.bannerElements).contains(button)){
            throw new RuntimeException("Button is not found on the banner");
        }

        //Looping through the list of banner items
        for (int i = 0; i < homePage.bannerElements.size(); i++){
            //if find the desired item on the banner, clicking on it
            if(Selenium_utils.getElementsText(homePage.bannerElements).get(i).equalsIgnoreCase(button)){
                homePage.bannerElements.get(i).click();
            }
        }
        Selenium_utils.switchToWindow(Driver.get().getWindowHandle());
    }
}
