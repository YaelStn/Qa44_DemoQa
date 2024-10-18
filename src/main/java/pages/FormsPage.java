package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class FormsPage extends BasePages{
    public FormsPage(WebDriver driver){
        setDriver(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,10),this);
    }
    //nasli element  с точным текстом "Practice Form".
    @FindBy(xpath = "//*[text()='Practice Form']")
    WebElement btnPracticeForm; //переменная, которая будет представлять найденный элемент.

    public AutomationPracticeForm clickBtnPracticeForm(){
        btnPracticeForm.click();
        return new AutomationPracticeForm(driver);
    }

}
