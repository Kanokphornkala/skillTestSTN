package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui_utils.Driver;
import ui_utils.Selenium_utils;

import java.util.ArrayList;
import java.util.List;

public class ResultsPage {
    public ResultsPage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(xpath = "//section[@class='mis-bg-wrapper']")
    public WebElement loadingMask;

    @FindBy(xpath = "//button[@data-opt-group='Distance from Downtown']")
    public WebElement distanceSorting;

    ////button[@data-opt-group='Distance from Downtown']    //span[text()='Distance from Downtown']
    @FindBy(xpath = "//li[@class='distance secondary tabAccess']")
    public List<WebElement> listOfDistances;

    @FindBy(xpath = "//li[@class='hotelTitle']/h4")
    public List<WebElement> listOfHotels;

    //Method to read the distances, trim and convert to miles
    //will return list of distances in miles

    public List<String> getListHotelsInNumberOfMiles(double miles){
        //create a list of Strings containing distances in km
        List<String> tempList = Selenium_utils.getElementsText(listOfDistances);
        //creating list to store hotel names
        List<String> hotelNames = new ArrayList<>();
        //looping through list
        for(int i = 0; i < tempList.size(); i++){
            //trim each item in list to get rid of empty spaces
            tempList.get(i).trim();
            //getting rid of characters and leaving only numeric value in temp variable
            double km = Double.valueOf( tempList.get(i).substring(0, tempList.get(i).indexOf("km")-1));
            //see if this value if <= given number, in our case is 2
            if(km/1.6 <= miles){
                //adding name of hotel, as well as distance in miles
                hotelNames.add(listOfHotels.get(i).getText() + " --> " + String.format("%.2f", km/1.6) + " miles");
            }
        }
        return hotelNames;
    }

}
