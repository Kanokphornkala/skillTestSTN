package step_definitions;

import io.cucumber.java.en.Then;
import pages.ResultsPage;

public class ResultsStepDefs {

    ResultsPage resultsPage = new ResultsPage();

    @Then("print list of hotels located withing {int} miles")
    public void printListOfHotelsLocatedWithingMiles(int miles) {
        System.out.println("LIST OF HOTELS WITHIN " + miles +" MILES:");
        for(int i = 0; i < resultsPage.getListHotelsInNumberOfMiles(miles).size(); i++){
            System.out.println(resultsPage.getListHotelsInNumberOfMiles(miles).get(i));
        }
    }
}
