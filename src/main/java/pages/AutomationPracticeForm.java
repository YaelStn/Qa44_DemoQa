package pages;

import manager.dto.StudentDTO;
import manager.enums.Gender;
import manager.enums.Hobbies;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.List;

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

    @FindBy(id = "userNumber")
    WebElement fieldMobileNumber;

    @FindBy(id = "dateOfBirthInput")
    WebElement fieldDateOfBirth; //18 Jun 2019

    @FindBy(id = "subjectsInput")
    WebElement fieldSubject;


    @FindBy(id = "currentAddress")
    WebElement fieldCurrentAddress;

    @FindBy(id="react-select-3-input")
    WebElement fieldState;

    @FindBy(id="react-select-4-input")
    WebElement fieldCity;

    @FindBy(xpath = "//button[text()='Submit']")
    WebElement btnSubmit;

    @FindBy(id="example-modal-sizes-title-lg")
    WebElement textThanksFor;


    //метод, который принимает объект типа StudentDTO и заполняет форму для студента
    public AutomationPracticeForm fillStudentsForm(StudentDTO student) {
        hideFooter();//skrivaem footer
        fieldFirstName.sendKeys(student.getName()); //вводит имя студента в поле для имени
        fieldLastName.sendKeys(student.getLastName());
        fieldEmail.sendKeys(student.getEmail());
        clickGender(student.getGender());
        fieldMobileNumber.sendKeys((student.getMobile()));

        //fieldDateOfBirth.clear();
        // fieldDateOfBirth.sendKeys(student.getDateOfBirth());

        typeFieldDateOfBirth(student.getDateOfBirth());
        typeFieldSubjects(student.getSubject());
        typeHobbies(student.getHobbies());
        fieldCurrentAddress.sendKeys(student.getCurrentAddress());

        //zapolnayaem pola state i city

        //===========================================
        // Мы обращаемся к полю "state" с помощью метода sendKeys, симулируя ввод данных.
        // Эти данные передаются из объекта student через геттер getState().
        // Метод getState() возвращает строку, которая затем вводится в поле state
        fieldState.sendKeys(student.getState());
        fieldState.sendKeys(Keys.ENTER);
        fieldCity.sendKeys(student.getCity());
        fieldCity.sendKeys(Keys.ENTER);

        return this;
    }

    public AutomationPracticeForm clickBtnSubmit(){
        btnSubmit.click();
        return this;
    }
      private void typeHobbies(List<Hobbies> hobbies) {
        for (Hobbies h : hobbies) {
            switch (h) {
                case MUSIC:
                    driver.findElement(By.cssSelector(h.getLocator())).click();
                    break;
                case SPORTS:
                    driver.findElement(By.cssSelector(h.getLocator())).click();
                    break;
                case READING:
                    driver.findElement(By.cssSelector(h.getLocator())).click();
                    break;

            }
        }
    }

    private void typeFieldSubjects(String subject) {
        //"Math, Physics, Economics"

        fieldSubject.click();
        String[] splitArray = subject.split(", ");//["Math"]["Physics"]["Economics"]


        for (String str : splitArray) {
            fieldSubject.sendKeys(str);
            fieldSubject.sendKeys(Keys.ENTER);
        }

    }

    private void typeFieldDateOfBirth(String dateOfBirth) {
        //class kotoriy znaet kakaya operz sistema u polzovatela
        String operationSystem = System.getProperty("os.name");

        fieldDateOfBirth.click(); //nashli pole i click

        //videlaem pole s help gorachix klavish
        if (operationSystem.startsWith("Win"))
            fieldDateOfBirth.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        else if (operationSystem.startsWith("Mac"))
            fieldDateOfBirth.sendKeys(Keys.chord(Keys.COMMAND, "a"));

        fieldDateOfBirth.sendKeys(dateOfBirth);
        fieldDateOfBirth.sendKeys(Keys.ENTER);

    }

    private void clickGender(Gender gender) {
        WebElement elementGender = driver.findElement(By.xpath(gender.getLocator()));
        elementGender.click();
    }

    public boolean isTextToBePresent_textThanksFor(){
        return isTextToBePresent(textThanksFor,"Thanks for submitting the form",5);
    }

}
