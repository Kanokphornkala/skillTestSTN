package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui_utils.Driver;

import java.util.ArrayList;
import java.util.List;

public class HomePage {
    public HomePage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//ul[@class='secondary-section']/li/a")
    public List<WebElement> bannerElements;

    //   //li//a[@class='_1cSeJ9']

    /**
     * Reusable method for Home Page to retrieve the text from banner web elements
     * @param
     * @return
     */
    public List<String> getTextBannerItems(){
        List<String> listBanner = new ArrayList<>();
        for(int i = 0; i < bannerElements.size(); i++){
            listBanner.add(bannerElements.get(i).getText());
        }
        return listBanner;
    }
}
