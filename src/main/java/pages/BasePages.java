package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePages {

    //protected в Java означает, что переменная или метод доступны:
    //Внутри того же класса.
    //Внутри всех классов в одном пакете.
    //Внутри классов-наследников, даже если они находятся в других пакетах.
    protected static WebDriver driver;

    public static void setDriver(WebDriver wd) {
        driver = wd;
    }

    //метод hideFooter() скрывает элемент футера на веб-странице с помощью JavaScript
    public void hideFooter(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector('footer').style.display = 'none'");
    }

    //метод, который проверяет, присутствует ли определённый текст
    // в указанном веб-элементе в течение заданного времени
    public boolean isTextToBePresent(WebElement element,String text,int time){
        return new WebDriverWait(driver, Duration.ofSeconds(time)).until(ExpectedConditions.
                textToBePresentInElement(element,text));
    }


}