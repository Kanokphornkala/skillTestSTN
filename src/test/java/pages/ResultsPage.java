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

    public List<String> getListHotelsInNumberOfMiles(double miles){
        List<String> tempList = Selenium_utils.getElementsText(listOfDistances);
        List<String> hotelNames = new ArrayList<>();
        for(int i = 0; i < tempList.size(); i++){
            tempList.get(i).trim();
            double km = Double.valueOf( tempList.get(i).substring(0, tempList.get(i).indexOf("km")-1));
            if(km/1.6 <= miles){
                hotelNames.add(listOfHotels.get(i).getText() + " --> " + String.format("%.2f", km/1.6) + " miles");
            }
        }
        return hotelNames;
    }
}
