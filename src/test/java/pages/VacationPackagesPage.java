package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import ui_utils.Driver;

import java.util.List;

public class VacationPackagesPage {
    public VacationPackagesPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//span[contains(text(),'                  Flight + Hotel')]")
    public WebElement flightHotelBtn;

    @FindBy(xpath = "//input[@id='package-origin-hp-package']")
    public WebElement originCityInput;

    @FindBy(xpath = "//input[@id='package-destination-hp-package']")
    public WebElement destinationCityInput;

    @FindBy(xpath = "//input[@id='package-departing-hp-package']")
    public WebElement departingDateInput;

    @FindBy(xpath = "//input[@id='package-returning-hp-package']")
    public WebElement returnDateInput;

    @FindBy(xpath = "//button[@class='trigger-utility menu-trigger btn-utility btn-secondary dropdown-toggle theme-standard pin-left menu-arrow gcw-component gcw-traveler-amount-select gcw-component-initialized']")
    public WebElement numberOfTravelers;

    @FindBy(xpath = "//select[@id='package-advanced-preferred-class-hp-package']")
    public WebElement airlineClass;

    @FindBy(xpath = "//button[@id='search-button-hp-package']")
    public WebElement searchButton;

    public WebElement getCityFromDropDown(String text){
        List<WebElement> list = Driver.get().findElements(By.xpath("//ul[@id='typeaheadDataPlain']//li/a"));
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getText().toLowerCase().contains(text.toLowerCase())){
                return list.get(i);
            }
        }
        return null;
    }

    public void getAirlineClassFromDropdown(String airClass){
        Select select = new Select(airlineClass);
        switch (airClass.toLowerCase()){
            case "economy":
                select.selectByVisibleText("Economy/Coach");
                break;
            case "first class":
                select.selectByVisibleText("First Class");
                break;
            case "business":
                select.selectByVisibleText("Business");
                break;
            case "premium economy":
                select.selectByVisibleText("Premium Economy");
                break;
            default:
                throw new RuntimeException("Airline class is not found");
        }
    }



}
