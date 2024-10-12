package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class HomePages extends BasePages {
    public HomePage(WebDriver driver){
        setDriver(driver);
        driver.get("https://demoqa.com/");
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,10),this);

    }
}
