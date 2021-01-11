package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import pages.HomePage;
import pages.VacationPackagesPage;
import ui_utils.Driver;
import ui_utils.Selenium_utils;

public class VacationPackageStepDefs {
    VacationPackagesPage vacationPackagesPage = new VacationPackagesPage();

    @When("user clicks on {string} button")
    public void userClicksOnButton(String button) {
        switch (button.toLowerCase()){
            case "flighthotel":
                vacationPackagesPage.flightHotelBtn.click();
                break;
            case "search":
                vacationPackagesPage.searchButton.click();
                break;
            default:
                System.out.println("Invalid button name");
        }
    }

   
   
    @And("user enter {string} origin city")
    public void userEnterOriginCity(String origin) {
        vacationPackagesPage.originCityInput.sendKeys(origin);
        vacationPackagesPage.getCityFromDropDown(origin).click();
    }

    @And("user enter {string} departing city")
    public void userEnterDepartingCity(String destination) {
        vacationPackagesPage.destinationCityInput.sendKeys(destination);
        vacationPackagesPage.getCityFromDropDown(destination).click();
    }

    @And("user enter {string} date and {string} date")
    public void userEnterDateAndDate(String departure, String returning) {
        vacationPackagesPage.departingDateInput.sendKeys(departure + Keys.TAB + Keys.ENTER);
//        vacationPackagesPage.returnDateInput.click();
//
//
//        int len = vacationPackagesPage.returnDateInput.getText().length();
//
//        JavascriptExecutor js = (JavascriptExecutor)Driver.get();
//        js.executeScript("arguments[0].setAttribute(value,'"+returning+"')",vacationPackagesPage.returnDateInput);
//        Selenium_utils.sleep(3000);


//        vacationPackagesPage.returnDateInput.clear();
//        vacationPackagesPage.returnDateInput.sendKeys(returning);

    }


    @And("user enter number of {string} and number of {string}")
    public void userEnterNumberOfAndNumberOf(String arg0, String arg1) {

    }


    @And("user select Airline {string}")
    public void userSelectAirline(String airClass) {
        vacationPackagesPage.getAirlineClassFromDropdown(airClass);
    }
}
