package pages;

import manager.dto.StudentDTO;
import manager.enums.Gender;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class AutomationPracticeForm extends BasePages{
    //Инициализация элемента: Чтобы переменная fieldFirstName стала "связана" с реальным элементом
    // на странице, используется механизм инициализации, обычно с помощью PageFactory
    public AutomationPracticeForm(WebDriver driver){
        setDriver(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,10),this);
    }
    //элемент fieldFirstName уже инициализирован - найден на странице
    // и "связан" с соответствующим элементом в DOM
    //элемент веб-страницы объявляется как переменная
    //fieldFirstName — это переменная, которая будет представлять элемент ввода для имени студента
    @FindBy (id = "firstName")
    WebElement fieldFirstName;

    @FindBy(id = "lastName")
    WebElement fieldLastName;

    @FindBy(xpath = "//*[@placeholder='name@example.com']")
    WebElement fieldEmail;

    //метод, который принимает объект типа StudentDTO и заполняет форму для студента
    public AutomationPracticeForm fillStudentsForm(StudentDTO student) {
        fieldFirstName.sendKeys(student.getName()); //вводит имя студента в поле для имени
        fieldLastName.sendKeys(student.getLastName());
        fieldEmail.sendKeys(student.getEmail());
        clickGender(student.getGender());




        return this;
    }

    private void clickGender(Gender gender) {
        WebElement elementGender = driver.findElement(By.xpath(gender.getLocator()));
        elementGender.click();
    }

}
