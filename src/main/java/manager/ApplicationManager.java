package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.ArrayList;
import java.util.List;

public class ApplicationManager {
    private WebDriver driver;
    //Инициализирует объект настроек Chrome chromeOptions,
    //который используется для конфигурирования параметров запуска браузера Chrome.
    private ChromeOptions chromeOptions = new ChromeOptions();

    //возвращает текущий объект WebDriver, который управляет браузером в тестах.
    // Метод обычно используется для получения доступа к драйверу браузера из других классов.
    public WebDriver getDriver() {
        return driver;
    }

    @BeforeMethod
    public void setUp(){
        //Добавляет расширение Chrome, расположенное по пути C://Tools/5.10.1_0.
        chromeOptions.addArguments("load-extension=C://Tools/5.10.1_0");
        //inizializaziya drivera, mi govorim chto on rabotaet v chromedriver
        driver = new ChromeDriver(chromeOptions);
        //открыть окно на весь экран, т.е. максимально увеличить его размер
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/");


        //метод в Java, который приостанавливает выполнение текущего потока
        // на указанное количество миллисекунд.
        //Метод требует обработки исключения InterruptedException,
        // поэтому его обычно вызывают внутри блока try-catch.
        try {
            Thread.sleep(5000);// Приостанавливает выполнение программы на 5 секунд
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //это метод в Selenium WebDriver, который возвращает множество (Set)
        // идентификаторов всех окон, открытых в текущем сеансе браузера.
        List<String>tabs = new ArrayList<>(driver.getWindowHandles());
        for (String s:tabs) {
            System.out.println("tab-->"+s);
        }

        //можно переключаться между окнами с помощью метода switchTo().window(windowHandle).
        //ukazivaem kakuyu stranizu zakrit a na kakoi rabotaem
        driver.switchTo().window(tabs.get(1)).close();
        driver.switchTo().window(tabs.get(0));



    }

    @AfterMethod
    public void tearDown() {
//        if(driver!=null)
//            driver.quit();

    }
}

