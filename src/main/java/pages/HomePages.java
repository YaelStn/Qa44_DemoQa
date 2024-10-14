package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class HomePages extends BasePages {
    public HomePages(WebDriver driver){
        setDriver(driver);
        driver.get("https://demoqa.com/");
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,10),this);

    }

    @FindBy(xpath = "//div[@class='category-cards']/div[2]")
    WebElement btnForm;

    //WebElement btnForm1 = driver.findElement(By.xpath("//div[@class='category-cards']/div[2]"));


    public FormsPage clickBtnForms() {
        // hideFooter();
        btnForm.click();
        return new FormsPage(driver);
    }
}
