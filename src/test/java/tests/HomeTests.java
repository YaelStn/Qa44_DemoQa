package tests;

import manager.ApplicationManager;
import org.testng.annotations.Test;
import pages.HomePages;

public class HomeTests extends ApplicationManager {

        @Test
        public void test() {
            HomePages homePage = new HomePages(getDriver());
            homePage.clickBtnForms();
                    //.clickBtnPracticeForm();
        }

    }

