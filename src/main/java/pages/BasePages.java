package pages;

public class BasePages {

    //protected в Java означает, что переменная или метод доступны:
    //Внутри того же класса.
    //Внутри всех классов в одном пакете.
    //Внутри классов-наследников, даже если они находятся в других пакетах.
    protected static WebDriver driver;

    public static void setDriver(WebDriver wd) {
        driver = wd;
    }
}
